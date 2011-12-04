package net.minecraft.src;

public class AetherWorldBiomeTwilightOcean extends AetherWorldBiomeBase{

    public AetherWorldBiomeTwilightOcean(int i)
    {
        super(i);
        minHeight = -1.9F;
        maxHeight = 0.5F;
        temperature = 0.66F;
        rainfall = 1.0F;
        spawnableCreatureList.clear();
    }
	
}
