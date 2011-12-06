package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_BlockAetherEnchantedGravitite extends MMC_BlockFloating {
	
	public MMC_BlockAetherEnchantedGravitite(int i, int j, boolean flag)
    {
        super(i, j, false);
    }

    public int getRenderColor(int i)
    {
        return 0xffaaff;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }
}
