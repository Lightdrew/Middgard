package net.sbeev.middgard.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModUtils {
    public static void updateBlocksDiagonally(Block block, BlockState state, BlockState newState, BlockPos pos, Level level)
    {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int x = -1; x < 2; x++) for (int y = -1; y < 2; y++) for (int z = -1; z < 2; z++)
        {
            int dist = x*x + y*y + z*z;
            if(dist == 0) continue;

            mutablePos.setWithOffset(pos, x, y, z);

            BlockState neighbour = level.getBlockState(mutablePos);

            if (!(neighbour.getBlock() instanceof LeavesBlock leaves)) continue;

            BlockState updatedState = leaves.updateShape(
                    neighbour,
                    null,
                    state,
                    level,
                    mutablePos,
                    pos
            );

            if (updatedState == neighbour) continue;

            level.setBlock(mutablePos, updatedState, Block.UPDATE_ALL);
        }
    }
}
