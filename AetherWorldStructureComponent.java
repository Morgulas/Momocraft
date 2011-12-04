package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldStructureComponent extends StructureComponent{

	public AetherWorldStructureComponent(int i)
    {
        super(i);
    }

    public static StructureBoundingBox getComponentToAddBoundingBox(int i, int j, int k, int l, int i1, int j1, int k1, int l1, 
            int i2, int j2)
    {
        switch(j2)
        {
        default:
            return new StructureBoundingBox(i + l, j + i1, k + j1, i + k1 + l, j + l1 + i1, k + i2 + j1);

        case 0: // '\0'
            return new StructureBoundingBox(i + l, j + i1, k + j1, i + k1 + l, j + l1 + i1, k + i2 + j1);

        case 1: // '\001'
            return new StructureBoundingBox((i - i2) + j1, j + i1, k + l, i + j1, j + l1 + i1, k + k1 + l);

        case 2: // '\002'
            return new StructureBoundingBox(i - k1 - l, j + i1, k - i2 - j1, i - l, j + l1 + i1, k - j1);

        case 3: // '\003'
            return new StructureBoundingBox(i + j1, j + i1, k - k1, i + i2 + j1, j + l1 + i1, k + l);
        }
    }

    protected void placeSpawnerAtCurrentPosition(World world, Random random, int i, int j, int k, String s, StructureBoundingBox structureboundingbox)
    {
        int l = getXWithOffset(i, k);
        int i1 = getYWithOffset(j);
        int j1 = getZWithOffset(i, k);
        if(structureboundingbox.isVecInside(l, i1, j1) && world.getBlockId(l, i1, j1) != Block.mobSpawner.blockID)
        {
            world.setBlockWithNotify(l, i1, j1, Block.mobSpawner.blockID);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(l, i1, j1);
            if(tileentitymobspawner != null)
            {
                tileentitymobspawner.setMobID(s);
            }
        }
    }

    protected void placeTreasureAtCurrentPosition(World world, Random random, int i, int j, int k, AetherWorldTreasure tftreasure, StructureBoundingBox structureboundingbox)
    {
        int l = getXWithOffset(i, k);
        int i1 = getYWithOffset(j);
        int j1 = getZWithOffset(i, k);
        if(structureboundingbox.isVecInside(l, i1, j1) && world.getBlockId(l, i1, j1) != Block.chest.blockID)
        {
            tftreasure.generate(world, random, l, i1, j1);
        }
    }

    protected int[] offsetTowerCoords(int i, int j, int k, int l, int i1)
    {
        int j1 = getXWithOffset(i, k);
        int k1 = getYWithOffset(j);
        int l1 = getZWithOffset(i, k);
        if(i1 == 0)
        {
            return (new int[] {
                j1 + 1, k1 - 1, l1 - l / 2
            });
        }
        if(i1 == 1)
        {
            return (new int[] {
                j1 + l / 2, k1 - 1, l1 + 1
            });
        }
        if(i1 == 2)
        {
            return (new int[] {
                j1 - 1, k1 - 1, l1 + l / 2
            });
        }
        if(i1 == 3)
        {
            return (new int[] {
                j1 - l / 2, k1 - 1, l1 - 1
            });
        } else
        {
            return (new int[] {
                i, j, k
            });
        }
    }

    public int[] getOffsetAsIfRotated(int ai[], int i)
    {
        int j = coordBaseMode;
        int ai1[] = new int[3];
        coordBaseMode = i;
        ai1[0] = getXWithOffset(ai[0], ai[2]);
        ai1[1] = getYWithOffset(ai[1]);
        ai1[2] = getZWithOffset(ai[0], ai[2]);
        coordBaseMode = j;
        return ai1;
    }

    protected int getXWithOffset(int i, int j)
    {
        switch(coordBaseMode)
        {
        case 0: // '\0'
            return boundingBox.minX + i;

        case 1: // '\001'
            return boundingBox.maxX - j;

        case 2: // '\002'
            return boundingBox.maxX - i;

        case 3: // '\003'
            return boundingBox.minX + j;
        }
        return i;
    }

    protected int getZWithOffset(int i, int j)
    {
        switch(coordBaseMode)
        {
        case 0: // '\0'
            return boundingBox.minZ + j;

        case 1: // '\001'
            return boundingBox.minZ + i;

        case 2: // '\002'
            return boundingBox.maxZ - j;

        case 3: // '\003'
            return boundingBox.maxZ - i;
        }
        return j;
    }

	@Override
	public boolean addComponentParts(World world, Random random,
			StructureBoundingBox structureboundingbox) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
