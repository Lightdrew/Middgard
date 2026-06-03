package net.sbeev.middgard.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sbeev.middgard.util.ModUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LeavesBlock.class)
public class LeavesBlockMixin extends BlockBehaviourMixin
{

    @Inject(
            method = "updateDistance(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void updateDistance(
            BlockState state,
            LevelAccessor level,
            BlockPos pos,
            CallbackInfoReturnable<BlockState> cir
    )
    {
        int i = LeavesBlock.DECAY_DISTANCE;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int x = -1; x < 2; x++) for (int y = -1; y < 2; y++) for (int z = -1; z < 2; z++)
        {
            int dist = x*x + y*y + z*z;
            if(dist == 0) continue;

            blockpos$mutableblockpos.setWithOffset(pos, x, y, z);

            i = Math.min(i, LeavesBlock.getDistanceAt(level.getBlockState(blockpos$mutableblockpos)) + dist);
            if (i == 1) {
                break;
            }
        }
        cir.setReturnValue(state.setValue(LeavesBlock.DISTANCE, i));
    }

    @Override
    protected void mixin$onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving, CallbackInfo ci) {
        ModUtils.updateBlocksDiagonally((Block)(Object)this, newState, state, pos, level);
    }

    @Override
    protected void mixin$onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
        ModUtils.updateBlocksDiagonally((Block)(Object)this, oldState, state, pos, level);
    }
}