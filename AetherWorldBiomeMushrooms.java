package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldBiomeMushrooms extends AetherWorldBiomeBase{
	
    public AetherWorldBiomeMushrooms(int i)
    {
        super(i);
        rainfall = 0.8F;
        biomeDecorator.mushroomsPerChunk = 16;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if(random.nextInt(7) == 0)
        {
            return bigMushroomGen;
        }
        if(random.nextInt(5) == 0)
        {
            return worldGenForest;
        } else
        {
            return worldGenTrees;
        }
    }
}
