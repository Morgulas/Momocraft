package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_BlockAetherChestMimic extends Block{
	
	public MMC_BlockAetherChestMimic(int i)
    {
        super(i, Material.wood);
        blockIndexInTexture = 26;
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return blockIndexInTexture - 1;
        }
        if(l == 0)
        {
            return blockIndexInTexture - 1;
        }
        int i1 = iblockaccess.getBlockId(i, j, k - 1);
        int j1 = iblockaccess.getBlockId(i, j, k + 1);
        int k1 = iblockaccess.getBlockId(i - 1, j, k);
        int l1 = iblockaccess.getBlockId(i + 1, j, k);
        if(i1 == blockID || j1 == blockID)
        {
            if(l == 2 || l == 3)
            {
                return blockIndexInTexture;
            }
            int i2 = 0;
            if(i1 == blockID)
            {
                i2 = -1;
            }
            int k2 = iblockaccess.getBlockId(i - 1, j, i1 == blockID ? k - 1 : k + 1);
            int i3 = iblockaccess.getBlockId(i + 1, j, i1 == blockID ? k - 1 : k + 1);
            if(l == 4)
            {
                i2 = -1 - i2;
            }
            byte byte1 = 5;
            if((Block.opaqueCubeLookup[k1] || Block.opaqueCubeLookup[k2]) && !Block.opaqueCubeLookup[l1] && !Block.opaqueCubeLookup[i3])
            {
                byte1 = 5;
            }
            if((Block.opaqueCubeLookup[l1] || Block.opaqueCubeLookup[i3]) && !Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[k2])
            {
                byte1 = 4;
            }
            return (l == byte1 ? blockIndexInTexture + 16 : blockIndexInTexture + 32) + i2;
        }
        if(k1 == blockID || l1 == blockID)
        {
            if(l == 4 || l == 5)
            {
                return blockIndexInTexture;
            }
            int j2 = 0;
            if(k1 == blockID)
            {
                j2 = -1;
            }
            int l2 = iblockaccess.getBlockId(k1 == blockID ? i - 1 : i + 1, j, k - 1);
            int j3 = iblockaccess.getBlockId(k1 == blockID ? i - 1 : i + 1, j, k + 1);
            if(l == 3)
            {
                j2 = -1 - j2;
            }
            byte byte2 = 3;
            if((Block.opaqueCubeLookup[i1] || Block.opaqueCubeLookup[l2]) && !Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[j3])
            {
                byte2 = 3;
            }
            if((Block.opaqueCubeLookup[j1] || Block.opaqueCubeLookup[j3]) && !Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l2])
            {
                byte2 = 2;
            }
            return (l == byte2 ? blockIndexInTexture + 16 : blockIndexInTexture + 32) + j2;
        }
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[l1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[l1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 4;
        }
        return l == byte0 ? blockIndexInTexture + 1 : blockIndexInTexture;
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture - 1;
        }
        if(i == 0)
        {
            return blockIndexInTexture - 1;
        }
        if(i == 3)
        {
            return blockIndexInTexture + 1;
        } else
        {
            return blockIndexInTexture;
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = 0;
        if(world.getBlockId(i - 1, j, k) == blockID)
        {
            l++;
        }
        if(world.getBlockId(i + 1, j, k) == blockID)
        {
            l++;
        }
        if(world.getBlockId(i, j, k - 1) == blockID)
        {
            l++;
        }
        if(world.getBlockId(i, j, k + 1) == blockID)
        {
            l++;
        }
        if(l > 1)
        {
            return false;
        }
        if(isThereANeighborChest(world, i - 1, j, k))
        {
            return false;
        }
        if(isThereANeighborChest(world, i + 1, j, k))
        {
            return false;
        }
        if(isThereANeighborChest(world, i, j, k - 1))
        {
            return false;
        } else
        {
            return !isThereANeighborChest(world, i, j, k + 1);
        }
    }

    private boolean isThereANeighborChest(World world, int i, int j, int k)
    {
        if(world.getBlockId(i, j, k) != blockID)
        {
            return false;
        }
        if(world.getBlockId(i - 1, j, k) == blockID)
        {
            return true;
        }
        if(world.getBlockId(i + 1, j, k) == blockID)
        {
            return true;
        }
        if(world.getBlockId(i, j, k - 1) == blockID)
        {
            return true;
        } else
        {
            return world.getBlockId(i, j, k + 1) == blockID;
        }
    }

/*    public void onBlockRemoval(World world, int i, int j, int k)
    {
        world.setBlockWithNotify(i, j, k, 0);
        EntityMimic entitymimic = new EntityMimic(world);
        entitymimic.setPosition((double)i + 0.5D, (double)j + 1.5D, (double)k + 0.5D);
        world.entityJoinedWorld(entitymimic);
    }
*/
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        world.setBlockWithNotify(i, j, k, 0);
        return true;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }
}
