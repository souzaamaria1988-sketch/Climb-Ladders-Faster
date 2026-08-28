package com.faststairs.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastStairsMod implements ModInitializer {
    public static final String MOD_ID = "fast-stairs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Configuração da velocidade - altere este valor para mudar a velocidade ao subir escadas
    // 1.0 = velocidade normal, 2.0 = 2x mais rápido, 4.0 = 4x mais rápido, etc.
    public static final double STAIR_CLIMB_SPEED_MULTIPLIER = 4.0;

    @Override
    public void onInitialize() {
        LOGGER.info("=========================================");
        LOGGER.info("Fast Stairs Mod está inicializando...");
        LOGGER.info("ID do Mod: {}", MOD_ID);
        LOGGER.info("Velocidade de escalada configurada para: {}x", STAIR_CLIMB_SPEED_MULTIPLIER);
        LOGGER.info("Procurando por mixins de escada...");
        LOGGER.info("Fast Stairs Mod foi carregado com sucesso!");
        LOGGER.info("=========================================");
    }
}
