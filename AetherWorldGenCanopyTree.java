package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenCanopyTree extends AetherWorldGenerator{
	
	private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int treeHeight;
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;

    public AetherWorldGenCanopyTree()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        treeRNG = random;
        int l = world.getBlockId(i, j - 1, k);
        if(l != Block.grass.blockID && l != Block.dirt.blockID || y >= 128 - treeHeight - 1)
        {
            return false;
        }
        x = i;
        y = j;
        z = k;
        treeBlock = MomocraftBlocks.BlockAetherLog.blockID;
        treeMeta = 1;
        leafBlock = MomocraftBlocks.BlockAetherSkyrootLeaves.blockID;
        leafMeta = 1;
        treeHeight = 20;
        if(treeRNG.nextInt(3) == 0)
        {
            treeHeight += treeRNG.nextInt(5);
            if(treeRNG.nextInt(8) == 0)
            {
                treeHeight += treeRNG.nextInt(5);
            }
        }
        buildBranch(0, treeHeight, 0.0D, 0.0D, true);
        int i1 = 3 + treeRNG.nextInt(2);
        double d = treeRNG.nextDouble();
        for(int j1 = 0; j1 < i1; j1++)
        {
            buildBranch((treeHeight - 10) + j1, 9D, 0.29999999999999999D * (double)j1 + d, 0.20000000000000001D, false);
        }

        return true;
    }

    void buildBranch(int i, double d, double d1, double d2, 
            boolean flag)
    {
        int ai[] = {
            x, y + i, z
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, treeMeta, true);
        if(flag)
        {
            addFirefly(3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        putBlockAndMetadata(ai1[0] + 1, ai1[1], ai1[2], treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0] - 1, ai1[1], ai1[2], treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0], ai1[1], ai1[2] + 1, treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0], ai1[1], ai1[2] - 1, treeBlock, treeMeta, true);
        drawCircle(ai1[0], ai1[1] - 1, ai1[2], 3, leafBlock, leafMeta, false);
        drawCircle(ai1[0], ai1[1], ai1[2], 4, leafBlock, leafMeta, false);
        drawCircle(ai1[0], ai1[1] + 1, ai1[2], 2, leafBlock, leafMeta, false);
    }

    private void addFirefly(int i, double d)
    {
        int j = (int)(d * 4D);
        if(j == 0)
        {
            putBlockAndMetadata(x + 1, y + i, z, MomocraftBlocks.TestBlock.blockID, 1, false);
        } else
        if(j == 1)
        {
            putBlockAndMetadata(x - 1, y + i, z, MomocraftBlocks.TestBlock.blockID, 2, false);
        } else
        if(j == 2)
        {
            putBlockAndMetadata(x, y + i, z + 1, MomocraftBlocks.TestBlock.blockID, 3, false);
        } else
        if(j == 3)
        {
            putBlockAndMetadata(x, y + i, z - 1, MomocraftBlocks.TestBlock.blockID, 4, false);
        }
    }
}
