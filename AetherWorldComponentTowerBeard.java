package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldComponentTowerBeard extends AetherWorldStructureComponent{

    int size;
    int height;

    public AetherWorldComponentTowerBeard(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size - 2;
        height = size / 2;
        boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX + 1, componenttftowerwing.boundingBox.minY - height - 1, componenttftowerwing.boundingBox.minZ + 1, componenttftowerwing.boundingBox.maxX - 1, componenttftowerwing.boundingBox.minY - 1, componenttftowerwing.boundingBox.maxZ - 1);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        return makePyramidBeard(world, structureboundingbox);
    }

    private boolean makePyramidBeard(World world, StructureBoundingBox structureboundingbox)
    {
        for(int i = 0; i <= height; i++)
        {
            int j = i;
            int k = size - i - 1;
            for(int l = j; l <= k; l++)
            {
                for(int i1 = j; i1 <= k; i1++)
                {
                    placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, l, height - i, i1, structureboundingbox);
                }

            }

        }

        return true;
    }
	
}
