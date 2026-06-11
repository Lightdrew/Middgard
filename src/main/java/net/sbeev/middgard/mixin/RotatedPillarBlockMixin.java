package net.sbeev.middgard.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sbeev.middgard.util.ModUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RotatedPillarBlock.class)
public class RotatedPillarBlockMixin extends BlockBehaviourMixin
{
    @Override
    protected void mixin$onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving, CallbackInfo ci) {
        if(state.is(BlockTags.LOGS)) ModUtils.updateBlocksDiagonally(newState, pos, level);
    }

    @Override
    protected void mixin$onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
        if(state.is(BlockTags.LOGS)) ModUtils.updateBlocksDiagonally(oldState, pos, level);
    }
}
