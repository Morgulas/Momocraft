package net.minecraft.src;

import java.util.Random;

public class MC_1BlockBucheHory extends Block {
        
        public MC_1BlockBucheHory(int id) 
        {
                super(id, Material.wood);
                this.setHardness(1.0F);
                this.setResistance(1F);
                this.setBlockName("BucheHory");
        }

        public int quantityDropped(Random random)
        {
            return 1;
        }

        public int idDropped(int i, Random random, int j)
        {
            return Block.wood.blockID;
        }

        protected int damageDropped(int i)
        {
            return i & 7;
        }

        public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
        {
            int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 1;
            int i1 = world.getBlockMetadata(i, j, k);
            if(l == 1)
            {
                world.setBlockMetadataWithNotify(i, j, k, i1 + 8);
            } else
            {
                world.setBlockMetadataWithNotify(i, j, k, i1);
            }
        }
        
        public int getBlockTextureFromSideAndMetadata(int i, int j)
        {
            int k = j & 8;
            j &= 7;
            if(k == 0)
            {
                if(i == 2)
                {
                    return 21;
                }
                if(i == 3)
                {
                    return 21;
                }
                if(i == 4 || i == 5)
                {
                    if(j == 1)
                    {
                        return MC_0Textures.bLogSide3;
                    }
                    if (j == 0)
                    {
                    	return MC_0Textures.bLogSide1;
                    }
                    if (j == 2)
                    {
                    	return MC_0Textures.bLogSide2;
                    }
                }
                if(j == 1)
                {
                    return 116;
                } else
                {
                    return j == 2 ? 117 : 20;
                }
            }
            if(i == 4)
            {
                return 21;
            }
            if(i == 5)
            {
                return 21;
            }
            if(j == 1)
            {
                return MC_0Textures.bLogSide3;
            }
            if (j == 0)
            {
            	return MC_0Textures.bLogSide1;
            }
            if (j == 2)
            {
            	return MC_0Textures.bLogSide2;
            }
            else
            	return MC_0Textures.bTest;
        }       
}