package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_BlockAetherPillar extends Block{

    public MMC_BlockAetherPillar(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0 || i == 1)
        {
            return sprTop;
        }
        if(j == 0)
        {
            return sprSide;
        } else
        {
            return sprTopSide;
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int sprTop = MMC_Textures.TexBlockAetherPillarTop;
    public static int sprSide = MMC_Textures.TexBlockAetherPillarSide;
    public static int sprTopSide = MMC_Textures.TexBlockAetherPillarCarved;

}
