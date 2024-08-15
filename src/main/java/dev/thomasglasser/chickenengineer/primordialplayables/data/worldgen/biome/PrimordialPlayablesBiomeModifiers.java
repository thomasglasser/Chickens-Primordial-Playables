package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.biome;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.placement.PrimordialPlayablesVegetationPlacements;
import dev.thomasglasser.chickenengineer.primordialplayables.tags.PrimordialPlayablesBiomeTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class PrimordialPlayablesBiomeModifiers {
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(create("add_mango_trees"), new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(PrimordialPlayablesBiomeTags.HAS_MANGO_TREES), HolderSet.direct(placedFeatures.getOrThrow(PrimordialPlayablesVegetationPlacements.JUNGLE_SMALL_MANGO_TREES), placedFeatures.getOrThrow(PrimordialPlayablesVegetationPlacements.JUNGLE_MEDIUM_MANGO_TREES), placedFeatures.getOrThrow(PrimordialPlayablesVegetationPlacements.JUNGLE_LARGE_MANGO_TREES)), GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> create(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PrimordialPlayables.modLoc(name));
    }
}
