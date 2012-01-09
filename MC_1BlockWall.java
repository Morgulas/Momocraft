// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashMap;

// Referenced classes of package net.minecraft.src:
//            Block, Item, ItemBlock, World, 
//            Material, AxisAlignedBB, IBlockAccess, mod_Walls

public class MC_1BlockWall extends Block
{

    private Block modelBlock;

    public MC_1BlockWall(int i, Block block, int j)
    {
        super(i, j, block.blockMaterial);
        modelBlock = block;
        setHardness(block.blockHardness);
        setResistance(block.blockResistance / 3F);
        setStepSound(block.stepSound);
        setTickOnLoad(true);
        Item.itemsList[i] = new ItemBlock(i - 256);
        blocksList[i].initializeBlock();
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
        return 71;
    }

    public boolean isWallOrGateAt(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockId(i, j, k);
        return l == Block.fenceGate.blockID || l == MC_0ID.bMuretStep || l == MC_0ID.bMuretSandStone || l == MC_0ID.bMuretPlank || l == MC_0ID.bMuretCobblestone || l == MC_0ID.bMuretBrick || l == MC_0ID.bMuretStonebrick || l == MC_0ID.bMuretStone/*mod_Momocraft.startingId <= l && mod_Momocraft.startingId + mod_Momocraft.materials.size() >= l*/;
    }
}
