package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_ItemAetherCloudParachute extends Item{
	public MMC_ItemAetherCloudParachute(int i)
    {
        super(i);
        setIconIndex(tex);
        maxStackSize = 1;
        setMaxDamage(i != MMC_ID.idItemAetherCloudParachuteGold ? 0 : 20);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(MMC_EntityCloudParachute.entityHasRoomForCloud(world, entityplayer))
        {
            for(int i = 0; i < 32; i++)
            {
                MMC_EntityCloudParachute.doCloudSmoke(world, entityplayer);
            }

            if(shiftedIndex == MMC_Item.ItemAetherCloudParachuteGold.shiftedIndex)
            {
                itemstack.damageItem(1, entityplayer);
            } else
            {
                itemstack.stackSize--;
            }
            world.playSoundAtEntity(entityplayer, "cloud", 1.0F, 1.0F / (itemRand.nextFloat() * 0.1F + 0.95F));
            if(!world.multiplayerWorld)
            {
                world.entityJoinedWorld(new MMC_EntityCloudParachute(world, entityplayer, shiftedIndex == MMC_Item.ItemAetherCloudParachuteGold.shiftedIndex));
            }
        }
        return itemstack;
    }

    public int getColorFromDamage(int i)
    {
        return shiftedIndex != MMC_Item.ItemAetherCloudParachuteGold.shiftedIndex ? 0xffffff : 0xffff7f;
    }

    private static int tex = MMC_Textures.TexItemAetherCloudParachute;

}
