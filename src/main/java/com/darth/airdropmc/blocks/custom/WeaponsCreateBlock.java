package com.darth.airdropmc.blocks.custom;

import com.darth.airdropmc.blocks.entities.WeaponsCreateBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WeaponsCreateBlock extends BaseEntityBlock {

		public static final VoxelShape  SHAPE = Block.box(-6, 0, 2, 22, 6, 14);
	public WeaponsCreateBlock(Properties p_49224_) {
		super(p_49224_);
		// TODO Auto-generated constructor stub
	}
	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
		CollisionContext p_60558_) {
	// TODO Auto-generated method stub
	return SHAPE;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
	// TODO Auto-generated method stub
	return RenderShape.MODEL;
	}
	/*@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		// TODO Auto-generated method stub
		return super()
	}*/
	@Override
	public void onRemove(BlockState p_49076_, Level p_49077_, BlockPos p_49078_, BlockState p_49079_, boolean p_49080_) 
	{if (!p_49076_.is(p_49079_.getBlock())) {
	         BlockEntity blockentity = p_49077_.getBlockEntity(p_49078_);
	         if (blockentity instanceof Container) {
	            Containers.dropContents(p_49077_, p_49078_, (Container)blockentity);
	            p_49077_.updateNeighbourForOutputSignal(p_49078_, this);
	         }

	super.onRemove(p_49076_, p_49077_, p_49078_, p_49079_, p_49080_);}
	
	}
	@Override
	public InteractionResult use(BlockState p_49069_, Level p_49070_, BlockPos p_49071_, Player p_49072_, InteractionHand p_49073_, BlockHitResult p_49074_) {
	      if (p_49070_.isClientSide) {
	         return InteractionResult.SUCCESS;
	      } else {
	         BlockEntity blockentity = p_49070_.getBlockEntity(p_49071_);
	         if (blockentity instanceof WeaponsCreateBlockEntity) {
	            p_49072_.openMenu((WeaponsCreateBlockEntity)blockentity);
	            p_49072_.awardStat(Stats.OPEN_BARREL);
	            PiglinAi.angerNearbyPiglins(p_49072_, true);
	         }

	         return InteractionResult.CONSUME;
	      }
	   }
	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		// TODO Auto-generated method stub
		return new WeaponsCreateBlockEntity(p_153215_, p_153216_);
	}

}
