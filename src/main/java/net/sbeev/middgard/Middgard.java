package net.sbeev.middgard;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.sbeev.middgard.block.ModBlocks;
import net.sbeev.middgard.item.ModCreativeModTabs;
import net.sbeev.middgard.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Middgard.MOD_ID)
public class Middgard {
    public static final String MOD_ID = "middgard";
    public static final Logger LOGGER = LogUtils.getLogger();

//FMLJavaModLoadingContext
    public Middgard(IEventBus modEventBus)
    {
        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);
    }
}