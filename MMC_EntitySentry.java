package net.minecraft.src;
/*
import net.minecraft.src.*;

public class EntitySentry extends EntityDungeonMob{
	
	public EntitySentry(World world)
    {
        super(world);
        texture = "/aether/mobs/Sentry.png";
        size = 2;
        yOffset = 0.0F;
        moveSpeed = 1.0F;
        field_100021_a = 1.0F;
        field_100020_b = 1.0F;
        jcount = rand.nextInt(20) + 10;
        func_100019_e(size);
    }

    public EntitySentry(World world, double d, double d1, double d2)
    {
        super(world);
        texture = "/aether/mobs/Sentry.png";
        size = 2;
        yOffset = 0.0F;
        moveSpeed = 1.0F;
        field_100021_a = 1.0F;
        field_100020_b = 1.0F;
        jcount = rand.nextInt(20) + 10;
        func_100019_e(size);
        rotationYaw = (float)rand.nextInt(4) * 1.570796F;
        setPosition(d, d1, d2);
    }

    public void func_100019_e(int i)
    {
        health = 10;
        width = 0.85F;
        height = 0.85F;
        setPosition(posX, posY, posZ);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Size", size - 1);
        nbttagcompound.setInteger("LostYou", lostyou);
        nbttagcompound.setInteger("Counter", counter);
        nbttagcompound.setBoolean("Active", active);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        size = nbttagcompound.getInteger("Size") + 1;
        lostyou = nbttagcompound.getInteger("LostYou");
        counter = nbttagcompound.getInteger("Counter");
        active = nbttagcompound.getBoolean("Active");
    }

    public void onUpdate()
    {
        boolean flag = onGround;
        super.onUpdate();
        if(onGround && !flag)
        {
            worldObj.playSoundAtEntity(this, "mob.slime", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
        } else
        if(!onGround && flag && playerToAttack != null)
        {
            motionX *= 3D;
            motionZ *= 3D;
        }
        if(playerToAttack != null && playerToAttack.isDead)
        {
            playerToAttack = null;
        }
    }

    public void setEntityDead()
    {
        if(health <= 0 || isDead)
        {
            super.setEntityDead();
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag && (entity instanceof EntityLiving))
        {
            active = true;
            lostyou = 0;
            playerToAttack = entity;
            texture = "/aether/mobs/SentryLit.png";
        }
        return flag;
    }

    public void shutdown()
    {
        counter = -64;
        active = false;
        playerToAttack = null;
        texture = "/aether/mobs/Sentry.png";
        setPathToEntity(null);
        moveStrafing = 0.0F;
        moveForward = 0.0F;
        isJumping = false;
        motionX = 0.0D;
        motionZ = 0.0D;
    }

    public void applyEntityCollision(Entity entity)
    {
        if(!isDead && playerToAttack != null && entity != null && playerToAttack == entity)
        {
            worldObj.createExplosion(this, posX, posY, posZ, 0.1F);
            entity.attackEntityFrom(null, 2);
            if(entity instanceof EntityLiving)
            {
                EntityLiving entityliving = (EntityLiving)entity;
                double d = entityliving.posX - posX;
                double d2;
                for(d2 = entityliving.posZ - posZ; d * d + d2 * d2 < 0.0001D; d2 = (Math.random() - Math.random()) * 0.01D)
                {
                    d = (Math.random() - Math.random()) * 0.01D;
                }

                entityliving.knockBack(this, 5, -d, -d2);
                entityliving.motionX *= 4D;
                entityliving.motionY *= 4D;
                entityliving.motionZ *= 4D;
            }
            float f = 0.01745329F;
            for(int i = 0; i < 40; i++)
            {
                double d1 = (float)posX + rand.nextFloat() * 0.25F;
                double d3 = (float)posY + 0.5F;
                double d4 = (float)posZ + rand.nextFloat() * 0.25F;
                float f1 = rand.nextFloat() * 360F;
                worldObj.spawnParticle("explode", d1, d3, d4, -Math.sin(f * f1) * 0.75D, 0.125D, Math.cos(f * f1) * 0.75D);
            }

            health = 0;
            setEntityDead();
        }
    }

    protected void updatePlayerActionState()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 8D);
        if(!active && counter >= 8)
        {
            if(entityplayer != null && canEntityBeSeen(entityplayer))
            {
                faceEntity(entityplayer, 10F, 10F);
                playerToAttack = entityplayer;
                active = true;
                lostyou = 0;
                texture = "/aether/mobs/SentryLit.png";
            }
            counter = 0;
        } else
        if(active && counter >= 8)
        {
            if(playerToAttack == null)
            {
                if(entityplayer != null && canEntityBeSeen(entityplayer))
                {
                    playerToAttack = entityplayer;
                    active = true;
                    lostyou = 0;
                } else
                {
                    lostyou++;
                    if(lostyou >= 4)
                    {
                        shutdown();
                    }
                }
            } else
            if(!canEntityBeSeen(playerToAttack) || getDistanceToEntity(playerToAttack) >= 16F)
            {
                lostyou++;
                if(lostyou >= 4)
                {
                    shutdown();
                }
            } else
            {
                lostyou = 0;
            }
            counter = 0;
        } else
        {
            counter++;
        }
        if(!active)
        {
            return;
        }
        if(playerToAttack != null)
        {
            faceEntity(playerToAttack, 10F, 10F);
        }
        if(onGround && jcount-- <= 0)
        {
            jcount = rand.nextInt(20) + 10;
            isJumping = true;
            moveStrafing = 0.5F - rand.nextFloat();
            moveForward = 1.0F;
            worldObj.playSoundAtEntity(this, "mob.slime", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            if(playerToAttack != null)
            {
                jcount /= 2;
                moveForward = 1.0F;
            }
        } else
        {
            isJumping = false;
            if(onGround)
            {
                moveStrafing = moveForward = 0.0F;
            }
        }
    }

    protected String getHurtSound()
    {
        return "mob.slime";
    }

    protected String getDeathSound()
    {
        return "mob.slime";
    }

    public boolean getCanSpawnHere()
    {
        return super.getCanSpawnHere();
    }

    protected float getSoundVolume()
    {
        return 0.6F;
    }

    protected int getDropItemId()
    {
        if(rand.nextInt(5) == 0)
        {
            return AetherBlocks.LightDungeonStone.blockID;
        } else
        {
            return AetherBlocks.DungeonStone.blockID;
        }
    }

    public float field_100021_a;
    public float field_100020_b;
    private int jcount;
    public int size;
    public int counter;
    public int lostyou;
    public boolean active;
}
*/