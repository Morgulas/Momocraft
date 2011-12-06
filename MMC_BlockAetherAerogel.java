package net.minecraft.src;


public class MMC_BlockAetherAerogel extends Block{
	
    public MMC_BlockAetherAerogel(int i)
    {
        super(i, MMC_Textures.TexBlockAetherAerogel, Material.rock);
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
