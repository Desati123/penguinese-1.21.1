package net.desati.penguinese.item;

import net.desati.penguinese.Penguinese;
import net.desati.penguinese.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PENGUINESE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Penguinese.MOD_ID, "penguinese_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ICE_CUBE))
                    .displayName(Text.translatable("itemgroup.penguinese.penguinese_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ICE_CUBE);
                        entries.add(ModItems.ICE_SHEET);
                        entries.add(ModItems.ICE_SHARD);
                        entries.add(ModItems.PACKED_ICE_SHARD);
                        entries.add(ModItems.BLUE_ICE_SHARD);
                        entries.add(ModItems.BLACK_ICE_SHARD);

                    }).build());

    public static final ItemGroup PENGUINESE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Penguinese.MOD_ID, "penguinese_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLACK_ICE))
                    .displayName(Text.translatable("itemgroup.penguinese.penguinese_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLACK_ICE);
                    }).build());


    public static void registerItemGroups() {
        Penguinese.LOGGER.info("Registering Item Groups for " + Penguinese.MOD_ID);
    }
}
