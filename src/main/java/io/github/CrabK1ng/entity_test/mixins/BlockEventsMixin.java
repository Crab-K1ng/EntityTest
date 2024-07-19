package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.blockevents.BlockEvents;
import finalforeach.cosmicreach.blocks.Block;
import io.github.CrabK1ng.entity_test.blockevents.SpawnMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static finalforeach.cosmicreach.blockevents.BlockEvents.registerBlockEventAction;
import static io.github.CrabK1ng.entity_test.EntityTest.LOGGER;

@Mixin(BlockEvents.class)
public class BlockEventsMixin {
    @Inject(method = "initBlockEvents", at = @At("HEAD"))
    private static void registerBlockEvent(CallbackInfo info){
        registerBlockEventAction(SpawnMob.class);
        //BlockEvents.getInstance("block_events_spawn");
        LOGGER.info("entity_spawn class register");
    }
}
