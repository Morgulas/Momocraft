package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldBiomeSwamp extends AetherWorldBiomeBase{
	
	public AetherWorldBiomeSwamp(int i)
    {
        super(i);
        minHeight = -0.25F;
        maxHeight = 0.0F;
        temperature = 0.8F;
        rainfall = 0.9F;
        biomeDecorator.deadBushPerChunk = 1;
        biomeDecorator.mushroomsPerChunk = 8;
        biomeDecorator.reedsPerChunk = 10;
        biomeDecorator.clayPerChunk = 1;
        biomeDecorator.treesPerChunk = 1;
        biomeDecorator.waterlilyPerChunk = 4;
        field_40256_A = 0xe0ff70;
        ((AetherWorldBiomeDecorator)biomeDecorator).canopyPerChunk = -999;
        ((AetherWorldBiomeDecorator)biomeDecorator).lakesPerChunk = 2;
        ((AetherWorldBiomeDecorator)biomeDecorator).mangrovesPerChunk = 3;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return worldGenSwamp;
    }

    public int func_40254_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.getWorldChunkManager().func_35554_b(i, j, k);
        double d1 = iblockaccess.getWorldChunkManager().func_35558_c(i, k);
        return (int)((double)((ColorizerGrass.getGrassColor(d, d1) & 0xfcfcfc) + 0x2c0c2c) * 0.75D);
    }

    public int func_40255_b(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.getWorldChunkManager().func_35554_b(i, j, k);
        double d1 = iblockaccess.getWorldChunkManager().func_35558_c(i, k);
        return (int)((double)((ColorizerGrass.getGrassColor(d, d1) & 0xfcfcfc) + 0x2c0c2c) * 0.75D);
    }

}
