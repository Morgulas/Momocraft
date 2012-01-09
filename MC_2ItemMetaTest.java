package net.minecraft.src;

public class MC_2ItemMetaTest extends ItemBlock {

        public static String[] blockNames = { "Multifaceted 1 Name", "Multifaceted 2 Name",
                "Multifaceted 3 Name" /* ect. ect. */ };

        public MC_2ItemMetaTest(int id) {
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