package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_ItemAetherAxeValkyrie extends ItemTool /*implements IReach */{
	
	public MMC_ItemAetherAxeValkyrie(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
//        SAPI.reachAdd(this);
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
        return ToolBase.Axe;
    }
*/
    public boolean reachItemMatches(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return false;
        } else
        {
            return itemstack.itemID == MMC_Item.ItemAetherAxeValkyrie.shiftedIndex;
        }
    }

    public float getReach(ItemStack itemstack)
    {
        return 10F;
    }

    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MMC_Block.BlockAetherPlank, MMC_Block.BlockAetherLog
        });
    }
}
