package net.minecraft.src;

import java.util.Random;


public class AetherWorldGenWitchHut extends AetherWorldGenerator {

	   public AetherWorldGenWitchHut()
	    {
	    }

	    public boolean generate(World world, Random random, int i, int j, int k)
	    {
	        return generateTinyHut(world, random, i, j, k);
	    }

	    public boolean generateTinyHut(World world, Random random, int i, int j, int k)
	    {
	        worldObj = world;
	        if(!isAreaClear(world, random, i, j, k, 5, 7, 6))
	        {
	            return false;
	        } else
	        {
	            putBlock(i + 1, j + 0, k + 1, randStone(random, 1), true);
	            putBlock(i + 2, j + 0, k + 1, randStone(random, 1), true);
	            putBlock(i + 3, j + 0, k + 1, randStone(random, 1), true);
	            putBlock(i + 5, j + 0, k + 1, randStone(random, 1), true);
	            putBlock(i + 0, j + 0, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 0, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 0, k + 2, randStone(random, 1), true);
	            putBlock(i + 0, j + 0, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 0, k + 3, randStone(random, 1), true);
	            putBlock(i + 0, j + 0, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 0, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 0, k + 4, randStone(random, 1), true);
	            putBlock(i + 1, j + 0, k + 5, randStone(random, 1), true);
	            putBlock(i + 2, j + 0, k + 5, randStone(random, 1), true);
	            putBlock(i + 3, j + 0, k + 5, randStone(random, 1), true);
	            putBlock(i + 5, j + 0, k + 5, randStone(random, 1), true);
	            putBlock(i + 1, j + 1, k + 1, randStone(random, 2), true);
	            putBlock(i + 3, j + 1, k + 1, randStone(random, 2), true);
	            putBlock(i + 5, j + 1, k + 1, randStone(random, 2), true);
	            putBlock(i + 0, j + 1, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 1, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 1, k + 2, randStone(random, 2), true);
	            putBlock(i + 0, j + 1, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 0, j + 1, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 1, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 1, k + 4, randStone(random, 2), true);
	            putBlock(i + 1, j + 1, k + 5, randStone(random, 2), true);
	            putBlock(i + 3, j + 1, k + 5, randStone(random, 2), true);
	            putBlock(i + 5, j + 1, k + 5, randStone(random, 2), true);
	            putBlock(i + 1, j + 2, k + 1, randStone(random, 3), true);
	            putBlock(i + 2, j + 2, k + 1, randStone(random, 3), true);
	            putBlock(i + 3, j + 2, k + 1, randStone(random, 3), true);
	            putBlock(i + 4, j + 2, k + 1, randStone(random, 3), true);
	            putBlock(i + 5, j + 2, k + 1, randStone(random, 3), true);
	            putBlock(i + 0, j + 2, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 2, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 2, k + 2, randStone(random, 3), true);
	            putBlock(i + 0, j + 2, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 2, k + 3, randStone(random, 3), true);
	            putBlock(i + 0, j + 2, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 1, j + 2, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 5, j + 2, k + 4, randStone(random, 1), true);
	            putBlock(i + 1, j + 2, k + 5, randStone(random, 3), true);
	            putBlock(i + 2, j + 2, k + 5, randStone(random, 3), true);
	            putBlock(i + 3, j + 2, k + 5, randStone(random, 3), true);
	            putBlock(i + 4, j + 2, k + 5, randStone(random, 3), true);
	            putBlock(i + 5, j + 2, k + 5, randStone(random, 3), true);
	            putBlock(i + 0, j + 3, k + 2, (byte)Block.brick.blockID, true);
	            putBlock(i + 0, j + 3, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 0, j + 3, k + 4, (byte)Block.brick.blockID, true);
	            putBlock(i + 2, j + 3, k + 1, randStone(random, 4), true);
	            putBlock(i + 3, j + 3, k + 1, randStone(random, 4), true);
	            putBlock(i + 4, j + 3, k + 1, randStone(random, 4), true);
	            putBlock(i + 2, j + 3, k + 5, randStone(random, 4), true);
	            putBlock(i + 3, j + 3, k + 5, randStone(random, 4), true);
	            putBlock(i + 4, j + 3, k + 5, randStone(random, 4), true);
	            putBlock(i + 0, j + 4, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 3, j + 4, k + 1, randStone(random, 5), true);
	            putBlock(i + 3, j + 4, k + 5, randStone(random, 5), true);
	            putBlock(i + 0, j + 5, k + 3, (byte)Block.brick.blockID, true);
	            putBlock(i + 0, j + 6, k + 3, (byte)Block.brick.blockID, true);
	            putBlockAndMetadata(i + 0, j + 2, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 0, j + 2, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 0, j + 2, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 0, j + 2, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 3, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 6, j + 2, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 3, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 3, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 3, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 4, k + 0, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 3, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 4, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 1, j + 4, k + 6, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 4, k + 0, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 3, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 4, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 5, j + 4, k + 6, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 5, k + 0, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 5, k + 1, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 5, k + 0, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 5, k + 1, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 2, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 3, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 4, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 5, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 5, k + 5, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 2, j + 5, k + 6, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 5, k + 5, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 4, j + 5, k + 6, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 0, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 1, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 2, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 4, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 5, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 6, k + 6, (byte)Block.stairDouble.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 7, k + 0, (byte)Block.stairSingle.blockID, 2, true);
	            putBlockAndMetadata(i + 3, j + 7, k + 6, (byte)Block.stairSingle.blockID, 2, true);
	            putBlock(i + 1, j - 1, k + 3, (byte)Block.netherrack.blockID, true);
	            putBlock(i + 1, j + 0, k + 3, (byte)Block.fire.blockID, true);
	            worldObj.setBlockWithNotify(i + 3, j + 1, k + 3, Block.mobSpawner.blockID);
	            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(i + 3, j + 1, k + 3);
	            tileentitymobspawner.setMobID("Skeleton Druid");
	            return true;
	        }
	    }

}
