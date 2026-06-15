package net.sbeev.middgard.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.block.custom.ModTags;

@EventBusSubscriber(modid = Middgard.MOD_ID, value = Dist.DEDICATED_SERVER)
public class ModEventBusServer
{
    @SubscribeEvent
    public static void onTagsUpdated(TagsUpdatedEvent event) {
        ModTags.CANOPY_BLOCKS = TagKey.create(
                Registries.BLOCK,
                ModTags.CANOPY_BLOCKS.location()
        );
        ModTags.BRANCHES = TagKey.create(
                Registries.BLOCK,
                ModTags.BRANCHES.location()
        );
        ModTags.TRUNKS = TagKey.create(
                Registries.BLOCK,
                ModTags.TRUNKS.location()
        );
    }
}