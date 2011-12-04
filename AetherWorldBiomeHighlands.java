package net.minecraft.src;

public class AetherWorldBiomeHighlands extends AetherWorldBiomeBase{
	
    public AetherWorldBiomeHighlands(int i)
    {
        super(i);
        minHeight = 1.0F;
        maxHeight = 2.0F;
        temperature = 0.5F;
        rainfall = 0.3F;
        ((AetherWorldBiomeDecorator)biomeDecorator).canopyPerChunk = -999;
    }
}
