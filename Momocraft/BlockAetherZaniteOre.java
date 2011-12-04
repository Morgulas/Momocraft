package net.minecraft.src.Momocraft;

import java.util.Random;
import net.minecraft.src.*;

public class BlockAetherZaniteOre extends Block{
	
    public BlockAetherZaniteOre(int i)
    {
        super(i, MomocraftTextures.TexBlockAetherZaniteOre, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MomocraftItems.ItemAetherZanite.shiftedIndex;
    }
    
}
