package net.sbeev.middgard.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;

import java.util.ArrayList;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Middgard.MOD_ID);

    public static final ArrayList<DeferredHolder<Item, Item>> entries = new ArrayList<>();

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MIDDGARD_TAB;

    public static void register(IEventBus eventBus)
    {
        MIDDGARD_TAB = CREATIVE_MODE_TABS.register("middgard_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(entries.getFirst().get())
        ).title(Component.translatable("creativetab.middgard_tab"))
        .displayItems((itemDisplayParameters, output) ->
                entries.forEach((entry) -> output.accept(entry.get()))
        ).build());

        CREATIVE_MODE_TABS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Creative Tab.");
    }
}
