package dev.thomasglasser.chickenengineer.primordialplayables.data.loot;

import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class PrimordialPlayablesBlockLootSubProvider extends ExtendedBlockLootSubProvider
{
	protected PrimordialPlayablesBlockLootSubProvider(HolderLookup.Provider provider)
	{
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, provider, PrimordialPlayablesBlocks.BLOCKS);
	}

	@Override
	protected void generate()
	{
		woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
	}
}