package io.github.CrabK1ng.entity_test;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import finalforeach.cosmicreach.blockevents.BlockEvents;
import finalforeach.cosmicreach.blocks.Block;
import io.github.CrabK1ng.entity_test.blockevents.SpawnMob;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityTest implements ModInitializer {
	public static final String MOD_ID = "test_entity";
	public static final Logger LOGGER = LoggerFactory.getLogger("Entity Test");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Entity Test Initialized!");
		BlockEvents.registerBlockEventAction(SpawnMob.class);
		LOGGER.info("block_entity_spawn");
		Block.getInstance("block_entity_spawn");
		LOGGER.info("block_entity_spawn");
	}
}

