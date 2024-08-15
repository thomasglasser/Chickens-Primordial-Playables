package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features.PrimordialPlayablesVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class PrimordialPlayablesVegetationPlacements {
    public static final ResourceKey<PlacedFeature> JUNGLE_SMALL_MANGO_TREES = create("jungle_small_mango_trees");
    public static final ResourceKey<PlacedFeature> JUNGLE_MEDIUM_MANGO_TREES = create("jungle_medium_mango_trees");
    public static final ResourceKey<PlacedFeature> JUNGLE_LARGE_MANGO_TREES = create("jungle_large_mango_trees");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> smallMangoTrees = configuredFeatures.getOrThrow(PrimordialPlayablesVegetationFeatures.JUNGLE_SMALL_MANGO_TREES);
        PlacementUtils.register(context, JUNGLE_SMALL_MANGO_TREES, smallMangoTrees, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(5)));
        Holder<ConfiguredFeature<?, ?>> mediumMangoTrees = configuredFeatures.getOrThrow(PrimordialPlayablesVegetationFeatures.JUNGLE_MEDIUM_MANGO_TREES);
        PlacementUtils.register(context, JUNGLE_MEDIUM_MANGO_TREES, mediumMangoTrees, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(10)));
        Holder<ConfiguredFeature<?, ?>> largeMangoTrees = configuredFeatures.getOrThrow(PrimordialPlayablesVegetationFeatures.JUNGLE_LARGE_MANGO_TREES);
        PlacementUtils.register(context, JUNGLE_LARGE_MANGO_TREES, largeMangoTrees, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(50)));
    }

    public static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, PrimordialPlayables.modLoc(name));
    }
}
