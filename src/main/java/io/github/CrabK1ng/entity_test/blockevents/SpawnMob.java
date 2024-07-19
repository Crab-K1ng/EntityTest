package io.github.CrabK1ng.entity_test.blockevents;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Queue;
import finalforeach.cosmicreach.blockevents.BlockEventTrigger;
import finalforeach.cosmicreach.blockevents.actions.ActionId;
import finalforeach.cosmicreach.blockevents.actions.IBlockAction;
import finalforeach.cosmicreach.blocks.BlockPosition;
import finalforeach.cosmicreach.blocks.BlockState;
import finalforeach.cosmicreach.world.BlockSetter;
import finalforeach.cosmicreach.world.Zone;

import java.util.HashMap;
import java.util.Map;

@ActionId(
        id = "test_entity:spawn_mob"
)
public class SpawnMob implements IBlockAction {
    String blockStateId;
    int xOff;
    int yOff;
    int zOff;
    float radius;

    @Override
    public void act(BlockState srcBlockState, BlockEventTrigger blockEventTrigger, Zone zone, Map<String, Object> args) {
        this.act(srcBlockState, blockEventTrigger, zone, (BlockPosition)args.get("blockPos"));
    }

    public void act(BlockState srcBlockState, BlockEventTrigger blockEventTrigger, Zone zone, BlockPosition sourcePos) {
        float radiusSq = this.radius * this.radius;
        Queue<BlockPosition> explodeQueue = new Queue<>();

        for(float i = -this.radius; i <= this.radius; ++i) {
            for(float j = -this.radius; j <= this.radius; ++j) {
                for(float k = -this.radius; k <= this.radius; ++k) {
                    float workingRadiusSq = Vector3.len2(i, j, k);
                    if (workingRadiusSq <= radiusSq) {
                        BlockPosition pos = sourcePos.getOffsetBlockPos(zone, (int)((float)this.xOff + i), (int)((float)this.yOff + j), (int)((float)this.zOff + k));
                        if (pos != null) {
                            explodeQueue.addLast(pos);
                        }
                    }
                }
            }
        }

        BlockState blockState;
        if ("self".equals(this.blockStateId)) {
            blockState = srcBlockState;
        } else {
            blockState = BlockState.getInstance(this.blockStateId);
        }

        Map<String, Object> newArgs = new HashMap<>();

        for(BlockPosition explodedPos : explodeQueue) {
            if (!explodedPos.equals(sourcePos)) {
                BlockState explodedBlock = explodedPos.getBlockState();
                if (explodedBlock != null) {
                    BlockEventTrigger[] explode = explodedBlock.getTrigger("onExplode");
                    if (explode != null) {
                        for(BlockEventTrigger e : explode) {
                            newArgs.put("blockPos", explodedPos);
                            e.act(explodedBlock, zone, newArgs);
                        }
                    }
                }
            }
        }

        BlockSetter.replaceBlocks(zone, blockState, explodeQueue, new Queue<>());
    }
}
