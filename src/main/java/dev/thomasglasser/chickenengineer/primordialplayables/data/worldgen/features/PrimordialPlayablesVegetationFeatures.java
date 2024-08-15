package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement.PrimordialPlayablesTreePlacements;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PrimordialPlayablesVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_SMALL_MANGO_TREES = create("jungle_small_mango_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_MEDIUM_MANGO_TREES = create("jungle_medium_mango_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_LARGE_MANGO_TREES = create("jungle_large_mango_trees");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        Holder.Reference<PlacedFeature> smallMangoChecked = placedFeatures.getOrThrow(PrimordialPlayablesTreePlacements.SMALL_MANGO_CHECKED);
        FeatureUtils.register(context, JUNGLE_SMALL_MANGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(smallMangoChecked, 1f)), smallMangoChecked));
        Holder.Reference<PlacedFeature> mediumMangoChecked = placedFeatures.getOrThrow(PrimordialPlayablesTreePlacements.MEDIUM_MANGO_CHECKED);
        FeatureUtils.register(context, JUNGLE_MEDIUM_MANGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(mediumMangoChecked, 1f)), mediumMangoChecked));
        Holder.Reference<PlacedFeature> largeMangoChecked = placedFeatures.getOrThrow(PrimordialPlayablesTreePlacements.LARGE_MANGO_CHECKED);
        FeatureUtils.register(context, JUNGLE_LARGE_MANGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(largeMangoChecked, 1f)), largeMangoChecked));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, PrimordialPlayables.modLoc(name));
    }
}
