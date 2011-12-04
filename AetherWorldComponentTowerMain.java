package net.minecraft.src;

import java.util.List;
import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldComponentTowerMain extends AetherWorldComponentTowerWing
{
	  public AetherWorldComponentTowerMain(World world, Random random, int i, int j, int k, int l)
	    {
	        super(i, j, k, l, 15, 45 + random.nextInt(30), 0);
	    }

	    public void buildComponent(StructureComponent structurecomponent, List list, Random random)
	    {
	        makeARoof(structurecomponent, list, random);
	        for(int i = 0; i < 4; i++)
	        {
	            int ai[] = getValidOpening(random, i);
	            int i1 = Math.min(21 + random.nextInt(10), height - ai[1] - 3);
	            if(!makeTowerWing(list, random, 1, ai[0], ai[1], ai[2], 9, i1, i))
	            {
	                makeTowerWing(list, random, 1, ai[0], ai[1], ai[2], 7, i1, i);
	            }
	        }

	        for(int j = 0; j < 4; j++)
	        {
	            int ai1[] = getValidOpening(random, j);
	            int j1 = Math.min(7 + random.nextInt(6), height - ai1[1] - 3);
	            if(!makeTowerWing(list, random, 1, ai1[0], ai1[1], ai1[2], 5, j1, j))
	            {
	                makeTowerWing(list, random, 1, ai1[0], ai1[1], ai1[2], 3, j1, j);
	            }
	        }

	        for(int k = 0; k < 4; k++)
	        {
	            int ai2[] = getOutbuildingOpening(random, k);
	            int k1 = 11 + random.nextInt(10);
	            int i2 = 7 + random.nextInt(2) * 2;
	            makeTowerOutbuilding(list, random, 1, ai2[0], ai2[1], ai2[2], i2, k1, k);
	        }

	        for(int l = 0; l < 16; l++)
	        {
	            int ai3[] = getValidOpening(random, l % 4);
	            int l1 = 6 + random.nextInt(5);
	            if(random.nextInt(3) == 0 || !makeTowerWing(list, random, 1, ai3[0], ai3[1], ai3[2], 5, l1, l % 4))
	            {
	                makeTowerWing(list, random, 1, ai3[0], ai3[1], ai3[2], 3, l1, l % 4);
	            }
	        }

	    }

	    public int[] getOutbuildingOpening(Random random, int i)
	    {
	        int j = 0;
	        int k = 1;
	        int l = 0;
	        switch(i)
	        {
	        case 0: // '\0'
	            j = size - 1;
	            l = 6 + random.nextInt(8);
	            break;

	        case 1: // '\001'
	            j = 1 + random.nextInt(11);
	            l = size - 1;
	            break;

	        case 2: // '\002'
	            j = 0;
	            l = 1 + random.nextInt(8);
	            break;

	        case 3: // '\003'
	            j = 3 + random.nextInt(11);
	            l = 0;
	            break;
	        }
	        return (new int[] {
	            j, k, l
	        });
	    }

	    public boolean makeTowerOutbuilding(List list, Random random, int i, int j, int k, int l, int i1, 
	            int j1, int k1)
	    {
	        int l1 = (coordBaseMode + k1) % 4;
	        int ai[] = offsetTowerCoords(j, k, l, i1, l1);
	        AetherWorldComponentTowerOutbuilding componenttftoweroutbuilding = new AetherWorldComponentTowerOutbuilding(i, ai[0], ai[1], ai[2], i1, j1, l1);
	        StructureComponent structurecomponent = StructureComponent.getIntersectingStructureComponent(list, componenttftoweroutbuilding.boundingBox);
	        if(structurecomponent == null || structurecomponent == this)
	        {
	            list.add(componenttftoweroutbuilding);
	            componenttftoweroutbuilding.buildComponent(this, list, random);
	            addOpening(j, k, l, k1);
	            return true;
	        } else
	        {
	            return false;
	        }
	    }

	    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
	    {
	        fillWithRandomizedBlocks(world, structureboundingbox, 0, 0, 0, size - 1, height - 1, size - 1, false, random, StructureStrongholdPieces.getStrongholdStones());
	        makeStairs(world, random, structureboundingbox);
	        makeOpenings(world, structureboundingbox);
	        decorateThisTower(world, random, structureboundingbox);
	        return true;
	    }
}
