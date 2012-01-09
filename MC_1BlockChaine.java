// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockGrass, 
//            AxisAlignedBB

public class MC_1BlockChaine extends Block
{

    protected MC_1BlockChaine(int i, int j)
    {
        super(i, j, Material.iron);
        float f = 0.375F;
        float f1 = 0.625F;
        setBlockBounds(f, 0.0F, f, f1, 1.0F, f1);
    }


    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
}
