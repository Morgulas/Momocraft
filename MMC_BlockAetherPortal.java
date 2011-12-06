package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_BlockAetherPortal extends BlockBreakable{
	
	 public MMC_BlockAetherPortal(int i, int j)
	    {
	        super(i, j, Material.portal, false);
	    }

	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	    {
	        return null;
	    }

	    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
	    {
	        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	    }

	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	    public boolean tryToCreatePortal(World world, int i, int j, int k)
	    {
	        if(isGoodPortalPool(world, i, j, k))
	        {
	            world.addWeatherEffect(new EntityLightningBolt(world, i, j, k));
	            transmuteWaterToPortal(world, i, j, k);
	            return true;
	        } else
	        {
	            return false;
	        }
	    }

	    public void transmuteWaterToPortal(World world, int i, int j, int k)
	    {
	        int l = i;
	        int i1 = k;
	        if(world.getBlockMaterial(l - 1, j, i1) == Material.water)
	        {
	            l--;
	        }
	        if(world.getBlockMaterial(l, j, i1 - 1) == Material.water)
	        {
	            i1--;
	        }
	        world.editingBlocks = true;
	        world.setBlockWithNotify(l + 0, j, i1 + 0, MMC_Block.BlockAetherPortal.blockID);
	        world.setBlockWithNotify(l + 1, j, i1 + 0, MMC_Block.BlockAetherPortal.blockID);
	        world.setBlockWithNotify(l + 1, j, i1 + 1, MMC_Block.BlockAetherPortal.blockID);
	        world.setBlockWithNotify(l + 0, j, i1 + 1, MMC_Block.BlockAetherPortal.blockID);
	        world.editingBlocks = false;
	    }

	    public boolean isGoodPortalPool(World world, int i, int j, int k)
	    {
	        boolean flag = false;
	        flag |= isGoodPortalPoolStrict(world, i + 0, j, k + 0);
	        flag |= isGoodPortalPoolStrict(world, i - 1, j, k - 1);
	        flag |= isGoodPortalPoolStrict(world, i + 0, j, k - 1);
	        flag |= isGoodPortalPoolStrict(world, i + 1, j, k - 1);
	        flag |= isGoodPortalPoolStrict(world, i - 1, j, k + 0);
	        flag |= isGoodPortalPoolStrict(world, i + 1, j, k + 0);
	        flag |= isGoodPortalPoolStrict(world, i - 1, j, k + 1);
	        flag |= isGoodPortalPoolStrict(world, i + 0, j, k + 1);
	        flag |= isGoodPortalPoolStrict(world, i + 1, j, k + 1);
	        return flag;
	    }

	    public boolean isGoodPortalPoolStrict(World world, int i, int j, int k)
	    {
	        boolean flag = true;
	        flag &= world.getBlockMaterial(i + 0, j, k + 0) == Material.water;
	        flag &= world.getBlockMaterial(i + 1, j, k + 0) == Material.water;
	        flag &= world.getBlockMaterial(i + 1, j, k + 1) == Material.water;
	        flag &= world.getBlockMaterial(i + 0, j, k + 1) == Material.water;
	        flag &= world.getBlockMaterial(i - 1, j, k - 1) == Material.grass;
	        flag &= world.getBlockMaterial(i - 1, j, k + 0) == Material.grass;
	        flag &= world.getBlockMaterial(i - 1, j, k + 1) == Material.grass;
	        flag &= world.getBlockMaterial(i - 1, j, k + 2) == Material.grass;
	        flag &= world.getBlockMaterial(i + 0, j, k - 1) == Material.grass;
	        flag &= world.getBlockMaterial(i + 1, j, k - 1) == Material.grass;
	        flag &= world.getBlockMaterial(i + 0, j, k + 2) == Material.grass;
	        flag &= world.getBlockMaterial(i + 1, j, k + 2) == Material.grass;
	        flag &= world.getBlockMaterial(i + 2, j, k - 1) == Material.grass;
	        flag &= world.getBlockMaterial(i + 2, j, k + 0) == Material.grass;
	        flag &= world.getBlockMaterial(i + 2, j, k + 1) == Material.grass;
	        flag &= world.getBlockMaterial(i + 2, j, k + 2) == Material.grass;
	        flag &= world.getBlockMaterial(i + 0, j - 1, k + 0).isSolid();
	        flag &= world.getBlockMaterial(i + 1, j - 1, k + 0).isSolid();
	        flag &= world.getBlockMaterial(i + 1, j - 1, k + 1).isSolid();
	        flag &= world.getBlockMaterial(i + 0, j - 1, k + 1).isSolid();
	        flag &= isNatureBlock(world, i - 1, j + 1, k - 1);
	        flag &= isNatureBlock(world, i - 1, j + 1, k + 0);
	        flag &= isNatureBlock(world, i - 1, j + 1, k + 1);
	        flag &= isNatureBlock(world, i - 1, j + 1, k + 2);
	        flag &= isNatureBlock(world, i + 0, j + 1, k - 1);
	        flag &= isNatureBlock(world, i + 1, j + 1, k - 1);
	        flag &= isNatureBlock(world, i + 0, j + 1, k + 2);
	        flag &= isNatureBlock(world, i + 1, j + 1, k + 2);
	        flag &= isNatureBlock(world, i + 2, j + 1, k - 1);
	        flag &= isNatureBlock(world, i + 2, j + 1, k + 0);
	        flag &= isNatureBlock(world, i + 2, j + 1, k + 1);
	        flag &= isNatureBlock(world, i + 2, j + 1, k + 2);
	        return flag;
	    }

	    public boolean isNatureBlock(World world, int i, int j, int k)
	    {
	        int ai[] = {
	            Block.mushroomBrown.blockID, Block.mushroomRed.blockID, Block.tallGrass.blockID, Block.plantRed.blockID, Block.plantYellow.blockID
	        };
	        int l = world.getBlockId(i, j, k);
	        for(int i1 = 0; i1 < ai.length; i1++)
	        {
	            if(l == ai[i1])
	            {
	                return true;
	            }
	        }

	        return false;
	    }

	    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
	    {
	        boolean flag = true;
	        if(world.getBlockId(i - 1, j, k) == blockID)
	        {
	            flag &= isGrassOrDirt(world, i + 1, j, k);
	        } else
	        if(world.getBlockId(i + 1, j, k) == blockID)
	        {
	            flag &= isGrassOrDirt(world, i - 1, j, k);
	        } else
	        {
	            flag = false;
	        }
	        if(world.getBlockId(i, j, k - 1) == blockID)
	        {
	            flag &= isGrassOrDirt(world, i, j, k + 1);
	        } else
	        if(world.getBlockId(i, j, k + 1) == blockID)
	        {
	            flag &= isGrassOrDirt(world, i, j, k - 1);
	        } else
	        {
	            flag = false;
	        }
	        if(!flag)
	        {
	            world.setBlockWithNotify(i, j, k, Block.waterStill.blockID);
	        }
	    }

	    protected boolean isGrassOrDirt(World world, int i, int j, int k)
	    {
	        return world.getBlockMaterial(i, j, k) == Material.grass || world.getBlockMaterial(i, j, k) == Material.ground;
	    }

	    public int quantityDropped(Random random)
	    {
	        return 0;
	    }

	    public int getRenderBlockPass()
	    {
	        return 1;
	    }

	    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	    {
	        if(entity.ridingEntity == null && entity.riddenByEntity == null)
	        {
	            entity.setInPortal();
	        }
	    }

	    public void randomDisplayTick(World world, int i, int j, int k, Random random)
	    {
	        if(random.nextInt(100) == 0)
	        {
	            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "portal.portal", 1.0F, random.nextFloat() * 0.4F + 0.8F);
	        }
	        for(int l = 0; l < 4; l++)
	        {
	            double d = (float)i + random.nextFloat();
	            double d1 = (float)j + random.nextFloat();
	            double d2 = (float)k + random.nextFloat();
	            double d3 = 0.0D;
	            double d4 = 0.0D;
	            double d5 = 0.0D;
	            int i1 = random.nextInt(2) * 2 - 1;
	            d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
	            d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
	            d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
	            if(world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID)
	            {
	                d2 = (double)k + 0.5D + 0.25D * (double)i1;
	                d5 = random.nextFloat() * 2.0F * (float)i1;
	            } else
	            {
	                d = (double)i + 0.5D + 0.25D * (double)i1;
	                d3 = random.nextFloat() * 2.0F * (float)i1;
	            }
	            world.spawnParticle("portal", d, d1, d2, d3, d4, d5);
	        }

	    }
	
	
	
	
	
	
/*    public BlockAetherPortal(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherPortal);
    }

    public boolean tryToCreatePortal(World world, int i, int j, int k)
    {
        int l = 0;
        int i1 = 0;
        if(world.getBlockId(i - 1, j, k) == Block.glowStone.blockID || world.getBlockId(i + 1, j, k) == Block.glowStone.blockID)
        {
            l = 1;
        }
        if(world.getBlockId(i, j, k - 1) == Block.glowStone.blockID || world.getBlockId(i, j, k + 1) == Block.glowStone.blockID)
        {
            i1 = 1;
        }
        if(l == i1)
        {
            return false;
        }
        if(world.getBlockId(i - l, j, k - i1) == 0)
        {
            i -= l;
            k -= i1;
        }
        for(int j1 = -1; j1 <= 2; j1++)
        {
            for(int l1 = -1; l1 <= 3; l1++)
            {
                boolean flag = j1 == -1 || j1 == 2 || l1 == -1 || l1 == 3;
                if((j1 == -1 || j1 == 2) && (l1 == -1 || l1 == 3))
                {
                    continue;
                }
                int j2 = world.getBlockId(i + l * j1, j + l1, k + i1 * j1);
                if(flag)
                {
                    if(j2 != Block.glowStone.blockID)
                    {
                        return false;
                    }
                    continue;
                }
                if(j2 != 0 && j2 != Block.waterMoving.blockID)
                {
                    return false;
                }
            }

        }

        world.editingBlocks = true;
        for(int k1 = 0; k1 < 2; k1++)
        {
            for(int i2 = 0; i2 < 3; i2++)
            {
                world.setBlockWithNotify(i + l * k1, j + i2, k + i1 * k1, blockID);
            }

        }

        world.editingBlocks = false;
        return true;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = 0;
        int j1 = 1;
        if(world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID)
        {
            i1 = 1;
            j1 = 0;
        }
        int k1;
        for(k1 = j; world.getBlockId(i, k1 - 1, k) == blockID; k1--) { }
        if(world.getBlockId(i, k1 - 1, k) != Block.glowStone.blockID)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        int l1;
        for(l1 = 1; l1 < 4 && world.getBlockId(i, k1 + l1, k) == blockID; l1++) { }
        if(l1 != 3 || world.getBlockId(i, k1 + l1, k) != Block.glowStone.blockID)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        boolean flag = world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID;
        boolean flag1 = world.getBlockId(i, j, k - 1) == blockID || world.getBlockId(i, j, k + 1) == blockID;
        if(flag && flag1)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        if((world.getBlockId(i + i1, j, k + j1) != Block.glowStone.blockID || world.getBlockId(i - i1, j, k - j1) != blockID) && (world.getBlockId(i - i1, j, k - j1) != Block.glowStone.blockID || world.getBlockId(i + i1, j, k + j1) != blockID))
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        } else
        {
            return;
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(100) == 0)
        {
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "portal.portal", 1.0F, random.nextFloat() * 0.4F + 0.8F);
        }
        for(int l = 0; l < 4; l++)
        {
            double d = (float)i + random.nextFloat();
            double d1 = (float)j + random.nextFloat();
            double d2 = (float)k + random.nextFloat();
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = random.nextInt(2) * 2 - 1;
            d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            if(world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID)
            {
                d2 = (double)k + 0.5D + 0.25D * (double)i1;
                d5 = random.nextFloat() * 2.0F * (float)i1;
            } else
            {
                d = (double)i + 0.5D + 0.25D * (double)i1;
                d3 = random.nextFloat() * 2.0F * (float)i1;
            }
            EntityAetherPortalFX entityaetherportalfx = new EntityAetherPortalFX(world, d, d1, d2, d3, d4, d5);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(entityaetherportalfx);
        }

    }

    public int getDimNumber()
    {
        return 3;
    }
*/
}
