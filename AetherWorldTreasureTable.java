package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldTreasureTable {

	  protected ArrayList list;

	    public AetherWorldTreasureTable()
	    {
	        list = new ArrayList();
	    }

	    public void add(Item item, int i)
	    {
	        add(item, i, 10);
	    }

	    public void add(Item item, int i, int j)
	    {
	        list.add(new AetherWorldTreasureItem(item, i, j));
	    }

	    public void add(Block block, int i)
	    {
	        add(block, i, 10);
	    }

	    public void add(Block block, int i, int j)
	    {
	        list.add(new AetherWorldTreasureItem(block, i, j));
	    }

	    protected int total()
	    {
	        int i = 0;
	        for(Iterator iterator = list.iterator(); iterator.hasNext();)
	        {
	        	AetherWorldTreasureItem tftreasureitem = (AetherWorldTreasureItem)iterator.next();
	            i += tftreasureitem.getRarity();
	        }

	        return i;
	    }

	    public ItemStack getRandomItem(Random random)
	    {
	        int i = random.nextInt(total());
	        for(Iterator iterator = list.iterator(); iterator.hasNext();)
	        {
	        	AetherWorldTreasureItem tftreasureitem = (AetherWorldTreasureItem)iterator.next();
	            if(tftreasureitem.getRarity() > i)
	            {
	                return tftreasureitem.getItemStack(random);
	            }
	            i -= tftreasureitem.getRarity();
	        }

	        return null;
	    }
}
