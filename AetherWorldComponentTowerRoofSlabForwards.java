package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofSlabForwards extends AetherWorldComponentTowerRoofSlab{

	public AetherWorldComponentTowerRoofSlabForwards(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size + 2;
        height = size / 2;
        makeAttachedOverhangBB(componenttftowerwing);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        for(int i = 0; i <= height; i++)
        {
            int j = 2 * i;
            int k = size - 2 * i - 1;
            for(int l = 0; l <= k - 1; l++)
            {
                for(int i1 = j; i1 <= k; i1++)
                {
                    if(l == k - 1 || i1 == j || i1 == k)
                    {
                        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, l, i, i1, structureboundingbox);
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
