package net.desati.penguinese.item.custom;

import net.desati.penguinese.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Meltwater_BucketItem extends BucketItem {

    public Meltwater_BucketItem(Settings settings) {
        super(null, settings); // You can change the block here to the snow block
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        System.out.println("Meltwater_BucketItem: useOnBlock called!"); // Debugging output

        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = context.getStack();
        Direction direction = context.getSide();
        BlockPos targetPos = blockPos.offset(direction);

//        // Check if the block is a snow block
//        if (world.getBlockState(blockPos).isOf(Blocks.SNOW_BLOCK)) {
//            // Replace the snow block with air
//            world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
//
//            // Give the player a meltwater bucket
//            if (player != null) {
//                ItemStack filledBucket = new ItemStack(ModItems.MELTWATER_BUCKET);
//                itemStack.decrement(1);
//                if (!player.giveItemStack(filledBucket)) {
//                    player.dropItem(filledBucket, false);
//                }
//            }
//
//            world.playSound(player, blockPos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            player.incrementStat(Stats.USED.getOrCreateStat(ModItems.MELTWATER_BUCKET));
//
//            return ActionResult.success(world.isClient());
//        }
//        // Check if the player is trying to place the snow block back down
//        else
        if (itemStack.isOf(ModItems.MELTWATER_BUCKET) && world.isAir(targetPos)) {
            // Place the snow block
            world.setBlockState(targetPos, Blocks.SNOW_BLOCK.getDefaultState());

            // Remove one filled bucket from the player's inventory and give them an empty bucket (if applicable)
            itemStack.decrement(1);
            ItemStack emptyBucket = new ItemStack(Items.BUCKET);
            if (!player.giveItemStack(emptyBucket)) {
                player.dropItem(emptyBucket, false);
            }

            world.playSound(player, targetPos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.incrementStat(Stats.USED.getOrCreateStat(this));

            return ActionResult.success(world.isClient());
        }

        return super.useOnBlock(context);
    }
}