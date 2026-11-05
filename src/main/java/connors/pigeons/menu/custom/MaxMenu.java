package connors.pigeons.menu.custom;

import connors.pigeons.entity.custom.MaxEntity;
import connors.pigeons.item.custom.StampItem;
import connors.pigeons.menu.ModMenuTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class MaxMenu extends AbstractContainerMenu {
    private Container maxContainer;
    public MaxEntity max;
    public static final MaxMenu create(int i, Inventory inventory, UUID uuid){
        List<MaxEntity> maxes = inventory.player.level().getEntitiesOfClass(MaxEntity.class,
                inventory.player.getBoundingBox().inflate(16), test -> test.getUUID().equals(uuid));
        MaxEntity maxEntity = maxes.isEmpty() ? null : maxes.getFirst();
        return new MaxMenu(i, inventory, new SimpleContainer(2), maxEntity, 2);
    }
    public MaxMenu(int containerId, Inventory inventory, Container maxContainer, final MaxEntity maxEntity, int columns) {
        super(ModMenuTypes.MAX_MENU, containerId);
        this.maxContainer = maxContainer;
        this.max = maxEntity;
        maxContainer.startOpen(inventory.player);
        //Stamp slot XD
        this.addSlot(new Slot(maxContainer, 0, 8, 63) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof StampItem;
            }
            @Override
            public int getMaxStackSize(){
                return 1;
        }});
        this.addSlot(new Slot(maxContainer, 1, 44, 63) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return true;
            }
        });


    }






    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return null;}
    @Override
    public boolean stillValid(Player player) {
        return !this.max.hasInventoryChanged(this.maxContainer)
                && this.maxContainer.stillValid(player)
                && this.max.isAlive()
                && player.isWithinEntityInteractionRange(this.max, 4.0);}
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.maxContainer.stopOpen(player);
    }}





