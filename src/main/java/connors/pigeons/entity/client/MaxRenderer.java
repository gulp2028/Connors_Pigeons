package connors.pigeons.entity.client;

import connors.pigeons.Connorspigeons;
import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

public class MaxRenderer extends MobRenderer<MaxEntity, MaxRenderState, MaxModel> {
    public MaxRenderer(EntityRendererProvider.Context context) {
        super(context, new MaxModel(context.bakeLayer(ModModelLayerLocations.MAX)), 0.45f);
    }

    @Override
    public Identifier getTextureLocation(MaxRenderState state) {
        return Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, "textures/entity/max/max.png");
    }

    @Override
    public MaxRenderState createRenderState() {
        return new MaxRenderState();
    }

    @Override
    public void extractRenderState(MaxEntity entity, MaxRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }
}

