package dev.thomasglasser.chickenengineer.primordialplayables.data.lang;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.lang.ExtendedEnUsLanguageProvider;
import net.minecraft.data.PackOutput;

public class PrimordialPlayablesEnUsLanguageProvider extends ExtendedEnUsLanguageProvider {
    public PrimordialPlayablesEnUsLanguageProvider(PackOutput output) {
        super(output, PrimordialPlayables.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        add(PrimordialPlayablesBlocks.MANGO_WOOD, "Mango");
        add(PrimordialPlayablesBlocks.MANGO_LEAVES, "Mango");
        add(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(), "Fruitful Mango Leaves");
        add(PrimordialPlayablesBlocks.KUDZU.get(), "Kudzu");

        add(PrimordialPlayablesItems.UNRIPE_MANGO.get(), "Unripe Mango");
        add(PrimordialPlayablesItems.MANGO.get(), "Mango");
    }
}
