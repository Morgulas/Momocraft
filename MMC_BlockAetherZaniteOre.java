package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.*;

public class MMC_BlockAetherZaniteOre extends Block{
	
    public MMC_BlockAetherZaniteOre(int i)
    {
        super(i, MMC_Textures.TexBlockAetherZaniteOre, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MMC_Item.ItemAetherZanite.shiftedIndex;
    }
    
}
