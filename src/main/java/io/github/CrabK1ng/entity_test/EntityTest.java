package io.github.CrabK1ng.entity_test;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import finalforeach.cosmicreach.GameAssetLoader;
import io.github.CrabK1ng.entity_test.entities.TestEntity;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import static finalforeach.cosmicreach.entities.EntityCreator.registerEntityCreator;

public class EntityTest implements ModInitializer {
	public static final String MOD_ID = "test_entity";
	public static final String MOD_NAME = "Entity Test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final List<String> MOB_NAMES = new ArrayList<>();

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info(EntityTest.MOD_NAME+" Initialized!");
		for (String mobName : EntityTest.MOB_NAMES) {
			System.out.println("mob:" + mobName);
		}
	}

	// add all mob names
	static {
		MOB_NAMES.add("test_entity");
	}
}

