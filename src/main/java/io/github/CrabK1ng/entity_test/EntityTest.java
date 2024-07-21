package io.github.CrabK1ng.entity_test;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityTest implements ModInitializer {
	public static final String MOD_ID = "test_entity";
	public static final String MOD_NAME = "Entity Test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info(EntityTest.MOD_NAME+" Initialized!");
	}
}

