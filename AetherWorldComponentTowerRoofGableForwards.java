package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldComponentTowerRoofGableForwards extends AetherWorldComponentTowerRoof{

	
	public AetherWorldComponentTowerRoofGableForwards(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size + 2;
        height = size;
        makeAttachedOverhangBB(componenttftowerwing);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = slopeChangeForSize(size);
        for(int j = 0; j <= height; j++)
        {
            int l;
            int j1;
            if(j < i)
            {
                l = j;
                j1 = size - j - 1;
            } else
            {
                l = (j + i) / 2;
                j1 = size - (j + i) / 2 - 1;
            }
            for(int k1 = 0; k1 <= size - 2; k1++)
            {
                for(int l1 = l; l1 <= j1; l1++)
                {
                    if(l1 == l || l1 == j1)
                    {
                        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, k1, j, l1, structureboundingbox);
                        continue;
                    }
                    if(k1 < size - 2)
                    {
                        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 5, k1, j, l1, structureboundingbox);
                    }
                }

            }

        }

        int k = (size + 1) - i;
        int i1 = size / 2;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 0, k, i1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, size - 3, k, i1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, size - 2, k, i1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, size - 1, k, i1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, size - 1, k + 1, i1, structureboundingbox);
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
