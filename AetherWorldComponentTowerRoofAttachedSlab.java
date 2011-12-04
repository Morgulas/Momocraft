package net.minecraft.src;

import java.util.Random;

public class AetherWorldComponentTowerRoofAttachedSlab extends AetherWorldComponentTowerRoofSlab{

    public AetherWorldComponentTowerRoofAttachedSlab(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        return makeConnectedCap(world, structureboundingbox);
    }
}
