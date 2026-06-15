package net.sbeev.middgard;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.sbeev.middgard.block.ModBlocks;
import net.sbeev.middgard.block.custom.ModTags;
import net.sbeev.middgard.block.entity.ModBlockEntities;
import net.sbeev.middgard.item.ModCreativeTab;
import net.sbeev.middgard.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Middgard.MOD_ID)
public class Middgard {
    public static final String MOD_ID = "middgard";
    public static final Logger LOGGER = LogUtils.getLogger();

//FMLJavaModLoadingContext
    public Middgard(IEventBus modEventBus, ModContainer modContainer)
    {
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModItems.register(modEventBus);

        ModCreativeTab.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.STARTUP, StartupConfig.SPEC);

        ModTags.init();
    }
}