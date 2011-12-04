package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public abstract class AetherWorldGenerator extends WorldGenerator{
	
	protected World worldObj;

    public AetherWorldGenerator()
    {
    }

    public abstract boolean generate(World world, Random random, int i, int j, int k);

    protected boolean putBlock(int i, int j, int k, int l, boolean flag)
    {
        return putBlockAndMetadata(i, j, k, l, 0, flag);
    }

    protected boolean putBlockAndMetadata(int i, int j, int k, int l, int i1, boolean flag)
    {
        if(flag)
        {
            worldObj.setBlockAndMetadata(i, j, k, l, i1);
        } else
        {
            int j1 = worldObj.getBlockId(i, j, k);
            if(j1 == 0)
            {
                worldObj.setBlockAndMetadata(i, j, k, l, i1);
            } else
            {
                return false;
            }
        }
        return true;
    }

    protected void putBlockAndMetadata(int ai[], int i, int j, boolean flag)
    {
        putBlockAndMetadata(ai[0], ai[1], ai[2], i, j, flag);
    }

    protected void putBlock(int ai[], int i, boolean flag)
    {
        putBlockAndMetadata(ai[0], ai[1], ai[2], i, 0, flag);
    }

    protected static int[] translate(int i, int j, int k, double d, double d1, double d2)
    {
        int ai[] = {
            i, j, k
        };
        double d3 = d1 * 2D * 3.1415926535897931D;
        double d4 = d2 * 3.1415926535897931D;
        ai[0] += Math.round(Math.sin(d3) * Math.sin(d4) * d);
        ai[1] += Math.round(Math.cos(d4) * d);
        ai[2] += Math.round(Math.cos(d3) * Math.sin(d4) * d);
        return ai;
    }

    protected void drawBresehnam(int i, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag)
    {
        drawBresehnam(i, j, k, l, i1, j1, k1, 0, flag);
    }

    protected void drawBresehnam(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        int ai[] = {
            i, j, k
        };
        int l2 = l - i;
        int i3 = i1 - j;
        int j3 = j1 - k;
        byte byte0 = ((byte)(l2 >= 0 ? 1 : -1));
        int k3 = Math.abs(l2);
        byte byte1 = ((byte)(i3 >= 0 ? 1 : -1));
        int l3 = Math.abs(i3);
        byte byte2 = ((byte)(j3 >= 0 ? 1 : -1));
        int i4 = Math.abs(j3);
        int l5 = k3 << 1;
        int i6 = l3 << 1;
        int j6 = i4 << 1;
        if(k3 >= l3 && k3 >= i4)
        {
            int j4 = i6 - k3;
            int i5 = j6 - k3;
            for(int i2 = 0; i2 < k3; i2++)
            {
                putBlockAndMetadata(ai, k1, l1, flag);
                if(j4 > 0)
                {
                    ai[1] += byte1;
                    j4 -= l5;
                }
                if(i5 > 0)
                {
                    ai[2] += byte2;
                    i5 -= l5;
                }
                j4 += i6;
                i5 += j6;
                ai[0] += byte0;
            }

        } else
        if(l3 >= k3 && l3 >= i4)
        {
            int k4 = l5 - l3;
            int j5 = j6 - l3;
            for(int j2 = 0; j2 < l3; j2++)
            {
                putBlockAndMetadata(ai, k1, l1, flag);
                if(k4 > 0)
                {
                    ai[0] += byte0;
                    k4 -= i6;
                }
                if(j5 > 0)
                {
                    ai[2] += byte2;
                    j5 -= i6;
                }
                k4 += l5;
                j5 += j6;
                ai[1] += byte1;
            }

        } else
        {
            int l4 = i6 - i4;
            int k5 = l5 - i4;
            for(int k2 = 0; k2 < i4; k2++)
            {
                putBlockAndMetadata(ai, k1, l1, flag);
                if(l4 > 0)
                {
                    ai[1] += byte1;
                    l4 -= j6;
                }
                if(k5 > 0)
                {
                    ai[0] += byte0;
                    k5 -= j6;
                }
                l4 += i6;
                k5 += l5;
                ai[2] += byte2;
            }

        }
        putBlockAndMetadata(ai, k1, l1, flag);
    }

    public void drawCircle(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        for(byte byte0 = 0; byte0 <= l; byte0++)
        {
            for(byte byte1 = 0; byte1 <= l; byte1++)
            {
                int k1 = (int)((double)Math.max(byte0, byte1) + (double)Math.min(byte0, byte1) * 0.5D);
                if(byte0 == 3 && byte1 == 3)
                {
                    k1 = 6;
                }
                if(k1 <= l)
                {
                    putBlockAndMetadata(i + byte0, j, k + byte1, i1, j1, flag);
                    putBlockAndMetadata(i + byte0, j, k - byte1, i1, j1, flag);
                    putBlockAndMetadata(i - byte0, j, k + byte1, i1, j1, flag);
                    putBlockAndMetadata(i - byte0, j, k - byte1, i1, j1, flag);
                }
            }

        }

    }

    public void drawDiameterCircle(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        byte byte0 = (byte)((l - 1) / 2);
        if(l % 2 == 1)
        {
            drawCircle(i, j, k, byte0, (byte)i1, j1, flag);
        } else
        {
            drawCircle(i, j, k, byte0, (byte)i1, j1, flag);
            drawCircle(i + 1, j, k, byte0, (byte)i1, j1, flag);
            drawCircle(i, j, k + 1, byte0, (byte)i1, j1, flag);
            drawCircle(i + 1, j, k + 1, byte0, (byte)i1, j1, flag);
        }
    }

    protected byte randStone(Random random, int i)
    {
        return random.nextInt(i) < 1 ? (byte)Block.cobblestoneMossy.blockID : (byte)Block.cobblestone.blockID;
    }

    protected boolean isAreaClear(World world, Random random, int i, int j, int k, int l, int i1, 
            int j1)
    {
        boolean flag = true;
        for(int k1 = 0; k1 < l; k1++)
        {
            for(int l1 = 0; l1 < i1; l1++)
            {
                Material material = world.getBlockMaterial(i + k1, j - 1, k + l1);
                if(material != Material.ground && material != Material.grass && material != Material.rock)
                {
                    flag = false;
                }
                for(int i2 = 0; i2 < j1; i2++)
                {
                    if(!world.isAirBlock(i + k1, j + i2, k + l1))
                    {
                        flag = false;
                    }
                }

            }

        }

        return flag;
    }

    protected void fill(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        for(int i2 = 0; i2 < l; i2++)
        {
            for(int j2 = 0; j2 < i1; j2++)
            {
                for(int k2 = 0; k2 < j1; k2++)
                {
                    worldObj.setBlockAndMetadata(i + i2, j + j2, k + k2, k1, l1);
                }

            }

        }

    }
	
}
