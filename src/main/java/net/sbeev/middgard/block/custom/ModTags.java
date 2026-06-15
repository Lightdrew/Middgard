package net.sbeev.middgard.block.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sbeev.middgard.Middgard;

public class ModTags {
    public static TagKey<Block> CANOPY_BLOCKS;
    public static TagKey<Block> BRANCHES;
    public static TagKey<Block> TRUNKS;

    public static void init()
    {
        CANOPY_BLOCKS = TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Middgard.MOD_ID,"canopy_blocks")
        );
        BRANCHES = TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Middgard.MOD_ID,"branches")
        );
        TRUNKS = TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Middgard.MOD_ID,"trunks")
        );
    }
}
