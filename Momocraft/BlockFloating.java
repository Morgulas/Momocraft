// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityFallingSand, 
//            BlockFire

public class BlockFloating extends Block
{

    public BlockFloating(int i, int j, boolean flag)
    {
        super(i, j, Material.rock);
        enchanted = flag;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(!enchanted || enchanted && world.isBlockGettingPowered(i, j, k))
        {
            tryToFall(world, i, j, k);
        }
    }

    private void tryToFall(World world, int i, int j, int k)
    {
        int l = i;
        int i1 = j;
        int j1 = k;
        if(canFallAbove(world, l, i1 + 1, j1) && i1 < 128)
        {
            byte byte0 = 32;
            if(fallInstantly || !world.checkChunksExist(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0))
            {
                world.setBlockWithNotify(i, j, k, 0);
                for(; canFallAbove(world, i, j + 1, k) && j < 128; j++) { }
                if(j > 0)
                {
                    world.setBlockWithNotify(i, j, k, blockID);
                }
            } else
            {
                EntityFloatingBlock entityfloatingblock = new EntityFloatingBlock(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, blockID);
                world.entityJoinedWorld(entityfloatingblock);
            }
        }
    }

    public int tickRate()
    {
        return 3;
    }

    public static boolean canFallAbove(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j, k);
        if(l == 0)
        {
            return true;
        }
        if(l == Block.fire.blockID)
        {
            return true;
        }
        Material material = Block.blocksList[l].blockMaterial;
        if(material == Material.water)
        {
            return true;
        } else
        {
            return material == Material.lava;
        }
    }

    public static boolean fallInstantly = false;
    private boolean enchanted;
}
