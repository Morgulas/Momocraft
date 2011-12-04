package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class AetherWorldTreasureItem {
	
	 int itemID;
	    int itemDamage;
	    int quantity;
	    int rarity;

	    public AetherWorldTreasureItem(Item item)
	    {
	        this(item, 1, 10);
	    }

	    public AetherWorldTreasureItem(Item item, int i)
	    {
	        this(item, i, 10);
	    }

	    public AetherWorldTreasureItem(Item item, int i, int j)
	    {
	        itemID = item.shiftedIndex;
	        itemDamage = 0;
	        quantity = i;
	        rarity = j;
	    }

	    public AetherWorldTreasureItem(Block block, int i, int j)
	    {
	        itemID = block.blockID;
	        itemDamage = 0;
	        quantity = i;
	        rarity = j;
	    }

	    public AetherWorldTreasureItem(ItemStack itemstack, int i)
	    {
	        itemID = itemstack.itemID;
	        itemDamage = itemstack.getItemDamage();
	        quantity = itemstack.stackSize;
	        rarity = i;
	    }

	    public ItemStack getItemStack(Random random)
	    {
	        return new ItemStack(itemID, random.nextInt(quantity) + 1, itemDamage);
	    }

	    public int getRarity()
	    {
	        return rarity;
	    }
}
