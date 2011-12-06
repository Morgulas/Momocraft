package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_EntitySlider extends EntityFlying implements MMC_IAetherBoss{

public MMC_EntitySlider(World world)
{
    super(world);
    rotationYaw = 0.0F;
    rotationPitch = 0.0F;
    setSize(2.0F, 2.0F);
    health = 500;
    dennis = 1;
    texture = "/momocraft/aether/mobs/sliderSleep.png";
    chatTime = 60;
    //bossName = "NameGen.gen();
}

/*public void entityInit()
{
    super.entityInit();
    posX = Math.floor(posX + 0.5D);
    posY = Math.floor(posY + 0.5D);
    posZ = Math.floor(posZ + 0.5D);
}

public boolean canDespawn()
{
    return false;
}

protected String getLivingSound()
{
    return "ambient.cave.cave";
}

protected String getHurtSound()
{
    return "step.stone";
}

protected String getDeathSound()
{
    return "aether.sound.bosses.slider.sliderDeath";
}

public void writeEntityToNBT(NBTTagCompound nbttagcompound)
{
    super.writeEntityToNBT(nbttagcompound);
    nbttagcompound.setFloat("Speedy", speedy);
    nbttagcompound.setShort("MoveTimer", (short)moveTimer);
    nbttagcompound.setShort("Direction", (short)direction);
    nbttagcompound.setBoolean("GotMovement", gotMovement);
    nbttagcompound.setBoolean("Awake", awake);
    nbttagcompound.setInteger("DungeonX", dungeonX);
    nbttagcompound.setInteger("DungeonY", dungeonY);
    nbttagcompound.setInteger("DungeonZ", dungeonZ);
    nbttagcompound.setBoolean("IsCurrentBoss", isCurrentBoss());
    nbttagcompound.setString("BossName", bossName);
}

public void readEntityFromNBT(NBTTagCompound nbttagcompound)
{
    super.readEntityFromNBT(nbttagcompound);
    speedy = nbttagcompound.getFloat("Speedy");
    moveTimer = nbttagcompound.getShort("MoveTimer");
    direction = nbttagcompound.getShort("Direction");
    gotMovement = nbttagcompound.getBoolean("GotMovement");
    awake = nbttagcompound.getBoolean("Awake");
    dungeonX = nbttagcompound.getInteger("DungeonX");
    dungeonY = nbttagcompound.getInteger("DungeonY");
    dungeonZ = nbttagcompound.getInteger("DungeonZ");
    if(nbttagcompound.getBoolean("IsCurrentBoss"))
    {
        mod_Aether.currentBoss = this;
    }
    bossName = nbttagcompound.getString("BossName");
    if(awake)
    {
        if(criticalCondition())
        {
            texture = "/aether/mobs/sliderAwake_red.png";
        } else
        {
            texture = "/aether/mobs/sliderAwake.png";
        }
    }
}

public boolean criticalCondition()
{
    return health <= 125;
}

public void onUpdate()
{
    super.onUpdate();
    renderYawOffset = rotationPitch = rotationYaw = 0.0F;
    if(awake)
    {
        if(target != null && (target instanceof EntityLiving))
        {
            EntityLiving entityliving = (EntityLiving)target;
            if(entityliving.health <= 0)
            {
                awake = false;
                mod_Aether.currentBoss = null;
                target = null;
                texture = "/aether/mobs/sliderSleep.png";
                stop();
                openDoor();
                moveTimer = 0;
                return;
            }
        } else
        {
            if(target != null && target.isDead)
            {
                awake = false;
                mod_Aether.currentBoss = null;
                target = null;
                texture = "/aether/mobs/sliderSleep.png";
                stop();
                openDoor();
                moveTimer = 0;
                return;
            }
            if(target == null)
            {
                target = worldObj.getClosestPlayerToEntity(this, -1D);
                if(target == null)
                {
                    awake = false;
                    mod_Aether.currentBoss = null;
                    target = null;
                    texture = "/aether/mobs/sliderSleep.png";
                    stop();
                    openDoor();
                    moveTimer = 0;
                    return;
                }
            }
        }
        if(gotMovement)
        {
            if(isCollided)
            {
                double d = posX - 0.5D;
                double d2 = boundingBox.minY + 0.75D;
                double d4 = posZ - 0.5D;
                crushed = false;
                if(d2 < 124D && d2 > 4D)
                {
                    if(direction == 0)
                    {
                        for(int i = 0; i < 25; i++)
                        {
                            double d6 = (double)(i / 5 - 2) * 0.75D;
                            double d12 = (double)(i % 5 - 2) * 0.75D;
                            blockCrush((int)(d + d6), (int)(d2 + 1.5D), (int)(d4 + d12));
                        }

                    } else
                    if(direction == 1)
                    {
                        for(int j = 0; j < 25; j++)
                        {
                            double d7 = (double)(j / 5 - 2) * 0.75D;
                            double d13 = (double)(j % 5 - 2) * 0.75D;
                            blockCrush((int)(d + d7), (int)(d2 - 1.5D), (int)(d4 + d13));
                        }

                    } else
                    if(direction == 2)
                    {
                        for(int k = 0; k < 25; k++)
                        {
                            double d8 = (double)(k / 5 - 2) * 0.75D;
                            double d14 = (double)(k % 5 - 2) * 0.75D;
                            blockCrush((int)(d + 1.5D), (int)(d2 + d8), (int)(d4 + d14));
                        }

                    } else
                    if(direction == 3)
                    {
                        for(int l = 0; l < 25; l++)
                        {
                            double d9 = (double)(l / 5 - 2) * 0.75D;
                            double d15 = (double)(l % 5 - 2) * 0.75D;
                            blockCrush((int)(d - 1.5D), (int)(d2 + d9), (int)(d4 + d15));
                        }

                    } else
                    if(direction == 4)
                    {
                        for(int i1 = 0; i1 < 25; i1++)
                        {
                            double d10 = (double)(i1 / 5 - 2) * 0.75D;
                            double d16 = (double)(i1 % 5 - 2) * 0.75D;
                            blockCrush((int)(d + d10), (int)(d2 + d16), (int)(d4 + 1.5D));
                        }

                    } else
                    if(direction == 5)
                    {
                        for(int j1 = 0; j1 < 25; j1++)
                        {
                            double d11 = (double)(j1 / 5 - 2) * 0.75D;
                            double d17 = (double)(j1 % 5 - 2) * 0.75D;
                            blockCrush((int)(d + d11), (int)(d2 + d17), (int)(d4 - 1.5D));
                        }

                    }
                }
                if(crushed)
                {
                    worldObj.playSoundEffect(posX, posY, posZ, "random.explode", 3F, (0.625F + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
                    worldObj.playSoundAtEntity(this, "aether.sound.bosses.slider.sliderCollide", 2.5F, 1.0F / (rand.nextFloat() * 0.2F + 0.9F));
                }
                stop();
            } else
            {
                if(speedy < 2.0F)
                {
                    speedy += criticalCondition() ? 0.0325F : 0.025F;
                }
                motionX = 0.0D;
                motionY = 0.0D;
                motionZ = 0.0D;
                if(direction == 0)
                {
                    motionY = speedy;
                    if(boundingBox.minY > target.boundingBox.minY + 0.34999999999999998D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                } else
                if(direction == 1)
                {
                    motionY = -speedy;
                    if(boundingBox.minY < target.boundingBox.minY - 0.25D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                } else
                if(direction == 2)
                {
                    motionX = speedy;
                    if(posX > target.posX + 0.125D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                } else
                if(direction == 3)
                {
                    motionX = -speedy;
                    if(posX < target.posX - 0.125D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                } else
                if(direction == 4)
                {
                    motionZ = speedy;
                    if(posZ > target.posZ + 0.125D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                } else
                if(direction == 5)
                {
                    motionZ = -speedy;
                    if(posZ < target.posZ - 0.125D)
                    {
                        stop();
                        moveTimer = 8;
                    }
                }
            }
        } else
        if(moveTimer > 0)
        {
            moveTimer--;
            if(criticalCondition() && rand.nextInt(2) == 0)
            {
                moveTimer--;
            }
            motionX = 0.0D;
            motionY = 0.0D;
            motionZ = 0.0D;
        } else
        {
            double d1 = Math.abs(posX - target.posX);
            double d3 = Math.abs(boundingBox.minY - target.boundingBox.minY);
            double d5 = Math.abs(posZ - target.posZ);
            if(d1 > d5)
            {
                direction = 2;
                if(posX > target.posX)
                {
                    direction = 3;
                }
            } else
            {
                direction = 4;
                if(posZ > target.posZ)
                {
                    direction = 5;
                }
            }
            if(d3 > d1 && d3 > d5 || d3 > 0.25D && rand.nextInt(5) == 0)
            {
                direction = 0;
                if(posY > target.posY)
                {
                    direction = 1;
                }
            }
            worldObj.playSoundAtEntity(this, "aether.sound.bosses.slider.sliderMove", 2.5F, 1.0F / (rand.nextFloat() * 0.2F + 0.9F));
            gotMovement = true;
        }
    }
    if(harvey > 0.01F)
    {
        harvey *= 0.8F;
    }
    if(chatTime > 0)
    {
        chatTime--;
    }
}

private void openDoor()
{
    int i = dungeonX + 15;
    for(int j = dungeonY + 1; j < dungeonY + 5; j++)
    {
        for(int k = dungeonZ + 6; k < dungeonZ + 10; k++)
        {
            worldObj.setBlock(i, j, k, 0);
        }

    }

}

public void applyEntityCollision(Entity entity)
{
    if(awake && gotMovement)
    {
        boolean flag = entity.attackEntityFrom(this, 6);
        if(flag && (entity instanceof EntityLiving))
        {
            worldObj.playSoundAtEntity(this, "aether.sound.bosses.slider.sliderCollide", 2.5F, 1.0F / (rand.nextFloat() * 0.2F + 0.9F));
            if((entity instanceof EntityCreature) || (entity instanceof EntityPlayer))
            {
                EntityLiving entityliving = (EntityLiving)entity;
                entityliving.motionY += 0.34999999999999998D;
                entityliving.motionX *= 2D;
                entityliving.motionZ *= 2D;
            }
            stop();
        }
    }
}

protected void dropFewItems()
{
    for(int i = 0; i < 7 + rand.nextInt(3); i++)
    {
        dropItem(AetherBlocks.DungeonStone.blockID, 1);
    }

    entityDropItem(new ItemStack(AetherItems.Key, 1, 0), 0.0F);
}

public boolean getCanSpawnHere()
{
    int i = MathHelper.floor_double(posX);
    int j = MathHelper.floor_double(boundingBox.minY);
    int k = MathHelper.floor_double(posZ);
    return worldObj.getBlockId(i, j - 1, k) == Block.grass.blockID && worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
}

public void stop()
{
    gotMovement = false;
    moveTimer = 12;
    direction = 0;
    speedy = 0.0F;
    motionX = 0.0D;
    motionY = 0.0D;
    motionZ = 0.0D;
}

private void chatItUp(String s)
{
    if(chatTime <= 0)
    {
        ModLoader.getMinecraftInstance().ingameGUI.addChatMessage(s);
        chatTime = 60;
    }
}

public boolean attackEntityFrom(Entity entity, int i)
{
    if(entity == null || !(entity instanceof EntityPlayer))
    {
        return false;
    }
    EntityPlayer entityplayer = (EntityPlayer)entity;
    ItemStack itemstack = entityplayer.getCurrentEquippedItem();
    if(itemstack == null || itemstack.getItem() == null)
    {
        return false;
    }
    if(itemstack.getItem() instanceof Tool)
    {
        Tool tool = (Tool)itemstack.getItem();
        if(!tool.canHarvest(Block.stone))
        {
            chatItUp("Hmm. Perhaps I need to attack it with a Pickaxe?");
            return false;
        }
    } else
    {
        chatItUp("Hmm. Perhaps I need to attack it with a Pickaxe?");
        return false;
    }
    boolean flag = super.attackEntityFrom(entity, Math.max(0, i));
    if(flag)
    {
        for(int j = 0; j < (health > 0 ? 48 : 16); j++)
        {
            double d1 = posX + (double)(rand.nextFloat() - rand.nextFloat()) * 1.5D;
            double d3 = boundingBox.minY + 1.75D + (double)(rand.nextFloat() - rand.nextFloat()) * 1.5D;
            double d4 = posZ + (double)(rand.nextFloat() - rand.nextFloat()) * 1.5D;
            if(health <= 0)
            {
                worldObj.spawnParticle("explode", d1, d3, d4, 0.0D, 0.0D, 0.0D);
            }
        }

        if(health <= 0)
        {
            isDead = true;
            openDoor();
            unlockBlock(dungeonX, dungeonY, dungeonZ);
            worldObj.setBlockAndMetadata(dungeonX + 7, dungeonY + 1, dungeonZ + 7, Block.trapdoor.blockID, 3);
            worldObj.setBlockAndMetadata(dungeonX + 8, dungeonY + 1, dungeonZ + 7, Block.trapdoor.blockID, 2);
            worldObj.setBlockAndMetadata(dungeonX + 7, dungeonY + 1, dungeonZ + 8, Block.trapdoor.blockID, 3);
            worldObj.setBlockAndMetadata(dungeonX + 8, dungeonY + 1, dungeonZ + 8, Block.trapdoor.blockID, 2);
//            mod_Aether.giveAchievement(AetherAchievements.defeatBronze);
//            mod_Aether.currentBoss = null;
        } else
        if(!awake)
        {
            worldObj.playSoundAtEntity(this, "aether.sound.bosses.slider.sliderAwaken", 2.5F, 1.0F / (rand.nextFloat() * 0.2F + 0.9F));
            awake = true;
            target = entity;
            texture = "/aether/mobs/sliderAwake.png";
            int k = dungeonX + 15;
            for(int l = dungeonY + 1; l < dungeonY + 8; l++)
            {
                for(int i1 = dungeonZ + 5; i1 < dungeonZ + 11; i1++)
                {
//                    worldObj.setBlock(k, l, i1, AetherBlocks.LockedDungeonStone.blockID);
                }

            }

            mod_Aether.currentBoss = this;
        } else
        if(gotMovement)
        {
            speedy *= 0.75F;
        }
        double d = Math.abs(posX - entity.posX);
        double d2 = Math.abs(posZ - entity.posZ);
        if(d > d2)
        {
            dennis = 1;
            rennis = 0;
            if(posX > entity.posX)
            {
                dennis = -1;
            }
        } else
        {
            rennis = 1;
            dennis = 0;
            if(posZ > entity.posZ)
            {
                rennis = -1;
            }
        }
        harvey = 0.7F - (float)health / 875F;
        if(criticalCondition())
        {
            texture = "/aether/mobs/sliderAwake_red.png";
        } else
        {
            texture = "/aether/mobs/sliderAwake.png";
        }
    }
    return flag;
}

private void unlockBlock(int i, int j, int k)
{
    int l = worldObj.getBlockId(i, j, k);
    if(l == AetherBlocks.LockedDungeonStone.blockID)
    {
        worldObj.setBlockAndMetadata(i, j, k, AetherBlocks.DungeonStone.blockID, worldObj.getBlockMetadata(i, j, k));
        unlockBlock(i + 1, j, k);
        unlockBlock(i - 1, j, k);
        unlockBlock(i, j + 1, k);
        unlockBlock(i, j - 1, k);
        unlockBlock(i, j, k + 1);
        unlockBlock(i, j, k - 1);
    }
/*    if(l == AetherBlocks.LockedLightDungeonStone.blockID)
    {
        worldObj.setBlockAndMetadata(i, j, k, AetherBlocks.LightDungeonStone.blockID, worldObj.getBlockMetadata(i, j, k));
        unlockBlock(i + 1, j, k);
        unlockBlock(i - 1, j, k);
        unlockBlock(i, j + 1, k);
        unlockBlock(i, j - 1, k);
        unlockBlock(i, j, k + 1);
        unlockBlock(i, j, k - 1);
    }*/
/*}*/

public void addVelocity(double d, double d1, double d2)
{
}

public void knockBack(Entity entity, int i, double d, double d1)
{
}

/*public void blockCrush(int i, int j, int k)
{
    int l = worldObj.getBlockId(i, j, k);
    int i1 = worldObj.getBlockMetadata(i, j, k);
    if(l == 0 || l == AetherBlocks.LockedDungeonStone.blockID || l == AetherBlocks.LockedLightDungeonStone.blockID)
    {
        return;
    }
    ModLoader.getMinecraftInstance().effectRenderer.addBlockDestroyEffects(i, j, k, l, i1);
    Block.blocksList[l].onBlockRemoval(worldObj, i, j, k);
    Block.blocksList[l].dropBlockAsItem(worldObj, i, j, k, i1);
    worldObj.setBlockWithNotify(i, j, k, 0);
    crushed = true;
    if(ModLoader.getMinecraftInstance().gameSettings.fancyGraphics)
    {
        addSquirrelButts(i, j, k);
    }
}*/

public void addSquirrelButts(int i, int j, int k)
{
    double d = (double)i + 0.5D + (double)(rand.nextFloat() - rand.nextFloat()) * 0.375D;
    double d1 = (double)j + 0.5D + (double)(rand.nextFloat() - rand.nextFloat()) * 0.375D;
    double d2 = (double)k + 0.5D + (double)(rand.nextFloat() - rand.nextFloat()) * 0.375D;
    worldObj.spawnParticle("explode", d, d1, d2, 0.0D, 0.0D, 0.0D);
}

public void setDungeon(int i, int j, int k)
{
    dungeonX = i;
    dungeonY = j;
    dungeonZ = k;
}

public int getBossHP()
{
    return health;
}

public int getBossMaxHP()
{
    return 500;
}

/*public boolean isCurrentBoss()
{
    if(mod_Aether.currentBoss == null)
    {
        return false;
    } else
    {
        return equals(mod_Aether.currentBoss);
    }
}*/

public int getBossEntityID()
{
    return entityId;
}

public String getBossTitle()
{
    return (new StringBuilder()).append(bossName).append(", the Slider").toString();
}

public int moveTimer;
public int dennis;
public int rennis;
public int chatTime;
public Entity target;
public boolean awake;
public boolean gotMovement;
public boolean crushed;
public float speedy;
public float harvey;
public int direction;
private int dungeonX;
private int dungeonY;
private int dungeonZ;
public String bossName;
@Override
public boolean isCurrentBoss() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int getMaxHealth() {
	// TODO Auto-generated method stub
	return 0;
}
}
