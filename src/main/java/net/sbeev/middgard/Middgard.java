package net.sbeev.middgard;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.sbeev.middgard.block.ModBlocks;
import net.sbeev.middgard.item.ModCreativeTab;
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

        ModCreativeTab.register(modEventBus);
    }
}