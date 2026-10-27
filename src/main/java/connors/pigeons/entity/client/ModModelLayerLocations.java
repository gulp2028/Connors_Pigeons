package connors.pigeons.entity.client;

import connors.pigeons.Connorspigeons;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayerLocations {
    public static final ModelLayerLocation MAX =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, "max"),
                    "main");

}
