// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, IBlockAccess, 
//            World

public class MC_1BlockFence extends Block
{


	public MC_1BlockFence(int i, int j)
    {
        super(i, j , Material.wood);    	
    }
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k);
    }

    public boolean isFenceAt(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockId(i, j, k);
        if(l == blockID || l == Block.fenceGate.blockID)
        {
            return true;
        }
        Block block = Block.blocksList[l];
        if(block != null && block.blockMaterial.getIsOpaque() && block.renderAsNormalBlock())
        {
            return block.blockMaterial != Material.pumpkin;
        } else
        {
            return false;
        }
    }
    
    public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
        switch (metadata){
        case 0: return MC_0Textures.bLogSide1;
        case 1: return MC_0Textures.bLogSide2;
        case 2: return MC_0Textures.bLogSide3;
        //etc. etc.
        }
		return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
}

}
