package net.minecraft.src;

import java.util.Random;

public class MC_1BlockSup extends Block{
	
	private boolean blockType;
	private Object block;

    public MC_1BlockSup(int i)
    {
        super(i, Material.cloth);
        setRequiresSelfNotify();
        setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public boolean isOpaqueCube()
    {
        return blockType;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
    }

    public int idDropped(int i, Random random, int j)
    {
        return Block.stairSingle.blockID;
    }

    public int quantityDropped(Random random)
    {
        return !blockType ? 1 : 2;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public boolean renderAsNormalBlock()
    {
        return blockType;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(this != Block.stairSingle)
        {
            super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
        if(l == 1)
        {
            return true;
        }
        if(!super.shouldSideBeRendered(iblockaccess, i, j, k, l))
        {
            return false;
        }
        if(l == 0)
        {
            return true;
        } else
        {
            return iblockaccess.getBlockId(i, j, k) != blockID;
        }
    }

    public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
        switch (metadata){
        case 0: return 5;
        case 1: return Block.sandStone.blockIndexInTexture;
        case 2: return Block.planks.blockIndexInTexture;
        case 3: return 16;
        case 4: return Block.brick.blockIndexInTexture;
        case 5: return Block.stoneBrick.blockIndexInTexture;
        case 6: return Block.stone.blockIndexInTexture;
        case 7: return Block.wood.blockIndexInTexture;
        case 8: return MC_0Textures.bPaille;
        case 9: return MC_0Textures.bArdoise;
        //etc. etc.
        }
		return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
}
    
    protected ItemStack func_41049_c_(int i)
    {
        return new ItemStack(Block.stairSingle.blockID, 1, i);
    }

}
