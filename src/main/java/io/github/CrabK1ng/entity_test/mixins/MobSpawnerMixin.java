package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.MobSpawner;
import io.github.CrabK1ng.entity_test.EntityTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static finalforeach.cosmicreach.MobSpawner.registerMob;
import static io.github.CrabK1ng.entity_test.EntityTest.LOGGER;

@Mixin(MobSpawner.class)
public class MobSpawnerMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectIntoEntityRegistry(CallbackInfo info) {
        LOGGER.info("Injecting into mobspawner");
        for (String mobName : EntityTest.MOB_NAMES) {
            registerMob(EntityTest.MOD_ID+":"+mobName,true);
        }
    }
}
