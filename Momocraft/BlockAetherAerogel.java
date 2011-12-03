package net.minecraft.src.Momocraft;

import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;

public class BlockAetherAerogel extends Block{
	
    public BlockAetherAerogel(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherAerogel, Material.rock);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }
}
