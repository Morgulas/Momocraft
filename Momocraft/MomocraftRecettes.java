package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class MomocraftRecettes {
	
	public MomocraftRecettes(){
//-----------------------------------------------------
// Exemples et objets de test
//-----------------------------------------------------
	/*Bloc de test*/	
	ModLoader.AddRecipe(new ItemStack(MomocraftBlocks.TestBlock, 1), new Object[]{ 	//Reslutat de la recette en terme de stack
		"I", 																		//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
		Character.valueOf('#'), Block.cobblestone, 									//Attribution du caractère # a sa correspondance
		Character.valueOf('I'), Item.stick											//Attribution du caractère I a sa correspondance
	});
	
	/*Item de test
	ModLoader.AddRecipe(new ItemStack(TFBlocks.portal, 1), new Object[]{ 	//Reslutat de la recette en terme de stack
		"III", " I ", " I ", 														//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
		Character.valueOf('I'), Block.mycelium	
	});*/
	
//-----------------------------------------------------
// Recettes des blocs
//-----------------------------------------------------	
	
	/*Bloc de paille
	ModLoader.AddRecipe(new ItemStack(MomocraftBlocks.BlockAetherPortal, 1), new Object[]{ 
		"#",											
		Character.valueOf('#'), Block.dirt							
	});
	*/
	ModLoader.AddRecipe(new ItemStack(MomocraftBlocks.BlockAetherGravititeOre, 1), new Object[]{ 
		"#",											
		Character.valueOf('#'), Block.dirt							
	});
	
	
//-----------------------------------------------------
// Recettes des items
//-----------------------------------------------------	
	
	/*Epée d'obsidienne*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.ObsiSword, 1), new Object[]{ 	
		"III", " I ", " I ", 										
		Character.valueOf('I'), Item.stick			
	});
	
	/*Chope de bière*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.Chope, 1), new Object[]{ 		
		"I I", "I I", "III", 										
		Character.valueOf('I'), Block.wood							
		
	});	
	
	/*Barre de fer*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.IronBar, 1), new Object[]{ 	
		"I", "I",													
		Character.valueOf('I'), Item.ingotIron
		
	});	
	
	/*Casque d'obsidienne*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.CasqueObsi, 1), new Object[]{ 	
		"I",															
		Character.valueOf('I'), Item.stick
	});
	
	/*Armure d'Obsidienne*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.ArmureObsi, 1), new Object[]{
		"II",
		Character.valueOf('I'), Item.stick
	});
	
	/*Jambières d'obsidienne*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.JambeObsi, 1), new Object[]{ 
		"III",
		Character.valueOf('I'), Item.stick
	});	
	
	/*Bottes d'obsidienne*/
	ModLoader.AddRecipe(new ItemStack(MomocraftItems.PiedObsi, 1), new Object[]{ 	
		"II", "II",
		Character.valueOf('I'), Item.stick
	});	
	
	}
	
}
