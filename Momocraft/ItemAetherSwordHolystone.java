package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class ItemAetherSwordHolystone extends ItemSword{
	
    public ItemAetherSwordHolystone(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if((new Random()).nextInt(25) == 0 && entityliving1 != null && (entityliving1 instanceof EntityPlayer) && (entityliving.hurtTime > 0 || entityliving.deathTime > 0))
        {
            entityliving.dropItemWithOffset(MomocraftItems.ItemAetherAmbrosiumShard.shiftedIndex, 1, 0.0F);
            itemstack.damageItem(1, entityliving1);
        }
        itemstack.damageItem(1, entityliving1);
        return true;
    }
}
