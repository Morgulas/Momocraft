package net.minecraft.src;

import java.util.Random;


public class AetherWorldStructureTowerStart extends StructureStart {
	
	   public AetherWorldStructureTowerStart(World world, Random random, int i, int j)
	    {
	        int k = (i << 4) + 8;
	        int l = (j << 4) + 8;
	        byte byte0 = 30;
	        AetherWorldComponentTowerMain componenttftowermain = new AetherWorldComponentTowerMain(world, random, 0, k, byte0, l);
	        components.add(componenttftowermain);
	        componenttftowermain.buildComponent(componenttftowermain, components, random);
	        updateBoundingBox();
	    }
}
