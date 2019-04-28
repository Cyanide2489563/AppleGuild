package com.Ayrou.AppleGuild.GUI.Item.type;

import com.Ayrou.AppleGuild.GUI.Item.enums.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Button implements Item {

    ItemType itemType = ItemType.BUTTON;

    @Override
    public ItemStack createItemStack() {
        ItemStack itemStack = new ItemStack(Material.STONE_HOE);
        ItemMeta itemmeta = itemStack.getItemMeta();

        Objects.requireNonNull(itemmeta).setUnbreakable(true);
        itemmeta.setDisplayName("");
        itemmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        itemStack.setItemMeta(itemmeta);
        return itemStack;
    }
}