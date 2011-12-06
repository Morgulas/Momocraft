package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_BlockMinefieldArdoise extends Block{
	//Constructeur
		public MMC_BlockMinefieldArdoise(int i, int j){	//i=ID du block, j=Textures
		
			super(i, j, Material.cactus); 		//Définition de la classe mère. Material definit le bruit de cassage?
		}
		
		//Methode qui definis le drop du bloc
		public int idDropped(int i, Random random){
			return this.blockID;
		}
}
