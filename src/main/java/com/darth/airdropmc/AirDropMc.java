package com.darth.airdropmc;
import org.slf4j.Logger;


import com.darth.airdropmc.blocks.ModBlocks;
import com.darth.airdropmc.blocks.entities.ModBlockEntities;
import com.darth.airdropmc.config.AirDropMcCommonConfigs;
import com.darth.airdropmc.items.ModItems;
import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AirDropMc.MOD_ID)
public class AirDropMc {
	public static final String MOD_ID ="airdropmc";
    public static final Logger LOGGER = LogUtils.getLogger();
	public AirDropMc() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.register(modEventBus);
		EntityManager.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModBlockEntities.register(modEventBus);
		ModLoadingContext.get().registerConfig(Type.COMMON, AirDropMcCommonConfigs.SPEC,"airdropmc-common.toml");
		
	}
	
}
