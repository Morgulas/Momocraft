package net.minecraft.src;

import java.util.Random;

public class AetherWorldTeleporter extends Teleporter{

    public AetherWorldTeleporter()
    {
    }

    public boolean placeInExistingPortal(World world, Entity entity)
    {
        char c = '\310';
        double d = -1D;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.floor_double(entity.posX);
        int i1 = MathHelper.floor_double(entity.posZ);
        for(int j1 = l - c; j1 <= l + c; j1++)
        {
            double d1 = ((double)j1 + 0.5D) - entity.posX;
            for(int j2 = i1 - c; j2 <= i1 + c; j2++)
            {
                double d3 = ((double)j2 + 0.5D) - entity.posZ;
                world.getClass();
                for(int k2 = 127; k2 >= 0; k2--)
                {
                    if(!isBlockPortal(world, j1, k2, j2))
                    {
                        continue;
                    }
                    for(; isBlockPortal(world, j1, k2 - 1, j2); k2--) { }
                    double d5 = ((double)k2 + 0.5D) - entity.posY;
                    double d7 = d1 * d1 + d5 * d5 + d3 * d3;
                    if(d < 0.0D || d7 < d)
                    {
                        d = d7;
                        i = j1;
                        j = k2;
                        k = j2;
                    }
                }

            }

        }

        if(d >= 0.0D)
        {
            int k1 = i;
            int l1 = j;
            int i2 = k;
            double d2 = (double)k1 + 0.5D;
            double d4 = (double)l1 + 0.5D;
            double d6 = (double)i2 + 0.5D;
            if(isBlockPortal(world, k1 - 1, l1, i2))
            {
                d2 -= 0.5D;
            }
            if(isBlockPortal(world, k1 + 1, l1, i2))
            {
                d2 += 0.5D;
            }
            if(isBlockPortal(world, k1, l1, i2 - 1))
            {
                d6 -= 0.5D;
            }
            if(isBlockPortal(world, k1, l1, i2 + 1))
            {
                d6 += 0.5D;
            }
            entity.setLocationAndAngles(d2, d4, d6, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isBlockPortal(World world, int i, int j, int k)
    {
        return world.getBlockMaterial(i, j, k) == Material.portal;
    }

    public boolean createPortal(World world, Entity entity)
    {
        byte byte0 = 16;
        double d = -1D;
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY);
        int k = MathHelper.floor_double(entity.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = world.rand.nextInt(4);
        for(int i2 = i - byte0; i2 <= i + byte0; i2++)
        {
            double d1 = ((double)i2 + 0.5D) - entity.posX;
            for(int j3 = k - byte0; j3 <= k + byte0; j3++)
            {
                double d3 = ((double)j3 + 0.5D) - entity.posZ;
                world.getClass();
                for(int k4 = 127; k4 >= 0; k4--)
                {
                    if(!world.isAirBlock(i2, k4, j3))
                    {
                        continue;
                    }
                    for(; k4 > 0 && world.isAirBlock(i2, k4 - 1, j3); k4--) { }
label0:
                    for(int i5 = l1; i5 < l1 + 4; i5++)
                    {
                        int k5 = i5 % 2;
                        int i6 = 1 - k5;
                        if(i5 % 4 >= 2)
                        {
                            k5 = -k5;
                            i6 = -i6;
                        }
                        for(int k6 = 0; k6 < 3; k6++)
                        {
                            for(int i7 = 0; i7 < 4; i7++)
                            {
                                for(int k7 = -1; k7 < 4; k7++)
                                {
                                    int i8 = i2 + (i7 - 1) * k5 + k6 * i6;
                                    int k8 = k4 + k7;
                                    int i9 = (j3 + (i7 - 1) * i6) - k6 * k5;
                                    if(k7 < 0 && !world.getBlockMaterial(i8, k8, i9).isSolid() || k7 >= 0 && !world.isAirBlock(i8, k8, i9))
                                    {
                                        break label0;
                                    }
                                }

                            }

                        }

                        double d5 = ((double)k4 + 0.5D) - entity.posY;
                        double d7 = d1 * d1 + d5 * d5 + d3 * d3;
                        if(d < 0.0D || d7 < d)
                        {
                            d = d7;
                            l = i2;
                            i1 = k4;
                            j1 = j3;
                            k1 = i5 % 4;
                        }
                    }

                }

            }

        }

        if(d < 0.0D)
        {
            for(int j2 = i - byte0; j2 <= i + byte0; j2++)
            {
                double d2 = ((double)j2 + 0.5D) - entity.posX;
                for(int k3 = k - byte0; k3 <= k + byte0; k3++)
                {
                    double d4 = ((double)k3 + 0.5D) - entity.posZ;
                    world.getClass();
                    for(int l4 = 127; l4 >= 0; l4--)
                    {
                        if(!world.isAirBlock(j2, l4, k3))
                        {
                            continue;
                        }
                        for(; l4 > 0 && world.isAirBlock(j2, l4 - 1, k3); l4--) { }
label1:
                        for(int j5 = l1; j5 < l1 + 2; j5++)
                        {
                            int l5 = j5 % 2;
                            int j6 = 1 - l5;
                            for(int l6 = 0; l6 < 4; l6++)
                            {
                                for(int j7 = -1; j7 < 4; j7++)
                                {
                                    int l7 = j2 + (l6 - 1) * l5;
                                    int j8 = l4 + j7;
                                    int l8 = k3 + (l6 - 1) * j6;
                                    if(j7 < 0 && !world.getBlockMaterial(l7, j8, l8).isSolid() || j7 >= 0 && !world.isAirBlock(l7, j8, l8))
                                    {
                                        break label1;
                                    }
                                }

                            }

                            double d6 = ((double)l4 + 0.5D) - entity.posY;
                            double d8 = d2 * d2 + d6 * d6 + d4 * d4;
                            if(d < 0.0D || d8 < d)
                            {
                                d = d8;
                                l = j2;
                                i1 = l4;
                                j1 = k3;
                                k1 = j5 % 2;
                            }
                        }

                    }

                }

            }

        }
        int k2 = k1;
        int l2 = l;
        int i3 = i1;
        int l3 = j1;
        int i4 = k2 % 2;
        int j4 = 1 - i4;
        if(k2 % 4 >= 2)
        {
            i4 = -i4;
            j4 = -j4;
        }
        makePortalAt(world, l2, i3, l3);
        return true;
    }

    private void makePortalAt(World world, int i, int j, int k)
    {
        if(j < 30)
        {
            j = 30;
        }
        world.getClass();
        if(j > 118)
        {
            world.getClass();
            j = 118;
        }
        j--;
        world.editingBlocks = true;
        world.setBlock(i - 1, j + 0, k - 1, Block.grass.blockID);
        world.setBlock(i + 0, j + 0, k - 1, Block.grass.blockID);
        world.setBlock(i + 1, j + 0, k - 1, Block.grass.blockID);
        world.setBlock(i + 2, j + 0, k - 1, Block.grass.blockID);
        world.setBlock(i - 1, j + 0, k + 0, Block.grass.blockID);
        world.setBlock(i + 2, j + 0, k + 0, Block.grass.blockID);
        world.setBlock(i - 1, j + 0, k + 1, Block.grass.blockID);
        world.setBlock(i + 2, j + 0, k + 1, Block.grass.blockID);
        world.setBlock(i - 1, j + 0, k + 2, Block.grass.blockID);
        world.setBlock(i + 0, j + 0, k + 2, Block.grass.blockID);
        world.setBlock(i + 1, j + 0, k + 2, Block.grass.blockID);
        world.setBlock(i + 2, j + 0, k + 2, Block.grass.blockID);
        world.setBlock(i + 0, j - 1, k + 0, Block.dirt.blockID);
        world.setBlock(i + 1, j - 1, k + 0, Block.dirt.blockID);
        world.setBlock(i + 0, j - 1, k + 1, Block.dirt.blockID);
        world.setBlock(i + 1, j - 1, k + 1, Block.dirt.blockID);
        world.setBlock(i + 0, j + 0, k + 0, MomocraftBlocks.BlockAetherPortal.blockID);
        world.setBlock(i + 1, j + 0, k + 0, MomocraftBlocks.BlockAetherPortal.blockID);
        world.setBlock(i + 0, j + 0, k + 1, MomocraftBlocks.BlockAetherPortal.blockID);
        world.setBlock(i + 1, j + 0, k + 1, MomocraftBlocks.BlockAetherPortal.blockID);
        for(int l = -1; l <= 2; l++)
        {
            for(int i1 = -1; i1 <= 2; i1++)
            {
                for(int j1 = 1; j1 <= 5; j1++)
                {
                    world.setBlock(i + l, j + j1, k + i1, 0);
                }

            }

        }

        world.setBlock(i - 1, j + 1, k - 1, randNatureBlockID(world.rand));
        world.setBlock(i + 0, j + 1, k - 1, randNatureBlockID(world.rand));
        world.setBlock(i + 1, j + 1, k - 1, randNatureBlockID(world.rand));
        world.setBlock(i + 2, j + 1, k - 1, randNatureBlockID(world.rand));
        world.setBlock(i - 1, j + 1, k + 0, randNatureBlockID(world.rand));
        world.setBlock(i + 2, j + 1, k + 0, randNatureBlockID(world.rand));
        world.setBlock(i - 1, j + 1, k + 1, randNatureBlockID(world.rand));
        world.setBlock(i + 2, j + 1, k + 1, randNatureBlockID(world.rand));
        world.setBlock(i - 1, j + 1, k + 2, randNatureBlockID(world.rand));
        world.setBlock(i + 0, j + 1, k + 2, randNatureBlockID(world.rand));
        world.setBlock(i + 1, j + 1, k + 2, randNatureBlockID(world.rand));
        world.setBlock(i + 2, j + 1, k + 2, randNatureBlockID(world.rand));
        world.editingBlocks = false;
    }

    public int randNatureBlockID(Random random)
    {
        int ai[] = {
            Block.mushroomBrown.blockID, Block.mushroomRed.blockID, Block.tallGrass.blockID, Block.plantRed.blockID, Block.plantYellow.blockID
        };
        return ai[random.nextInt(ai.length)];
    }
	
}
