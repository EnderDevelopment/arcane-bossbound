package dev.fantasyfrontiers.registry;

import net.minecraft.world.food.FoodProperties;

public final class FantasyFood {
    public static final FoodProperties ARCANE_RATION = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    private FantasyFood() {}
}
