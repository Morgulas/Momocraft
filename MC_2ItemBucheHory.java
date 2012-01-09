package net.minecraft.src;

public class MC_2ItemBucheHory extends ItemBlock {

        public static String[] blockNames = { "Tronccouh�1", "Tronccouh�2",
                "Tronccouh�3" ,"Tronccouh�4", "Tronccouh�5",
                "Tronccouh�6", "Tronccouh�7", "Tronccouh�8",
                "Tronccouh�9" ,"Tronccouh�10", "Tronccouh�11",
                "Tronccouh�12","Tronccouh�13", "Tronccouh�14",
                "Tronccouh�15"};

        public MC_2ItemBucheHory(int i) {
                super(i);
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