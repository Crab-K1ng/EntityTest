package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.entities.DroneHiveEntity;
import io.github.CrabK1ng.entity_test.TestEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static finalforeach.cosmicreach.entities.EntityCreator.registerEntityCreator;

public class EntityCreatorMixin {
    @Inject(method = "static", at = @At("HEAD"))
    private void injected(CallbackInfo ci) {
        registerEntityCreator("crabk1ng:test_entity", TestEntity::new);
    }
}
