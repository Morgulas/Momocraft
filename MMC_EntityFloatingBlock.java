// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

import net.minecraft.src.*;


// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, World, Block, 
//            BlockPistonMoving, BlockSand, NBTTagCompound

public class MMC_EntityFloatingBlock extends Entity
{

    public MMC_EntityFloatingBlock(World world)
    {
        super(world);
        flytime = 0;
    }

    public MMC_EntityFloatingBlock(World world, double d, double d1, double d2, 
            int i, int j)
    {
        super(world);
        flytime = 0;
        blockID = i;
        metadata = j;
        preventEntitySpawning = true;
        setSize(0.98F, 0.98F);
        yOffset = height / 2.0F;
        setPosition(d, d1, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
    }

    public MMC_EntityFloatingBlock(World world, double d, double d1, double d2, 
            int i)
    {
        this(world, d, d1, d2, i, 0);
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void entityInit()
    {
    }

    public boolean canBeCollidedWith()
    {
        return !isDead;
    }

    public void onUpdate()
    {
        if(blockID == 0)
        {
            setEntityDead();
            return;
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        flytime++;
        motionY += 0.040000000000000001D;
        moveEntity(motionX, motionY, motionZ);
        motionX *= 0.98000001907348633D;
        motionY *= 0.98000001907348633D;
        motionZ *= 0.98000001907348633D;
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int k = MathHelper.floor_double(posZ);
        if(worldObj.getBlockId(i, j, k) == blockID || worldObj.getBlockId(i, j, k) == MMC_Block.BlockAetherGrass.blockID && blockID == MMC_Block.BlockAetherGrass.blockID)
        {
            worldObj.setBlockWithNotify(i, j, k, 0);
        }
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(0.0D, 1.0D, 0.0D));
        for(int l = 0; l < list.size(); l++)
        {
            if((list.get(l) instanceof EntityFallingSand) && worldObj.canBlockBePlacedAt(blockID, i, j, k, true, 1))
            {
                worldObj.setBlockAndMetadataWithNotify(i, j, k, blockID, metadata);
                setEntityDead();
            }
        }

        if(isCollidedVertically && !onGround)
        {
            motionX *= 0.69999998807907104D;
            motionZ *= 0.69999998807907104D;
            motionY *= -0.5D;
            setEntityDead();
            if(worldObj.canBlockBePlacedAt(blockID, i, j, k, true, 1) && !MMC_BlockFloating.canFallAbove(worldObj, i, j + 1, k) && worldObj.setBlockAndMetadataWithNotify(i, j, k, blockID, metadata) || worldObj.multiplayerWorld);
        } else
        if(flytime > 100 && !worldObj.multiplayerWorld)
        {
            setEntityDead();
        }
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setByte("Tile", (byte)blockID);
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        blockID = nbttagcompound.getByte("Tile") & 0xff;
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    public World getWorld()
    {
        return worldObj;
    }

    public int blockID;
    public int metadata;
    public int flytime;
}
