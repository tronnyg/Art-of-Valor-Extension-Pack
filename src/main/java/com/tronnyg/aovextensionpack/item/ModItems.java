package com.tronnyg.aovextensionpack.item;

import com.tronnyg.aovextensionpack.aovExtensionPack;
import com.tronnyg.aovextensionpack.item.custom.RogueSword;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, aovExtensionPack.MOD_ID);

    public static final RegistryObject<Item> ROGUE_SWORD = ITEMS.register("rogue_sword",
            () -> new RogueSword(ModItemTier.ROGUESWORD, 3, -1.4f, new Item.Properties().group(ModItemGroup.AOV_EXTENSION_PACK_GROUP).maxStackSize(1).rarity(Rarity.UNCOMMON).setNoRepair()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
