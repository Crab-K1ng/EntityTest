package io.github.CrabK1ng.entity_test;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;


public class EntityTest implements ModInitializer {
	public static final String MOD_ID = "test_entity";
	public static final String MOD_NAME = "Entity Test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final List<String> MOB_ID = new ArrayList<>();

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info(EntityTest.MOD_NAME+" Initialized!");
		for (String mobName : EntityTest.MOB_ID) {
			LOGGER.info("mob: "+mobName+" add");
		}
	}
	// add all mob names
	static {
		MOB_ID.add("test_entity");
	}
}

