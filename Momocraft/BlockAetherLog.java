package net.minecraft.src.Momocraft;

import java.util.Random;
import net.minecraft.src.*;

public class BlockAetherLog extends Block{
	
	public BlockAetherLog(int i)
    {
        super(i, sprSide, Material.wood);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i <= 1 && j <= 3)
        {
            return sprTop;
        }
        if(j <= 1)
        {
            return sprSide;
        } else
        {
            return sprGoldenSide;
        }
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, 0);
        if(mod_Momocraft.equippedSkyrootAxe() && l != 1)
        {
            itemstack.stackSize *= 2;
        }
//A completer quand mise a jour de shockAPI         SAPI.drop(world, new Loc(i, j, k), itemstack);
        ItemStack itemstack2 = entityplayer.inventory.getCurrentItem();
        if(itemstack2 == null || itemstack2.itemID != MomocraftItems.ItemAetherAxeZanite.shiftedIndex && itemstack2.itemID != MomocraftItems.ItemAetherAxeGravitite.shiftedIndex && l >= 2)
        {
            return;
        }
        if(l > 1 && rand.nextBoolean())
        {
            ItemStack itemstack1 = new ItemStack(MomocraftItems.ItemAetherGoldenAmber.shiftedIndex, 2 + rand.nextInt(2), 0);
//A completer quand mise a jour de shockAPI            SAPI.drop(world, new Loc(i, j, k), itemstack1);
        }
    }

    public static int sprTop = MomocraftTextures.TexBlockAetherSkyrootLogTop;
    public static int sprSide = MomocraftTextures.TexBlockAetherSkyrootLogSide;
    public static int sprGoldenSide = MomocraftTextures.TexBlockAetherGoldenOak;
    private static Random rand = new Random();

}
