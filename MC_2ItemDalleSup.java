package net.minecraft.src;

public class MC_2ItemDalleSup extends ItemBlock {

        public static String[] blockNames = { "Multifaceted 1 Name", "Multifaceted 2 Name", "Multifaceted 12 Name", "Multifaceted 22 Name", "Multifaceted 14 Name", "Multifaceted 24 Name", "Multifaceted 16 Name", "Multifaceted 26 Name",
                "Multifaceted 3 Name",  "Multifaceted 1 5Name", "Multifaceted 2 Name",/* ect. ect. */ };

        public MC_2ItemDalleSup(int i) {
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