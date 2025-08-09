package com.darth.airdropmc.entity.models;

import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.entity.AirDropEntity;
import com.darth.airdropmc.entity.WeaponsCreateEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class WeaponsCreateEntityRender extends MobRenderer<WeaponsCreateEntity, WeaponsCreateEntityModel<WeaponsCreateEntity>>{

	public WeaponsCreateEntityRender(Context context) {
		super(context, new WeaponsCreateEntityModel<>(context.bakeLayer(ModModelLayers.WEAPONS_CREATE_ENTITY_LAYER)),2f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getTextureLocation(WeaponsCreateEntity p_115812_) {
		// TODO Auto-generated method stub
		return new ResourceLocation(AirDropMc.MOD_ID,"textures/entity/weapons_create_entity.png");
	}
	@Override
	public void render(WeaponsCreateEntity p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_,
			MultiBufferSource p_115459_, int p_115460_) {
		// TODO Auto-generated method stub
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
	}


}
