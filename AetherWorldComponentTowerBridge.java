package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldComponentTowerBridge extends AetherWorldComponentTowerWing{

	 int dSize;
	    int dHeight;

	    public AetherWorldComponentTowerBridge(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        super(i, j, k, l, 3, 3, k1);
	        dSize = i1;
	        dHeight = j1;
	    }

	    public void buildComponent(StructureComponent structurecomponent, List list, Random random)
	    {
	        int ai[] = {
	            2, 1, 1
	        };
	        makeTowerWing(list, random, 1, ai[0], ai[1], ai[2], dSize, dHeight, 0);
	    }

	    public StructureBoundingBox getWingBB()
	    {
	        int ai[] = offsetTowerCoords(2, 1, 1, dSize, coordBaseMode);
	        return AetherWorldStructureComponent.getComponentToAddBoundingBox(ai[0], ai[1], ai[2], 0, 0, 0, dSize - 1, dHeight - 1, dSize - 1, coordBaseMode);
	    }

	    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
	    {
	        for(int i = 0; i < 3; i++)
	        {
	            placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i, 2, 0, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i, 2, 2, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, 1, 0, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, 1, 2, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, 0, 0, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, 0, 1, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, 0, 2, structureboundingbox);
	            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, -1, 1, structureboundingbox);
	        }

	        return true;
	    }
	
}
