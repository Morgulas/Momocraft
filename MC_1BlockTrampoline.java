package net.minecraft.src;

public class MC_1BlockTrampoline  extends Block{

	protected MC_1BlockTrampoline(int i, int j, Material material) {
		
		super(i, j, material);
	}
	
	//Rendu World
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return MC_0Textures.bTrampolineTop;
        }
        if(l == 0)
        {
            return MC_0Textures.bTrampolineBottom;
        }
        else
        {
            return MC_0Textures.bTrampolineSide;
        }
    }

    //Rendu Inventaire
    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return MC_0Textures.bTrampolineTop;
        }
        if(i == 0)
        {
            return MC_0Textures.bTrampolineBottom;
        }
        if(i == 3)
        {
            return MC_0Textures.bTrampolineSide;
        } else
        {
            return MC_0Textures.bTrampolineSide;
        }
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
      entity.motionY += 1.0;
    }
}
