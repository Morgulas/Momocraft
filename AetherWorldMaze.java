package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldMaze {

	int width;
    int depth;
    int oddBias;
    int evenBias;
    int tall;
    int roots;
    int worldX;
    int worldY;
    int worldZ;
    int type;
    int wallBlockID;
    int wallBlockMeta;
    int rootBlockID;
    int rootBlockMeta;
    int torchBlockID;
    int torchBlockMeta;
    int torchRarity;
    protected int rawWidth;
    protected int rawDepth;
    protected int storage[];
    static final int OUT_OF_BOUNDS = 0x80000000;
    static final int OOB = 0x80000000;
    static final int ROOM = 5;
    Random rand;

    public AetherWorldMaze(int i, int j)
    {
        rand = new Random();
        oddBias = 3;
        evenBias = 1;
        tall = 3;
        roots = 0;
        wallBlockID = MomocraftBlocks.TestBlock.blockID;
        wallBlockMeta = 2;
        rootBlockID = MomocraftBlocks.TestBlock.blockID;
        rootBlockMeta = 0;
        torchBlockID = Block.torchWood.blockID;
        torchBlockMeta = 0;
        torchRarity = 2;
        width = i;
        depth = j;
        rawWidth = width * 2 + 1;
        rawDepth = depth * 2 + 1;
        storage = new int[rawWidth * rawDepth];
    }

    public int getCell(int i, int j)
    {
        return getRaw(i * 2 + 1, j * 2 + 1);
    }

    public void putCell(int i, int j, int k)
    {
        putRaw(i * 2 + 1, j * 2 + 1, k);
    }

    public boolean cellEquals(int i, int j, int k)
    {
        return getCell(i, j) == k;
    }

    public int getWall(int i, int j, int k, int l)
    {
        if(k == i + 1 && l == j)
        {
            return getRaw(i * 2 + 2, j * 2 + 1);
        }
        if(k == i - 1 && l == j)
        {
            return getRaw(i * 2 + 0, j * 2 + 1);
        }
        if(k == i && l == j + 1)
        {
            return getRaw(i * 2 + 1, j * 2 + 2);
        }
        if(k == i && l == j - 1)
        {
            return getRaw(i * 2 + 1, j * 2 + 0);
        } else
        {
            System.out.println((new StringBuilder()).append("Wall check out of bounds; s = ").append(i).append(", ").append(j).append("; d = ").append(k).append(", ").append(l).toString());
            return 0x80000000;
        }
    }

    public void putWall(int i, int j, int k, int l, int i1)
    {
        if(k == i + 1 && l == j)
        {
            putRaw(i * 2 + 2, j * 2 + 1, i1);
        }
        if(k == i - 1 && l == j)
        {
            putRaw(i * 2 + 0, j * 2 + 1, i1);
        }
        if(k == i && l == j + 1)
        {
            putRaw(i * 2 + 1, j * 2 + 2, i1);
        }
        if(k == i && l == j - 1)
        {
            putRaw(i * 2 + 1, j * 2 + 0, i1);
        }
    }

    public boolean isWall(int i, int j, int k, int l)
    {
        return getWall(i, j, k, l) == 0;
    }

    protected void putRaw(int i, int j, int k)
    {
        if(i >= 0 && i < rawWidth && j >= 0 && j < rawDepth)
        {
            storage[j * rawWidth + i] = k;
        }
    }

    protected int getRaw(int i, int j)
    {
        if(i < 0 || i >= rawWidth || j < 0 || j >= rawDepth)
        {
            return 0x80000000;
        } else
        {
            return storage[j * rawWidth + i];
        }
    }

    public void copyToWorld(World world, int i, int j, int k)
    {
        worldX = i;
        worldY = j;
        worldZ = k;
        for(int l = 0; l < rawWidth; l++)
        {
label0:
            for(int i1 = 0; i1 < rawDepth; i1++)
            {
                if(getRaw(l, i1) != 0)
                {
                    continue;
                }
                int j1 = i + (l / 2) * (evenBias + oddBias);
                int k1 = k + (i1 / 2) * (evenBias + oddBias);
                if(isEven(l) && isEven(i1))
                {
                    if(type == 4 && shouldTree(l, i1))
                    {
                        (new AetherWorldGenCanopyTree()).generate(world, rand, j1, j, k1);
                    } else
                    {
                        for(int l1 = 0; l1 < tall; l1++)
                        {
                            putWallBlock(world, j1, j + l1, k1);
                        }

                        for(int i2 = 1; i2 <= roots; i2++)
                        {
                            putRootBlock(world, j1, j - i2, k1);
                        }

                    }
                }
                if(isEven(l) && !isEven(i1))
                {
                    for(int j2 = 1; j2 <= oddBias; j2++)
                    {
                        for(int l2 = 0; l2 < tall; l2++)
                        {
                            putWallBlock(world, j1, j + l2, k1 + j2);
                        }

                        for(int i3 = 1; i3 <= roots; i3++)
                        {
                            putRootBlock(world, j1, j - i3, k1 + j2);
                        }

                    }

                }
                if(isEven(l) || !isEven(i1))
                {
                    continue;
                }
                int k2 = 1;
                do
                {
                    if(k2 > oddBias)
                    {
                        continue label0;
                    }
                    for(int j3 = 0; j3 < tall; j3++)
                    {
                        putWallBlock(world, j1 + k2, j + j3, k1);
                    }

                    for(int k3 = 1; k3 <= roots; k3++)
                    {
                        putRootBlock(world, j1 + k2, j - k3, k1);
                    }

                    k2++;
                } while(true);
            }

        }

        placeTorches(world);
    }

    public void carveToWorld(World world, int i, int j, int k)
    {
        worldX = i;
        worldY = j;
        worldZ = k;
        for(int l = 0; l < rawWidth; l++)
        {
label0:
            for(int i1 = 0; i1 < rawDepth; i1++)
            {
                if(getRaw(l, i1) == 0)
                {
                    continue;
                }
                int j1 = i + (l / 2) * (evenBias + oddBias);
                int k1 = k + (i1 / 2) * (evenBias + oddBias);
                if(isEven(l) && isEven(i1))
                {
                    for(int l1 = 0; l1 < tall; l1++)
                    {
                        carveBlock(world, j1, j + l1, k1);
                    }

                    continue;
                }
                if(isEven(l) && !isEven(i1))
                {
                    int i2 = 1;
                    do
                    {
                        if(i2 > oddBias)
                        {
                            continue label0;
                        }
                        for(int l2 = 0; l2 < tall; l2++)
                        {
                            carveBlock(world, j1, j + l2, k1 + i2);
                        }

                        i2++;
                    } while(true);
                }
                if(!isEven(l) && isEven(i1))
                {
                    int j2 = 1;
                    do
                    {
                        if(j2 > oddBias)
                        {
                            continue label0;
                        }
                        for(int i3 = 0; i3 < tall; i3++)
                        {
                            carveBlock(world, j1 + j2, j + i3, k1);
                        }

                        j2++;
                    } while(true);
                }
                if(isEven(l) || isEven(i1))
                {
                    continue;
                }
                int k2 = 1;
                do
                {
                    if(k2 > oddBias)
                    {
                        continue label0;
                    }
                    for(int j3 = 1; j3 <= oddBias; j3++)
                    {
                        for(int k3 = 0; k3 < tall; k3++)
                        {
                            carveBlock(world, j1 + k2, j + k3, k1 + j3);
                        }

                    }

                    k2++;
                } while(true);
            }

        }

        placeTorches(world);
    }

    protected void putWallBlock(World world, int i, int j, int k)
    {
        world.setBlockAndMetadataWithNotify(i, j, k, wallBlockID, wallBlockMeta);
    }

    protected void carveBlock(World world, int i, int j, int k)
    {
        world.setBlockAndMetadataWithNotify(i, j, k, 0, 0);
    }

    protected void putRootBlock(World world, int i, int j, int k)
    {
        world.setBlockAndMetadataWithNotify(i, j, k, rootBlockID, rootBlockMeta);
    }

    public boolean isEven(int i)
    {
        return i % 2 == 0;
    }

    public void placeTorches(World world)
    {
        int i = 1;
        for(int j = 0; j < rawWidth; j++)
        {
            for(int k = 0; k < rawDepth; k++)
            {
                if(getRaw(j, k) != 0)
                {
                    continue;
                }
                int l = worldX + (j / 2) * (evenBias + oddBias);
                int i1 = worldY + i;
                int j1 = worldZ + (k / 2) * (evenBias + oddBias);
                if(isEven(j) && isEven(k) && shouldTorch(j, k) && world.getBlockId(l, i1, j1) == wallBlockID)
                {
                    world.setBlockAndMetadataWithNotify(l, i1, j1, torchBlockID, torchBlockMeta);
                }
            }

        }

    }

    public boolean shouldTorch(int i, int j)
    {
        if(getRaw(i + 1, j) == 0x80000000 || getRaw(i - 1, j) == 0x80000000 || getRaw(i, j + 1) == 0x80000000 || getRaw(i, j - 1) == 0x80000000)
        {
            return false;
        }
        if(getRaw(i + 1, j) == 0 && getRaw(i - 1, j) == 0 || getRaw(i, j + 1) == 0 && getRaw(i, j - 1) == 0)
        {
            return false;
        } else
        {
            return rand.nextInt(2) == 0;
        }
    }

    public boolean shouldTree(int i, int j)
    {
        if((i == 0 || i == rawWidth - 1) && (getRaw(i, j + 1) != 0 || getRaw(i, j - 1) != 0))
        {
            return true;
        }
        if((j == 0 || j == rawDepth - 1) && (getRaw(i + 1, j) != 0 || getRaw(i - 1, j) != 0))
        {
            return true;
        } else
        {
            return rand.nextInt(50) == 0;
        }
    }

    int getWorldX(int i)
    {
        return worldX + i * (evenBias + oddBias) + 1;
    }

    int getWorldZ(int i)
    {
        return worldZ + i * (evenBias + oddBias) + 1;
    }

    public void carveRoom0(int i, int j)
    {
        putCell(i, j, 5);
        putCell(i + 1, j, 5);
        putWall(i, j, i + 1, j, 5);
        putCell(i - 1, j, 5);
        putWall(i, j, i - 1, j, 5);
        putCell(i, j + 1, 5);
        putWall(i, j, i, j + 1, 5);
        putCell(i, j - 1, 5);
        putWall(i, j, i, j - 1, 5);
    }

    public void carveRoom1(int i, int j)
    {
        int k = i * 2 + 1;
        int l = j * 2 + 1;
        for(int i1 = -2; i1 <= 2; i1++)
        {
            for(int j1 = -2; j1 <= 2; j1++)
            {
                putRaw(k + i1, l + j1, 5);
            }

        }

        putCell(k, l + 1, 0);
        putCell(k, l - 1, 0);
        putCell(k + 1, l, 0);
        putCell(k - 1, l, 0);
        if(getRaw(k, l + 4) != 0x80000000)
        {
            putRaw(k, l + 3, 5);
        }
        if(getRaw(k, l - 4) != 0x80000000)
        {
            putRaw(k, l - 3, 5);
        }
        if(getRaw(k + 4, l) != 0x80000000)
        {
            putRaw(k + 3, l, 5);
        }
        if(getRaw(k - 4, l) != 0x80000000)
        {
            putRaw(k - 3, l, 5);
        }
    }

    public void add4Exits()
    {
        int i = rawWidth / 2 + 1;
        int j = rawDepth / 2 + 1;
        putRaw(i, 0, 5);
        putRaw(i, rawDepth - 1, 5);
        putRaw(0, j, 5);
        putRaw(rawWidth - 1, j, 5);
    }

    public void generateRecursiveBacktracker(int i, int j)
    {
        rbGen(i, j);
    }

    public void rbGen(int i, int j)
    {
        putCell(i, j, 1);
        int k = 0;
        if(cellEquals(i + 1, j, 0))
        {
            k++;
        }
        if(cellEquals(i - 1, j, 0))
        {
            k++;
        }
        if(cellEquals(i, j + 1, 0))
        {
            k++;
        }
        if(cellEquals(i, j - 1, 0))
        {
            k++;
        }
        if(k == 0)
        {
            return;
        }
        int l = rand.nextInt(k);
        int j1;
        int i1 = j1 = 0;
        if(cellEquals(i + 1, j, 0))
        {
            if(l == 0)
            {
                i1 = i + 1;
                j1 = j;
            }
            l--;
        }
        if(cellEquals(i - 1, j, 0))
        {
            if(l == 0)
            {
                i1 = i - 1;
                j1 = j;
            }
            l--;
        }
        if(cellEquals(i, j + 1, 0))
        {
            if(l == 0)
            {
                i1 = i;
                j1 = j + 1;
            }
            l--;
        }
        if(cellEquals(i, j - 1, 0) && l == 0)
        {
            i1 = i;
            j1 = j - 1;
        }
        putWall(i, j, i1, j1, 2);
        rbGen(i1, j1);
        rbGen(i, j);
        rbGen(i, j);
    }
	
}
