package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofFence  extends AetherWorldComponentTowerRoof{

    public AetherWorldComponentTowerRoofFence(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size;
        height = 0;
        makeCapBB(componenttftowerwing);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = height + 1;
        for(int j = 0; j <= size - 1; j++)
        {
            for(int k = 0; k <= size - 1; k++)
            {
                if(j == 0 || j == size - 1 || k == 0 || k == size - 1)
                {
                    placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, j, i, k, structureboundingbox);
                }
            }

        }

        return true;
    }
	
}
