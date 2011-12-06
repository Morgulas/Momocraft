package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_BlockAetherQuicksoil extends Block{
	
    public MMC_BlockAetherQuicksoil(int i)
    {
        super(i, MMC_Textures.TexBlockAetherQuicksoil, Material.sand);
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
