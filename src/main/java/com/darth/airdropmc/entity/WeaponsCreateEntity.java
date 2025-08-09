package com.darth.airdropmc.entity;

import com.darth.airdropmc.blocks.ModBlocks;
import com.darth.airdropmc.blocks.entities.ModBlockEntities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WeaponsCreateEntity extends AirDropEntity{

	public WeaponsCreateEntity(EntityType<? extends AirDropEntity> entityType, Level level) {
		super(entityType, level);
		// TODO Auto-generated constructor stub
	}
	public static AttributeSupplier.Builder createAttributes(){
		return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE,5d).add(Attributes.MAX_HEALTH,9999d);
	}
	@Override
	public BlockState getBlockStateToReplaceWith() {
		// TODO Auto-generated method stub
		return ModBlocks.WEAPONS_CREATE.get().defaultBlockState();
	}
	@Override
	public BlockEntityType<?> getBlockEntityToReplaceWith() {
		// TODO Auto-generated method stub
		return ModBlockEntities.WEAPONS_CREATE_BE.get();
	}

}
