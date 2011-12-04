package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenCaveStalactite extends AetherWorldGenerator{

	 public double size;
	    public int bType;
	    public boolean hang;
	    public int dir;

	    public AetherWorldGenCaveStalactite(int i, double d, boolean flag)
	    {
	        bType = i;
	        size = d;
	        hang = flag;
	        dir = hang ? -1 : 1;
	    }

	    public static AetherWorldGenCaveStalactite makeRandomOreStalactite(Random random, int i)
	    {
	        if(i >= 3)
	        {
	            int j = random.nextInt(6);
	            if(j == 0)
	            {
	                return new AetherWorldGenCaveStalactite(Block.oreDiamond.blockID, random.nextDouble() * 0.5D, true);
	            }
	            if(j == 1)
	            {
	                return new AetherWorldGenCaveStalactite(Block.oreLapis.blockID, random.nextDouble() * 0.80000000000000004D, true);
	            }
	        }
	        if(i >= 2)
	        {
	            int k = random.nextInt(6);
	            if(k == 0)
	            {
	                return new AetherWorldGenCaveStalactite(Block.oreGold.blockID, random.nextDouble() * 0.59999999999999998D, true);
	            }
	            if(k == 1 || k == 2)
	            {
	                return new AetherWorldGenCaveStalactite(Block.oreRedstone.blockID, random.nextDouble() * 0.80000000000000004D, true);
	            }
	        }
	        int l = random.nextInt(5);
	        if(l == 0 || l == 1)
	        {
	            return new AetherWorldGenCaveStalactite(Block.oreIron.blockID, random.nextDouble() * 0.69999999999999996D, true);
	        }
	        if(l == 2 || l == 3)
	        {
	            return new AetherWorldGenCaveStalactite(Block.oreCoal.blockID, random.nextDouble() * 0.80000000000000004D, true);
	        } else
	        {
	            return new AetherWorldGenCaveStalactite(Block.glowStone.blockID, random.nextDouble() * 0.5D, true);
	        }
	    }

	    public boolean generate(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        int l = 129;
	        int i1 = -1;
	        int j1 = j;
	        do
	        {
	            if(j1 >= 128)
	            {
	                break;
	            }
	            Material material = worldObj.getBlockMaterial(i, j1, k);
	            if(material != Material.air)
	            {
	                if(material != Material.ground && material != Material.rock)
	                {
	                    return false;
	                }
	                l = j1;
	                break;
	            }
	            j1++;
	        } while(true);
	        if(l == 129)
	        {
	            return false;
	        }
	        j1 = j;
	        do
	        {
	            if(j1 <= 4)
	            {
	                break;
	            }
	            Material material1 = worldObj.getBlockMaterial(i, j1, k);
	            if(material1 != Material.air)
	            {
	                if(material1 != Material.ground && material1 != Material.rock && !hang && material1 != Material.water && !hang && material1 != Material.lava)
	                {
	                    return false;
	                }
	                i1 = j1;
	                break;
	            }
	            j1--;
	        } while(true);
	        j1 = (int)((double)(l - i1) * size);
	        if(bType == Block.oreDiamond.blockID && j1 > 4)
	        {
	            j1 = 4;
	        }
	        if(bType == Block.oreGold.blockID && j1 > 6)
	        {
	            j1 = 6;
	        }
	        return makeSpike(random, i, hang ? l : i1, k, j1);
	    }

	    public boolean makeSpike(Random random, int i, int j, int k, int l)
	    {
	        int i1 = (int)((double)l / 4.5D);
	        for(int j1 = -i1; j1 <= i1; j1++)
	        {
	            for(int k1 = -i1; k1 <= i1; k1++)
	            {
	                int l1 = Math.abs(j1);
	                int i2 = Math.abs(k1);
	                int j2 = (int)((double)Math.max(l1, i2) + (double)Math.min(l1, i2) * 0.5D);
	                int k2 = 0;
	                if(j2 == 0)
	                {
	                    k2 = l;
	                }
	                if(j2 > 0)
	                {
	                    k2 = random.nextInt((int)((double)l / ((double)j2 + 0.25D)));
	                }
	                for(int l2 = 0; l2 != k2 * dir; l2 += dir)
	                {
	                    putBlock(i + j1, j + l2, k + k1, bType, false);
	                }

	            }

	        }

	        return true;
	    }

	    public boolean generateOld(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        if(!world.isAirBlock(i, j, k))
	        {
	            return false;
	        }
	        if(world.getBlockId(i, j + 1, k) != Block.stone.blockID && world.getBlockId(i, j + 1, k) != Block.dirt.blockID)
	        {
	            return false;
	        } else
	        {
	            drawDiameterCircle(i, j + 1, k, 3, (byte)bType, 0, false);
	            drawDiameterCircle(i, j, k, 3, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 1, k, 3, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 2, k, 2, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 3, k, 2, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 4, k, 2, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 5, k, 1, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 6, k, 1, (byte)bType, 0, false);
	            drawDiameterCircle(i, j - 7, k, 1, (byte)bType, 0, false);
	            return true;
	        }
	    }
	
}
