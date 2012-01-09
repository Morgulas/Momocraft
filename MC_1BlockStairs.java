// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, World, EntityLiving, MathHelper, 
//            IBlockAccess, AxisAlignedBB, EntityPlayer, Entity, 
//            Vec3D

public class MC_1BlockStairs extends Block
{

//    private Block modelBlock;

    protected MC_1BlockStairs(int i, Block block, int j)
    {
        super(i, j, block.blockMaterial);
//        modelBlock = block;
        setHardness(block.blockHardness);
        setResistance(block.blockResistance / 3F);
        setStepSound(block.stepSound);
        setLightOpacity(255);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
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
        return 10;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(l == 0)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 1)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        }
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }


    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
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
    
    public int idDropped(int metadata, Random random) {
        return blockID;
    }

	protected int damageDropped(int metadata) {
	        return metadata;
	}


/**
*
* Pick one of the following 3 code blocks.
*
*/

// If you use metadata to change the texture of the block.
//	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
//	        switch (metadata){
//	        case 0: return Block.cloth.blockIndexInTexture;
//	        case 1: return mod_Momocraft.IndexClothTexture(1);
//	        case 2: return mod_Momocraft.IndexClothTexture(2);
//	        case 3: return mod_Momocraft.IndexClothTexture(3);
//	        case 4: return mod_Momocraft.IndexClothTexture(4);
//	        case 5: return mod_Momocraft.IndexClothTexture(5);
//	        case 6: return mod_Momocraft.IndexClothTexture(6);
//	        case 7: return mod_Momocraft.IndexClothTexture(7);
//	        case 8: return mod_Momocraft.IndexClothTexture(8);
//	        case 9: return mod_Momocraft.IndexClothTexture(9);
//	        case 10: return mod_Momocraft.IndexClothTexture(10);
//	        case 11: return mod_Momocraft.IndexClothTexture(11);
//	        case 12: return mod_Momocraft.IndexClothTexture(12);
//	        case 13: return mod_Momocraft.IndexClothTexture(13);
//	        case 14: return mod_Momocraft.IndexClothTexture(14);
//	        case 15: return mod_Momocraft.IndexClothTexture(15);
//	        }
//			return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
//	}
	
//	// If you use the side of the block but not metadata.
//	public int getBlockTextureFromSide(int side){
//	       switch (side){
//	       case 0: return MC_0Textures.bLogSide1;
//	       case 1: return MC_0Textures.bLogSide2;
//	       case 2: return MC_0Textures.bLogSide3;
//	       //etc. etc.
//	       }
//	
//	
//	return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
//	
//	}          
}
