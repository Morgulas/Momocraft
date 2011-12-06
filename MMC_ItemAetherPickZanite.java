package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherPickZanite extends ItemTool {

	public MMC_ItemAetherPickZanite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((2.0F * (float)itemstack.getItemDamage()) / (float)itemstack.getItem().getMaxDamage() + 0.5F);
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

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MMC_Block.BlockAetherHolystone, MMC_Block.BlockAetherIcestone, MMC_Block.BlockAetherEnchantedGravitite, MMC_Block.BlockAetherGravititeOre, MMC_Block.BlockAetherZaniteOre, MMC_Block.BlockAetherAmbrosiumOre, MMC_Block.BlockAetherLightDungeonStone, MMC_Block.BlockAetherDungeonStone, MMC_Block.BlockAetherPillar, /*MomocraftBlocks.BlockAetherEnchanter,*/ 
            /*MomocraftBlocks.BlockAetherIncubator, */MMC_Block.BlockAetherZanite, /*MomocraftBlocks.BlockAetherFreezer, */MMC_Block.BlockAetherQuicksoilGlass
        });
    }

}
