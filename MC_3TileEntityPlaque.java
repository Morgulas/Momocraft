package net.minecraft.src;

public class MC_3TileEntityPlaque extends TileEntity{
	
    public int orientation;
    public int rotation;
    public int angle;
    public boolean ouvert;

    public MC_3TileEntityPlaque()
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
