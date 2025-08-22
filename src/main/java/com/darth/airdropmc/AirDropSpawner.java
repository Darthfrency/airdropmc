package com.darth.airdropmc;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.LevelChunk;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AirDropSpawner {
	public static void spawn(ServerLevel overworld, EntityType<?> airdroptype) {
		BlockPos tempPos;
		int x = 0;
		int z = 0;
		int iterations=0;
		while(iterations<10) {
            iterations++;
			x = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
			z = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
			tempPos = new BlockPos(x,100,z);
			if (isBiomeSuitable(overworld.getBiome(tempPos))) {
                break;
            }

			break;
		} 

		
		

		//
		//}
        final int finx =x;
        final int finz =z;
        CompletableFuture.runAsync(()->{
            BlockPos owner = new BlockPos(finx,0 , finz);
            ChunkPos chunkPos= overworld.getChunkAt(owner).getPos();
            for(int i = 0; i<3; i++){
                for(int j= 0; j<3; j++){
                    ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, owner, chunkPos.x+i-1, chunkPos.z+i-1, true, false);
                    }
            }
            int y = overworld.getHeight(Types.WORLD_SURFACE, finx, finz);
            AirDropMc.LOGGER.debug(y+"");
            SummonAirdropCallBack callback;

            BlockPos airDropPos = new BlockPos(finx,y+80,finz);
            callback = new SummonAirdropCallBack(airdroptype, airDropPos);
            CallBackScheduler.registerCallBack(overworld, callback, (long)20*AirDropMcCommonConfigs.TIMETOWAITAFTERTHESPAWNOFTHEAIRDROP.get());

            BlockPos tPos;
            for ( int i = 0; i< AirDropMcCommonConfigs.MOBFORSPAWN.get().size(); i++) {
                int amount = AirDropMcCommonConfigs.AMOUNTTOSPAWN.get().get(i);
                String mobName = AirDropMcCommonConfigs.MOBFORSPAWN.get().get(i);
                for (int j = 0; j < amount; j++) {
                    int newx = finx + (int) (Math.random() * 15);
                    int newz = finz + (int) (Math.random() * 15);
                    tPos = new BlockPos(newx, 0, newz);
                    chunkPos = overworld.getChunkAt(tPos).getPos();
                    y = overworld.getHeight(Types.WORLD_SURFACE, newx, newz);
                    BlockPos pos = new BlockPos(newx, y, newz);
                    EntityType<?> entityType = EntityType.byString(mobName).get();
                    Entity entity = entityType.spawn(overworld, pos, MobSpawnType.TRIGGERED);
                    CompoundTag tag = new CompoundTag();
                    entity.saveWithoutId(tag);
                    tag.putBoolean("PersistenceRequired", true);
                    entity.load(tag);
                }
            }
            for(int i = 0; i<3; i++){
                for(int j= 0; j<3; j++){
                    ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, owner, chunkPos.x+i-1, chunkPos.z+i-1, false, false);
                }
            }
        });
		for( ServerPlayer player :overworld.getServer().getPlayerList().getPlayers()) {
            Component comp = Component.literal("\"Hai ricevuto un messaggio radio: <<Un pacco di approvigionamento sta atterrando alle coordinate X:"+x+" Z:"+z+">>").withStyle((Style)->Style.withColor(Color.MAGENTA.getRGB()));
			player.sendSystemMessage(comp);
		}
	}
    private static void SpawnLogic(){

    }
    private static boolean isBiomeSuitable(Holder<Biome> biome){
        boolean condition=  biome.is(Biomes.OCEAN)||
                biome.is(Biomes.DEEP_OCEAN) ||
                biome.is(Biomes.WARM_OCEAN) ||
                biome.is(Biomes.LUKEWARM_OCEAN) ||
                biome.is(Biomes.COLD_OCEAN) ||
                biome.is(Biomes.FROZEN_OCEAN) ||
                biome.is(Biomes.RIVER) ||
                biome.is(Biomes.FROZEN_RIVER);
        return !condition;
    }
}
