package dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure.placement;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure.PrimordialPlayablesStructures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class PrimordialPlayablesStructureSets {
    public static final ResourceKey<StructureSet> SMALL_MANGO_TREE = register("small_mango_tree");
    public static final ResourceKey<StructureSet> MEDIUM_MANGO_TREE = register("medium_mango_tree");
    public static final ResourceKey<StructureSet> LARGE_MANGO_TREE = register("large_mango_tree");

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> holderGetter = context.lookup(Registries.STRUCTURE);

        context.register(
                SMALL_MANGO_TREE,
                // The salt is the word "smango" numerically
                new StructureSet(holderGetter.getOrThrow(PrimordialPlayablesStructures.SMALL_MANGO_TREE), new RandomSpreadStructurePlacement(2, 0, RandomSpreadType.LINEAR, 1913114715)));
        context.register(
                MEDIUM_MANGO_TREE,
                // The salt is the words "memgo" numerically
                new StructureSet(holderGetter.getOrThrow(PrimordialPlayablesStructures.MEDIUM_MANGO_TREE), new RandomSpreadStructurePlacement(4, 2, RandomSpreadType.LINEAR, 13513715)));
        context.register(
                LARGE_MANGO_TREE,
                // The salt is the words "lango" numerically
                new StructureSet(holderGetter.getOrThrow(PrimordialPlayablesStructures.LARGE_MANGO_TREE), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 12114715)));
    }

    private static ResourceKey<StructureSet> register(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, PrimordialPlayables.modLoc(name));
    }
}
