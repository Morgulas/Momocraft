// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.src.*;


// Referenced classes of package net.minecraft.src:
//            TileEntity, NBTTagCompound

public class MMC_TileEntityPlaque extends TileEntity
{

    public int orientation;
    public int rotation;
    public int angle;
    public boolean ouvert;

    public MMC_TileEntityPlaque()
    {
        orientation = -1;
        rotation = -1;
        angle = -1;
        ouvert = true;
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("orientation", orientation);
        nbttagcompound.setInteger("rotation", rotation);
        nbttagcompound.setInteger("angle", angle);
        nbttagcompound.setBoolean("ouvert", ouvert);
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        orientation = nbttagcompound.getInteger("orientation");
        rotation = nbttagcompound.getInteger("rotation");
        angle = nbttagcompound.getInteger("angle");
        ouvert = nbttagcompound.getBoolean("ouvert");
    }
}
