package io.github.CrabK1ng.entity_test.mixins;

import finalforeach.cosmicreach.blocks.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.CrabK1ng.entity_test.EntityTest.LOGGER;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "loadAllBlocks", at = @At("TAIL"))
    private static void loadAllBlocks(CallbackInfo info){
        Block.getInstance("block_entity_spawn");
        LOGGER.info("block entity_spawn load");
    }
}
