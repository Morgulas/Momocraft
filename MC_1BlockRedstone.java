
package net.minecraft.src;
import java.util.Random;

public class MC_1BlockRedstone extends Block
{
   private static final int BlockAllumeTexture = MC_0Textures.bRedstone1;
   private static final int BlockEteintTexture = MC_0Textures.bRedstone0;

   public MC_1BlockRedstone(int id)
   { 
      super(id, 0, Material.rock);
   }
   
   public int idDropped(int i, Random random)
   {
        return MC_0Block.BlockRedStone0.blockID;
   }
   
   public int getBlockTextureFromSide(int i)
   {
          if(blockID == MC_0Block.BlockRedStone1.blockID)
          {
               return BlockAllumeTexture;
          }
           else
          {
               return BlockEteintTexture;
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
        return world.getBlockId(i, j, k) == MC_0Block.BlockRedStone1.blockID;
    }
   
   
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k);
        if(flag)
        {
      
            if(!IsBlockPowered(world, i, j, k))
            {
                
            world.setBlockWithNotify(i, j, k, MC_0Block.BlockRedStone1.blockID);
                 return;
            
            }
         
        } 
        else if(IsBlockPowered(world, i, j, k))  
       {
            
            world.setBlockWithNotify(i, j, k, MC_0Block.BlockRedStone0.blockID);
            return;
         
        }
    }
   
    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        if(world.isBlockIndirectlyGettingPowered(i, j, k))
        {  
        	
	        double d = 0.0625D;
	        int l = world.getBlockMetadata(i, j, k);
	        double d1 = (float)i + random.nextFloat();
	        double d2 = (float)j + random.nextFloat();
	        double d3 = (float)k + random.nextFloat();
	        if(l == 0 && !world.isBlockOpaqueCube(i, j + 1, k))
	        {
	            d2 = (double)(j + 1) + d;
	        }
	        if(l == 1 && !world.isBlockOpaqueCube(i, j - 1, k))
	        {
	            d2 = (double)(j + 0) - d;
	        }
	        if(l == 2 && !world.isBlockOpaqueCube(i, j, k + 1))
	        {
	            d3 = (double)(k + 1) + d;
	        }
	        if(l == 3 && !world.isBlockOpaqueCube(i, j, k - 1))
	        {
	            d3 = (double)(k + 0) - d;
	        }
	        if(l == 4 && !world.isBlockOpaqueCube(i + 1, j, k))
	        {
	            d1 = (double)(i + 1) + d;
	        }
	        if(l == 5 && !world.isBlockOpaqueCube(i - 1, j, k))
	        {
	            d1 = (double)(i + 0) - d;
	        }
	        if(d1 < (double)i || d1 > (double)(i + 1) || d2 < 0.0D || d2 > (double)(j + 1) || d3 < (double)k || d3 > (double)(k + 1))
	        {
	            world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
	            
	        }
        }
    }
}
