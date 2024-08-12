package dev.thomasglasser.chickenengineer.primordialplayables.data.worldgen;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.CappedProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosAlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class PrimordialPlayablesProcessorLists {
    public static final ResourceKey<StructureProcessorList> SMALL_FRUITFUL_MANGO_TREE = register("small_fruitful_mango_tree");
    public static final ResourceKey<StructureProcessorList> MEDIUM_FRUITFUL_MANGO_TREE = register("medium_fruitful_mango_tree");
    public static final ResourceKey<StructureProcessorList> LARGE_FRUITFUL_MANGO_TREE = register("large_fruitful_mango_tree");

    private static ResourceKey<StructureProcessorList> register(String path) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, PrimordialPlayables.modLoc(path));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> bootstapContext) {
        bootstapContext.register(SMALL_FRUITFUL_MANGO_TREE, new StructureProcessorList(List.of(
                randomReplacement(PrimordialPlayablesBlocks.MANGO_LEAVES.leaves().get(), PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(), 8, 12))));
        bootstapContext.register(MEDIUM_FRUITFUL_MANGO_TREE, new StructureProcessorList(List.of(
                randomReplacement(PrimordialPlayablesBlocks.MANGO_LEAVES.leaves().get(), PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(), 8, 16))));
        bootstapContext.register(LARGE_FRUITFUL_MANGO_TREE, new StructureProcessorList(List.of(
                randomReplacement(PrimordialPlayablesBlocks.MANGO_LEAVES.leaves().get(), PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get(), 18, 40))));
    }

    private static StructureProcessor randomReplacement(Block input, Block output, int min, int max) {
        return new CappedProcessor(new RuleProcessor(List.of(new ProcessorRule(new BlockMatchTest(input), AlwaysTrueTest.INSTANCE, PosAlwaysTrueTest.INSTANCE, output.defaultBlockState()))), UniformInt.of(min, max));
    }
}
