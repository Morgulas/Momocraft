package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class BlockAetherQuicksoilGlass extends BlockBreakable{
	
	public BlockAetherQuicksoilGlass(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherQuicksoilGlass, Material.glass, false);
        slipperiness = 1.05F;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public int getRenderColor(int i)
    {
        return 0xffff00;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }
}
