package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherShovelZanite extends ItemTool {

	public MMC_ItemAetherShovelZanite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((float)(itemstack.getItemDamage() / itemstack.getItem().getMaxDamage()) + 0.5F);
    }

/*    public ToolBase getToolBase()
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

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MMC_Block.BlockAetherQuicksoil, MMC_Block.BlockAetherDirt, MMC_Block.BlockAetherGrass, MMC_Block.BlockAetherAercloud
        });
    }

}
