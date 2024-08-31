package net.desati.penguinese.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlackIceBoost extends Block {
    public BlackIceBoost(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            // Apply the speed effect for 1 second (20 ticks)
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 2, false, false, true));
        }
        // Call the superclass method to ensure normal behavior is preserved
        super.onSteppedOn(world, pos, state, entity);
    }

    private void increaseBoatSpeed(BoatEntity boat) {
        double speedMultiplier = 10.0;
        boat.setVelocity(boat.getVelocity().multiply(speedMultiplier));
    }
}
