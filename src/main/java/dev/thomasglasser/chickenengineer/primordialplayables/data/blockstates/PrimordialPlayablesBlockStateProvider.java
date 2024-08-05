package dev.thomasglasser.chickenengineer.primordialplayables.data.blockstates;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.AgeingFruitfulLeavesBlock;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PrimordialPlayablesBlockStateProvider extends ExtendedBlockStateProvider {
    public PrimordialPlayablesBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PrimordialPlayables.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        woodSet(PrimordialPlayablesBlocks.MANGO_WOOD);
        leavesSet(PrimordialPlayablesBlocks.MANGO_LEAVES);
        getVariantBuilder(PrimordialPlayablesBlocks.FRUITFUL_MANGO_LEAVES.get())
                .forAllStates(state -> {
                    ResourceLocation loc = BuiltInRegistries.BLOCK.getKey(state.getBlock());
                    int age = state.getValue(AgeingFruitfulLeavesBlock.AGE);

                    String name = loc.getPath() + "_stage" + age;
                    return ConfiguredModel.builder()
                            .modelFile(models().leaves(name, modBlockModel(name)))
                            .build();
                });
    }
}
