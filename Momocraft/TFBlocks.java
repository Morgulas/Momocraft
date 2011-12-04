package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class TFBlocks {

	    public static Block portal;

	    public TFBlocks(){
	        portal = (new BlockTFPortal(mod_Momocraft.idBlockPortal, 14))/*.setHardness(0.0F)*/.setBlockName("TFPortal");
	        ModLoader.RegisterBlock(portal);
	        ModLoader.AddName(portal, "Portail vers la MomoDimension");
	        TFBlocks _tmp = this;
	        TFBlocks _tmp1 = this;
	    }
}
