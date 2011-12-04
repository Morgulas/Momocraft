package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenMeadowTree extends AetherWorldGenerator{

	private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int height;
    private int diameter;
    private int treeBlock;
    private int leafBlock;
    static int treesMade = 0;
    static long totalTime = 0L;
    int leafBlobsMade;
    int leavesMade;

    public AetherWorldGenMeadowTree()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        long l = System.currentTimeMillis();
        worldObj = world;
        treeRNG = random;
        x = i;
        y = j;
        z = k;
        treeBlock = MomocraftBlocks.TestBlock.blockID;
        leafBlock = MomocraftBlocks.TestBlock.leaves.blockID;
        leafBlobsMade = 0;
        height = 30;
        diameter = 7;
        if(y < 1 || y + height + diameter + 1 > 128)
        {
            return false;
        }
        for(int i1 = -diameter; i1 <= diameter; i1++)
        {
            for(int k1 = -diameter; k1 <= diameter; k1++)
            {
                for(int j2 = 1; j2 <= height; j2++)
                {
                    int i3 = worldObj.getBlockId(i1 + x, j2 + y, k1 + z);
                    if(i3 != 0)
                    {
                        if(i3 == Block.leaves.blockID);
                    }
                }

            }

        }

        int j1 = diameter * 4 + 8;
        for(int l1 = -j1; l1 <= j1; l1++)
        {
            for(int k2 = -j1; k2 <= j1; k2++)
            {
                for(int j3 = height - j1; j3 <= height + j1; j3++)
                {
                    int j4 = worldObj.getBlockId(l1 + x, j3 + y, k2 + z);
                    if(j4 != 0)
                    {
                        if(j4 == Block.leaves.blockID);
                    }
                }

            }

        }

        int i2 = world.getBlockId(x, y - 1, z);
        if(i2 == Block.grass.blockID || i2 == Block.dirt.blockID)
        {
            if(y < 128 - height - 1);
        }
        buildTrunk();
        int l2 = treeRNG.nextInt(3 * diameter) + 5;
        for(int k3 = 0; k3 <= l2; k3++)
        {
            int k4 = (int)((double)height * treeRNG.nextDouble() * 0.90000000000000002D) + height / 10;
            double d = treeRNG.nextDouble();
            addFirefly(k4, d);
        }

        l2 = treeRNG.nextInt(3 * diameter) + 5;
        for(int l3 = 0; l3 <= l2; l3++)
        {
            int l4 = (int)((double)height * treeRNG.nextDouble() * 0.90000000000000002D) + height / 10;
            double d1 = treeRNG.nextDouble();
            addCicada(l4, d1);
        }

        buildFullCrown();
        int i4 = treeRNG.nextInt(3) + 3;
        for(int i5 = 0; i5 <= i4; i5++)
        {
            int j5 = (int)((double)height * treeRNG.nextDouble() * 0.90000000000000002D) + height / 10;
            double d2 = treeRNG.nextDouble();
            makeSmallBranch(j5, 4D, d2, 0.34999999999999998D, true);
        }

        buildBranchRing(3, 2, 6, 0, 0.75D, 0.0D, 3, 5, 3, false);
        treesMade++;
        long l5 = System.currentTimeMillis() - l;
        totalTime += l5;
        return true;
    }

    private void buildFullCrown()
    {
        byte byte0 = 48;
        int i = diameter + 2;
        buildBranchRing(22, 0, byte0, 0, 0.47999999999999998D, 0.0D, i, i + 2, 2, true);
        buildBranchRing(22, 0, byte0, 0, 0.34999999999999998D, 0.0D, i, i + 2, 2, true);
        buildBranchRing(23, 0, byte0, 0, 0.28000000000000003D, 0.0D, i, i + 2, 1, true);
        buildBranchRing(24, 0, byte0, 0, 0.14999999999999999D, 0.0D, 2, 4, 1, true);
        buildBranchRing(24, 0, byte0, 0, 0.050000000000000003D, 0.0D, i, i + 2, 1, true);
    }

    private void buildBranchRing(int i, int j, int k, int l, double d, double d1, int i1, int j1, int k1, boolean flag)
    {
        int l1 = treeRNG.nextInt(j1 - i1) + i1;
        double d2 = 1.0D / (double)l1;
        double d3 = treeRNG.nextDouble();
        for(int i2 = 0; i2 <= l1; i2++)
        {
            int j2;
            if(j > 0)
            {
                j2 = (i - j) + treeRNG.nextInt(2 * j);
            } else
            {
                j2 = i;
            }
            if(k1 == 2)
            {
                makeLargeBranch(j2, k, (double)i2 * d2 + d3, d, flag);
                continue;
            }
            if(k1 == 1)
            {
                makeMedBranch(j2, k, (double)i2 * d2 + d3, d, flag);
                continue;
            }
            if(k1 == 3)
            {
                makeRoot(j2, k, (double)i2 * d2 + d3, d);
            } else
            {
                makeSmallBranch(j2, k, (double)i2 * d2 + d3, d, flag);
            }
        }

    }

    private void buildTrunk()
    {
        int i = diameter / 2;
        for(int j = -diameter; j <= diameter; j++)
        {
            for(int l = -diameter; l <= diameter; l++)
            {
                for(int j1 = 0; j1 <= height; j1++)
                {
                    int l1 = Math.abs(j);
                    int j2 = Math.abs(l);
                    int l2 = (int)((double)Math.max(l1, j2) + (double)Math.min(l1, j2) * 0.5D);
                    if(l2 <= diameter && l2 > i)
                    {
                        putBlock(j + x, j1 + y, l + z, treeBlock, true);
                    }
                    if(l2 > i);
                    if(l2 == i && j == i)
                    {
                        putBlockAndMetadata(j + x, j1 + y, l + z, Block.ladder.blockID, 4, true);
                    }
                }

            }

        }

        for(int k = -diameter; k <= diameter; k++)
        {
            for(int i1 = -diameter; i1 <= diameter; i1++)
            {
                for(int k1 = -4; k1 < 0; k1++)
                {
                    int i2 = Math.abs(k);
                    int k2 = Math.abs(i1);
                    int i3 = (int)((double)Math.max(i2, k2) + (double)Math.min(i2, k2) * 0.5D);
                    if(i3 <= diameter && i3 > i)
                    {
                        putBlock(k + x, k1 + y, i1 + z, treeBlock, false);
                    }
                }

            }

        }

    }

    private void makeMedBranch(int i, double d, double d1, double d2, 
            boolean flag)
    {
        int j = x;
        int k = y + i;
        int l = z;
        int ai[] = translate(j, k, l, diameter, d1, 0.5D);
        makeMedBranch(ai[0], ai[1], ai[2], d, d1, d2, flag);
    }

    private void makeMedBranch(int i, int j, int k, double d, double d1, 
            double d2, boolean flag)
    {
        int ai[] = {
            i, j, k
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, true);
        if(flag)
        {
            int l = treeRNG.nextInt(2) + 1;
            for(int j1 = 0; j1 <= l; j1++)
            {
                double d4 = (treeRNG.nextDouble() * 0.59999999999999998D + 0.20000000000000001D) * d;
                int ai2[] = translate(ai[0], ai[1], ai[2], d4, d1, d2);
                drawBlob(ai2[0], ai2[1], ai2[2], 3, leafBlock, false);
            }

            drawBlob(ai1[0], ai1[1], ai1[2], 3, leafBlock, false);
        }
        int i1 = treeRNG.nextInt(2) + 1;
        double d3 = 0.80000000000000004D / (double)i1;
        for(int k1 = 0; k1 <= i1; k1++)
        {
            double d5 = d3 * (double)k1 - 0.40000000000000002D;
            double d6 = treeRNG.nextDouble() * 0.80000000000000004D + 0.20000000000000001D;
            double d7 = treeRNG.nextDouble() * 0.75D + 0.14999999999999999D;
            int ai3[] = translate(ai[0], ai[1], ai[2], d * d6, d1, d2);
            double d8 = d * 0.40000000000000002D;
            makeSmallBranch(ai3[0], ai3[1], ai3[2], d8, d1 + d5, d2 * d7, flag);
        }

    }

    private void makeSmallBranch(int i, int j, int k, double d, double d1, 
            double d2, boolean flag)
    {
        int ai[] = {
            i, j, k
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, true);
        if(flag)
        {
            byte byte0 = (byte)(treeRNG.nextInt(2) + 2);
            drawBlob(ai1[0], ai1[1], ai1[2], byte0, leafBlock, false);
        }
    }

    private void makeSmallBranch(int i, double d, double d1, double d2, 
            boolean flag)
    {
        int j = x;
        int k = y + i;
        int l = z;
        int ai[] = translate(j, k, l, diameter, d1, 0.5D);
        makeSmallBranch(ai[0], ai[1], ai[2], d, d1, d2, flag);
    }

    private void makeRoot(int i, double d, double d1, double d2)
    {
        int ai[] = translate(x, y + i, z, diameter, d1, 0.5D);
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, true);
        drawBresehnam(ai[0], ai[1] - 1, ai[2], ai1[0], ai1[1] - 1, ai1[2], treeBlock, true);
    }

    private void makeLargeBranch(int i, int j, int k, double d, double d1, 
            double d2, boolean flag)
    {
        int ai[] = {
            i, j, k
        };
        int ai1[] = translate(ai[0], ai[1], ai[2], d, d1, d2);
        drawBresehnam(ai[0], ai[1], ai[2], ai1[0], ai1[1], ai1[2], treeBlock, true);
        int l = treeRNG.nextInt(3);
        for(int i1 = 0; i1 <= l; i1++)
        {
            int k1 = (i1 & 2) != 0 ? 0 : 1;
            byte byte0 = ((byte)((i1 & 1) != 0 ? -1 : 1));
            int k2 = (i1 & 2) != 0 ? 1 : 0;
            drawBresehnam(ai[0] + k1, ai[1] + byte0, ai[2] + k2, ai1[0], ai1[1], ai1[2], treeBlock, true);
        }

        if(flag)
        {
            drawBlob(ai1[0], ai1[1] + 1, ai1[2], 4, leafBlock, false);
        }
        int j1 = treeRNG.nextInt((int)(d / 6D)) + treeRNG.nextInt(2) + 1;
        for(int l1 = 0; l1 <= j1; l1++)
        {
            double d3 = treeRNG.nextDouble() * 0.29999999999999999D + 0.29999999999999999D;
            double d5 = treeRNG.nextDouble() * 0.22500000000000001D * ((l1 & 1) != 0 ? -1D : 1.0D);
            int ai2[] = translate(ai[0], ai[1], ai[2], d * d3, d1, d2);
            makeMedBranch(ai2[0], ai2[1], ai2[2], d * 0.59999999999999998D, d1 + d5, d2, flag);
        }

        int i2 = treeRNG.nextInt(2) + 1;
        for(int j2 = 0; j2 <= i2; j2++)
        {
            double d4 = treeRNG.nextDouble() * 0.25D + 0.25D;
            double d6 = treeRNG.nextDouble() * 0.25D * ((j2 & 1) != 0 ? -1D : 1.0D);
            int ai3[] = translate(ai[0], ai[1], ai[2], d * d4, d1, d2);
            makeSmallBranch(ai3[0], ai3[1], ai3[2], Math.max(d * 0.29999999999999999D, 2D), d1 + d6, d2, flag);
        }

    }

    private void makeLargeBranch(int i, double d, double d1, double d2, 
            boolean flag)
    {
        int j = x;
        int k = y + i;
        int l = z;
        int ai[] = translate(j, k, l, diameter, d1, 0.5D);
        makeLargeBranch(ai[0], ai[1], ai[2], d, d1, d2, flag);
    }

    private void addFirefly(int i, double d)
    {
        int ai[] = translate(x, y + i, z, diameter + 1, d, 0.5D);
        d %= 1.0D;
        byte byte0 = 0;
        if(d > 0.875D || d <= 0.125D)
        {
            byte0 = 3;
        } else
        if(d > 0.125D && d <= 0.375D)
        {
            byte0 = 1;
        } else
        if(d > 0.375D && d <= 0.625D)
        {
            byte0 = 4;
        } else
        if(d > 0.625D && d <= 0.875D)
        {
            byte0 = 2;
        }
        if(MomocraftBlocks.TestBlock.canPlaceBlockAt(worldObj, ai[0], ai[1], ai[2]))
        {
            putBlockAndMetadata(ai[0], ai[1], ai[2], MomocraftBlocks.TestBlock.blockID, byte0, false);
        }
    }

    private void addCicada(int i, double d)
    {
        int ai[] = translate(x, y + i, z, diameter + 1, d, 0.5D);
        d %= 1.0D;
        byte byte0 = 0;
        if(d > 0.875D || d <= 0.125D)
        {
            byte0 = 3;
        } else
        if(d > 0.125D && d <= 0.375D)
        {
            byte0 = 1;
        } else
        if(d > 0.375D && d <= 0.625D)
        {
            byte0 = 4;
        } else
        if(d > 0.625D && d <= 0.875D)
        {
            byte0 = 2;
        }
        if(MomocraftBlocks.TestBlock.canPlaceBlockAt(worldObj, ai[0], ai[1], ai[2]))
        {
            putBlockAndMetadata(ai[0], ai[1], ai[2], MomocraftBlocks.TestBlock.blockID, byte0, false);
        }
    }

    private void drawBlob(int i, int j, int k, int l, int i1, boolean flag)
    {
        for(byte byte0 = 0; byte0 <= l; byte0++)
        {
            for(byte byte1 = 0; byte1 <= l; byte1++)
            {
                for(byte byte2 = 0; byte2 <= l; byte2++)
                {
                    byte byte3 = 0;
                    if(byte0 >= byte1 && byte0 >= byte2)
                    {
                        byte3 = (byte)(byte0 + (byte)(int)((double)Math.max(byte1, byte2) * 0.5D + (double)Math.min(byte1, byte2) * 0.25D));
                    } else
                    if(byte1 >= byte0 && byte1 >= byte2)
                    {
                        byte3 = (byte)(byte1 + (byte)(int)((double)Math.max(byte0, byte2) * 0.5D + (double)Math.min(byte0, byte2) * 0.25D));
                    } else
                    {
                        byte3 = (byte)(byte2 + (byte)(int)((double)Math.max(byte0, byte1) * 0.5D + (double)Math.min(byte0, byte1) * 0.25D));
                    }
                    if(byte3 <= l)
                    {
                        putBlock(i + byte0, j + byte1, k + byte2, i1, flag);
                        putBlock(i + byte0, j + byte1, k - byte2, i1, flag);
                        putBlock(i - byte0, j + byte1, k + byte2, i1, flag);
                        putBlock(i - byte0, j + byte1, k - byte2, i1, flag);
                        putBlock(i + byte0, j - byte1, k + byte2, i1, flag);
                        putBlock(i + byte0, j - byte1, k - byte2, i1, flag);
                        putBlock(i - byte0, j - byte1, k + byte2, i1, flag);
                        putBlock(i - byte0, j - byte1, k - byte2, i1, flag);
                    }
                }

            }

        }

        leafBlobsMade++;
    }

	
}
