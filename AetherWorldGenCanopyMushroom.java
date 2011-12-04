package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenCanopyMushroom extends AetherWorldGenerator{

	private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int treeHeight;
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;

    public AetherWorldGenCanopyMushroom()
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
        treeBlock = Block.mushroomCapBrown.blockID;
        treeMeta = 10;
        leafBlock = treeRNG.nextInt(3) != 0 ? Block.mushroomCapBrown.blockID : Block.mushroomCapRed.blockID;
        leafMeta = 5;
        treeHeight = 12;
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
            buildBranch((treeHeight - 5) + j1, 9D, 0.29999999999999999D * (double)j1 + d, 0.20000000000000001D, false);
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
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai[1], ai1[2], treeBlock, treeMeta, true);
        drawBresehnam(ai1[0], ai[1], ai1[2], ai1[0], ai1[1] - 1, ai1[2], treeBlock, treeMeta, true);
        if(flag)
        {
            addFirefly(3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        drawMushroomCircle(ai1[0], ai1[1], ai1[2], 4, leafBlock, true);
    }

    public void drawMushroomCircle(int i, int j, int k, int l, int i1, boolean flag)
    {
        for(byte byte0 = 0; byte0 <= l; byte0++)
        {
            for(byte byte1 = 0; byte1 <= l; byte1++)
            {
                int j1 = (int)((double)Math.max(byte0, byte1) + (double)Math.min(byte0, byte1) * 0.5D);
                if(byte0 == 3 && byte1 == 3)
                {
                    j1 = 6;
                }
                if(byte0 == 0)
                {
                    if(byte1 < l)
                    {
                        putBlockAndMetadata(i + 0, j, k + byte1, i1, 5, flag);
                        putBlockAndMetadata(i + 0, j, k - byte1, i1, 5, flag);
                    } else
                    {
                        putBlockAndMetadata(i + 0, j, k + byte1, i1, 8, flag);
                        putBlockAndMetadata(i + 0, j, k - byte1, i1, 2, flag);
                    }
                    continue;
                }
                if(byte1 == 0)
                {
                    if(byte0 < l)
                    {
                        putBlockAndMetadata(i + byte0, j, k + 0, i1, 5, flag);
                        putBlockAndMetadata(i - byte0, j, k + 0, i1, 5, flag);
                    } else
                    {
                        putBlockAndMetadata(i + byte0, j, k + 0, i1, 6, flag);
                        putBlockAndMetadata(i - byte0, j, k + 0, i1, 4, flag);
                    }
                    continue;
                }
                if(j1 < l)
                {
                    putBlockAndMetadata(i + byte0, j, k + byte1, i1, 5, flag);
                    putBlockAndMetadata(i + byte0, j, k - byte1, i1, 5, flag);
                    putBlockAndMetadata(i - byte0, j, k + byte1, i1, 5, flag);
                    putBlockAndMetadata(i - byte0, j, k - byte1, i1, 5, flag);
                    continue;
                }
                if(j1 == l)
                {
                    putBlockAndMetadata(i + byte0, j, k + byte1, i1, 9, flag);
                    putBlockAndMetadata(i + byte0, j, k - byte1, i1, 3, flag);
                    putBlockAndMetadata(i - byte0, j, k + byte1, i1, 7, flag);
                    putBlockAndMetadata(i - byte0, j, k - byte1, i1, 1, flag);
                }
            }

        }

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
