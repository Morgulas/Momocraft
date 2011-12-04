package net.minecraft.src;

import java.io.File;

public class AetherWorld extends World{
    public AetherWorld(World world, WorldProvider worldprovider)
    {
        super(world, worldprovider);
        chunkProvider = getChunkProvider();
    }

    protected IChunkProvider getChunkProvider()
    {
        File file = ((SaveHandler)saveHandler).getSaveDirectory();
        Object obj = null;
        if(saveHandler instanceof SaveOldDir)
        {
            File file1 = new File(file, "DIM7");
            file1.mkdirs();
            obj = new ThreadedChunkLoader(file1);
        } else
        if(saveHandler instanceof SaveHandler)
        {
            File file2 = new File(file, "DIM7");
            file2.mkdirs();
            obj = new ChunkLoader(file2, true);
        }
        return new ChunkProvider(this, ((IChunkLoader) (obj)), worldProvider.getChunkProvider());
    }

    public int getFirstUncoveredBlock(int i, int j)
    {
        int k;
        for(k = 30; !isAirBlock(i, k + 1, j); k++) { }
        return getBlockId(i, k, j);
    }

    public void setSpawnLocation()
    {
    }

    public int calculateSkylightSubtracted(float f)
    {
        float f1 = 0.5F;
        f1 = (float)((double)f1 * (1.0D - (double)(getRainStrength(f) * 5F) / 16D));
        f1 = (float)((double)f1 * (1.0D - (double)(getWeightedThunderStrength(f) * 5F) / 16D));
        f1 = 1.0F - f1;
        return (int)(f1 * 11F);
    }

    public float func_35464_b(float f)
    {
        float f1 = 0.2F;
        f1 = (float)((double)f1 * (1.0D - (double)(getRainStrength(f) * 5F) / 16D));
        f1 = (float)((double)f1 * (1.0D - (double)(getWeightedThunderStrength(f) * 5F) / 16D));
        return f1 * 0.8F + 0.2F;
    }

    public Vec3D getSkyColor(Entity entity, float f)
    {
        float f1 = 0.25F;
        float f2 = MathHelper.cos(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posZ);
        int k = getWorldChunkManager().getBiomeGenAt(i, j).getSkyColorByTemp(0.5F);
        float f3 = (float)(k >> 16 & 0xff) / 255F;
        float f4 = (float)(k >> 8 & 0xff) / 255F;
        float f5 = (float)(k & 0xff) / 255F;
        f3 *= f2;
        f4 *= f2;
        f5 *= f2;
        float f6 = getRainStrength(f);
        if(f6 > 0.0F)
        {
            float f7 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
            float f9 = 1.0F - f6 * 0.75F;
            f3 = f3 * f9 + f7 * (1.0F - f9);
            f4 = f4 * f9 + f7 * (1.0F - f9);
            f5 = f5 * f9 + f7 * (1.0F - f9);
        }
        float f8 = getWeightedThunderStrength(f);
        if(f8 > 0.0F)
        {
            float f10 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
            float f12 = 1.0F - f8 * 0.75F;
            f3 = f3 * f12 + f10 * (1.0F - f12);
            f4 = f4 * f12 + f10 * (1.0F - f12);
            f5 = f5 * f12 + f10 * (1.0F - f12);
        }
        if(lightningFlash > 0)
        {
            float f11 = (float)lightningFlash - f;
            if(f11 > 1.0F)
            {
                f11 = 1.0F;
            }
            f11 *= 0.45F;
            f3 = f3 * (1.0F - f11) + 0.8F * f11;
            f4 = f4 * (1.0F - f11) + 0.8F * f11;
            f5 = f5 * (1.0F - f11) + 1.0F * f11;
        }
        return Vec3D.createVector(f3, f4, f5);
    }

    public float getStarBrightness(float f)
    {
        return 0.5F;
    }
}
