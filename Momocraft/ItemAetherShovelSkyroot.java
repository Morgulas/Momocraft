package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;


public class ItemAetherShovelSkyroot extends ItemTool {

	 public ItemAetherShovelSkyroot(int i, EnumToolMaterial enumtoolmaterial)
	    {
	        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
	    }

/*	    public ToolBase getToolBase()
	    {
	        return ToolBase.Shovel;
	    }
*/
	    public boolean canHarvestBlock(Block block)
	    {
	        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
	        {
	            if(blocksEffectiveAgainst[i].blockID == block.blockID)
	            {
	                return true;
	            }
	        }

	        return false;
	    }

	    private static Block blocksEffectiveAgainst[];
	    private static Random random = new Random();

	    static 
	    {
	        blocksEffectiveAgainst = (new Block[] {
	            MomocraftBlocks.BlockAetherQuicksoil, MomocraftBlocks.BlockAetherDirt, MomocraftBlocks.BlockAetherGrass, MomocraftBlocks.BlockAetherAercloud
	        });
	    }
}
