package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldGenGlacierMaze extends AetherWorldGenerator{


    int size;
    AetherWorldMaze maze;
    Random rand;

    public AetherWorldGenGlacierMaze(int i)
    {
        size = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        rand = random;
        int l = i - 7 - size * 16;
        int i1 = k - 7 - size * 16;
        byte byte0 = 15;
        maze = new AetherWorldMaze(byte0, byte0);
        maze.oddBias = 2;
        maze.wallBlockID = Block.ice.blockID;
        maze.torchBlockID = Block.ice.blockID;
        maze.type = 5;
        maze.tall = 3;
        maze.generateRecursiveBacktracker(0, 0);
        maze.add4Exits();
        maze.carveToWorld(worldObj, l, j, i1);
        return true;
    }
	
	
}
