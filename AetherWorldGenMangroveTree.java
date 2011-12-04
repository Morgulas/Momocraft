package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenMangroveTree extends AetherWorldGenerator{

	private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int height;
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;

    public AetherWorldGenMangroveTree()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        treeRNG = random;
        x = i;
        y = j;
        z = k;
        treeBlock = MomocraftBlocks.TestBlock.blockID;
        treeMeta = 2;
        leafBlock = MomocraftBlocks.TestBlock.blockID;
        leafMeta = 2;
        int l = world.getBlockId(x, y - 1, z);
        if(l != Block.waterStill.blockID || y >= 128 - height - 1)
        {
            return false;
        }
        buildBranch(5, 6 + treeRNG.nextInt(3), 0.0D, 0.0D);
        int i1 = treeRNG.nextInt(3);
        double d = treeRNG.nextDouble();
        for(int j1 = 0; j1 < i1; j1++)
        {
            buildBranch(7 + j1, 6 + treeRNG.nextInt(2), 0.29999999999999999D * (double)j1 + d, 0.25D);
        }

        int k1 = 3 + treeRNG.nextInt(2);
        d = treeRNG.nextDouble();
        for(int l1 = 0; l1 < k1; l1++)
        {
            double d1 = 0.75D + treeRNG.nextDouble() * 0.10000000000000001D;
            buildRoot(5, 8D, 0.40000000000000002D * (double)l1 + d, d1);
        }

        addFirefly(5 + treeRNG.nextInt(5), treeRNG.nextDouble());
        return true;
    }

    void buildBranch(int i, double d, double d1, double d2)
    {
        int ai[] = {
            x, y + i, z
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0] + 1, ai1[1], ai1[2], treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0] - 1, ai1[1], ai1[2], treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0], ai1[1], ai1[2] + 1, treeBlock, treeMeta, true);
        putBlockAndMetadata(ai1[0], ai1[1], ai1[2] - 1, treeBlock, treeMeta, true);
        int j = 2 + treeRNG.nextInt(3);
        drawCircle(ai1[0], ai1[1] - 1, ai1[2], (byte)(j - 1), leafBlock, leafMeta, false);
        drawCircle(ai1[0], ai1[1], ai1[2], (byte)j, leafBlock, leafMeta, false);
        drawCircle(ai1[0], ai1[1] + 1, ai1[2], (byte)(j - 2), leafBlock, leafMeta, false);
    }

    void buildRoot(int i, double d, double d1, double d2)
    {
        int ai[] = {
            x, y + i, z
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, treeMeta, true);
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
