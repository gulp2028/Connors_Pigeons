package connors.pigeons.item.custom;

import connors.pigeons.item.ModItems;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class StampItem extends Item {
    public StampItem(Properties properties){
        super(properties);
    }
    public static ItemStack createStamp(ServerPlayer player){
        ItemStack stamp = new ItemStack(ModItems.STAMP);
        stamp.set(DataComponents.CUSTOM_NAME,
                Component.literal("Stamp of:" + player.getName()));
        stamp.set(DataComponents.CUSTOM_DATA,
                CustomData.of(new CompoundTag()
                        .putUUID("Player", player.getUUID())));
        return stamp;
    }

}
