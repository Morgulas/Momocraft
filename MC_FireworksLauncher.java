// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, FireworksSkyrocketManager, TileEntityDispenser, 
//            World, FireworksRocket, MFAPI, EffectRenderer, 
//            TileEntity, EntityPlayer

public class MC_FireworksLauncher extends BlockContainer
{

    int topTexture;
    int sideTexture;
    double xMotion;
    double yMotion;
    double zMotion;
    double motionRandom;
    double red;
    double green;
    double blue;
    double redRandom;
    double greenRandom;
    double blueRandom;
    double redTarget;
    double greenTarget;
    double blueTarget;
    double redTRandom;
    double greenTRandom;
    double blueTRandom;
    double cRange;
    int numberOfSubrockets;
    int ageRocket;
    int ageSubrocket;
    int ageParticles;
    double ageRandom;
    float particleSize;
    boolean emitParticles;
    double explosionStrength;
    double strengthRandom;
    double gravity;
    int type;
    String allSettings[][];

    public MC_FireworksLauncher(int i, int j, int k, MC_FireworksSkyrocketManager fireworksskyrocketmanager)
    {
        super(i, k, Material.rock);
        topTexture = j;
        sideTexture = k;
        allSettings = fireworksskyrocketmanager.allSettings;
        setHardness(0.8F);
    }

    public int damageDropped(int i)
    {
        return i;
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return topTexture;
        } else
        {
            return sideTexture;
        }
    }

    public int tickRate()
    {
        return 4;
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntityDispenser();
    }

    public void powerBlock(World world, int i, int j, int k, int l, int i1)
    {
        launchRocket(world, i, j, k);
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        } else
        {
            launchRocket(world, i, j, k);
            return true;
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        updatePistonState(world, i, j, k);
    }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
        explode(world, i, j, k);
    }

    private void updateSettings(int i)
    {
        xMotion = Double.valueOf(allSettings[i][0]).doubleValue();
        yMotion = Double.valueOf(allSettings[i][1]).doubleValue();
        zMotion = Double.valueOf(allSettings[i][2]).doubleValue();
        red = Double.valueOf(allSettings[i][3]).doubleValue();
        green = Double.valueOf(allSettings[i][4]).doubleValue();
        blue = Double.valueOf(allSettings[i][5]).doubleValue();
        redTarget = Double.valueOf(allSettings[i][6]).doubleValue();
        greenTarget = Double.valueOf(allSettings[i][7]).doubleValue();
        blueTarget = Double.valueOf(allSettings[i][8]).doubleValue();
        cRange = Double.valueOf(allSettings[i][9]).doubleValue();
        numberOfSubrockets = Integer.valueOf(allSettings[i][10]).intValue();
        ageRocket = Integer.valueOf(allSettings[i][11]).intValue();
        ageSubrocket = Integer.valueOf(allSettings[i][12]).intValue();
        ageParticles = Integer.valueOf(allSettings[i][13]).intValue();
        particleSize = Float.valueOf(allSettings[i][14]).floatValue();
        emitParticles = Boolean.valueOf(allSettings[i][15]).booleanValue();
        explosionStrength = Double.valueOf(allSettings[i][16]).doubleValue();
        gravity = Double.valueOf(allSettings[i][17]).doubleValue();
        type = Integer.valueOf(allSettings[i][18]).intValue();
        motionRandom = Double.valueOf(allSettings[i][19]).doubleValue();
        redRandom = Double.valueOf(allSettings[i][20]).doubleValue();
        greenRandom = Double.valueOf(allSettings[i][21]).doubleValue();
        blueRandom = Double.valueOf(allSettings[i][22]).doubleValue();
        redTRandom = Double.valueOf(allSettings[i][23]).doubleValue();
        greenTRandom = Double.valueOf(allSettings[i][24]).doubleValue();
        blueTRandom = Double.valueOf(allSettings[i][25]).doubleValue();
        ageRandom = Double.valueOf(allSettings[i][26]).doubleValue();
        strengthRandom = Double.valueOf(allSettings[i][27]).doubleValue();
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        updatePistonState(world, i, j, k);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        updatePistonState(world, i, j, k);
    }

    private void updatePistonState(World world, int i, int j, int k)
    {
        System.out.println("Check redstone");
        int l = world.getBlockMetadata(i, j, k);
        boolean flag = isIndirectlyPowered(world, i, j, k, l);
        if(flag)
        {
            System.out.println("Launch");
            launchRocket(world, i, j, k);
        }
    }

    private boolean isIndirectlyPowered(World world, int i, int j, int k, int l)
    {
        if(world.isBlockIndirectlyProvidingPowerTo(i, j - 1, k, 0))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j + 1, k, 1))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j, k - 1, 2))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j, k + 1, 3))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i + 1, j, k, 5))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i - 1, j, k, 4))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j, k, 0))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j + 2, k, 1))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j + 1, k - 1, 2))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i, j + 1, k + 1, 3))
        {
            return true;
        }
        if(world.isBlockIndirectlyProvidingPowerTo(i - 1, j + 1, k, 4))
        {
            return true;
        } else
        {
            return world.isBlockIndirectlyProvidingPowerTo(i + 1, j + 1, k, 5);
        }
    }

    private void launchRocket(World world, int i, int j, int k)
    {
        if(Math.random() < 9.9999999999999995E-007D)
        {
            explode(world, i, j, k);
            return;
        }
        double d = (double)i + 0.5D;
        double d1 = (double)j + 0.80000000000000004D;
        double d2 = (double)k + 0.5D;
        for(int l = 0; l < 5; l++)
        {
            double d3 = (Math.random() - 0.5D) / 10D;
            double d5 = Math.random() / 20D;
            double d7 = (Math.random() - 0.5D) / 10D;
            world.spawnParticle("smoke", d, d1, d2, d3, d5, d7);
        }

        world.spawnParticle("lava", d, d1, d2, 0.0D, 0.0D, 0.0D);
        int i1 = world.getBlockMetadata(i, j, k);
        updateSettings(i1);
        double d4 = xMotion + Math.random() * motionRandom;
        double d6 = yMotion + Math.random() * motionRandom * 2D;
        double d8 = zMotion + Math.random() * motionRandom;
        double d9 = red + Math.random() * redRandom;
        double d10 = green + Math.random() * greenRandom;
        double d11 = blue + Math.random() * blueRandom;
        double d12 = redTarget + Math.random() * redTRandom;
        double d13 = greenTarget + Math.random() * greenTRandom;
        double d14 = blueTarget + Math.random() * blueTRandom;
        int j1 = ageRocket + (int)(Math.random() * ageRandom);
        int k1 = ageSubrocket + (int)(Math.random() * ageRandom);
        int l1 = ageParticles + (int)(Math.random() * ageRandom);
        double d15 = explosionStrength + Math.random() * strengthRandom;
        MC_FireworksRocket fireworksrocket;
        if(type == 0)
        {
            fireworksrocket = new MC_FireworksRocket(world, d, d1, d2, d4, d6, d8, type, d9, d10, d11, d12, d13, d14, cRange, numberOfSubrockets, j1, k1, l1, particleSize, emitParticles, d15, gravity);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksrocket);
        } else
        if(type == 1)
        {
            fireworksrocket = new MC_FireworksRocket(world, d, d1, d2, d4, d6, d8, type, d9, d10, d11, d12, d13, d14, cRange, numberOfSubrockets, j1, k1, l1, particleSize, emitParticles, d15, gravity);
            MC_FireworksRocket fireworksrocket1 = new MC_FireworksRocket(world, d, d1, d2, d4, d6, d8, -1, d12, d13, d14, d9, d10, d11, cRange, numberOfSubrockets * 5, j1, k1, l1, particleSize * 2.0F, false, d15, gravity);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksrocket);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksrocket1);
        } else
        {
            fireworksrocket = new MC_FireworksRocket(world, d, d1, d2, d4, d6, d8, type, d9, d10, d11, d12, d13, d14, cRange, numberOfSubrockets, j1, k1, l1, particleSize, emitParticles, d15, gravity);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksrocket);
        }
        float f = (float)(0.5D + Math.random());
        float f1 = (float)(0.59999999999999998D + Math.random());
        world.playSoundAtEntity(fireworksrocket, "fireworks.launch", f, f1);
    }

    private void explode(World world, int i, int j, int k)
    {
        for(int l = 0; l < 5; l++)
        {
            double d = Math.random() - 0.5D;
            double d1 = Math.random() - 0.5D;
            double d2 = Math.random() / 2D;
            double d3 = Math.random();
            double d4 = Math.random();
            double d5 = Math.random();
            double d6 = Math.random();
            double d7 = Math.random();
            double d8 = Math.random();
            int i1 = 0;
            int j1 = 6 + (int)(Math.random() * 10D);
            int k1 = 20 + (int)(Math.random() * 10D);
            double d9 = 2D + Math.random() * 2D;
            MC_FireworksRocket fireworksrocket = new MC_FireworksRocket(world, (double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, d, d1, d2, 0, d6, d7, d8, d3, d4, d5, cRange, 200, i1, j1, k1, 1.7F, false, d9 / 4D, 0.01D);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireworksrocket);
        }

        world.createExplosion(null, (double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, 3F);
    }
}
