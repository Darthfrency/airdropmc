package com.darth.airdropmc.entity;
import java.util.Random;
import java.util.random.RandomGenerator;

import com.darth.airdropmc.AirDropMc;

import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.MobSpawnEvent.AllowDespawn;

public class AirDropEntity extends Mob{
	
	private static float BASE_FALL_SPEED = 0.09f;
	private static float BASE_TERMINAL_VEL=0.2f;
	private static float ACCELERATED_TERMINAL_VEL=0.5f;
	private static float ACCELERATED_FALL_SPEED = 0.2f;
	private float speed;
	private float current_terminal_vel;
	private boolean shouldBeDestroyed = false;
	public AirDropEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
        this.speed= BASE_FALL_SPEED;
        this.current_terminal_vel = BASE_TERMINAL_VEL;
    }

	public static AttributeSupplier.Builder createAttributes(){
		return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE,5d).add(Attributes.MAX_HEALTH,9999d);
	}
	
	public BlockState getBlockStateToReplaceWith() {
		return Blocks.BARREL.defaultBlockState();
	}
	public BlockEntityType<?> getBlockEntityToReplaceWith() {
		return BlockEntityType.BARREL;
	}
	public String getLootTableId() {
		return "airdroploot_table";
	}
	@Override
	public void tick() {
		super.tick(); 
		
		if (onGround())
		{
			this.setDeltaMovement(0,0,0);
			BlockState state = getBlockStateToReplaceWith();
			BlockPos pos = new BlockPos((int) Math.floor(this.position().x), (int)Math.floor(this.position().y),(int)Math.floor(this.position().z));
			this.level().setBlockAndUpdate(pos,state);
			BlockEntity entity =  level().getBlockEntity(pos, getBlockEntityToReplaceWith()).get();
			if (entity instanceof RandomizableContainerBlockEntity) {
				((RandomizableContainerBlockEntity)entity).setLootTable(new ResourceLocation(AirDropMc.MOD_ID,getLootTableId()),java.time.Instant.now().getEpochSecond());
			}
			this.playBlockFallSound();
			this.setPos(this.position().x,-100,this.position().z);
			shouldBeDestroyed = true;
			return;
		}
		if (Math.abs(getDeltaMovement().y)>= this.current_terminal_vel) {
			this.setDeltaMovement(getDeltaMovement().x, -this.current_terminal_vel, getDeltaMovement().z);
			return;
		}
		this.addDeltaMovement(new Vec3(0, -speed, 0));
		if (shouldBeDestroyed)
			this.kill();
	}
	
	@Override
	public void handleDamageEvent(DamageSource source) {
		if (source.getEntity() instanceof Player) 
		{
			 this.speed = ACCELERATED_FALL_SPEED;
		}
	}
	@Override
	public boolean isPersistenceRequired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isNoGravity() {
		return true;
	}
	@Override
	public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
		return false;
	}
}
