package connors.pigeons.menu;

import connors.pigeons.Connorspigeons;
import connors.pigeons.menu.custom.MaxMenu;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.Registry;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {
    public static final MenuType<MaxMenu> MAX_MENU =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID,
                            "max_menu"),
                    new ExtendedMenuType<>(MaxMenu::create, UUIDUtil.STREAM_CODEC));

    public static void registerModMenuTypes(){
        Connorspigeons.LOGGER.info("Registering ModMenuTypes for " + Connorspigeons.MOD_ID);

    }
}
