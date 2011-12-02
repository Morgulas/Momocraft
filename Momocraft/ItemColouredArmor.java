package net.minecraft.src.Momocraft;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import java.util.*;

public class ItemColouredArmor extends ItemArmor {

    public ItemColouredArmor(int i, EnumArmorMaterial j, int k, int l, int i1)
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
