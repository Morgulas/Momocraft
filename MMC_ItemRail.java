// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.src.*;


// Referenced classes of package net.minecraft.src:
//            Item, World, TileEntityPlaque, mod_Plaques, 
//            ItemStack, TileEntity, EntityPlayer

public class MMC_ItemRail extends Item
{

    public MMC_ItemRail(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        TileEntity tileentity = world.getBlockTileEntity(i, j, k);
        if(tileentity != null && (tileentity instanceof MMC_TileEntityPlaque))
        {
            MMC_TileEntityPlaque tileentityplaque = (MMC_TileEntityPlaque)tileentity;
            if(tileentityplaque.angle == -1 && l != tileentityplaque.orientation && l != mod_Momocraft.Inverse(tileentityplaque.orientation))
            {
                tileentityplaque.rotation = mod_Momocraft.Inverse(l);
                tileentityplaque.angle = 180;
                itemstack.stackSize--;
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }
}
