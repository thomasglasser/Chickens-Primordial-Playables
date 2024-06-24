package dev.thomasglasser.chickenengineer.primordialplayables.data.models;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.AgeingLeavesBlock;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.models.ExtendedItemModelProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PrimordialPlayablesItemModels extends ExtendedItemModelProvider
{
	public PrimordialPlayablesItemModels(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, PrimordialPlayables.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
		leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);
		leaves(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.getId().getPath(), modBlockModel(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.getId().getPath() + "_stage" + AgeingLeavesBlock.MAX_AGE));

		basicItem(PrimordialPlayablesItems.UNRIPE_MANGO.get());
		basicItem(PrimordialPlayablesItems.MANGO.get());
	}
}
