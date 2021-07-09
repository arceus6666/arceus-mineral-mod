package net.arceus.mineral.mod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
// import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class SilverBlock extends Block {

  public SilverBlock() {
    super(FabricBlockSettings
      .of(Material.METAL, MaterialColor.WHITE)
      // .breakByHand(false)
      .breakByTool(FabricToolTags.PICKAXES, 2)
      .requiresTool()
      .strength(6.0F, 8.0F)
      .sounds(BlockSoundGroup.METAL)
    );
  }

}
