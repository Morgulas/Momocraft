package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherDirt extends Block{

//	protected BlockAetherDirt(int i, int j, Material material) {
//		super(i, j, material);
//		// TODO Auto-generated constructor stub
//	}

	public BlockAetherDirt(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherDirt, Material.ground);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && mod_Momocraft.equippedSkyrootShovel())
        {
            dropBlockAsItem(world, i, j, k, l, l);
        }
        dropBlockAsItem(world, i, j, k, l, l);
    }
	
	
}
