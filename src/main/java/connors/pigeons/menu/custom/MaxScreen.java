package connors.pigeons.menu.custom;

import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class MaxScreen extends Screen {
    public MaxEntity max;

    protected MaxScreen(Component title) {
        super(title);
    }
}
