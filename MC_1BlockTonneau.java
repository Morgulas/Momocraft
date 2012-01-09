package net.minecraft.src;

import java.util.ArrayList;

public class MC_1BlockTonneau extends Block{
	
	public static Material material_stone;
    public static Block block_cobblestone;
    public static Block block_wood;
    public static Block block_brick;
    public static Material material_cloth;
    public boolean opaque;
    public boolean renderAsNormal;
    public boolean changeDataByPosition;
    public boolean hasTextureSprite;
    public String textureSprite;
    
    protected MC_1BlockTonneau(int i, int j, Material material) {

		super(i, j, material);    	
		// TODO Auto-generated constructor stub
	}


    
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(world.getBlockId(i, j - 1, k) == blockID)
        {
            return true;
        }
        if(!world.getBlockMaterial(i, j - 1, k).isSolid())
        {
            return false;
        } else
        {
            return super.canPlaceBlockAt(world, i, j, k);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float)j + 1.5F, k + 1);
    }
    
    public int getRenderType()
    {
        return 52;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }


    public void setOpaque(boolean flag)
    {
        opaque = flag;
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
