package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherSwordGravitite extends ItemSword{
	
    public MMC_ItemAetherSwordGravitite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if(entityliving1 != null && (entityliving1 instanceof EntityPlayer) && (entityliving.hurtTime > 0 || entityliving.deathTime > 0))
        {
            entityliving.motionY++;
            itemstack.damageItem(1, entityliving1);
        }
        return true;
    }
}
