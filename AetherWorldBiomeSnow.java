package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldBiomeSnow extends AetherWorldBiomeBase{
	
	 public AetherWorldBiomeSnow(int i)
	    {
	        super(i);
	        biomeDecorator.treesPerChunk = 7;
	        biomeDecorator.grassPerChunk = 1;
	        temperature = 0.125F;
	        rainfall = 0.9F;
	        ((AetherWorldBiomeDecorator)biomeDecorator).canopyPerChunk = -999;
	    }

	    public WorldGenerator getRandomWorldGenForTrees(Random random)
	    {
	        if(random.nextInt(3) == 0)
	        {
	            return new WorldGenTaiga1();
	        } else
	        {
	            return new WorldGenTaiga2(true);
	        }
	    }

	    public boolean getEnableSnow()
	    {
	        return true;
	    }

	    public boolean canSpawnLightningBolt()
	    {
	        return false;
	    }
}
