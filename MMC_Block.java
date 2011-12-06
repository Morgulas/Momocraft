/*
 * Mod Momocraft - SteveVuillaume
 * 
 * stevevuillaume@gmail.com
 * Pt:1
 * 
 */


package net.minecraft.src;
import java.util.Map;

import net.minecraft.src.*;

public class MMC_Block {
	
	//Variable de textures neutre
	static int steel = Block.blockSteel.blockIndexInTexture;
	static int glass = Block.blockSteel.blockIndexInTexture;
	
//-------------------------------------------
// Momocraft
//-------------------------------------------	
	
	//TestBlock
	public static final Block BlockMomocraftTestBlock = (new MMC_BlockMomocraftTestBlock(MMC_ID.idBlockMomocraftTest /*Id du block*/, MMC_Textures.TexBlockMomocraftTest /*Texture du blocs*/))
			.setBlockName("TestBlock")				//Redefinir le nom du bloc de la variable
			.setHardness(1.5f)						//Defini la dureté du bloc
			.setResistance(10f)						//Defini la resistance au explosion du bloc
			.setStepSound(Block.soundStoneFootstep);//Defini le son joué quand marche dessus
													//Etc...
	
	
//	  public static final Block BlockMomocraftFeuArtifice = (new MomocraftFireworksLauncher(MomocraftID.idBlockMomocraftFirework, MomocraftTextures.TexBlockMomocraftTest, MomocraftTextures.TexBlockMomocraftTest, mod_Momocraft.props)).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("Fireworks");
	public static final Block BlockMomocraftFence1 = (new BlockFence(MMC_ID.idBlockMomocraftFence1, Block.blockSteel.blockIndexInTexture));
	public static final Block BlockMomocraftStairs1 = (new BlockStairs(MMC_ID.idBlockMomocraftStairs1, Block.cloth));
	
	public static final Block BlockMomocraftPlaqueDiamond = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueDiamond, Block.blockDiamond, Block.blockDiamond.blockIndexInTexture).setBlockName("Plaque en diamant");
	public static final Block BlockMomocraftPlaqueGlass = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueGlass, Block.glass, Block.glass.blockIndexInTexture).setBlockName("Plaque en verre");
	public static final Block BlockMomocraftPlaqueGlowStone = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueGlowStone, Block.glowStone, Block.glowStone.blockIndexInTexture).setBlockName("Plaque en rayonnite");
	public static final Block BlockMomocraftPlaqueGlowStoneLight = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueGlowStoneLight, Block.glowStone, Block.glowStone.blockIndexInTexture).setLightValue(1.0F).setBlockName("Plaque en rayonnite");
	public static final Block BlockMomocraftPlaqueGold = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueGold, Block.blockGold, Block.blockGold.blockIndexInTexture).setBlockName("Plaque en or");
	public static final Block BlockMomocraftPlaqueIce = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueIce, Block.ice, Block.ice.blockIndexInTexture).setBlockName("Plaque en glace").setLightOpacity(3);
	public static final Block BlockMomocraftPlaqueLapis = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueLapis, Block.blockLapis, Block.blockLapis.blockIndexInTexture).setBlockName("Plaque en lapis");
	public static final Block BlockMomocraftPlaqueObsidian = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueObsidian, Block.obsidian, Block.obsidian.blockIndexInTexture).setBlockName("Plaque en obsidienne");
	public static final Block BlockMomocraftPlaquePlanks = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaquePlanks, Block.planks, Block.planks.blockIndexInTexture).setBlockName("Plaque en planche");
	public static final Block BlockMomocraftPlaqueSandStone = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueSandStone, Block.sandStone, Block.sandStone.blockIndexInTexture).setBlockName("Plaque en gres");
	public static final Block BlockMomocraftPlaqueSteel = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueSteel, Block.blockSteel, Block.blockSteel.blockIndexInTexture).setBlockName("Plaque en fer");
	public static final Block BlockMomocraftPlaqueStone = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueStone, Block.stone, Block.stone.blockIndexInTexture).setBlockName("Plaque en pierre");
	
	public static final Block BlockMomocraftPlaqueCloth0 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth0, Block.cloth, Block.cloth.blockIndexInTexture).setBlockName("Plaque en laine blanche");
	public static final Block BlockMomocraftPlaqueCloth1 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth1, Block.cloth, mod_Momocraft.IndexClothTexture(1)).setBlockName("Plaque en laine orange");
	public static final Block BlockMomocraftPlaqueCloth2 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth2, Block.cloth, mod_Momocraft.IndexClothTexture(2)).setBlockName("Plaque en laine magenta");
	public static final Block BlockMomocraftPlaqueCloth3 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth3, Block.cloth, mod_Momocraft.IndexClothTexture(3)).setBlockName("Plaque en laine bleu ciel");
	public static final Block BlockMomocraftPlaqueCloth4 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth4, Block.cloth, mod_Momocraft.IndexClothTexture(4)).setBlockName("Plaque en laine jaune");
	public static final Block BlockMomocraftPlaqueCloth5 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth5, Block.cloth, mod_Momocraft.IndexClothTexture(5)).setBlockName("Plaque en laine vert lime");
	public static final Block BlockMomocraftPlaqueCloth6 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth6, Block.cloth, mod_Momocraft.IndexClothTexture(6)).setBlockName("Plaque en laine rose");
	public static final Block BlockMomocraftPlaqueCloth7 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth7, Block.cloth, mod_Momocraft.IndexClothTexture(7)).setBlockName("Plaque en laine grise");
	public static final Block BlockMomocraftPlaqueCloth8 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth8, Block.cloth, mod_Momocraft.IndexClothTexture(8)).setBlockName("Plaque en laine gris clair");
	public static final Block BlockMomocraftPlaqueCloth9 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth9, Block.cloth, mod_Momocraft.IndexClothTexture(9)).setBlockName("Plaque en laine cyan");
	public static final Block BlockMomocraftPlaqueCloth10 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth10, Block.cloth, mod_Momocraft.IndexClothTexture(10)).setBlockName("Plaque en laine violette");
	public static final Block BlockMomocraftPlaqueCloth11 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth11, Block.cloth, mod_Momocraft.IndexClothTexture(11)).setBlockName("Plaque en laine bleue");
	public static final Block BlockMomocraftPlaqueCloth12 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth12, Block.cloth, mod_Momocraft.IndexClothTexture(12)).setBlockName("Plaque en laine marron");
	public static final Block BlockMomocraftPlaqueCloth13 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth13, Block.cloth, mod_Momocraft.IndexClothTexture(13)).setBlockName("Plaque en laine verte");
	public static final Block BlockMomocraftPlaqueCloth14 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth14, Block.cloth, mod_Momocraft.IndexClothTexture(14)).setBlockName("Plaque en laine rouge");
	public static final Block BlockMomocraftPlaqueCloth15 = new MMC_BlockPlaque(MMC_ID.idBlockMomocraftPlaqueCloth15, Block.cloth, mod_Momocraft.IndexClothTexture(15)).setBlockName("Plaque en laine noire");
	
//-------------------------------------------
// Minefield
//-------------------------------------------
	
	public static final Block BlockMinefieldArdoise = (new MMC_BlockMinefieldArdoise(MMC_ID.idBlockMinefieldArdoise, MMC_Textures.TexBlockMinefieldArdoise)).setBlockName("BlockMinefieldArdoise").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
/*	public static final Block BlockMinefieldBancCentre = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldBancCentre, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldBancCentre").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldBancPied = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldBancPied, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldBancPied").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldBarriereFer = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldBarriereFer, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldBarriereFer").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldChaine = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldChaine, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldChaine").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldChaise = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldChaise, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldChaise").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	
	public static final Block BlockMinefieldCouverts = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldCouverts, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldCouverts").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldEtagere = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldEtagere, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldEtagere").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	*/
/*	public static final Block BlockMinefieldGlowstonePure = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldGlowstonePure, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldGlowstonePure").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldGobeur = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldGobeur, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldGobeur").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldHerse = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldHerse, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldHerse").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldHoublon = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldHoublon, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldHoublon").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldLanterne = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldLanterne, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldLanterne").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldLanterneEteinte = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldLanterneEteinte, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldLanterneEteinte").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldList = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldList, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldList").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
*///	public static final Block BlockMinefieldNappe = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldNappe, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldNappe").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldPaille = (new MMC_BlockMinefieldPaille(MMC_ID.idBlockMinefieldPaille, MMC_Textures.TexBlockMinefieldPaille)).setBlockName("BlockMinefieldPaille").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
//	public static final Block BlockMinefieldPoulie = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldPoulie, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldPoulie").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
//	public static final Block BlockMinefieldPoulieMoving = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldPoulieMoving, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldPoulieMoving").setHardness(0.4f).setStepSound(Block.soundClothFootstep);

/*	public static final Block BlockMinefieldSupportMural = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldSupportMural, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldSupportMural").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTableBasse = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTableBasse, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTableBasse").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTableCentre = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTableCentre, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTableCentre").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTablePied = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTablePied, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTablePied").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTablePlateau = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTablePlateau, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTablePlateau").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTabouret = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTabouret, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTabouret").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldTonneau = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldTonneau, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldTonneau").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldVerreColo = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldVerreColo, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldVerreColo").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockMinefieldVitreColo = (new BlockMinefieldPaille(MomocraftID.idBlockMinefieldVitreColo, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockMinefieldVitreColo").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
*/
	
//-------------------------------------------
// Aether Mod
//-------------------------------------------
	
/**/public static final Block BlockAetherPortal = (new MMC_BlockAetherPortal(MMC_ID.idBlockAetherPortal, 14)).setBlockName("BlockAetherPortal").setHardness(-1F).setResistance(6000000F);
	public static final Block BlockAetherDirt = (new MMC_BlockAetherDirt(MMC_ID.idBlockAetherDirt)).setBlockName("BlockAetherDirt").setHardness(0.2F).setStepSound(Block.soundGravelFootstep);
	public static final Block BlockAetherGrass = (new MMC_BlockAetherGrass(MMC_ID.idBlockAetherGrass)).setBlockName("BlockAetherGrass").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherQuicksoil = (new MMC_BlockAetherQuicksoil(MMC_ID.idBlockAetherQuicksoil)).setBlockName("BlockAetherQuicksoil").setHardness(0.5F).setStepSound(Block.soundSandFootstep);
	public static final Block BlockAetherHolystone = (new MMC_BlockAetherHolystone(MMC_ID.idBlockAetherHolystone)).setBlockName("BlockAetherHolystone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherIcestone = (new MMC_BlockAetherIcestone(MMC_ID.idBlockAetherIcestone)).setBlockName("BlockAetherIcestone").setHardness(3F).setStepSound(Block.soundGlassFootstep);
	public static final Block BlockAetherAercloud = (new MMC_BlockAetherAercloud(MMC_ID.idBlockAetherAercloud)).setBlockName("BlockAetherAercloud").setHardness(0.2F).setLightOpacity(3).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAerogel = (new MMC_BlockAetherAerogel(MMC_ID.idBlockAetherAerogel)).setBlockName("BlockAetherAerogel").setHardness(1.0F).setResistance(2000F).setLightOpacity(3).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherLog = (new MMC_BlockAetherLog(MMC_ID.idBlockAetherLog)).setBlockName("BlockAetherLog").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
	public static final Block BlockAetherPlank = (new Block(MMC_ID.idBlockAetherPlank, MMC_Textures.TexBlockAetherPlank, Material.wood)).setBlockName("BlockAetherPlank").setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep);
	public static final Block BlockAetherSkyrootLeaves = (new MMC_BlockAetherLeaves(MMC_ID.idBlockAetherSkyrootLeaves)).setBlockName("BlockAetherSkyrootLeaves").setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherGoldenOakLeaves = (new MMC_BlockAetherLeaves(MMC_ID.idBlockAetherGoldenOakLeaves)).setBlockName("BlockAetherGoldenOakLeaves").setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherSkyrootSapling = (new MMC_BlockAetherSapling(MMC_ID.idBlockAetherSkyrootSapling)).setBlockName("BlockAetherSkyrootSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherGoldenOakSapling = (new MMC_BlockAetherSapling(MMC_ID.idBlockAetherGoldenOakSapling)).setBlockName("BlockAetherGoldenOakSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherAmbrosiumOre = (new MMC_BlockAetherAmbrosiumOre(MMC_ID.idBlockAetherAmbrosiumOre)).setBlockName("BlockAetherAmbrosiumOre").setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherAmbrosiumTorch = (new MMC_BlockAetherAmbrosiumTorch(MMC_ID.idBlockAetherAmbrosiumTorch)).setBlockName("BlockAetherAmbrosiumTorch").setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
    
	//NecessiteGUI
/*	public static final Block BlockAetherIncubator = (new BlockAetherIncubator(MomocraftID.idBlockAetherIncubator)).setBlockName("BlockAetherIncubator").setHardness(2.0F);
	public static final Block BlockAetherEnchanter = (new BlockAetherEnchanter(MomocraftID.idBlockAetherEnchanter)).setBlockName("BlockAetherEnchanter").setHardness(2.0F);
	public static final Block BlockAetherFreezer = (new BlockAetherFreezer(MomocraftID.idBlockAetherFreezer)).setBlockName("BlockAetherFreezer").setHardness(2.5F).setStepSound(Block.soundStoneFootstep);
*/
	//Mineraux et blocs massifs
	public static final Block BlockAetherZaniteOre = (new MMC_BlockAetherZaniteOre(MMC_ID.idBlockAetherZaniteOre)).setBlockName("BlockAetherZaniteOre").setHardness(3F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherGravititeOre = (new MMC_BlockFloating(MMC_ID.idBlockAetherGravititeOre, MMC_Textures.TexBlockAetherGravititeOre, false)).setBlockName("BlockAetherGravititeOre").setHardness(5F).setStepSound(Block.soundStoneFootstep);
	
	public static final Block BlockAetherZanite = (new MMC_BlockAetherZanite(MMC_ID.idBlockAetherZanite, steel)).setBlockName("BlockAetherZanite").setHardness(3F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherEnchantedGravitite = (new MMC_BlockAetherEnchantedGravitite(MMC_ID.idBlockAetherEnchantedGravitite, steel, true)).setBlockName("BlockAetherEnchantedGravitite").setHardness(5F).setStepSound(Block.soundStoneFootstep);
	
	public static final Block BlockAetherTrap = (new MMC_BlockAetherTrap(MMC_ID.idBlockAetherTrap)).setBlockName("BlockAetherTrap").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep);
//	public static final Block BlockAetherChestMimic = (new BlockAetherChestMimic(MomocraftID.idBlockAetherChestMimic)).setBlockName("BlockAetherChestMimic").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
//	public static final Block BlockAetherTreasureChest = (new BlockAetherTreasureChest(MomocraftID.idBlockAetherTreasureChest, MomocraftTextures.TexBlockAetherLockedChestFront, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherTreasureChest").setHardness(-1F).setStepSound(Block.soundStoneFootstep);
	
	//Pierre de donjon
	public static final Block BlockAetherDungeonStone = (new MMC_BlockAetherDungeon(MMC_ID.idBlockAetherDungeonStone)).setBlockName("BlockAetherDungeonStone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherLightDungeonStone = (new MMC_BlockAetherDungeon(MMC_ID.idBlockAetherLightDungeonStone)).setBlockName("BlockAetherLightDungeonStone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.75F);
	public static final Block BlockAetherLockedDungeonStone = (new MMC_BlockAetherDungeon(MMC_ID.idBlockAetherLockedDungeonStone)).setBlockName("BlockAetherLockedDungeonStone").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherLockedLightDungeonStone = (new MMC_BlockAetherDungeon(MMC_ID.idBlockAetherLockedLightDungeonStone)).setBlockName("BlockAetherLockedLightDungeonStone").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep).setLightValue(0.5F);
	public static final Block BlockAetherPillar = (new MMC_BlockAetherPillar(MMC_ID.idBlockAetherPillar)).setBlockName("BlockAetherPillar").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);

	public static final Block BlockAetherQuicksoilGlass = (new MMC_BlockAetherQuicksoilGlass(MMC_ID.idBlockAetherQuicksoilGlass)).setBlockName("BlockAetherQuicksoilGlass").setLightValue(0.7375F).setHardness(0.2F).setLightOpacity(0).setStepSound(Block.soundGlassFootstep);
	public static final Block BlockAetherWhiteFlower = (new MMC_BlockAetherFlower(MMC_ID.idBlockAetherWhiteFlower, MMC_Textures.TexBlockAetherWhiteFlower)).setBlockName("BlockAetherWhiteFlower").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherPurpleFlower = (new MMC_BlockAetherFlower(MMC_ID.idBlockAetherPurpleFlower, MMC_Textures.TexBlockAetherPurpleFlower)).setBlockName("BlockAetherPurpleFlower").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
//	public static final Block BlockAetherBed = (new BlockAetherBed(MomocraftID.idBlockAetherBed)).setBlockName("BlockAetherBed").setHardness(0.2F).disableStats();
	
	
	//Methode pour le rendu des blocs volants
	public static void AddRenderer(Map map)
	{
		map.put(MMC_EntityFloatingBlock.class, new MMC_RenderFloatingBlock());
	}
}
