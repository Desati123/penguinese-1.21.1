package net.desati.penguinese.block;

import net.desati.penguinese.Penguinese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModBlocks {
    public static final Block BLACK_ICE = registerBlock("black_ice",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f,2.5f)
                    .sounds(BlockSoundGroup.GLASS)
                    .mapColor(MapColor.TERRACOTTA_BLACK)
                    .slipperiness(0.99F)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Penguinese.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Penguinese.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Penguinese.LOGGER.info("Registering Mod Blocks for " + Penguinese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.BLACK_ICE);
        });
    }
}
