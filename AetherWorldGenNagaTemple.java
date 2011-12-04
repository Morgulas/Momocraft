package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldGenNagaTemple extends AetherWorldGenerator{

    static int RADIUS = 46;

    public AetherWorldGenNagaTemple()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        fill(i - RADIUS, j - 1, k - RADIUS, RADIUS * 2 + 1, 1, RADIUS * 2 + 1, Block.grass.blockID, 0);
        for(int l = -RADIUS; l <= RADIUS; l++)
        {
            for(int l1 = -RADIUS; l1 <= RADIUS; l1++)
            {
                if(random.nextInt(3) != 0)
                {
                    continue;
                }
                worldObj.setBlock(i + l, j, k + l1, 0);
                worldObj.setBlock(i + l, j - 1, k + l1, Block.stairDouble.blockID);
                if(random.nextInt(20) == 0)
                {
                    worldObj.setBlock(i + l, j, k + l1, Block.stairSingle.blockID);
                }
            }

        }

        for(int i1 = -RADIUS; i1 <= RADIUS; i1++)
        {
            putRandStoneBlock(i + i1, j + 0, k + RADIUS);
            putRandStoneBlock(i + i1, j + 0, k - RADIUS);
            putRandStoneBlock(i + i1, j + 1, k + RADIUS);
            putRandStoneBlock(i + i1, j + 1, k - RADIUS);
            if(i1 % 2 == 0)
            {
                worldObj.setBlockAndMetadata(i + i1, j + 2, k + RADIUS, Block.stairSingle.blockID, 5);
                putRandStoneBlock(i + i1, j + 2, k - RADIUS);
            } else
            {
                worldObj.setBlockAndMetadata(i + i1, j + 2, k - RADIUS, Block.stairSingle.blockID, 5);
                putRandStoneBlock(i + i1, j + 2, k + RADIUS);
            }
        }

        for(int j1 = -RADIUS; j1 <= RADIUS; j1++)
        {
            putRandStoneBlock(i + RADIUS, j + 0, k + j1);
            putRandStoneBlock(i - RADIUS, j + 0, k + j1);
            putRandStoneBlock(i + RADIUS, j + 1, k + j1);
            putRandStoneBlock(i - RADIUS, j + 1, k + j1);
            if(j1 % 2 == 0)
            {
                worldObj.setBlockAndMetadata(i + RADIUS, j + 2, k + j1, Block.stairSingle.blockID, 5);
                putRandStoneBlock(i - RADIUS, j + 2, k + j1);
            } else
            {
                worldObj.setBlockAndMetadata(i - RADIUS, j + 2, k + j1, Block.stairSingle.blockID, 5);
                putRandStoneBlock(i + RADIUS, j + 2, k + j1);
            }
        }

        worldObj.setBlockWithNotify(i, j + 2, k, MomocraftBlocks.TestBlock.blockID);
        for(int k1 = 0; k1 < 20; k1++)
        {
            int i2 = (i - RADIUS) + 2 + random.nextInt(2 * RADIUS - 4);
            int j2 = (k - RADIUS) + 2 + random.nextInt(2 * RADIUS - 4);
            makePillar(i2, j, j2);
        }

        return true;
    }

    protected void makeSupplyBox(int i, int j, int k)
    {
        worldObj.setBlockWithNotify(i, j, k, Block.chest.blockID);
        TileEntityChest tileentitychest = (TileEntityChest)worldObj.getBlockTileEntity(i, j, k);
        if(tileentitychest != null)
        {
            tileentitychest.setInventorySlotContents(0, new ItemStack(Item.appleGold, 64));
            tileentitychest.setInventorySlotContents(1, new ItemStack(Item.pickaxeDiamond));
            tileentitychest.setInventorySlotContents(2, new ItemStack(Item.swordDiamond));
            tileentitychest.setInventorySlotContents(3, new ItemStack(Item.axeDiamond));
            tileentitychest.setInventorySlotContents(4, new ItemStack(Item.swordSteel));
            tileentitychest.setInventorySlotContents(5, new ItemStack(Block.stoneBrick, 64));
            tileentitychest.setInventorySlotContents(6, new ItemStack(Block.stoneBrick, 64));
            tileentitychest.setInventorySlotContents(7, new ItemStack(Item.bow));
            tileentitychest.setInventorySlotContents(8, new ItemStack(Item.arrow, 64));
            tileentitychest.setInventorySlotContents(9, new ItemStack(Item.arrow, 64));
            tileentitychest.setInventorySlotContents(10, new ItemStack(Item.beefCooked, 64));
            tileentitychest.setInventorySlotContents(11, new ItemStack(Item.helmetSteel));
            tileentitychest.setInventorySlotContents(12, new ItemStack(Item.plateSteel));
            tileentitychest.setInventorySlotContents(13, new ItemStack(Item.legsSteel));
            tileentitychest.setInventorySlotContents(14, new ItemStack(Item.bootsSteel));
            tileentitychest.setInventorySlotContents(15, new ItemStack(Item.helmetDiamond));
            tileentitychest.setInventorySlotContents(16, new ItemStack(Item.plateDiamond));
            tileentitychest.setInventorySlotContents(17, new ItemStack(Item.legsDiamond));
            tileentitychest.setInventorySlotContents(18, new ItemStack(Item.bootsDiamond));
        }
    }

    public boolean makePillar(int i, int j, int k)
    {
        byte byte0 = 8;
        putBlock(i - 1, j + 0, k + 1, Block.stairSingle.blockID, true);
        putBlock(i + 0, j + 0, k + 1, Block.stairSingle.blockID, true);
        putBlock(i + 1, j + 0, k + 1, Block.stairSingle.blockID, true);
        putBlock(i + 1, j + 0, k + 0, Block.stairSingle.blockID, true);
        putBlock(i - 1, j + 0, k + 0, Block.stairSingle.blockID, true);
        putBlock(i - 1, j + 0, k - 1, Block.stairSingle.blockID, true);
        putBlock(i + 0, j + 0, k - 1, Block.stairSingle.blockID, true);
        putBlock(i + 1, j + 0, k - 1, Block.stairSingle.blockID, true);
        for(int l = 0; l < byte0; l++)
        {
            putRandStoneBlock(i, j + l, k);
            if(l > 0 && worldObj.rand.nextInt(2) == 0)
            {
                switch(worldObj.rand.nextInt(4))
                {
                case 0: // '\0'
                    putBlockAndMetadata(i - 1, j + l, k + 0, Block.vine.blockID, 8, true);
                    break;

                case 1: // '\001'
                    putBlockAndMetadata(i + 1, j + l, k + 0, Block.vine.blockID, 2, true);
                    break;

                case 2: // '\002'
                    putBlockAndMetadata(i + 0, j + l, k + 1, Block.vine.blockID, 4, true);
                    break;

                case 3: // '\003'
                    putBlockAndMetadata(i + 0, j + l, k - 1, Block.vine.blockID, 1, true);
                    break;
                }
                continue;
            }
            if(l > 0 && worldObj.rand.nextInt(4) == 0)
            {
                switch(worldObj.rand.nextInt(4))
                {
                case 0: // '\0'
                    putBlock(i - 1, j + l, k + 0, MomocraftBlocks.TestBlock.blockID, true);
                    break;

                case 1: // '\001'
                    putBlock(i + 1, j + l, k + 0, MomocraftBlocks.TestBlock.blockID, true);
                    break;

                case 2: // '\002'
                    putBlock(i + 0, j + l, k + 1, MomocraftBlocks.TestBlock.blockID, true);
                    break;

                case 3: // '\003'
                    putBlock(i + 0, j + l, k - 1, MomocraftBlocks.TestBlock.blockID, true);
                    break;
                }
            }
        }

        if(byte0 == 8)
        {
            putBlock(i - 1, j + 8, k + 1, Block.stairSingle.blockID, true);
            putBlock(i + 0, j + 8, k + 1, Block.stairSingle.blockID, true);
            putBlock(i + 1, j + 8, k + 1, Block.stairSingle.blockID, true);
            putBlock(i + 1, j + 8, k + 0, Block.stairSingle.blockID, true);
            putBlock(i - 1, j + 8, k + 0, Block.stairSingle.blockID, true);
            putBlock(i - 1, j + 8, k - 1, Block.stairSingle.blockID, true);
            putBlock(i + 0, j + 8, k - 1, Block.stairSingle.blockID, true);
            putBlock(i + 1, j + 8, k - 1, Block.stairSingle.blockID, true);
            putBlockAndMetadata(i + 0, j + 8, k + 0, Block.stairSingle.blockID, 5, true);
        }
        return true;
    }

    public void putRandStoneBlock(int i, int j, int k)
    {
        putBlockAndMetadata(i, j, k, Block.stoneBrick.blockID, worldObj.rand.nextInt(3), true);
    }
	
	
}
