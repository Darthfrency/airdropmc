package com.darth.airdropmc.entity.models;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class WeaponsCreateEntityModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Model;
	private final ModelPart parachute;
	private final ModelPart bone5;
	private final ModelPart bone4;
	private final ModelPart cacca;
	private final ModelPart vertices2;
	private final ModelPart bone3;
	private final ModelPart vertices;
	private final ModelPart bone;
	private final ModelPart group;
	private final ModelPart group5;
	private final ModelPart group4;
	private final ModelPart group3;
	private final ModelPart group2;

	public WeaponsCreateEntityModel(ModelPart root) {
		this.Model = root.getChild("Model");
		this.parachute = this.Model.getChild("parachute");
		this.bone5 = this.parachute.getChild("bone5");
		this.bone4 = this.bone5.getChild("bone4");
		this.cacca = this.Model.getChild("cacca");
		this.vertices2 = this.Model.getChild("vertices2");
		this.bone3 = this.vertices2.getChild("bone3");
		this.vertices = this.Model.getChild("vertices");
		this.bone = this.vertices.getChild("bone");
		this.group = this.vertices.getChild("group");
		this.group5 = this.group.getChild("group5");
		this.group4 = this.group.getChild("group4");
		this.group3 = this.group4.getChild("group3");
		this.group2 = this.group4.getChild("group2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Model = partdefinition.addOrReplaceChild("Model", CubeListBuilder.create(), PartPose.offset(0.0F, -67.5F, 1.0F));

		PartDefinition parachute = Model.addOrReplaceChild("parachute", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone5 = parachute.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 58.5739F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r1 = bone5.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -2.3308F, 7.6408F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 20).addBox(-11.0F, -2.3308F, 3.6408F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7431F, 12.3592F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r2 = bone5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -1.4876F, 0.059F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 20).addBox(-11.0F, -1.4876F, -3.941F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7431F, 12.3592F, -2.9234F, 0.0F, -3.1416F));

		PartDefinition cube_r3 = bone5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -1.8254F, -7.7963F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7431F, 12.3592F, -2.8362F, 0.0F, -3.1416F));

		PartDefinition cube_r4 = bone5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -2.4979F, -11.6076F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7431F, 12.3592F, -2.7489F, 0.0F, -3.1416F));

		PartDefinition bone4 = bone5.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -3.0739F, -7.0F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 20).addBox(-11.0F, -3.0739F, -3.0F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bone4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -1.6191F, 8.0125F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1068F, -18.3773F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -1.6191F, 0.0125F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.241F, -14.4721F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -1.9604F, -7.8312F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6247F, -10.5669F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(2, 20).addBox(-11.0F, -2.9841F, -15.6153F, 22.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8276F, -6.7521F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cacca = Model.addOrReplaceChild("cacca", CubeListBuilder.create(), PartPose.offset(14.2053F, 85.8949F, -6.9209F));

		PartDefinition cube_r9 = cacca.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(61, 13).mirror().addBox(0.0F, -27.5F, 0.0F, 1.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.4107F, 0.0F, 0.0F, 2.5333F, -1.2528F, -2.9022F));

		PartDefinition cube_r10 = cacca.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(61, 13).mirror().addBox(-1.0F, -27.5F, 0.0F, 1.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 0.0F, 11.1F, -0.324F, 1.0678F, -0.0061F));

		PartDefinition cube_r11 = cacca.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(61, 13).mirror().addBox(0.0F, -27.5F, 0.0F, 1.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.6107F, 0.0F, 11.1F, -0.3658F, -1.0772F, -0.0258F));

		PartDefinition cube_r12 = cacca.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(61, 13).addBox(-1.0F, -27.5F, 0.0F, 1.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.5233F, 1.2413F, 2.8272F));

		PartDefinition vertices2 = Model.addOrReplaceChild("vertices2", CubeListBuilder.create(), PartPose.offset(1.0F, 57.5086F, -1.0F));

		PartDefinition bone3 = vertices2.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition vertices = Model.addOrReplaceChild("vertices", CubeListBuilder.create(), PartPose.offset(-1.0F, 57.5086F, -1.0F));

		PartDefinition bone = vertices.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition group = vertices.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offset(1.0F, 33.9914F, 0.0F));

		PartDefinition group5 = group.addOrReplaceChild("group5", CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -5.0F, 2.0F, 28.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-21.0F, -5.0F, 11.0F, 28.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-20.0F, -5.0F, 5.0F, 26.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, -8.0F));

		PartDefinition group4 = group.addOrReplaceChild("group4", CubeListBuilder.create(), PartPose.offset(8.5F, -5.1679F, 5.125F));

		PartDefinition group3 = group4.addOrReplaceChild("group3", CubeListBuilder.create().texOffs(11, 33).addBox(-18.5F, -0.8321F, -10.125F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = group3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(52, 29).addBox(-9.0F, -4.9497F, 2.1213F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = group3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(52, 29).addBox(-9.0F, -4.9497F, -3.4749F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, 0.7854F, 0.0F, 0.0F));

		PartDefinition group2 = group4.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(11, 33).addBox(0.5F, -0.8321F, -10.125F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = group2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(52, 29).addBox(10.0F, -4.9497F, 2.1213F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r16 = group2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(52, 29).addBox(10.0F, -4.9497F, -3.4749F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Model.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		// TODO Auto-generated method stub
		return Model;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}
}