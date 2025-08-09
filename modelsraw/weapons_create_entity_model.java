// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class weapons_create_entity_model<T extends weapons_create_entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "weapons_create_entity_model"), "main");
	private final ModelPart group;
	private final ModelPart group5;
	private final ModelPart group4;
	private final ModelPart group3;
	private final ModelPart group2;

	public weapons_create_entity_model(ModelPart root) {
		this.group = root.getChild("group");
		this.group5 = this.group.getChild("group5");
		this.group4 = this.group.getChild("group4");
		this.group3 = this.group4.getChild("group3");
		this.group2 = this.group4.getChild("group2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition group5 = group.addOrReplaceChild("group5", CubeListBuilder.create().texOffs(0, 8).addBox(-21.0F, -5.0F, 2.0F, 28.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-21.0F, -5.0F, 11.0F, 28.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(-20.0F, -5.0F, 5.0F, 26.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, -8.0F));

		PartDefinition group4 = group.addOrReplaceChild("group4", CubeListBuilder.create(), PartPose.offset(8.5F, -5.1679F, 5.125F));

		PartDefinition group3 = group4.addOrReplaceChild("group3", CubeListBuilder.create().texOffs(42, 23).addBox(-18.5F, -0.8321F, -10.125F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = group3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(43, 23).addBox(-9.0F, -4.9497F, 2.1213F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = group3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(43, 23).addBox(-9.0F, -4.9497F, -3.4749F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, 0.7854F, 0.0F, 0.0F));

		PartDefinition group2 = group4.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(42, 23).addBox(0.5F, -0.8321F, -10.125F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = group2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(43, 23).addBox(10.0F, -4.9497F, 2.1213F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r4 = group2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(43, 23).addBox(10.0F, -4.9497F, -3.4749F, 1.0F, 1.0F, 1.3536F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, 1.1679F, -5.125F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(weapons_create_entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}