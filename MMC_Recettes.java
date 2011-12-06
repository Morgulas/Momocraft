package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_Recettes {
	
	public MMC_Recettes(){
//-----------------------------------------------------
// Exemples et objets de test
//-----------------------------------------------------
	//Bloc de test
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftTestBlock, 1), new Object[]{ 	//Reslutat de la recette en terme de stack
		"I", 																						//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
		Character.valueOf('I'), Item.stick															//Attribution du caractère I a sa correspondance
	});


	//Item de test
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMomocraftTestItem, 1), new Object[]{ 		//Reslutat de la recette en terme de stack
		"III", " I ", " I ", 																		//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
		Character.valueOf('I'), Block.mycelium														//Attribution du caractère I a sa correspondance
	});
	
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftFence1, 1), new Object[]{ "II", Character.valueOf('I'), Block.dirt });
	
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueDiamond, 2), new Object[] { "##", Character.valueOf('#'), Item.diamond });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueGlass, 8), new Object[] { "#", Character.valueOf('#'), Block.glass });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueGlowStone, 8), new Object[] { "#", Character.valueOf('#'), Block.glowStone });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueGold, 2), new Object[] { "##", Character.valueOf('#'), Item.ingotGold });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueIce, 8), new Object[] { "#", Character.valueOf('#'), Block.ice });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueLapis, 2), new Object[] { "##", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 4) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueObsidian, 8), new Object[] { "#", Character.valueOf('#'), Block.obsidian });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaquePlanks, 8), new Object[] { "#", Character.valueOf('#'), Block.planks });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueSandStone, 8), new Object[] { "#", Character.valueOf('#'), Block.sandStone });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueSteel, 2), new Object[] { "##", Character.valueOf('#'), Item.ingotIron });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueStone, 8), new Object[] { "#", Character.valueOf('#'), Block.stone });
	
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth0, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth1, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth2, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth3, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth4, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth5, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth6, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth7, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth8, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth9, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth10, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth11, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth12, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth13, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth14, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMomocraftPlaqueCloth15, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });

    ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMomocraftCharniere, 4), new Object[] { "#", "#", Character.valueOf('#'), Item.ingotIron });
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMomocraftRail, 4), new Object[] { "##", "##", Character.valueOf('#'), Item.ingotIron });

//-------------------------------------------
// Minefield
//-------------------------------------------	
	
	// Recettes des blocs
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockMinefieldPaille, 1), new Object[]{ "#", Character.valueOf('#'), Block.dirt });
	
	// Recettes des items
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldBierre, 1), new Object[]{ "III", " I ", " I ", Character.valueOf('I'), Item.stick	});
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldBarreDeFer, 1), new Object[]{ "I I", "I I", "III", Character.valueOf('I'), Block.wood });	
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldObsiEpee, 1), new Object[]{ " # ", " # ", " I ", Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer,Character.valueOf('#'), MMC_Item.ItemMinefieldObsidienneIngot});	
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldObsiPioche, 1), new Object[]{ "###", " I ", " I ", Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer,Character.valueOf('#'), MMC_Item.ItemMinefieldObsidienneIngot});
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldObsiPelle, 1), new Object[]{ " # ", " I ", " I ",Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer,Character.valueOf('#'), MMC_Item.ItemMinefieldObsidienneIngot});
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldObsiHache, 1), new Object[]{ "## ", "#I ", " I ",Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer,Character.valueOf('#'), MMC_Item.ItemMinefieldObsidienneIngot});	
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldObsiBeche, 1), new Object[]{ 	"## ", " I ", " I ",Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer,Character.valueOf('#'), MMC_Item.ItemMinefieldObsidienneIngot});	
//	ModLoader.AddRecipe(new ItemStack(MomocraftItems.ItemMinefieldObsidienneIngot, 1), new Object[]{"II",Character.valueOf('I'), Item.stick});	
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldCerclageFer, 2), new Object[]{ "III", "I I", "III",Character.valueOf('I'), MMC_Item.ItemMinefieldBarreDeFer});	
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemMinefieldCarte, 1), new Object[]{ 	"II", "II",Character.valueOf('I'), Item.stick});	
//	ModLoader.AddRecipe(new ItemStack(MomocraftItems.ItemMinefieldRideauBlanc, 1), new Object[]{ "II", "II",Character.valueOf('I'), Block.whiteStone});	
	
//-------------------------------------------
// Aether Mod
//-------------------------------------------
	
	// Recettes des blocs
	ModLoader.AddRecipe(new ItemStack(MMC_Block.BlockAetherZaniteOre, 1), new Object[]{ "##", Character.valueOf('#'), Block.dirt });
	
	// Recettes des items
	ModLoader.AddRecipe(new ItemStack(MMC_Item.ItemAetherHammerNotch, 1), new Object[]{ "I", "I",Character.valueOf('I'), Block.dirt });
	
	
	}
	
}
