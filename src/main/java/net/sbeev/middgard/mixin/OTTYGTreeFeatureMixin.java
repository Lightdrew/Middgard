package net.sbeev.middgard.mixin;

import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TreeFromStructureNBTFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.sbeev.middgard.block.custom.ModTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

import static net.sbeev.middgard.StartupConfig.TREE_FIX_SCAN_LEVEL_ON_MISS;

@Pseudo
@Mixin(TreeFromStructureNBTFeature.class)
public class OTTYGTreeFeatureMixin
{
    @Unique
    private static final boolean SHOULD_SCAN = TREE_FIX_SCAN_LEVEL_ON_MISS.getAsBoolean();

    @Unique
    private static final Map<Direction, EnumProperty<WallSide>> TRUNK_PROPERTY_BY_DIRECTION = Map.of(
            Direction.NORTH, BlockStateProperties.NORTH_WALL,
            Direction.SOUTH, BlockStateProperties.SOUTH_WALL,
            Direction.EAST, BlockStateProperties.EAST_WALL,
            Direction.WEST, BlockStateProperties.WEST_WALL
    );

    @Unique
    private static final Map<Direction, BooleanProperty> BRANCH_PROPERTY_BY_DIRECTION = Map.of(
            Direction.NORTH, BlockStateProperties.NORTH,
            Direction.SOUTH, BlockStateProperties.SOUTH,
            Direction.EAST, BlockStateProperties.EAST,
            Direction.WEST, BlockStateProperties.WEST
    );

    @Inject(
            method = "placeKnownBlockPositions",
            at = @At("HEAD"),
            remap = false
    )
    private static void placeKnownBlockPositions(Map<BlockPos, BlockState> positions, WorldGenLevel level, CallbackInfo ci)
    {
        positions.entrySet().forEach(entry ->
        {
            BlockState state = entry.getValue();

            boolean isTrunk = state.is(ModTags.TRUNKS);
            boolean isBranch = state.is(ModTags.BRANCHES);

            if (!(isBranch || isTrunk)) return;

            BlockPos pos = entry.getKey().immutable();

            boolean updated = false;
            BlockState newState = state;

            for(Direction dir : Direction.Plane.HORIZONTAL)
            {
                BlockPos neighbourPos = pos.relative(dir);
                BlockState neighbourState = positions.get(neighbourPos);

                if (SHOULD_SCAN && neighbourState == null) neighbourState = level.getBlockState(neighbourPos);

                boolean isNeighbourCanopy = neighbourState != null && neighbourState.is(ModTags.CANOPY_BLOCKS);

                if (isTrunk)
                {
                    newState = state.setValue(
                        TRUNK_PROPERTY_BY_DIRECTION.get(dir),
                        isNeighbourCanopy ? WallSide.LOW : WallSide.NONE
                    );
                }

                if (isBranch) newState = state.setValue(
                    BRANCH_PROPERTY_BY_DIRECTION.get(dir),
                    isNeighbourCanopy
                );

                if (newState.equals(state)) continue;

                updated = true;
                state = newState;
            }

            if (updated) entry.setValue(state);
        });
    }
}
