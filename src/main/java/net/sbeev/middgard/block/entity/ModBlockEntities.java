package net.sbeev.middgard.block.entity;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sbeev.middgard.block.ModBlocks;
import net.sbeev.middgard.block.entity.custom.ModHangingSignBlockEntity;
import net.sbeev.middgard.block.entity.custom.ModSignBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Middgard.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
        BLOCK_ENTITIES.register(
            "mod_sign",
            () -> BlockEntityType.Builder.of(
                    ModSignBlockEntity::new,
                    ModBlocks.PINE_SIGN.standing().get(),  ModBlocks.PINE_SIGN.wall().get(),
                    ModBlocks.ASPEN_SIGN.standing().get(), ModBlocks.ASPEN_SIGN.wall().get(),
                    ModBlocks.MAPLE_SIGN.standing().get(), ModBlocks.MAPLE_SIGN.wall().get()
            ).build(null)
        );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
        BLOCK_ENTITIES.register(
            "mod_hanging_sign",
            () -> BlockEntityType.Builder.of(
                    ModHangingSignBlockEntity::new,
                    ModBlocks.PINE_HANGING_SIGN.ceiling().get(),  ModBlocks.PINE_HANGING_SIGN.wall().get(),
                    ModBlocks.ASPEN_HANGING_SIGN.ceiling().get(), ModBlocks.ASPEN_HANGING_SIGN.wall().get(),
                    ModBlocks.MAPLE_HANGING_SIGN.ceiling().get(), ModBlocks.MAPLE_HANGING_SIGN.wall().get()
            ).build(null)
        );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Block Entities.");
    }
}
