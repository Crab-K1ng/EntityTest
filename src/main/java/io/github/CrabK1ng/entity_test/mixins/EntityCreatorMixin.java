package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.entities.DroneHiveEntity;
import finalforeach.cosmicreach.entities.EntityCreator;
import io.github.CrabK1ng.entity_test.TestEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static finalforeach.cosmicreach.entities.EntityCreator.registerEntityCreator;

@Mixin(EntityCreator.class)
public class EntityCreatorMixin {
    @Inject(method = "static", at = @At("TAIL"))
    private void injected(CallbackInfo ci) {
        System.out.println("Injecting into EntityRegistry static initializer block");
        registerEntityCreator("crabk1ng:test_entity", TestEntity::new);
    }
}
