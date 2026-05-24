package net.sbeev.middgard.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/HarlockDevv">HarlockDevv</a>
 */
public final class ModConfiguredFeature {

    private ModConfiguredFeature() {}

    // 10 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> ASPEN = listOf(
            "aspen/big_aspen_tree_1", "aspen/big_aspen_tree_2",
            "aspen/big_aspen_tree_3", "aspen/big_aspen_tree_4",
            "aspen/small_aspen_tree_1", "aspen/small_aspen_tree_2",
            "aspen/small_aspen_tree_3", "aspen/small_aspen_tree_4",
            "aspen/small_aspen_tree_5", "aspen/small_aspen_tree_6");

    // 10 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> YELLOW_ASPEN = listOf(
            "yellow_aspen/big_yellow_aspen_tree_1", "yellow_aspen/big_yellow_aspen_tree_2",
            "yellow_aspen/big_yellow_aspen_tree_3", "yellow_aspen/big_yellow_aspen_tree_4",
            "yellow_aspen/small_yellow_aspen_tree_1", "yellow_aspen/small_yellow_aspen_tree_2",
            "yellow_aspen/small_yellow_aspen_tree_3", "yellow_aspen/small_yellow_aspen_tree_4",
            "yellow_aspen/small_yellow_aspen_tree_5", "yellow_aspen/small_yellow_aspen_tree_6");

    // 16 variants — white pine lives in the pine/ folder
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> PINE = listOf(
            "pine/pine_tree_1", "pine/pine_tree_2", "pine/pine_tree_3", "pine/pine_tree_4",
            "pine/cone_pine_tree_1", "pine/cone_pine_tree_2", "pine/cone_pine_tree_3", "pine/cone_pine_tree_4",
            "pine/spike_pine_tree_1", "pine/spike_pine_tree_2", "pine/spike_pine_tree_3", "pine/spike_pine_tree_4",
            "pine/small_spike_pine_tree_1", "pine/small_spike_pine_tree_2",
            "pine/small_spike_pine_tree_3", "pine/small_spike_pine_tree_4");

    // 6 variants — also inside the pine/ folder (white_pine/ folder is empty)
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> WHITE_PINE = listOf(
            "pine/white_pine_tree_1", "pine/white_pine_tree_2",
            "pine/white_pine_tree_3", "pine/white_pine_tree_4",
            "pine/small_white_pine_tree_1", "pine/small_white_pine_tree_2");

    // 22 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> MAPLE = listOf(
            "maple/big_maple_tree_1", "maple/big_maple_tree_2",
            "maple/big_maple_tree_3", "maple/big_maple_tree_4",
            "maple/bushy_maple_tree_1", "maple/bushy_maple_tree_2",
            "maple/bushy_maple_tree_3", "maple/bushy_maple_tree_4",
            "maple/medium_maple_tree_1", "maple/medium_maple_tree_2",
            "maple/medium_maple_tree_3", "maple/medium_maple_tree_4",
            "maple/shrubby_maple_tree_1", "maple/shrubby_maple_tree_2", "maple/shrubby_maple_tree_3",
            "maple/small_maple_tree_1", "maple/small_maple_tree_2", "maple/small_maple_tree_3",
            "maple/small_maple_tree_4", "maple/small_maple_tree_5", "maple/small_maple_tree_6",
            "maple/small_maple_tree_7");

    // 22 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> RED_MAPLE = listOf(
            "red_maple/big_red_maple_tree_1", "red_maple/big_red_maple_tree_2",
            "red_maple/big_red_maple_tree_3", "red_maple/big_red_maple_tree_4",
            "red_maple/bushy_red_maple_tree_1", "red_maple/bushy_red_maple_tree_2",
            "red_maple/bushy_red_maple_tree_3", "red_maple/bushy_red_maple_tree_4",
            "red_maple/medium_red_maple_tree_1", "red_maple/medium_red_maple_tree_2",
            "red_maple/medium_red_maple_tree_3", "red_maple/medium_red_maple_tree_4",
            "red_maple/shrubby_red_maple_tree_1", "red_maple/shrubby_red_maple_tree_2", "red_maple/shrubby_red_maple_tree_3",
            "red_maple/small_red_maple_tree_1", "red_maple/small_red_maple_tree_2", "red_maple/small_red_maple_tree_3",
            "red_maple/small_red_maple_tree_4", "red_maple/small_red_maple_tree_5", "red_maple/small_red_maple_tree_6",
            "red_maple/small_red_maple_tree_7");

    // 22 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> ORANGE_MAPLE = listOf(
            "orange_maple/big_orange_maple_tree_1", "orange_maple/big_orange_maple_tree_2",
            "orange_maple/big_orange_maple_tree_3", "orange_maple/big_orange_maple_tree_4",
            "orange_maple/bushy_orange_maple_tree_1", "orange_maple/bushy_orange_maple_tree_2",
            "orange_maple/bushy_orange_maple_tree_3", "orange_maple/bushy_orange_maple_tree_4",
            "orange_maple/medium_orange_maple_tree_1", "orange_maple/medium_orange_maple_tree_2",
            "orange_maple/medium_orange_maple_tree_3", "orange_maple/medium_orange_maple_tree_4",
            "orange_maple/shrubby_orange_maple_tree_1", "orange_maple/shrubby_orange_maple_tree_2", "orange_maple/shrubby_orange_maple_tree_3",
            "orange_maple/small_orange_maple_tree_1", "orange_maple/small_orange_maple_tree_2", "orange_maple/small_orange_maple_tree_3",
            "orange_maple/small_orange_maple_tree_4", "orange_maple/small_orange_maple_tree_5", "orange_maple/small_orange_maple_tree_6",
            "orange_maple/small_orange_maple_tree_7");

    // Vanilla sapling overrides — replicate the 1.20 Forge TreePlacer `sapling_overrides/single/minecraft/*.json`
    // entries so vanilla oak/birch/spruce saplings grow Middgard trees.

    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> VANILLA_OAK = listOf(
            "oak/bushy_oak_tree_1", "oak/bushy_oak_tree_2", "oak/bushy_oak_tree_3",
            "oak/shrubby_oak_tree_1", "oak/shrubby_oak_tree_2", "oak/shrubby_oak_tree_3",
            "oak/small_oak_tree_1", "oak/small_oak_tree_2", "oak/small_oak_tree_3",
            "oak/small_oak_tree_4", "oak/small_oak_tree_5", "oak/small_oak_tree_6", "oak/small_oak_tree_7",
            "oak/tall_oak_tree_1", "oak/tall_oak_tree_2", "oak/tall_oak_tree_3",
            "oak/tall_oak_tree_4", "oak/tall_oak_tree_5");

    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> VANILLA_BIRCH = listOf(
            "birch/small_birch_tree_1", "birch/small_birch_tree_2", "birch/small_birch_tree_3",
            "birch/small_birch_tree_4", "birch/small_birch_tree_5", "birch/small_birch_tree_6", "birch/small_birch_tree_7",
            "birch/tall_birch_tree_1", "birch/tall_birch_tree_2", "birch/tall_birch_tree_3", "birch/tall_birch_tree_4",
            "birch/tall_birch_tree_5", "birch/tall_birch_tree_6", "birch/tall_birch_tree_7", "birch/tall_birch_tree_8");

    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> VANILLA_SPRUCE = listOf(
            "spruce/big_cone_spruce_tree_1", "spruce/big_cone_spruce_tree_2",
            "spruce/big_cone_spruce_tree_3", "spruce/big_cone_spruce_tree_4",
            "spruce/cone_spruce_tree_1", "spruce/cone_spruce_tree_2", "spruce/cone_spruce_tree_3",
            "spruce/cone_spruce_tree_4", "spruce/cone_spruce_tree_5", "spruce/cone_spruce_tree_6", "spruce/cone_spruce_tree_7",
            "spruce/small_spike_spruce_tree_1", "spruce/small_spike_spruce_tree_2",
            "spruce/small_spike_spruce_tree_3", "spruce/small_spike_spruce_tree_4",
            "spruce/spike_spruce_tree_1", "spruce/spike_spruce_tree_2",
            "spruce/spike_spruce_tree_3", "spruce/spike_spruce_tree_4");

    // 22 variants
    public static final List<ResourceKey<ConfiguredFeature<?, ?>>> YELLOW_MAPLE = listOf(
            "yellow_maple/big_yellow_maple_tree_1", "yellow_maple/big_yellow_maple_tree_2",
            "yellow_maple/big_yellow_maple_tree_3", "yellow_maple/big_yellow_maple_tree_4",
            "yellow_maple/bushy_yellow_maple_tree_1", "yellow_maple/bushy_yellow_maple_tree_2",
            "yellow_maple/bushy_yellow_maple_tree_3", "yellow_maple/bushy_yellow_maple_tree_4",
            "yellow_maple/medium_yellow_maple_tree_1", "yellow_maple/medium_yellow_maple_tree_2",
            "yellow_maple/medium_yellow_maple_tree_3", "yellow_maple/medium_yellow_maple_tree_4",
            "yellow_maple/shrubby_yellow_maple_tree_1", "yellow_maple/shrubby_yellow_maple_tree_2", "yellow_maple/shrubby_yellow_maple_tree_3",
            "yellow_maple/small_yellow_maple_tree_1", "yellow_maple/small_yellow_maple_tree_2", "yellow_maple/small_yellow_maple_tree_3",
            "yellow_maple/small_yellow_maple_tree_4", "yellow_maple/small_yellow_maple_tree_5", "yellow_maple/small_yellow_maple_tree_6",
            "yellow_maple/small_yellow_maple_tree_7");

    private static List<ResourceKey<ConfiguredFeature<?, ?>>> listOf(String... paths) {
        return Arrays.stream(paths)
                .map(p -> ResourceKey.create(Registries.CONFIGURED_FEATURE,
                        ResourceLocation.fromNamespaceAndPath("middgard", p)))
                .toList();
    }
}