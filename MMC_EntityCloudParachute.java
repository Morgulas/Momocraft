package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class MMC_EntityCloudParachute extends Entity {
	
	public MMC_EntityCloudParachute(World world, EntityPlayer entityplayer, boolean b)
    {
        super(world);
        justServerSpawned = false;
        setSize(1.0F, 1.0F);
    }

    public MMC_EntityCloudParachute(World world, double d, double d1, double d2)
    {
        this(world, null, gold);
        setPositionAndRotation(d, d1, d2, rotationYaw, rotationPitch);
        justServerSpawned = true;
    }



	/*    public EntityCloudParachute(World world, EntityLiving entityliving, boolean flag)
    {
        this(world);
        if(entityliving == null)
        {
            throw new IllegalArgumentException("entityliving cannot be null.");
        } else
        {
            entityUsing = entityliving;
            cloudMap.put(entityliving, this);
            prevPosX = posX;
            prevPosY = posY;
            prevPosZ = posZ;
            moveToEntityUsing();
            gold = flag;
            return;
        }
    }
*/
    public static MMC_EntityCloudParachute getCloudBelongingToEntity(EntityLiving entityliving)
    {
        return (MMC_EntityCloudParachute)cloudMap.get(entityliving);
    }

    public World getWorld()
    {
        return worldObj;
    }

/*    public void die()
    {
        if(entityUsing != null)
        {
            if(cloudMap.containsKey(entityUsing))
            {
                cloudMap.remove(entityUsing);
            }
            for(int i = 0; i < 32; i++)
            {
                doCloudSmoke(worldObj, entityUsing);
            }

            worldObj.playSoundAtEntity(entityUsing, "cloud", 1.0F, 1.0F / (rand.nextFloat() * 0.1F + 0.95F));
        }
        entityUsing = null;
        isDead = true;
    }
*/
/*    public static void doCloudSmoke(World world, EntityLiving entityliving)
    {
        double d = (entityliving.posX + entityliving.rand.nextDouble() * 0.75D * 2D) - 0.75D;
        double d1 = ((entityliving.boundingBox.minY - 0.5D) + entityliving.rand.nextDouble() * 0.75D * 2D) - 0.75D;
        double d2 = (entityliving.posZ + entityliving.rand.nextDouble() * 0.75D * 2D) - 0.75D;
        ModLoader.getMinecraftInstance().effectRenderer.addEffect(new EntityCloudSmokeFX(world, d, d1, d2, 0.0D, 0.0D, 0.0D, 2.5F, 1.0F, 1.0F, 1.0F));
    }
*/
    public static boolean entityHasRoomForCloud(World world, EntityLiving entityliving)
    {
        AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(entityliving.posX - 0.5D, entityliving.boundingBox.minY - 1.0D, entityliving.posZ - 0.5D, entityliving.posX + 0.5D, entityliving.boundingBox.minY, entityliving.posZ + 0.5D);
        return world.getCollidingBoundingBoxes(entityliving, axisalignedbb).size() == 0 && !world.isAABBInMaterial(axisalignedbb, Material.water);
    }

    protected void entityInit()
    {
    }

    public boolean isInRangeToRenderDist(double d)
    {
        if(entityUsing != null)
        {
            return entityUsing.isInRangeToRenderDist(d);
        } else
        {
            return super.isInRangeToRenderDist(d);
        }
    }

    public boolean canBeCollidedWith()
    {
        return true;
    }

    public AxisAlignedBB getBoundingBox()
    {
        return boundingBox;
    }

/*    public void onUpdate()
    {
        if(isDead)
        {
            return;
        }
        if(entityUsing == null)
        {
            if(worldObj.multiplayerWorld && !justServerSpawned)
            {
                die();
                return;
            }
            justServerSpawned = false;
            entityUsing = findUser();
            if(entityUsing != null)
            {
                cloudMap.put(entityUsing, this);
            } else
            {
                die();
                return;
            }
        }
        if(entityUsing.motionY < -0.25D)
        {
            entityUsing.motionY = -0.25D;
        }
        entityUsing.fallDistance = 0.0F;
        doCloudSmoke(worldObj, entityUsing);
        moveToEntityUsing();
    }
*/
    private EntityLiving findUser()
    {
        List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityLiving.class, boundingBox.copy().offset(0.0D, 1.0D, 0.0D));
        double d = -1D;
        EntityLiving entityliving = null;
        for(int i = 0; i < list.size(); i++)
        {
            EntityLiving entityliving1 = (EntityLiving)list.get(i);
            if(!entityliving1.isEntityAlive())
            {
                continue;
            }
            double d1 = posX - entityliving1.posX;
            double d2 = boundingBox.maxY - entityliving1.boundingBox.minY;
            double d3 = posZ - entityliving1.posZ;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;
            if(d == -1D || d4 < d)
            {
                d = d4;
                entityliving = entityliving1;
            }
        }

        return entityliving;
    }

/*    private void moveToEntityUsing()
    {
        setPositionAndRotation(entityUsing.posX, entityUsing.boundingBox.minY - (double)(height / 2.0F), entityUsing.posZ, entityUsing.rotationYaw, entityUsing.rotationPitch);
        motionX = entityUsing.motionX;
        motionY = entityUsing.motionY;
        motionZ = entityUsing.motionZ;
        rotationYaw = entityUsing.rotationYaw;
        if(isCollided())
        {
            die();
        }
    }
*/
    private boolean isCollided()
    {
        return worldObj.getCollidingBoundingBoxes(this, boundingBox).size() > 0 || worldObj.isAABBInMaterial(boundingBox, Material.water);
    }

    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    private EntityLiving entityUsing;
    private boolean justServerSpawned;
    private static Map cloudMap = new HashMap();
    private static final float MAX_FALL_SPEED = 0.25F;
    private static final double ANIM_RADIUS = 0.75D;
    public static boolean gold;
	public static void doCloudSmoke(World world, EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		
	}


}
