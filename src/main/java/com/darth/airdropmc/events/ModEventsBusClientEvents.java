package com.darth.airdropmc.events;

import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.EntityManager;
import com.darth.airdropmc.entity.models.AirDropModel;
import com.darth.airdropmc.entity.models.AirDropRender;
import com.darth.airdropmc.entity.models.ModModelLayers;
import com.darth.airdropmc.entity.models.WeaponsCreateEntityModel;
import com.darth.airdropmc.entity.models.WeaponsCreateEntityRender;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=AirDropMc.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventsBusClientEvents {
	@SubscribeEvent
	public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModModelLayers.AIRDROP_LAYER, AirDropModel::createBodyLayer);

		event.registerLayerDefinition(ModModelLayers.WEAPONS_CREATE_ENTITY_LAYER, WeaponsCreateEntityModel::createBodyLayer);
		
	}
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(EntityManager.AirDrop.get(),AirDropRender::new);
		EntityRenderers.register(EntityManager.WeaponsCreate.get(),WeaponsCreateEntityRender::new);
	}
}
