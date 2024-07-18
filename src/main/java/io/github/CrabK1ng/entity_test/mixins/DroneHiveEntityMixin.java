package io.github.CrabK1ng.entity_test.mixins;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.DroneHiveEntity;
import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityCreator;
import finalforeach.cosmicreach.world.Zone;
import io.github.CrabK1ng.entity_test.EntityTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(DroneHiveEntity.class)
public class DroneHiveEntityMixin {

    @Shadow private float timeSinceActivated;

    @Inject(method = "update", at = @At("TAIL"))
    public void spawner(Zone zone, double deltaTime, CallbackInfo info) {
        EntityTest.LOGGER.info(String.valueOf(timeSinceActivated));
        if ((double)this.timeSinceActivated > 0.5) {
            for(int i = 0; i < MathUtils.random(1, 3); ++i) {
                EntityTest.LOGGER.info("spawn now");
                String mobToSpawnId = "test_entity:test_entity";
                Entity mob = EntityCreator.get(mobToSpawnId);
                mob.setPosition(this.position);
                mob.accelerate(0.0F, 500.0F, 0.0F);
                zone.allEntities.add(mob);
            }
        }
    }
}
