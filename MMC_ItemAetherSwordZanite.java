package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherSwordZanite extends ItemSword{

    public MMC_ItemAetherSwordZanite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((2.0F * (float)itemstack.getItemDamage()) / (float)itemstack.getItem().getMaxDamage() + 0.5F);
    }
}
