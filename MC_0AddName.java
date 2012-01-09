/*
 *  - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */
 
package net.minecraft.src;

public class MC_0AddName {

	public MC_0AddName(){
		
///////////////////////////////////////////////////////////////////////////
//SECTION ADDNAME - Tri pour version Serveur
///////////////////////////////////////////////////////////////////////////        

		//Les Blocs        
		ModLoader.AddName(MC_0Block.BlockTest, "Bloc de test");
		ModLoader.AddName(MC_0Block.BlockPaille, "Bloc de paille");
		ModLoader.AddName(MC_0Block.BlockArdoise, "Bloc en ardoise");
		ModLoader.AddName(MC_0Block.BlockGlowstonePure, "Glowstone pur");
		ModLoader.AddName(MC_0Block.BlockLanterneGlowstone, "Lanterne en glowstone");
		ModLoader.AddName(MC_0Block.BlockLanterneGlowstonePure, "Lanterne en glowstone purifié");
		ModLoader.AddName(MC_0Block.BlockEscalierPaille, "Escalier en paille");
		ModLoader.AddName(MC_0Block.BlockEscalierArdoise, "Escalier en ardoise");
		ModLoader.AddName(MC_0Block.BlockHerbeLumineuse, "Herbe lumineuse");
		
		ModLoader.AddName(MC_0Block.BlockEscalierStone, "Escalier en stone");
		ModLoader.AddName(MC_0Block.BlockEscalierStonePolie, "Escalier en stone polie");
		ModLoader.AddName(MC_0Block.BlockEscalierLog, "Escalier en bois brut");

		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalle, 1, 0), "Dalle en stone");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalle, 1, 1), "Dalle en bois brut");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalle, 1, 2), "Dalle en paille");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalle, 1, 3), "Dalle en ardoise");
		
//		ModLoader.AddName(MC_0Block.BlockDalleStone, "Dalle en stone");
//		ModLoader.AddName(MC_0Block.BlockDalleLog, "Dalle en bois brut");
//		ModLoader.AddName(MC_0Block.BlockDallePaille, "Dalle en paille");
//		ModLoader.AddName(MC_0Block.BlockDalleArdoise, "Dalle en ardoise");
		
		ModLoader.AddName(MC_0Block.BlockPlaqueDiamond, "Plaque en diamant");
		ModLoader.AddName(MC_0Block.BlockPlaqueGlass, "Plaque en verre");
		ModLoader.AddName(MC_0Block.BlockPlaqueGlowStone, "Plaque en rayonnite");
		ModLoader.AddName(MC_0Block.BlockPlaqueGold, "Plaque en or");
		ModLoader.AddName(MC_0Block.BlockPlaqueIce, "Plaque en glace");
		ModLoader.AddName(MC_0Block.BlockPlaqueLapis, "Plaque en lapis");
		ModLoader.AddName(MC_0Block.BlockPlaqueObsidian, "Plaque en obsidienne");
		ModLoader.AddName(MC_0Block.BlockPlaquePlanks, "Plaque en planche");
		ModLoader.AddName(MC_0Block.BlockPlaqueSandStone, "Plaque en gres");
		ModLoader.AddName(MC_0Block.BlockPlaqueSteel, "Plaque en fer");
		ModLoader.AddName(MC_0Block.BlockPlaqueStone, "Plaque en pierre");
		
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth0, "Plaque en laine blanche");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth1, "Plaque en laine orange");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth2, "Plaque en laine magenta");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth3, "Plaque en laine bleu ciel");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth4, "Plaque en laine jaune");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth5, "Plaque en laine vert lime");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth6, "Plaque en laine rose");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth7, "Plaque en laine grise");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth8, "Plaque en laine gris clair");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth9, "Plaque en laine cyan");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth10, "Plaque en laine violette");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth11, "Plaque en laine bleue");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth12, "Plaque en laine marron");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth13, "Plaque en laine verte");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth14, "Plaque en laine rouge");
		ModLoader.AddName(MC_0Block.BlockPlaqueCloth15, "Plaque en laine noire");
		
        ModLoader.AddName(MC_0Block.BlockEscalierCloth0, "Escalier en laine blanche");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth1, "Escalier en laine orange");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth2, "Escalier en laine magenta");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth3, "Escalier en laine bleu ciel");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth4, "Escalier en laine jaune");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth5, "Escalier en laine vert limé");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth6, "Escalier en laine rose");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth7, "Escalier en laine grise");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth8, "Escalier en laine gris clair");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth9, "Escalier en laine cyan");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth10, "Escalier en laine violette");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth11, "Escalier en laine bleue");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth12, "Escalier en laine marron");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth13, "Escalier en laine verte");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth14, "Escalier en laine rouge");
        ModLoader.AddName(MC_0Block.BlockEscalierCloth15, "Escalier en laine noire");
		
		//Arche
		ModLoader.AddName(MC_0Block.BlockArcheStep, "Arche en stone polie");
		ModLoader.AddName(MC_0Block.BlockArcheSandstone, "Arche en sandstone");
		ModLoader.AddName(MC_0Block.BlockArchePlank, "Arche en planche");
		ModLoader.AddName(MC_0Block.BlockArcheCobblestone, "Arche en cobblestone");
		ModLoader.AddName(MC_0Block.BlockArcheBrick, "Arche en brique");
		ModLoader.AddName(MC_0Block.BlockArcheStonebrick, "Arche en stonebrick");
		ModLoader.AddName(MC_0Block.BlockArcheStone, "Arche en stone");
		ModLoader.AddName(MC_0Block.BlockArcheLog, "Arche en bois brut");
		ModLoader.AddName(MC_0Block.BlockArchePaille, "Arche en paille");
		ModLoader.AddName(MC_0Block.BlockArcheArdoise, "Arche en ardoise");
		
		//Muret
		ModLoader.AddName(MC_0Block.BlockMuretStep, "Muret en stone polie");
		ModLoader.AddName(MC_0Block.BlockMuretSandstone, "Muret en sandstone");
		ModLoader.AddName(MC_0Block.BlockMuretPlank, "Muret en planche");
		ModLoader.AddName(MC_0Block.BlockMuretCobblestone, "Muret en cobblestone");
		ModLoader.AddName(MC_0Block.BlockMuretBrick, "Muret en brique");
		ModLoader.AddName(MC_0Block.BlockMuretStoneBrick, "Muret en stonebrick");
		ModLoader.AddName(MC_0Block.BlockMuretStone, "Muret en stone");

		//Dalle de plafond
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 0), "Dalle de plafond en stone polie");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 1), "Dalle de plafond en sandstone");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 2), "Dalle de plafond en planche");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 3), "Dalle de plafond en cobblestone");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 4), "Dalle de plafond en brick");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 5), "Dalle de plafond en stonebrick");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 6), "Dalle de plafond en stone");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 7), "Dalle de plafond en bois brut");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 8), "Dalle de plafond en paille");
		ModLoader.AddName(new ItemStack(MC_0Block.BlockDalleSup, 1, 9), "Dalle de plafond en ardoise");
		
		ModLoader.AddName(MC_0Block.BlockBarriereFer, "Barrière de fer");
		
		ModLoader.AddName(MC_0Block.BlockTrampoline, "Trampoline");
		ModLoader.AddName(MC_0Block.BlockNuage, "Nuage/Fumée");
		ModLoader.AddName(MC_0Block.BlockHerse, "Herse");
		ModLoader.AddName(MC_0Block.BlockTonneau, "Tonneau");
		ModLoader.AddName(MC_0Block.BlockChaine, "Chaine");
		ModLoader.AddName(MC_0Block.BlockPortail, "Portail");

        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 0), "Bloc de verre orange");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 1), "Bloc de verre blanc");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 2), "Bloc de verre rouge");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 3), "Bloc de verre noir");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 4), "Bloc de verre vert foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 5), "Bloc de verre brun");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 6), "Bloc de verre bleu foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 7), "Bloc de verre violet");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 8), "Bloc de verre bleu clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 9), "Bloc de verre gris clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 10), "Bloc de verre gris foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 11), "Bloc de verre rose");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 12), "Bloc de verre vert clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 13), "Bloc de verre jaune");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 14), "Bloc de verre turquoise");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVerre, 1, 15), "Bloc de verre magenta");
		
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 0), "Vitre orange");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 1), "Vitre blanc");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 2), "Vitre rouge");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 3), "Vitre noir");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 4), "Vitre vert foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 5), "Vitre brun");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 6), "Vitre bleu foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 7), "Vitre violet");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 8), "Vitre bleu clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 9), "Vitre gris clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 10), "Vitre gris foncé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 11), "Vitre rose");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 12), "Vitre vert clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 13), "Vitre jaune");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 14), "Vitre turquoise");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockVitre, 1, 15), "Vitre magenta");
        
		ModLoader.AddName(MC_0Block.BlockCouverts, "Couverts");
		
		ModLoader.AddName(MC_0Block.BlockHoublon, "Houblon");
		ModLoader.AddName(MC_0Block.BlockRedStone0, "Bloc de Redstone massif");
		
        ModLoader.AddName(new ItemStack(MC_0Block.BlockBucheHory, 1, 0), "Buche couché de chêne");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockBucheHory, 1, 1), "Buche couché de sapin");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockBucheHory, 1, 2), "Buche couché de boulot");
        
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 0), "Dalle en laine blanche");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 1), "Dalle en laine orange");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 2), "Dalle en laine magenta");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 3), "Dalle en laine bleu ciel");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 4), "Dalle en laine jaune");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 5), "Dalle en laine verte limé");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 6), "Dalle en laine rose");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 7), "Dalle en laine grise");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 8), "Dalle en laine gris clair");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 9), "Dalle en laine cyan");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 10), "Dalle en laine violette");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 11), "Dalle en laine bleue");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 12), "Dalle en laine marron");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 13), "Dalle en laine verte");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 14), "Dalle en laine rouge");
        ModLoader.AddName(new ItemStack(MC_0Block.BlockStepCloth, 1, 15), "Dalle en laine noire");
        
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 0), "Feu d'artifice de couleur 1");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 1), "Feu d'artifice de couleur 2");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 2), "Feu d'artifice de couleur 3");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 3), "Feu d'artifice de couleur 4");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 4), "Feu d'artifice de couleur 5");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 5), "Feu d'artifice de couleur 6");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 6), "Feu d'artifice de couleur 7");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 7), "Feu d'artifice de couleur 8");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 8), "Feu d'artifice de couleur 9");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 9), "Feu d'artifice de couleur 10");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 10), "Feu d'artifice de couleur 11");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 11), "Feu d'artifice de couleur 12");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 12), "Feu d'artifice de couleur 13");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 13), "Feu d'artifice de couleur 14");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 14), "Feu d'artifice de couleur 15");
//        ModLoader.AddName(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 15), "Feu d'artifice de couleur 16");
        
		
		//Les Items
		ModLoader.AddName(MC_0Item.ItemTest, "Item de test");
		ModLoader.AddName(MC_0Item.ItemLingotObsidienne, "Lingot d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiPioche, "Pioche d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiPelle, "Pelle d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiHache, "Hache d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiBeche, "Beche d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiEpee, "Epée d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiCasque, "Casque d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiPlastron, "Plastron d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiJambieres, "Jambières d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemObsiBottes, "Bottes d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemBarreFer, "Barre de fer");
		ModLoader.AddName(MC_0Item.ItemCerclageFer, "Cerclage de fer");
		ModLoader.AddName(MC_0Item.ItemBarreOr, "Barre d'or");
		ModLoader.AddName(MC_0Item.ItemCerclageOr, "Cerclage d'or");
		ModLoader.AddName(MC_0Item.ItemBarreObsi, "Barre d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemCerclageObsi, "Cerclage d'obsidienne");
		ModLoader.AddName(MC_0Item.ItemRail, "Rails");
		ModLoader.AddName(MC_0Item.ItemCharniere, "Charnière");
		
		ModLoader.AddName(MC_0Item.ItemBagWE, "Baguette WorldEdit");
		ModLoader.AddName(MC_0Item.ItemBagVoxel1, "Baguette Voxel Sniper");
		ModLoader.AddName(MC_0Item.ItemBagVoxel2, "Baguette Voxel Powder");
		ModLoader.AddName(MC_0Item.ItemMapWG, "Carte des propriétés");
		ModLoader.AddName(MC_0Item.ItemMapLog1, "Carte de griefer précise");
		ModLoader.AddName(MC_0Item.ItemMapLog2, "Carte de griefer environnent");

		ModLoader.AddName(MC_0Item.ItemHoublon, "Houblon récolté");
		
		ModLoader.AddName(MC_0Item.ItemCapeLaineOrange, "Cape de laine orange");
		ModLoader.AddName(MC_0Item.ItemCapeLaineBlanche, "Cape de laine blanche");
		ModLoader.AddName(MC_0Item.ItemCapeLaineRouge, "Cape de laine rouge");
		ModLoader.AddName(MC_0Item.ItemCapeLaineNoire, "Cape de laine noire");
		ModLoader.AddName(MC_0Item.ItemCapeLaineKaki, "Cape de laine kaki");
		ModLoader.AddName(MC_0Item.ItemCapeLaineMarron, "Cape de laine marron");
		ModLoader.AddName(MC_0Item.ItemCapeLaineBleu, "Cape de laine bleu");
		ModLoader.AddName(MC_0Item.ItemCapeLaineViolette, "Cape de laine violette");
		ModLoader.AddName(MC_0Item.ItemCapeLaineCyan, "Cape de laine cyan");
		ModLoader.AddName(MC_0Item.ItemCapeLaineGrisClair, "Cape de laine grise claire");
		ModLoader.AddName(MC_0Item.ItemCapeLaineGris, "Cape de laine grise");
		ModLoader.AddName(MC_0Item.ItemCapeLaineRose, "Cape de laine rose");
		ModLoader.AddName(MC_0Item.ItemCapeLaineVerte, "Cape de laine verte");
		ModLoader.AddName(MC_0Item.ItemCapeLaineJaune, "Cape de laine jaune");
		ModLoader.AddName(MC_0Item.ItemCapeLaineBleuClair, "Cape de laine bleu claire");
		ModLoader.AddName(MC_0Item.ItemCapeLaineMagenta, "Cape de laine magenta");
		
		ModLoader.AddName(MC_0Item.ItemPileOrange, "Verre pilé orange");
		ModLoader.AddName(MC_0Item.ItemPileBlanche, "Verre pilé blanc");
		ModLoader.AddName(MC_0Item.ItemPileRouge, "Verre pilé rouge");
		ModLoader.AddName(MC_0Item.ItemPileNoire, "Verre pilé noir");
		ModLoader.AddName(MC_0Item.ItemPileKaki, "Verre pilé kaki");
		ModLoader.AddName(MC_0Item.ItemPileMarron, "Verre pilé marron");
		ModLoader.AddName(MC_0Item.ItemPileBleu, "Verre pilé bleu");
		ModLoader.AddName(MC_0Item.ItemPileViolette, "Verre pilé violet");
		ModLoader.AddName(MC_0Item.ItemPileCyan, "Verre pilé cyan");
		ModLoader.AddName(MC_0Item.ItemPileGrisClair, "Verre pilé gris clair");
		ModLoader.AddName(MC_0Item.ItemPileGris, "Verre pilé gris");
		ModLoader.AddName(MC_0Item.ItemPileRose, "Verre pilé rose");
		ModLoader.AddName(MC_0Item.ItemPileVerte, "Verre pilé verte");
		ModLoader.AddName(MC_0Item.ItemPileJaune, "Verre pilé jaune");
		ModLoader.AddName(MC_0Item.ItemPileBleuClair, "Verre pilé bleu clair");
		ModLoader.AddName(MC_0Item.ItemPileMagenta, "Verre pilé magenta");

	}
}