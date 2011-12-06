/*
 * Mod Momocraft - SteveVuillaume
 * 
 * stevevuillaume@gmail.com
 * Pt:1
 * 
 */

package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import net.minecraft.client.Minecraft;

import java.util.*;
import org.lwjgl.opengl.GL11;

//Class du mode qui hérite de BaseMod
public class mod_Momocraft extends BaseModMp{
	
	//Déclaration de variable systèmes
//	public static MomocraftFireworksSkyrocketManager props = new MomocraftFireworksSkyrocketManager();
	    
	//Constructeur
	public mod_Momocraft() {
		
		//Appel des fonctions
		new MMC_Block();
		new MMC_Item();
		new MMC_Mobs();
		new MMC_Recettes();		
		new MMC_Textures();
		
		
///////////////////////////////////////////////////////////////////////////
//SECTION REGISTER ENTITIES
///////////////////////////////////////////////////////////////////////////
		
//-------------------------------------------
// RegisterEntityID
//-------------------------------------------		
		ModLoader.RegisterEntityID(MMC_EntityFloatingBlock.class, null, MMC_ID.idEntityFloatingBlock);
		ModLoader.RegisterTileEntity(MMC_TileEntityPlaque.class, "Plaque");
		
//-------------------------------------------
// RegisterNetClientHandlerEntity (Pour le multi)
//-------------------------------------------
		
		//Fonctions de registration des Entities
		//Coté Client
		ModLoaderMp.RegisterNetClientHandlerEntity(MMC_EntityFloatingBlock.class, MMC_ID.idEntityFloatingBlock);
		
		//Coté Serveur
		//ModLoaderMp.RegisterEntityTrackerEntry(EntityFloatingBlock.class, MomocraftID.idEntityFloatingBlock);
		//ModLoaderMp.RegisterEntityTracker(EntityFloatingBlock.class, 160, 5);				//Le 5 correspont au Tick du jeu, c'est a dire 4 fois par seconde
		
		//Exemple
		//ModLoaderMp.RegisterEntityTrackerEntry(MoCEntityKittyBed.class, 200);
		//ModLoaderMp.RegisterEntityTracker(MoCEntityKittyBed.class, 160, 5);
		
///////////////////////////////////////////////////////////////////////////
//	SECTION REGISTERBLOCK
///////////////////////////////////////////////////////////////////////////

//-------------------------------------------
// Momocraft
//-------------------------------------------
		
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftTestBlock);				//Registration d'un bloc
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMomocraftFeuArtifice);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftFence1);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftStairs1);
        
		
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueDiamond);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueGlass);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueGlowStone);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueGlowStoneLight);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueGold);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueIce);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueLapis);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueObsidian);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaquePlanks);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueSandStone);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueSteel);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueStone);
		
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth0);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth1);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth2);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth3);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth4);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth5);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth6);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth7);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth8);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth9);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth10);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth11);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth12);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth13);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth14);
		ModLoader.RegisterBlock(MMC_Block.BlockMomocraftPlaqueCloth15);
		
//-------------------------------------------
// Minefield
//-------------------------------------------
		
        ModLoader.RegisterBlock(MMC_Block.BlockMinefieldArdoise);	
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldBancCentre);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldBancPied);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldBarriereFer);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldChaine);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldChaise);
        
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldCouverts);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldEtagere);
        
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldGlowstonePure);	
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldGobeur);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldHerse);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldHoublon);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldLanterne);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldLanterneEteinte);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldList);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldNappe);
        ModLoader.RegisterBlock(MMC_Block.BlockMinefieldPaille);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldPoulie);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldPoulieMoving);
        
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldSupportMural);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTableBasse);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTableCentre);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTablePied);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTablePlateau);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTabouret);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldTonneau);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldVerreColo);
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockMinefieldVitreColo);
      
//-------------------------------------------
// Aether Mod
//-------------------------------------------
		
        ModLoader.RegisterBlock(MMC_Block.BlockAetherPortal);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherDirt);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherGrass);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherQuicksoil);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherHolystone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherIcestone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherAercloud);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherAerogel);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherEnchanter);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherIncubator);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherLog);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherPlank);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherSkyrootLeaves);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherGoldenOakLeaves);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherSkyrootSapling);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherGoldenOakSapling);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherAmbrosiumOre);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherAmbrosiumTorch);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherZaniteOre);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherGravititeOre);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherEnchantedGravitite);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherTrap);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherChestMimic);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherTreasureChest);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherDungeonStone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherLightDungeonStone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherLockedDungeonStone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherLockedLightDungeonStone);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherPillar);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherZanite);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherQuicksoilGlass);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherFreezer);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherWhiteFlower);								
        ModLoader.RegisterBlock(MMC_Block.BlockAetherPurpleFlower);								
//        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherBed);	
        
///////////////////////////////////////////////////////////////////////////
//	SECTION ADDNAME - Tri pour version Serveur
///////////////////////////////////////////////////////////////////////////        
      
//-------------------------------------------
// Momocraft
//------------------------------------------- 
        
		//Les Blocs        
		ModLoader.AddName(MMC_Block.BlockMomocraftTestBlock, "Bloc de test");		//Rajout d'un nom au bloc
//        ModLoader.AddName(MomocraftBlocks.BlockMomocraftFeuArtifice,"Lanceur de feu");
//		ModLoader.AddName(MomocraftBlocks.BlockMomocraftFence1, "Barriere de test");
//		ModLoader.AddName(MomocraftBlocks.BlockMomocraftStairs1, "Escalier de test");
		
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueDiamond, "Plaque en diamant");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueGlass, "Plaque en verre");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueGlowStone, "Plaque en rayonnite");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueGold, "Plaque en or");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueIce, "Plaque en glace");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueLapis, "Plaque en lapis");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueObsidian, "Plaque en obsidienne");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaquePlanks, "Plaque en planche");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueSandStone, "Plaque en gres");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueSteel, "Plaque en fer");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueStone, "Plaque en pierre");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth0, "Plaque en laine blanche");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth1, "Plaque en laine orange");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth2, "Plaque en laine magenta");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth3, "Plaque en laine bleu ciel");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth4, "Plaque en laine jaune");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth5, "Plaque en laine vert lime");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth6, "Plaque en laine rose");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth7, "Plaque en laine grise");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth8, "Plaque en laine gris clair");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth9, "Plaque en laine cyan");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth10, "Plaque en laine violette");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth11, "Plaque en laine bleue");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth12, "Plaque en laine marron");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth13, "Plaque en laine verte");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth14, "Plaque en laine rouge");
		ModLoader.AddName(MMC_Block.BlockMomocraftPlaqueCloth15, "Plaque en laine noire");
		
		
		//Les Items
		ModLoader.AddName(MMC_Item.ItemMomocraftTestItem,"Item de test");						//Rajout d'un nom à l'item
        ModLoader.AddName(MMC_Item.ItemMomocraftCharniere, "Charniere");
		ModLoader.AddName(MMC_Item.ItemMomocraftRail, "Rail");
		
//-------------------------------------------
// Minefield
//-------------------------------------------
		
		//Les Blocs		
        ModLoader.AddName(MMC_Block.BlockMinefieldArdoise,"Bloc en ardoise");	
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldBancCentre,"Banc Centre");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldBancPied,"Banc Pied");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldBarriereFer,"Barriere de fer");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldChaine,"Chaine");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldChaise,"Chaise");
        
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldCouverts,"Couverts");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldEtagere,"Etagère");
        
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldGlowstonePure,"Glowstone pure");	
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldGobeur,"Gobeur");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldHerse,"Herse");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldHoublon,"Houblon");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldLanterne,"Lanterne");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldLanterneEteinte,"Lanterne eteinte");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldList,"Liste");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldNappe,"Nappe");*/
        ModLoader.AddName(MMC_Block.BlockMinefieldPaille, "Bloc de paille");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldPoulie,"Poulie");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldPoulieMoving,"Poulie");
        
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldSupportMural,"Support mural");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTableBasse,"Table basse");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTableCentre,"Table Centre");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTablePied,"Table Pied");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTablePlateau,"Table Plateau");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTabouret,"Tabouret");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldTonneau,"Tonneau");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldVerreColo,"Verre Colo");
//        ModLoader.AddName(MomocraftBlocks.BlockMinefieldVitreColo,"Vitre Colo");
        
		//Les Items
		ModLoader.AddName(MMC_Item.ItemMinefieldBierre,"Chope de bière");
		ModLoader.AddName(MMC_Item.ItemMinefieldBarreDeFer,"Barre de fer");
		ModLoader.AddName(MMC_Item.ItemMinefieldObsiEpee,"Epée d'obsidienne");
		ModLoader.AddName(MMC_Item.ItemMinefieldObsiPioche,"Pioche d'obsidienne");
		ModLoader.AddName(MMC_Item.ItemMinefieldObsiPelle,"Pelle d'obsidienne");
		ModLoader.AddName(MMC_Item.ItemMinefieldObsiHache,"Hache d'obsidienne");
		ModLoader.AddName(MMC_Item.ItemMinefieldObsiBeche,"Beche d'obsidienne");	
		ModLoader.AddName(MMC_Item.ItemMinefieldObsidienneIngot,"Lingot d'obsidienne");
		ModLoader.AddName(MMC_Item.ItemMinefieldCerclageFer,"Cerclage de fer");
		ModLoader.AddName(MMC_Item.ItemMinefieldCarte,"Carte aux Trésors");
		
//		  ModLoader.AddName(MomocraftItems.ItemMinefieldRideauBlanc,"Rideau Blanc");	
				
		
		
//-------------------------------------------
// Aether Mod
//-------------------------------------------	
		
		//Les Blocs
		ModLoader.AddName(MMC_Block.BlockAetherPortal, "Bloc du portail vers l'Aether");
		ModLoader.AddName(MMC_Block.BlockAetherDirt, "Terre de l'Aether");
		ModLoader.AddName(MMC_Block.BlockAetherGrass, "Herbe de l'Aether");
		ModLoader.AddName(MMC_Block.BlockAetherQuicksoil, "QuickSoil");
		ModLoader.AddName(MMC_Block.BlockAetherHolystone, "Holystone");
		ModLoader.AddName(MMC_Block.BlockAetherIcestone, "Icestone");
		ModLoader.AddName(MMC_Block.BlockAetherAercloud, "Aercloud");
		ModLoader.AddName(MMC_Block.BlockAetherAerogel, "Aerogel");
//  	  ModLoader.AddName(MomocraftBlocks.BlockAetherEnchanter, "Enchanteur");
//		  ModLoader.AddName(MomocraftBlocks.BlockAetherIncubator, "Incubateur");
		ModLoader.AddName(MMC_Block.BlockAetherLog, "Bois");
		ModLoader.AddName(MMC_Block.BlockAetherPlank, "Planche de bois");
		ModLoader.AddName(MMC_Block.BlockAetherSkyrootLeaves, "Feuilles de Skyroot");
		ModLoader.AddName(MMC_Block.BlockAetherGoldenOakLeaves, "Feuilles d'arbre d'or");
		ModLoader.AddName(MMC_Block.BlockAetherSkyrootSapling, "Pousse de Skyroot");
		ModLoader.AddName(MMC_Block.BlockAetherGoldenOakSapling, "Pousse d'arbre d'or");
		ModLoader.AddName(MMC_Block.BlockAetherAmbrosiumOre, "Minerai d'Ambrosium");
		ModLoader.AddName(MMC_Block.BlockAetherAmbrosiumTorch, "Torche d'Ambrosium");
		ModLoader.AddName(MMC_Block.BlockAetherZaniteOre, "Minerai de Zanite");
		ModLoader.AddName(MMC_Block.BlockAetherGravititeOre, "Minerai de Gravitite");
		ModLoader.AddName(MMC_Block.BlockAetherEnchantedGravitite, "Gravitite enchantée");
		ModLoader.AddName(MMC_Block.BlockAetherTrap, "Piège");
//		  ModLoader.AddName(MomocraftBlocks.BlockAetherChestMimic, "Coffre");
//		  ModLoader.AddName(MomocraftBlocks.BlockAetherTreasureChest, "Coffre à trésor");
		ModLoader.AddName(MMC_Block.BlockAetherDungeonStone, "Pierre de donjon");
		ModLoader.AddName(MMC_Block.BlockAetherLightDungeonStone, "Pierre de donjon lumineuse");
		ModLoader.AddName(MMC_Block.BlockAetherLockedDungeonStone, "Pierre de donjon verrouillée");
		ModLoader.AddName(MMC_Block.BlockAetherLockedLightDungeonStone, "Pierre de donjon lumineuse verrouillée");
		ModLoader.AddName(MMC_Block.BlockAetherPillar, "Pillier");
		ModLoader.AddName(MMC_Block.BlockAetherZanite, "Block de Zanite");
		ModLoader.AddName(MMC_Block.BlockAetherQuicksoilGlass, "QuicksoilGlass");
//		  ModLoader.AddName(MomocraftBlocks.BlockAetherFreezer, "Freezer");
		ModLoader.AddName(MMC_Block.BlockAetherWhiteFlower, "Fleur blanche");
		ModLoader.AddName(MMC_Block.BlockAetherPurpleFlower, "Fleur violette");
//		  ModLoader.AddName(MomocraftBlocks.BlockAetherBed, "Lit");
		
		//Les Items
		ModLoader.AddName(MMC_Item.ItemAetherVictoryMedal,"Médaille de victoire");	
		ModLoader.AddName(MMC_Item.ItemAetherKey,"Clé");	
		ModLoader.AddName(MMC_Item.ItemAetherLoreBook,"Livre d'histoire");	
		ModLoader.AddName(MMC_Item.ItemAetherMoaEgg,"Oeuf de Moa");	
		ModLoader.AddName(MMC_Item.ItemAetherBlueMusicDisk,"Disque Bleu");	
		ModLoader.AddName(MMC_Item.ItemAetherGoldenAmber,"Ambre doré");	
		ModLoader.AddName(MMC_Item.ItemAetherAechorPetal,"Pétale d'Aechor");	
		ModLoader.AddName(MMC_Item.ItemAetherStick,"Baton de l'Aether");	
		ModLoader.AddName(MMC_Item.ItemAetherDart,"Dard");	
		ModLoader.AddName(MMC_Item.ItemAetherDartShooter,"Sarbacane");	
		ModLoader.AddName(MMC_Item.ItemAetherAmbrosiumShard,"Echarde d'Ambrosium");	
		ModLoader.AddName(MMC_Item.ItemAetherZanite,"Zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherBucket,"Sot");	
		ModLoader.AddName(MMC_Item.ItemAetherPickSkyroot,"Pioche en Skyroot");	
		ModLoader.AddName(MMC_Item.ItemAetherPickHolystone,"Pioche en Holystone");	
		ModLoader.AddName(MMC_Item.ItemAetherPickZanite,"Pioche en Zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherPickGravitite,"Pioche en Gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherShovelSkyroot,"Pelle en Skyroot");	
		ModLoader.AddName(MMC_Item.ItemAetherShovelHolystone,"Pelle en Holystone");	
		ModLoader.AddName(MMC_Item.ItemAetherShovelZanite,"Pelle en Zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherShovelGravitite,"Pelle en Gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherAxeSkyroot,"Hache en Skyroot");	
		ModLoader.AddName(MMC_Item.ItemAetherAxeHolystone,"Hache en Holystone");	
		ModLoader.AddName(MMC_Item.ItemAetherAxeZanite,"Hache en Zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherAxeGravitite,"Hache en Gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordSkyroot,"Epée en Skyroot");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordHolystone,"Epée en Holystone");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordZanite,"Epée en Zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordGravitite,"Epée en Gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherIronBubble,"Bulle de fer");	
		ModLoader.AddName(MMC_Item.ItemAetherPigSlayer,"? de porc");	
		ModLoader.AddName(MMC_Item.ItemAetherVampireBlade,"Lame vampirique");	
		ModLoader.AddName(MMC_Item.ItemAetherNatureStaff,"Nature Staff");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordFire,"Epée enflamée");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordHoly,"Sainte épée");	
		ModLoader.AddName(MMC_Item.ItemAetherSwordLightning,"Epée lumineuse");	
		ModLoader.AddName(MMC_Item.ItemAetherLightningKnife,"Couteau lumineux");	
		ModLoader.AddName(MMC_Item.ItemAetherGummieSwet,"Gummie Swet");	
		ModLoader.AddName(MMC_Item.ItemAetherHammerNotch,"Marteau de Notch");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixBow,"Arc du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherCloudParachute,"Parachute Nuage");	
		ModLoader.AddName(MMC_Item.ItemAetherCloudParachuteGold,"Parachute Nuage d'Or");	
		ModLoader.AddName(MMC_Item.ItemAetherCloudStaff,"CloudStaff");	
		ModLoader.AddName(MMC_Item.ItemAetherLifeShard,"Life Shard");	
		ModLoader.AddName(MMC_Item.ItemAetherGoldenFeather,"Plume d'or");	
		ModLoader.AddName(MMC_Item.ItemAetherLance,"Lance");	
		ModLoader.AddName(MMC_Item.ItemAetherIronRing,"Anneau de fer");	
		ModLoader.AddName(MMC_Item.ItemAetherGoldRing,"Anneau d'or");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteRing,"Anneau de zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherIronPendant,"Pendentif de fer");	
		ModLoader.AddName(MMC_Item.ItemAetherGoldPendant,"Pendentif d'or");	
		ModLoader.AddName(MMC_Item.ItemAetherZanitePendant,"Pendentif de zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherRepShield,"Bouclier de répulsion");	
		ModLoader.AddName(MMC_Item.ItemAetherAetherCape,"Cape de l'Aether");	
		ModLoader.AddName(MMC_Item.ItemAetherLeatherGlove,"Gants en cuir");	
		ModLoader.AddName(MMC_Item.ItemAetherIronGlove,"Gants en fer");	
		ModLoader.AddName(MMC_Item.ItemAetherGoldGlove,"Gants en or");	
		ModLoader.AddName(MMC_Item.ItemAetherDiamondGlove,"Gants en diamand");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteGlove,"Gants en zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteHelmet,"Casque en zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteChestplate,"Armure en zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteLeggings,"Jambières en zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherZaniteBoots,"Bottes en zanite");	
		ModLoader.AddName(MMC_Item.ItemAetherGravititeGlove,"Gants en gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherGravititeHelmet,"Casque en gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherGravititeBodyplate,"Armure en plaque de gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherGravititePlatelegs,"Jambières en plaque de gravitite ");	
		ModLoader.AddName(MMC_Item.ItemAetherGravititeBoots,"Bottes en gravitite");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixGlove,"Gants du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixHelm,"Casque du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixBody,"Armure du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixLegs,"Jambières du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherPhoenixBoots,"Bottes du Phoenix");	
		ModLoader.AddName(MMC_Item.ItemAetherObsidianGlove,"Gants en obsidienne");	
//		  ModLoader.AddName(MomocraftItems.ItemAetherObsidianBody,"Armure en obsidienne");	
//		  ModLoader.AddName(MomocraftItems.ItemAetherObsidianHelm,"Casque en obsidienne");	
//		  ModLoader.AddName(MomocraftItems.ItemAetherObsidianLegs,"Jambières en obsidienne");	
//		  ModLoader.AddName(MomocraftItems.ItemAetherObsidianBoots,"Bottes en obsidienne");	
		ModLoader.AddName(MMC_Item.ItemAetherNeptuneGlove,"Gants de Neptune");	
		ModLoader.AddName(MMC_Item.ItemAetherNeptuneHelmet,"Casque de Neptune");	
		ModLoader.AddName(MMC_Item.ItemAetherNeptuneChestplate,"Armure de Neptune");	
		ModLoader.AddName(MMC_Item.ItemAetherNeptuneLeggings,"Jambières de Neptune");	
		ModLoader.AddName(MMC_Item.ItemAetherNeptuneBoots,"Bottes de Neptune");	
		ModLoader.AddName(MMC_Item.ItemAetherRegenerationStone,"Pierre de regeneration");	
		ModLoader.AddName(MMC_Item.ItemAetherInvisibilityCloak,"Manteau d'invisibilité");	
		ModLoader.AddName(MMC_Item.ItemAetherAgilityCape,"Cape d'agilité");	
		ModLoader.AddName(MMC_Item.ItemAetherWhiteCape,"Cape blanche");	
		ModLoader.AddName(MMC_Item.ItemAetherRedCape,"Cape rouge");	
		ModLoader.AddName(MMC_Item.ItemAetherYellowCape,"Cape jaune");	
		ModLoader.AddName(MMC_Item.ItemAetherBlueCape,"Cape bleu");	
		ModLoader.AddName(MMC_Item.ItemAetherPickValkyrie,"Pioche des Valkyries");	
		ModLoader.AddName(MMC_Item.ItemAetherAxeValkyrie,"Hache des Valkyries");	
		ModLoader.AddName(MMC_Item.ItemAetherShovelValkyrie,"Pelle des Valkyries");	
		ModLoader.AddName(MMC_Item.ItemAetherHealingStone,"Pierre de soin");	
		ModLoader.AddName(MMC_Item.ItemAetherIceRing,"Anneau de glace");	
		ModLoader.AddName(MMC_Item.ItemAetherIcePendant,"Pendentif de glace");		
	}		
	
///////////////////////////////////////////////////////////////////////////
//	TICK
/////////////////////////////////////////////////////////////////////////// 	
	
	public boolean OnTickInGame(Minecraft minecraft)
    {
		return false;
		
    }
	
	
///////////////////////////////////////////////////////////////////////////
//	METHODE DU MOD
/////////////////////////////////////////////////////////////////////////// 
	
	
	//Methode de rendu sur le mod (Important pour la gravitite par exemple, et les items à effet visuelle)
    public void AddRenderer(Map map)
    {
        MMC_Block.AddRenderer(map);
        MMC_Item.AddRenderer(map);
    }

	//Fonctions exotiques
	
	public static boolean equippedSkyrootShovel(){
		ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
		return itemstack != null && itemstack.itemID == MMC_Item.ItemAetherShovelSkyroot.shiftedIndex;
		}
			
	public static boolean equippedSkyrootAxe(){
		ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
		return itemstack != null && itemstack.itemID == MMC_Item.ItemAetherAxeSkyroot.shiftedIndex;
		}	
	
    public static boolean equippedSkyrootPick(){
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == MMC_Item.ItemAetherPickSkyroot.shiftedIndex;
    	}	
    
    
    public static void giveAchievement(Achievement blueCloud,
			EntityPlayer entity) {
		    	
	}
    
    //Méthode pour les plaques
    public static int IndexClothTexture(int i)
    {
        i = ~(i & 0xf);
        return 113 + ((i & 8) >> 3) + (i & 7) * 16;
    }

    public static int Inverse(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return 1;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 3;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 5;

        case 5: // '\005'
            return 4;
        }
        return -1;
    }
    
    
    //Attribution de la version
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0.0";
	}

	//Méthode de chargement
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}



}
