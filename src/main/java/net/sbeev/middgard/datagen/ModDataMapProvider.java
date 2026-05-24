package net.sbeev.middgard.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.sbeev.middgard.block.ModBlocks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override @ParametersAreNonnullByDefault
    protected void gather(HolderLookup.Provider lookupProvider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModBlocks.PINE_SAPLING.getId()        , new Compostable(0.3F), false)
                .add(ModBlocks.WHITE_PINE_SAPLING.getId()  , new Compostable(0.3F), false)
                .add(ModBlocks.ASPEN_SAPLING.getId()       , new Compostable(0.3F), false)
                .add(ModBlocks.YELLOW_ASPEN_SAPLING.getId(), new Compostable(0.3F), false)
                .add(ModBlocks.MAPLE_SAPLING.getId()       , new Compostable(0.3F), false)
                .add(ModBlocks.YELLOW_MAPLE_SAPLING.getId(), new Compostable(0.3F), false)
                .add(ModBlocks.ORANGE_MAPLE_SAPLING.getId(), new Compostable(0.3F), false)
                .add(ModBlocks.RED_MAPLE_SAPLING.getId()   , new Compostable(0.3F), false);
    }
}
