// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, FireworksSubrocket, MFAPI, 
//            EffectRenderer, FireworksSplitrocket, FireworksParticle, Tessellator

public class MC_FireworksRocket extends EntityFX
{

    double red;
    double green;
    double blue;
    double redT;
    double greenT;
    double blueT;
    int maxAgeParticles;
    int maxAgeSubrockets;
    int numberOfSubrockets;
    double explosionStrength;
    float particleSize;
    boolean emitParticles;
    double gravity;
    double colorRange;
    private float field_672_a;
    int type;

    public MC_FireworksRocket(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, int i, 
            double d6, double d7, double d8, double d9, double d10, double d11, double d12, 
            int j, int k, int l, int i1, float f, boolean flag, double d13, double d14)
    {
        super(world, d, d1, d2, d3, d4, d5);
        renderDistanceWeight = 10D;
        field_672_a = 0.9F;
        setSize(1.0F, 1.0F);
        noClip = false;
        particleMaxAge = k;
        maxAgeParticles = i1;
        maxAgeSubrockets = l;
        numberOfSubrockets = j;
        gravity = d14;
        explosionStrength = d13;
        particleSize = f;
        emitParticles = flag;
        type = i;
        red = d6;
        green = d7;
        blue = d8;
        redT = d9;
        greenT = d10;
        blueT = d11;
        colorRange = d12;
        particleRed = (float)red;
        particleGreen = (float)green;
        particleBlue = (float)blue;
        setParticleTextureIndex((int)(4D + Math.random() * 4D));
        noClip = false;
        motionY = 0.5D;
    }

    public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)particleAge + f) / (float)particleMaxAge;
        particleScale = 1.0F;
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
            explode();
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
        spawnSparksOnPath();
        if(type == 0)
        {
            motionX *= 1.05D;
            motionZ *= 1.05D;
            motionX += (Math.random() - 0.5D) / 10D;
            motionZ += (Math.random() - 0.5D) / 10D;
            if(motionY < 2.2000000000000002D)
            {
                motionY *= 1.2D;
            }
        } else
        if(type == 1)
        {
            if(motionY < 1.2D)
            {
                motionY *= 1.1000000000000001D;
            }
            motionX = 0.5D * Math.sin(particleAge);
            motionZ = 0.5D * Math.cos(particleAge);
        } else
        if(type == -1)
        {
            if(motionY < 1.2D)
            {
                motionY *= 1.1000000000000001D;
            }
            motionX = 0.5D * Math.cos(particleAge + 180);
            motionZ = 0.5D * Math.sin(particleAge + 180);
        } else
        {
            motionX *= 1.05D;
            motionZ *= 1.05D;
            motionX += (Math.random() - 0.5D) / 10D;
            motionZ += (Math.random() - 0.5D) / 10D;
            if(motionY < 2.2000000000000002D)
            {
                motionY *= 1.2D;
            }
        }
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

    private void explode()
    {
        float f = (float)(8D + Math.random() * 3D);
        float f1 = (float)(0.5D + Math.random());
        boolean flag = false;
        worldObj.playSoundAtEntity(this, "fireworks.bang", f, f1);
        if(type < 2)
        {
            for(int i = 0; i < numberOfSubrockets; i++)
            {
                int i1 = (int)(Math.random() * 360D);
                int i2 = (int)(Math.random() * 360D);
                double d1 = explosionStrength * Math.sin(i1) * Math.sin(i2);
                double d5 = explosionStrength * Math.sin(i1) * Math.cos(i2);
                double d10 = explosionStrength * Math.cos(i1);
                double d15 = red + colorRange * (Math.random() - 0.5D);
                double d20 = green + colorRange * (Math.random() - 0.5D);
                double d25 = blue + colorRange * (Math.random() - 0.5D);
                double d30 = redT + colorRange * (Math.random() - 0.5D);
                double d35 = greenT + colorRange * (Math.random() - 0.5D);
                double d40 = blueT + colorRange * (Math.random() - 0.5D);
                int l3 = (int)((double)maxAgeSubrockets + (double)(maxAgeSubrockets / 10) * (Math.random() - 0.5D));
                MC_FireworksSubrocket fireworkssubrocket2 = new MC_FireworksSubrocket(worldObj, posX, posY, posZ, d1, d5, d10, d15, d20, d25, d30, d35, d40, l3, maxAgeParticles, particleSize, emitParticles, gravity, flag);
                fireworkssubrocket2.renderDistanceWeight = 10D;
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssubrocket2);
            }

        } else
        if(type == 2)
        {
            byte byte0 = 3;
            int j1 = (int)((double)maxAgeSubrockets / 1.5D);
            for(int j2 = 0; j2 < numberOfSubrockets; j2++)
            {
                int i3 = (int)(Math.random() * 360D);
                int j3 = (int)(Math.random() * 360D);
                double d6 = explosionStrength * Math.sin(i3) * Math.sin(j3);
                double d11 = explosionStrength * Math.sin(i3) * Math.cos(j3);
                double d16 = explosionStrength * Math.cos(i3);
                double d21 = red + colorRange * (Math.random() - 0.5D);
                double d26 = green + colorRange * (Math.random() - 0.5D);
                double d31 = blue + colorRange * (Math.random() - 0.5D);
                double d36 = redT + colorRange * (Math.random() - 0.5D);
                double d41 = greenT + colorRange * (Math.random() - 0.5D);
                double d44 = blueT + colorRange * (Math.random() - 0.5D);
                int k4 = (int)((double)maxAgeSubrockets + (double)(maxAgeSubrockets / 10) * (Math.random() - 0.5D));
                MC_FireworksSplitrocket fireworkssplitrocket = new MC_FireworksSplitrocket(worldObj, posX, posY, posZ, d6, d11, d16, d36, d41, d44, d21, d26, d31, j1, maxAgeParticles, particleSize, emitParticles, gravity, byte0);
                fireworkssplitrocket.renderDistanceWeight = 10D;
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssplitrocket);
            }

        } else
        if(type == 3)
        {
            for(int j = 0; j < numberOfSubrockets; j++)
            {
                int k1 = (int)(Math.random() * 360D);
                int k2 = (int)(Math.random() * 360D);
                double d2 = explosionStrength * Math.sin(k1) * Math.sin(k2);
                double d7 = 0.5D + Math.abs(explosionStrength * Math.sin(k1) * Math.cos(k2));
                double d12 = explosionStrength * Math.cos(k1);
                double d17 = red + colorRange * (Math.random() - 0.5D);
                double d22 = green + colorRange * (Math.random() - 0.5D);
                double d27 = blue + colorRange * (Math.random() - 0.5D);
                double d32 = redT + colorRange * (Math.random() - 0.5D);
                double d37 = greenT + colorRange * (Math.random() - 0.5D);
                double d42 = blueT + colorRange * (Math.random() - 0.5D);
                int i4 = (int)((double)maxAgeSubrockets + (double)(maxAgeSubrockets / 10) * (Math.random() - 0.5D));
                MC_FireworksSubrocket fireworkssubrocket3 = new MC_FireworksSubrocket(worldObj, posX, posY, posZ, d2, d7, d12, d17, d22, d27, d32, d37, d42, i4, maxAgeParticles, particleSize, emitParticles, gravity, flag);
                fireworkssubrocket3.renderDistanceWeight = 10D;
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssubrocket3);
            }

        } else
        if(type == 4)
        {
            for(int k = 0; k < numberOfSubrockets; k++)
            {
                double d = explosionStrength * (Math.random() - 0.5D);
                double d3 = explosionStrength * (Math.random() - 0.5D);
                double d8 = explosionStrength * (Math.random() - 0.5D);
                double d13 = red + colorRange * (Math.random() - 0.5D);
                double d18 = green + colorRange * (Math.random() - 0.5D);
                double d23 = blue + colorRange * (Math.random() - 0.5D);
                double d28 = redT + colorRange * (Math.random() - 0.5D);
                double d33 = greenT + colorRange * (Math.random() - 0.5D);
                double d38 = blueT + colorRange * (Math.random() - 0.5D);
                int k3 = (int)((double)maxAgeSubrockets + (double)(maxAgeSubrockets / 10) * (Math.random() - 0.5D));
                MC_FireworksSubrocket fireworkssubrocket1 = new MC_FireworksSubrocket(worldObj, posX, posY, posZ, d, d3, d8, d13, d18, d23, d28, d33, d38, k3, maxAgeParticles, particleSize, emitParticles, gravity, flag);
                fireworkssubrocket1.renderDistanceWeight = 10D;
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssubrocket1);
            }

        } else
        if(type == 5)
        {
            for(int l = 0; l < numberOfSubrockets; l++)
            {
                int l1 = (int)(Math.random() * 360D);
                int l2 = (int)(Math.random() * 360D);
                double d4 = explosionStrength * Math.sin(l1);
                double d9 = (Math.random() - 0.5D) / 100D;
                double d14 = explosionStrength * Math.cos(l1);
                double d19 = red + colorRange * (Math.random() - 0.5D);
                double d24 = green + colorRange * (Math.random() - 0.5D);
                double d29 = blue + colorRange * (Math.random() - 0.5D);
                double d34 = redT + colorRange * (Math.random() - 0.5D);
                double d39 = greenT + colorRange * (Math.random() - 0.5D);
                double d43 = blueT + colorRange * (Math.random() - 0.5D);
                int j4 = (int)((double)maxAgeSubrockets + (double)(maxAgeSubrockets / 10) * (Math.random() - 0.5D));
                MC_FireworksSubrocket fireworkssubrocket4 = new MC_FireworksSubrocket(worldObj, posX, posY, posZ, d4, d9, d14, d19, d24, d29, d34, d39, d43, j4, maxAgeParticles, particleSize, emitParticles, gravity, flag);
                fireworkssubrocket4.renderDistanceWeight = 10D;
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssubrocket4);
            }

        }
        if(!emitParticles)
        {
            MC_FireworksSubrocket fireworkssubrocket = new MC_FireworksSubrocket(worldObj, posX, posY, posZ, 0.0D, 0.0D, 0.0D, red, green, blue, redT, greenT, blueT, maxAgeSubrockets, maxAgeParticles, 0.0F, emitParticles, gravity, true);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworkssubrocket);
        }
    }

    private void spawnSparksOnPath()
    {
        double d = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        int i = (int)(d * 5D);
        double d1 = prevPosX;
        double d2 = prevPosY;
        double d3 = prevPosZ;
        double d4 = (posX - prevPosX) / (double)i;
        double d5 = (posY - prevPosY) / (double)i;
        double d6 = (posZ - prevPosZ) / (double)i;
        for(int j = 0; j < i - 1; j++)
        {
            d1 += d4;
            d2 += d5;
            d3 += d6;
            spawnParticles(d1, d2, d3);
        }

    }

    private void spawnParticles(double d, double d1, double d2)
    {
        int i = (int)((double)(maxAgeParticles / 2) + (Math.random() - 0.5D) * (double)(maxAgeParticles / 10));
        float f = particleSize / 2.0F;
        MC_FireworksParticle fireworksparticle = new MC_FireworksParticle(worldObj, d, d1, d2, red, green, blue, redT, greenT, blueT, i, f);
        fireworksparticle.renderDistanceWeight = 10D;
        ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksparticle);
    }
}
