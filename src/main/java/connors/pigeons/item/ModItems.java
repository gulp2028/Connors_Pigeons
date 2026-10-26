package connors.pigeons.item;

import connors.pigeons.Connorspigeons;
import connors.pigeons.item.custom.Pigeon_GloveItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item PIGEON_GLOVE = registerItem("pigeon_glove",
           properties -> new Pigeon_GloveItem(properties));


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, name)))));
    }
    public static void registerModItems() {
        Connorspigeons.LOGGER.info("Registering Mod Items for " + Connorspigeons.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
                    output.accept(PIGEON_GLOVE);
                }

        );

    }
}
