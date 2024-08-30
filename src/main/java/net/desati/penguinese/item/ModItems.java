package net.desati.penguinese.item;

import net.desati.penguinese.Penguinese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ICE_CUBE = registerItem("ice_cube", new Item(new Item.Settings().food(ModFoodComponents.ICE_CUBE)));
    public static final Item ICE_SHEET = registerItem("ice_sheet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Penguinese.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Penguinese.LOGGER.info("Registering Mod Items For " + Penguinese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ICE_CUBE);
            entries.add(ICE_SHEET);
        });
    }
}
