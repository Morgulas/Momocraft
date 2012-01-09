//// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://www.kpdus.com/jad.html
//// Decompiler options: packimports(3) braces deadcode 
//
//package net.minecraft.src;
//
//import java.util.List;
//
//// Referenced classes of package net.minecraft.src:
////            Container, Slot, SlotFurnace, InventoryPlayer, 
////            ICrafting, TileEntityFurnace, ItemStack, EntityPlayer
//
//public class MC_5ContainerFourNether extends Container
//{
//
//    public MC_5ContainerFourNether(InventoryPlayer inventoryplayer, MC_3TileEntityFourNether tileentitycooker)
//    {
//        coolTime = 0;
//        cookTime = 0;
//        itemCookTime = 0;
//        cooker = tileentitycooker;
//        addSlot(new Slot(tileentitycooker, 0, 56, 17));
//        addSlot(new Slot(tileentitycooker, 1, 56, 53));
//        addSlot(new MC_6SlotFourNether(inventoryplayer.player, tileentitycooker, 2, 116, 35));
//        for(int i = 0; i < 3; i++)
//        {
//            for(int k = 0; k < 9; k++)
//            {
//                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
//            }
//
//        }
//
//        for(int j = 0; j < 9; j++)
//        {
//            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
//        }
//
//    }
//
//    public void updateCraftingResults()
//    {
//        super.updateCraftingResults();
//        for(int i = 0; i < inventorySlots.size(); i++)
//        {
//            ICrafting icrafting = (ICrafting)inventorySlots.get(i);
//            if(coolTime != cooker.cookerBurnTime)
//            {
//                icrafting.updateCraftingInventoryInfo(this, 0, cooker.cookerBurnTime);
//            }
//            if(cookTime != cooker.cookerCookTime)
//            {
//                icrafting.updateCraftingInventoryInfo(this, 1, cooker.cookerCookTime);
//            }
//            if(itemCookTime != cooker.currentItemBurnTime)
//            {
//                icrafting.updateCraftingInventoryInfo(this, 2, cooker.currentItemBurnTime);
//            }
//        }
//
//        coolTime = cooker.cookerBurnTime;
//        cookTime = cooker.cookerCookTime;
//        itemCookTime = cooker.currentItemBurnTime;
//    }
//
//    public void func_20112_a(int i, int j)
//    {
//        if(i == 0)
//        {
//            cooker.cookerBurnTime = j;
//        }
//        if(i == 1)
//        {
//            cooker.cookerCookTime = j;
//        }
//        if(i == 2)
//        {
//            cooker.currentItemBurnTime = j;
//        }
//    }
//
//    public boolean canInteractWith(EntityPlayer entityplayer)
//    {
//        return cooker.canInteractWith(entityplayer);
//    }
//
//    public ItemStack getStackInSlot(int i)
//    {
//        ItemStack itemstack = null;
//        Slot slot = (Slot)inventorySlots.get(i);
//        if(slot != null && slot.getHasStack())
//        {
//            ItemStack itemstack1 = slot.getStack();
//            itemstack = itemstack1.copy();
//            if(i == 2)
//            {
//                if(!mergeItemStack(itemstack1, 3, 39, true))
//                {
//                    return null;
//                }
//            } else
//            if(i >= 3 && i < 30)
//            {
//                if(!mergeItemStack(itemstack1, 30, 39, false))
//                {
//                    return null;
//                }
//            } else
//            if(i >= 30 && i < 39)
//            {
//                if(!mergeItemStack(itemstack1, 3, 30, false))
//                {
//                    return null;
//                }
//            } else
//            if(!mergeItemStack(itemstack1, 3, 39, false))
//            {
//                return null;
//            }
//            if(itemstack1.stackSize == 0)
//            {
//                slot.putStack(null);
//            } else
//            {
//                slot.onSlotChanged();
//            }
//            if(itemstack1.stackSize != itemstack.stackSize)
//            {
//                slot.onPickupFromSlot(itemstack1);
//            } else
//            {
//                return null;
//            }
//        }
//        return itemstack;
//    }
//
//    private MC_3TileEntityFourNether cooker;
//    private int coolTime;
//    private int cookTime;
//    private int itemCookTime;
//}