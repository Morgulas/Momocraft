package net.minecraft.src.Momocraft;

//Dependance neccessaire pour Random
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;


//Heritage de Block, la classe m�re
public class BlockPaille extends Block{

	//Constructeur
	public BlockPaille(int i, int j){	//i=ID du block, j=Textures
	
		super(i, j, Material.cactus); 		//D�finition de la classe m�re. Material definit le bruit de cassage?
	}
	
	//Methode qui definis le drop du bloc
	public int idDropped(int i, Random random){
		return this.blockID;
	}
}
