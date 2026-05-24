package net.sbeev.middgard.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.block.ModBlocks;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Middgard.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MIDDGARD_TAB =
        CREATIVE_MODE_TABS.register("middgard_tab",
            CreativeModeTab.builder().icon(ModBlocks.PINE_SAPLING::toStack)
            .title(Component.translatable("creativetab.middgard_tab"))
            .displayItems(ModItems.ITEMS.getEntries())::build
        );

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Creative Tab.");
    }
}
