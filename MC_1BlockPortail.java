// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            MFAPISimpleBlock, Material, EntityLiving, MathHelper, 
//            World, AxisAlignedBB

public class MC_1BlockPortail extends Block
{

    public static int id = MC_0ID.bPortail;

    public MC_1BlockPortail()
    {
        super(id, 14, Material.ice);
        setHardness(0.8F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 1);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 0);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 1);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 0);
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        double d = (float)i + random.nextFloat();
        double d1 = (float)j + 0.8F;
        double d2 = (float)k + random.nextFloat();
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        world.spawnParticle("portal", d, d1, d2, d3, d4, d5);
    }

}
