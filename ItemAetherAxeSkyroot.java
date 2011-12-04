package net.minecraft.src;

import net.minecraft.src.*;
import java.util.Random;


public class ItemAetherAxeSkyroot extends ItemTool {
	
    protected ItemAetherAxeSkyroot(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
    }


    public boolean canHarvestBlock(Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i].blockID == block.blockID)
            {
                return true;
            }
        }

        return false;
    }


    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MomocraftBlocks.BlockAetherPlank, MomocraftBlocks.BlockAetherLog
        });
    }
}

