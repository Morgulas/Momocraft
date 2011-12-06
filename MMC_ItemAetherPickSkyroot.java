package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_ItemAetherPickSkyroot extends ItemTool {

	public MMC_ItemAetherPickSkyroot(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
    }

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

/*    public ToolBase getToolBase()
    {
        return ToolBase.Pickaxe;
    }
*/
    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MMC_Block.BlockAetherHolystone, MMC_Block.BlockAetherAmbrosiumOre, /*MomocraftBlocks.BlockAetherFreezer,*/ MMC_Block.BlockAetherQuicksoilGlass, /*MomocraftBlocks.BlockAetherIncubator*/
        });
    }

}
