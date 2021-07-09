package net.arceus.mineral.mod.materials;

import net.arceus.mineral.mod.Main;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SilverArmorMaterial implements ArmorMaterial {

  private static final int[] BASE_DUARBILITY = new int[] { 13, 15, 16, 11 };

  // helmet, chestplate, leggings, boots
  private static final int[] PROTECTION_VALUES = new int[] { 2, 7, 5, 2 };

  @Override
  public int getDurability(EquipmentSlot slot) {
    return BASE_DUARBILITY[slot.getEntitySlotId()] * 25;
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
    return PROTECTION_VALUES[slot.getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return 17;
  }

  @Override
  public SoundEvent getEquipSound() {
    return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(Main.silver_ingot);
  }

  @Override
  public String getName() {
    return "silver";
  }

  @Override
  public float getToughness() {
    return 1.0F;
  }

  @Override
  public float getKnockbackResistance() {
    return 0;
  }

}
