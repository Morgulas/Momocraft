package net.minecraft.src;

public class MC_2ItemBucheHory extends ItemBlock {

        public static String[] blockNames = { "Tronccouhé1", "Tronccouhé2",
                "Tronccouhé3" ,"Tronccouhé4", "Tronccouhé5",
                "Tronccouhé6", "Tronccouhé7", "Tronccouhé8",
                "Tronccouhé9" ,"Tronccouhé10", "Tronccouhé11",
                "Tronccouhé12","Tronccouhé13", "Tronccouhé14",
                "Tronccouhé15"};

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