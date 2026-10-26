package connors.pigeons.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class MaxModel extends EntityModel<MaxRenderState> {
        private final ModelPart head;
        private final ModelPart right_arm;
        private final ModelPart left_arm;
        private final ModelPart left_leg;
        private final ModelPart right_leg;
        private final ModelPart body;

	public Max(ModelPart root) {
            this.head = root.getChild("head");
            this.right_arm = root.getChild("right_arm");
            this.left_arm = root.getChild("left_arm");
            this.left_leg = root.getChild("left_leg");
            this.right_leg = root.getChild("right_leg");
            this.body = root.getChild("body");
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

            return LayerDefinition.create(meshdefinition, 16, 16);
        }

        @Override
        public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}
