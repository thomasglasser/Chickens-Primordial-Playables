package dev.thomasglasser.chickenengineer.primordialplayables.data.tags;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.tags.ExtendedBlockTagsProvider;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PrimordialPlayablesBlockTagsProvider extends ExtendedBlockTagsProvider {
    public PrimordialPlayablesBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PrimordialPlayables.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);

        leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);

        tag(BlockTags.LEAVES)
                .add(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get());
    }
}
