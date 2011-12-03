package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherHolystone extends Block{
	
	public BlockAetherHolystone(int i)
    {
        super(i, sprNormal, Material.rock);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, l > 1 ? 2 : 0);
        if(mod_Momocraft.equippedSkyrootPick() && (l == 0 || l == 2))
        {
            itemstack.stackSize *= 2;
        }
        
/*Desactiver tant ShockAPI pas a jour*/        //SAPI.drop(world, new Loc(i, j, k), itemstack);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j > 1)
        {
            return sprMossy;
        } else
        {
            return sprNormal;
        }
    }

    public static int sprNormal = MomocraftTextures.TexBlockAetherHolystone;
    public static int sprMossy = MomocraftTextures.TexBlockAetherMossyHolystone;
}
