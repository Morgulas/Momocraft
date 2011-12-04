package net.minecraft.src;

import net.minecraft.src.*;

public class AetherWorldGenMapTower extends MapGenStructure {
	
	 public AetherWorldGenMapTower()
	    {
	    }

	    protected boolean canSpawnStructureAtCoords(int i, int j)
	    {
	        return AetherWorldChunkProvider.featureType(i, j, worldObj) == 6;
	    }

	    protected StructureStart getStructureStart(int i, int j)
	    {
	        return new AetherWorldStructureTowerStart(worldObj, rand, i, j);
	    }
}
