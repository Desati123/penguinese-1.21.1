package net.desati.penguinese.item;

import net.desati.penguinese.Penguinese;
import net.desati.penguinese.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ICE_CUBE = registerItem("ice_cube", new Item(new Item.Settings().food(ModFoodComponents.ICE_CUBE)));
    public static final Item ICE_SHEET = registerItem("ice_sheet", new Item(new Item.Settings()));
    public static final Item ICE_SHARD = registerItem("ice_shard", new Item(new Item.Settings()));
    public static final Item PACKED_ICE_SHARD = registerItem("packed_ice_shard", new Item(new Item.Settings()));
    public static final Item BLUE_ICE_SHARD = registerItem("blue_ice_shard", new Item(new Item.Settings()));
    public static final Item BLACK_ICE_SHARD = registerItem("black_ice_shard", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));

    public static final Item BLACK_ICE = registerItem("black_ice", new BlockItem(ModBlocks.BLACK_ICE, new Item.Settings().rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Penguinese.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Penguinese.LOGGER.info("Registering Mod Items For " + Penguinese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ICE_CUBE);
            entries.add(ICE_SHEET);
            entries.add(ICE_SHARD);
            entries.add(PACKED_ICE_SHARD);
            entries.add(BLUE_ICE_SHARD);
            entries.add(BLACK_ICE_SHARD);

        });
    }
}
