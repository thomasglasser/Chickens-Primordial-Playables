package dev.thomasglasser.chickenengineer.primordialplayables.data.blockstates;

import com.google.gson.JsonElement;
import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.AgeingFruitfulLeavesBlock;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.function.TriFunction;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
                            .modelFile(age < AgeingFruitfulLeavesBlock.MAX_AGE ? models().leaves(name, modBlockModel(name)) : models().withExistingParent(name, modBlockModel(loc.getPath() + "_ripe"))
                                    .texture("0", modBlockModel(name))
                                    .texture("particle", modBlockModel(name)))
                            .build();
                });
        models().withExistingParent(PrimordialPlayablesBlocks.KUDZU.getId().getPath(), BuiltInRegistries.BLOCK.getKey(Blocks.GLOW_LICHEN).withPrefix("block/"))
                .renderType(RenderType.cutout().name)
                .texture("glow_lichen", modBlockModel(PrimordialPlayablesBlocks.KUDZU.getId().getPath()))
                .texture("particle", modBlockModel(PrimordialPlayablesBlocks.KUDZU.getId().getPath()));
    }

    @Override
    protected TriFunction<Consumer<BlockStateGenerator>, BiConsumer<ResourceLocation, Supplier<JsonElement>>, Consumer<Item>, ? extends ExtendedBlockModelGenerators> getBlockModelGenerators() {
        return PrimordialPlayablesBlockModelGenerators::new;
    }

    private class PrimordialPlayablesBlockModelGenerators extends ExtendedBlockModelGenerators {
        public PrimordialPlayablesBlockModelGenerators(Consumer<BlockStateGenerator> pBlockStateOutput, BiConsumer<ResourceLocation, Supplier<JsonElement>> pModelOutput, Consumer<Item> pSkippedAutoModelsOutput) {
            super(pBlockStateOutput, pModelOutput, pSkippedAutoModelsOutput);
        }

        @Override
        public void run() {
            createMultiface(PrimordialPlayablesBlocks.KUDZU.get());
        }
    }
}
