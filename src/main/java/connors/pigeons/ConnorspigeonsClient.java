package connors.pigeons;

import connors.pigeons.entity.ModEntities;
import connors.pigeons.entity.client.MaxRenderer;
import connors.pigeons.entity.client.ModModelLayerLocations;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ConnorspigeonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.MAX, MaxOldModel::createBodyLayer);
        EntityRenderers.register(ModEntities.MAX, MaxRenderer::new);

    }


}
