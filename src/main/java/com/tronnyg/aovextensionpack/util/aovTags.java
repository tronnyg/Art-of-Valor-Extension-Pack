package com.tronnyg.aovextensionpack.util;


import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import com.tronnyg.aovextensionpack.*;

public class aovTags {

    public static class Items{

        public static final Tags.IOptionalNamedTag<Item> ROGUE_SWORD_BROKEN = createTag("rogue_sword_broken");

        private static Tags.IOptionalNamedTag<Item> createTag(String name){
            return ItemTags.createOptional(new ResourceLocation(aovExtensionPack.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name){
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
