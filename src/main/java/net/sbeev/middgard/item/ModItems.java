package net.sbeev.middgard.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, Middgard.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Items.");
    }
}