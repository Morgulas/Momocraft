package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherAmbrosiumShard extends Item {

	public MMC_ItemAetherAmbrosiumShard(int i, int j)
    {
        super(i);
        healAmount = j;
        maxStackSize = 64;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.stackSize--;
        entityplayer.heal(healAmount);
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }

    private int healAmount;
}
