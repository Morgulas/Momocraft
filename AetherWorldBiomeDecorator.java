package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldBiomeDecorator extends BiomeDecorator {
	
	AetherWorldGenCanopyTree canopyTreeGen;
	AetherWorldGenCanopyMushroom canopyMushroomGen;
	AetherWorldGenHollowTree hollowTreeGen;
    WorldGenLakes extraLakeGen;
    AetherWorldGenMangroveTree mangroveTreeGen;
    public int canopyPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;

    public AetherWorldBiomeDecorator(BiomeGenBase biomegenbase)
    {
        super(biomegenbase);
        canopyTreeGen = new AetherWorldGenCanopyTree();
        canopyMushroomGen = new AetherWorldGenCanopyMushroom();
        mangroveTreeGen = new AetherWorldGenMangroveTree();
        hollowTreeGen = new AetherWorldGenHollowTree();
        extraLakeGen = new WorldGenLakes(Block.waterStill.blockID);
        canopyPerChunk = 1;
        lakesPerChunk = 0;
        mangrovesPerChunk = 0;
    }

    public void decorate(World world, Random random, int i, int j)
    {
        int k = AetherWorldChunkProvider.nearestFeatureType(i >> 4, j >> 4, world);
        int l = AetherWorldChunkProvider.featureType(i >> 4, j >> 4, world);
        if(k == 4 || k == 5 || k == 6 || k == 9)
        {
            if(l == 4)
            {
                (new AetherWorldGenHedgeMaze(1)).generate(world, random, i + 8, 31, j + 8);
            } else
            if(l == 5)
            {
                (new AetherWorldGenNagaTemple()).generate(world, random, i + 8, 31, j + 8);
            } else
            if(l == 9)
            {
                (new AetherWorldGenMeadowTree()).generate(world, random, i + 8, 31, j + 8);
            }
        } else
        {
            if(l == 7)
            {
                (new AetherWorldGenGlacierMaze(1)).generate(world, random, i + 8, 41, j + 8);
            }
            if(random.nextInt(24) == 0)
            {
                int i1 = i + random.nextInt(16) + 8;
                int l1 = j + random.nextInt(16) + 8;
                int i3 = world.getHeightValue(i1, l1);
                hollowTreeGen.generate(world, random, i1, i3, l1);
            }
            if(random.nextInt(6) == 0)
            {
                int j1 = i + random.nextInt(16) + 8;
                int i2 = j + random.nextInt(16) + 8;
                int j3 = world.getHeightValue(j1, i2);
                AetherWorldGenerator tfgenerator = randomFeature(random);
                if(!tfgenerator.generate(world, random, j1, j3, i2));
            }
            int k1 = canopyPerChunk + random.nextInt(2);
            for(int j2 = 0; j2 < k1; j2++)
            {
                int k3 = i + random.nextInt(16) + 8;
                int j4 = j + random.nextInt(16) + 8;
                int i5 = world.getHeightValue(k3, j4);
                if(mushroomsPerChunk >= 8 && random.nextInt(5) == 0)
                {
                    canopyMushroomGen.generate(world, random, k3, i5, j4);
                } else
                {
                    canopyTreeGen.generate(world, random, k3, i5, j4);
                }
            }

            for(int k2 = 0; k2 < lakesPerChunk; k2++)
            {
                int l3 = i + random.nextInt(16) + 8;
                int k4 = j + random.nextInt(16) + 8;
                int j5 = world.getHeightValue(l3, k4);
                extraLakeGen.generate(world, random, l3, j5, k4);
            }

            for(int l2 = 0; l2 < mangrovesPerChunk; l2++)
            {
                int i4 = i + random.nextInt(16) + 8;
                int l4 = j + random.nextInt(16) + 8;
                int k5 = world.getHeightValue(i4, l4);
                mangroveTreeGen.generate(world, random, i4, k5, l4);
            }

            if(l > 0 && l <= 3)
            {
                (new AetherWorldGenHollowHill(l)).generate(world, random, i + 8, 29, j + 8);
                (new AetherWorldGenHillMaze(l)).generate(world, random, i + 8, 9, j + 8);
            }
            super.decorate(world, random, i, j);
        }
    }

    protected void makeSnow(World world, int i, int j)
    {
        float af[] = null;
        af = world.getWorldChunkManager().getTemperatures(af, i + 8, j + 8, 16, 16);
        for(int k = i + 8; k < i + 8 + 16; k++)
        {
            for(int l = j + 8; l < j + 8 + 16; l++)
            {
                int i1 = k - (i + 8);
                int j1 = l - (j + 8);
                int k1 = world.func_35461_e(k, l);
                double d = af[j1 * 16 + i1];
                if(d < 0.5D && k1 > 0 && k1 < 128 && world.isAirBlock(k, k1, l) && world.getBlockMaterial(k, k1 - 1, l).getIsSolid() && world.getBlockMaterial(k, k1 - 1, l) != Material.ice)
                {
                    world.setBlockWithNotify(k, k1, l, Block.snow.blockID);
                }
            }

        }

    }

    public AetherWorldGenerator randomFeature(Random random)
    {
        int i = random.nextInt(6);
        switch(i)
        {
        case 0: // '\0'
            return new AetherWorldGenStoneCircle();

        case 1: // '\001'
            return new AetherWorldGenWell();

        case 2: // '\002'
            return new AetherWorldGenWitchHut();

        case 3: // '\003'
            return new AetherWorldGenOutsideStalagmite();

        case 4: // '\004'
            return new AetherWorldGenFoundation();

        case 5: // '\005'
            return new AetherWorldGenMonolith();
        }
        return new AetherWorldGenStoneCircle();
    }
}
