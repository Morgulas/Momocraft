package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldGenHillMaze extends AetherWorldGenerator{


    int hsize;
    AetherWorldMaze maze;
    Random rand;

    public AetherWorldGenHillMaze(int i)
    {
        hsize = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        worldObj = world;
        rand = random;
        int l = i - 7 - hsize * 16;
        int i1 = k - 7 - hsize * 16;
        byte byte0 = 11;
        if(hsize == 2)
        {
            byte0 = 19;
        } else
        if(hsize == 3)
        {
            byte0 = 27;
        }
        fill(l, j - 1, i1, byte0 * 4, 1, byte0 * 4, MomocraftBlocks.TestBlock.blockID, 0);
        fill(l, j, i1, byte0 * 4, 3, byte0 * 4, 0, 0);
        fill(l, j + 3, i1, byte0 * 4, 1, byte0 * 4, MomocraftBlocks.TestBlock.blockID, 0);
        maze = new AetherWorldMaze(byte0, byte0);
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
        maze.copyToWorld(worldObj, l, j, i1);
        decorateDeadEnds();
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

    public void decorateDeadEnds()
    {
        for(int i = 0; i < maze.width; i++)
        {
            for(int j = 0; j < maze.depth; j++)
            {
                if(!maze.isWall(i, j, i - 1, j) && maze.isWall(i, j, i + 1, j) && maze.isWall(i, j, i, j - 1) && maze.isWall(i, j, i, j + 1))
                {
                    decorateDeadEnd(i, j, 3);
                }
                if(maze.isWall(i, j, i - 1, j) && !maze.isWall(i, j, i + 1, j) && maze.isWall(i, j, i, j - 1) && maze.isWall(i, j, i, j + 1))
                {
                    decorateDeadEnd(i, j, 1);
                }
                if(maze.isWall(i, j, i - 1, j) && maze.isWall(i, j, i + 1, j) && !maze.isWall(i, j, i, j - 1) && maze.isWall(i, j, i, j + 1))
                {
                    decorateDeadEnd(i, j, 0);
                }
                if(maze.isWall(i, j, i - 1, j) && maze.isWall(i, j, i + 1, j) && maze.isWall(i, j, i, j - 1) && !maze.isWall(i, j, i, j + 1))
                {
                    decorateDeadEnd(i, j, 2);
                }
            }

        }

    }

    public void decorateDeadEnd(int i, int j, int k)
    {
        int l = rand.nextInt(17);
        switch(l)
        {
        case 0: // '\0'
            deadEndSpiderSpawner(i, j, k);
            break;

        case 1: // '\001'
            deadEndWebs(i, j, k);
            break;

        case 2: // '\002'
            deadEndTreasure(i, j, k);
            break;

        case 3: // '\003'
            deadEndSpawner(i, j, k);
            break;

        case 4: // '\004'
            deadEndPainting(i, j, k);
            break;

        case 5: // '\005'
            deadEndTrap(i, j, k);
            break;

        case 6: // '\006'
            deadEndTrappedChest(i, j, k);
            break;

        case 7: // '\007'
            deadEndTorch(i, j, k);
            break;

        case 8: // '\b'
            deadEndTorchRedstone(i, j, k);
            break;

        case 9: // '\t'
            deadEndFountain(i, j, k);
            break;

        case 10: // '\n'
            deadEndLavaFountain(i, j, k);
            break;

        case 11: // '\013'
            deadEndDoorway(i, j, k);
            break;

        case 12: // '\f'
            deadEndDoor(i, j, k);
            break;

        case 13: // '\r'
            deadEndDoorSteel(i, j, k);
            break;

        case 14: // '\016'
            deadEndDoorTreasure(i, j, k);
            break;
        }
    }

    void deadEndSpiderSpawner(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        deadEndWebs(i, j, k);
        if(k == 0)
        {
            placeMobSpawner(l + 1, i1 + 0, j1 + 2, "Spider");
        } else
        if(k == 1)
        {
            placeMobSpawner(l + 0, i1 + 0, j1 + 1, "Spider");
        } else
        if(k == 2)
        {
            placeMobSpawner(l + 1, i1 + 0, j1 + 0, "Spider");
        } else
        if(k == 3)
        {
            placeMobSpawner(l + 2, i1 + 0, j1 + 1, "Spider");
        }
    }

    void deadEndWebs(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.web.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.web.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.web.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 1, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 0, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 2, Block.web.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.web.blockID);
        }
    }

    void deadEndTreasure(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            AetherWorldTreasure.underhill_deadend.generate(worldObj, rand, l + 1, i1 + 0, j1 + 2);
        } else
        if(k == 1)
        {
            AetherWorldTreasure.underhill_deadend.generate(worldObj, rand, l + 0, i1 + 0, j1 + 1);
        } else
        if(k == 2)
        {
            AetherWorldTreasure.underhill_deadend.generate(worldObj, rand, l + 1, i1 + 0, j1 + 0);
        } else
        if(k == 3)
        {
            AetherWorldTreasure.underhill_deadend.generate(worldObj, rand, l + 2, i1 + 0, j1 + 1);
        }
    }

    void deadEndSpawner(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        String s = rand.nextInt(3) != 0 ? "Zombie" : "Skeleton";
        if(k == 0)
        {
            placeMobSpawner(l + 1, i1 + 0, j1 + 2, s);
        } else
        if(k == 1)
        {
            placeMobSpawner(l + 0, i1 + 0, j1 + 1, s);
        } else
        if(k == 2)
        {
            placeMobSpawner(l + 1, i1 + 0, j1 + 0, s);
        } else
        if(k == 3)
        {
            placeMobSpawner(l + 2, i1 + 0, j1 + 1, s);
        }
    }

    void deadEndPainting(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        int k1 = rand.nextInt(7);
        EnumArt aenumart[] = EnumArt.values();
        String s = aenumart[k1].title;
        EntityPainting entitypainting = null;
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 2, Block.torchWood.blockID);
            entitypainting = new EntityPainting(worldObj, l + 1, i1 + 1, j1 + 3, 0, s);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 2, Block.torchWood.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 0, Block.torchWood.blockID);
            entitypainting = new EntityPainting(worldObj, l - 1, i1 + 1, j1 + 1, 3, s);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 2, Block.torchWood.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 0, Block.torchWood.blockID);
            entitypainting = new EntityPainting(worldObj, l + 1, i1 + 1, j1 - 1, 2, s);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 0, Block.torchWood.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 0, Block.torchWood.blockID);
            entitypainting = new EntityPainting(worldObj, l + 3, i1 + 1, j1 + 1, 1, s);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 2, Block.torchWood.blockID);
        }
        if(entitypainting != null && entitypainting.canStay())
        {
            if(!worldObj.multiplayerWorld)
            {
                worldObj.entityJoinedWorld(entitypainting);
            }
        } else
        {
            System.out.println((new StringBuilder()).append("Painting fail!! ").append(entitypainting.art.title).append(" at ").append(entitypainting.xPosition).append(" , ").append(entitypainting.yPosition).append(", ").append(entitypainting.zPosition).append(" : ").append(entitypainting.direction).toString());
        }
    }

    void deadEndTrap(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 1, Block.pressurePlateStone.blockID);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 - 1, j1 + 2, Block.tnt.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 - 1, j1 + 1, Block.tnt.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 - 1, j1 + 0, Block.tnt.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 - 1, j1 + 1, Block.tnt.blockID);
        }
    }

    void deadEndTrappedChest(int i, int j, int k)
    {
        deadEndTrap(i, j, k);
        deadEndTreasure(i, j, k);
    }

    void deadEndTorch(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.torchWood.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.torchWood.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.torchWood.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.torchWood.blockID);
        }
    }

    void deadEndTorchRedstone(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.torchRedstoneActive.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.torchRedstoneActive.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.torchRedstoneActive.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.torchRedstoneActive.blockID);
        }
    }

    void deadEndNook(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 2, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 2, j1 + 2, Block.stone.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 1, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 2, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 2, j1 + 1, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 2, j1 + 2, Block.stone.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 0, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 0, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 0, i1 + 2, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 1, i1 + 2, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 2, j1 + 0, Block.stone.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 1, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 0, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 2, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 2, j1 + 0, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 2, j1 + 1, Block.stone.blockID);
            worldObj.setBlockWithNotify(l + 2, i1 + 2, j1 + 2, Block.stone.blockID);
        }
    }

    void deadEndFountain(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        deadEndNook(i, j, k);
        worldObj.setBlockWithNotify(l + 1, i1 - 1, j1 + 1, 0);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.waterMoving.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.waterMoving.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.waterMoving.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.waterMoving.blockID);
        }
    }

    void deadEndLavaFountain(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        deadEndNook(i, j, k);
        worldObj.setBlockWithNotify(l + 1, i1 - 1, j1 + 1, 0);
        if(k == 0)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 2, Block.lavaMoving.blockID);
        } else
        if(k == 1)
        {
            worldObj.setBlockWithNotify(l + 0, i1 + 1, j1 + 1, Block.lavaMoving.blockID);
        } else
        if(k == 2)
        {
            worldObj.setBlockWithNotify(l + 1, i1 + 1, j1 + 0, Block.lavaMoving.blockID);
        } else
        if(k == 3)
        {
            worldObj.setBlockWithNotify(l + 2, i1 + 1, j1 + 1, Block.lavaMoving.blockID);
        }
    }

    void deadEndDoorway(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        if(k == 0)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 2, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 2, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 2, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
        } else
        if(k == 1)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 2, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 2, j1 + 1, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 2, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
        } else
        if(k == 2)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 2, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 2, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 2, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
        } else
        if(k == 3)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 2, j1 + 0, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 2, j1 + 1, maze.wallBlockID, maze.wallBlockMeta);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 2, j1 + 2, maze.wallBlockID, maze.wallBlockMeta);
        }
    }

    void deadEndDoor(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        deadEndDoorway(i, j, k);
        if(k == 0)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 0, j1 + 0, Block.doorWood.blockID, 1);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 1, j1 + 0, Block.doorWood.blockID, 9);
        } else
        if(k == 1)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 1, Block.doorWood.blockID, 2);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 1, Block.doorWood.blockID, 10);
        } else
        if(k == 2)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 0, j1 + 2, Block.doorWood.blockID, 3);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 1, j1 + 2, Block.doorWood.blockID, 11);
        } else
        if(k == 3)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 1, Block.doorWood.blockID, 0);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 1, Block.doorWood.blockID, 8);
        }
    }

    void deadEndDoorSteel(int i, int j, int k)
    {
        int l = maze.getWorldX(i);
        int i1 = maze.worldY;
        int j1 = maze.getWorldZ(j);
        deadEndDoorway(i, j, k);
        if(k == 0)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 0, j1 + 0, Block.doorSteel.blockID, 1);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 1, j1 + 0, Block.doorSteel.blockID, 9);
        } else
        if(k == 1)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 0, j1 + 1, Block.doorSteel.blockID, 2);
            worldObj.setBlockAndMetadataWithNotify(l + 2, i1 + 1, j1 + 1, Block.doorSteel.blockID, 10);
        } else
        if(k == 2)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 0, j1 + 2, Block.doorSteel.blockID, 3);
            worldObj.setBlockAndMetadataWithNotify(l + 1, i1 + 1, j1 + 2, Block.doorSteel.blockID, 11);
        } else
        if(k == 3)
        {
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 0, j1 + 1, Block.doorSteel.blockID, 0);
            worldObj.setBlockAndMetadataWithNotify(l + 0, i1 + 1, j1 + 1, Block.doorSteel.blockID, 8);
        }
    }

    void deadEndDoorTreasure(int i, int j, int k)
    {
        deadEndDoor(i, j, k);
        deadEndTreasure(i, j, k);
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
        roomSpawner(k, l, i1, 11);
        if(!roomTreasure(k, l, i1, 11) || rand.nextInt(2) == 0)
        {
            roomTreasure(k, l, i1, 11);
        }
        roomSpiderwebs(k, l, i1, 11);
    }

    private boolean roomSpawner(int i, int j, int k, int l)
    {
        int i1 = (rand.nextInt(l) + i) - l / 2;
        int j1 = (rand.nextInt(l) + k) - l / 2;
        return placeMobSpawner(i1, j, j1, "Skeleton");
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
            return AetherWorldTreasure.underhill_room.generate(worldObj, rand, i1, j, j1);
        }
    }

    private boolean roomSpiderwebs(int i, int j, int k, int l)
    {
        int i1 = i;
        int j1 = k;
        int k1 = rand.nextInt(4);
        if(k1 == 0)
        {
            i1 -= 5;
            j1 -= 5;
        } else
        if(k1 == 1)
        {
            i1 += 5;
            j1 -= 5;
        } else
        if(k1 == 2)
        {
            i1 -= 5;
            j1 += 5;
        } else
        if(k1 == 3)
        {
            i1 += 5;
            j1 += 5;
        }
        boolean flag = false;
        flag |= roomSpiderweb(i1, j, j1, 3);
        flag |= roomSpiderweb(i1, j, j1, 3);
        flag |= roomSpiderweb(i1, j, j1, 3);
        return flag;
    }

    private boolean roomSpiderweb(int i, int j, int k, int l)
    {
        int i1 = (rand.nextInt(l) + i) - l / 2;
        int j1 = (rand.nextInt(l) + k) - l / 2;
        if(worldObj.getBlockId(i1, j + 2, j1) != 0)
        {
            return false;
        } else
        {
            worldObj.setBlockWithNotify(i1, j + 2, j1, Block.web.blockID);
            return true;
        }
    }
	
}
