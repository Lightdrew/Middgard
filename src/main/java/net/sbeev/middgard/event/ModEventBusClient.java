package net.sbeev.middgard.event;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.block.custom.ModWoodTypes;
import net.sbeev.middgard.block.entity.ModBlockEntities;

@EventBusSubscriber(modid = Middgard.MOD_ID, value = Dist.CLIENT)
public class ModEventBusClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        Sheets.addWoodType(ModWoodTypes.PINE);
        Sheets.addWoodType(ModWoodTypes.ASPEN);
        Sheets.addWoodType(ModWoodTypes.MAPLE);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}