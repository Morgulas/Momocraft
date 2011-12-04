package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofPointy extends AetherWorldComponentTowerRoof{
	 public AetherWorldComponentTowerRoofPointy(int i, AetherWorldComponentTowerWing componenttftowerwing)
	    {
	        super(i, componenttftowerwing);
	        coordBaseMode = componenttftowerwing.coordBaseMode;
	        size = componenttftowerwing.size;
	        height = size;
	        makeCapBB(componenttftowerwing);
	    }

	    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
	    {
	        for(int i = 0; i <= height; i++)
	        {
	            int i1 = slopeChangeForSize(size);
	            int j;
	            int l;
	            if(i < i1)
	            {
	                j = i;
	                l = size - i - 1;
	            } else
	            {
	                j = (i + i1) / 2;
	                l = size - (i + i1) / 2 - 1;
	            }
	            int k = j + (l - j) / 2;
	            for(int j1 = j; j1 <= l; j1++)
	            {
	                for(int k1 = j; k1 <= l; k1++)
	                {
	                    placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, j1, i, k1, structureboundingbox);
	                    if(j1 == j && (k1 == j || k1 == l) || j1 == l && (k1 == j || k1 == l))
	                    {
	                        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, j1, i + 1, k1, structureboundingbox);
	                    }
	                    if(((j1 == j || j1 == l) && k1 == k && j1 % 2 == 0 || (k1 == j || k1 == l) && j1 == k && k1 % 2 == 0) && k != j + 1)
	                    {
	                        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, j1, i + 1, k1, structureboundingbox);
	                    }
	                }

	            }

	        }

	        return true;
	    }

	    public int slopeChangeForSize(int i)
	    {
	        if(size > 10)
	        {
	            return 3;
	        }
	        return size <= 6 ? 1 : 2;
	    }
}
