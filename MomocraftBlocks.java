package net.minecraft.src;

import net.minecraft.src.Momocraft.BlockAetherPortal;
import net.minecraft.src.Momocraft.BlockPaille;
import net.minecraft.src.Momocraft.BlockTestBlock;
import net.minecraft.src.Momocraft.MomocraftID;
import net.minecraft.src.Momocraft.MomocraftTextures;

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
//-------------------------------------------
// Minefield
//-------------------------------------------
	
	public static final Block BlockPaille = (new BlockPaille(240, MomocraftTextures.TexBlockAetherDirt)).setBlockName("BlockPaille").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	
//-------------------------------------------
// Aether Mod
//-------------------------------------------
	
	public static final Block BlockAetherPortal = (new BlockPaille(MomocraftID.idBlockAetherPortal, MomocraftTextures.TexBlockAetherPortal)).setBlockName("BlockAetherPortal").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherDirt = (new BlockPaille(MomocraftID.idBlockAetherDirt, MomocraftTextures.TexBlockAetherDirt)).setBlockName("BlockAetherDirt").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherGrass = (new BlockPaille(MomocraftID.idBlockAetherGrass, MomocraftTextures.TexBlockAetherGrassDirt)).setBlockName("BlockAetherGrass").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherQuicksoil = (new BlockPaille(MomocraftID.idBlockAetherQuicksoil, MomocraftTextures.TexBlockAetherQuicksoil)).setBlockName("BlockAetherQuicksoil").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherHolystone = (new BlockPaille(MomocraftID.idBlockAetherHolystone, MomocraftTextures.TexBlockAetherHolystone)).setBlockName("BlockAetherHolystone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherIcestone = (new BlockPaille(MomocraftID.idBlockAetherIcestone, MomocraftTextures.TexBlockAetherIcestone)).setBlockName("BlockAetherIcestone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAercloud = (new BlockPaille(MomocraftID.idBlockAetherAercloud, MomocraftTextures.TexBlockAetherAercloud)).setBlockName("BlockAetherAercloud").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAerogel = (new BlockPaille(MomocraftID.idBlockAetherAerogel, MomocraftTextures.TexBlockAetherAerogel)).setBlockName("BlockAetherAerogel").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherEnchanter = (new BlockPaille(MomocraftID.idBlockAetherEnchanter, MomocraftTextures.TexBlockAetherEnchanterSide)).setBlockName("BlockAetherEnchanter").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherIncubator = (new BlockPaille(MomocraftID.idBlockAetherIncubator, MomocraftTextures.TexBlockAetherIncubatorSide)).setBlockName("BlockAetherIncubator").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherLog = (new BlockPaille(MomocraftID.idBlockAetherLog, MomocraftTextures.TexBlockAetherSkyrootLogSide)).setBlockName("BlockAetherLog").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherPlank = (new BlockPaille(MomocraftID.idBlockAetherPlank, MomocraftTextures.TexBlockAetherPlank)).setBlockName("BlockAetherPlank").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherSkyrootLeaves = (new BlockPaille(MomocraftID.idBlockAetherSkyrootLeaves, MomocraftTextures.TexBlockAetherSkyrootLeaves)).setBlockName("BlockAetherSkyrootLeaves").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherGoldenOakLeaves = (new BlockPaille(MomocraftID.idBlockAetherGoldenOakLeaves, MomocraftTextures.TexBlockAetherGoldenOakLeaves)).setBlockName("BlockAetherGoldenOakLeaves").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherSkyrootSapling = (new BlockPaille(MomocraftID.idBlockAetherSkyrootSapling, MomocraftTextures.TexBlockAetherSkyrootSapling)).setBlockName("BlockAetherSkyrootSapling").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherGoldenOakSapling = (new BlockPaille(MomocraftID.idBlockAetherGoldenOakSapling, MomocraftTextures.TexBlockAetherGoldenOakSapling)).setBlockName("BlockAetherGoldenOakSapling").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAmbrosiumOre = (new BlockPaille(MomocraftID.idBlockAetherAmbrosiumOre, MomocraftTextures.TexBlockAetherAmbrosiumOre)).setBlockName("BlockAetherAmbrosiumOre").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherAmbrosiumTorch = (new BlockPaille(MomocraftID.idBlockAetherAmbrosiumTorch, MomocraftTextures.TexBlockAetherAmbrosiumTorch)).setBlockName("BlockAetherAmbrosiumTorch").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherZaniteOre = (new BlockPaille(MomocraftID.idBlockAetherZaniteOre, MomocraftTextures.TexBlockAetherZaniteOre)).setBlockName("BlockAetherZaniteOre").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherGravititeOre = (new BlockPaille(MomocraftID.idBlockAetherGravititeOre, MomocraftTextures.TexBlockAetherGravititeOre)).setBlockName("BlockAetherGravititeOre").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherEnchantedGravitite = (new BlockPaille(MomocraftID.idBlockAetherEnchantedGravitite, MomocraftTextures.TexBlockAetherGravititeOre)).setBlockName("BlockAetherEnchantedGravitite").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherTrap = (new BlockPaille(MomocraftID.idBlockAetherTrap, MomocraftTextures.TexBlockAetherPlank)).setBlockName("BlockAetherTrap").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherChestMimic = (new BlockPaille(MomocraftID.idBlockAetherChestMimic, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherChestMimic").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherTreasureChest = (new BlockPaille(MomocraftID.idBlockAetherTreasureChest, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherTreasureChest").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherDungeonStone = (new BlockPaille(MomocraftID.idBlockAetherDungeonStone, MomocraftTextures.TexBlockMomocraftTest)).setBlockName("BlockAetherDungeonStone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherLightDungeonStone = (new BlockPaille(MomocraftID.idBlockAetherLightDungeonStone, MomocraftTextures.TexBlockAetherSkyrootSapling)).setBlockName("BlockAetherLightDungeonStone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherLockedDungeonStone = (new BlockPaille(MomocraftID.idBlockAetherLockedDungeonStone, MomocraftTextures.TexBlockAetherGoldenOakSapling)).setBlockName("BlockAetherLockedDungeonStone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherLockedLightDungeonStone = (new BlockPaille(MomocraftID.idBlockAetherLockedLightDungeonStone, MomocraftTextures.TexBlockAetherAmbrosiumOre)).setBlockName("BlockAetherLockedLightDungeonStone").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherPillar = (new BlockPaille(MomocraftID.idBlockAetherPillar, MomocraftTextures.TexBlockAetherAmbrosiumTorch)).setBlockName("BlockAetherPillar").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherZanite = (new BlockPaille(MomocraftID.idBlockAetherZanite, MomocraftTextures.TexBlockAetherZaniteOre)).setBlockName("BlockAetherZanite").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherQuicksoilGlass = (new BlockPaille(MomocraftID.idBlockAetherQuicksoilGlass, MomocraftTextures.TexBlockAetherGravititeOre)).setBlockName("BlockAetherQuicksoilGlass").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherFreezer = (new BlockPaille(MomocraftID.idBlockAetherFreezer, MomocraftTextures.TexBlockAetherGravititeOre)).setBlockName("BlockAetherFreezer").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherWhiteFlower = (new BlockPaille(MomocraftID.idBlockAetherWhiteFlower, MomocraftTextures.TexBlockAetherPlank)).setBlockName("BlockAetherWhiteFlower").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherPurpleFlower = (new BlockPaille(MomocraftID.idBlockAetherPurpleFlower, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherPurpleFlower").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	public static final Block BlockAetherBed = (new BlockPaille(MomocraftID.idBlockAetherBed, MomocraftTextures.TexBlockAetherLockedChestSide)).setBlockName("BlockAetherBed").setHardness(0.4f).setStepSound(Block.soundClothFootstep);
	
}
