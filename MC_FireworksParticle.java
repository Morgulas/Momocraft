// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class MC_FireworksParticle extends EntityFX
{

    double redDiff;
    double greenDiff;
    double blueDiff;
    private float field_672_a;

    public MC_FireworksParticle(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, double d6, double d7, double d8, int i, float f)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        super.particleGravity = -1F;
        field_672_a = f + (float)((Math.random() - 0.5D) / 100D);
        setSize(1.0F, 1.0F);
        noClip = true;
        particleMaxAge = i;
        motionX = Math.random() / 100D;
        motionY = Math.random() / 100D;
        motionZ = Math.random() / 100D;
        particleRed = (float)d3;
        particleGreen = (float)d4;
        particleBlue = (float)d5;
        redDiff = (d6 - d3) / (double)i;
        greenDiff = (d7 - d4) / (double)i;
        blueDiff = (d8 - d5) / (double)i;
        setParticleTextureIndex((int)(4D + Math.random() * 4D));
    }

    public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)particleAge + f) / (float)particleMaxAge;
        particleScale = field_672_a * (1.0F - f6 * f6 * 0.5F);
        super.renderParticle(tessellator, f, f1, f2, f3, f4, f5);
    }

    public float getEntityBrightness(float f)
    {
        return 1.0F;
    }

    public void onUpdate()
    {
        if(particleAge >= particleMaxAge)
        {
            setEntityDead();
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        moveEntity(motionX, motionY, motionZ);
        particleAge++;
        particleRed += redDiff;
        particleGreen += greenDiff;
        particleBlue += blueDiff;
        if(inWater)
        {
            setEntityDead();
        }
    }
}
