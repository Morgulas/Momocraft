package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofSlab extends AetherWorldComponentTowerRoof{
	
	public AetherWorldComponentTowerRoofSlab(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size;
        height = size / 2;
        makeCapBB(componenttftowerwing);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        return makePyramidCap(world, structureboundingbox);
    }

    protected boolean makePyramidCap(World world, StructureBoundingBox structureboundingbox)
    {
        for(int i = 0; i <= height; i++)
        {
            int j = 2 * i;
            int k = size - 2 * i - 1;
            for(int l = j; l <= k; l++)
            {
                for(int i1 = j; i1 <= k; i1++)
                {
                    if(l == j || l == k || i1 == j || i1 == k)
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

    protected boolean makeConnectedCap(World world, StructureBoundingBox structureboundingbox)
    {
        for(int i = 0; i < height; i++)
        {
            int j = 2 * i;
            int k = size - 2 * i - 1;
            for(int l = 0; l <= k; l++)
            {
                for(int i1 = j; i1 <= k; i1++)
                {
                    if(l == k || i1 == j || i1 == k)
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
