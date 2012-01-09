/*
 *  - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

public class MC_0RegisterBlock {
	
	public MC_0RegisterBlock(){
		
///////////////////////////////////////////////////////////////////////////
//SECTION REGISTERBLOCK
///////////////////////////////////////////////////////////////////////////

		ModLoader.RegisterBlock(MC_0Block.BlockTest);
		ModLoader.RegisterBlock(MC_0Block.BlockPaille);
		ModLoader.RegisterBlock(MC_0Block.BlockArdoise);
		ModLoader.RegisterBlock(MC_0Block.BlockGlowstonePure);
		ModLoader.RegisterBlock(MC_0Block.BlockLanterneGlowstone);
		ModLoader.RegisterBlock(MC_0Block.BlockLanterneGlowstonePure);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierPaille);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierArdoise);
		ModLoader.RegisterBlock(MC_0Block.BlockHerbeLumineuse);

		ModLoader.RegisterBlock(MC_0Block.BlockEscalierStone);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierStonePolie);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierLog);

		ModLoader.RegisterBlock(MC_0Block.BlockDalle, net.minecraft.src.MC_2ItemStep.class);	

		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueDiamond);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueGlass);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueGlowStone);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueGlowStoneLight);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueGold);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueIce);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueLapis);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueObsidian);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaquePlanks);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueSandStone);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueSteel);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueStone);

		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth0);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth1);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth2);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth3);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth4);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth5);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth6);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth7);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth8);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth9);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth10);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth11);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth12);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth13);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth14);
		ModLoader.RegisterBlock(MC_0Block.BlockPlaqueCloth15);	
		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth0);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth1);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth2);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth3);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth4);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth5);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth6);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth7);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth8);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth9);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth10);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth11);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth12);
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth13);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth14);		
		ModLoader.RegisterBlock(MC_0Block.BlockEscalierCloth15);	
		
		//Arche
		ModLoader.RegisterBlock(MC_0Block.BlockArcheStep);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheSandstone);	
		ModLoader.RegisterBlock(MC_0Block.BlockArchePlank);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheCobblestone);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheBrick);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheStonebrick);
		
		ModLoader.RegisterBlock(MC_0Block.BlockArcheStone);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheLog);	

		ModLoader.RegisterBlock(MC_0Block.BlockArchePaille);	
		ModLoader.RegisterBlock(MC_0Block.BlockArcheArdoise);
		
		//Muret
		ModLoader.RegisterBlock(MC_0Block.BlockMuretStep);	
		ModLoader.RegisterBlock(MC_0Block.BlockMuretSandstone);	
		ModLoader.RegisterBlock(MC_0Block.BlockMuretPlank);	
		ModLoader.RegisterBlock(MC_0Block.BlockMuretCobblestone);	
		ModLoader.RegisterBlock(MC_0Block.BlockMuretBrick);	
		ModLoader.RegisterBlock(MC_0Block.BlockMuretStoneBrick);	
		
		ModLoader.RegisterBlock(MC_0Block.BlockMuretStone);	
		
		//Dalle de plafond
		ModLoader.RegisterBlock(MC_0Block.BlockDalleSup, net.minecraft.src.MC_2ItemDalleSup.class);

		ModLoader.RegisterBlock(MC_0Block.BlockRedStone0);
		ModLoader.RegisterBlock(MC_0Block.BlockRedStone1);
		
		ModLoader.RegisterBlock(MC_0Block.BlockBarriereFer);
		ModLoader.RegisterBlock(MC_0Block.BlockPortail);
		ModLoader.RegisterBlock(MC_0Block.BlockTrampoline);
		ModLoader.RegisterBlock(MC_0Block.BlockNuage);
		ModLoader.RegisterBlock(MC_0Block.BlockHerse);
		ModLoader.RegisterBlock(MC_0Block.BlockTonneau);
		ModLoader.RegisterBlock(MC_0Block.BlockChaine);
		ModLoader.RegisterBlock(MC_0Block.BlockVitre, net.minecraft.src.MC_2ItemVitre.class);
		ModLoader.RegisterBlock(MC_0Block.BlockVerre, net.minecraft.src.MC_2ItemVerre.class);
		ModLoader.RegisterBlock(MC_0Block.BlockCouverts);
		ModLoader.RegisterBlock(MC_0Block.BlockHoublon);
//		ModLoader.RegisterBlock(MC_0Block.BlockChaudronBiere);
//		ModLoader.RegisterBlock(MC_0Block.BlockLanceurdeFeu, net.minecraft.src.MC_2ItemFireworks.class);

		ModLoader.RegisterBlock(MC_0Block.BlockBucheHory, net.minecraft.src.MC_2ItemBucheHory.class);
		ModLoader.RegisterBlock(MC_0Block.BlockStepCloth, net.minecraft.src.MC_2ItemStepCloth.class);
		
//		ModLoader.RegisterBlock(MC_0Block.BlockMetaTest, net.minecraft.src.MC_2ItemMetaTest.class);
		
	}
}