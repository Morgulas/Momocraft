package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class BlockAetherTreasureChest extends BlockContainer{
	
	public BlockAetherTreasureChest(int i, int j, int k)
    {
        super(i, Material.rock);
        random = new Random();
        blockIndexInTexture = j;
        sideTexture = k;
    }

    public int quantityDropped(Random random1)
    {
        return 0;
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return 62;
        }
        if(l == 0)
        {
            return 62;
        }
        int i1 = iblockaccess.getBlockId(i, j, k - 1);
        int j1 = iblockaccess.getBlockId(i, j, k + 1);
        int k1 = iblockaccess.getBlockId(i - 1, j, k);
        int l1 = iblockaccess.getBlockId(i + 1, j, k);
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
        return l == byte0 ? blockIndexInTexture : sideTexture;
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return 62;
        }
        if(i == 0)
        {
            return 62;
        }
        if(i == 3)
        {
            return blockIndexInTexture;
        } else
        {
            return sideTexture;
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return false;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        }
        int l = world.getBlockMetadata(i, j, k);
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
        if(l % 2 == 1)
        {
            ModLoader.OpenGUI(entityplayer, new GuiTreasureChest(entityplayer.inventory, tileentitychest, l));
            return true;
        }
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherKey.shiftedIndex && itemstack.getItemDamage() == 0 && l == 0)
        {
            entityplayer.inventory.decrStackSize(entityplayer.inventory.currentItem, 1);
            world.setBlockMetadata(i, j, k, l + 1);
            world.setBlockTileEntity(i, j, k, tileentitychest);
            return true;
        }
        if(itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherKey.shiftedIndex && itemstack.getItemDamage() == 1 && l == 2)
        {
            entityplayer.inventory.decrStackSize(entityplayer.inventory.currentItem, 1);
            world.setBlockMetadata(i, j, k, l + 1);
            world.setBlockTileEntity(i, j, k, tileentitychest);
            return true;
        }
        if(itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherKey.shiftedIndex && itemstack.getItemDamage() == 2 && l == 4)
        {
            entityplayer.inventory.decrStackSize(entityplayer.inventory.currentItem, 1);
            world.setBlockMetadata(i, j, k, l + 1);
            world.setBlockTileEntity(i, j, k, tileentitychest);
            return true;
        } else
        {
            return false;
        }
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntityChest();
    }

    private Random random;
    private int sideTexture;
	

}
