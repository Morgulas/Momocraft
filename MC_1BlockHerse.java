package net.minecraft.src;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

public class MC_1BlockHerse extends BlockFence{
	
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
	RenderBlocks renderblocks;
	
    protected MC_1BlockHerse(int i, int j, Material material) {
		super(i, j, material);
		changeDataByPosition = true;

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

//    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
//    {
//        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float)j + 1.5F, k + 1);
//    }
    
    public int getRenderType()
    {
        return 41;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public Block setLightValue(float f)
    {
        super.setLightValue(f);
        return this;
    }

    public void setOpaque(boolean flag)
    {
        opaque = flag;
    }

    public void renderAsNormalBlock(boolean flag)
    {
        renderAsNormal = flag;
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
    
    public void changeDataByPosition(boolean flag)
    {
        changeDataByPosition = flag;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        boolean flag = isFenceAt(world, i, j, k - 1);
        boolean flag1 = isFenceAt(world, i, j, k + 1);
        boolean flag2 = isFenceAt(world, i - 1, j, k);
        boolean flag3 = isFenceAt(world, i + 1, j, k);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f, j, (float)k + f2, (float)i + f1, (float)j + 1.5F, (float)k + f3);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        boolean flag = isFenceAt(iblockaccess, i, j, k - 1);
        boolean flag1 = isFenceAt(iblockaccess, i, j, k + 1);
        boolean flag2 = isFenceAt(iblockaccess, i - 1, j, k);
        boolean flag3 = isFenceAt(iblockaccess, i + 1, j, k);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
    
    static 
    {
        material_stone = Material.rock;
        material_cloth = Material.cloth;
        block_cobblestone = Block.cobblestone;
        block_wood = Block.planks;
        block_brick = Block.brick;
    }
}
