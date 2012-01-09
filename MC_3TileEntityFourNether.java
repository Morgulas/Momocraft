//// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://www.kpdus.com/jad.html
//// Decompiler options: packimports(3) braces deadcode 
//
//package net.minecraft.src;
//
//
//// Referenced classes of package net.minecraft.src:
////            TileEntity, IInventory, ItemStack, NBTTagCompound, 
////            NBTTagList, World, Item, BlockFurnace, 
////            FurnaceRecipes, Block, Material, ModLoader, 
////            EntityPlayer
//
//public class MC_3TileEntityFourNether extends TileEntity implements IInventory {
//
//    public MC_3TileEntityFourNether()
//    {
//        cookerItemStacks = new ItemStack[3];
//        cookerCookTime = 0;
//        currentItemBurnTime = 0;
//        cookerBurnTime = 0;
//    }
//
//    public int getSizeInventory()
//    {
//        return cookerItemStacks.length;
//    }
//
//    public ItemStack getStackInSlot(int i)
//    {
//        return cookerItemStacks[i];
//    }
//
//    public ItemStack decrStackSize(int i, int j)
//    {
//        if(cookerItemStacks[i] != null)
//        {
//            if(cookerItemStacks[i].stackSize <= j)
//            {
//                ItemStack itemstack = cookerItemStacks[i];
//                cookerItemStacks[i] = null;
//                return itemstack;
//            }
//            ItemStack itemstack1 = cookerItemStacks[i].splitStack(j);
//            if(cookerItemStacks[i].stackSize == 0)
//            {
//                cookerItemStacks[i] = null;
//            }
//            return itemstack1;
//        } else
//        {
//            return null;
//        }
//    }
//
//    public void setInventorySlotContents(int i, ItemStack itemstack)
//    {
//        cookerItemStacks[i] = itemstack;
//        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
//        {
//            itemstack.stackSize = getInventoryStackLimit();
//        }
//    }
//
//    public String getInvName()
//    {
//        return "Cooker";
//    }
//
//    public void readFromNBT(NBTTagCompound nbttagcompound)
//    {
//        super.readFromNBT(nbttagcompound);
//        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
//        cookerItemStacks = new ItemStack[getSizeInventory()];
//        for(int i = 0; i < nbttaglist.tagCount(); i++)
//        {
//            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
//            byte byte0 = nbttagcompound1.getByte("SlotCooker");
//            if(byte0 >= 0 && byte0 < cookerItemStacks.length)
//            {
//                cookerItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
//            }
//        }
//
//        cookerCookTime = nbttagcompound.getShort("CookTime");
//        cookerBurnTime = nbttagcompound.getShort("BurnTime");
//        currentItemBurnTime = getItemCookTime(cookerItemStacks[1]);
//    }
//
//    public void writeToNBT(NBTTagCompound nbttagcompound)
//    {
//        super.writeToNBT(nbttagcompound);
//        nbttagcompound.setShort("CookTime", (short)cookerCookTime);
//        nbttagcompound.setShort("BurnTime", (short)cookerBurnTime);
//        NBTTagList nbttaglist = new NBTTagList();
//        for(int i = 0; i < cookerItemStacks.length; i++)
//        {
//            if(cookerItemStacks[i] != null)
//            {
//                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
//                nbttagcompound1.setByte("SlotCooker", (byte)i);
//                cookerItemStacks[i].writeToNBT(nbttagcompound1);
//                nbttaglist.setTag(nbttagcompound1);
//            }
//        }
//
//        nbttagcompound.setTag("Items", nbttaglist);
//    }
//
//    public int getInventoryStackLimit()
//    {
//        return 64;
//    }
//
//    public int getBurnProgressScaled(int i)
//    {
//        return (cookerBurnTime * i) / 200;
//    }
//
//    public int getCookTimeRemainingScaled(int i)
//    {
//        if(currentItemBurnTime == 0)
//        {
//            currentItemBurnTime = 200;
//        }
//        return (cookerCookTime * i) / currentItemBurnTime;
//    }
//
//    public boolean isFreezing()
//    {
//        return cookerCookTime > 0;
//    }
//
//    public void updateEntity()
//    {
//        boolean flag = cookerCookTime > 0;
//        boolean flag1 = false;
//        if(cookerCookTime > 0)
//        {
//            cookerCookTime--;
//        }
//        if(!worldObj.multiplayerWorld)
//        {
//            if(cookerCookTime == 0 && canCook())
//            {
//                currentItemBurnTime = cookerCookTime = getItemCookTime(cookerItemStacks[1]);
//                if(cookerCookTime > 0)
//                {
//                    flag1 = true;
//                    if(cookerItemStacks[1] != null)
//                    {
//                        if(cookerItemStacks[1].getItem().hasContainerItem())
//                        {
//                            cookerItemStacks[1] = new ItemStack(cookerItemStacks[1].getItem().getContainerItem());
//                        } else
//                        {
//                            cookerItemStacks[1].stackSize--;
//                        }
//                        if(cookerItemStacks[1].stackSize == 0)
//                        {
//                            cookerItemStacks[1] = null;
//                        }
//                    }
//                }
//            }
//            if(isFreezing() && canCook())
//            {
//                cookerBurnTime++;
//                if(cookerBurnTime == 200)
//                {
//                    cookerBurnTime = 0;
//                    cookItem();
//                    flag1 = true;
//                }
//            } else
//            {
//                cookerBurnTime = 0;
//            }
//        }
//        if(flag != (cookerCookTime > 0))
//        {
//            flag1 = true;
//            
//            //Appel de cette fonction pour le changement d'etat
//            MC_1BlockFourNether.updateFurnaceBlockState(cookerCookTime > 0, worldObj, xCoord, yCoord, zCoord);
//
//        }
//        if(flag1)
//        {
//            onInventoryChanged();
//        }
//    }
//
//    private boolean canCook()
//    {
//        if(cookerItemStacks[0] == null)
//        {
//            return false;
//        }
//        ItemStack itemstack = MC_0FourNetherRecipes.cooking().getCookingResult(cookerItemStacks[0].getItem().shiftedIndex);
//        if(itemstack == null)
//        {
//            return false;
//        }
//        if(cookerItemStacks[2] == null)
//        {
//            return true;
//        }
//        if(!cookerItemStacks[2].isItemEqual(itemstack))
//        {
//            return false;
//        }
//        if(cookerItemStacks[2].stackSize < getInventoryStackLimit() && cookerItemStacks[2].stackSize < cookerItemStacks[2].getMaxStackSize())
//        {
//            return true;
//        }
//        return cookerItemStacks[2].stackSize < itemstack.getMaxStackSize();
//    }
//
//    public void cookItem()
//    {
//        if(!canCook())
//        {
//            return;
//        }
//        ItemStack itemstack = MC_0FourNetherRecipes.cooking().getCookingResult(cookerItemStacks[0].getItem().shiftedIndex);
//        if(cookerItemStacks[2] == null)
//        {
//            cookerItemStacks[2] = itemstack.copy();
//        } else
//        if(cookerItemStacks[2].itemID == itemstack.itemID)
//        {
//            cookerItemStacks[2].stackSize += itemstack.stackSize;
//        }
//        if(cookerItemStacks[0].getItem().hasContainerItem())
//        {
//            cookerItemStacks[0] = new ItemStack(cookerItemStacks[0].getItem().getContainerItem());
//        } else
//        {
//            cookerItemStacks[0].stackSize--;
//        }
//        if(cookerItemStacks[0].stackSize <= 0)
//        {
//            cookerItemStacks[0] = null;
//        }
//    }
//
//    private int getItemCookTime(ItemStack itemstack)
//    {
//        if(itemstack == null)
//        {
//            return 0;
//        }
//        int i = itemstack.getItem().shiftedIndex;
//        if (i == Item.blazePowder.shiftedIndex/*Item.redstone.shiftedIndex*/)
//        {
//                return 2400;
//        }
//        else
//        {
//                return 0;
//        }
//    }
//
//    public boolean canInteractWith(EntityPlayer entityplayer)
//    {
//        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
//        {
//            return false;
//        }
//        return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
//    }
//    
//    public void openChest()
//    {
//    }
//
//    public void closeChest()
//    {
//    }
//
//    private ItemStack cookerItemStacks[];
//    public int cookerCookTime;
//    public int currentItemBurnTime;
//    public int cookerBurnTime;
//    public int furnaceBurnTime;
//	public void func_35142_x_() {
//		
//	}
//
//	public void func_35141_y_() {
//		
//	}
//
//	@Override
//	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}