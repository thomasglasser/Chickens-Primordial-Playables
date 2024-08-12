package dev.thomasglasser.chickenengineer.primordialplayables.tags;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class PrimordialPlayablesBiomeTags {
    public static final TagKey<Biome> HAS_MANGO_TREES = create("has_mango_trees");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, PrimordialPlayables.modLoc(name));
    }
}
