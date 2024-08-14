package dev.thomasglasser.chickenengineer.primordialplayables.world.level.levelgen.structure.pools;

import static net.minecraft.data.worldgen.Pools.EMPTY;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen.PrimordialPlayablesProcessorLists;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class MangoTreePools {
    public static final ResourceKey<StructureTemplatePool> SMALL = PrimordialPlayablesPools.createKey("mango_tree/small");
    private static final ResourceLocation SMALL_1 = PrimordialPlayables.modLoc("mango_tree/small_1");
    private static final ResourceLocation SMALL_2 = PrimordialPlayables.modLoc("mango_tree/small_2");
    public static final ResourceKey<StructureTemplatePool> MEDIUM = PrimordialPlayablesPools.createKey("mango_tree/medium");
    public static final ResourceKey<StructureTemplatePool> LARGE = PrimordialPlayablesPools.createKey("mango_tree/large");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> bootstrapContext) {
        HolderGetter<StructureTemplatePool> holderGetter = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorLists = bootstrapContext.lookup(Registries.PROCESSOR_LIST);

        Holder<StructureTemplatePool> holder = holderGetter.getOrThrow(EMPTY);

        bootstrapContext.register(
                SMALL,
                new StructureTemplatePool(
                        holder, ImmutableList.of(Pair.of(StructurePoolElement.single(SMALL_1.toString(), processorLists.getOrThrow(PrimordialPlayablesProcessorLists.SMALL_FRUITFUL_MANGO_TREE)), 1), Pair.of(StructurePoolElement.single(SMALL_2.toString(), processorLists.getOrThrow(PrimordialPlayablesProcessorLists.SMALL_FRUITFUL_MANGO_TREE)), 1)), StructureTemplatePool.Projection.RIGID));
        bootstrapContext.register(
                MEDIUM,
                new StructureTemplatePool(
                        holder, ImmutableList.of(Pair.of(StructurePoolElement.single(MEDIUM.location().toString(), processorLists.getOrThrow(PrimordialPlayablesProcessorLists.MEDIUM_FRUITFUL_MANGO_TREE)), 1)), StructureTemplatePool.Projection.RIGID));
        bootstrapContext.register(
                LARGE,
                new StructureTemplatePool(
                        holder, ImmutableList.of(Pair.of(StructurePoolElement.single(LARGE.location().toString(), processorLists.getOrThrow(PrimordialPlayablesProcessorLists.LARGE_FRUITFUL_MANGO_TREE)), 1)), StructureTemplatePool.Projection.RIGID));
    }
}
