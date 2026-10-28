package connors.pigeons.entity.client;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class MaxOldModel extends EntityModel<MaxRenderState> {
        private final ModelPart Head;
        private final ModelPart right_arm;
        private final ModelPart left_arm;
        private final ModelPart left_leg;
        private final ModelPart right_leg;
        private final ModelPart body;

        private final KeyframeAnimation walkingAnimation;
        private final KeyframeAnimation idlingAnimation;

	public MaxOldModel(ModelPart root) {
        super(root);
            this.Head = root.getChild("head");
            this.right_arm = root.getChild("right_arm");
            this.left_arm = root.getChild("left_arm");
            this.left_leg = root.getChild("left_leg");
            this.right_leg = root.getChild("right_leg");
            this.body = root.getChild("body");
            this.walkingAnimation = MaxAnimations.WALK.bake(root);
            this.idlingAnimation = MaxAnimations.IDLE.bake(root);
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-8.0F, 13.0F, 0.0F));

            PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(4.0F, 14.0F, 0.0F));

            PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-4.0F, 20.0F, 0.0F));

            PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-2.0F, 15.0F, 0.0F));

            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        @Override
        public void setupAnim(MaxRenderState state) {
            this.root().getAllParts().forEach(ModelPart::resetPose);
            this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.6f);
            this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }
    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);




    }}
