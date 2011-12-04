package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldComponentTowerRoof extends AetherWorldStructureComponent{

    int size;
    int height;

    public AetherWorldComponentTowerRoof(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i);
    }

    protected void makeAttachedOverhangBB(AetherWorldComponentTowerWing componenttftowerwing)
    {
        switch(coordBaseMode)
        {
        case 0: // '\0'
            boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ - 1, componenttftowerwing.boundingBox.maxX + 1, (componenttftowerwing.boundingBox.maxY + height) - 1, componenttftowerwing.boundingBox.maxZ + 1);
            break;

        case 1: // '\001'
            boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX - 1, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ, componenttftowerwing.boundingBox.maxX + 1, (componenttftowerwing.boundingBox.maxY + height) - 1, componenttftowerwing.boundingBox.maxZ + 1);
            break;

        case 2: // '\002'
            boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX - 1, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ - 1, componenttftowerwing.boundingBox.maxX, (componenttftowerwing.boundingBox.maxY + height) - 1, componenttftowerwing.boundingBox.maxZ + 1);
            break;

        case 3: // '\003'
            boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX - 1, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ - 1, componenttftowerwing.boundingBox.maxX + 1, (componenttftowerwing.boundingBox.maxY + height) - 1, componenttftowerwing.boundingBox.maxZ);
            break;
        }
    }

    protected void makeCapBB(AetherWorldComponentTowerWing componenttftowerwing)
    {
        boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ, componenttftowerwing.boundingBox.maxX, componenttftowerwing.boundingBox.maxY + height, componenttftowerwing.boundingBox.maxZ);
    }

    protected void makeOverhangBB(AetherWorldComponentTowerWing componenttftowerwing)
    {
        boundingBox = new StructureBoundingBox(componenttftowerwing.boundingBox.minX - 1, componenttftowerwing.boundingBox.maxY, componenttftowerwing.boundingBox.minZ - 1, componenttftowerwing.boundingBox.maxX + 1, (componenttftowerwing.boundingBox.maxY + height) - 1, componenttftowerwing.boundingBox.maxZ + 1);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        return false;
    }

    public boolean fits(AetherWorldComponentTowerWing componenttftowerwing, List list, Random random)
    {
    	AetherWorldComponentTowerRoof _tmp = this;
        return getIntersectingStructureComponent(list, boundingBox) == componenttftowerwing;
    }
	
}
