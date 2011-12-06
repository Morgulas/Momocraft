// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;


// Referenced classes of package net.minecraft.src:
//            BlockContainer, Block, IBlockAccess, World, 
//            TileEntityPlaque, mod_Plaques, EntityPlayer, Material, 
//            Item, EntityItem, ItemStack, MathHelper, 
//            AxisAlignedBB, Vec3D, MovingObjectPosition, TileEntity

public class MMC_BlockPlaque extends BlockContainer
{

    private MMC_TileEntityPlaque tePlaque;
    private int angle;

    public MMC_BlockPlaque(int i, Block block, int j)
    {
        super(i, j, block.blockMaterial);
        angle = -1;
        setHardness(block.blockHardness);
        setResistance(block.blockResistance / 8F);
        setStepSound(block.stepSound);
        setRequiresSelfNotify();
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        switch(iblockaccess.getBlockMetadata(i, j, k))
        {
        case 0: // '\0'
            setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;

        case 1: // '\001'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
            break;

        case 2: // '\002'
            setBlockBounds(0.0F, 0.0F, 0.875F, 1.0F, 1.0F, 1.0F);
            break;

        case 3: // '\003'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.125F);
            break;

        case 4: // '\004'
            setBlockBounds(0.875F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;

        case 5: // '\005'
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.125F, 1.0F, 1.0F);
            break;
        }
    }

    public void setBlockBoundsForItemRender()
    {
        setBlockBounds(0.0F, 0.4375F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        setBlockBoundsBasedOnState(world, i, j, k);
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        setBlockBoundsBasedOnState(world, i, j, k);
        return super.collisionRayTrace(world, i, j, k, vec3d, vec3d1);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockMetadataWithNotify(i, j, k, l);
        world.setBlockTileEntity(i, j, k, getBlockEntity());
        tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(i, j, k);
        tePlaque.orientation = l;
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(i, j, k);
        if(tePlaque != null && tePlaque.rotation > -1)
        {
            Deplace(world, i, j, k, entityplayer, determineOrientation(world, i, j, k, entityplayer) != mod_Momocraft.Inverse(tePlaque.orientation));
            angle = tePlaque.angle;
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(i, j, k);
        if(tePlaque != null && tePlaque.rotation > -1)
        {
            return Deplace(world, i, j, k, entityplayer, determineOrientation(world, i, j, k, entityplayer) == mod_Momocraft.Inverse(tePlaque.orientation));
        } else
        {
            return false;
        }
    }

    private boolean Deplace(World world, int i, int j, int k, EntityPlayer entityplayer, boolean flag)
    {
        if(tePlaque.angle == 90 || tePlaque.angle == 180)
        {
            int l = i;
            int i1 = j;
            int j1 = k;
            int k1 = 0;
            int l1 = tePlaque.orientation;
            int i2 = tePlaque.rotation;
            int j2 = tePlaque.angle;
            if(flag && tePlaque.angle == 90)
            {
                k1 = l1;
            } else
            {
                k1 = i2;
            }
            switch(k1)
            {
            case 0: // '\0'
                i1++;
                break;

            case 1: // '\001'
                i1--;
                break;

            case 2: // '\002'
                j1++;
                break;

            case 3: // '\003'
                j1--;
                break;

            case 4: // '\004'
                l++;
                break;

            case 5: // '\005'
                l--;
                break;
            }
            if(world.isAirBlock(l, i1, j1) || world.getBlockMaterial(l, i1, j1) == Material.water || world.getBlockMaterial(l, i1, j1) == Material.lava)
            {
                world.setBlockWithNotify(i, j, k, 0);
                world.removeBlockTileEntity(i, j, k);
                int k2;
                int l2;
                if(tePlaque.angle == 90)
                {
                    k2 = flag ? i2 : mod_Momocraft.Inverse(i2);
                    l2 = flag ? mod_Momocraft.Inverse(l1) : l1;
                } else
                {
                    k2 = l1;
                    l2 = mod_Momocraft.Inverse(i2);
                }
                world.setBlock(l, i1, j1, blockID);
                world.setBlockMetadataWithNotify(l, i1, j1, k2);
                world.setBlockTileEntity(l, i1, j1, getBlockEntity());
                tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(l, i1, j1);
                tePlaque.orientation = k2;
                tePlaque.rotation = l2;
                tePlaque.angle = j2;
                world.playAuxSFXAtEntity(entityplayer, 1003, l, i1, j1, 0);
                return true;
            }
        }
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderBlockPass()
    {
        return blockID != MMC_ID.idBlockMomocraftPlaqueIce ? 0 : 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public TileEntity getBlockEntity()
    {
        return new MMC_TileEntityPlaque();
    }

    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        if(angle > -1)
        {
            Item item = null;
            if(angle == 90)
            {
                item = MMC_Item.ItemMomocraftCharniere;
            } else
            {
                item = MMC_Item.ItemMomocraftRail;
            }
            angle = -1;
            float f1 = 0.7F;
            float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(item));
            entityitem.delayBeforeCanPickup = 10;
            world.entityJoinedWorld(entityitem);
        }
    }

    public int idDropped(int i, Random random)
    {
        if(i == MMC_ID.idBlockMomocraftPlaqueGlowStoneLight)
        {
            return MMC_ID.idBlockMomocraftPlaqueGlowStone;
        } else
        {
            return blockID;
        }
    }

    public int tickRate()
    {
        return 2;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
    }

    public boolean IsBlockPowered(World world, int i, int j, int k)
    {
        return world.getBlockId(i, j, k) == MMC_ID.idBlockMomocraftPlaqueGlowStoneLight;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(blockID == MMC_ID.idBlockMomocraftPlaqueGlowStone || blockID == MMC_ID.idBlockMomocraftPlaqueGlowStoneLight)
        {
            boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k);
            if(flag)
            {
                if(!IsBlockPowered(world, i, j, k))
                {
                    ChangeBlock(world, i, j, k, MMC_ID.idBlockMomocraftPlaqueGlowStoneLight);
                }
            } else
            if(IsBlockPowered(world, i, j, k))
            {
                ChangeBlock(world, i, j, k, MMC_ID.idBlockMomocraftPlaqueGlowStone);
            }
        }
    }

    private void ChangeBlock(World world, int i, int j, int k, int l)
    {
        tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(i, j, k);
        int i1 = tePlaque.orientation;
        int j1 = tePlaque.rotation;
        int k1 = tePlaque.rotation;
        world.setBlock(i, j, k, l);
        world.setBlockMetadataWithNotify(i, j, k, i1);
        world.setBlockTileEntity(i, j, k, getBlockEntity());
        tePlaque = (MMC_TileEntityPlaque)world.getBlockTileEntity(i, j, k);
        tePlaque.orientation = i1;
        tePlaque.rotation = j1;
    }

    private static int determineOrientation(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(MathHelper.abs((float)entityplayer.posX - (float)i) < 2.0F && MathHelper.abs((float)entityplayer.posZ - (float)k) < 2.0F)
        {
            double d = (entityplayer.posY + 1.8200000000000001D) - (double)entityplayer.yOffset;
            if(d - (double)j > 2D)
            {
                return 1;
            }
            if((double)j - d > 0.0D)
            {
                return 0;
            }
        }
        int l = MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            return 2;
        }
        if(l == 1)
        {
            return 5;
        }
        if(l == 2)
        {
            return 3;
        } else
        {
            return l == 3 ? 4 : 0;
        }
    }
}
