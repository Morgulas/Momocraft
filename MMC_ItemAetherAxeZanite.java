package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherAxeZanite extends ItemTool{
	
	public MMC_ItemAetherAxeZanite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
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
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((2.0F * (float)itemstack.getItemDamage()) / (float)itemstack.getItem().getMaxDamage() + 0.5F);
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MMC_Block.BlockAetherPlank, MMC_Block.BlockAetherLog
        });
    }
}