package com.darth.airdropmc.blocks.entities;

import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.blocks.ModBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AirDropMc.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<WeaponsCreateBlockEntity>> WEAPONS_CREATE_BE = BLOCK_ENTITIES.register("weapons_create_be", ()-> BlockEntityType.Builder.of(WeaponsCreateBlockEntity::new, ModBlocks.WEAPONS_CREATE.get()).build(null));
	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}
}
