package net.desati.penguinese.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.desati.penguinese.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BucketItem.class)
public class BucketItemMixin {

    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;", ordinal = 0), cancellable = true)
    public void testing(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir, @Local BlockState state, @Local BlockHitResult hit) {
        System.out.println("1----");
        if (state.isOf(Blocks.SNOW_BLOCK)) {
            System.out.println("2----");

            ItemStack itemStack = new ItemStack(ModItems.MELTWATER_BUCKET);
            player.incrementStat(Stats.USED.getOrCreateStat((BucketItem)(Object)this));
            world.emitGameEvent(player, GameEvent.FLUID_PICKUP, hit.getBlockPos());
            ItemStack itemStack3 = ItemUsage.exchangeStack(player.getMainHandStack(), player, itemStack);
            world.setBlockState(hit.getBlockPos(), Blocks.AIR.getDefaultState());
            if (!world.isClient) {
                System.out.println("3----");
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack);

            }

            // Play the standard liquid bucket fill sound
            world.playSound(player, hit.getBlockPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
            cir.setReturnValue(TypedActionResult.success(itemStack3, world.isClient()));
        }
    }
}