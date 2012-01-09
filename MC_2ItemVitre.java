package net.minecraft.src;

public class MC_2ItemVitre extends ItemBlock {

        public static String[] blockNames = {"verreorange", "verreblanc",
            "verrerouge" ,"verrenoir", "verrevertfonce",
            "verrebrun" ,"verrebleufonce", "verreviolet",
            "verrebleuclair" ,"verregrisclair", "verregrisclair",
            "verregrisfonce", "verrerose", "verrevertclair",
            "verrejaune" , "verreturquoise", "verremagenta"};

        public MC_2ItemVitre(int id) {
                super(id);
                setMaxDamage(0);
                setHasSubtypes(true);
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

}