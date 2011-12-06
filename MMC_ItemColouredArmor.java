package net.minecraft.src;

import java.util.*;

public class MMC_ItemColouredArmor extends ItemArmor {

    public MMC_ItemColouredArmor(int i, EnumArmorMaterial j, int k, int l, int i1)
    {
        super(i, j, k, l);
        colour = i1;
    }
    public int getColorFromDamage(int i)
    {
        return colour;
    }

    private int colour;
}
