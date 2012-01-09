// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashMap;

// Referenced classes of package net.minecraft.src:
//            MFAPISimpleItem, World, EntityPlayer, MFParametre, 
//            AxisAlignedBB, ItemStack, ItemList

public class MC_2ItemPotion extends Item
{
    public int id;
    public int texture_mf_id;
    public float param[] = {
        1.5F, 2.0F, 0.5F, 0.3F
    };

    public MC_2ItemPotion(int i)
    {
        super(i);
        texture_mf_id = 0;
        setMaxStackSize(1);
        id = i;
        texture_mf_id = (i - 2768) + 32 + 256 + 3;
    }

//    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
//    {
//    	super.onItemRightClick(itemstack, world, entityplayer);
//        entityplayer.resetHeight();
//        entityplayer.boundingBox.maxY = entityplayer.boundingBox.minY + (double)entityplayer.yOffset;
//        entityplayer.setSize(0.6F, entityplayer.yOffset);
//        System.out.print("Clic droit");
//        entityplayer.setEntityDead();
//        entityplayer.boundingBox.maxY = 5.0f;
//        super.onItemRightClick(itemstack, world, entityplayer);
//        if(!world.multiplayerWorld)
//        {
//            MFParametre mfparametre = (MFParametre)entityplayer.mf_parametre.get(Integer.valueOf(3));
//            if(mfparametre != null)
//            {
//                if(mfparametre.param_float != param[id - 2768])
//                {
//                    entityplayer.mf_parametre.remove(Integer.valueOf(3));
//                    entityplayer.mf_parametre.put(Integer.valueOf(3), new MFParametre(3, param[id - 2768], 0x493e0));
//                    entityplayer.resetHeight();
//                    entityplayer.boundingBox.maxY = entityplayer.boundingBox.minY + (double)entityplayer.yOffset;
//                    entityplayer.setSize(0.6F, entityplayer.yOffset);
//                } else
//                {
//                    mfparametre.timer += 0x493e0;
//                }
//            } else
//            {
//                entityplayer.mf_parametre.put(Integer.valueOf(3), new MFParametre(3, param[id - 2768], 0x493e0));
//                entityplayer.resetHeight();
//                entityplayer.boundingBox.maxY = entityplayer.boundingBox.minY + (double)entityplayer.yOffset;
//                entityplayer.setSize(0.6F, entityplayer.yOffset);
//            }
//        }
//        return new ItemStack(ItemList.itemfiole);
//        }
//		return itemstack;
//		return new ItemStack (MC_0Item.ItemPotion) ;
//    }
}
