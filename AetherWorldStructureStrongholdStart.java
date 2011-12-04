package net.minecraft.src;

import java.io.*;
import java.util.*;


import net.minecraft.src.*;

public class AetherWorldStructureStrongholdStart extends StructureStart {

	public AetherWorldStructureStrongholdStart(World world, Random random, int i, int j)
    {
        StructureStrongholdPieces.prepareStructurePieces();
        ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(0, random, (i << 4) + 2, (j << 4) + 2);
        componentstrongholdstairs2.getBoundingBox().offset(0, -28, 0);
        System.out.println((new StringBuilder()).append("Made a stronghold at ").append(componentstrongholdstairs2.getBoundingBox().minX).append(", ").append(componentstrongholdstairs2.getBoundingBox().minY).append(", ").append(componentstrongholdstairs2.getBoundingBox().minZ).toString());
        components.add(componentstrongholdstairs2);
        componentstrongholdstairs2.buildComponent(componentstrongholdstairs2, components, random);
        StructureComponent structurecomponent;
        for(ArrayList arraylist = componentstrongholdstairs2.field_35037_b; !arraylist.isEmpty(); structurecomponent.buildComponent(componentstrongholdstairs2, components, random))
        {
            int k = random.nextInt(arraylist.size());
            structurecomponent = (StructureComponent)arraylist.remove(k);
        }

        updateBoundingBox();
        markAvailableHeight(world, random, 1);
    }

    protected void markAvailableHeight(World world, Random random, int i)
    {
        world.getClass();
        int j = 35 - i;
        int k = boundingBox.getYSize() + 1;
        if(k < j)
        {
            k += random.nextInt(j - k);
        }
        int l = k - boundingBox.maxY;
        boundingBox.offset(0, l, 0);
        StructureComponent structurecomponent;
        for(Iterator iterator = components.iterator(); iterator.hasNext(); structurecomponent.getBoundingBox().offset(0, l, 0))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }
}
