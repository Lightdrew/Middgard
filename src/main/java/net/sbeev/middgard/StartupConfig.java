package net.sbeev.middgard;

import net.neoforged.neoforge.common.ModConfigSpec;

public class StartupConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue TREE_FIX_SCAN_LEVEL_ON_MISS = BUILDER
            .comment("[STARTUP] Whether the branch/trunk placement should query the level for adjacent blockstates if none are found in the tree positions.\n" +
                    "Enabling this will make connections more accurate, specifically near the tree base, at the cost of performance.")
            .define("tree_fix_scan_level_on_miss", false);

    static final ModConfigSpec SPEC = BUILDER.build();
}
