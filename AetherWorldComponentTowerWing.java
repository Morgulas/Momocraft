package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldComponentTowerWing extends AetherWorldStructureComponent{

    int size;
    int height;
    Class roofType;
    ArrayList openings;
    int highestOpening;
    boolean openingTowards[] = {
        false, false, true, false
    };

    protected AetherWorldComponentTowerWing(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        super(i);
        openings = new ArrayList();
        size = i1;
        height = j1;
        coordBaseMode = k1;
        highestOpening = 0;
        boundingBox = AetherWorldStructureComponent.getComponentToAddBoundingBox(j, k, l, 0, 0, 0, size - 1, height - 1, size - 1, k1);
    }

    public void buildComponent(StructureComponent structurecomponent, List list, Random random)
    {
        addOpening(0, 1, size / 2, 2);
        makeARoof(structurecomponent, list, random);
        makeABeard(structurecomponent, list, random);
        if(size > 4)
        {
            for(int i = 0; i < 4; i++)
            {
                if(i == 2)
                {
                    continue;
                }
                int ai[] = getValidOpening(random, i);
                if(!makeTowerWing(list, random, 1, ai[0], ai[1], ai[2], size - 2, height - 6, i) && size > 8)
                {
                    makeTowerWing(list, random, 1, ai[0], ai[1], ai[2], size - 6, height - 18, i);
                }
            }

        }
    }

    public boolean makeTowerWing(List list, Random random, int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        if(j1 < 6)
        {
            return false;
        }
        int l1 = (coordBaseMode + k1) % 4;
        int ai[] = offsetTowerCoords(j, k, l, i1, l1);
        if(random.nextInt(6) == 0)
        {
            return makeBridge(list, random, i, j, k, l, i1, j1, k1);
        }
        AetherWorldComponentTowerWing componenttftowerwing = new AetherWorldComponentTowerWing(i, ai[0], ai[1], ai[2], i1, j1, l1);
        StructureComponent structurecomponent = StructureComponent.getIntersectingStructureComponent(list, componenttftowerwing.boundingBox);
        if(structurecomponent == null || structurecomponent == this)
        {
            list.add(componenttftowerwing);
            componenttftowerwing.buildComponent(this, list, random);
            addOpening(j, k, l, k1);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean makeBridge(List list, Random random, int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        int l1 = (coordBaseMode + k1) % 4;
        int ai[] = offsetTowerCoords(j, k, l, 3, l1);
        AetherWorldComponentTowerBridge componenttftowerbridge = new AetherWorldComponentTowerBridge(i, ai[0], ai[1], ai[2], i1, j1, l1);
        StructureComponent structurecomponent = StructureComponent.getIntersectingStructureComponent(list, componenttftowerbridge.boundingBox);
        if(structurecomponent == null || structurecomponent == this)
        {
            structurecomponent = StructureComponent.getIntersectingStructureComponent(list, componenttftowerbridge.getWingBB());
        } else
        {
            return false;
        }
        if(structurecomponent == null || structurecomponent == this)
        {
            list.add(componenttftowerbridge);
            componenttftowerbridge.buildComponent(this, list, random);
            addOpening(j, k, l, k1);
            return true;
        } else
        {
            return false;
        }
    }

    public void addOpening(int i, int j, int k, int l)
    {
        openingTowards[l] = true;
        if(j > highestOpening)
        {
            highestOpening = j;
        }
        openings.add(new ChunkCoordinates(i, j, k));
    }

    public void makeABeard(StructureComponent structurecomponent, List list, Random random)
    {
        int i = func_35012_c();
        AetherWorldComponentTowerBeard componenttftowerbeard = new AetherWorldComponentTowerBeard(i + 1, this);
        list.add(componenttftowerbeard);
        componenttftowerbeard.buildComponent(this, list, random);
    }

    public void makeARoof(StructureComponent structurecomponent, List list, Random random)
    {
        boolean flag = structurecomponent.boundingBox.maxY > boundingBox.maxY;
        if(flag)
        {
            makeAttachedRoof(list, random);
        } else
        {
            makeFreestandingRoof(list, random);
        }
    }

    protected void makeAttachedRoof(List list, Random random)
    {
        int i = func_35012_c();
        if(roofType == null && random.nextInt(32) != 0)
        {
            tryToFitRoof(list, random, new AetherWorldComponentTowerRoofGableForwards(i + 1, this));
        }
        if(roofType == null && random.nextInt(8) != 0)
        {
            tryToFitRoof(list, random, new AetherWorldComponentTowerRoofSlabForwards(i + 1, this));
        }
        if(roofType == null && random.nextInt(32) != 0)
        {
            AetherWorldComponentTowerRoofAttachedSlab componenttftowerroofattachedslab = new AetherWorldComponentTowerRoofAttachedSlab(i + 1, this);
            tryToFitRoof(list, random, componenttftowerroofattachedslab);
        }
        if(roofType == null)
        {
            AetherWorldComponentTowerRoofFence componenttftowerrooffence = new AetherWorldComponentTowerRoofFence(i + 1, this);
            tryToFitRoof(list, random, componenttftowerrooffence);
        }
    }

    protected void tryToFitRoof(List list, Random random, AetherWorldComponentTowerRoof componenttftowerroof)
    {
        if(componenttftowerroof.fits(this, list, random))
        {
            list.add(componenttftowerroof);
            componenttftowerroof.buildComponent(this, list, random);
            roofType = componenttftowerroof.getClass();
        }
    }

    protected void makeFreestandingRoof(List list, Random random)
    {
        int i = func_35012_c();
        if(roofType == null && random.nextInt(8) != 0)
        {
            AetherWorldComponentTowerRoofPointyOverhang componenttftowerroofpointyoverhang = new AetherWorldComponentTowerRoofPointyOverhang(i + 1, this);
            tryToFitRoof(list, random, componenttftowerroofpointyoverhang);
        }
        if(roofType == null)
        {
        	AetherWorldComponentTowerRoofStairsOverhang componenttftowerroofstairsoverhang = new AetherWorldComponentTowerRoofStairsOverhang(i + 1, this);
            tryToFitRoof(list, random, componenttftowerroofstairsoverhang);
        }
        if(roofType == null)
        {
        	AetherWorldComponentTowerRoofStairs componenttftowerroofstairs = new AetherWorldComponentTowerRoofStairs(i + 1, this);
            tryToFitRoof(list, random, componenttftowerroofstairs);
        }
        if(roofType == null && random.nextInt(53) != 0)
        {
        	AetherWorldComponentTowerRoofSlab componenttftowerroofslab = new AetherWorldComponentTowerRoofSlab(i + 1, this);
            tryToFitRoof(list, random, componenttftowerroofslab);
        }
        if(roofType == null)
        {
        	AetherWorldComponentTowerRoofFence componenttftowerrooffence = new AetherWorldComponentTowerRoofFence(i + 1, this);
            tryToFitRoof(list, random, componenttftowerrooffence);
        }
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        fillWithRandomizedBlocks(world, structureboundingbox, 0, 0, 0, size - 1, height - 1, size - 1, false, random, StructureStrongholdPieces.getStrongholdStones());
        if(highestOpening > 1)
        {
            makeStairs(world, random, structureboundingbox);
        }
        decorateThisTower(world, random, structureboundingbox);
        makeWindows(world, random, structureboundingbox);
        makeOpenings(world, structureboundingbox);
        return true;
    }

    protected void makeOpeningMarkers(World world, Random random, int i, StructureBoundingBox structureboundingbox)
    {
        if(size > 4)
        {
            for(int j = 0; j < i; j++)
            {
                int ai[] = getValidOpening(random, 0);
                placeBlockAtCurrentPosition(world, Block.cloth.blockID, 0, ai[0], ai[1], ai[2], structureboundingbox);
            }

            for(int k = 0; k < i; k++)
            {
                int ai1[] = getValidOpening(random, 1);
                placeBlockAtCurrentPosition(world, Block.cloth.blockID, 1, ai1[0], ai1[1], ai1[2], structureboundingbox);
            }

            for(int l = 0; l < i; l++)
            {
                int ai2[] = getValidOpening(random, 2);
                placeBlockAtCurrentPosition(world, Block.cloth.blockID, 2, ai2[0], ai2[1], ai2[2], structureboundingbox);
            }

            for(int i1 = 0; i1 < i; i1++)
            {
                int ai3[] = getValidOpening(random, 3);
                placeBlockAtCurrentPosition(world, Block.cloth.blockID, 3, ai3[0], ai3[1], ai3[2], structureboundingbox);
            }

        }
    }

    protected void decorateThisTower(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        Random random1 = new Random(world.getWorldSeed() + (long)(boundingBox.minX * 0x132a3b3d * (boundingBox.minZ * 0xb8c67)));
        if(size > 3)
        {
            if(isDeadEnd())
            {
                decorateDeadEnd(world, random1, structureboundingbox);
            } else
            {
                decorateStairTower(world, random1, structureboundingbox);
            }
        }
    }

    protected void decorateDeadEnd(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = (height - 1) / 5;
        int j = height / i;
        for(int k = 1; k < i; k++)
        {
            for(int i1 = 1; i1 < size - 1; i1++)
            {
                for(int k1 = 1; k1 < size - 1; k1++)
                {
                    placeBlockAtCurrentPosition(world, Block.planks.blockID, 0, i1, k * j, k1, structureboundingbox);
                }

            }

        }

        if(i > 1)
        {
            int l = 3;
            byte byte0 = -1;
            decorateFloor(world, random, 0, 1, j, l, -1, structureboundingbox);
            for(int l1 = 1; l1 < i - 1; l1++)
            {
                int i2 = 1 + j * l1;
                int j2 = j * (l1 + 1);
                int j1 = l;
                l = ++l % 4;
                decorateFloor(world, random, l1, i2, j2, l, j1, structureboundingbox);
            }

            decorateFloor(world, random, i, 1 + j * (i - 1), height - 1, -1, l, structureboundingbox);
        } else
        {
            decorateFloor(world, random, 0, 1, height - 1, -1, -1, structureboundingbox);
        }
    }

    protected void decorateFloor(World world, Random random, int i, int j, int k, int l, int i1, 
            StructureBoundingBox structureboundingbox)
    {
        if(l > -1)
        {
            int j1 = getLadderMeta(l);
            int l1 = getLadderX(l);
            int j2 = getLadderZ(l);
            for(int l2 = j; l2 < k; l2++)
            {
                placeBlockAtCurrentPosition(world, Block.ladder.blockID, j1, l1, l2, j2, structureboundingbox);
            }

        }
        if(i1 > -1)
        {
            int k1 = getLadderMeta(i1);
            int i2 = getLadderX(i1);
            int k2 = getLadderZ(i1);
            for(int i3 = j - 1; i3 < j + 2; i3++)
            {
                placeBlockAtCurrentPosition(world, Block.ladder.blockID, k1, i2, i3, k2, structureboundingbox);
            }

        }
        if(random.nextInt(7) == 0 && i1 == -1)
        {
            decorateWell(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(7) == 0 && i1 == -1)
        {
            decorateSkeletonRoom(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(6) == 0 && i1 == -1)
        {
            decorateZombieRoom(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(5) == 0 && i1 == -1)
        {
            decorateCactusRoom(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(4) == 0 && i1 > -1)
        {
            decorateTreasureChest(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(5) == 0)
        {
            decorateSpiderWebs(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(12) == 0 && i1 > -1)
        {
            decorateSolidRock(world, random, j, k, l, i1, structureboundingbox);
        } else
        if(random.nextInt(3) == 0)
        {
            decorateFullLibrary(world, random, j, k, l, i1, structureboundingbox);
        } else
        {
            decorateLibrary(world, random, j, k, l, i1, structureboundingbox);
        }
    }

    protected void decorateWell(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        int i1 = size / 2;
        int j1 = i1;
        int k1 = i;
        int l1 = random.nextInt(4) != 0 ? Block.waterStill.blockID : Block.lavaStill.blockID;
        if(size > 5)
        {
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 - 1, k1 + 0, j1 - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 - 1, k1 + 1, j1 - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 0, k1 + 0, j1 - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 1, k1 + 0, j1 - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 + 1, k1 + 1, j1 - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 - 1, k1 + 0, j1 + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, l1, 0, i1 + 0, k1 + 0, j1 + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 1, k1 + 0, j1 + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 - 1, k1 + 0, j1 + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 - 1, k1 + 1, j1 + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 0, k1 + 0, j1 + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 1, k1 + 0, j1 + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 + 1, k1 + 1, j1 + 1, structureboundingbox);
        }
        placeBlockAtCurrentPosition(world, l1, 0, i1 + 0, k1 - 1, j1 + 0, structureboundingbox);
    }

    protected void decorateSkeletonRoom(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        placeSpawnerAtCurrentPosition(world, random, size / 2, i + 2, size / 2, "Skeleton", structureboundingbox);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new ChunkCoordinates(size / 2, i + 2, size / 2));
        for(int i1 = 0; i1 < size + 2; i1++)
        {
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(2 + random.nextInt(size - 4), height - 2, 2 + random.nextInt(size - 4));
            if(chainCollides(chunkcoordinates, arraylist))
            {
                continue;
            }
            for(int l1 = i; l1 < j; l1++)
            {
                placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, chunkcoordinates.posX, l1, chunkcoordinates.posZ, structureboundingbox);
            }

            arraylist.add(chunkcoordinates);
        }

        for(int j1 = 1; j1 <= size - 2; j1++)
        {
            for(int k1 = 1; k1 <= size - 2; k1++)
            {
                if((j1 == 1 || j1 == size - 2 || k1 == 1 || k1 == size - 2) && !isWindowPos(j1, k1) && !isLadderPos(j1, k1, k, l))
                {
                    placeBlockAtCurrentPosition(world, Block.web.blockID, 0, j1, j - 1, k1, structureboundingbox);
                }
            }

        }

    }

    protected void decorateZombieRoom(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        placeSpawnerAtCurrentPosition(world, random, size / 2, i + 2, size / 2, "Zombie", structureboundingbox);
        for(int i1 = 1; i1 <= size - 2; i1++)
        {
            for(int j1 = 1; j1 <= size - 2; j1++)
            {
                if(!isWindowPos(i1, j1) && !isLadderPos(i1, j1, k, l) && random.nextInt(5) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.mushroomBrown.blockID, 0, i1, i, j1, structureboundingbox);
                }
            }

        }

        ArrayList arraylist = new ArrayList();
        arraylist.add(new ChunkCoordinates(size / 2, i + 2, size / 2));
        for(int k1 = 0; k1 < size - 1; k1++)
        {
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(2 + random.nextInt(size - 4), height - 2, 2 + random.nextInt(size - 4));
            if(!chainCollides(chunkcoordinates, arraylist))
            {
                placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, chunkcoordinates.posX, i + 0, chunkcoordinates.posZ, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, chunkcoordinates.posX, i + 1, chunkcoordinates.posZ, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.slowSand.blockID, 0, chunkcoordinates.posX, i + 2, chunkcoordinates.posZ, structureboundingbox);
                arraylist.add(chunkcoordinates);
            }
        }

    }

    protected void decorateCactusRoom(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        for(int i1 = 1; i1 <= size - 2; i1++)
        {
            for(int j1 = 1; j1 <= size - 2; j1++)
            {
                placeBlockAtCurrentPosition(world, Block.sand.blockID, 0, i1, i - 1, j1, structureboundingbox);
                if(!isWindowPos(i1, j1) && !isLadderPos(i1, j1, k, l) && random.nextInt(4) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.deadBush.blockID, 0, i1, i, j1, structureboundingbox);
                }
            }

        }

        ArrayList arraylist = new ArrayList();
        arraylist.add(new ChunkCoordinates(size / 2, i + 2, size / 2));
        for(int k1 = 0; k1 < size + 2; k1++)
        {
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(2 + random.nextInt(size - 4), height - 2, 2 + random.nextInt(size - 4));
            if(chainCollides(chunkcoordinates, arraylist))
            {
                continue;
            }
            for(int l1 = i; l1 < j; l1++)
            {
                placeBlockAtCurrentPosition(world, Block.cactus.blockID, 0, chunkcoordinates.posX, l1, chunkcoordinates.posZ, structureboundingbox);
            }

            arraylist.add(chunkcoordinates);
        }

    }

    protected void decorateTreasureChest(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        int i1 = size / 2;
        int j1 = i1;
        int k1 = i;
        int l1 = random.nextInt(4) != 0 ? Block.waterStill.blockID : Block.lavaStill.blockID;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 - 1, k1 + 0, j1 - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 0, k1 + 0, j1 - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 + 1, k1 + 0, j1 - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 - 1, k1 + 0, j1 + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 0, k1 + 0, j1 + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 1, k1 + 0, j1 + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 - 1, k1 + 0, j1 + 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i1 + 0, k1 + 0, j1 + 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i1 + 1, k1 + 0, j1 + 1, structureboundingbox);
        placeTreasureAtCurrentPosition(world, random, i1 + 0, k1 + 1, j1 + 0, AetherWorldTreasure.tower_room, structureboundingbox);
        for(int i2 = 0; i2 < 4; i2++) { }
    }

    protected void decorateSpiderWebs(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        for(int i1 = i; i1 < j; i1++)
        {
            int j1 = (j - i1) + 2;
            for(int k1 = 1; k1 <= size - 2; k1++)
            {
                for(int l1 = 1; l1 <= size - 2; l1++)
                {
                    if(!isLadderPos(k1, l1, k, l) && random.nextInt(j1) == 0)
                    {
                        placeBlockAtCurrentPosition(world, Block.web.blockID, 0, k1, i1, l1, structureboundingbox);
                    }
                }

            }

        }

        if(random.nextInt(5) == 0)
        {
            String s;
            switch(random.nextInt(4))
            {
            case 3: // '\003'
                s = "CaveSpider";
                break;

            case 2: // '\002'
                s = "Swarm Spider";
                break;

            case 1: // '\001'
                s = "Hedge Spider";
                break;

            case 0: // '\0'
            default:
                s = "Spider";
                break;
            }
            placeSpawnerAtCurrentPosition(world, random, size / 2, i + 2, size / 2, s, structureboundingbox);
        }
    }

    protected void decorateSolidRock(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        for(int i1 = i; i1 < j; i1++)
        {
            for(int j1 = 1; j1 <= size - 2; j1++)
            {
                for(int k1 = 1; k1 <= size - 2; k1++)
                {
                    if(!isLadderPos(j1, k1, k, l) && random.nextInt(9) != 0)
                    {
                        placeBlockAtCurrentPosition(world, Block.stone.blockID, 0, j1, i1, k1, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void decorateLibrary(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        for(int i1 = 1; i1 <= size - 2; i1++)
        {
            for(int j1 = 1; j1 <= size - 2; j1++)
            {
                for(int k1 = i; k1 < j - 1; k1++)
                {
                    if((i1 == 1 || i1 == size - 2 || j1 == 1 || j1 == size - 2) && !isWindowPos(i1, j1) && !isLadderPos(i1, j1, k, l))
                    {
                        placeBlockAtCurrentPosition(world, Block.bookShelf.blockID, 0, i1, k1, j1, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void decorateFullLibrary(World world, Random random, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        for(int i1 = 1; i1 <= size - 2; i1++)
        {
            for(int j1 = 1; j1 <= size - 2; j1++)
            {
                for(int k1 = i; k1 < j; k1++)
                {
                    if((i1 % 2 != 0 && (j1 >= i1 && j1 <= size - i1 - 1 || j1 >= size - i1 - 1 && j1 <= i1) || j1 % 2 != 0 && (i1 >= j1 && i1 <= size - j1 - 1 || i1 >= size - j1 - 1 && i1 <= j1)) && !isWindowPos(i1, k1, j1) && !isOpeningPos(i1, k1, j1) && !isLadderPos(i1, j1, k, l))
                    {
                        placeBlockAtCurrentPosition(world, Block.bookShelf.blockID, 0, i1, k1, j1, structureboundingbox);
                    }
                }

            }

        }

    }

    protected boolean isWindowPos(int i, int j)
    {
        if(i == 1 && j == size / 2)
        {
            return true;
        }
        if(i == size - 2 && j == size / 2)
        {
            return true;
        }
        if(i == size / 2 && j == 1)
        {
            return true;
        }
        return i == size / 2 && j == size - 2;
    }

    protected boolean isWindowPos(int i, int j, int k)
    {
        byte byte0 = -1;
        if(i == 1 && k == size / 2)
        {
            byte0 = 2;
        } else
        if(i == size - 2 && k == size / 2)
        {
            byte0 = 0;
        } else
        if(i == size / 2 && k == 1)
        {
            byte0 = 3;
        } else
        if(i == size / 2 && k == size - 2)
        {
            byte0 = 1;
        }
        if(byte0 > -1)
        {
            return !openingTowards[byte0] && (j == 2 || j == 3 || height > 8 && (j == height - 3 || j == height - 4));
        } else
        {
            return false;
        }
    }

    protected boolean isOpeningPos(int i, int j, int k)
    {
        for(Iterator iterator = openings.iterator(); iterator.hasNext();)
        {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)iterator.next();
            ChunkCoordinates chunkcoordinates1 = new ChunkCoordinates(chunkcoordinates);
            if(chunkcoordinates1.posX == 0)
            {
                chunkcoordinates1.posX++;
            } else
            if(chunkcoordinates1.posX == size - 1)
            {
                chunkcoordinates1.posX--;
            } else
            if(chunkcoordinates1.posZ == 0)
            {
                chunkcoordinates1.posZ++;
            } else
            if(chunkcoordinates1.posZ == size - 1)
            {
                chunkcoordinates1.posZ--;
            }
            if(chunkcoordinates1.posX == i && chunkcoordinates1.posZ == k && (chunkcoordinates1.posY == j || chunkcoordinates1.posY + 1 == j))
            {
                return true;
            }
        }

        return false;
    }

    protected boolean isLadderPos(int i, int j, int k, int l)
    {
        if(i == getLadderX(k) && j == getLadderZ(k))
        {
            return true;
        }
        return i == getLadderX(l) && j == getLadderZ(l);
    }

    protected int getLadderX(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return size - 2;

        case 1: // '\001'
            return size / 2 + 1;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return size / 2 - 1;
        }
        return size / 2;
    }

    protected int getLadderZ(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return size / 2 - 1;

        case 1: // '\001'
            return size - 2;

        case 2: // '\002'
            return size / 2 + 1;

        case 3: // '\003'
            return 1;
        }
        return size / 2;
    }

    protected int getLadderMeta(int i)
    {
        switch((coordBaseMode + i) % 4)
        {
        case 0: // '\0'
            return 4;

        case 1: // '\001'
            return 2;

        case 2: // '\002'
            return 5;

        case 3: // '\003'
            return 3;
        }
        return -1;
    }

    protected void decorateStairTower(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(height - highestOpening > 13)
        {
            int i = highestOpening + 3;
            int j = (height - i) / 5;
            int k = (height - i) / j;
            for(int l = 0; l < j; l++)
            {
                for(int j1 = 1; j1 < size - 1; j1++)
                {
                    for(int l1 = 1; l1 < size - 1; l1++)
                    {
                        placeBlockAtCurrentPosition(world, Block.planks.blockID, 0, j1, l * k + i, l1, structureboundingbox);
                    }

                }

            }

            int i1 = 3;
            byte byte0 = -1;
            int i2 = getLadderMeta(i1);
            int j2 = getLadderX(i1);
            int k2 = getLadderZ(i1);
            for(int l2 = 1; l2 < 3; l2++)
            {
                placeBlockAtCurrentPosition(world, Block.ladder.blockID, i2, j2, i - l2, k2, structureboundingbox);
            }

            for(int i3 = 0; i3 < j - 1; i3++)
            {
                int j3 = i + 1 + k * i3;
                int k3 = i + k * (i3 + 1);
                int k1 = i1;
                i1 = ++i1 % 4;
                decorateFloor(world, random, i3, j3, k3, i1, k1, structureboundingbox);
            }

            decorateFloor(world, random, j, i + 1 + k * (j - 1), height - 1, -1, i1, structureboundingbox);
        } else
        if(size > 5)
        {
            switch(random.nextInt(5))
            {
            case 0: // '\0'
                decorateChandelier(world, random, structureboundingbox);
                break;

            case 1: // '\001'
                decorateHangingChains(world, random, structureboundingbox);
                break;

            case 2: // '\002'
                decorateFloatingBooks(world, random, structureboundingbox);
                break;

            case 3: // '\003'
                decorateFloatingVines(world, random, structureboundingbox);
                break;
            }
        }
        if(size > 5)
        {
            if(random.nextInt(4) == 0)
            {
                decorateStairWell(world, random, structureboundingbox);
            } else
            if(random.nextInt(3) != 0)
            {
                decoratePlanter(world, random, structureboundingbox);
            }
        }
    }

    protected void decorateHangingChains(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < size + 2; i++)
        {
            byte byte0 = ((byte)(size >= 15 ? 4 : 2));
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(byte0 + random.nextInt(size - byte0 * 2), height - 2, byte0 + random.nextInt(size - byte0 * 2));
            if(!chainCollides(chunkcoordinates, arraylist))
            {
                int j = 1 + random.nextInt(height - highestOpening - 3);
                decorateOneChain(world, random, chunkcoordinates.posX, j, chunkcoordinates.posZ, structureboundingbox);
                arraylist.add(chunkcoordinates);
            }
        }

    }

    protected boolean chainCollides(ChunkCoordinates chunkcoordinates, List list)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            ChunkCoordinates chunkcoordinates1 = (ChunkCoordinates)iterator.next();
            if(chunkcoordinates.posZ == chunkcoordinates1.posZ && Math.abs(chunkcoordinates.posX - chunkcoordinates1.posX) <= 1)
            {
                return true;
            }
            if(chunkcoordinates.posX == chunkcoordinates1.posX && Math.abs(chunkcoordinates.posZ - chunkcoordinates1.posZ) <= 1)
            {
                return true;
            }
        }

        return false;
    }

    protected void decorateOneChain(World world, Random random, int i, int j, int k, StructureBoundingBox structureboundingbox)
    {
        for(int l = 1; l <= j; l++)
        {
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i, height - l - 1, k, structureboundingbox);
        }

        int i1;
        byte byte0;
        switch(random.nextInt(10))
        {
        case 0: // '\0'
            i1 = Block.blockSteel.blockID;
            byte0 = 0;
            break;

        case 1: // '\001'
            i1 = Block.bookShelf.blockID;
            byte0 = 0;
            break;

        case 2: // '\002'
            i1 = Block.netherrack.blockID;
            byte0 = 0;
            break;

        case 3: // '\003'
            i1 = Block.slowSand.blockID;
            byte0 = 0;
            break;

        case 4: // '\004'
            i1 = Block.glass.blockID;
            byte0 = 0;
            break;

        case 5: // '\005'
            i1 = Block.blockLapis.blockID;
            byte0 = 0;
            break;

        case 6: // '\006'
            i1 = Block.silverfish.blockID;
            byte0 = 2;
            break;

        case 7: // '\007'
        default:
            i1 = Block.glowStone.blockID;
            byte0 = 0;
            break;
        }
        placeBlockAtCurrentPosition(world, i1, byte0, i, height - j - 2, k, structureboundingbox);
    }

    protected void decorateFloatingBooks(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < size + 2; i++)
        {
            byte byte0 = ((byte)(size >= 15 ? 4 : 2));
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(byte0 + random.nextInt(size - byte0 * 2), height - 2, byte0 + random.nextInt(size - byte0 * 2));
            if(chainCollides(chunkcoordinates, arraylist))
            {
                continue;
            }
            int j = 2 + random.nextInt(height - highestOpening - 3);
            int k = random.nextInt(j - 1) + 2;
            for(int l = k; l <= j; l++)
            {
                placeBlockAtCurrentPosition(world, Block.bookShelf.blockID, 0, chunkcoordinates.posX, height - l, chunkcoordinates.posZ, structureboundingbox);
            }

            arraylist.add(chunkcoordinates);
        }

    }

    protected void decorateFloatingVines(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < size + 2; i++)
        {
            byte byte0 = ((byte)(size >= 15 ? 4 : 2));
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(byte0 + random.nextInt(size - byte0 * 2), height - 2, byte0 + random.nextInt(size - byte0 * 2));
            if(chainCollides(chunkcoordinates, arraylist))
            {
                continue;
            }
            int i1 = 2 + random.nextInt(height - highestOpening - 3);
            int j1 = random.nextInt(i1 - 1) + 2;
            for(int k1 = j1; k1 <= i1; k1++)
            {
                placeBlockAtCurrentPosition(world, Block.cobblestoneMossy.blockID, 0, chunkcoordinates.posX, height - k1, chunkcoordinates.posZ, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(2), chunkcoordinates.posX + 1, height - k1, chunkcoordinates.posZ + 0, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(0), chunkcoordinates.posX - 1, height - k1, chunkcoordinates.posZ + 0, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(3), chunkcoordinates.posX + 0, height - k1, chunkcoordinates.posZ + 1, structureboundingbox);
                placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(1), chunkcoordinates.posX + 0, height - k1, chunkcoordinates.posZ - 1, structureboundingbox);
            }

            arraylist.add(chunkcoordinates);
        }

        for(int j = highestOpening + 3; j < height - 1; j++)
        {
            for(int k = 1; k < size - 1; k++)
            {
                if(random.nextInt(3) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(3), k, j, 1, structureboundingbox);
                }
                if(random.nextInt(3) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(1), k, j, size - 2, structureboundingbox);
                }
            }

            for(int l = 1; l < size - 1; l++)
            {
                if(random.nextInt(3) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(2), 1, j, l, structureboundingbox);
                }
                if(random.nextInt(3) == 0)
                {
                    placeBlockAtCurrentPosition(world, Block.vine.blockID, getVineMeta(0), size - 2, j, l, structureboundingbox);
                }
            }

        }

    }

    protected int getVineMeta(int i)
    {
        switch((coordBaseMode + i) % 4)
        {
        case 0: // '\0'
            return 8;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;

        case 3: // '\003'
            return 4;
        }
        return -1;
    }

    protected void decoratePlanter(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = size / 2;
        int j = i;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, i + 0, 1, j + 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, i + 0, 1, j - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, i + 1, 1, j + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, i - 1, 1, j + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.grass.blockID, 0, i + 0, 1, j + 0, structureboundingbox);
        int k;
        byte byte0;
        switch(random.nextInt(8))
        {
        case 0: // '\0'
            k = Block.tallGrass.blockID;
            byte0 = 0;
            break;

        case 1: // '\001'
            k = Block.tallGrass.blockID;
            byte0 = 1;
            break;

        case 2: // '\002'
            k = Block.tallGrass.blockID;
            byte0 = 2;
            break;

        case 3: // '\003'
            k = Block.sapling.blockID;
            byte0 = 0;
            break;

        case 4: // '\004'
            k = Block.sapling.blockID;
            byte0 = 1;
            break;

        case 5: // '\005'
            k = Block.sapling.blockID;
            byte0 = 2;
            break;

        case 6: // '\006'
            k = Block.mushroomBrown.blockID;
            byte0 = 0;
            break;

        case 7: // '\007'
        default:
            k = Block.mushroomRed.blockID;
            byte0 = 0;
            break;
        }
        placeBlockAtCurrentPosition(world, k, byte0, i + 0, 2, j + 0, structureboundingbox);
        if(k == Block.sapling.blockID)
        {
            int l = getXWithOffset(i, j);
            int j1 = getYWithOffset(2);
            int l1 = getZWithOffset(i, j);
            ((BlockSapling)Block.sapling).growTree(world, l, j1, l1, world.rand);
        }
        if(k == Block.mushroomBrown.blockID || k == Block.mushroomRed.blockID)
        {
            int i1 = getXWithOffset(i, j);
            int k1 = getYWithOffset(2);
            int i2 = getZWithOffset(i, j);
            ((BlockMushroom)Block.blocksList[k]).func_35293_c(world, i1, k1, i2, world.rand);
        }
    }

    protected void decorateStairWell(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = size / 2;
        int j = i;
        int k = 1;
        int l = random.nextInt(4) != 0 ? Block.waterStill.blockID : Block.lavaStill.blockID;
        if(size > 7)
        {
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i - 1, k + 0, j - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i - 1, k + 1, j - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 0, k + 0, j - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 1, k + 0, j - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i + 1, k + 1, j - 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i - 1, k + 0, j + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, l, 0, i + 0, k + 0, j + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 1, k + 0, j + 0, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i - 1, k + 0, j + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i - 1, k + 1, j + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 0, k + 0, j + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 1, k + 0, j + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 5, i + 1, k + 1, j + 1, structureboundingbox);
        }
        placeBlockAtCurrentPosition(world, l, 0, i + 0, k - 1, j + 0, structureboundingbox);
    }

    public boolean isDeadEnd()
    {
        return openings.size() == 1;
    }

    public boolean hasExitsOnAllWalls()
    {
        int i = 0;
        for(int j = 0; j < 4; j++)
        {
            i += openingTowards[j] ? 1 : 0;
        }

        return i == 4;
    }

    public boolean hasStairs()
    {
        return highestOpening > 1;
    }

    protected void makeOpenings(World world, StructureBoundingBox structureboundingbox)
    {
        ChunkCoordinates chunkcoordinates;
        for(Iterator iterator = openings.iterator(); iterator.hasNext(); makeDoorOpening(world, chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, structureboundingbox))
        {
            chunkcoordinates = (ChunkCoordinates)iterator.next();
        }

    }

    protected void makeDoorOpening(World world, int i, int j, int k, StructureBoundingBox structureboundingbox)
    {
        placeBlockAtCurrentPosition(world, 0, 0, i, j + 0, k, structureboundingbox);
        placeBlockAtCurrentPosition(world, 0, 0, i, j + 1, k, structureboundingbox);
        if(getBlockIdAtCurrentPosition(world, i, j + 2, k, structureboundingbox) != 0)
        {
            placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, i, j + 2, k, structureboundingbox);
        }
    }

    public int[] getValidOpening(Random random, int i)
    {
        int j = size - 2;
        byte byte0 = 1;
        if(size == 15)
        {
            j = 11;
            byte0 = 2;
        }
        if(i == 0 || i == 2)
        {
            int k = i != 0 ? 0 : size - 1;
            int i1 = byte0 + random.nextInt(j);
            int k1 = getYByStairs(i1, random, i);
            return (new int[] {
                k, k1, i1
            });
        }
        if(i == 1 || i == 3)
        {
            int l = byte0 + random.nextInt(j);
            int j1 = i != 1 ? 0 : size - 1;
            int l1 = getYByStairs(l, random, i);
            return (new int[] {
                l, l1, j1
            });
        } else
        {
            return (new int[] {
                0, 0, 0
            });
        }
    }

    private int getYByStairs(int i, Random random, int j)
    {
        byte byte0 = 1;
        byte byte1 = 0;
        if(size == 15)
        {
            byte0 = 10;
            byte1 = ((byte)(j != 0 && j != 2 ? 28 : 23));
        }
        if(size == 9)
        {
            byte0 = 6;
            byte1 = ((byte)(j != 0 && j != 2 ? 5 : 2));
        }
        if(size == 7)
        {
            byte0 = 4;
            byte1 = ((byte)(j != 0 && j != 2 ? 4 : 2));
        }
        if(size == 5)
        {
            byte0 = 4;
            switch(j)
            {
            case 0: // '\0'
                byte1 = 3;
                break;

            case 1: // '\001'
                byte1 = 2;
                break;

            case 2: // '\002'
                byte1 = 5;
                break;

            case 3: // '\003'
                byte1 = 4;
                break;
            }
        }
        int k = (height - 6 - byte1) / byte0 + 1;
        if(byte1 > 0 && k > 0)
        {
            int l = random.nextInt(k);
            int i1 = l * byte0 + byte1;
            if(size == 15)
            {
                i1 -= j != 0 && j != 3 ? (size - i - 3) / 2 : (i - 2) / 2;
            } else
            {
                i1 -= j != 0 && j != 3 ? (size - i - 2) / 2 : (i - 1) / 2;
            }
            if(i1 < 1)
            {
                i1 = 1;
            }
            return i1;
        } else
        {
            return 0;
        }
    }

    protected void makeWindows(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        for(int i = 0; i < 4; i++)
        {
            if(openingTowards[i])
            {
                continue;
            }
            makeWindowBlock(world, size - 1, 2, size / 2, i, structureboundingbox);
            makeWindowBlock(world, size - 1, 3, size / 2, i, structureboundingbox);
            if(height > 8)
            {
                makeWindowBlock(world, size - 1, height - 3, size / 2, i, structureboundingbox);
                makeWindowBlock(world, size - 1, height - 4, size / 2, i, structureboundingbox);
            }
        }

    }

    protected void makeWindowBlock(World world, int i, int j, int k, int l, StructureBoundingBox structureboundingbox)
    {
        int i1 = coordBaseMode;
        coordBaseMode = (coordBaseMode + l) % 4;
        int j1 = getBlockIdAtCurrentPosition(world, i + 1, j, k, structureboundingbox);
        int k1 = getBlockIdAtCurrentPosition(world, i - 1, j, k, structureboundingbox);
        if(k1 == 0 && j1 == 0)
        {
            placeBlockAtCurrentPosition(world, Block.thinGlass.blockID, 0, i, j, k, structureboundingbox);
        }
        coordBaseMode = i1;
    }

    protected void decorateChandelier(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = size / 2;
        int j = highestOpening + 2 + random.nextInt(height - highestOpening - 5);
        int k = size / 2;
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 0, j + 0, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i - 1, j + 0, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 1, j + 0, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 0, j + 0, k - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 0, j + 0, k + 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 0, j + 1, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, i - 1, j + 1, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, i + 1, j + 1, k + 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, i + 0, j + 1, k - 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, i + 0, j + 1, k + 1, structureboundingbox);
        for(int l = j; l < height - 1; l++)
        {
            placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, i + 0, l, k + 0, structureboundingbox);
        }

    }

    protected boolean makeStairs(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(size == 15)
        {
            return makeStairs15(world, random, structureboundingbox);
        }
        if(size == 9)
        {
            return makeStairs9(world, random, structureboundingbox);
        }
        if(size == 7)
        {
            return makeStairs7(world, random, structureboundingbox);
        }
        if(size == 5)
        {
            return makeStairs5(world, random, structureboundingbox);
        } else
        {
            return false;
        }
    }

    protected boolean makeStairs5(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = 1;
        int j = highestOpening / i;
        for(int k = 0; k < j; k++)
        {
            makeStairs5flight(world, random, structureboundingbox, k * i, 0 + k * 3, 2);
        }

        return true;
    }

    protected void makeStairs5flight(World world, Random random, StructureBoundingBox structureboundingbox, int i, int j, int k)
    {
        int l = coordBaseMode;
        coordBaseMode = (coordBaseMode + j) % 4;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 2, 1 + i, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 3, 1 + i, 3, structureboundingbox);
        coordBaseMode = l;
    }

    protected boolean makeStairs7(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 1, 1, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 1, 1, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 5, 1, 2, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 5, 1, 1, structureboundingbox);
        byte byte0 = 2;
        int i = highestOpening / byte0;
        for(int j = 0; j < i; j++)
        {
            makeStairs7flight(world, random, structureboundingbox, 1 + j * byte0, 0 + j * 3, 2);
            makeStairs7flight(world, random, structureboundingbox, 1 + j * byte0, 2 + j * 3, 0);
        }

        return true;
    }

    protected void makeStairs7flight(World world, Random random, StructureBoundingBox structureboundingbox, int i, int j, int k)
    {
        int l = coordBaseMode;
        coordBaseMode = (coordBaseMode + j) % 4;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 2, 1 + i, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 3, 1 + i, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 4, 2 + i, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 5, 2 + i, 5, structureboundingbox);
        coordBaseMode = l;
    }

    protected boolean makeStairs9(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 1, 1, 6, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 1, 1, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 7, 1, 2, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 7, 1, 1, structureboundingbox);
        byte byte0 = 3;
        int i = highestOpening / byte0;
        for(int j = 0; j < i; j++)
        {
            makeStairs9flight(world, random, structureboundingbox, 1 + j * byte0, 0 + j * 3, 2);
            makeStairs9flight(world, random, structureboundingbox, 1 + j * byte0, 2 + j * 3, 0);
        }

        return true;
    }

    protected void makeStairs9flight(World world, Random random, StructureBoundingBox structureboundingbox, int i, int j, int k)
    {
        int l = coordBaseMode;
        coordBaseMode = (coordBaseMode + j) % 4;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 2, 1 + i, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 3, 1 + i, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 4, 2 + i, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 5, 2 + i, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 6, 3 + i, 7, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 7, 3 + i, 7, structureboundingbox);
        coordBaseMode = l;
    }

    protected boolean makeStairs15(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 1, 1, 9, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 2, 1, 9, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 1, 1, 10, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 2, 1, 10, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 1, 2, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 2, 2, 2, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 1, 2, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 2, 2, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 1, 2, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 2, 2, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 3, 2, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 3, 3, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 3, 4, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, 3, 5, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 3, 1, 10, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 3, 2, 10, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 3, 3, 10, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 2, 3, 1, 9, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 3, 2, 9, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 13, 1, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 12, 1, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 13, 1, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 12, 1, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 13, 2, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, 0, 12, 2, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 13, 2, 2, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 12, 2, 2, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 13, 2, 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 12, 2, 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 11, 2, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 3, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 4, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, 11, 5, 3, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 11, 1, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 2, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 3, 4, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, 0, 11, 1, 5, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 2, 5, structureboundingbox);
        byte byte0 = 5;
        int i = highestOpening / byte0;
        for(int j = 0; j < i; j++)
        {
            makeStairs15flight(world, random, structureboundingbox, 2 + j * byte0, 0 + j * 3, 2);
            makeStairs15flight(world, random, structureboundingbox, 2 + j * byte0, 2 + j * 3, 0);
        }

        return true;
    }

    protected void makeStairs15flight(World world, Random random, StructureBoundingBox structureboundingbox, int i, int j, int k)
    {
        int l = coordBaseMode;
        coordBaseMode = (coordBaseMode + j) % 4;
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 3, 1 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 4, 1 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 5, 2 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 6, 2 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 7, 3 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 8, 3 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 9, 4 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 10, 4 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 11, 5 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 12, 5 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 13, 5 + i, 13, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 3, 1 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 4, 1 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 5, 2 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 6, 2 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 7, 3 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 8, 3 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 9, 4 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 10, 4 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairSingle.blockID, k, 11, 5 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 12, 5 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 13, 5 + i, 12, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 4, 1 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 5, 2 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 6, 2 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 7, 3 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 8, 3 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 9, 4 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 10, 4 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.stairDouble.blockID, k, 11, 5 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 4, 2 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 5, 3 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 6, 3 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 7, 4 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 8, 4 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 9, 5 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 10, 5 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 6 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 4, 3 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 6, 4 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 8, 5 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 10, 6 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 11, 7 + i, 11, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 0, 11, 8 + i, 11, structureboundingbox);
        coordBaseMode = l;
    }
}
