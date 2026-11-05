package connors.pigeons.menu.custom;

import connors.pigeons.Connorspigeons;
import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public class MaxScreen extends AbstractContainerScreen<MaxMenu> {

    public MaxScreen(MaxMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.max = menu.max;
    }
    @Override
    protected void init() {
        super.init();
        titleLabelX = 72;
        titleLabelY = 12;

        inventoryLabelX = 1000;
    }

    public MaxScreen(MaxMenu menu, Inventory inventory, Component title, int imageWidth, int imageHeight) {
        super(menu, inventory, title, imageWidth, imageHeight);
    }
}
