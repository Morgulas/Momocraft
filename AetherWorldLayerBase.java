package net.minecraft.src;

import net.minecraft.src.*;

public class AetherWorldLayerBase extends GenLayer{

    public AetherWorldLayerBase(long l)
    {
        super(l);
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = IntCache.getIntCache(k * l);
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < k; j1++)
            {
                func_35499_a(i + j1, j + i1);
                ai[j1 + i1 * k] = 1;
            }

        }

        if(i > -k && i <= 0 && j > -l && j <= 0)
        {
            ai[-i + -j * k] = 1;
        }
        return ai;
    }
}
