package connors.pigeons.menu.custom;

import connors.pigeons.Connorspigeons;
import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.UUID;

public class MaxScreen extends Screen {


    protected MaxScreen(Component title) {
        super(title);
    }

    protected MaxScreen(Minecraft minecraft, Font font, Component title) {
        super(minecraft, font, title);
    }
}
