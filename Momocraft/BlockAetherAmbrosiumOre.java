package net.minecraft.src.Momocraft;

import java.util.*;

import net.minecraft.src.*;

public class BlockAetherAmbrosiumOre extends Block{
	
	public BlockAetherAmbrosiumOre(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherAmbrosiumOre, Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return MomocraftItems.ItemAetherAmbrosiumShard.shiftedIndex;
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
