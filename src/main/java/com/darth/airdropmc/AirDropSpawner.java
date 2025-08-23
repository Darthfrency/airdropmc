package com.darth.airdropmc;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.TicketType;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.client.event.RenderTooltipEvent;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
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
    public static List<AirDropRaid> raids = new ArrayList<>();
	public static void spawn(ServerLevel overworld, EntityType<?> airdropType) {


		
		

		//
		//}
        CompletableFuture.runAsync(()->{
            BlockPos tempPos;
            int x = 0;
            int z = 0;
            int y = 0;
            int iterations=0;
            //noinspection ConstantValue
            while(iterations<10) {
                iterations++;
                x = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
                z = (int)((Math.random()-1)*AirDropMcCommonConfigs.AIRDROPSPAWNRANGE.get());
                tempPos = new BlockPos(x,100,z);
                ChunkPos chunkPos = overworld.getChunkAt(tempPos).getPos();
                ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, tempPos, chunkPos.x, chunkPos.z, true, false);

                boolean CanSpawn =false;
                for (int i=overworld.getMaxBuildHeight(); i > overworld.getMinBuildHeight(); i-- ){
                    tempPos= new BlockPos(x,i,z);
                    BlockState block =overworld.getBlockState(tempPos);
                    if(block.isAir()){
                        continue;
                    };
                    if(block.is(Blocks.WATER) || block.is(Blocks.LAVA)){
                        break;
                    }
                    CanSpawn=true;
                    break;
                }
                ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, tempPos, chunkPos.x, chunkPos.z, false, false);
                if(CanSpawn){
                    break;
                }
            }
            AirDropRaid raid = new AirDropRaid(overworld, new Vec2(x,z),airdropType);
            raids.add(raid);
            for( ServerPlayer player :overworld.getServer().getPlayerList().getPlayers()) {
                Component comp = Component.literal("\"Hai ricevuto un messaggio radio: <<Un pacco di approvigionamento sta atterrando alle coordinate X:"+x+" Z:"+z+">>").withStyle((Style)->Style.withColor(Color.MAGENTA.getRGB()));
                player.sendSystemMessage(comp);
            }
        });
        //CompletableFuture.runAsync(()->{
        //    BlockPos owner = new BlockPos(finX,0 , finZ);
        //    ChunkPos chunkPos= overworld.getChunkAt(owner).getPos();
        //    for(int i = 0; i<3; i++){
        //        for(int j= 0; j<3; j++){
        //            ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, owner, chunkPos.x+i-1, chunkPos.z+i-1, true, false);
        //            }
        //    }
        //    int y = overworld.getHeight(Types.WORLD_SURFACE, finX, finZ);
        //    AirDropMc.LOGGER.debug(y+"");
        //
        //

        //
        //    BlockPos tPos;
        //    for ( int i = 0; i< AirDropMcCommonConfigs.MOBFORSPAWN.get().size(); i++) {
        //        int amount = AirDropMcCommonConfigs.AMOUNTTOSPAWN.get().get(i);
        //        String mobName = AirDropMcCommonConfigs.MOBFORSPAWN.get().get(i);
        //        for (int j = 0; j < amount; j++) {
        //            int newX = finX + (int) (Math.random() * 15);
        //            int newZ = finZ + (int) (Math.random() * 15);
        //            tPos = new BlockPos(newX, 0, newZ);
        //            chunkPos = overworld.getChunkAt(tPos).getPos();
        //            y = overworld.getHeight(Types.WORLD_SURFACE, newX, newZ);
        //            BlockPos pos = new BlockPos(newX, y, newZ);
        //            EntityType<?> entityType = EntityType.byString(mobName).get();
        //            Entity entity = entityType.spawn(overworld, pos, MobSpawnType.TRIGGERED);
        //            CompoundTag tag = new CompoundTag();
        //            entity.saveWithoutId(tag);
        //            tag.putBoolean("PersistenceRequired", true);
        //            entity.load(tag);
        //        }
        //    }
        //    for(int i = 0; i<3; i++){
        //        for(int j= 0; j<3; j++){
        //            ForgeChunkManager.forceChunk(overworld, AirDropMc.MOD_ID, owner, chunkPos.x+i-1, chunkPos.z+i-1, false, false);
        //        }
        //    }
        //});

	}
    public static void tick()
    {
        for (int i = 0; i < raids.size();i++){
           AirDropRaid raid = raids.get(i);
           if (raid.hasFinished()){
               raids.remove(raid);
               continue;
           }
           raid.tick();
        }
    }
    private static boolean isBiomeSuitable(@NotNull Holder<Biome> biome){
        AirDropMc.LOGGER.debug(biome.get().toString());
        boolean condition=  biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_RIVER);
        return !condition;
    }
}
