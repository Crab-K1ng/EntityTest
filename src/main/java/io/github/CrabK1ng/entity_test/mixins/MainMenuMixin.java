package io.github.CrabK1ng.entity_test.mixins;

import io.github.CrabK1ng.entity_test.EntityTest;
import finalforeach.cosmicreach.gamestates.MainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MainMenu.class)
public class MainMenuMixin {
    @Inject(method = "create", at = @At("HEAD"))
    private void injected(CallbackInfo ci) {
        EntityTest.LOGGER.info("Example mixin logged!");
    }
}
