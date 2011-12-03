package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherPillar extends Block{

    public BlockAetherPillar(int i)
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

    public static int sprTop = MomocraftTextures.TexBlockAetherPillarTop;
    public static int sprSide = MomocraftTextures.TexBlockAetherPillarSide;
    public static int sprTopSide = MomocraftTextures.TexBlockAetherPillarCarved;

}
