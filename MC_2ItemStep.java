package net.minecraft.src;

public class MC_2ItemStep extends ItemBlock {

        public static String[] blockNames = { "stepstone", "steplog",
                "steppaille" ,"stepardoise"};

        public MC_2ItemStep(int i) {
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