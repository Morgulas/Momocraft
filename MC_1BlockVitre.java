// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;


// Referenced classes of package net.minecraft.src:
//            BlockPane, Material

public class MC_1BlockVitre extends BlockPane
{

    private static int j;

	protected MC_1BlockVitre(int i, int k, Material material, boolean flag)
    {
        super(i, MC_0Textures.bVerreGrisClair, k, material, flag);
        setTickOnLoad(true);
        setHardness(0.5F);
    }
    
    public int getRenderType()
    {
        return 73;
    }
    
    public int getRenderBlockPass()
    {
        return 1;
    }

    public int idDropped(int metadata, Random random) 
    {
        return blockID;
    }

	protected int damageDropped(int metadata) 
	{
	        return metadata;
	}
	
  public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
	  
	  switch (metadata)
	  {
		  case 0: return MC_0Textures.bVerreOrange;
		  case 1: return MC_0Textures.bVerreBlanc;
		  case 2: return MC_0Textures.bVerreRouge;
		  case 3: return MC_0Textures.bVerreNoir;
		  case 4: return MC_0Textures.bVerreVertfonce;
		  case 5: return MC_0Textures.bVerreBrun;
		  case 6: return MC_0Textures.bVerreBleufonce;
		  case 7: return MC_0Textures.bVerreViolet;
		  case 8: return MC_0Textures.bVerreBleuClair;
		  case 9: return MC_0Textures.bVerreGrisClair;
		  case 10: return MC_0Textures.bVerreGrisFonce;
		  case 11: return MC_0Textures.bVerreRose;
		  case 12: return MC_0Textures.bVerreVertClair;
		  case 13: return MC_0Textures.bVerreJaune;
		  case 14: return MC_0Textures.bVerreTurquoise;
		  case 15: return MC_0Textures.bVerreMagenta;
	  }
		return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
}

}
