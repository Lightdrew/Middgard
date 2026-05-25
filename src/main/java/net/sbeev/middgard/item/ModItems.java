package net.sbeev.middgard.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Middgard.MOD_ID);

    public static final DeferredItem<Item> TINY_CHARCOAL = ITEMS.registerItem("tiny_charcoal", Item::new);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Items.");
    }
}