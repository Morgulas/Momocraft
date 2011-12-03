package net.minecraft.src.Momocraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.src.*;

public class BlockAetherLeaves extends BlockLeavesBase {
	public BlockAetherLeaves(int i)
    {
        super(i, i != MomocraftID.idBlockAetherGoldenOakLeaves ? sprSkyroot : sprGoldenOak, Material.leaves, false);
        setTickOnLoad(true);
    }

    public int quantityDropped(Random random)
    {
        if(blockID == MomocraftBlocks.BlockAetherGoldenOakLeaves.blockID)
        {
            return random.nextInt(60) == 0 ? 1 : 0;
        } else
        {
            return random.nextInt(40) == 0 ? 1 : 0;
        }
    }

    public int idDropped(int i, Random random)
    {
        if(blockID == MomocraftBlocks.BlockAetherSkyrootLeaves.blockID)
        {
            return MomocraftBlocks.BlockAetherSkyrootSapling.blockID;
        }
        if(random.nextInt(10) == 0)
        {
            return Item.appleGold.shiftedIndex;
        } else
        {
            return MomocraftBlocks.BlockAetherGoldenOakSapling.blockID;
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if(i2 == blockID)
                        {
                            int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
                            world.setBlockMetadata(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        if(!nearTrunk(world, i, j, k))
        {
            removeLeaves(world, i, j, k);
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), k);
        world.setBlockWithNotify(i, j, k, 0);
    }

    private boolean nearTrunk(World world, int i, int j, int k)
    {
		return graphicsLevel;}
/*ShockAPI        Loc loc = new Loc(i, j, k);
        LinkedList linkedlist = new LinkedList();
        ArrayList arraylist = new ArrayList();
        linkedlist.offer(new Loc(i, j, k));
        int l = blockID;
        do
        {
            if(linkedlist.isEmpty())
            {
                break;
            }
            Loc loc1 = (Loc)linkedlist.poll();
            if(!arraylist.contains(loc1))
            {
                if(loc1.distSimple(loc) <= 4)
                {
                    int i1 = loc1.getBlock(world);
                    int j1 = loc1.getMeta(world);
                    if(i1 == MomocraftBlocks.Log.blockID && isMyTrunkMeta(j1))
                    {
                       return true;
                    }
                    if(i1 == l)
                    {
                        linkedlist.addAll(Arrays.asList(loc1.adjacent()));
                    }
                }
                arraylist.add(loc1);
            }
        } while(true);
        return false;
    }
*/
    private boolean isMyTrunkMeta(int i)
    {
        if(blockID == MomocraftBlocks.BlockAetherSkyrootLeaves.blockID)
        {
            return i <= 1;
        } else
        {
            return i >= 2;
        }
    }

    protected int damageDropped(int i)
    {
        return i & 3;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.multiplayerWorld && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(blockID, 1, l & 3));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        return true;
    }

    public static int sprSkyroot = MomocraftTextures.TexBlockAetherSkyrootLeaves;
    public static int sprGoldenOak = MomocraftTextures.TexBlockAetherGoldenOakLeaves;

}
