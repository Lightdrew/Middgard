package net.sbeev.middgard.block.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.slf4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/HarlockDevv">HarlockDevv</a>
 */
public class ModSaplingBlock extends SaplingBlock {

    private static final Logger LOGGER = LogUtils.getLogger();

    // Toggle with -Dmiddgard.debug.trees=true. When off, the grow path is exactly the non-debug path (zero snapshot cost).
    private static final boolean DEBUG = "true".equalsIgnoreCase(System.getProperty("middgard.debug.trees"));

    private static final int DBG_RADIUS_XZ = 12;
    private static final int DBG_DOWN = 2;
    private static final int DBG_UP = 32;

    private final List<ResourceKey<ConfiguredFeature<?, ?>>> features;

    public ModSaplingBlock(List<ResourceKey<ConfiguredFeature<?, ?>>> features,
                           TreeGrower fallback, Properties props) {
        super(fallback, props);
        this.features = features;
    }

    @Override @ParametersAreNonnullByDefault
    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource rand) {
        if (state.getValue(STAGE) == 0) {
            super.advanceTree(level, pos, state, rand);
            return;
        }

        if (features.isEmpty()) {
            LOGGER.warn("MiddgardSaplingBlock at {}: empty feature list, using vanilla fallback", pos);
            super.advanceTree(level, pos, state, rand);
            return;
        }

        var registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        int size = features.size();
        int startIdx = rand.nextInt(size);
        BlockState fluid = level.getFluidState(pos).createLegacyBlock();
        ResourceLocation saplingId = DEBUG ? BuiltInRegistries.BLOCK.getKey(state.getBlock()) : null;

        for (int attempt = 0; attempt < size; attempt++) {
            var key = features.get((startIdx + attempt) % size);
            var maybeHolder = registry.getHolder(key);
            if (maybeHolder.isEmpty()) {
                LOGGER.warn("MiddgardSaplingBlock: missing ConfiguredFeature '{}', skipping", key.location());
                continue;
            }
            level.setBlock(pos, fluid, 4);

            Map<BlockPos, BlockState> before = DEBUG ? snapshot(level, pos) : null;
            boolean placed = maybeHolder.get().value().place(level, level.getChunkSource().getGenerator(), rand, pos);
            if (DEBUG) {
                logDiff(saplingId, key, pos, before, level, placed);
            }

            if (placed) {
                return;
            }
            level.setBlock(pos, state, 4);
        }

        LOGGER.warn("MiddgardSaplingBlock at {}: all {} features failed to place, using vanilla fallback", pos, size);
        super.advanceTree(level, pos, state, rand);
    }

    private static Map<BlockPos, BlockState> snapshot(ServerLevel level, BlockPos center) {
        Map<BlockPos, BlockState> out = new HashMap<>();
        BlockPos.MutableBlockPos mpos = new BlockPos.MutableBlockPos();
        for (int dy = -DBG_DOWN; dy <= DBG_UP; dy++) {
            for (int dx = -DBG_RADIUS_XZ; dx <= DBG_RADIUS_XZ; dx++) {
                for (int dz = -DBG_RADIUS_XZ; dz <= DBG_RADIUS_XZ; dz++) {
                    mpos.set(center.getX() + dx, center.getY() + dy, center.getZ() + dz);
                    out.put(mpos.immutable(), level.getBlockState(mpos));
                }
            }
        }
        return out;
    }

    private static void logDiff(ResourceLocation saplingId,
                                ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                BlockPos sapling,
                                Map<BlockPos, BlockState> before,
                                ServerLevel level,
                                boolean placed) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;
        int changed = 0;
        int logsBelowOrAt0 = 0;
        int logsAtY1 = 0;
        int logsAtY2 = 0;

        StringBuilder changes = new StringBuilder();
        for (Map.Entry<BlockPos, BlockState> e : before.entrySet()) {
            BlockPos p = e.getKey();
            BlockState oldS = e.getValue();
            BlockState newS = level.getBlockState(p);
            if (oldS == newS) continue;

            int rx = p.getX() - sapling.getX();
            int ry = p.getY() - sapling.getY();
            int rz = p.getZ() - sapling.getZ();
            if (rx < minX) minX = rx; if (rx > maxX) maxX = rx;
            if (ry < minY) minY = ry; if (ry > maxY) maxY = ry;
            if (rz < minZ) minZ = rz; if (rz > maxZ) maxZ = rz;
            changed++;

            if (newS.is(BlockTags.LOGS)) {
                if (ry <= 0) logsBelowOrAt0++;
                else if (ry == 1) logsAtY1++;
                else if (ry == 2) logsAtY2++;
            }

            changes.append("\n  (")
                    .append(rx).append(',').append(ry).append(',').append(rz).append(") ")
                    .append(describe(oldS)).append(" -> ").append(describe(newS));
        }

        StringBuilder header = new StringBuilder();
        header.append("\n[MiddgardTreeDebug] sapling=").append(saplingId)
                .append(" feature=").append(featureKey.location())
                .append(" pos=").append(sapling.getX()).append(',').append(sapling.getY()).append(',').append(sapling.getZ())
                .append(" result=").append(placed ? "PLACED" : "FAILED")
                .append(" changed=").append(changed);
        if (changed > 0) {
            header.append(" bounds=x[").append(minX).append(',').append(maxX).append("]")
                    .append(" y[").append(minY).append(',').append(maxY).append("]")
                    .append(" z[").append(minZ).append(',').append(maxZ).append("]");
        }
        header.append(" logs_y<=0=").append(logsBelowOrAt0)
                .append(" logs_y=1=").append(logsAtY1)
                .append(" logs_y=2=").append(logsAtY2)
                .append(" base_anomaly=").append(logsBelowOrAt0 > 0 || (logsAtY1 + logsAtY2) > 2);

        LOGGER.info("{}{}", header, changes);
    }

    private static String describe(BlockState s) {
        return BuiltInRegistries.BLOCK.getKey(s.getBlock()).toString();
    }
}
