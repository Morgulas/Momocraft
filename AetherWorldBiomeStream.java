package net.minecraft.src;

public class AetherWorldBiomeStream extends AetherWorldBiomeBase{

    public AetherWorldBiomeStream(int i)
    {
        super(i);
        minHeight = -0.7F;
        maxHeight = -0.05F;
        temperature = 0.5F;
        rainfall = 1.0F;
        spawnableCreatureList.clear();
    }
}
