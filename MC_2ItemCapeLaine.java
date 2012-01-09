// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MFAPISimpleItem, ItemStack

public class MC_2ItemCapeLaine extends Item
{

    public static int id = 2800;
    public static int texture_mf_id = 96;
    public static int Icone[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15
    };
    public static String name[] = {
        "Cape en laine orange", "Cape en laine blanche", "Cape en laine rouge", "Cape en laine noire", "Cape en laine verte fonc\351e", "Cape en laine brune", "Cape en laine bleue fonc\351e", "Cape en laine violette", "Cape en laine turquoise", "Cape en laine grise claire", 
        "Cape en laine grise fonc\351e", "Cape en laine rose", "Cape en laine verte claire", "Cape en laine jaune", "Cape en laine bleue claire", "Cape en laine magenta"
    };

    protected MC_2ItemCapeLaine()
    {
        super(id);
        setMaxStackSize(1);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return name[itemstack.getItemDamage()];
    }

    public int getIconFromDamage(int i)
    {
        return Icone[i] + 256 + 96;
    }

}
