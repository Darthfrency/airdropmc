package com.darth.airdropmc;

import com.darth.airdropmc.config.AirDropMcCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;


public class AirDropRaid {
    private final ServerLevel level;
    private final Vec2 center;
    private float totalHealth;
    private final ServerBossEvent bossBar = new ServerBossEvent(Component.literal("Libera la zona dai nemici per far atterrare l'airdrop"), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.NOTCHED_6);;
    private Status status =Status.WAITING;
    private final List<Entity> enemies = new ArrayList<Entity>();
    private boolean haveMobSpawned=false;
    private final EntityType<?> airdropType;
    private int ticks=0;
    private  List<Float> old_healths = new ArrayList<Float>();
    private int y;

    private static enum Status{
        WAITING,
        ONGOING,
        FINISHED
    }


    public AirDropRaid(ServerLevel level, Vec2 center,EntityType<?> airdropType){
        this.level=level;
        this.center=center;
        this.airdropType =airdropType;
        bossBar.setProgress(1f);
    }
    public boolean hasFinished(){
        return status == Status.FINISHED;
    }
    public void tick(){

        if (status == Status.FINISHED){
            return;
        }
        if (status == Status.WAITING){
            for (ServerPlayer serverPlayer : level.players())
                     {
                        Vec2 playerPos = new Vec2((float)serverPlayer.position().x,(float)serverPlayer.position().z);
                        if (playerPos.distanceToSqr(center)<1000){
                            status = Status.ONGOING;
                            bossBar.addPlayer(serverPlayer);
                            y = level.getHeight(Heightmap.Types.WORLD_SURFACE, (int) center.x, (int) center.y);
                            spawnMobs();
                            break;
                        }
                    }
            return;
        }
        if (ticks < 300){
            this.generateParticles();
        }
        if(!haveMobSpawned){
            return;
        }
        ticks++;
        updateBossBar();
        level.players().forEach(
                serverPlayer -> {
                    Vec2 playerpos = new Vec2((float)serverPlayer.position().x,(float)serverPlayer.position().z);
                    if (playerpos.distanceToSqr(center)<3000){
                        bossBar.addPlayer(serverPlayer);
                    }else{
                        bossBar.removePlayer(serverPlayer);
                    }
                });
        for (int i = 0; i < enemies.size(); i++){
            Entity enemy = enemies.get(i);
            Vec2 enemyPosition = new Vec2((float)enemy.position().x,(float)enemy.position().z);
            if (enemyPosition.distanceToSqr(center) >3000){
                enemies.remove(enemy);
            }
        }
        if(bossBar.getProgress() == 0f){
            postRaid();
        }

    }
    public void postRaid(){
        bossBar.setName(Component.literal("Airdrop in arrivo"));
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                bossBar.removeAllPlayers();
            }
        };
        timer.schedule(task,20000);
        SummonAirdropCallBack callback;
        int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, (int)center.x, (int)center.y);
        BlockPos airDropPos = new BlockPos((int)center.x,y+80,(int)center.y);
        callback = new SummonAirdropCallBack(airdropType, airDropPos);
        CallBackScheduler.registerCallBack(this.level, callback, (long)60);
        this.status =Status.FINISHED;
    }
    private void generateParticles(){
            level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                    (double) center.x + 0.5D,
                    y+0.5,
                    (double) center.y + 0.5D,
                    10, 0, 0.005D, 0, 0.02);

    }
    public void updateBossBar(){


        boolean shouldUpdateProgress = false;
        if (old_healths.size() != enemies.size()){
            shouldUpdateProgress=true;
            old_healths= new ArrayList<>();
            for (Entity e: enemies){
                Mob m =(Mob)e;
                old_healths.add(m.getHealth());
            }
        }else{
            for (int i=0; i<enemies.size();i++ ){
                if (((Mob)enemies.get(i)).getHealth() != old_healths.get(i)){
                    old_healths.set(i,((Mob) enemies.get(i)).getHealth());
                    shouldUpdateProgress=true;
                    break;
                }
            }

        }

        if (shouldUpdateProgress){
            bossBar.setProgress(Mth.clamp(this.getCurrentHealth() / this.totalHealth, 0.0F, 1.0F));
            AirDropMc.LOGGER.debug(Mth.clamp(this.getCurrentHealth() / this.totalHealth, 0.0F, 1.0F)+" "+ this.getCurrentHealth() +" "+ this.totalHealth);
        }

        if (enemies.size() < 10){
            bossBar.setName(Component.literal("Libera la zona dai nemici per far atterrare l'airdrop - "+ enemies.size() +" nemici rimasti"));
        }

    }
    public float getCurrentHealth(){
        float health = 0;
        for (int i = 0; i<enemies.size();i++){
            Entity e = enemies.get(i);
            if(!e.isAlive()){
                enemies.remove(e);
                continue;
            }
            if (e instanceof Mob m){
                health += m.getHealth();
            }
        }
        return health;
    }

    public void spawnMobs(){
        CompletableFuture.runAsync(
                ()->{
                    for (int i = 0; i< AirDropMcCommonConfigs.MOBFORSPAWN.get().size(); i++) {
                        int amount = AirDropMcCommonConfigs.AMOUNTTOSPAWN.get().get(i);
                        String mobName = AirDropMcCommonConfigs.MOBFORSPAWN.get().get(i);
                        for (int j = 0; j < amount; j++) {
                            float f = this.level.random.nextFloat() * ((float) Math.PI * 2F);
                            int newX = (int)this.center.x + Mth.floor(Mth.cos(f) * this.level.random.nextInt(16) )+ this.level.random.nextInt(5);
                            int newZ = (int)this.center.y + Mth.floor(Mth.sin(f) * this.level.random.nextInt(16) ) + this.level.random.nextInt(5);
                            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, newX, newZ);
                            BlockPos pos = new BlockPos(newX, y, newZ);
                            EntityType<?> entityType = EntityType.byString(mobName).get();
                            Entity entity = entityType.spawn(level, pos, MobSpawnType.TRIGGERED);
                            CompoundTag tag = new CompoundTag();
                            entity.saveWithoutId(tag);
                            tag.putBoolean("PersistenceRequired", true);
                            entity.load(tag);
                            enemies.add(entity);

                        }
                    }
                }
        ).thenRun(
                ()->{
                    for(Entity e :enemies){
                        if(e instanceof Mob m){
                               totalHealth+= m.getMaxHealth();
                        }
                    }
                    haveMobSpawned=true;
                }
        );

}
}
