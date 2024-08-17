package io.github.CrabK1ng.entity_test;


import com.github.puzzle.loader.entrypoint.interfaces.ModInitializer;
import com.github.puzzle.loader.mod.ModLocator;
import io.github.CrabK1ng.entity_menu.MobMenuRegistry;
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
	public void onInit() {
		LOGGER.info(EntityTest.MOD_NAME+" Initialized!");
		if (ModLocator.isModLoaded("entity_menu")){
			MobMenuRegistry.registerMobButton("Test Entity", "test_entity:test_entity");
		}
		for (String mobName : EntityTest.MOB_ID) {
			LOGGER.info("mob: "+mobName+" add");
		}
	}
	// add all mob names
	static {
		MOB_ID.add("test_entity");
	}
}

