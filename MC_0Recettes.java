/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

import net.minecraft.src.*;

public class MC_0Recettes {
	
	public MC_0Recettes()
	{
        loadArmurier();
        loadSoufleurDeVerre();        
        loadBase();
	}
	
//-----------------------------------------------------
// Exemples et objets de test
//-----------------------------------------------------

		//Bloc de test
//		ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierPaille, 1), new Object[]{ 	//Reslutat de la recette en terme de stack
//			"I", 																	//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
//			Character.valueOf('I'), Block.dirt										//Attribution du caractère I a sa correspondance
//		});


		//Item de test
//		ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemTest, 1), new Object[]{ 		//Reslutat de la recette en terme de stack
//			"II",																	//Matrice de creation dans l'établi. Le premiere ligne represente la ligne du haut dans l'établi
//			Character.valueOf('I'), Block.dirt										//Attribution du caractère I a sa correspondance
//		});
		
	    
	
    public static void loadArmurier()
    {
    	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiCasque, 1), new Object[]{"###","# #","   ", Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
    	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiPlastron, 1), new Object[]{"# #","###","###",	Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
    	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiJambieres, 1), new Object[]{"###","# #","# #", Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
    	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiBottes, 1), new Object[]{"   ","# #","# #", Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
    }
	
    public static void loadSoufleurDeVerre()
    {
        ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockLanterneGlowstone, 1), new Object[] {" X ", "X#X", " X ", Character.valueOf('#'), Block.glowStone, Character.valueOf('X'), MC_0Item.ItemCerclageFer});
        ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockLanterneGlowstonePure, 1), new Object[] {" X ", "X#X", " X ", Character.valueOf('#'), MC_0Block.BlockGlowstonePure, Character.valueOf('X'), MC_0Item.ItemCerclageFer});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileOrange, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 14)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileBlanche, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 15)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileRouge, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileNoire, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileKaki, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileMarron, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileBleu, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileViolette, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileCyan, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileGrisClair, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 7)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileGris, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 8)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileRose, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 9)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileVerte, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 10)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileJaune, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 11)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileBleuClair, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 12)});
        ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemPileMagenta, 1), new Object[] {"C", "V", Character.valueOf('V'), new ItemStack(Block.glass, 1), Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 13)});

//        for(int i = 0; i < 16; i++)
//        {
//            ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockVitre, 8, i), new Object[] {"VVV", "VVV", Character.valueOf('V'), new ItemStack(MC_0Block.BlockVerre, 1, i)});
//        }
        
    }

//-----------------------------------------------------
// Les Blocs
//-----------------------------------------------------  
    public static void loadBase()
    {
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPaille, 1), new Object[]{"II","II", Character.valueOf('I'), Item.wheat });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArdoise, 1), new Object[]{"II","II", Character.valueOf('I'), Item.flint });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierPaille, 1), new Object[]{"  I"," II","III", Character.valueOf('I'), MC_0Block.BlockPaille });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierArdoise, 1), new Object[]{"  I"," II","III", Character.valueOf('I'), MC_0Block.BlockArdoise });
	
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueDiamond, 2), new Object[] { "##", Character.valueOf('#'), Item.diamond });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueGlass, 8), new Object[] { "#", Character.valueOf('#'), Block.glass });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueGlowStone, 8), new Object[] { "#", Character.valueOf('#'), Block.glowStone });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueGold, 2), new Object[] { "##", Character.valueOf('#'), Item.ingotGold });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueIce, 8), new Object[] { "#", Character.valueOf('#'), Block.ice });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueLapis, 2), new Object[] { "##", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 4) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueObsidian, 8), new Object[] { "#", Character.valueOf('#'), Block.obsidian });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaquePlanks, 8), new Object[] { "#", Character.valueOf('#'), Block.planks });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueSandStone, 8), new Object[] { "#", Character.valueOf('#'), Block.sandStone });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueSteel, 2), new Object[] { "##", Character.valueOf('#'), Item.ingotIron });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueStone, 8), new Object[] { "#", Character.valueOf('#'), Block.stone });

	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth0, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth1, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth2, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth3, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth4, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth5, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth6, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth7, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth8, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth9, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth10, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth11, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth12, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth13, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth14, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockPlaqueCloth15, 8), new Object[] { "#", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });
	
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth0, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth1, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth2, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth3, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth4, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth5, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth6, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth7, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth8, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth9, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth10, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth11, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth12, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth13, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth14, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockEscalierCloth15, 4), new Object[] { "  #", " ##", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });

	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArcheCobblestone, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), Block.cobblestone });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArcheStone, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), Block.stone });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArcheStonebrick, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), Block.stoneBrick });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArchePlank, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), Block.planks });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArchePaille, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), MC_0Block.BlockPaille });
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockArcheArdoise, 4), new Object[] { "###", " ##", "  #", Character.valueOf('#'), MC_0Block.BlockArdoise });
	
//-----------------------------------------------------
// Les Items
//-----------------------------------------------------
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiPioche, 1), new Object[]{"###"," I "," I ", Character.valueOf('I'), MC_0Item.ItemBarreFer, Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiPelle, 1), new Object[]{" # "," I "," I ", Character.valueOf('I'), MC_0Item.ItemBarreFer, Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiHache, 1), new Object[]{"## ","#I "," I ", Character.valueOf('I'), MC_0Item.ItemBarreFer, Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiBeche, 1), new Object[]{"## "," I "," I ", Character.valueOf('I'), MC_0Item.ItemBarreFer, Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemObsiEpee, 1), new Object[]{" # "," # "," I ",	Character.valueOf('I'), MC_0Item.ItemBarreFer, Character.valueOf('#'), MC_0Item.ItemLingotObsidienne });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemBarreFer, 4), new Object[]{" I"," I", Character.valueOf('I'), Item.ingotIron });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemCerclageFer, 4), new Object[]{"III","I I","III",Character.valueOf('I'), MC_0Item.ItemBarreFer });
	
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemCharniere, 4), new Object[] { "#", "#", Character.valueOf('#'), Item.ingotIron });
	ModLoader.AddRecipe(new ItemStack(MC_0Item.ItemRail, 4), new Object[] { "##", "##", Character.valueOf('#'), Item.ingotIron });
	
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockBucheHory, 2, 0), new Object[] {"##", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0)});
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockBucheHory, 2, 1), new Object[] {"##", Character.valueOf('#'), new ItemStack(Block.wood, 1, 1)});
	ModLoader.AddRecipe(new ItemStack(MC_0Block.BlockBucheHory, 2, 2), new Object[] {"##", Character.valueOf('#'), new ItemStack(Block.wood, 1, 2)});
	
	}
	
}	
