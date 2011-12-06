package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_ItemAetherPickHolystone extends ItemTool {

	public MMC_ItemAetherPickHolystone(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(random.nextInt(50) == 0)
        {
            entityliving.dropItemWithOffset(MMC_Item.ItemAetherAmbrosiumShard.shiftedIndex, 1, 0.0F);
        }
        return super.onBlockDestroyed(itemstack, i, j, k, l, entityliving);
    }

/*    public ToolBase getToolBase()
    {
        return ToolBase.Pickaxe;
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
            MMC_Block.BlockAetherHolystone, MMC_Block.BlockAetherIcestone, MMC_Block.BlockAetherZaniteOre, MMC_Block.BlockAetherAmbrosiumOre, MMC_Block.BlockAetherLightDungeonStone, MMC_Block.BlockAetherDungeonStone, MMC_Block.BlockAetherPillar, /*MomocraftBlocks.BlockAetherEnchanter, MomocraftBlocks.BlockAetherIncubator,*/ MMC_Block.BlockAetherZanite, 
            /*MomocraftBlocks.BlockAetherFreezer,*/ MMC_Block.BlockAetherQuicksoilGlass
        });
    }

}
