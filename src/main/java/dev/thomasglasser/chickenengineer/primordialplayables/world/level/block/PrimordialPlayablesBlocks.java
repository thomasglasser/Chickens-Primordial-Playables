package dev.thomasglasser.chickenengineer.primordialplayables.world.level.block;

import dev.thomasglasser.chickenengineer.primordialplayables.PrimordialPlayables;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.tommylib.api.registration.DeferredBlock;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import dev.thomasglasser.tommylib.api.world.level.block.BlockUtils;
import dev.thomasglasser.tommylib.api.world.level.block.LeavesSet;
import dev.thomasglasser.tommylib.api.world.level.block.WoodSet;
import dev.thomasglasser.tommylib.api.world.level.block.grower.StructureGrower;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.List;
import java.util.function.Supplier;

public class PrimordialPlayablesBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PrimordialPlayables.MOD_ID);

    public static final WoodSet MANGO_WOOD = registerWoodSet("mango", MapColor.COLOR_ORANGE, MapColor.TERRACOTTA_ORANGE);
    public static final LeavesSet MANGO_LEAVES = registerLeavesSet("mango", new StructureGrower("mango", new Object2ObjectLinkedOpenHashMap<>() {
        {
            // TODO: Mango tree structures
            put((randomSource) -> true, BuiltinStructures.IGLOO);
        }
    }));
    public static final DeferredBlock<AgeingFruitfulLeavesBlock> FRUITFUL_MANGO_LEAVES = registerWithItem("fruitful_mango_leaves", () -> new AgeingFruitfulLeavesBlock(PrimordialPlayablesItems.UNRIPE_MANGO, PrimordialPlayablesItems.MANGO, BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .isValidSpawn((BlockState pState, BlockGetter pLevel, BlockPos pPos, EntityType<?> p_50825_) -> p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT)
            .isSuffocating((BlockState pState, BlockGetter pLevel, BlockPos pPos) -> false)
            .isViewBlocking((BlockState pState, BlockGetter pLevel, BlockPos pPos) -> false)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY)
            .isRedstoneConductor((BlockState pState, BlockGetter pLevel, BlockPos pPos) -> false)), List.of(CreativeModeTabs.NATURAL_BLOCKS));
    public static final DeferredBlock<SpreadingMultifaceBlock> KUDZU = registerWithItem("kudzu", () -> new SpreadingMultifaceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE)), List.of(CreativeModeTabs.NATURAL_BLOCKS));

    private static <T extends Block> DeferredBlock<T> registerWithItem(String name, Supplier<T> block, List<ResourceKey<CreativeModeTab>> tabs) {
        return BlockUtils.registerBlockAndItemAndWrap(BLOCKS, name, block, PrimordialPlayablesItems::register, tabs);
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        return BlockUtils.register(BLOCKS, name, block);
    }

    private static WoodSet registerWoodSet(String name, MapColor plankColor, MapColor logColor) {
        return BlockUtils.registerWoodSet(BLOCKS, name, plankColor, logColor, PrimordialPlayablesItems::register);
    }

    private static LeavesSet registerLeavesSet(String name, StructureGrower structureGrower) {
        return BlockUtils.registerLeavesSet(BLOCKS, name, structureGrower, PrimordialPlayablesItems::register);
    }

    public static void init() {}
}
