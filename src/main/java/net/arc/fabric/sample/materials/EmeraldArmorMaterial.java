package net.arceus.mineral.mod.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EmeraldArmorMaterial implements ArmorMaterial {

  private static final int X = 30;

  private static final int[] BASE_DUARBILITY = new int[] { 20, 20, 20, 20 };

  // helmet, chestplate, leggings, boots
  private static final int[] PROTECTION_VALUES = new int[] { 2, 5, 7, 2 };

  @Override
  public int getDurability(EquipmentSlot slot) {
    return BASE_DUARBILITY[slot.getEntitySlotId()] * X;
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
    return PROTECTION_VALUES[slot.getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return X;
  }

  @Override
  public SoundEvent getEquipSound() {
    return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(Items.EMERALD);
  }

  @Override
  public String getName() {
    return "emerald";
  }

  @Override
  public float getToughness() {
    return 30.0F;
  }

  @Override
  public float getKnockbackResistance() {
    return 0.30F;
  }
}

