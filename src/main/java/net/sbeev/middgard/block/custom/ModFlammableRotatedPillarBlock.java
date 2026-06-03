package net.sbeev.middgard.block.custom;

import net.neoforged.neoforge.common.ItemAbility;
import net.sbeev.middgard.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties pProperties) {
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
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.PINE_LOG.get())) {
                return ModBlocks.STRIPPED_PINE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.PINE_WOOD.get())) {
                return ModBlocks.STRIPPED_PINE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.ASPEN_LOG.get())) {
                return ModBlocks.STRIPPED_ASPEN_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.ASPEN_WOOD.get())) {
                return ModBlocks.STRIPPED_ASPEN_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.MAPLE_LOG.get())) {
                return ModBlocks.STRIPPED_MAPLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.MAPLE_WOOD.get())) {
                return ModBlocks.STRIPPED_MAPLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
