package com.Ayrou.AppleGuild.GUI.Item.type;

import com.Ayrou.AppleGuild.GUI.Item.enums.ItemType;
import org.bukkit.inventory.ItemStack;

interface Item {

    ItemType itemType = null;

    ItemStack createItemStack();
}