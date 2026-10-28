package connors.pigeons.menu.custom;

import connors.pigeons.Connorspigeons;
import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.UUID;

public class MaxScreen extends Screen {
    public MaxEntity max;
    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, "textures/entity/max/gui/max_gui.png");


    public MaxScreen(MaxMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.max = menu.max;
    }
    @Override
    protected void init(){
        titleLabelX = 72;
        titleLabelY = 12;
        inventoryLabelX = 1000;
    }
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractBackground(graphics, mouseX, mouseY, partialTick);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
}
