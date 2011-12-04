package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenWell extends AetherWorldGenerator {


    public AetherWorldGenWell()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        if(random.nextInt(4) == 0)
        {
            return generate4x4Well(world, random, i, j, k);
        } else
        {
            return generate3x3Well(world, random, i, j, k);
        }
    }

    public boolean generate3x3Well(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        if(!isAreaClear(world, random, i, j, k, 3, 4, 3))
        {
            return false;
        }
        putBlock(i + 0, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 2, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 0, j, k + 2, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 2, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 2, j, k + 2, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 0, j, k + 1, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 2, j, k + 1, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 1, Block.waterStill.blockID, true);
        putBlock(i + 0, j + 1, k + 0, Block.fence.blockID, true);
        putBlock(i + 2, j + 1, k + 0, Block.fence.blockID, true);
        putBlock(i + 0, j + 1, k + 2, Block.fence.blockID, true);
        putBlock(i + 2, j + 1, k + 2, Block.fence.blockID, true);
        putBlock(i + 0, j + 2, k + 0, Block.fence.blockID, true);
        putBlock(i + 2, j + 2, k + 0, Block.fence.blockID, true);
        putBlock(i + 0, j + 2, k + 2, Block.fence.blockID, true);
        putBlock(i + 2, j + 2, k + 2, Block.fence.blockID, true);
        putBlockAndMetadata(i + 0, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 1, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 2, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 0, j + 3, k + 2, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 1, j + 3, k + 2, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 2, j + 3, k + 2, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 0, j + 3, k + 1, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 2, j + 3, k + 1, Block.stairSingle.blockID, 2, true);
        putBlock(i + 1, j + 3, k + 1, Block.planks.blockID, true);
        int l = -1;
        do
        {
            if(l < -20)
            {
                break;
            }
            int i1 = world.getBlockId(i + 1, j + l, k + 1);
            if(i1 != Block.dirt.blockID && i1 != Block.grass.blockID && i1 != Block.gravel.blockID && i1 != Block.stone.blockID || !world.getBlockMaterial(i + 1, (j + l) - 1, k + 1).isSolid())
            {
                break;
            }
            putBlock(i + 1, j + l, k + 1, Block.waterStill.blockID, true);
            l--;
        } while(true);
        return true;
    }

    public boolean generate4x4Well(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        if(!isAreaClear(world, random, i, j, k, 4, 4, 4))
        {
            return false;
        }
        putBlock(i + 0, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 2, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 3, j, k + 0, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 0, j, k + 3, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 3, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 2, j, k + 3, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 3, j, k + 3, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 0, j, k + 1, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 0, j, k + 2, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 3, j, k + 1, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 3, j, k + 2, Block.cobblestoneMossy.blockID, true);
        putBlock(i + 1, j, k + 1, Block.waterStill.blockID, true);
        putBlock(i + 2, j, k + 1, Block.waterStill.blockID, true);
        putBlock(i + 1, j, k + 2, Block.waterStill.blockID, true);
        putBlock(i + 2, j, k + 2, Block.waterStill.blockID, true);
        putBlock(i + 0, j + 1, k + 0, Block.fence.blockID, true);
        putBlock(i + 3, j + 1, k + 0, Block.fence.blockID, true);
        putBlock(i + 0, j + 1, k + 3, Block.fence.blockID, true);
        putBlock(i + 3, j + 1, k + 3, Block.fence.blockID, true);
        putBlock(i + 0, j + 2, k + 0, Block.fence.blockID, true);
        putBlock(i + 3, j + 2, k + 0, Block.fence.blockID, true);
        putBlock(i + 0, j + 2, k + 3, Block.fence.blockID, true);
        putBlock(i + 3, j + 2, k + 3, Block.fence.blockID, true);
        putBlockAndMetadata(i + 0, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 1, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 2, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 3, j + 3, k + 0, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 0, j + 3, k + 3, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 1, j + 3, k + 3, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 2, j + 3, k + 3, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 3, j + 3, k + 3, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 0, j + 3, k + 1, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 0, j + 3, k + 2, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 3, j + 3, k + 1, Block.stairSingle.blockID, 2, true);
        putBlockAndMetadata(i + 3, j + 3, k + 2, Block.stairSingle.blockID, 2, true);
        putBlock(i + 1, j + 3, k + 1, Block.planks.blockID, true);
        putBlock(i + 2, j + 3, k + 1, Block.planks.blockID, true);
        putBlock(i + 1, j + 3, k + 2, Block.planks.blockID, true);
        putBlock(i + 2, j + 3, k + 2, Block.planks.blockID, true);
        for(int l = 1; l <= 2; l++)
        {
label0:
            for(int i1 = 1; i1 <= 2; i1++)
            {
                int j1 = -1;
                do
                {
                    if(j1 < -20)
                    {
                        continue label0;
                    }
                    int k1 = world.getBlockId(i + l, j + j1, k + i1);
                    if(k1 != Block.dirt.blockID && k1 != Block.grass.blockID && k1 != Block.gravel.blockID && k1 != Block.stone.blockID || !world.getBlockMaterial(i + l, (j + j1) - 1, k + i1).isSolid())
                    {
                        continue label0;
                    }
                    putBlock(i + l, j + j1, k + i1, Block.waterStill.blockID, true);
                    j1--;
                } while(true);
            }

        }

        return true;
    }
}
