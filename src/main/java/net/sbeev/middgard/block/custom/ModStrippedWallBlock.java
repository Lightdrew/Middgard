package net.sbeev.middgard.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.sbeev.middgard.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.drew.diagonal_leaves.util.ModUtils.updateBlocksDiagonally;

public class ModStrippedWallBlock extends WallBlock {
    public ModStrippedWallBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override @ParametersAreNonnullByDefault
    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        return super.connectsTo(state, isSideSolid, direction) || state.is(ModTags.CANOPY_BLOCKS);
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
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.PINE_TRUNK)) {
                return ModBlocks.STRIPPED_PINE_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.ASPEN_TRUNK)) {
                return ModBlocks.STRIPPED_ASPEN_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.MAPLE_TRUNK)) {
                return ModBlocks.STRIPPED_MAPLE_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.OAK_TRUNK)) {
                return ModBlocks.STRIPPED_OAK_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.BIRCH_TRUNK)) {
                return ModBlocks.STRIPPED_BIRCH_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.SPRUCE_TRUNK)) {
                return ModBlocks.STRIPPED_SPRUCE_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.ACACIA_TRUNK)) {
                return ModBlocks.STRIPPED_ACACIA_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.JUNGLE_TRUNK)) {
                return ModBlocks.STRIPPED_JUNGLE_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.DARK_OAK_TRUNK)) {
                return ModBlocks.STRIPPED_DARK_OAK_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.MANGROVE_TRUNK)) {
                return ModBlocks.STRIPPED_MANGROVE_TRUNK.get().defaultBlockState();
            }
            if (state.is(ModBlocks.CHERRY_TRUNK)) {
                return ModBlocks.STRIPPED_CHERRY_TRUNK.get().defaultBlockState();
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override @ParametersAreNonnullByDefault
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        if(state.is(BlockTags.LOGS)) updateBlocksDiagonally(state, pos, level);
    }
}
