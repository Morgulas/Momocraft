package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldComponentTowerOutbuilding extends AetherWorldComponentTowerWing{
	
	 protected AetherWorldComponentTowerOutbuilding(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        super(i, j, k, l, i1, j1, k1);
	    }

	    public void makeABeard(StructureComponent structurecomponent, List list, Random random)
	    {
	    }

	    public boolean makeTowerWing(List list, Random random, int i, int j, int k, int l, int i1, 
	            int j1, int k1)
	    {
	        if(k > 7)
	        {
	            return super.makeTowerWing(list, random, i, j, k, l, i1, j1, k1);
	        } else
	        {
	            return false;
	        }
	    }
}
