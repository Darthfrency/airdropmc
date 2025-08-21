package com.darth.airdropmc;

import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.RenderTooltipEvent;
import org.joml.Math;

import com.darth.airdropmc.config.AirDropMcCommonConfigs;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.common.world.ForgeChunkManager;

import java.awt.*;

public class AirDropSpawner {
	public static void spawn(ServerLevel overworld, EntityType<?> airdroptype) {
		BlockPos tempPos;
		ChunkPos chunkPos;
		SummonAirdropCallBack callback;
		int x = 0;
		int y = 0;
		int z = 0;
		int iterations =0;
		while(true) {
			iterations++;
			x = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
			z = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
			tempPos = new BlockPos(x,0,z);
			chunkPos = overworld.getChunkAt(tempPos).getPos();
			ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, tempPos, chunkPos.x, chunkPos.z, true, false);
			y = overworld.getHeight(Types.WORLD_SURFACE, x, z);
			AirDropMc.LOGGER.debug(""+y);
			if (iterations >=10) {
				//AirDropMc.LOGGER.debug("the airdrop spawn algorithm has hit the max spawn iterations");
				break;
			}
			if (overworld.getBlockState(new BlockPos(x, y-1, z)).is(Blocks.WATER)){

				//AirDropMc.LOGGER.debug("water block encountered");
				continue;
			}
			break;
		} 

		BlockPos airDropPos = new BlockPos(x,y+80,z);
		callback = new SummonAirdropCallBack(airdroptype, airDropPos);
		CallBackScheduler.registerCallBack(overworld, callback, 20*AirDropMcCommonConfigs.TIMETOWAITAFTERTHESPAWNOFTHEAIRDROP.get());
		
		
		for ( int i = 0; i< AirDropMcCommonConfigs.MOBFORSPAWN.get().size(); i++) {
			int amount = AirDropMcCommonConfigs.AMOUNTTOSPAWN.get().get(i);
			String mobname = AirDropMcCommonConfigs.MOBFORSPAWN.get().get(i);
			for(int j=0; j<amount; j++)
			{
				int newx = x+(int)(Math.random()*20);
				int newz = z+(int)(Math.random()*20);
				tempPos = new BlockPos(newx,0,newz);
				chunkPos= overworld.getChunkAt(tempPos).getPos();
				ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, tempPos, chunkPos.x, chunkPos.z, true, false);
				y = overworld.getHeight(Types.WORLD_SURFACE, newx, newz);
				BlockPos pos =new BlockPos(newx,y,newz);
				EntityType<?> entityType =EntityType.byString(mobname).get();
				Entity entity =entityType.spawn(overworld, pos, MobSpawnType.TRIGGERED);
				CompoundTag tag = new CompoundTag();
				entity.saveWithoutId(tag); 
				tag.putBoolean("PersistenceRequired", true);
				entity.load(tag);
			}
			
		}
		for( ServerPlayer player :overworld.getServer().getPlayerList().getPlayers()) {
            Component comp = Component.literal("\"Hai ricevuto un messaggio radio: <<Un pacco di approvigionamento sta atterrando alle coordinate X:"+x+" Z:"+z+">>").withStyle((Style)->Style.withColor(Color.MAGENTA.getRGB()));
			player.sendSystemMessage(comp);
		}
	}
}
