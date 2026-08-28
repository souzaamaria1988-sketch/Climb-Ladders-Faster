package com.faststairs.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastStairsMod implements ModInitializer {
    public static final String MOD_ID = "fast-stairs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Fast Stairs mod initialized! Climb stairs 4x faster.");
    }
}
