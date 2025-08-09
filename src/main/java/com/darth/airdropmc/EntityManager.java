package com.darth.airdropmc;

import com.darth.airdropmc.entity.AirDropEntity;
import com.darth.airdropmc.entity.WeaponsCreateEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityManager {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AirDropMc.MOD_ID);

	
	
	public static final RegistryObject<EntityType<AirDropEntity>> AirDrop = ENTITY_TYPES.register("airdrop", () -> EntityType.Builder.of(AirDropEntity::new, MobCategory.MISC).sized(1f, 2f).fireImmune().canSpawnFarFromPlayer().build("airdrop"));
	public static final RegistryObject<EntityType<WeaponsCreateEntity>> WeaponsCreate = ENTITY_TYPES.register("weapons_create", ()-> EntityType.Builder.of(WeaponsCreateEntity::new,MobCategory.MISC).sized(1f, 2f).fireImmune().canSpawnFarFromPlayer().build("weapons_create"));
	public static void register(IEventBus eventbus) {	
		ENTITY_TYPES.register(eventbus);
	}

}