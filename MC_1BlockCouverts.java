// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MFAPISimpleBlock, Material, World, AxisAlignedBB

public class MC_1BlockCouverts extends Block
{
    public static int id = MC_0ID.bCouverts;
    public static Material material_stone;
    public static Block block_cobblestone;
    public static Block block_wood;
    public static Block block_brick;
    public static Material material_cloth;
    public int renderType;
    public boolean opaque;
    public boolean renderAsNormal;
    public boolean changeDataByPosition;
    public boolean hasTextureSprite;
    public String textureSprite;

    public MC_1BlockCouverts()
    {
        super(id, MC_0Textures.bCouverts, Material.glass);
        setHardness(0.8F);
        float f = 0.0625F;
        setBlockBounds(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
        changeDataByPosition(true);
        setTextureSprite("/momocraft/blocks/terrain.png");
    }

    public int getRenderType()
    {
        return 51;
    }
    public void changeDataByPosition(boolean flag)
    {
        changeDataByPosition = flag;
    }
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        if(changeDataByPosition)
        {
            int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
            if(l == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, 2);
            }
            if(l == 1)
            {
                world.setBlockMetadataWithNotify(i, j, k, 1);
            }
            if(l == 2)
            {
                world.setBlockMetadataWithNotify(i, j, k, 3);
            }
            if(l == 3)
            {
                world.setBlockMetadataWithNotify(i, j, k, 0);
            }
        }
    }
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
    public boolean hasTextureSprite()
    {
        return hasTextureSprite;
    }

    public String getTextureSprite()
    {
        return textureSprite;
    }

    public void setTextureSprite(String s)
    {
        hasTextureSprite = true;
        textureSprite = s;
    }
}
