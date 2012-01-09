// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, FireworksParticle, MFAPI, 
//            EffectRenderer, Tessellator

public class MC_FireworksSubrocket extends EntityFX
{

    double red;
    double green;
    double blue;
    double redT;
    double greenT;
    double blueT;
    int maxAgeParticles;
    boolean emitParticles;
    float particleSize;
    double gravity;
    private float field_672_a;
    boolean carrySound;

    public MC_FireworksSubrocket(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, double d6, double d7, double d8, double d9, 
            double d10, double d11, int i, int j, float f, 
            boolean flag, double d12, boolean flag1)
    {
        super(world, d, d1, d2, d3, d4, d5);
        field_672_a = 0.9F;
        setSize(1.0F, 1.0F);
        noClip = false;
        particleMaxAge = i;
        maxAgeParticles = j;
        particleSize = f;
        gravity = d12;
        motionX = d3;
        motionY = d4;
        motionZ = d5;
        carrySound = flag1;
        red = d6;
        green = d7;
        blue = d8;
        redT = d9;
        greenT = d10;
        blueT = d11;
        emitParticles = flag;
        particleRed = (float)red;
        particleGreen = (float)green;
        particleBlue = (float)blue;
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
            if(!emitParticles)
            {
                spawnParticles(posX, posY, posZ);
                if(carrySound)
                {
                    float f = (float)(8D + Math.random() * 3D);
                    float f1 = (float)(0.5D + Math.random());
                    worldObj.playSoundAtEntity(this, "fireworks.cracks", f, f1);
                }
            }
            setEntityDead();
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        moveEntity(motionX, motionY, motionZ);
        if(emitParticles)
        {
            spawnSparksOnPath();
        }
        particleAge++;
        motionY -= gravity;
        motionX *= 0.98499999999999999D;
        motionZ *= 0.98499999999999999D;
        if(onGround)
        {
            motionY *= -0.69999999999999996D;
            motionX *= 0.69999999999999996D;
            motionZ *= 0.69999999999999996D;
        }
        if(inWater)
        {
            setEntityDead();
        }
    }

    private void spawnSparksOnPath()
    {
        double d = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        int i = (int)(1.0D + d * 5D);
        double d1 = prevPosX;
        double d2 = prevPosY;
        double d3 = prevPosZ;
        double d4 = (posX - prevPosX) / (double)i;
        double d5 = (posY - prevPosY) / (double)i;
        double d6 = (posZ - prevPosZ) / (double)i;
        for(int j = 0; j < i; j++)
        {
            d1 += d4;
            d2 += d5;
            d3 += d6;
            spawnParticles(d1, d2, d3);
        }

    }

    private void spawnParticles(double d, double d1, double d2)
    {
        int i = (int)((double)maxAgeParticles + (Math.random() - 0.5D) * (double)(maxAgeParticles / 10));
        MC_FireworksParticle fireworksparticle = new MC_FireworksParticle(worldObj, d, d1, d2, red, green, blue, redT, greenT, blueT, i, particleSize);
        fireworksparticle.renderDistanceWeight = 10D;
        ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksparticle);
    }
}
