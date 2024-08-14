package dev.thomasglasser.chickenengineer.primordialplayables.data.tags;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.tags.ExtendedItemTagsProvider;
import dev.thomasglasser.tommylib.api.tags.ConventionalItemTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PrimordialPlayablesItemTagsProvider extends ExtendedItemTagsProvider {
    public PrimordialPlayablesItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(output, future, blockTagsProvider, PrimordialPlayables.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);

        leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);

        tag(ItemTags.LEAVES)
                .add(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.asItem());

        tag(ItemTags.PARROT_FOOD)
                .add(PrimordialPlayablesItems.MANGO.get());

        tag(ConventionalItemTags.FRUITS_FOODS)
                .add(PrimordialPlayablesItems.MANGO.get())
                .add(PrimordialPlayablesItems.UNRIPE_MANGO.get());
    }
}
