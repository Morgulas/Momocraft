package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenOutsideStalagmite extends AetherWorldGenCaveStalactite {

    public AetherWorldGenOutsideStalagmite()
    {
        super((byte)Block.stone.blockID, 1.0D, false);
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        int l = random.nextInt(10) + 5;
        if(!isAreaClear(world, random, i, j, k, 1, l, 1))
        {
            return false;
        } else
        {
            return makeSpike(random, i, j - 1, k, l);
        }
    }

}
