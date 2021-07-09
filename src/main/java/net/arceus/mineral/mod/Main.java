package net.arceus.mineral.mod;

import net.arceus.mineral.mod.blocks.RawSilverBlock;
import net.arceus.mineral.mod.blocks.SilverBlock;
import net.arceus.mineral.mod.blocks.SilverOre;
import net.arceus.mineral.mod.items.RawSilver;
import net.arceus.mineral.mod.items.SilverIngot;
// import net.arceus.mineral.mod.materials.EmeraldArmorMaterial;
import net.arceus.mineral.mod.materials.SilverArmorMaterial;
import net.arceus.mineral.mod.materials.SilverToolMaterial;
import net.arceus.mineral.mod.tools.SilverAxe;
import net.arceus.mineral.mod.tools.SilverHoe;
import net.arceus.mineral.mod.tools.SilverPickaxe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
// import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Main implements ModInitializer {

  private static final Identifier ID(String name) {
    return new Identifier("arceus_mineral_mod", name);
  }

  private static final Settings TOOL_SETTINGS() {
    return new Item.Settings().group(ItemGroup.TOOLS);
  }

  private static final Settings COMBAT_GROUP() {
    return new Item.Settings().group(ItemGroup.COMBAT);
  }

  private static final BlockItem BUILDING_BLOCKS(Block block) {
    return new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
  }

  public static final Item arc_item = new ArcItem(new Item.Settings().group(ItemGroup.MISC));

  // silver
  // silver - blocks
  public static final Block silver_block = new SilverBlock();
  public static final Block silver_ore = new SilverOre();
  public static final Block raw_silver_block = new RawSilverBlock();
  // silver - items
  public static final Item raw_silver = new RawSilver(new FabricItemSettings().group(ItemGroup.MISC));
  public static final Item silver_ingot = new SilverIngot(new FabricItemSettings().group(ItemGroup.MISC));
  // silver - materials
  // public static final ToolMaterial silver_tool_material = new SilverToolMaterial();
  public static final ArmorMaterial silver_armor_material = new SilverArmorMaterial();
  // silver - tools
  public static final ToolItem silver_shovel = new ShovelItem(SilverToolMaterial.INSTANCE, 5.0F, -1.0F,
      TOOL_SETTINGS());
  public static final ToolItem silver_sword = new SwordItem(SilverToolMaterial.INSTANCE, 6, -1.0F,
      new Item.Settings().group(ItemGroup.COMBAT));
  public static final ToolItem silver_pickaxe = new SilverPickaxe(SilverToolMaterial.INSTANCE, 4, -1.2F,
      TOOL_SETTINGS());
  public static final ToolItem silver_axe = new SilverAxe(SilverToolMaterial.INSTANCE, 9, -0.9F, TOOL_SETTINGS());
  public static final ToolItem silver_hoe = new SilverHoe(SilverToolMaterial.INSTANCE, 1, -3.0F, TOOL_SETTINGS());

  // silver - armor
  public static final Item silver_helmet = new ArmorItem(silver_armor_material, EquipmentSlot.HEAD, COMBAT_GROUP());
  public static final Item silver_chestplate = new ArmorItem(silver_armor_material, EquipmentSlot.CHEST,
      COMBAT_GROUP());
  public static final Item silver_leggings = new ArmorItem(silver_armor_material, EquipmentSlot.LEGS, COMBAT_GROUP());
  public static final Item silver_boots = new ArmorItem(silver_armor_material, EquipmentSlot.FEET, COMBAT_GROUP());

  // silver - ore generation
  private static ConfiguredFeature<?, ?> silver_ore_nether = Feature.ORE
      .configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, silver_ore.getDefaultState(), 9))
      .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(2, 30, 200))).spreadHorizontally().repeat(20);

  // ------

  // public static final ArmorMaterial emerald_armor_material = new
  // EmeraldArmorMaterial();

  // public static final Item emerald_helmet = new
  // ArmorItem(emerald_armor_material, EquipmentSlot.HEAD,
  // new Item.Settings().group(ItemGroup.COMBAT));

  // public static final Item emerald_chestplate = new
  // ArmorItem(emerald_armor_material, EquipmentSlot.CHEST,
  // new Item.Settings().group(ItemGroup.COMBAT));

  // public static final Item emerald_leggings = new
  // ArmorItem(emerald_armor_material, EquipmentSlot.LEGS,
  // new Item.Settings().group(ItemGroup.COMBAT));

  // public static final Item emerald_boots = new
  // ArmorItem(emerald_armor_material, EquipmentSlot.FEET,
  // new Item.Settings().group(ItemGroup.COMBAT));

  @Override
  public void onInitialize() {

    Registry.register(Registry.ITEM, ID("arc_item"), arc_item);

    // silver
    Registry.register(Registry.ITEM, ID("raw_silver"), raw_silver);
    Registry.register(Registry.ITEM, ID("silver_ingot"), silver_ingot);
    Registry.register(Registry.BLOCK, ID("silver_block"), silver_block);
    Registry.register(Registry.BLOCK, ID("silver_ore"), silver_ore);
    Registry.register(Registry.BLOCK, ID("raw_silver_block"), raw_silver_block);
    Registry.register(Registry.ITEM, ID("silver_block"), BUILDING_BLOCKS(silver_block));
    Registry.register(Registry.ITEM, ID("silver_ore"), BUILDING_BLOCKS(silver_ore));
    Registry.register(Registry.ITEM, ID("raw_silver_block"), BUILDING_BLOCKS(raw_silver_block));
    Registry.register(Registry.ITEM, ID("silver_pickaxe"), silver_pickaxe);
    Registry.register(Registry.ITEM, ID("silver_axe"), silver_axe);
    Registry.register(Registry.ITEM, ID("silver_shovel"), silver_shovel);
    Registry.register(Registry.ITEM, ID("silver_hoe"), silver_hoe);
    Registry.register(Registry.ITEM, ID("silver_sword"), silver_sword);
    Registry.register(Registry.ITEM, ID("silver_helmet"), silver_helmet);
    Registry.register(Registry.ITEM, ID("silver_chestplate"), silver_chestplate);
    Registry.register(Registry.ITEM, ID("silver_leggings"), silver_leggings);
    Registry.register(Registry.ITEM, ID("silver_boots"), silver_boots);

    RegistryKey<ConfiguredFeature<?, ?>> silver_ore_nether_key = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
        ID("silver_ore_nether"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, silver_ore_nether_key.getValue(), silver_ore_nether);
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
        silver_ore_nether_key);
    // -------

    // emerald armor
    // Registry.register(Registry.ITEM, new Identifier("arceus_mineral_mod",
    // "emerald_helmet"), emerald_helmet);
    // Registry.register(Registry.ITEM, new Identifier("arceus_mineral_mod",
    // "emerald_chestplate"), emerald_chestplate);
    // Registry.register(Registry.ITEM, new Identifier("arceus_mineral_mod",
    // "emerald_leggings"), emerald_leggings);
    // Registry.register(Registry.ITEM, new Identifier("arceus_mineral_mod",
    // "emerald_boots"), emerald_boots);

  }

}
