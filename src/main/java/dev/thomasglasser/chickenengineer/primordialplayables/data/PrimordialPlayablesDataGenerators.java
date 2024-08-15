package dev.thomasglasser.chickenengineer.primordialplayables.data;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.blockstates.PrimordialPlayablesBlockStateProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.lang.PrimordialPlayablesEnUsLanguageProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.loot.PrimordialPlayablesLootTables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.models.PrimordialPlayablesItemModels;
import dev.thomasglasser.chickenengineer.primordialplayables.data.recipes.PrimordialPlayablesRecipes;
import dev.thomasglasser.chickenengineer.primordialplayables.data.tags.PrimordialPlayablesBiomeTagsProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.tags.PrimordialPlayablesBlockTagsProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.tags.PrimordialPlayablesItemTagsProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.PrimordialPlayablesProcessorLists;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.biome.PrimordialPlayablesBiomeModifiers;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features.PrimordialPlayablesTreeFeatures;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features.PrimordialPlayablesVegetationFeatures;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement.PrimordialPlayablesTreePlacements;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement.PrimordialPlayablesVegetationPlacements;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class PrimordialPlayablesDataGenerators {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PROCESSOR_LIST, PrimordialPlayablesProcessorLists::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, context -> {
                PrimordialPlayablesTreeFeatures.bootstrap(context);
                PrimordialPlayablesVegetationFeatures.bootstrap(context);
            })
            .add(Registries.PLACED_FEATURE, context -> {
                PrimordialPlayablesTreePlacements.bootstrap(context);
                PrimordialPlayablesVegetationPlacements.bootstrap(context);
            })
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PrimordialPlayablesBiomeModifiers::bootstrap);

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Server
        DatapackBuiltinEntriesProvider entries = new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Set.of(PrimordialPlayables.MOD_ID));
        generator.addProvider(event.includeServer(), entries);
        provider = entries.getRegistryProvider();
        generator.addProvider(event.includeServer(), new PrimordialPlayablesLootTables(output, provider));
        generator.addProvider(event.includeServer(), new PrimordialPlayablesRecipes(output, provider));
        BlockTagsProvider blocks = new PrimordialPlayablesBlockTagsProvider(output, provider, existingFileHelper);
        generator.addProvider(event.includeServer(), blocks);
        generator.addProvider(event.includeServer(), new PrimordialPlayablesItemTagsProvider(output, provider, blocks.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new PrimordialPlayablesBiomeTagsProvider(output, provider, existingFileHelper));

        // Client
        generator.addProvider(event.includeClient(), new PrimordialPlayablesEnUsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new PrimordialPlayablesBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new PrimordialPlayablesItemModels(output, existingFileHelper));
    }
}
