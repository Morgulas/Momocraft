package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class MMC_BlockAetherAmbrosiumOre extends Block{
	
	public MMC_BlockAetherAmbrosiumOre(int i)
    {
        super(i, MMC_Textures.TexBlockAetherAmbrosiumOre, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MMC_Item.ItemAetherAmbrosiumShard.shiftedIndex;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && mod_Momocraft.equippedSkyrootPick())
        {
            dropBlockAsItem(world, i, j, k, l, l);
        }
        dropBlockAsItem(world, i, j, k, l, l);
    }
}
