package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherLoreBook extends Item {

	public MMC_ItemAetherLoreBook(int i)
    {
        super(i);
        maxStackSize = 1;
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    public int getColorFromDamage(int i)
    {
        if(i == 0)
        {
            return 0x7fff7f;
        }
        return i != 1 ? 0x7f7fff : 0xff7f7f;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
//        ModLoader.OpenGUI(entityplayer, new GuiLore(entityplayer.inventory, itemstack.getItemDamage()));
        return itemstack;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        return (new StringBuilder()).append(super.getItemName()).append(".").append(i).toString();
    }

}
