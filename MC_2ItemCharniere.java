package net.minecraft.src;

public class MC_2ItemCharniere extends Item{
    public MC_2ItemCharniere(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        TileEntity tileentity = world.getBlockTileEntity(i, j, k);
        if(tileentity != null && (tileentity instanceof MC_3TileEntityPlaque))
        {
            MC_3TileEntityPlaque tileentityplaque = (MC_3TileEntityPlaque)tileentity;
            if(tileentityplaque.angle == -1 && l != tileentityplaque.orientation && l != mod_Momocraft.Inverse(tileentityplaque.orientation))
            {
                tileentityplaque.rotation = mod_Momocraft.Inverse(l);
                tileentityplaque.angle = 90;
                itemstack.stackSize--;
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }
}
