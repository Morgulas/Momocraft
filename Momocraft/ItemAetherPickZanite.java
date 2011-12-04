package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class ItemAetherPickZanite extends ItemTool {

	public ItemAetherPickZanite(int i, EnumToolMaterial enumtoolmaterial)
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
            MomocraftBlocks.BlockAetherHolystone, MomocraftBlocks.BlockAetherIcestone, MomocraftBlocks.BlockAetherEnchantedGravitite, MomocraftBlocks.BlockAetherGravititeOre, MomocraftBlocks.BlockAetherZaniteOre, MomocraftBlocks.BlockAetherAmbrosiumOre, MomocraftBlocks.BlockAetherLightDungeonStone, MomocraftBlocks.BlockAetherDungeonStone, MomocraftBlocks.BlockAetherPillar, MomocraftBlocks.BlockAetherEnchanter, 
            MomocraftBlocks.BlockAetherIncubator, MomocraftBlocks.BlockAetherZanite, MomocraftBlocks.BlockAetherFreezer, MomocraftBlocks.BlockAetherQuicksoilGlass
        });
    }

}
