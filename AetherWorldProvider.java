package net.minecraft.src;

import net.minecraft.src.*;

public class AetherWorldProvider extends WorldProvider{
	
	public AetherWorldProvider()
    {
    }

    public float[] calcSunriseSunsetColors(float f, float f1)
    {
        return super.calcSunriseSunsetColors(f, f1);
    }

    public Vec3D getFogColor(float f, float f1)
    {
        float f2 = MathHelper.cos(1.570796F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = 0.7529412F;
        float f4 = 1.0F;
        float f5 = 0.8470588F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3D.createVector(f3, f4, f5);
    }

    public void registerWorldChunkManager()
    {
        worldChunkMgr = new AetherWorldChunkManager(worldObj);
        worldType = 7;
    }

    public IChunkProvider getChunkProvider()
    {
        return new AetherWorldChunkProvider(worldObj, worldObj.getWorldSeed(), worldObj.getWorldInfo().isMapFeaturesEnabled());
    }

    public boolean func_28112_c()
    {
        return false;
    }

    public boolean canCoordinateBeSpawn(int i, int j)
    {
        int k = worldObj.getFirstUncoveredBlock(i, j);
        if(k == 0)
        {
            return false;
        } else
        {
            return Block.blocksList[k].blockMaterial.getIsSolid();
        }
    }
}
