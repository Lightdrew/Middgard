package net.sbeev.middgard.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sbeev.middgard.Middgard;
import net.sbeev.middgard.block.custom.*;
import net.sbeev.middgard.worldgen.ModConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Middgard.MOD_ID);

    private static final boolean DEBUG = "true".equalsIgnoreCase(System.getProperty("middgard.debug.registry")) ||
            "true".equalsIgnoreCase(System.getProperty("middgard.debug.registry.block"));

    public static final DeferredBlock<RootedDirtBlock> CONIFER_TOPSOIL = registerBlock("conifer_topsoil",
            () -> new RootedDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT)) {
                @Override
                public @NotNull TriState canSustainPlant(BlockState s, BlockGetter l, BlockPos sP, Direction f, BlockState p)
                {
                    return TriState.TRUE;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate)
                {
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

    public static final DeferredBlock<ColoredFallingBlock> WHITE_SAND = registerBlock("white_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(14406560), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final DeferredBlock<Block> WHITE_SANDSTONE = registerBlock("white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<StairBlock> WHITE_SANDSTONE_STAIRS = registerBlock("white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> WHITE_SANDSTONE_SLAB = registerBlock("white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<WallBlock> WHITE_SANDSTONE_WALL = registerBlock("white_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CUT_WHITE_SANDSTONE = registerBlock("cut_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
    public static final DeferredBlock<SlabBlock> CUT_WHITE_SANDSTONE_SLAB = registerBlock("cut_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_SANDSTONE = registerBlock("smooth_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredBlock<StairBlock> SMOOTH_WHITE_SANDSTONE_STAIRS = registerBlock("smooth_white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredBlock<SlabBlock> SMOOTH_WHITE_SANDSTONE_SLAB = registerBlock("smooth_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final DeferredBlock<Block> CHISELED_WHITE_SANDSTONE = registerBlock("chiseled_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_SANDSTONE)));

    public static final DeferredBlock<DeadBushBlock> SHRUB = registerBlock("shrub",
            () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).noOcclusion().sound(SoundType.GRASS)));
    public static final DeferredBlock<DeadBushBlock> BEACH_GRASS = registerBlock("beach_grass",
            () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).noOcclusion().sound(SoundType.GRASS)));

    public static final DeferredBlock<ModLeavesBlock> BROWN_OAK_LEAVES = registerBlock("brown_oak_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<ModLeafPileBlock> LEAF_PILE = registerBlock("leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<ModLeafPileBlock> MAPLE_LEAF_PILE = registerBlock("maple_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<ModLeafPileBlock> AUTUMNAL_MAPLE_LEAF_PILE = registerBlock("autumnal_maple_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<ModLeafPileBlock> ASPEN_LEAF_PILE = registerBlock("aspen_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<ModLeafPileBlock> AUTUMNAL_ASPEN_LEAF_PILE = registerBlock("autumnal_aspen_leaf_pile",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<ModLeafPileBlock> FALLEN_NEEDLES = registerBlock("fallen_needles",
            () -> new ModLeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    public static final DeferredBlock<ModStrippedWallBlock> OAK_TRUNK = registerBlock("oak_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_OAK_TRUNK = registerBlock("stripped_oak_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> OAK_BRANCH = registerBlock("oak_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> BIRCH_TRUNK = registerBlock("birch_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_BIRCH_TRUNK = registerBlock("stripped_birch_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> BIRCH_BRANCH = registerBlock("birch_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> SPRUCE_TRUNK = registerBlock("spruce_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_SPRUCE_TRUNK = registerBlock("stripped_spruce_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> SPRUCE_BRANCH = registerBlock("spruce_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> JUNGLE_TRUNK = registerBlock("jungle_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_JUNGLE_TRUNK = registerBlock("stripped_jungle_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> JUNGLE_BRANCH = registerBlock("jungle_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> ACACIA_TRUNK = registerBlock("acacia_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_ACACIA_TRUNK = registerBlock("stripped_acacia_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> ACACIA_BRANCH = registerBlock("acacia_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> DARK_OAK_TRUNK = registerBlock("dark_oak_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_DARK_OAK_TRUNK = registerBlock("stripped_dark_oak_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> DARK_OAK_BRANCH = registerBlock("dark_oak_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> MANGROVE_TRUNK = registerBlock("mangrove_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_MANGROVE_TRUNK = registerBlock("stripped_mangrove_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> MANGROVE_BRANCH = registerBlock("mangrove_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModStrippedWallBlock> CHERRY_TRUNK = registerBlock("cherry_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_CHERRY_TRUNK = registerBlock("stripped_cherry_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> CHERRY_BRANCH = registerBlock("cherry_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<ModFlammableRotatedPillarBlock> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableBlock> PINE_PLANKS = registerBlock("pine_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableSlabBlock> PINE_SLAB = registerBlock("pine_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableStairBlock> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModLeavesBlock> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> FALLEN_NEEDLE_BLOCK = registerBlock("fallen_needle_block",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModStrippedWallBlock> PINE_TRUNK = registerBlock("pine_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_PINE_TRUNK = registerBlock("stripped_pine_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> PINE_BRANCH = registerBlock("pine_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> PINE_FENCE = registerBlock("pine_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceGateBlock> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<ButtonBlock> PINE_BUTTON = registerBlock("pine_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<DoorBlock> PINE_DOOR = registerBlock("pine_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final DeferredBlock<ModFlammableRotatedPillarBlock> ASPEN_LOG = registerBlock("aspen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> ASPEN_WOOD = registerBlock("aspen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableBlock> ASPEN_PLANKS = registerBlock("aspen_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableSlabBlock> ASPEN_SLAB = registerBlock("aspen_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableStairBlock> ASPEN_STAIRS = registerBlock("aspen_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModStrippedWallBlock> ASPEN_TRUNK = registerBlock("aspen_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_ASPEN_TRUNK = registerBlock("stripped_aspen_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> ASPEN_BRANCH = registerBlock("aspen_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> ASPEN_FENCE = registerBlock("aspen_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceGateBlock> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<ButtonBlock> ASPEN_BUTTON = registerBlock("aspen_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> ASPEN_PRESSURE_PLATE = registerBlock("aspen_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<DoorBlock> ASPEN_DOOR = registerBlock("aspen_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> ASPEN_TRAPDOOR = registerBlock("aspen_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<ModLeavesBlock> ASPEN_LEAVES = registerBlock("aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> YELLOW_ASPEN_LEAVES = registerBlock("yellow_aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> BROWN_ASPEN_LEAVES = registerBlock("brown_aspen_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<ModFlammableRotatedPillarBlock> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredBlock<ModFlammableRotatedPillarBlock> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final DeferredBlock<ModFlammableBlock> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableSlabBlock> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableStairBlock> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new ModFlammableStairBlock(ModBlocks.MAPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModStrippedWallBlock> MAPLE_TRUNK = registerBlock("maple_trunk",
            () -> new ModStrippedWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableWallBlock> STRIPPED_MAPLE_TRUNK = registerBlock("stripped_maple_trunk",
            () -> new ModFlammableWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> MAPLE_BRANCH = registerBlock("maple_branch",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceBlock> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<ModFlammableFenceGateBlock> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<ButtonBlock> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockSetType.OAK,10,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock( BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<DoorBlock> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<ModLeavesBlock> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> YELLOW_MAPLE_LEAVES = registerBlock("yellow_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> ORANGE_MAPLE_LEAVES = registerBlock("orange_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<ModLeavesBlock> BROWN_MAPLE_LEAVES = registerBlock("brown_maple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<ModSaplingBlock> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.PINE,TreeGrower.SPRUCE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModSaplingBlock> WHITE_PINE_SAPLING = registerBlock("white_pine_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.WHITE_PINE,TreeGrower.SPRUCE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<ModSaplingBlock> ASPEN_SAPLING = registerBlock("aspen_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.ASPEN,TreeGrower.BIRCH,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModSaplingBlock> YELLOW_ASPEN_SAPLING = registerBlock("yellow_aspen_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.YELLOW_ASPEN,TreeGrower.BIRCH,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<ModSaplingBlock> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.MAPLE,TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModSaplingBlock> YELLOW_MAPLE_SAPLING = registerBlock("yellow_maple_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.YELLOW_MAPLE,TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModSaplingBlock> ORANGE_MAPLE_SAPLING = registerBlock("orange_maple_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.ORANGE_MAPLE,TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModSaplingBlock> RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            () -> new ModSaplingBlock(ModConfiguredFeature.RED_MAPLE,TreeGrower.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        if (DEBUG) {
            Middgard.LOGGER.info("Registering Middgard block " + Middgard.MOD_ID + ":{}", name);
        }
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
        Middgard.LOGGER.info("Loaded Middgard Blocks.");
    }
}
