package net.desati.penguinese;

import net.desati.penguinese.block.ModBlocks;
import net.desati.penguinese.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Penguinese implements ModInitializer {
	public static final String MOD_ID = "penguinese";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}