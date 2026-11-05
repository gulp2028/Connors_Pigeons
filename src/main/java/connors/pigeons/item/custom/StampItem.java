package connors.pigeons.item.custom;

import connors.pigeons.item.ModItems;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;

import java.util.UUID;


public class StampItem extends Item {
    public StampItem(Properties properties){
        super(properties);
    }
    @Override
    public void onCraftedBy(ItemStack itemStack, Player crafter){
        super.onCraftedBy(itemStack, crafter);
        CompoundTag tag = new CompoundTag();
        tag.putString("Recipient", crafter.getUUID().toString());
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal("Stamp of:" + crafter.getName().getString()));

        int colour = crafter.getUUID().hashCode() & 0xFFFFFF;
        itemStack.set(DataComponents.DYED_COLOR,
                new DyedItemColor(colour));
        }

    }




