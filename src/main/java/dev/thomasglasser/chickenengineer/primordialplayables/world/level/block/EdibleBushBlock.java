package dev.thomasglasser.chickenengineer.primordialplayables.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class EdibleBushBlock extends BushBlock {
    public static final MapCodec<EdibleBushBlock> CODEC = simpleCodec(EdibleBushBlock::new);

    private final int foodValue;
    private final boolean requireHerbivore;

    public EdibleBushBlock(int foodValue, boolean requireHerbivore, Properties properties) {
        super(properties);
        this.foodValue = foodValue;
        this.requireHerbivore = requireHerbivore;
    }

    public EdibleBushBlock(int foodValue, Properties properties) {
        this(foodValue, false, properties);
    }

    public EdibleBushBlock(Properties properties) {
        this(1, properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // TODO: Custom food system with foodValue
        if (!requireHerbivore || /*Check if herbivore*/true)
            player.getFoodData().eat(foodValue, 0F);
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
}
