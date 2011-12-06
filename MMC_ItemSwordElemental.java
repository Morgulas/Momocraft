package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.src.*;

public class MMC_ItemSwordElemental extends ItemSword{
	public MMC_ItemSwordElemental(int i, MMC_EnumElement enumelement, int j)
    {
        super(i, EnumToolMaterial.EMERALD);
        setIconIndex(MMC_Textures.TexItemAetherElementalSword);
        maxStackSize = 1;
        setMaxDamage(enumelement != MMC_EnumElement.Holy ? 32 : 128);
        weaponDamage = 4;
        holyDamage = 20;
        element = enumelement;
        colour = j;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return 1.5F;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if(element == MMC_EnumElement.Fire)
        {
            //entityliving.fire = 600;
        } else
        if(element == MMC_EnumElement.Lightning)
        {
            //ModLoader.getMinecraftInstance().theWorld.entityJoinedWorld(new EntityAetherLightning(ModLoader.getMinecraftInstance().theWorld, (int)entityliving.posX, (int)entityliving.posY, (int)entityliving.posZ));
        }
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
label0:
        {
            if(element != MMC_EnumElement.Holy || !(entity instanceof EntityLiving))
            {
                break label0;
            }
            EntityLiving entityliving = (EntityLiving)entity;
            Iterator iterator = undead.iterator();
            Class class1;
            do
            {
                if(!iterator.hasNext())
                {
                    break label0;
                }
                class1 = (Class)iterator.next();
            } while(!entityliving.getClass().isAssignableFrom(class1));
            return holyDamage;
        }
        return weaponDamage;
    }

    public int getColorFromDamage(int i)
    {
        return colour;
    }

    public boolean isFull3D()
    {
        return true;
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public static ArrayList undead;
    private int weaponDamage;
    private int holyDamage;
    private MMC_EnumElement element;
    private int colour;

    static 
    {
        undead = new ArrayList();
        undead.add(net.minecraft.src.EntityZombie.class);
        undead.add(net.minecraft.src.EntitySkeleton.class);
        undead.add(net.minecraft.src.EntityPigZombie.class);
    }
}
