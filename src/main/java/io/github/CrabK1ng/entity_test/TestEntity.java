package io.github.CrabK1ng.entity_test;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import de.pottgames.tuningfork.SoundBuffer;
import finalforeach.cosmicreach.GameAssetLoader;
import finalforeach.cosmicreach.GameSingletons;
import finalforeach.cosmicreach.Threads;
import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityCreator;
import finalforeach.cosmicreach.entities.EntityUtils;
import finalforeach.cosmicreach.savelib.crbin.CRBSerialized;
import finalforeach.cosmicreach.world.Zone;

public class TestEntity extends Entity {
    public static final String ENTITY_TYPE_ID = "crabk1ng:test_entity";
    static Array<SoundBuffer> hurts = new Array<>();
    @CRBSerialized
    float cryCountdown;
    @CRBSerialized
    float stepCountdown;
    @CRBSerialized
    float timeSinceActivated = -1.0F;
    boolean released = false;

    public TestEntity(){
        super("crabk1ng:test_entity");
        this.canDespawn = true;
        //this.sightRange = 5.0F;
        this.localBoundingBox.min.set(-0.5F, 0.0F, -0.5F);
        this.localBoundingBox.max.set(0.5F, 0.5F, 0.5F);
        this.localBoundingBox.update();
        Threads.runOnMainThread(
                () -> this.model = GameSingletons.entityModelLoader
                        .load(
                                this,
                                "model_entity_test.json",
                                "entity_test.animation.json",
                                "animation.entity-test.idle",
                                "entity_test.png"
                        )
        );
    }


    protected void onDeath(Zone zone) {
        if (!this.released) {

        }

        super.onDeath(zone);
    }

    private void die(Zone zone) {
        this.hitpoints = 0.0F;
        this.onHitpointChange(zone);
    }


    public void update(Zone zone, double deltaTime) {
        this.viewDirection.set(0.0F, 0.0F, -1.0F);
        Entity closestPlayerEntity = EntityUtils.getClosestPlayerToEntity(this, zone);
        if (closestPlayerEntity != null && this.timeSinceActivated < 0.0F && this.model != null) {
            this.model.setCurrentAnimation(this, "animation.drone-interceptor-trap.open");
            this.timeSinceActivated = 0.0F;
        }
//     look at lis
        if (this.timeSinceActivated >= 0.0F) {
            this.timeSinceActivated = (float)((double)this.timeSinceActivated + deltaTime);
            if ((double)this.timeSinceActivated > 0.5) {
                for(int i = 0; i < MathUtils.random(1, 3); ++i) {
                    String mobToSpawnId = "crabk1ng:test_entity";
                    Entity mob = EntityCreator.get(mobToSpawnId);
                    mob.setPosition(this.position);
                    mob.accelerate(0.0F, 500.0F, 0.0F);
                    zone.allEntities.add(mob);
                }

                this.released = true;
                this.die(zone);
            }
        }

        super.update(zone, deltaTime);
    }

    static {
        hurts.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-hurt-1.ogg"));
    }
}
