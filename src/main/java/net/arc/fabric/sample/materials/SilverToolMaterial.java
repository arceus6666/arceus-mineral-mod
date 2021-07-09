package net.arceus.mineral.mod.materials;

import net.arceus.mineral.mod.Main;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SilverToolMaterial implements ToolMaterial {

  public static final SilverToolMaterial INSTANCE = new SilverToolMaterial();

  @Override
  public int getDurability() {
    return 158;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 10.0F;
  }

  @Override
  public float getAttackDamage() {
    return 8.0F;
  }

  @Override
  public int getMiningLevel() {
    return 3;
  }

  @Override
  public int getEnchantability() {
    return 17;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(Main.silver_ingot);
  }

}
