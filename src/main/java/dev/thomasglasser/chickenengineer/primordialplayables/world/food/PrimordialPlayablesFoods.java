package dev.thomasglasser.chickenengineer.primordialplayables.world.food;

import net.minecraft.world.food.FoodProperties;

public class PrimordialPlayablesFoods {
    public static FoodProperties UNRIPE_MANGO = new FoodProperties.Builder().nutrition(2).build();
    public static FoodProperties MANGO = new FoodProperties.Builder().nutrition(6).saturationModifier(0.3f).build();
}
