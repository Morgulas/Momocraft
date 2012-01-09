package net.minecraft.src;

public class MC_2ItemVerre extends ItemBlock {

    public static int Icone[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15
    };
	
        public static String[] blockNames = { "verreorange", "verreblanc",
                "verrerouge" ,"verrenoir", "verrevertfonce",
                "verrebrun" ,"verrebleufonce", "verreviolet",
                "verrebleuclair" ,"verregrisclair", "verregrisclair",
                "verregrisfonce", "verrerose", "verrevertclair",
                "verrejaune" , "verreturquoise", "verremagenta"};

        public MC_2ItemVerre(int i) {
                super(i);
                setMaxDamage(0);
                setHasSubtypes(true);
                setIconIndex(1);
                setMaxStackSize(1);
                setHasSubtypes(true);
                setMaxDamage(0);
        }
        
        public int getPlacedBlockMetadata(int damage) {
                return damage;
        }

        public String getItemNameIS(ItemStack itemstack) {
        return (new StringBuilder())
                .append(super.getItemName())
                .append(".")
                .append(blockNames[itemstack.getItemDamage()])
                .toString();
        }
        
        public int getIconFromDamage(int i)
        {
            return 1;
        }

}