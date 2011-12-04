package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenHollowHill extends AetherWorldGenerator{

	 int hsize;
	    int radius;
	    int sn;
	    int mg;
	    int tc;
	    int hx;
	    int hy;
	    int hz;
	    Random hillRNG;

	    public AetherWorldGenHollowHill(int i)
	    {
	        hsize = i;
	        radius = (hsize * 2 + 1) * 8 - 6;
	        int j = (int)(3.1415926535897931D * (double)radius * (double)radius);
	        sn = j / 16;
	        int ai[] = {
	            0, 3, 9, 18
	        };
	        mg = ai[hsize];
	        int ai1[] = {
	            0, 2, 6, 12
	        };
	        tc = ai1[hsize];
	    }

	    public boolean generate(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        hx = i;
	        hy = j;
	        hz = k;
	        hillRNG = random;
	        for(int l = 0; l < mg; l++)
	        {
	            int ai1[] = getCoordsInHill2D();
	            placeMobSpawner(ai1[0], hy + random.nextInt(4), ai1[1]);
	        }

	        for(int i1 = 0; i1 < tc; i1++)
	        {
	            int ai2[] = getCoordsInHill2D();
	            placeTreasureChest(ai2[0], hy, ai2[1]);
	        }

	        for(int j1 = 0; j1 < sn; j1++)
	        {
	            int ai3[] = getCoordsInHill2D();
	            AetherWorldGenCaveStalactite tfgencavestalactite = AetherWorldGenCaveStalactite.makeRandomOreStalactite(random, hsize);
	            tfgencavestalactite.generate(worldObj, random, ai3[0], hy + 1, ai3[1]);
	        }

	        for(int k1 = 0; k1 < sn; k1++)
	        {
	            int ai4[] = getCoordsInHill2D();
	            (new AetherWorldGenCaveStalactite(Block.stone.blockID, random.nextDouble(), true)).generate(worldObj, random, ai4[0], hy + 1, ai4[1]);
	        }

	        for(int l1 = 0; l1 < sn; l1++)
	        {
	            int ai5[] = getCoordsInHill2D();
	            (new AetherWorldGenCaveStalactite(Block.stone.blockID, random.nextDouble() * 0.69999999999999996D, false)).generate(worldObj, random, ai5[0], hy + 1, ai5[1]);
	        }

	        if(hsize == 3)
	        {
	            int ai[] = getEmptyCoordsInHill(hy + 10, 20);
	            placeWraithSpawner(ai[0], hy + 10, ai[1]);
	            ai = getEmptyCoordsInHill(hy + 10, 20);
	            placeWraithSpawner(ai[0], hy + 10, ai[1]);
	        }
	        return true;
	    }

	    boolean isInHill(int i, int j)
	    {
	        int k = hx - i;
	        int l = hz - j;
	        int i1 = (int)Math.sqrt(k * k + l * l);
	        return i1 < radius;
	    }

	    int[] getCoordsInHill2D()
	    {
	        return getCoordsInHill2D(radius);
	    }

	    int[] getCoordsInHill2D(int i)
	    {
	        int j;
	        int k;
	        do
	        {
	            j = (hx + hillRNG.nextInt(2 * i)) - i;
	            k = (hz + hillRNG.nextInt(2 * i)) - i;
	        } while(!isInHill(j, k));
	        int ai[] = {
	            j, k
	        };
	        return ai;
	    }

	    int[] getEmptyCoordsInHill(int i, int j)
	    {
	        int k;
	        int l;
	        int i1;
	        do
	        {
	            k = (hx + hillRNG.nextInt(2 * j)) - j;
	            l = (hz + hillRNG.nextInt(2 * j)) - j;
	            i1 = worldObj.getBlockId(k, i, l);
	        } while(!isInHill(k, l) || i1 != 0);
	        int ai[] = {
	            k, l
	        };
	        return ai;
	    }

	    protected boolean placeMobSpawner(int i, int j, int k)
	    {
	        worldObj.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
	        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)worldObj.getBlockTileEntity(i, j, k);
	        if(tileentitymobspawner != null)
	        {
	            tileentitymobspawner.setMobID(getMobID(hsize));
	        }
	        return true;
	    }

	    protected boolean placeWraithSpawner(int i, int j, int k)
	    {
	        worldObj.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
	        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)worldObj.getBlockTileEntity(i, j, k);
	        if(tileentitymobspawner != null)
	        {
	            tileentitymobspawner.setMobID("Twilight Wraith");
	        }
	        return true;
	    }

	    protected String getMobID(int i)
	    {
	        if(i == 1)
	        {
	            return getLevel1Mob();
	        }
	        if(i == 2)
	        {
	            return getLevel2Mob();
	        }
	        if(i == 3)
	        {
	            return getLevel3Mob();
	        } else
	        {
	            return "Spider";
	        }
	    }

	    public String getLevel1Mob()
	    {
	        switch(hillRNG.nextInt(10))
	        {
	        case 0: // '\0'
	        case 1: // '\001'
	        case 2: // '\002'
	            return "Swarm Spider";

	        case 3: // '\003'
	        case 4: // '\004'
	        case 5: // '\005'
	            return "Spider";

	        case 6: // '\006'
	        case 7: // '\007'
	            return "Zombie";

	        case 8: // '\b'
	            return "Silverfish";

	        case 9: // '\t'
	            return "Redcap";
	        }
	        return "Swarm Spider";
	    }

	    public String getLevel2Mob()
	    {
	        switch(hillRNG.nextInt(10))
	        {
	        case 0: // '\0'
	        case 1: // '\001'
	        case 2: // '\002'
	            return "Redcap";

	        case 3: // '\003'
	        case 4: // '\004'
	        case 5: // '\005'
	            return "Zombie";

	        case 6: // '\006'
	        case 7: // '\007'
	            return "Skeleton";

	        case 8: // '\b'
	            return "Swarm Spider";

	        case 9: // '\t'
	            return "CaveSpider";
	        }
	        return "Redcap";
	    }

	    public String getLevel3Mob()
	    {
	        switch(hillRNG.nextInt(11))
	        {
	        case 0: // '\0'
	        case 1: // '\001'
	        case 2: // '\002'
	            return "Enderman";

	        case 3: // '\003'
	        case 4: // '\004'
	        case 5: // '\005'
	            return "Skeleton";

	        case 6: // '\006'
	        case 7: // '\007'
	        case 8: // '\b'
	            return "CaveSpider";

	        case 9: // '\t'
	            return "Creeper";

	        case 10: // '\n'
	            return "Twilight Wraith";
	        }
	        return "Enderman";
	    }

	    protected boolean placeTreasureChest(int i, int j, int k)
	    {
	        return AetherWorldTreasure.hill1.generate(worldObj, hillRNG, i, j, k);
	    }

	    protected boolean placeTreasureChestOld(int i, int j, int k)
	    {
	        worldObj.setBlockWithNotify(i, j, k, Block.chest.blockID);
	        TileEntityChest tileentitychest = (TileEntityChest)worldObj.getBlockTileEntity(i, j, k);
	        if(tileentitychest != null && tileentitychest.getSizeInventory() > 0)
	        {
	            int l = hillRNG.nextInt(4) + hillRNG.nextInt(4) + 2;
	            for(int i1 = 0; i1 < l; i1++)
	            {
	                tileentitychest.setInventorySlotContents(i1, getTreasure(hsize));
	            }

	        }
	        return true;
	    }

	    protected ItemStack getTreasure(int i)
	    {
	        if(i == 1)
	        {
	            switch(hillRNG.nextInt(6))
	            {
	            case 0: // '\0'
	                return new ItemStack(Item.ingotIron, hillRNG.nextInt(4) + 1);

	            case 1: // '\001'
	                return new ItemStack(Item.bucketEmpty);

	            case 2: // '\002'
	                return new ItemStack(Item.bread);

	            case 4: // '\004'
	                return new ItemStack(Item.wheat, hillRNG.nextInt(3) + 1);

	            case 3: // '\003'
	            case 5: // '\005'
	            default:
	                return new ItemStack(Block.torchWood, hillRNG.nextInt(16) + 1);
	            }
	        }
	        if(i == 2)
	        {
	            switch(hillRNG.nextInt(8))
	            {
	            case 0: // '\0'
	            case 1: // '\001'
	            case 2: // '\002'
	                return getTreasure(1);

	            case 4: // '\004'
	                return new ItemStack(Item.ingotGold, hillRNG.nextInt(6) + 1);

	            case 5: // '\005'
	                return new ItemStack(Item.saddle);

	            case 6: // '\006'
	                return new ItemStack(Item.dyePowder, hillRNG.nextInt(10) + 1, hillRNG.nextInt(16));

	            case 3: // '\003'
	            case 7: // '\007'
	            default:
	                return new ItemStack(Item.bowlSoup);
	            }
	        }
	        if(i == 3)
	        {
	            switch(hillRNG.nextInt(8))
	            {
	            case 0: // '\0'
	            case 1: // '\001'
	            case 2: // '\002'
	                return getTreasure(2);

	            case 4: // '\004'
	                return new ItemStack(Item.appleGold);

	            case 5: // '\005'
	                return new ItemStack(Item.record13);

	            case 6: // '\006'
	                return new ItemStack(Item.saddle);

	            case 3: // '\003'
	            case 7: // '\007'
	            default:
	                return new ItemStack(Item.diamond);
	            }
	        } else
	        {
	            return new ItemStack(Item.coal, hillRNG.nextInt(16) + 1);
	        }
	    }
	
}
