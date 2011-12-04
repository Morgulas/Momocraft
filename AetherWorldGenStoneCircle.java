package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenStoneCircle extends AetherWorldGenerator {

	 public AetherWorldGenStoneCircle()
	    {
	    }

	    public boolean generate(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        for(int l = -3; l <= 3; l++)
	        {
	            for(int j1 = -3; j1 <= 3; j1++)
	            {
	                for(int k1 = 0; k1 <= 4; k1++)
	                {
	                    if(!world.getBlockMaterial(i + l, j - 1, k + j1).isSolid())
	                    {
	                        return false;
	                    }
	                    if(!world.isAirBlock(i + l, j + k1, k + j1))
	                    {
	                        return false;
	                    }
	                }

	            }

	        }

	        for(int i1 = 0; i1 <= 2; i1++)
	        {
	            putBlock(i - 3, j + i1, k, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i + 3, j + i1, k, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i, j + i1, k - 3, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i, j + i1, k + 3, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i - 2, j + i1, k - 2, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i + 2, j + i1, k - 2, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i - 2, j + i1, k + 2, MomocraftBlocks.TestBlock.blockID, true);
	            putBlock(i + 2, j + i1, k + 2, MomocraftBlocks.TestBlock.blockID, true);
	        }

	        return true;
	    }

}
