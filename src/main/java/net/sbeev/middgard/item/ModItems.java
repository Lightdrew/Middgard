package net.sbeev.middgard.item;

import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.block.ModBlocks;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Middgard.MOD_ID);
    private static final boolean DEBUG = "true".equalsIgnoreCase(System.getProperty("middgard.debug.registry")) ||
            "true".equalsIgnoreCase(System.getProperty("middgard.debug.registry.item"));


    public static void register(IEventBus eventBus)
    {
        ModBlocks.BLOCKS.getEntries().forEach((entry) ->
                {
                    if (DEBUG) {
                        Middgard.LOGGER.info("Registering Middgard item {}",entry.getRegisteredName());
                    }
                    ITEMS.registerItem(entry.getId().getPath(), (properties) -> new BlockItem(entry.get(), properties));
                }

        );
        ITEMS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Items.");
    }
}