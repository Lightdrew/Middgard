package net.sbeev.middgard.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModLeafPileBlock extends SnowLayerBlock
{
    public ModLeafPileBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override @ParametersAreNonnullByDefault
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {}

    @Override @ParametersAreNonnullByDefault
    public @NotNull VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override @ParametersAreNonnullByDefault
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }

    @Override @ParametersAreNonnullByDefault
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }

    @Override @ParametersAreNonnullByDefault
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }

}
