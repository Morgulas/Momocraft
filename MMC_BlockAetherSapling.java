package net.minecraft.src;

import java.util.*;
import net.minecraft.src.*;

public class MMC_BlockAetherSapling extends BlockFlower {
	
	public MMC_BlockAetherSapling(int i)
    {
        super(i, i != MMC_ID.idBlockAetherGoldenOakSapling ? sprSkyroot : sprGoldenOak);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(30) == 0)
        {
            growTree(world, i, j, k, random);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(blockID == MMC_Block.BlockAetherGoldenOakSapling.blockID)
        {
            return sprGoldenOak;
        } else
        {
            return sprSkyroot;
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == MMC_Block.BlockAetherGrass.blockID || i == MMC_Block.BlockAetherDirt.blockID;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return false;
        }
        if(entityplayer == null)
        {
            return false;
        }
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if(itemstack == null)
        {
            return false;
        }
        if(itemstack.itemID != Item.dyePowder.shiftedIndex)
        {
            return false;
        }
        if(itemstack.getItemDamage() != 15)
        {
            return false;
        } else
        {
            growTree(world, i, j, k, world.rand);
            itemstack.stackSize--;
            return true;
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        world.setBlock(i, j, k, 0);
        Object obj = null;
        if(blockID == MMC_Block.BlockAetherGoldenOakSapling.blockID)
        {
            obj = new MMC_GenAetherGoldenOak();
        } else
        {
            obj = new MMC_GenAetherSkyroot();
        }
        if(!((WorldGenerator)obj).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, blockID);
        }
    }

    public static int sprSkyroot = MMC_Textures.TexBlockAetherSkyrootSapling;
    public static int sprGoldenOak = MMC_Textures.TexBlockAetherGoldenOakSapling;

}
