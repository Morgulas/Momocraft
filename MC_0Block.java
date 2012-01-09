/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

import java.util.Map;

import net.minecraft.src.*;

public class MC_0Block {
    public static Item itemsList[] = new Item[32000];
	//Variable de textures neutre
	static int steel = Block.blockSteel.blockIndexInTexture;
	static int glass = Block.glass.blockIndexInTexture;
    static MC_FireworksSkyrocketManager fireworksskyrocketmanager = new MC_FireworksSkyrocketManager();
	
	//TestBlock
	public static final Block BlockTest = (new MC_1BlockTest(MC_0ID.bTest /*Id du block*/, MC_0Textures.bTest /*Texture du blocs*/))
			.setBlockName("TestBlock")					//Redefinir le nom du bloc de la variable
			.setHardness(1.5f)							//Defini la dureté du bloc
			.setResistance(10f)							//Defini la resistance au explosion du bloc
			.setStepSound(Block.soundStoneFootstep)		//Defini le son joué quand marche dessus
            .setLightValue(1.0F);						//Mettre de la lumière au bloc					
                                                    	//Etc...

	
	public static final Block BlockPaille = (new Block (MC_0ID.bPaille, MC_0Textures.bPaille, Material.cloth)).setBlockName("BlockPaille").setHardness(0.8F).setStepSound(Block.soundClothFootstep);
	public static final Block BlockArdoise = (new Block (MC_0ID.bArdoise, MC_0Textures.bArdoise, Material.rock)).setBlockName("BlockArdoise").setHardness(1.5f).setResistance(10f).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockGlowstonePure = (new Block (MC_0ID.bGlowstonePure, MC_0Textures.bGlowstonePure, Material.rock)).setBlockName("BlockGlowstonePure").setHardness(1.5f).setResistance(10f).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F);
	public static final Block BlockLanterneGlowstone = (new Block (MC_0ID.bLanterneGlowstone, MC_0Textures.bLanterneGlowstone, Material.rock)).setBlockName("BlockLanterneGlowstone").setHardness(1.5f).setResistance(10f).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F);
	public static final Block BlockLanterneGlowstonePure = (new Block (MC_0ID.bLanterneGlowstonePure, MC_0Textures.bLanterneGlowstonePure, Material.rock)).setBlockName("BlockLanterneGlowstonePure").setHardness(1.5f).setResistance(10f).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F);
	public static final Block BlockEscalierPaille = (new BlockStairs (MC_0ID.bEscalierPaille, MC_0Block.BlockPaille)).setBlockName("BlockEscalierPaille").setLightOpacity(0);
	public static final Block BlockEscalierArdoise = (new BlockStairs (MC_0ID.bEscalierArdoise, MC_0Block.BlockArdoise)).setBlockName("BlockEscalierArdoise").setLightOpacity(0);
	public static final Block BlockHerbeLumineuse = (new BlockGrass (MC_0ID.bHerbeLumineuse)).setBlockName("BlockHerbeLumineuse").setLightValue(0.8F).setRequiresSelfNotify();

	public static final Block BlockEscalierStone = (new MC_1BlockStairs (MC_0ID.bEscalierStone, Block.stone, Block.stone.blockIndexInTexture)).setBlockName("BlockEscalierStone").setLightOpacity(0);
	public static final Block BlockEscalierStonePolie = (new MC_1BlockStairs (MC_0ID.bEscalierStonePolie, Block.stone, 5)).setBlockName("BlockEscalierStonePolie").setLightOpacity(0);
	public static final Block BlockEscalierLog = (new MC_1BlockStairs (MC_0ID.bEscalierLog, Block.wood, Block.wood.blockIndexInTexture)).setBlockName("BlockEscalierLog").setLightOpacity(0);

    public static final Block BlockDalle = new MC_1BlockStep(MC_0ID.bDalle, Block.stone, Block.stone.blockIndexInTexture).setStepSound(Block.soundStoneFootstep).setBlockName("step").setRequiresSelfNotify();

//	public static final Block BlockDalleStone = (new MC_1BlockStep (MC_0ID.bDalleStone, Block.stone, Block.stone.blockIndexInTexture)).setBlockName("BlockDalleStone").setLightOpacity(0);
//	public static final Block BlockDalleLog = (new MC_1BlockStep (MC_0ID.bDalleLog, Block.wood, Block.wood.blockIndexInTexture)).setBlockName("BlockDalleLog").setLightOpacity(0);
//	public static final Block BlockDallePaille = (new MC_1BlockStep (MC_0ID.bDallePaille, MC_0Block.BlockPaille, MC_0Textures.bPaille)).setBlockName("BlockDallePaille").setLightOpacity(0);
//	public static final Block BlockDalleArdoise = (new MC_1BlockStep (MC_0ID.bDalleArdoise, MC_0Block.BlockArdoise, MC_0Textures.bArdoise)).setBlockName("BlockDalleArdoise").setLightOpacity(0);
	
	public static final Block BlockPlaqueDiamond = new MC_1BlockPlaque(MC_0ID.bPlaqueDiamond, Block.blockDiamond, Block.blockDiamond.blockIndexInTexture).setBlockName("Plaque en diamant");
	public static final Block BlockPlaqueGlass = new MC_1BlockPlaque(MC_0ID.bPlaqueGlass, Block.glass, Block.glass.blockIndexInTexture).setBlockName("Plaque en verre");
	public static final Block BlockPlaqueGlowStone = new MC_1BlockPlaque(MC_0ID.bPlaqueGlowStone, MC_0Block.BlockLanterneGlowstonePure, MC_0Textures.bLanterneGlowstonePure).setBlockName("Plaque en rayonnite");
	public static final Block BlockPlaqueGlowStoneLight = new MC_1BlockPlaque(MC_0ID.bPlaqueGlowStoneLight, MC_0Block.BlockLanterneGlowstonePure, MC_0Textures.bLanterneGlowstonePure).setLightValue(1.0F).setBlockName("Plaque en rayonnite");
	public static final Block BlockPlaqueGold = new MC_1BlockPlaque(MC_0ID.bPlaqueGold, Block.blockGold, Block.blockGold.blockIndexInTexture).setBlockName("Plaque en or");
	public static final Block BlockPlaqueIce = new MC_1BlockPlaque(MC_0ID.bPlaqueIce, Block.ice, Block.ice.blockIndexInTexture).setBlockName("Plaque en glace").setLightOpacity(3);
	public static final Block BlockPlaqueLapis = new MC_1BlockPlaque(MC_0ID.bPlaqueLapis, Block.blockLapis, Block.blockLapis.blockIndexInTexture).setBlockName("Plaque en lapis");
	public static final Block BlockPlaqueObsidian = new MC_1BlockPlaque(MC_0ID.bPlaqueObsidian, Block.obsidian, Block.obsidian.blockIndexInTexture).setBlockName("Plaque en obsidienne");
	public static final Block BlockPlaquePlanks = new MC_1BlockPlaque(MC_0ID.bPlaquePlanks, Block.planks, Block.planks.blockIndexInTexture).setBlockName("Plaque en planche");
	public static final Block BlockPlaqueSandStone = new MC_1BlockPlaque(MC_0ID.bPlaqueSandStone, Block.sandStone, Block.sandStone.blockIndexInTexture).setBlockName("Plaque en gres");
	public static final Block BlockPlaqueSteel = new MC_1BlockPlaque(MC_0ID.bPlaqueSteel, Block.blockSteel, Block.blockSteel.blockIndexInTexture).setBlockName("Plaque en fer");
	public static final Block BlockPlaqueStone = new MC_1BlockPlaque(MC_0ID.bPlaqueStone, Block.stone, Block.stone.blockIndexInTexture).setBlockName("Plaque en pierre");

	public static final Block BlockPlaqueCloth0 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth0, Block.cloth, Block.cloth.blockIndexInTexture).setBlockName("Plaque en laine blanche");
	public static final Block BlockPlaqueCloth1 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth1, Block.cloth, mod_Momocraft.IndexClothTexture(1)).setBlockName("Plaque en laine orange");
	public static final Block BlockPlaqueCloth2 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth2, Block.cloth, mod_Momocraft.IndexClothTexture(2)).setBlockName("Plaque en laine magenta");
	public static final Block BlockPlaqueCloth3 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth3, Block.cloth, mod_Momocraft.IndexClothTexture(3)).setBlockName("Plaque en laine bleu ciel");
	public static final Block BlockPlaqueCloth4 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth4, Block.cloth, mod_Momocraft.IndexClothTexture(4)).setBlockName("Plaque en laine jaune");
	public static final Block BlockPlaqueCloth5 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth5, Block.cloth, mod_Momocraft.IndexClothTexture(5)).setBlockName("Plaque en laine vert lime");
	public static final Block BlockPlaqueCloth6 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth6, Block.cloth, mod_Momocraft.IndexClothTexture(6)).setBlockName("Plaque en laine rose");
	public static final Block BlockPlaqueCloth7 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth7, Block.cloth, mod_Momocraft.IndexClothTexture(7)).setBlockName("Plaque en laine grise");
	public static final Block BlockPlaqueCloth8 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth8, Block.cloth, mod_Momocraft.IndexClothTexture(8)).setBlockName("Plaque en laine gris clair");
	public static final Block BlockPlaqueCloth9 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth9, Block.cloth, mod_Momocraft.IndexClothTexture(9)).setBlockName("Plaque en laine cyan");
	public static final Block BlockPlaqueCloth10 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth10, Block.cloth, mod_Momocraft.IndexClothTexture(10)).setBlockName("Plaque en laine violette");
	public static final Block BlockPlaqueCloth11 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth11, Block.cloth, mod_Momocraft.IndexClothTexture(11)).setBlockName("Plaque en laine bleue");
	public static final Block BlockPlaqueCloth12 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth12, Block.cloth, mod_Momocraft.IndexClothTexture(12)).setBlockName("Plaque en laine marron");
	public static final Block BlockPlaqueCloth13 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth13, Block.cloth, mod_Momocraft.IndexClothTexture(13)).setBlockName("Plaque en laine verte");
	public static final Block BlockPlaqueCloth14 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth14, Block.cloth, mod_Momocraft.IndexClothTexture(14)).setBlockName("Plaque en laine rouge");
	public static final Block BlockPlaqueCloth15 = new MC_1BlockPlaque(MC_0ID.bPlaqueCloth15, Block.cloth, mod_Momocraft.IndexClothTexture(15)).setBlockName("Plaque en laine noire");
	
	public static final Block BlockEscalierCloth0 = new MC_1BlockStairs (MC_0ID.bEscalierCloth0, Block.cloth, Block.cloth.blockIndexInTexture).setBlockName("EscalierBlanc").setLightOpacity(0);
	public static final Block BlockEscalierCloth1 = new MC_1BlockStairs (MC_0ID.bEscalierCloth1, Block.cloth, mod_Momocraft.IndexClothTexture(1)).setBlockName("EscalierOrange").setLightOpacity(0);
	public static final Block BlockEscalierCloth2 = new MC_1BlockStairs (MC_0ID.bEscalierCloth2, Block.cloth, mod_Momocraft.IndexClothTexture(2)).setBlockName("EscalierMagenta").setLightOpacity(0);
	public static final Block BlockEscalierCloth3 = new MC_1BlockStairs (MC_0ID.bEscalierCloth3, Block.cloth, mod_Momocraft.IndexClothTexture(3)).setBlockName("EscalierBleuCiel").setLightOpacity(0);
	public static final Block BlockEscalierCloth4 = new MC_1BlockStairs (MC_0ID.bEscalierCloth4, Block.cloth, mod_Momocraft.IndexClothTexture(4)).setBlockName("EscalierJaune").setLightOpacity(0);
	public static final Block BlockEscalierCloth5 = new MC_1BlockStairs (MC_0ID.bEscalierCloth5, Block.cloth, mod_Momocraft.IndexClothTexture(5)).setBlockName("EscalierVertLime").setLightOpacity(0);
	public static final Block BlockEscalierCloth6 = new MC_1BlockStairs (MC_0ID.bEscalierCloth6, Block.cloth, mod_Momocraft.IndexClothTexture(6)).setBlockName("EscalierRose").setLightOpacity(0);
	public static final Block BlockEscalierCloth7 = new MC_1BlockStairs (MC_0ID.bEscalierCloth7, Block.cloth, mod_Momocraft.IndexClothTexture(7)).setBlockName("EscalierGrise").setLightOpacity(0);
	public static final Block BlockEscalierCloth8 = new MC_1BlockStairs (MC_0ID.bEscalierCloth8, Block.cloth, mod_Momocraft.IndexClothTexture(8)).setBlockName("EscalierGrisClair").setLightOpacity(0);
	public static final Block BlockEscalierCloth9 = new MC_1BlockStairs (MC_0ID.bEscalierCloth9, Block.cloth, mod_Momocraft.IndexClothTexture(9)).setBlockName("EscalierCyan").setLightOpacity(0);
	public static final Block BlockEscalierCloth10 = new MC_1BlockStairs (MC_0ID.bEscalierCloth10, Block.cloth, mod_Momocraft.IndexClothTexture(10)).setBlockName("EscalierViolette").setLightOpacity(0);
	public static final Block BlockEscalierCloth11 = new MC_1BlockStairs (MC_0ID.bEscalierCloth11, Block.cloth, mod_Momocraft.IndexClothTexture(11)).setBlockName("EscalierBleue").setLightOpacity(0);
	public static final Block BlockEscalierCloth12 = new MC_1BlockStairs (MC_0ID.bEscalierCloth12, Block.cloth, mod_Momocraft.IndexClothTexture(12)).setBlockName("EscalierMarron").setLightOpacity(0);
	public static final Block BlockEscalierCloth13 = new MC_1BlockStairs (MC_0ID.bEscalierCloth13, Block.cloth, mod_Momocraft.IndexClothTexture(13)).setBlockName("EscalierVerte").setLightOpacity(0);
	public static final Block BlockEscalierCloth14 = new MC_1BlockStairs (MC_0ID.bEscalierCloth14, Block.cloth, mod_Momocraft.IndexClothTexture(14)).setBlockName("EscalierRouge").setLightOpacity(0);
	public static final Block BlockEscalierCloth15 = new MC_1BlockStairs (MC_0ID.bEscalierCloth15, Block.cloth, mod_Momocraft.IndexClothTexture(15)).setBlockName("EscalierNoire").setLightOpacity(0);
    
	//Arche
    public static final Block BlockArcheStep = new MC_1BlockArch(MC_0ID.bArcheStep, Block.stone, 5).setBlockName("ArcheStep");
    public static final Block BlockArcheSandstone = new MC_1BlockArch(MC_0ID.bArcheSandStone, Block.sandStone, Block.sandStone.blockIndexInTexture).setBlockName("ArcheSandstone");
    public static final Block BlockArchePlank = new MC_1BlockArch(MC_0ID.bArchePlank, Block.planks, Block.planks.blockIndexInTexture).setBlockName("ArchePlank");
    public static final Block BlockArcheCobblestone = new MC_1BlockArch(MC_0ID.bArcheCobblestone, Block.cobblestone, Block.cobblestone.blockIndexInTexture).setBlockName("ArcheCobblestone");
    public static final Block BlockArcheBrick = new MC_1BlockArch(MC_0ID.bArcheBrick, Block.brick, Block.brick.blockIndexInTexture).setBlockName("ArcheBrick");
    public static final Block BlockArcheStonebrick = new MC_1BlockArch(MC_0ID.bArcheStonebrick, Block.stoneBrick, Block.stoneBrick.blockIndexInTexture).setBlockName("ArcheStonebrick");
    public static final Block BlockArcheStone = new MC_1BlockArch(MC_0ID.bArcheStone, Block.stone, Block.stone.blockIndexInTexture).setBlockName("ArcheStone");
    public static final Block BlockArcheLog = new MC_1BlockArch(MC_0ID.bArcheLog, Block.wood, Block.wood.blockIndexInTexture).setBlockName("ArcheLog");
    public static final Block BlockArchePaille = new MC_1BlockArch(MC_0ID.bArchePaille, MC_0Block.BlockPaille, MC_0Textures.bPaille).setBlockName("ArchePaille");
    public static final Block BlockArcheArdoise = new MC_1BlockArch(MC_0ID.bArcheArdoise, MC_0Block.BlockArdoise, MC_0Textures.bArdoise).setBlockName("ArcheArdoise");

    //Muret
    public static final Block BlockMuretStep = new MC_1BlockWall(MC_0ID.bMuretStep, Block.stone, 6).setBlockName("MuretStep");
    public static final Block BlockMuretSandstone = new MC_1BlockWall(MC_0ID.bMuretSandStone, Block.sandStone, Block.sandStone.blockIndexInTexture).setBlockName("MuretSandstone");
    public static final Block BlockMuretPlank = new MC_1BlockWall(MC_0ID.bMuretPlank, Block.planks, Block.planks.blockIndexInTexture).setBlockName("MuretPlank");
    public static final Block BlockMuretCobblestone = new MC_1BlockWall(MC_0ID.bMuretCobblestone, Block.cobblestone, Block.cobblestone.blockIndexInTexture).setBlockName("MuretCobblestone");
    public static final Block BlockMuretBrick = new MC_1BlockWall(MC_0ID.bMuretBrick, Block.brick, Block.brick.blockIndexInTexture).setBlockName("MuretBrick");
    public static final Block BlockMuretStoneBrick = new MC_1BlockWall(MC_0ID.bMuretStonebrick, Block.stoneBrick, Block.stoneBrick.blockIndexInTexture).setBlockName("MuretStonebrick");
    public static final Block BlockMuretStone = new MC_1BlockWall(MC_0ID.bMuretStone, Block.stone, Block.stone.blockIndexInTexture).setBlockName("MuretStone");

    //Dalle de plafond
    public static final Block BlockDalleSup = new MC_1BlockSup(MC_0ID.bDalleSup).setBlockName("DalleSup").setLightOpacity(0);

    //Barrière
    public static final Block BlockBarriereFer = new BlockFence(MC_0ID.bBarriereFer, Block.blockSteel.blockIndexInTexture).setBlockName("BarriereFer").setLightOpacity(0);

    public static final Block BlockTrampoline = new MC_1BlockTrampoline(MC_0ID.bTrampoline, MC_0Textures.bTrampolineSide, Material.iron).setBlockName("Trampoline").setLightOpacity(0);
    public static final Block BlockNuage = new MC_1BlockNuage(MC_0ID.bNuage).setBlockName("Nuage").setLightOpacity(3);
    public static final Block BlockHerse = new MC_1BlockHerse(MC_0ID.bHerse, Block.blockSteel.blockIndexInTexture, Material.iron).setBlockName("Herse");
    public static final Block BlockTonneau = new MC_1BlockTonneau(MC_0ID.bTonneau, Block.planks.blockIndexInTexture, Material.iron).setBlockName("Tonneau");
    public static final Block BlockChaine = new MC_1BlockChaine(MC_0ID.bChaine, MC_0Textures.bChaine).setBlockName("Chaine").setHardness(0.8F).setStepSound(Block.soundStoneFootstep);
//    public static final Block BlockChaudronBiere = new MC_1BlockCauldron(MC_0ID.bChaudronBiere).setBlockName("Chaudronbiere").setHardness(0.8F).setStepSound(Block.soundStoneFootstep);
    public static final Block BlockPortail = new MC_1BlockPortail().setBlockName("Portail").setHardness(0.8F).setStepSound(Block.soundStoneFootstep);

//    public static final Block BlockLanceurdeFeu = new MC_FireworksLauncher(MC_0ID.bLanceurdeFeu, 110, 109, fireworksskyrocketmanager).setBlockName("FireWorks").setHardness(0.8F).setStepSound(Block.soundStoneFootstep);
    public static final Block BlockVerre = new MC_1BlockVerre(MC_0ID.bVerre, Material.glass, true).setHardness(0.3F).setBlockName("verre").setStepSound(Block.soundGlassFootstep);
    public static final Block BlockVitre = new MC_1BlockVitre(MC_0ID.bVitre, 148, Material.glass, true).setHardness(0.3F).setBlockName("vitre").setStepSound(Block.soundGlassFootstep);
    public static final Block BlockCouverts = new MC_1BlockCouverts().setBlockName("Couverts");
    public static final Block BlockHoublon = new MC_1BlockHoublon(MC_0ID.bHoublon, MC_0Textures.bHoublon, Material.glass).setBlockName("Houblon");
    public static final Block BlockBucheHory = new MC_1BlockBucheHory(MC_0ID.bBucheHory).setStepSound(Block.soundWoodFootstep).setBlockName("BucheHory").setRequiresSelfNotify();
    public static final Block BlockStepCloth = new MC_1BlockStepCloth(MC_0ID.bStepCloth).setStepSound(Block.soundClothFootstep).setBlockName("StepCloth").setRequiresSelfNotify();
    public static final Block BlockRedStone0 = new MC_1BlockRedstone(MC_0ID.bRedStone0).setStepSound(Block.soundStoneFootstep).setBlockName("BlockRedStone0").setRequiresSelfNotify();
    public static final Block BlockRedStone1 = new MC_1BlockRedstone(MC_0ID.bRedStone1).setStepSound(Block.soundStoneFootstep).setBlockName("BlockRedStone1").setLightValue(1.0f).setRequiresSelfNotify();

//////////////////////////////////////////////////////////////////
//	PROTOTYPE
//////////////////////////////////////////////////////////////////

//    public static final Block BlockRedstone = new MC_1BlockRedstone(MC_0ID.bRedstone, MC_0Textures.bRedstone0, false).setBlockName("BlockRedstone");

	//Methode pour le rendu les blocs 
	public static void AddRenderer(Map map)
	{
        //Blocs volants
		//map.put(MMC_EntityFloatingBlock.class, new MMC_RenderFloatingBlock());
	}
}
