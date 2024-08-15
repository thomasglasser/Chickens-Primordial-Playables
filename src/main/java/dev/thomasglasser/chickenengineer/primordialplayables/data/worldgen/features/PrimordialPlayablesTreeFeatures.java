package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features;

import com.mojang.datafixers.util.Pair;
import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.PrimordialPlayablesProcessorLists;
import dev.thomasglasser.tommylib.api.world.level.levelgen.feature.NbtFeatureConfig;
import dev.thomasglasser.tommylib.api.world.level.levelgen.feature.TommyLibFeatures;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PrimordialPlayablesTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_MANGO = create("small_mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SMALL_MANGO = create("fancy_small_mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_MANGO = create("medium_mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_MANGO = create("large_mango");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, SMALL_MANGO, TommyLibFeatures.NBT_FEATURE.get(), new NbtFeatureConfig(false, false, 0, List.of(
                Pair.of(modLoc("mango_tree/small"), 1)), PrimordialPlayablesProcessorLists.SMALL_FRUITFUL_MANGO_TREE));
        FeatureUtils.register(context, FANCY_SMALL_MANGO, TommyLibFeatures.NBT_FEATURE.get(), new NbtFeatureConfig(false, false, 0, List.of(
                Pair.of(modLoc("mango_tree/fancy_small"), 1)), PrimordialPlayablesProcessorLists.SMALL_FRUITFUL_MANGO_TREE));
        FeatureUtils.register(context, MEDIUM_MANGO, TommyLibFeatures.NBT_FEATURE.get(), new NbtFeatureConfig(false, false, 0, List.of(
                Pair.of(modLoc("mango_tree/medium"), 1)), PrimordialPlayablesProcessorLists.MEDIUM_FRUITFUL_MANGO_TREE));
        FeatureUtils.register(context, LARGE_MANGO, TommyLibFeatures.NBT_FEATURE.get(), new NbtFeatureConfig(false, true, 0, List.of(
                Pair.of(modLoc("mango_tree/large"), 1)), PrimordialPlayablesProcessorLists.LARGE_FRUITFUL_MANGO_TREE));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, PrimordialPlayables.modLoc(name));
    }

    private static ResourceLocation modLoc(String name) {
        return PrimordialPlayables.modLoc(name);
    }
}
