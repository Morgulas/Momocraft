package net.minecraft.src;

public class MC_6SlotFourNether extends Slot {

    public MC_6SlotFourNether(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
    {
        super(iinventory, i, j, k);
    }

    public boolean isItemValid(ItemStack itemstack)
    {
        return false;
    }

    public void onPickupFromSlot(ItemStack itemstack)
    {
        super.onPickupFromSlot(itemstack);
    }
}
