package dev.thomasglasser.chickenengineer.primordialplayables.data.loot;

import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.AgeingFruitfulLeavesBlock;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class PrimordialPlayablesBlockLootSubProvider extends ExtendedBlockLootSubProvider {
    protected PrimordialPlayablesBlockLootSubProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, provider, PrimordialPlayablesBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
        leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);
        add(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(), createAgeingFruitfulLeavesDrops(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get()));
    }

    protected LootTable.Builder createAgeingFruitfulLeavesDrops(AgeingFruitfulLeavesBlock block) {
        LootPoolSingletonContainer.Builder<?> ripe = LootItem.lootTableItem(block.getFruitForAge(AgeingFruitfulLeavesBlock.MAX_AGE))
                .when(
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AgeingFruitfulLeavesBlock.AGE, AgeingFruitfulLeavesBlock.MAX_AGE)));
        LootPoolSingletonContainer.Builder<?> unripe = LootItem.lootTableItem(block.getFruitForAge(AgeingFruitfulLeavesBlock.MAX_AGE - 1))
                .when(
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AgeingFruitfulLeavesBlock.AGE, AgeingFruitfulLeavesBlock.MAX_AGE - 1)));
        return this.createLeavesDrops(block, PrimordialPlayablesBlocks.MANGO_LEAVES.sapling().get(), NORMAL_LEAVES_SAPLING_CHANCES)
                .withPool(
                        LootPool.lootPool()
                                .add(applyExplosionCondition(block, ripe.otherwise(unripe)))
                                .setRolls(ConstantValue.exactly(1.0F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)))
                );
    }
}
