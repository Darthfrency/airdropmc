package com.darth.airdropmc.events;


import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.EntityManager;
import com.darth.airdropmc.entity.AirDropEntity;
import com.darth.airdropmc.entity.WeaponsCreateEntity;


import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AirDropMc.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	public static int numberOfTicks=0;
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityManager.AirDrop.get(), AirDropEntity.createAttributes().build());
		event.put(EntityManager.WeaponsCreate.get(), WeaponsCreateEntity.createAttributes().build());
	}
	
	
}
