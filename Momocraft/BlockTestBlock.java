package net.minecraft.src.Momocraft;

//Dependance neccessaire pour Random
import java.util.Random;

import net.minecraft.src.*;


//Heritage de Block, la classe m�re
public class BlockTestBlock extends Block{

	//Constructeur
	public BlockTestBlock(int i, int j){	//i=ID du block, j=Textures
	
		super(i, j, Material.rock); 		//D�finition de la classe m�re. Material definit le bruit de cassage.
	}
	
	//Methode qui definis le drop du bloc
    public int idDropped(int i, Random random, int j){
    	
        return MomocraftBlocks.BlockAetherZanite.blockID;
    }
    
    //Argument blockID pour les blocks
    //Argument ShiftedIndex pour les items
    
    //Methode qui definis la quantit� du drop
/*  public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }
*/    
}
