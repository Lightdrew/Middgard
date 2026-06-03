package net.sbeev.middgard.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sbeev.middgard.util.ModUtils;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModFlammableWallBlock extends WallBlock {
    public ModFlammableWallBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override @ParametersAreNonnullByDefault
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override @ParametersAreNonnullByDefault
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override @ParametersAreNonnullByDefault
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override @ParametersAreNonnullByDefault
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        if(state.is(BlockTags.LOGS)) ModUtils.updateBlocksDiagonally(this, state, newState, pos, level);
    }
}
