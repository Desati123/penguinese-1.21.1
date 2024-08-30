package net.desati.penguinese.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ICE_CUBE = new FoodComponent.Builder().nutrition(0).saturationModifier(0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1), 0.1f).build();
}
