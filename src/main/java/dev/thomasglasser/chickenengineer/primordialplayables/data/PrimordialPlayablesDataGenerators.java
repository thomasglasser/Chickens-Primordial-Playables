package dev.thomasglasser.chickenengineer.primordialplayables.data;

import dev.thomasglasser.chickenengineer.primordialplayables.data.blockstates.PrimordialPlayablesBlockStateProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.lang.PrimordialPlayablesEnUsLanguageProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.loot.PrimordialPlayablesLootTables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.models.PrimordialPlayablesItemModels;
import dev.thomasglasser.chickenengineer.primordialplayables.data.recipes.PrimordialPlayablesRecipes;
import dev.thomasglasser.chickenengineer.primordialplayables.data.tags.PrimordialPlayablesBlockTagsProvider;
import dev.thomasglasser.chickenengineer.primordialplayables.data.tags.PrimordialPlayablesItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class PrimordialPlayablesDataGenerators {
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Server
        generator.addProvider(event.includeServer(), new PrimordialPlayablesLootTables(output, provider));
        generator.addProvider(event.includeServer(), new PrimordialPlayablesRecipes(output, provider));
        BlockTagsProvider blocks = new PrimordialPlayablesBlockTagsProvider(output, provider, existingFileHelper);
        generator.addProvider(event.includeServer(), blocks);
        generator.addProvider(event.includeServer(), new PrimordialPlayablesItemTagsProvider(output, provider, blocks.contentsGetter(), existingFileHelper));

        // Client
        generator.addProvider(event.includeClient(), new PrimordialPlayablesEnUsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new PrimordialPlayablesBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new PrimordialPlayablesItemModels(output, existingFileHelper));
    }
}
