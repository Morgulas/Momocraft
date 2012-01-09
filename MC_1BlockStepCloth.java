package net.minecraft.src;

import java.util.Random;

public class MC_1BlockStepCloth extends Block {
	
    private boolean blockType;
    
        public MC_1BlockStepCloth(int i) {
                super(i, Material.cloth);
                this.setStepSound(Block.soundClothFootstep);
                this.setBlockName("StepCloth");
                setHardness(0.8F);
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        public int idDropped(int metadata, Random random) 
        {
                return blockID;
        }

        protected int damageDropped(int metadata) 
        {
                return metadata;
        }

        public int getBlockTextureFromSideAndMetadata(int side, int metadata) 
        {
                switch (metadata){
                case 0: return Block.cloth.blockIndexInTexture;
                case 1: return mod_Momocraft.IndexClothTexture(1);
                case 2: return mod_Momocraft.IndexClothTexture(2);
                case 3: return mod_Momocraft.IndexClothTexture(3);
                case 4: return mod_Momocraft.IndexClothTexture(4);
                case 5: return mod_Momocraft.IndexClothTexture(5);
                case 6: return mod_Momocraft.IndexClothTexture(6);
                case 7: return mod_Momocraft.IndexClothTexture(7);
                case 8: return mod_Momocraft.IndexClothTexture(8);
                case 9: return mod_Momocraft.IndexClothTexture(9);
                case 10: return mod_Momocraft.IndexClothTexture(10);
                case 11: return mod_Momocraft.IndexClothTexture(11);
                case 12: return mod_Momocraft.IndexClothTexture(12);
                case 13: return mod_Momocraft.IndexClothTexture(13);
                case 14: return mod_Momocraft.IndexClothTexture(14);
                case 15: return mod_Momocraft.IndexClothTexture(15);
                }
				return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
        }

        public boolean isOpaqueCube()
        {
			return blockType;
        }       
        
        public boolean renderAsNormalBlock()
        {
            return blockType;
        }

}