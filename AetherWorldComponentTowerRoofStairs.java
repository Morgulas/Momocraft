package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofStairs extends AetherWorldComponentTowerRoof{

	  public AetherWorldComponentTowerRoofStairs(int i, AetherWorldComponentTowerWing componenttftowerwing)
	    {
	        super(i, componenttftowerwing);
	        coordBaseMode = 0;
	        size = componenttftowerwing.size;
	        height = size / 2;
	        makeCapBB(componenttftowerwing);
	    }

	    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
	    {
	        for(int i = 0; i <= height; i++)
	        {
	            int j = i;
	            int k = size - i - 1;
	            for(int l = j; l <= k; l++)
	            {
	                for(int i1 = j; i1 <= k; i1++)
	                {
	                    if(l == j)
	                    {
	                        if(i1 == j || i1 == k)
	                        {
	                            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, l, i, i1, structureboundingbox);
	                        } else
	                        {
	                            placeBlockAtCurrentPosition(world, Block.stairCompactPlanks.blockID, 0, l, i, i1, structureboundingbox);
	                        }
	                        continue;
	                    }
	                    if(l == k)
	                    {
	                        if(i1 == j || i1 == k)
	                        {
	                            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, l, i, i1, structureboundingbox);
	                        } else
	                        {
	                            placeBlockAtCurrentPosition(world, Block.stairCompactPlanks.blockID, 1, l, i, i1, structureboundingbox);
	                        }
	                        continue;
	                    }
	                    if(i1 == k)
	                    {
	                        placeBlockAtCurrentPosition(world, Block.stairCompactPlanks.blockID, 3, l, i, i1, structureboundingbox);
	                        continue;
	                    }
	                    if(i1 == j)
	                    {
	                        placeBlockAtCurrentPosition(world, Block.stairCompactPlanks.blockID, 2, l, i, i1, structureboundingbox);
	                    } else
	                    {
	                        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, l, i, i1, structureboundingbox);
	                    }
	                }

	            }

	        }

	        return true;
	    }
	
}
