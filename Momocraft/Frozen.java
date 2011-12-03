package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class Frozen {
	
    public Frozen(ItemStack itemstack, ItemStack itemstack1, int i)
    {
        frozenFrom = itemstack;
        frozenTo = itemstack1;
        frozenPowerNeeded = i;
    }

    public ItemStack frozenFrom;
    public ItemStack frozenTo;
    public int frozenPowerNeeded;
}
