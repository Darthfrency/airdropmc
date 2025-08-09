package com.darth.airdropmc.events;


import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.AirDropSpawner;
import com.darth.airdropmc.CallBackScheduler;
import com.darth.airdropmc.EntityManager;
import com.darth.airdropmc.config.AirDropMcCommonConfigs;

import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AirDropMc.MOD_ID, bus=Bus.FORGE)
public class ForgeEventBusEvents {
	public static long LASTTICK=0;
	@SubscribeEvent
	 public static void serverTickEvent(ServerTickEvent event)
    {

		ServerLevel overworld =event.getServer().getLevel(ServerLevel.OVERWORLD);
		if (LASTTICK== overworld.getGameTime()) {
			return;
		}
		LASTTICK=overworld.getGameTime();

		CallBackScheduler.run(overworld);
		if ((overworld.getGameTime()%(20*AirDropMcCommonConfigs.TIMEBETWEENAIRDROPS.get()) == 0)) {
			AirDropSpawner.spawn(overworld, EntityManager.WeaponsCreate.get());
			
		}
		
    }
	
}
