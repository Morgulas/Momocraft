package net.minecraft.src;

public class MC_2ItemStepCloth extends ItemBlock {

        public static String[] blockNames = { "stepblanc", "steporange",
                "stepmagenta" ,"stepbleuciel", "stepjaune",
                "stepvertlime" ,"steprose", "stepgris",
                "stepgrisclair" ,"stepcyan", "stepviolet",
                "stepbleu", "stepmarron", "stepvert",
                "stepouge" , "stepnoir"};

        public MC_2ItemStepCloth(int i) {
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