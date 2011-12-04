package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldGenHedgeMaze extends AetherWorldGenerator{

	int size;
    AetherWorldMaze maze;
    Random rand;

    public AetherWorldGenHedgeMaze(int i)
    {
        size = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        rand = random;
        int l = i - 7 - size * 16;
        int i1 = k - 7 - size * 16;
        byte byte0 = 16;
        maze = new AetherWorldMaze(byte0, byte0);
        maze.oddBias = 2;
        maze.torchBlockID = MomocraftBlocks.TestBlock.blockID;
        maze.wallBlockID = MomocraftBlocks.TestBlock.blockID;
        maze.type = 4;
        maze.tall = 3;
        maze.roots = 3;
        fill(l, j - 1, i1, byte0 * 3, 1, byte0 * 3, Block.grass.blockID, 0);
        putBlockAndMetadata(l - 1, j, i1 + 23, Block.pumpkinLantern.blockID, 1, true);
        putBlockAndMetadata(l - 1, j, i1 + 28, Block.pumpkinLantern.blockID, 1, true);
        putBlockAndMetadata(l + 49, j, i1 + 23, Block.pumpkinLantern.blockID, 3, true);
        putBlockAndMetadata(l + 49, j, i1 + 28, Block.pumpkinLantern.blockID, 3, true);
        putBlockAndMetadata(l + 23, j, i1 - 1, Block.pumpkinLantern.blockID, 2, true);
        putBlockAndMetadata(l + 28, j, i1 - 1, Block.pumpkinLantern.blockID, 2, true);
        putBlockAndMetadata(l + 23, j, i1 + 49, Block.pumpkinLantern.blockID, 0, true);
        putBlockAndMetadata(l + 28, j, i1 + 49, Block.pumpkinLantern.blockID, 0, true);
        int j1 = byte0 / 3;
        int ai[] = new int[j1 * 2];
        for(int k1 = 0; k1 < j1; k1++)
        {
            int l1;
            int i2;
            do
            {
                l1 = random.nextInt(byte0 - 2) + 1;
                i2 = random.nextInt(byte0 - 2) + 1;
            } while(isNearRoom(l1, i2, ai));
            maze.carveRoom1(l1, i2);
            ai[k1 * 2] = l1;
            ai[k1 * 2 + 1] = i2;
        }

        maze.generateRecursiveBacktracker(0, 0);
        maze.add4Exits();
        maze.copyToWorld(worldObj, l, j, i1);
        decorate3x3Rooms(ai);
        return true;
    }

    protected boolean isNearRoom(int i, int j, int ai[])
    {
        for(int k = 0; k < ai.length / 2; k++)
        {
            int l = ai[k * 2];
            int i1 = ai[k * 2 + 1];
            if((l != 0 || i1 != 0) && Math.abs(i - l) < 3 && Math.abs(j - i1) < 3)
            {
                return true;
            }
        }

        return false;
    }

    void decorate3x3Rooms(int ai[])
    {
        for(int i = 0; i < ai.length / 2; i++)
        {
            int j = ai[i * 2];
            int k = ai[i * 2 + 1];
            decorate3x3Room(j, k);
        }

    }

    void decorate3x3Room(int i, int j)
    {
        int k = maze.getWorldX(i) + 1;
        int l = maze.worldY;
        int i1 = maze.getWorldZ(j) + 1;
        roomSpawner(k, l, i1, 8);
        if(!roomTreasure(k, l, i1, 8))
        {
            roomTreasure(k, l, i1, 8);
        }
        if(!roomJackO(k, l, i1, 8) || rand.nextInt(4) == 0)
        {
            roomJackO(k, l, i1, 8);
        }
    }

    private boolean roomSpawner(int i, int j, int k, int l)
    {
        int i1 = (rand.nextInt(l) + i) - l / 2;
        int j1 = (rand.nextInt(l) + k) - l / 2;
        String s;
        switch(rand.nextInt(3))
        {
        case 1: // '\001'
            s = "Swarm Spider";
            break;

        case 2: // '\002'
            s = "Hostile Wolf";
            break;

        case 0: // '\0'
        default:
            s = "Hedge Spider";
            break;
        }
        return placeMobSpawner(i1, j, j1, s);
    }

    private boolean roomTreasure(int i, int j, int k, int l)
    {
        int i1 = (rand.nextInt(l) + i) - l / 2;
        int j1 = (rand.nextInt(l) + k) - l / 2;
        if(worldObj.getBlockId(i1, j, j1) != 0)
        {
            return false;
        } else
        {
            return AetherWorldTreasure.hedgemaze.generate(worldObj, rand, i1, j, j1);
        }
    }

    protected boolean placeMobSpawner(int i, int j, int k, String s)
    {
        worldObj.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)worldObj.getBlockTileEntity(i, j, k);
        if(tileentitymobspawner != null)
        {
            tileentitymobspawner.setMobID(s);
            return true;
        } else
        {
            return false;
        }
    }

    private boolean roomJackO(int i, int j, int k, int l)
    {
        int i1 = (rand.nextInt(l) + i) - l / 2;
        int j1 = (rand.nextInt(l) + k) - l / 2;
        if(worldObj.getBlockId(i1, j, j1) != 0)
        {
            return false;
        } else
        {
            worldObj.setBlockAndMetadataWithNotify(i1, j, j1, Block.pumpkinLantern.blockID, rand.nextInt(4));
            return true;
        }
    }
	
}
