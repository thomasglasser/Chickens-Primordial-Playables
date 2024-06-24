package dev.thomasglasser.chickenengineer.primordialplayables.data.loot;

import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.AgeingLeavesBlock;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

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
		leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);
		this.add(
				PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(),
				(block) -> this.applyExplosionDecay(block,
						LootTable.lootTable()
								.withPool(
										LootPool.lootPool()
												.when(
														LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
																.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AgeingLeavesBlock.AGE, AgeingLeavesBlock.MAX_AGE))
												)
												.add(LootItem.lootTableItem(((AgeingLeavesBlock)block).getFruitForAge(AgeingLeavesBlock.MAX_AGE)))
												.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
												.apply(ApplyBonusCount.addUniformBonusCount(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)))
								).withPool(
										LootPool.lootPool()
												.when(
														LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
																.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AgeingLeavesBlock.AGE, AgeingLeavesBlock.MAX_AGE - 1))
												)
												.add(LootItem.lootTableItem(((AgeingLeavesBlock)block).getFruitForAge(AgeingLeavesBlock.MAX_AGE - 1)))
												.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
												.apply(ApplyBonusCount.addUniformBonusCount(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)))
								)
				)
		);
	}
}