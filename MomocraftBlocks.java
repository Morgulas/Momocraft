package net.minecraft.src;

import net.minecraft.src.Momocraft.*;

public class MomocraftBlocks {
	
//-------------------------------------------
// Momocraft
//-------------------------------------------	
	
	//TestBlock
	public static final Block TestBlock = (new BlockTestBlock(MomocraftID.idBlockMomocraftTest /*Id du block*/, MomocraftTextures.TexBlockMomocraftTest /*Texture du blocs*/))
			.setBlockName("TestBlock")				//Redefinir le nom du bloc de la variable
			.setHardness(1.5f)						//Defini la dureté du bloc
			.setResistance(10f)						//Defini la resistance au explosion du bloc
			.setStepSound(Block.soundStoneFootstep);//Defini le son joué quand marche dessus
													//Etc...
//	public static final Block BlockPortal = (new MomoWorldBlockPortal(MomocraftID.idBlockMomocraftPortal, ModLoader.getUniqueSpriteIndex("/terrain.png"))).setHardness(-1F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75F).setBlockName("NameherePortal");

//-------------------------------------------
// Minefield
//-------------------------------------------
	
	public static final Block BlockPaille = (new BlockPaille(240, MomocraftTextures.TexBlockAetherDirt)).setBlockName("BlockPaille").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	
//-------------------------------------------
// Aether Mod
//-------------------------------------------
	
/**/public static final Block BlockAetherPortal = (new BlockAetherPortal(MomocraftID.idBlockAetherPortal, 14)).setBlockName("BlockAetherPortal").setHardness(-1F).setResistance(6000000F);
	public static final Block BlockAetherDirt = (new BlockAetherDirt(MomocraftID.idBlockAetherDirt)).setBlockName("BlockAetherDirt").setHardness(0.2F).setStepSound(Block.soundGravelFootstep);
	public static final Block BlockAetherGrass = (new BlockAetherGrass(MomocraftID.idBlockAetherGrass)).setBlockName("BlockAetherGrass").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherQuicksoil = (new BlockAetherQuicksoil(MomocraftID.idBlockAetherQuicksoil)).setBlockName("BlockAetherQuicksoil").setHardness(0.5F).setStepSound(Block.soundSandFootstep);
	public static final Block BlockAetherHolystone = (new BlockAetherHolystone(MomocraftID.idBlockAetherHolystone)).setBlockName("BlockAetherHolystone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherIcestone = (new BlockAetherIcestone(MomocraftID.idBlockAetherIcestone)).setBlockName("BlockAetherIcestone").setHardness(3F).setStepSound(Block.soundGlassFootstep);
	public static final Block BlockAetherAercloud = (new BlockAetherAercloud(MomocraftID.idBlockAetherAercloud)).setBlockName("BlockAetherAercloud").setHardness(0.2F).setLightOpacity(3).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAerogel = (new BlockAetherAerogel(MomocraftID.idBlockAetherAerogel)).setBlockName("BlockAetherAerogel").setHardness(1.0F).setResistance(2000F).setLightOpacity(3).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherEnchanter = (new BlockAetherEnchanter(MomocraftID.idBlockAetherEnchanter)).setBlockName("BlockAetherEnchanter").setHardness(2.0F);
	public static final Block BlockAetherIncubator = (new BlockAetherIncubator(MomocraftID.idBlockAetherIncubator)).setBlockName("BlockAetherIncubator").setHardness(2.0F);
	public static final Block BlockAetherLog = (new BlockAetherLog(MomocraftID.idBlockAetherLog)).setBlockName("BlockAetherLog").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
	public static final Block BlockAetherPlank = (new Block(MomocraftID.idBlockAetherPlank, MomocraftTextures.TexBlockAetherPlank, Material.wood)).setBlockName("BlockAetherPlank").setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep);
	public static final Block BlockAetherSkyrootLeaves = (new BlockAetherLeaves(MomocraftID.idBlockAetherSkyrootLeaves)).setBlockName("BlockAetherSkyrootLeaves").setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherGoldenOakLeaves = (new BlockAetherLeaves(MomocraftID.idBlockAetherGoldenOakLeaves)).setBlockName("BlockAetherGoldenOakLeaves").setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherSkyrootSapling = (new BlockAetherSapling(MomocraftID.idBlockAetherSkyrootSapling)).setBlockName("BlockAetherSkyrootSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherGoldenOakSapling = (new BlockAetherSapling(MomocraftID.idBlockAetherGoldenOakSapling)).setBlockName("BlockAetherGoldenOakSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherAmbrosiumOre = (new BlockAetherAmbrosiumOre(MomocraftID.idBlockAetherAmbrosiumOre)).setBlockName("BlockAetherAmbrosiumOre").setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherAmbrosiumTorch = (new BlockAetherAmbrosiumTorch(MomocraftID.idBlockAetherAmbrosiumTorch)).setBlockName("BlockAetherAmbrosiumTorch").setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
    
	//Mineraux et blocs massifs
	static int i = Block.blockSteel.blockIndexInTexture;
	public static final Block BlockAetherZaniteOre = (new BlockAetherZaniteOre(MomocraftID.idBlockAetherZaniteOre)).setBlockName("BlockAetherZaniteOre").setHardness(3F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherZanite = (new BlockAetherZanite(MomocraftID.idBlockAetherZanite, i)).setBlockName("BlockAetherZanite").setHardness(3F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherGravititeOre = (new BlockFloating(MomocraftID.idBlockAetherGravititeOre, MomocraftTextures.TexBlockAetherGravititeOre, false)).setBlockName("BlockAetherGravititeOre").setHardness(5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherEnchantedGravitite = (new BlockAetherEnchantedGravitite(MomocraftID.idBlockAetherEnchantedGravitite, i, true)).setBlockName("BlockAetherEnchantedGravitite").setHardness(5F).setStepSound(Block.soundStoneFootstep);
	
	public static final Block BlockAetherTrap = (new BlockAetherTrap(MomocraftID.idBlockAetherTrap)).setBlockName("BlockAetherTrap").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherChestMimic = (new BlockAetherChestMimic(MomocraftID.idBlockAetherChestMimic)).setBlockName("BlockAetherChestMimic").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
	public static final Block BlockAetherTreasureChest = (new BlockAetherTreasureChest(MomocraftID.idBlockAetherTreasureChest, MomocraftTextures.TexBlockAetherLockedChestFront, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherTreasureChest").setHardness(-1F).setStepSound(Block.soundStoneFootstep);
	
	//Pierre de donjon
	public static final Block BlockAetherDungeonStone = (new BlockAetherDungeon(MomocraftID.idBlockAetherDungeonStone)).setBlockName("BlockAetherDungeonStone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherLightDungeonStone = (new BlockAetherDungeon(MomocraftID.idBlockAetherLightDungeonStone)).setBlockName("BlockAetherLightDungeonStone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.75F);
	public static final Block BlockAetherLockedDungeonStone = (new BlockAetherDungeon(MomocraftID.idBlockAetherLockedDungeonStone)).setBlockName("BlockAetherLockedDungeonStone").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherLockedLightDungeonStone = (new BlockAetherDungeon(MomocraftID.idBlockAetherLockedLightDungeonStone)).setBlockName("BlockAetherLockedLightDungeonStone").setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep).setLightValue(0.5F);
	
	public static final Block BlockAetherPillar = (new BlockAetherPillar(MomocraftID.idBlockAetherPillar)).setBlockName("BlockAetherPillar").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherQuicksoilGlass = (new BlockAetherQuicksoilGlass(MomocraftID.idBlockAetherQuicksoilGlass)).setBlockName("BlockAetherQuicksoilGlass").setLightValue(0.7375F).setHardness(0.2F).setLightOpacity(0).setStepSound(Block.soundGlassFootstep);
	public static final Block BlockAetherFreezer = (new BlockAetherFreezer(MomocraftID.idBlockAetherFreezer)).setBlockName("BlockAetherFreezer").setHardness(2.5F).setStepSound(Block.soundStoneFootstep);
	public static final Block BlockAetherWhiteFlower = (new BlockAetherFlower(MomocraftID.idBlockAetherWhiteFlower, MomocraftTextures.TexBlockAetherWhiteFlower)).setBlockName("BlockAetherWhiteFlower").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherPurpleFlower = (new BlockAetherFlower(MomocraftID.idBlockAetherPurpleFlower, MomocraftTextures.TexBlockAetherPurpleFlower)).setBlockName("BlockAetherPurpleFlower").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
	public static final Block BlockAetherBed = (new BlockAetherBed(MomocraftID.idBlockAetherBed)).setBlockName("BlockAetherBed").setHardness(0.2F).disableStats();
	
}
