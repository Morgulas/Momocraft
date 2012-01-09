package net.minecraft.src;

public class MC_2ItemPlaqueCloth extends ItemBlock {

        public static String[] blockNames = { "plaqueclothorange", "plaqueclothblanc",
                "plaqueclothrouge" ,"plaqueclothnoir", "plaqueclothvertfonce",
                "plaqueclothbrun" ,"plaqueclothbleufonce", "plaqueclothviolet",
                "plaqueclothbleuclair" ,"plaqueclothgrisclair", "plaqueclothgrisclair",
                "plaqueclothgrisfonce", "plaqueclothrose", "plaqueclothvertclair",
                "plaqueclothjaune" , "plaqueclothturquoise", "plaqueclothmagenta"};

        public MC_2ItemPlaqueCloth(int id) {
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