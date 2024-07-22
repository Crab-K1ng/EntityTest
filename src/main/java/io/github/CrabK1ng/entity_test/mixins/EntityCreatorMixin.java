package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.entities.EntityCreator;
import io.github.CrabK1ng.entity_test.EntityTest;
import io.github.CrabK1ng.entity_test.entities.TestEntity;
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
        LOGGER.info("EntityRegistry");
        for (String mobName : EntityTest.MOB_NAMES) {
            LOGGER.info("mob:" + mobName);
        }
        registerEntityCreator(EntityTest.MOD_ID+":test_entity", TestEntity::new);
    }
}
