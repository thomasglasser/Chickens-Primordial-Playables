package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.features.PrimordialPlayablesTreeFeatures;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PrimordialPlayablesTreePlacements {
    public static final ResourceKey<PlacedFeature> SMALL_MANGO_CHECKED = create("small_mango_checked");
    public static final ResourceKey<PlacedFeature> MEDIUM_MANGO_CHECKED = create("medium_mango_checked");
    public static final ResourceKey<PlacedFeature> LARGE_MANGO_CHECKED = create("large_mango_checked");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, SMALL_MANGO_CHECKED, features.getOrThrow(PrimordialPlayablesTreeFeatures.SMALL_MANGO), PlacementUtils.filteredByBlockSurvival(PrimordialPlayablesBlocks.MANGO_LEAVES.sapling().get()));
        PlacementUtils.register(context, MEDIUM_MANGO_CHECKED, features.getOrThrow(PrimordialPlayablesTreeFeatures.MEDIUM_MANGO), PlacementUtils.filteredByBlockSurvival(PrimordialPlayablesBlocks.MANGO_LEAVES.sapling().get()));
        PlacementUtils.register(context, LARGE_MANGO_CHECKED, features.getOrThrow(PrimordialPlayablesTreeFeatures.LARGE_MANGO), PlacementUtils.filteredByBlockSurvival(PrimordialPlayablesBlocks.MANGO_LEAVES.sapling().get()));
    }

    private static ResourceKey<PlacedFeature> create(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, PrimordialPlayables.modLoc(pKey));
    }
}
