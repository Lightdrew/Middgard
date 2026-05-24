package net.sbeev.middgard.block;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sbeev.middgard.block.custom.*;
import net.sbeev.middgard.item.ModItems;

import static net.sbeev.middgard.block.ModBlocks.BLOCKS;

class ModSignBlocks
{
    static SignBlock registerSignBlock(String wood_name, BlockBehaviour.Properties pProperties, WoodType pType) {
        var sign_entry = new SignBlock(
            BLOCKS.register(wood_name.concat("_sign"), () -> new ModStandingSignBlock(pType, pProperties)),
            BLOCKS.register(wood_name.concat("_wall_sign"), () -> new ModWallSignBlock(pType, pProperties))
        );

        registerSignItem(wood_name, sign_entry);

        return sign_entry;
    }

    private static void registerSignItem(String wood_name, SignBlock block_record)
    {
        ModItems.ITEMS.registerItem(wood_name.concat("_sign"), p -> new SignItem(p.stacksTo(16), block_record.standing.get(), block_record.wall.get()));
    }

    static HangingSignBlock registerHangingSignBlock(String wood_name, BlockBehaviour.Properties pProperties, WoodType pType) {
        var sign_entry = new HangingSignBlock(
                BLOCKS.register(wood_name.concat("_hanging_sign"), () -> new ModHangingSignBlock(pType, pProperties)),
                BLOCKS.register(wood_name.concat("_wall_hanging_sign"), () -> new ModWallHangingSignBlock(pType, pProperties))
        );

        registerHangingSignItem(wood_name, sign_entry);

        return sign_entry;
    }

    private static void registerHangingSignItem(String wood_name, HangingSignBlock block_record)
    {
        ModItems.ITEMS.registerItem(wood_name.concat("_hanging_sign"), p -> new HangingSignItem(block_record.ceiling.get(), block_record.wall.get(), p.stacksTo(16)));
    }

    public record SignBlock(DeferredBlock<ModStandingSignBlock> standing, DeferredBlock<ModWallSignBlock> wall) {}
    public record HangingSignBlock(DeferredBlock<ModHangingSignBlock> ceiling, DeferredBlock<ModWallHangingSignBlock> wall){}
}
