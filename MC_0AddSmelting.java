package net.minecraft.src;

public class MC_0AddSmelting {
	
	public MC_0AddSmelting(){
		
	ModLoader.AddSmelting (Block.obsidian.blockID, new ItemStack(MC_0Item.ItemLingotObsidienne));
	ModLoader.AddSmelting (Block.glowStone.blockID, new ItemStack(MC_0Block.BlockGlowstonePure));
	
	}
}
