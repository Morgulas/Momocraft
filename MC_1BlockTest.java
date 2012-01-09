package net.minecraft.src;

//Dependance neccessaire pour Random
import java.util.Random;

import net.minecraft.src.*;
/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

//Heritage de Block, la classe mère
public class MC_1BlockTest extends Block{

	//Constructeur
	public MC_1BlockTest(int i, int j){	//i=ID du block, j=Textures
	
		super(i, j, Material.rock); 		    //Définition de la classe mère. Material definit le bruit de cassage.
	}
	
	//Methode qui definis le drop du bloc
    public int idDropped(int i, Random random, int j){
    	
        return MC_0Block.BlockTest.blockID;
    }
    
    //Argument blockID pour les blocks
    //Argument ShiftedIndex pour les items
    
    //Methode qui definis la quantité du drop
/*  public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }
*/    

/*Enlever la transparence :


	public boolean isOpaqueCube()
	{
	  return false;
	}
*/
}
