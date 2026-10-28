package connors.pigeons.menu.custom;

import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.UUID;

public class MaxMenu extends Screen {
    public MaxEntity max;

    protected MaxMenu(Component title) {
        super(title);
    }



    public static MaxMenu create(int i, Inventory inventory, UUID uuid) {
        List<MaxEntity> turtles = inventory.player.level().getEntitiesOfClass(MaxEntity.class,
                inventory.player.getBoundingBox().inflate(16), test -> test.getUUID().equals(uuid));
        MaxEntity maxEntity = turtles.isEmpty() ? null : turtles.getFirst();
        return new MaxMenu(i, inventory, new SimpleContainer(28), maxEntity, 4);

}}
