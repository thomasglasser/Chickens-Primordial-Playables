package dev.thomasglasser.chickenengineer.primordialplayables.world.level.block;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import dev.thomasglasser.tommylib.api.world.level.block.BlockUtils;
import dev.thomasglasser.tommylib.api.world.level.block.WoodSet;
import net.minecraft.world.level.material.MapColor;

public class PrimordialPlayablesBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PrimordialPlayables.MOD_ID);

	public static final WoodSet MANGO_WOOD = registerWoodSet("mango", MapColor.COLOR_ORANGE, MapColor.TERRACOTTA_ORANGE);

	private static WoodSet registerWoodSet(String name, MapColor plankColor, MapColor logColor)
	{
		return BlockUtils.registerWoodSet(BLOCKS, name, plankColor, logColor, PrimordialPlayablesItems::register);
	}

	public static void init() {}
}
