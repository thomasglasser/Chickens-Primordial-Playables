package dev.thomasglasser.chickenengineer.primordialplayables.world.level.block;

import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class AgeingLeavesBlock extends LeavesBlock implements BonemealableBlock {
    public static final int MAX_AGE = 2;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;

    private final DeferredItem<?> unripe;
    private final DeferredItem<?> ripe;

    public AgeingLeavesBlock(DeferredItem<?> unripe, DeferredItem<?> ripe, Properties properties) {
        super(properties);
        this.unripe = unripe;
        this.ripe = ripe;
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(DISTANCE, 7)
                        .setValue(PERSISTENT, Boolean.FALSE)
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(AGE, 0));
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(AGE) < MAX_AGE;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pState.getValue(AGE);
        if (i < MAX_AGE && pLevel.getRawBrightness(pPos.above(), 0) >= 9 && net.neoforged.neoforge.common.CommonHooks.canCropGrow(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
            BlockState blockstate = pState.setValue(AGE, i + 1);
            pLevel.setBlock(pPos, blockstate, Block.UPDATE_CLIENTS);
            net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(pLevel, pPos, pState);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        int i = pState.getValue(AGE);
        boolean flag = i == MAX_AGE;
        return !flag && pStack.is(Items.BONE_MEAL)
                ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION
                : super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        int i = pState.getValue(AGE);
        if (i > 0) {
            int j = pLevel.random.nextInt(3) + 1;
            popResource(pLevel, pPos, new ItemStack(getFruitForAge(i).get(), j));
            pLevel.playSound(
                    null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
            BlockState blockstate = pState.setValue(AGE, 0);
            pLevel.setBlock(pPos, blockstate, Block.UPDATE_CLIENTS);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return pState.getValue(AGE) < MAX_AGE;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        int i = Math.min(MAX_AGE, pState.getValue(AGE) + 1);
        pLevel.setBlock(pPos, pState.setValue(AGE, i), Block.UPDATE_CLIENTS);
    }

    public DeferredItem<?> getFruitForAge(int age) {
        return age == MAX_AGE ? ripe : unripe;
    }
}
