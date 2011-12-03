package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherEnchantedGravitite extends BlockFloating {
	
	public BlockAetherEnchantedGravitite(int i, int j, boolean flag)
    {
        super(i, j, flag);
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
