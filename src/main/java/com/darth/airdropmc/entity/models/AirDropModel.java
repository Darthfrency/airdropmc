package com.darth.airdropmc.entity.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class AirDropModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart AirDrop;
	private final ModelPart parachute;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart cable2;
	private final ModelPart cable3;
	private final ModelPart cable;
	private final ModelPart cable4;

	public AirDropModel(ModelPart root) {
		this.AirDrop = root.getChild("AirDrop");
		this.parachute = this.AirDrop.getChild("parachute");
		this.bone = this.parachute.getChild("bone");
		this.bone2 = this.parachute.getChild("bone2");
		this.cable2 = this.AirDrop.getChild("cable2");
		this.cable3 = this.AirDrop.getChild("cable3");
		this.cable = this.AirDrop.getChild("cable");
		this.cable4 = this.AirDrop.getChild("cable4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition AirDrop = partdefinition.addOrReplaceChild("AirDrop", CubeListBuilder.create().texOffs(96, 8).addBox(-8.0F, 27.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

		PartDefinition parachute = AirDrop.addOrReplaceChild("parachute", CubeListBuilder.create().texOffs(0, 6).addBox(-20.0F, -0.5F, -4.0F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -48.5F, 1.0F));

		PartDefinition bone = parachute.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 60).addBox(-20.0F, -3.5887F, 11.4888F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0887F, 23.5112F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 96).addBox(-20.0F, -0.5F, -4.0F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2727F, -15.2658F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 87).addBox(-20.0F, -0.5F, -4.0F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.554F, -7.7964F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 78).addBox(-20.0F, -0.5F, -4.0F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5033F, -0.1185F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 69).addBox(-20.0F, -0.5F, -4.0F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.2348F, 7.6919F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone2 = parachute.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 15).addBox(-20.0F, -4.1807F, 11.3773F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.6807F, -23.3773F));

		PartDefinition cube_r5 = bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-20.0F, -1.6191F, 4.0125F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-20.0F, -1.6191F, -3.9875F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 42).addBox(-20.0F, -1.9604F, -11.8312F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 51).addBox(-20.0F, -2.9841F, -19.6153F, 40.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cable2 = AirDrop.addOrReplaceChild("cable2", CubeListBuilder.create(), PartPose.offset(-9.5649F, -10.245F, -28.888F));

		PartDefinition cube_r8 = cable2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(96, 42).addBox(-11.7702F, -0.5F, -0.5F, 23.5404F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6725F, -18.7763F, -8.8818F, -1.5851F, 0.2812F, -1.6686F));

		PartDefinition cube_r9 = cable2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 4).addBox(-25.5F, -0.5F, -0.5F, 51.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.814F, 17.7485F, 9.0562F, -1.7574F, 0.5495F, -1.8219F));

		PartDefinition cube_r10 = cable2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(96, 48).addBox(-3.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2668F, -6.1456F, -5.0448F, -1.7173F, 0.3846F, -1.7415F));

		PartDefinition cable3 = AirDrop.addOrReplaceChild("cable3", CubeListBuilder.create(), PartPose.offset(9.5649F, -10.245F, 29.888F));

		PartDefinition cube_r11 = cable3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(96, 44).addBox(-11.7702F, -0.5F, -0.5F, 23.5404F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1214F, -18.5088F, 9.948F, 2.0214F, 0.2812F, 1.6686F));

		PartDefinition cube_r12 = cable3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 2).addBox(-32.5F, -0.5F, -0.5F, 65.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8786F, 18.5088F, -9.948F, 1.7309F, 0.5571F, 1.7714F));

		PartDefinition cable = AirDrop.addOrReplaceChild("cable", CubeListBuilder.create(), PartPose.offset(-9.5649F, -10.245F, 29.888F));

		PartDefinition cube_r13 = cable.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(96, 40).addBox(-11.7702F, -0.5F, -0.5F, 23.5404F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1214F, -18.5088F, 9.948F, 2.0214F, -0.2812F, -1.6686F));

		PartDefinition cube_r14 = cable.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-32.5F, -0.5F, -0.5F, 65.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8786F, 18.5088F, -9.948F, 1.7309F, -0.5571F, -1.7714F));

		PartDefinition cable4 = AirDrop.addOrReplaceChild("cable4", CubeListBuilder.create(), PartPose.offset(9.5649F, -10.245F, -27.888F));

		PartDefinition cube_r15 = cable4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(96, 46).addBox(-11.7702F, -0.5F, -0.5F, 23.5404F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1214F, -18.5088F, -9.948F, -2.0214F, -0.2812F, 1.6686F));

		PartDefinition cube_r16 = cable4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 6).addBox(-32.5F, -0.5F, -0.5F, 49.4435F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8786F, 18.5088F, 9.948F, -1.7309F, -0.5571F, 1.7714F));

		PartDefinition cube_r17 = cable4.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(96, 50).addBox(-2.7218F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5413F, 34.3292F, 19.6391F, -1.7128F, -0.2982F, 1.7282F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		AirDrop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		// TODO Auto-generated method stub
		return AirDrop;
	}
}