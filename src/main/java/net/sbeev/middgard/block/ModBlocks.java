package net.sbeev.middgard.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.item.ModCreativeModTabs;
import net.sbeev.middgard.item.ModItems;
import net.sbeev.middgard.block.custom.*;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Middgard.MOD_ID);


    public static final DeferredHolder<Block, RootedDirtBlock> CONIFER_TOPSOIL = registerBlock("conifer_topsoil",
            () -> new RootedDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT)) {
                @Override
                public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos soilPosition, Direction facing, BlockState plant) {
                    return TriState.TRUE;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
                    ItemStack itemStack = context.getItemInHand();

                    if (!itemStack.canPerformAction(itemAbility)) {
                        return null;
                    }

                    if (ItemAbilities.HOE_TILL == itemAbility) {
                        Block block = state.getBlock();
                        return Blocks.DIRT.defaultBlockState();
                    }

                    return null;
                }
            });

    public static final DeferredHolder<Block, ColoredFallingBlock> WHITE_SAND = registerBlock("white_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(14406560), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final DeferredHolder<Block, Block> WHITE_SANDSTONE = registerBlock("white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredHolder<Block, StairBlock> WHITE_SANDSTONE_STAIRS = registerBlock("white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_SANDSTONE.get())));
    public static final DeferredHolder<Block, SlabBlock> WHITE_SANDSTONE_SLAB = registerBlock("white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredHolder<Block, WallBlock> WHITE_SANDSTONE_WALL = registerBlock("white_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredHolder<Block, Block> CUT_WHITE_SANDSTONE = registerBlock("cut_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
    public static final DeferredHolder<Block, SlabBlock> CUT_WHITE_SANDSTONE_SLAB = registerBlock("cut_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
    public static final DeferredHolder<Block, Block> SMOOTH_WHITE_SANDSTONE = registerBlock("smooth_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredHolder<Block, StairBlock> SMOOTH_WHITE_SANDSTONE_STAIRS = registerBlock("smooth_white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredHolder<Block, SlabBlock> SMOOTH_WHITE_SANDSTONE_SLAB = registerBlock("smooth_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredHolder<Block, Block> CHISELED_WHITE_SANDSTONE = registerBlock("chiseled_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_SANDSTONE)));

    public static final DeferredHolder<Block, DeadBushBlock> SHRUB = registerBlock("shrub",
            () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).noOcclusion().sound(SoundType.GRASS)));
    public static final DeferredHolder<Block, DeadBushBlock> BEACH_GRASS = registerBlock("beach_grass",
            () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).noOcclusion().sound(SoundType.GRASS)));

    public static final DeferredHolder<Block, ModLeavesBlock> BROWN_OAK_LEAVES = registerBlock("brown_oak_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> LEAF_PILE = registerBlock("leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> MAPLE_LEAF_PILE = registerBlock("maple_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> AUTUMNAL_MAPLE_LEAF_PILE = registerBlock("autumnal_maple_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> ASPEN_LEAF_PILE = registerBlock("aspen_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> AUTUMNAL_ASPEN_LEAF_PILE = registerBlock("autumnal_aspen_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModLeafPileBlock> FALLEN_NEEDLES = registerBlock("fallen_needles",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> OAK_TRUNK = registerBlock("oak_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_OAK_TRUNK = registerBlock("stripped_oak_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> OAK_BRANCH = registerBlock("oak_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModStrippedWallBlock> BIRCH_TRUNK = registerBlock("birch_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_BIRCH_TRUNK = registerBlock("stripped_birch_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> BIRCH_BRANCH = registerBlock("birch_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> SPRUCE_TRUNK = registerBlock("spruce_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_SPRUCE_TRUNK = registerBlock("stripped_spruce_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> SPRUCE_BRANCH = registerBlock("spruce_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> JUNGLE_TRUNK = registerBlock("jungle_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_JUNGLE_TRUNK = registerBlock("stripped_jungle_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> JUNGLE_BRANCH = registerBlock("jungle_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> ACACIA_TRUNK = registerBlock("acacia_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_ACACIA_TRUNK = registerBlock("stripped_acacia_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> ACACIA_BRANCH = registerBlock("acacia_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModStrippedWallBlock> DARK_OAK_TRUNK = registerBlock("dark_oak_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_DARK_OAK_TRUNK = registerBlock("stripped_dark_oak_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> DARK_OAK_BRANCH = registerBlock("dark_oak_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModStrippedWallBlock> MANGROVE_TRUNK = registerBlock("mangrove_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_MANGROVE_TRUNK = registerBlock("stripped_mangrove_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> MANGROVE_BRANCH = registerBlock("mangrove_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModStrippedWallBlock> CHERRY_TRUNK = registerBlock("cherry_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_CHERRY_TRUNK = registerBlock("stripped_cherry_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> CHERRY_BRANCH = registerBlock("cherry_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableRotatedPillarBlock> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final DeferredHolder<Block, ModFlammableBlock> PINE_PLANKS = registerBlock("pine_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableSlabBlock> PINE_SLAB = registerBlock("pine_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableStairBlock> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModLeavesBlock> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block,ModLeavesBlock> FALLEN_NEEDLE_BLOCK = registerBlock("fallen_needle_block",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> PINE_TRUNK = registerBlock("pine_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_PINE_TRUNK = registerBlock("stripped_pine_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableFenceBlock> PINE_BRANCH = registerBlock("pine_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceBlock> PINE_FENCE = registerBlock("pine_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableFenceGateBlock> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final DeferredHolder<Block,ButtonBlock> PINE_BUTTON = registerBlock("pine_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredHolder<Block,PressurePlateBlock> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredHolder<Block,DoorBlock> PINE_DOOR = registerBlock("pine_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredHolder<Block,TrapDoorBlock> PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredHolder<Block, SaplingBlock> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock(TreeGrower.SPRUCE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredHolder<Block, SaplingBlock> WHITE_PINE_SAPLING = registerBlock("white_pine_sapling",
            () -> new SaplingBlock(TreeGrower.SPRUCE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> ASPEN_LOG = registerBlock("aspen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> ASPEN_WOOD = registerBlock("aspen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block,ModFlammableRotatedPillarBlock> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final DeferredHolder<Block,ModFlammableBlock> ASPEN_PLANKS = registerBlock("aspen_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableSlabBlock> ASPEN_SLAB = registerBlock("aspen_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableStairBlock> ASPEN_STAIRS = registerBlock("aspen_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> ASPEN_TRUNK = registerBlock("aspen_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_ASPEN_TRUNK = registerBlock("stripped_aspen_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceBlock> ASPEN_BRANCH = registerBlock("aspen_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceBlock> ASPEN_FENCE = registerBlock("aspen_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableFenceGateBlock> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final DeferredHolder<Block, ButtonBlock> ASPEN_BUTTON = registerBlock("aspen_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredHolder<Block, PressurePlateBlock> ASPEN_PRESSURE_PLATE = registerBlock("aspen_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredHolder<Block, DoorBlock> ASPEN_DOOR = registerBlock("aspen_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredHolder<Block,TrapDoorBlock> ASPEN_TRAPDOOR = registerBlock("aspen_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredHolder<Block, SaplingBlock> ASPEN_SAPLING = registerBlock("aspen_sapling",
            () -> new SaplingBlock(TreeGrower.BIRCH,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredHolder<Block, SaplingBlock> YELLOW_ASPEN_SAPLING = registerBlock("yellow_aspen_sapling",
            () -> new SaplingBlock(TreeGrower.BIRCH,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredHolder<Block, ModLeavesBlock> ASPEN_LEAVES = registerBlock("aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block, ModLeavesBlock> YELLOW_ASPEN_LEAVES = registerBlock("yellow_aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block, ModLeavesBlock> BROWN_ASPEN_LEAVES = registerBlock("brown_aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredHolder<Block, ModFlammableRotatedPillarBlock> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block, ModFlammableRotatedPillarBlock> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredHolder<Block, ModFlammableRotatedPillarBlock> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block, ModFlammableRotatedPillarBlock> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final DeferredHolder<Block, ModFlammableBlock> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableSlabBlock> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block,ModFlammableStairBlock> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.MAPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModStrippedWallBlock> MAPLE_TRUNK = registerBlock("maple_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredHolder<Block, ModFlammableWallBlock> STRIPPED_MAPLE_TRUNK = registerBlock("stripped_maple_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceBlock> MAPLE_BRANCH = registerBlock("maple_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceBlock> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredHolder<Block, ModFlammableFenceGateBlock> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final DeferredHolder<Block, ButtonBlock> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockSetType.OAK,10,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredHolder<Block, PressurePlateBlock> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock( BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredHolder<Block, DoorBlock> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredHolder<Block, TrapDoorBlock> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredHolder<Block,SaplingBlock> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredHolder<Block,SaplingBlock> YELLOW_MAPLE_SAPLING = registerBlock("yellow_maple_sapling",
            () -> new SaplingBlock(TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredHolder<Block, SaplingBlock> ORANGE_MAPLE_SAPLING = registerBlock("orange_maple_sapling",
            () -> new SaplingBlock(TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredHolder<Block, SaplingBlock> RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            () -> new SaplingBlock(TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredHolder<Block,ModLeavesBlock> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block,ModLeavesBlock> YELLOW_MAPLE_LEAVES = registerBlock("yellow_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block,ModLeavesBlock> ORANGE_MAPLE_LEAVES = registerBlock("orange_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block,ModLeavesBlock> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredHolder<Block,ModLeavesBlock> BROWN_MAPLE_LEAVES = registerBlock("brown_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(String name, Supplier<T> block) {
        DeferredHolder<Block, T> toReturn = BLOCKS.register(name, block);
        ModCreativeModTabs.entries.add(registerBlockItem(name, toReturn));
        return toReturn;
    }

    private static <T extends Block> DeferredHolder<Item, Item> registerBlockItem(String name, DeferredHolder<Block, T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Blocks.");
    }
}
