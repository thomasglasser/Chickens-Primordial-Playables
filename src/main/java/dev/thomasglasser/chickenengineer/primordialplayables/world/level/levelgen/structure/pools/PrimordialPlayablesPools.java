package dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure.pools;

import com.google.common.collect.ImmutableList;
import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import static net.minecraft.data.worldgen.Pools.EMPTY;

public class PrimordialPlayablesPools {
    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, PrimordialPlayables.modLoc(name));
    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> holderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> holder = holderGetter.getOrThrow(EMPTY);
        context.register(EMPTY, new StructureTemplatePool(holder, ImmutableList.of(), StructureTemplatePool.Projection.RIGID));

        MangoTreePools.bootstrap(context);
    }
}
