package dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.tags.PrimordialPlayablesBiomeTags;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure.pools.MangoTreePools;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public class PrimordialPlayablesStructures {
    public static final ResourceKey<Structure> SMALL_MANGO_TREE = createKey("small_mango_tree");
    public static final ResourceKey<Structure> MEDIUM_MANGO_TREE = createKey("medium_mango_tree");
    public static final ResourceKey<Structure> LARGE_MANGO_TREE = createKey("large_mango_tree");

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, PrimordialPlayables.modLoc(name));
    }

    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                SMALL_MANGO_TREE,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(holderGetter.getOrThrow(PrimordialPlayablesBiomeTags.HAS_MANGO_TREES))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        holderGetter2.getOrThrow(MangoTreePools.SMALL),
                        JigsawStructure.MAX_DEPTH,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        false,
                        Heightmap.Types.WORLD_SURFACE));
        context.register(
                MEDIUM_MANGO_TREE,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(holderGetter.getOrThrow(PrimordialPlayablesBiomeTags.HAS_MANGO_TREES))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        holderGetter2.getOrThrow(MangoTreePools.MEDIUM),
                        JigsawStructure.MAX_DEPTH,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        false,
                        Heightmap.Types.WORLD_SURFACE));
        context.register(
                LARGE_MANGO_TREE,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(holderGetter.getOrThrow(PrimordialPlayablesBiomeTags.HAS_MANGO_TREES))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        holderGetter2.getOrThrow(MangoTreePools.LARGE),
                        JigsawStructure.MAX_DEPTH,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        false,
                        Heightmap.Types.WORLD_SURFACE));
    }
}
