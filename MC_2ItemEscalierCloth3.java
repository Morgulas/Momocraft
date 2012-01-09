// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack

public class MC_2ItemEscalierCloth3 extends ItemBlock
{

    private int data_dmg[] = {
        12, 7, 8, 9
    };
    private String data_color[] = {
        "marron", "gris", "gris clair", "cyan"
    };

    public MC_2ItemEscalierCloth3(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        i = data_dmg[i / 4];
        if(i == 0)
        {
            return 64;
        } else
        {
            return 113 + ((i & 8) >> 3) + (i & 7) * 16;
        }
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append("Escalier en tissu ").append(data_color[itemstack.getItemDamage() / 4]).toString();
    }
}
