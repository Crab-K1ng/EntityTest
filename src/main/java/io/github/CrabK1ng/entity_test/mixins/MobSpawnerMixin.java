package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.MobSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static finalforeach.cosmicreach.MobSpawner.registerMob;
import static finalforeach.cosmicreach.entities.EntityCreator.registerEntityCreator;
import static io.github.CrabK1ng.entity_test.EntityTest.LOGGER;

@Mixin(MobSpawner.class)
public class MobSpawnerMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectIntoEntityRegistry(CallbackInfo info) {
        LOGGER.info("Injecting into mobspawner");
        registerMob("test_entity:test_entity",true);

    }
}
