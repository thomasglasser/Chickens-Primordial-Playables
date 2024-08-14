package dev.thomasglasser.chickenengineer.primordialplayables.data.tags;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.tags.PrimordialPlayablesBiomeTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PrimordialPlayablesBiomeTagsProvider extends BiomeTagsProvider {
    public PrimordialPlayablesBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, PrimordialPlayables.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(PrimordialPlayablesBiomeTags.HAS_MANGO_TREES)
                .addTag(BiomeTags.IS_JUNGLE);
    }
}
