package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenFoundation extends AetherWorldGenerator {


    public AetherWorldGenFoundation()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        int l = 5 + random.nextInt(5);
        int i1 = 5 + random.nextInt(5);
        if(!isAreaClear(world, random, i, j, k, l, 4, i1))
        {
            return false;
        }
        for(int j1 = 0; j1 <= l; j1++)
        {
            for(int k1 = 0; k1 <= i1; k1++)
            {
                if(j1 == 0 || j1 == l || k1 == 0 || k1 == i1)
                {
                    int l1 = random.nextInt(4) + 1;
                    for(int i2 = 0; i2 <= l1; i2++)
                    {
                        putBlock(i + j1, (j + i2) - 1, k + k1, randStone(random, i2 + 1), true);
                    }

                    continue;
                }
                if(random.nextInt(3) != 0)
                {
                    putBlock(i + j1, j - 1, k + k1, (byte)Block.planks.blockID, true);
                }
            }

        }

        return true;
    }
}
