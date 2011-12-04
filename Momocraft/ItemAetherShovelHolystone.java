package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class ItemAetherShovelHolystone extends ItemTool {
	
    public ItemAetherShovelHolystone(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(random.nextInt(50) == 0)
        {
            entityliving.dropItemWithOffset(MomocraftItems.ItemAetherAmbrosiumShard.shiftedIndex, 1, 0.0F);
        }
        return super.onBlockDestroyed(itemstack, i, j, k, l, entityliving);
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
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MomocraftBlocks.BlockAetherQuicksoil, MomocraftBlocks.BlockAetherDirt, MomocraftBlocks.BlockAetherGrass, MomocraftBlocks.BlockAetherAercloud
        });
    }
}
