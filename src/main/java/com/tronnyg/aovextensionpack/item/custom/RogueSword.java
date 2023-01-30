package com.tronnyg.aovextensionpack.item.custom;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class RogueSword extends SwordItem {

    public RogueSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }


    // TOOLTIPS INFORMATION
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.aovextensionpack.roguesword.shift"));
            tooltip.add(new TranslationTextComponent(""));
            tooltip.add(new TranslationTextComponent("tooltip.aovextensionpack.roguesword.shift1"));
       }
        else{
            tooltip.add(new TranslationTextComponent("tooltip.aovextensionpack.roguesword"));
            tooltip.add(new TranslationTextComponent(" "));
            tooltip.add(new TranslationTextComponent("tooltip.aovextensionpack.roguesword1"));}
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    // HIT ENTITY EFFECTS
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        PlayerEntity playerEntity = (PlayerEntity) attacker;

        if (!playerEntity.getCooldownTracker().hasCooldown(this)) {
            attacker.addPotionEffect(new EffectInstance(Effects.SPEED, 100,1));
            playerEntity.getCooldownTracker().setCooldown(this, 200);
        }
        if (random.nextInt(3) == 1) {
            target.addPotionEffect(new EffectInstance(Effects.POISON, 60, 1));
        }

        return super.hitEntity(stack, target, attacker);
    }

    // ADDS NIGHT VISION TO PLAYER
    public static void addNightVision (World worldIn, PlayerEntity playerIn) {
        if (!(playerIn.isPotionActive(new EffectInstance(Effects.NIGHT_VISION).getPotion()))){
        playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,72000));}
    }

    // REMOVES NIGHT VISION FROM PLAYER
    public static void removeNightVision(PlayerEntity playerIn) {
        playerIn.removePotionEffect(new EffectInstance(Effects.NIGHT_VISION).getPotion());
        }


    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (isSelected && (worldIn.getLightValue(entityIn.getPosition()) < 3)){
            addNightVision(worldIn, (PlayerEntity) entityIn);}

        if(!isSelected) {removeNightVision((PlayerEntity) entityIn);}
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
