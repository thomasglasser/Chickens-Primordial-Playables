package dev.thomasglasser.chickenengineer.primordialplayables.data.blockstates;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PrimordialPlayablesBlockStateProvider extends ExtendedBlockStateProvider
{
	public PrimordialPlayablesBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
	{
		super(output, PrimordialPlayables.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels()
	{
		woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
	}
}
