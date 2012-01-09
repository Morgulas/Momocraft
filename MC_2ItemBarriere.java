package net.minecraft.src;

public class MC_2ItemBarriere extends ItemBlock {

        public static String[] blockNames = { "Tronccouh�1", "Tronccouh�2",
                "Tronccouh�3" /* ect. ect. */ };

        public MC_2ItemBarriere(int id) {
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