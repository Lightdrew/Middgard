package net.sbeev.middgard.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModFlammableFenceGateBlock extends FenceGateBlock {
    public ModFlammableFenceGateBlock(Properties pProperties, SoundEvent openSound, SoundEvent closeSound) {
        super(pProperties,openSound,closeSound);
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
}
