package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.entities.EntityCreator;
import io.github.CrabK1ng.entity_test.TestEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static finalforeach.cosmicreach.entities.EntityCreator.registerEntityCreator;
import static io.github.CrabK1ng.entity_test.EntityTest.LOGGER;

@Mixin(EntityCreator.class)
public class EntityCreatorMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectIntoEntityRegistry(CallbackInfo info) {
        LOGGER.info("EntityRegistry test entity");
        registerEntityCreator("test_entity:test_entity", TestEntity::new);

    }
}
