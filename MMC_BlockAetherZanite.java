package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_BlockAetherZanite extends Block{
	
	 public MMC_BlockAetherZanite(int i, int j)
	    {
	        super(i, j, Material.rock);
	    }

	    public int getRenderColor(int i)
	    {
	        return 0x9999ff;
	    }

	    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
	    {
	        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
	    }
}
