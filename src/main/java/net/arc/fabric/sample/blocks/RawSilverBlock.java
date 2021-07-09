package net.arceus.mineral.mod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class RawSilverBlock extends Block {
  public RawSilverBlock(){
    super(FabricBlockSettings
      .of(Material.STONE)
      .breakByHand(false)
      .requiresTool()
      .breakByTool(FabricToolTags.PICKAXES, 2)
      .strength(6.0F, 830F)
      .sounds(BlockSoundGroup.STONE)
    );
  }
}
