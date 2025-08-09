package com.darth.airdropmc;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;

public class SummonAirdropCallBack extends DelayableCallBack {
	public EntityType<?> airDropEntityType;
	public BlockPos position;
	public SummonAirdropCallBack(EntityType<?> airDropEntityType,BlockPos position) 
		{
		
		this.airDropEntityType=airDropEntityType;
		this.position= position;
		}
	@Override
	public void call(ServerLevel level) {
		Entity ent = airDropEntityType.spawn(level, position,MobSpawnType.TRIGGERED);
		CompoundTag t = new CompoundTag();
		ent.saveWithoutId(t);
		t.putBoolean("PersistenceRequired", true);
		ent.load(t);
	}
}
