package net.minecraft.src;

//Dependance neccessaire pour Random
import java.util.Random;



//Heritage de Block, la classe m�re
public class MMC_BlockMinefieldPaille extends Block{

	//Constructeur
	public MMC_BlockMinefieldPaille(int i, int j){	//i=ID du block, j=Textures
	
		super(i, j, Material.cactus); 		//D�finition de la classe m�re. Material definit le bruit de cassage?
	}
	
	//Methode qui definis le drop du bloc
	public int idDropped(int i, Random random){
		return this.blockID;
	}
}