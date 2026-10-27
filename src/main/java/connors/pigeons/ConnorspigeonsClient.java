package connors.pigeons;

import connors.pigeons.entity.client.MaxModel;
import connors.pigeons.entity.client.ModModelLayerLocations;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ConnorspigeonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.MAX, MaxModel::createBodyLayer);
    }


}
