package dev.thomasglasser.chickenengineer.primordialplayables.data.lang;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.lang.ExtendedLanguageProvider;
import net.minecraft.data.PackOutput;

public class PrimordialPlayablesEnUsLanguageProvider extends ExtendedLanguageProvider
{
	public PrimordialPlayablesEnUsLanguageProvider(PackOutput output)
	{
		super(output, PrimordialPlayables.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations()
	{
		add(PrimordialPlayablesBlocks.MANGO_WOOD, "Mango");
	}
}
