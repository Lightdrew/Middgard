package net.sbeev.middgard.block.custom;

import net.sbeev.middgard.block.entity.custom.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModWallHangingSignBlock extends WallHangingSignBlock
{
    public ModWallHangingSignBlock(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity(pPos, pState);
    }
}
