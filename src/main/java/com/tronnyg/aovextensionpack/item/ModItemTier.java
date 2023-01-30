package com.tronnyg.aovextensionpack.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    ROGUESWORD(2, 250, 4.0F, 2.0F, 10);



    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;

    ModItemTier(int level, int uses, float speed, float damage, int enchantmentValue) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
    }

    @Override
    public int getMaxUses() {
        return uses;
    }

    @Override
    public float getEfficiency() {
        return speed;
    }

    @Override
    public float getAttackDamage() {
        return damage;
    }

    @Override
    public int getHarvestLevel() {
        return level;
    }

    @Override
    public int getEnchantability() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }
}