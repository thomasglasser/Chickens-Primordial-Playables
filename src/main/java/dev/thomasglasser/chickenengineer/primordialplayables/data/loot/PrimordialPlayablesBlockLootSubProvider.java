package dev.thomasglasser.chickenengineer.primordialplayables.data.loot;

import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class PrimordialPlayablesBlockLootSubProvider extends ExtendedBlockLootSubProvider
{
	protected PrimordialPlayablesBlockLootSubProvider()
	{
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS);
	}

	@Override
	protected void generate()
	{
		woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
	}

	@Override
	protected Iterable<Block> getKnownBlocks()
	{
		return PrimordialPlayablesBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
	}
}
