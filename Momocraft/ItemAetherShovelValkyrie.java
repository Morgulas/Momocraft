package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class ItemAetherShovelValkyrie extends ItemTool /*implements IReach*/{
	
	public ItemAetherShovelValkyrie(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
//        SAPI.reachAdd(this);
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

    public boolean reachItemMatches(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return false;
        } else
        {
            return itemstack.itemID == MomocraftItems.ItemAetherShovelValkyrie.shiftedIndex;
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
            MomocraftBlocks.BlockAetherQuicksoil, MomocraftBlocks.BlockAetherDirt, MomocraftBlocks.BlockAetherGrass, MomocraftBlocks.BlockAetherAercloud
        });
    }
}
