package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_EntityAetherPortalFX extends EntityPortalFX {
	
    public MMC_EntityAetherPortalFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        float f = rand.nextFloat() * 0.6F + 0.4F;
        particleRed = particleGreen = particleBlue = 1.0F * f;
        particleRed *= 0.2F;
        particleGreen *= 0.2F;
    }
}
