package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;


public class MMC_ItemAetherShovelSkyroot extends ItemTool {

	 public MMC_ItemAetherShovelSkyroot(int i, EnumToolMaterial enumtoolmaterial)
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
	            MMC_Block.BlockAetherQuicksoil, MMC_Block.BlockAetherDirt, MMC_Block.BlockAetherGrass, MMC_Block.BlockAetherAercloud
	        });
	    }
}
