package io.github.CrabK1ng.entity_test;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityTest implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Entity Test");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Entity Test Initialized!");
	}
}

