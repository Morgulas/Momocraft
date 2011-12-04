package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenMonolith extends AetherWorldGenerator {

	 public AetherWorldGenMonolith()
	    {
	    }

	    public boolean generate(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        int l = random.nextInt(10) + 10;
	        int i1 = random.nextInt(4);
	        if(!isAreaClear(world, random, i, j, k, 2, l, 2))
	        {
	            return false;
	        }
	        int j1;
	        int k1;
	        int l1;
	        int i2;
	        switch(i1)
	        {
	        case 0: // '\0'
	            j1 = l;
	            k1 = (int)((double)l * 0.75D);
	            l1 = (int)((double)l * 0.75D);
	            i2 = (int)((double)l * 0.5D);
	            break;

	        case 1: // '\001'
	            j1 = (int)((double)l * 0.5D);
	            k1 = l;
	            l1 = (int)((double)l * 0.75D);
	            i2 = (int)((double)l * 0.75D);
	            break;

	        case 2: // '\002'
	            j1 = (int)((double)l * 0.75D);
	            k1 = (int)((double)l * 0.5D);
	            l1 = l;
	            i2 = (int)((double)l * 0.75D);
	            break;

	        case 3: // '\003'
	        default:
	            j1 = (int)((double)l * 0.75D);
	            k1 = (int)((double)l * 0.75D);
	            l1 = (int)((double)l * 0.5D);
	            i2 = l;
	            break;
	        }
	        for(int j2 = 0; j2 <= j1; j2++)
	        {
	            putBlock(i + 0, (j + j2) - 1, k + 0, j2 != l ? ((int) ((byte)Block.obsidian.blockID)) : ((int) ((byte)Block.blockLapis.blockID)), true);
	        }

	        for(int k2 = 0; k2 <= k1; k2++)
	        {
	            putBlock(i + 1, (j + k2) - 1, k + 0, k2 != l ? ((int) ((byte)Block.obsidian.blockID)) : ((int) ((byte)Block.blockLapis.blockID)), true);
	        }

	        for(int l2 = 0; l2 <= l1; l2++)
	        {
	            putBlock(i + 0, (j + l2) - 1, k + 1, l2 != l ? ((int) ((byte)Block.obsidian.blockID)) : ((int) ((byte)Block.blockLapis.blockID)), true);
	        }

	        for(int i3 = 0; i3 <= i2; i3++)
	        {
	            putBlock(i + 1, (j + i3) - 1, k + 1, i3 != l ? ((int) ((byte)Block.obsidian.blockID)) : ((int) ((byte)Block.blockLapis.blockID)), true);
	        }

	        return true;
	    }
}
