package io.github.CrabK1ng.entity_test;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import de.pottgames.tuningfork.SoundBuffer;
import finalforeach.cosmicreach.GameAssetLoader;
import finalforeach.cosmicreach.GameSingletons;
import finalforeach.cosmicreach.Threads;
import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityUtils;
import finalforeach.cosmicreach.items.loot.Loot;
import finalforeach.cosmicreach.savelib.crbin.CRBSerialized;
import finalforeach.cosmicreach.world.Zone;

public class TestEntity extends Entity {
   public static final String ENTITY_TYPE_ID = "test_entity:test_entity";
   public static final String LOOT_ID = "base:loot_interceptor";
   static Array<SoundBuffer> cries = new Array<>();
   static Array<SoundBuffer> steps = new Array<>();
   static Array<SoundBuffer> hurts = new Array<>();
   @CRBSerialized
   float cryCountdown;
   @CRBSerialized
   float stepCountdown;
   @CRBSerialized
   float timer;
   Loot loot;
   private Vector3 tmpDesiredLocation = new Vector3();
   @CRBSerialized
   int attackChargeTime = MathUtils.random(20, 60);

   public TestEntity() {
      super("test_entity:test_entity");
      this.canDespawn = true;
      this.loot = Loot.get("base:loot_interceptor");
      Threads.runOnMainThread(
         () -> this.model = GameSingletons.entityModelLoader
               .load(this, "model_entity_test.json", "entity_test.animation.json", "animation.entity-test.idle", "entity_test.png")
      );
   }

   @Override
   public void hit(float amount) {
      super.hit(amount);
      if (amount >= 0.0F) {
         GameSingletons.soundManager.playSound3D(hurts.random(), this.position);
      }
   }

   @Override
   protected void onDeath(Zone zone) {
      this.loot.dropAsItems(zone, this.position);
      super.onDeath(zone);
   }

   @Override
   public void update(Zone zone, double deltaTime) {
      this.viewDirection.set(0.0F, 0.0F, -1.0F);
      super.update(zone, deltaTime);
   }

   static {
      cries.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-cry-1.ogg"));
      cries.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-cry-2.ogg"));
      cries.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-cry-3.ogg"));
      steps.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-step-1.ogg"));
      hurts.add(GameAssetLoader.getSound("sounds/entities/drone_interceptor/drone-hurt-1.ogg"));
   }
}
