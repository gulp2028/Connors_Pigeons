package connors.pigeons.entity.client;

import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

public class MaxRenderer extends MobRenderer<MaxEntity, MaxRenderState, MaxModel> {
    public MaxRenderer(EntityRendererProvider.Context context, MaxModel model, float shadow) {
        super(context, model, shadow);
    }

    @Override
    public Identifier getTextureLocation(MaxRenderState state) {
        return null;
    }

    @Override
    public MaxRenderState createRenderState() {
        return null;
    }
}

