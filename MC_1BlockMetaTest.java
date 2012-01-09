package net.minecraft.src;

import java.util.Random;

public class MC_1BlockMetaTest extends Block {
        
        public MC_1BlockMetaTest(int id) {
                super(id, Material.iron);
                
                this.setHardness(1.0F);
                this.setResistance(1F);
                this.setStepSound(Block.soundClothFootstep);
                this.setBlockName("Multifaceted");
        }

        public int idDropped(int metadata, Random random) {
                return blockID;
        }

        protected int damageDropped(int metadata) {
                return metadata;
        }


        /**
        *
        * Pick one of the following 3 code blocks.
        *
        */

        // If you use metadata to change the texture of the block.
        public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
                switch (metadata){
                case 0: return MC_0Textures.bLogSide1;
                case 1: return MC_0Textures.bLogSide2;
                case 2: return MC_0Textures.bLogSide3;
                //etc. etc.
                }
				return this.blockIndexInTexture = Block.wood.blockIndexInTexture;
        }

        // If you use the side of the block but not metadata.
        public int getBlockTextureFromSide(int side){
               switch (side){
               case 0: return MC_0Textures.bLogSide1;
               case 1: return MC_0Textures.bLogSide2;
               case 2: return MC_0Textures.bLogSide3;
               //etc. etc.
               }
        

        return this.blockIndexInTexture = Block.wood.blockIndexInTexture;

        }          
}