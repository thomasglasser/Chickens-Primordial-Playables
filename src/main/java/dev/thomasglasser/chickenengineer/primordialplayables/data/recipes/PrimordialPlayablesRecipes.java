package dev.thomasglasser.chickenengineer.primordialplayables.data.recipes;

import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.recipes.ExtendedRecipeProvider;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

public class PrimordialPlayablesRecipes extends ExtendedRecipeProvider {
    public PrimordialPlayablesRecipes(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput writer) {
        woodSet(writer, PrimordialPlayablesBlocks.MANGO_WOOD);
    }
}
