package net.minecraft.src;

public class MC_2ItemEscalierCloth1 extends ItemBlock {

        public static String[] blockNames = { "escalierblanc", "escalierorange",
                "escaliermagenta" ,"escalierbleuciel", "escalierjaune",
                "escaliervertlime" ,"escalierrose", "escaliergris",
                "escaliergrisclair" ,"escaliercyan", "escalierviolet",
                "escalierbleu", "escaliermarron", "escaleirvert",
                "escalierouge" , "escaliernoir"};

        public MC_2ItemEscalierCloth1(int id) {
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