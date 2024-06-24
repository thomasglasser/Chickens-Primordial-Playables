package dev.thomasglasser.chickenengineer.primordialplayables.world.item;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.food.PrimordialPlayablesFoods;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import dev.thomasglasser.tommylib.api.world.item.ItemUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.function.Supplier;

public class PrimordialPlayablesItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrimordialPlayables.MOD_ID);

	public static final DeferredItem<Item> UNRIPE_MANGO = register("unripe_mango", () -> new Item(new Item.Properties().food(PrimordialPlayablesFoods.UNRIPE_MANGO)), List.of(CreativeModeTabs.FOOD_AND_DRINKS));
	public static final DeferredItem<Item> MANGO = register("mango", () -> new Item(new Item.Properties().food(PrimordialPlayablesFoods.MANGO)), List.of(CreativeModeTabs.FOOD_AND_DRINKS));

	public static <T extends Item> DeferredItem<T> register(String name, Supplier<T> supplier, List<ResourceKey<CreativeModeTab>> tabs)
	{
		return ItemUtils.register(ITEMS, name, supplier, tabs);
	}

	public static void init() {}
}
