package net.sbeev.middgard.worldgen;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sbeev.middgard.Middgard;

import java.util.List;
import java.util.Map;

public final class ModVanillaSaplingOverride
{
    private static final Map<net.minecraft.world.level.block.Block, List<ResourceKey<ConfiguredFeature<?, ?>>>> POOLS =
            Map.of(
                    Blocks.OAK_SAPLING, ModConfiguredFeature.VANILLA_OAK,
                    Blocks.BIRCH_SAPLING, ModConfiguredFeature.VANILLA_BIRCH,
                    Blocks.SPRUCE_SAPLING, ModConfiguredFeature.VANILLA_SPRUCE
            );

    private ModVanillaSaplingOverride() {}

    public static boolean isOverridden(BlockState state) {
        return POOLS.containsKey(state.getBlock());
    }

    /**
     * Runs the Middgard shuffle-walk feature placement for a vanilla sapling.
     * Returns true if it handled the growth (either placed a tree or exhausted the pool),
     * so the caller should skip the vanilla TreeGrower path. Returns false only if there
     * is no pool for this block (caller should fall through to vanilla).
     */
    public static boolean advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource rand) {
        var pool = POOLS.get(state.getBlock());
        if (pool == null || pool.isEmpty()) {
            return false;
        }

        var registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        int size = pool.size();
        int startIdx = rand.nextInt(size);
        BlockState fluid = level.getFluidState(pos).createLegacyBlock();

        for (int attempt = 0; attempt < size; attempt++) {
            var key = pool.get((startIdx + attempt) % size);
            var maybeHolder = registry.getHolder(key);
            if (maybeHolder.isEmpty()) {
                Middgard.LOGGER.warn("VanillaSaplingOverride: missing ConfiguredFeature '{}', skipping", key.location());
                continue;
            }
            level.setBlock(pos, fluid, 4);
            boolean placed = maybeHolder.get().value().place(level, level.getChunkSource().getGenerator(), rand, pos);
            if (placed) {
                return true;
            }
            level.setBlock(pos, state, 4);
        }

        // All Midgard features failed. Return true anyway so the vanilla TreeGrower does NOT
        // grow a vanilla tree on top — the user wants Midgard trees or nothing on these saplings.
        Middgard.LOGGER.debug("VanillaSaplingOverride at {}: all {} features failed for {}", pos, size, state.getBlock());
        return true;
    }
}