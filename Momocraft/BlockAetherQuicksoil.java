package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherQuicksoil extends Block{
	
    public BlockAetherQuicksoil(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherQuicksoil, Material.sand);
        slipperiness = 1.1F;
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
