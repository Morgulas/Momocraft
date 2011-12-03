package net.minecraft.src.Momocraft;

import net.minecraft.src.*;
import net.minecraft.src.EntityPlayer;

public class ContainerFreezer extends Container {

	public ContainerFreezer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityfreezer)
    {
        cookTime = 0;
        burnTime = 0;
        itemBurnTime = 0;
        freezer = tileentityfreezer;
//        addSlot(new Slot(tileentityfreezer, 0, 56, 17));
//        addSlot(new Slot(tileentityfreezer, 1, 56, 53));
//        addSlot(new SlotFurnace(inventoryplayer.player, tileentityfreezer, 2, 116, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }

    }

    protected void func_28125_a(ItemStack itemstack, int i, int j, boolean flag)
    {
    }

/*    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            if(cookTime != freezer.frozenTimeForItem)
            {
                icrafting.func_20158_a(this, 0, freezer.frozenTimeForItem);
            }
            if(burnTime != freezer.frozenProgress)
            {
                icrafting.func_20158_a(this, 1, freezer.frozenProgress);
            }
            if(itemBurnTime != freezer.frozenPowerRemaining)
            {
                icrafting.func_20158_a(this, 2, freezer.frozenPowerRemaining);
            }
        }

        cookTime = freezer.frozenTimeForItem;
        burnTime = freezer.frozenProgress;
        itemBurnTime = freezer.frozenPowerRemaining;
    }
*/
    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            freezer.frozenTimeForItem = j;
        }
        if(i == 1)
        {
            freezer.frozenProgress = j;
        }
        if(i == 2)
        {
            freezer.frozenPowerRemaining = j;
        }
    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return freezer.canInteractWith(entityplayer);
    }

/*    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)slots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 2)
            {
                func_28125_a(itemstack1, 3, 39, true);
            } else
            if(i >= 3 && i < 30)
            {
                func_28125_a(itemstack1, 30, 39, false);
            } else
            if(i >= 30 && i < 39)
            {
                func_28125_a(itemstack1, 3, 30, false);
            } else
            {
                func_28125_a(itemstack1, 3, 39, false);
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
*/
    private TileEntityFreezer freezer;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
    
    
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

}
