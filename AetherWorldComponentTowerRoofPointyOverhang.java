package net.minecraft.src;

public class AetherWorldComponentTowerRoofPointyOverhang extends AetherWorldComponentTowerRoofPointy{
	
    public AetherWorldComponentTowerRoofPointyOverhang(int i, AetherWorldComponentTowerWing componenttftowerwing)
    {
        super(i, componenttftowerwing);
        coordBaseMode = componenttftowerwing.coordBaseMode;
        size = componenttftowerwing.size + 2;
        height = size;
        makeOverhangBB(componenttftowerwing);
    }
}
