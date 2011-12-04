package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class ItemAetherPickValkyrie extends ItemTool /*implements IReach*/{
	
	public ItemAetherPickValkyrie(int i, EnumToolMaterial enumtoolmaterial)
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
            return itemstack.itemID == MomocraftItems.ItemAetherPickValkyrie.shiftedIndex;
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
            MomocraftBlocks.BlockAetherHolystone, MomocraftBlocks.BlockAetherIcestone, MomocraftBlocks.BlockAetherEnchantedGravitite, MomocraftBlocks.BlockAetherGravititeOre, MomocraftBlocks.BlockAetherZaniteOre, MomocraftBlocks.BlockAetherAmbrosiumOre, MomocraftBlocks.BlockAetherLightDungeonStone, MomocraftBlocks.BlockAetherDungeonStone, MomocraftBlocks.BlockAetherPillar, MomocraftBlocks.BlockAetherAerogel, 
            MomocraftBlocks.BlockAetherEnchanter, MomocraftBlocks.BlockAetherIncubator, MomocraftBlocks.BlockAetherZanite, MomocraftBlocks.BlockAetherFreezer, MomocraftBlocks.BlockAetherQuicksoilGlass
        });
    }
}
