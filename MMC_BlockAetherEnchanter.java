package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_BlockAetherEnchanter extends BlockContainer{
	
    public MMC_BlockAetherEnchanter(int i)
    {
        super(i, Material.rock);
        blockIndexInTexture = MMC_Textures.TexBlockMomocraftTest;
        sideTexture = MMC_Textures.TexBlockMomocraftTest;
        EnchanterRand = new Random();
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        setDefaultDirection(world, i, j, k);
    }

    private void setDefaultDirection(World world, int i, int j, int k)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }

/*    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        TileEntityEnchanter tileentityenchanter = (TileEntityEnchanter)world.getBlockTileEntity(i, j, k);
        if(tileentityenchanter.isBurning())
        {
            float f = (float)i + 0.5F;
            float f1 = (float)j + 1.0F + (random.nextFloat() * 6F) / 16F;
            float f2 = (float)k + 0.5F;
            world.spawnParticle("smoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", f, f1, f2, 0.0D, 0.0D, 0.0D);
        }
    }
*/
    
public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture;
        }
        if(i == 0)
        {
            return blockIndexInTexture;
        } else
        {
            return sideTexture;
        }
    }

/*    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        } else
        {
            TileEntityEnchanter tileentityenchanter = (TileEntityEnchanter)world.getBlockTileEntity(i, j, k);
            ModLoader.OpenGUI(entityplayer, new GuiEnchanter(entityplayer.inventory, tileentityenchanter));
            return true;
        }
    }
*/
    public static void updateEnchanterBlockState(boolean flag, World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        TileEntity tileentity = world.getBlockTileEntity(i, j, k);
        world.setBlockMetadataWithNotify(i, j, k, l);
        world.setBlockTileEntity(i, j, k, tileentity);
    }

/*    protected TileEntity getBlockEntity()
    {
        return new TileEntityEnchanter();
    }
*/
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        }
    }

/*    public void onBlockRemoval(World world, int i, int j, int k)
    {
        TileEntityEnchanter tileentityenchanter = (TileEntityEnchanter)world.getBlockTileEntity(i, j, k);
label0:
        for(int l = 0; l < tileentityenchanter.getSizeInventory(); l++)
        {
            ItemStack itemstack = tileentityenchanter.getStackInSlot(l);
            if(itemstack == null)
            {
                continue;
            }
            float f = EnchanterRand.nextFloat() * 0.8F + 0.1F;
            float f1 = EnchanterRand.nextFloat() * 0.8F + 0.1F;
            float f2 = EnchanterRand.nextFloat() * 0.8F + 0.1F;
            do
            {
                if(itemstack.stackSize <= 0)
                {
                    continue label0;
                }
                int i1 = EnchanterRand.nextInt(21) + 10;
                if(i1 > itemstack.stackSize)
                {
                    i1 = itemstack.stackSize;
                }
                itemstack.stackSize -= i1;
                EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                float f3 = 0.05F;
                entityitem.motionX = (float)EnchanterRand.nextGaussian() * f3;
                entityitem.motionY = (float)EnchanterRand.nextGaussian() * f3 + 0.2F;
                entityitem.motionZ = (float)EnchanterRand.nextGaussian() * f3;
                world.entityJoinedWorld(entityitem);
            } while(true);
        }

        super.onBlockRemoval(world, i, j, k);
    }
*/
    private Random EnchanterRand;
    private int sideTexture;
    
    
	@Override
	public TileEntity getBlockEntity() {
		// TODO Auto-generated method stub
		return null;
	}
}
