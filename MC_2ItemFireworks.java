// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack

public class MC_2ItemFireworks extends ItemBlock
{

    public MC_2ItemFireworks(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
        setItemName("Feu d'artifice");
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append("Feu d'artifice : Type ").append(itemstack.getItemDamage()).toString();
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

}
