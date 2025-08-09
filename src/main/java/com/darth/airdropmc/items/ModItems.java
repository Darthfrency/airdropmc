package com.darth.airdropmc.items;

import com.darth.airdropmc.AirDropMc;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AirDropMc.MOD_ID);
	
	public static void register(IEventBus eventBus) {
		eventBus.register(ITEMS);
	}
	
	
	
	
}
