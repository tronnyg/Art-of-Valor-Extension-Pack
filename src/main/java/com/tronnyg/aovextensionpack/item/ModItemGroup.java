package com.tronnyg.aovextensionpack.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup AOV_EXTENSION_PACK_GROUP = new ItemGroup("aovModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ROGUE_SWORD.get());
        }
    };
}
