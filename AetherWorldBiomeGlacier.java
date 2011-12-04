package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldBiomeGlacier extends AetherWorldBiomeBase{

    public AetherWorldBiomeGlacier(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 1;
        biomeDecorator.grassPerChunk = 0;
        temperature = 0.0F;
        rainfall = 0.1F;
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
