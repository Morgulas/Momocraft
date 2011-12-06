package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_ItemAetherSwordHolystone extends ItemSword{
	
    public MMC_ItemAetherSwordHolystone(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if((new Random()).nextInt(25) == 0 && entityliving1 != null && (entityliving1 instanceof EntityPlayer) && (entityliving.hurtTime > 0 || entityliving.deathTime > 0))
        {
            entityliving.dropItemWithOffset(MMC_Item.ItemAetherAmbrosiumShard.shiftedIndex, 1, 0.0F);
            itemstack.damageItem(1, entityliving1);
        }
        itemstack.damageItem(1, entityliving1);
        return true;
    }
}
