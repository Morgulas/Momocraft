package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_ItemAetherPickValkyrie extends ItemTool /*implements IReach*/{
	
	public MMC_ItemAetherPickValkyrie(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
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
        return ToolBase.Pickaxe;
    }
*/
    public boolean reachItemMatches(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return false;
        } else
        {
            return itemstack.itemID == MMC_Item.ItemAetherPickValkyrie.shiftedIndex;
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
            MMC_Block.BlockAetherHolystone, MMC_Block.BlockAetherIcestone, MMC_Block.BlockAetherEnchantedGravitite, MMC_Block.BlockAetherGravititeOre, MMC_Block.BlockAetherZaniteOre, MMC_Block.BlockAetherAmbrosiumOre, MMC_Block.BlockAetherLightDungeonStone, MMC_Block.BlockAetherDungeonStone, MMC_Block.BlockAetherPillar, MMC_Block.BlockAetherAerogel, 
            /*MomocraftBlocks.BlockAetherEnchanter, MomocraftBlocks.BlockAetherIncubator,*/ MMC_Block.BlockAetherZanite, /*MomocraftBlocks.BlockAetherFreezer,*/ MMC_Block.BlockAetherQuicksoilGlass
        });
    }
}
