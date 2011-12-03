package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.MomocraftBlocks;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class AetherGenGoldenOak extends WorldGenerator{
	
	public AetherGenGoldenOak()
    {
    }

    public boolean branch(World world, Random random, int i, int j, int k, int l)
    {
        int i1 = random.nextInt(3) - 1;
        int j1 = l;
        int k1 = random.nextInt(3) - 1;
        for(int l1 = 0; l1 < random.nextInt(2) + 1; l1++)
        {
            i += i1;
            j += j1;
            k += k1;
            if(world.getBlockId(i, j, k) == MomocraftBlocks.BlockAetherGoldenOakLeaves.blockID)
            {
//ShockAPI                world.setBlockAndMetadata(i, j, k, MomocraftBlocks.Log.blockID, 2);
            }
        }

        return true;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        if(world.getBlockId(i, j - 1, k) != MomocraftBlocks.BlockAetherGrass.blockID && world.getBlockId(i, j - 1, k) != MomocraftBlocks.BlockAetherDirt.blockID)
        {
            return false;
        }
        int l = random.nextInt(5) + 6;
        for(int i1 = i - 3; i1 < i + 4; i1++)
        {
            for(int k1 = j + 5; k1 < j + 12; k1++)
            {
                for(int l1 = k - 3; l1 < k + 4; l1++)
                {
                    if((i1 - i) * (i1 - i) + (k1 - j - 8) * (k1 - j - 8) + (l1 - k) * (l1 - k) < 12 + random.nextInt(5) && world.getBlockId(i1, k1, l1) == 0)
                    {
                        world.setBlock(i1, k1, l1, MomocraftBlocks.BlockAetherGoldenOakLeaves.blockID);
                    }
                }

            }

        }

        for(int j1 = 0; j1 < l; j1++)
        {
            if(j1 > 4 && random.nextInt(3) > 0)
            {
                branch(world, random, i, j + j1, k, j1 / 4 - 1);
            }
//SockAPI            world.setBlockAndMetadata(i, j + j1, k, MomocraftBlocks.Log.blockID, 2);
        }

        return true;
    }


}
