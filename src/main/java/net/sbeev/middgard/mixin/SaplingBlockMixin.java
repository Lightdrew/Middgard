package net.sbeev.middgard.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.worldgen.ModVanillaSaplingOverride;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author <a href="https://github.com/HarlockDevv">HarlockDevv</a>
 * Intercepts vanilla oak/birch/spruce saplings' {@code advanceTree} call and redirects
 * it to the Midgard feature pool (replicating the 1.20 TreePlacer sapling_overrides).
 * Midgard's own {@link net.sbeev.middgard.block.custom.ModSaplingBlock} overrides
 * {@code advanceTree} directly, so this mixin only fires for vanilla subclasses.
 */
@Mixin(SaplingBlock.class)
public abstract class SaplingBlockMixin
{
    @Inject(method = "advanceTree", at = @At("HEAD"), cancellable = true)
    private void middgard$advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource rand, CallbackInfo ci)
    {
        if (state.getValue(SaplingBlock.STAGE) == 0) {
            // Stage 0: let vanilla bump it to stage 1 (normal growth progression).
            return;
        }
        if (!ModVanillaSaplingOverride.isOverridden(state)) {
            return;
        }
        if (!ModVanillaSaplingOverride.advanceTree(level, pos, state, rand)) {
            Middgard.LOGGER.info("SaplingBlockMixin failed to place custom feature");
            return;
        }

        ci.cancel();
    }
}