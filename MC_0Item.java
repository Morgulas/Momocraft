/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

import net.minecraft.src.*;
import java.util.*;

public class MC_0Item {
	
	//Variable de textures neutre
	static int steel = Block.blockSteel.blockIndexInTexture;
	static int glass = Block.blockSteel.blockIndexInTexture;
	
    //TestItem
    public static final Item ItemTest = new MC_2ItemTest(MC_0ID.iTest)
        .setItemName("TestItem")
        .setMaxStackSize(16)
        .setFull3D()
        .setIconIndex(MC_0Textures.iTest);
	
		
    
    public static int ObsidienneArmour = ModLoader.AddArmor("obsi");
    //Les Items
    public static final Item ItemLingotObsidienne = new Item(MC_0ID.iLingotObsidienne).setItemName("LingotObsidienne").setMaxStackSize(64).setIconIndex(MC_0Textures.iLingotObsidienne);
    public static final Item ItemObsiPioche = new ItemPickaxe(MC_0ID.iObsiPioche, EnumToolMaterial.EMERALD).setItemName("ObsiPioche").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiPioche);
    public static final Item ItemObsiPelle = new ItemSpade(MC_0ID.iObsiPelle, EnumToolMaterial.EMERALD).setItemName("ObsiPelle").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiPelle);
    public static final Item ItemObsiHache = new ItemAxe(MC_0ID.iObsiHache, EnumToolMaterial.EMERALD).setItemName("ObsiHache").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiHache);
    public static final Item ItemObsiBeche = new ItemHoe(MC_0ID.iObsiBeche, EnumToolMaterial.EMERALD).setItemName("ObsiBeche").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiBeche);
    public static final Item ItemObsiEpee = new ItemSword(MC_0ID.iObsiEpee, EnumToolMaterial.EMERALD).setItemName("ObsiEpee").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiEpee);
    public static final Item ItemObsiCasque = new ItemArmor(MC_0ID.iObsiCasque, EnumArmorMaterial.DIAMOND, ObsidienneArmour,0).setItemName("ObsiCasque").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiCasque);
    public static final Item ItemObsiPlastron = new ItemArmor(MC_0ID.iObsiPlastron, EnumArmorMaterial.DIAMOND, ObsidienneArmour,1).setItemName("ObsiPlastron").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiPlastron);
    public static final Item ItemObsiJambieres = new ItemArmor(MC_0ID.iObsiJambieres, EnumArmorMaterial.DIAMOND, ObsidienneArmour,2).setItemName("ObsiJambieres").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiJambieres);
    public static final Item ItemObsiBottes = new ItemArmor(MC_0ID.iObsiBottes, EnumArmorMaterial.DIAMOND, ObsidienneArmour,3).setItemName("ObsiBottes").setMaxStackSize(1).setIconIndex(MC_0Textures.iObsiBottes);
    public static final Item ItemBarreFer = new Item(MC_0ID.iBarreFer).setItemName("BarreFer").setMaxStackSize(64).setIconIndex(MC_0Textures.iBarreFer).setFull3D();
    public static final Item ItemCerclageFer = new Item(MC_0ID.iCerclageFer).setItemName("CerclageFer").setMaxStackSize(64).setIconIndex(MC_0Textures.iCerclageFer);
    public static final Item ItemBarreOr = new Item(MC_0ID.iBarreOr).setItemName("BarreOr").setMaxStackSize(64).setIconIndex(MC_0Textures.iBarreOr).setFull3D();
    public static final Item ItemCerclageOr = new Item(MC_0ID.iCerclageOr).setItemName("CerclageOr").setMaxStackSize(64).setIconIndex(MC_0Textures.iCerclageOr);
    public static final Item ItemBarreObsi = new Item(MC_0ID.iBarreObsi).setItemName("BarreObsi").setMaxStackSize(64).setIconIndex(MC_0Textures.iBarreObsi).setFull3D();
    public static final Item ItemCerclageObsi = new Item(MC_0ID.iCerclageObsi).setItemName("CerclageObsi").setMaxStackSize(64).setIconIndex(MC_0Textures.iCerclageObsi);
    public static final Item ItemRail = new MC_2ItemRail(MC_0ID.iRail).setItemName("Rail").setMaxStackSize(64).setIconIndex(MC_0Textures.iRail);
    public static final Item ItemCharniere = new MC_2ItemCharniere(MC_0ID.iCharniere).setItemName("Charniere").setMaxStackSize(64).setIconIndex(MC_0Textures.iBarreFer);
    
    public static final Item ItemBagWE = new Item(MC_0ID.iBagWE).setItemName("BaguetteWE").setMaxStackSize(1).setIconIndex(MC_0Textures.iBagWE).setFull3D();
    public static final Item ItemBagVoxel1 = new Item(MC_0ID.iBagVoxel1).setItemName("BaguetteVoxel1").setMaxStackSize(1).setIconIndex(MC_0Textures.iBagVoxel1).setFull3D();
    public static final Item ItemBagVoxel2 = new Item(MC_0ID.iBagVoxel2).setItemName("BaguetteVoxel2").setMaxStackSize(1).setIconIndex(MC_0Textures.iBagVoxel2).setFull3D();
    public static final Item ItemMapWG = new Item(MC_0ID.iMapWG).setItemName("MapWG").setMaxStackSize(1).setIconIndex(MC_0Textures.iMapWG);
    public static final Item ItemMapLog1 = new Item(MC_0ID.iMapLog1).setItemName("MapLog1").setMaxStackSize(1).setIconIndex(MC_0Textures.iMapLog1);
    public static final Item ItemMapLog2 = new Item(MC_0ID.iMapLog2).setItemName("MapLog2").setMaxStackSize(1).setIconIndex(MC_0Textures.iMapLog2);
    
    public static final Item ItemHoublon = new Item(MC_0ID.iHoublon).setItemName("Houblon").setMaxStackSize(64).setIconIndex(MC_0Textures.iHoublon);

    public static final Item ItemCapeLaineOrange = new Item(MC_0ID.iCapeLaineOrange).setItemName("CapeLaineOrange").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeOrange);
    public static final Item ItemCapeLaineBlanche = new Item(MC_0ID.iCapeLaineBlanche).setItemName("CapeLaineBlanche").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeBlanche);
    public static final Item ItemCapeLaineRouge = new Item(MC_0ID.iCapeLaineRouge).setItemName("CapeLaineRouge").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeRouge);
    public static final Item ItemCapeLaineNoire = new Item(MC_0ID.iCapeLaineNoire).setItemName("CapeLaineNoire").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeNoire);
    public static final Item ItemCapeLaineKaki = new Item(MC_0ID.iCapeLaineKaki).setItemName("CapeLaineKaki").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeKaki);
    public static final Item ItemCapeLaineMarron = new Item(MC_0ID.iCapeLaineMarron).setItemName("CapeLaineMarron").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeMarron);
    public static final Item ItemCapeLaineBleu = new Item(MC_0ID.iCapeLaineBleu).setItemName("CapeLaineBleu").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeBleu);
    public static final Item ItemCapeLaineViolette = new Item(MC_0ID.iCapeLaineViolette).setItemName("CapeLaineViolette").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeViolette);
    public static final Item ItemCapeLaineCyan = new Item(MC_0ID.iCapeLaineCyan).setItemName("CapeLaineCyan").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeCyan);
    public static final Item ItemCapeLaineGrisClair = new Item(MC_0ID.iCapeLaineGrisClair).setItemName("CapeLaineGrisClair").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeGrisClair);
    public static final Item ItemCapeLaineGris = new Item(MC_0ID.iCapeLaineGris).setItemName("CapeLaineGris").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeGris);
    public static final Item ItemCapeLaineRose = new Item(MC_0ID.iCapeLaineRose).setItemName("CapeLaineRose").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeRose);
    public static final Item ItemCapeLaineVerte = new Item(MC_0ID.iCapeLaineVerte).setItemName("CapeLaineVerte").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeVerte);
    public static final Item ItemCapeLaineJaune = new Item(MC_0ID.iCapeLaineJaune).setItemName("CapeLaineJaune").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeJaune);
    public static final Item ItemCapeLaineBleuClair = new Item(MC_0ID.iCapeLaineBleuClair).setItemName("CapeLaineBleuClair").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeBleuClair);
    public static final Item ItemCapeLaineMagenta = new Item(MC_0ID.iCapeLaineMagenta).setItemName("CapeLaineMagenta").setMaxStackSize(1).setIconIndex(MC_0Textures.iCapeMagenta);

    public static final Item ItemPileOrange = new Item(MC_0ID.iPileOrange).setItemName("pileorange").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileOrange);
    public static final Item ItemPileBlanche = new Item(MC_0ID.iPileBlanche).setItemName("pileblanc").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileBlanche);
    public static final Item ItemPileRouge = new Item(MC_0ID.iPileRouge).setItemName("pilerouge").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileRouge);
    public static final Item ItemPileNoire = new Item(MC_0ID.iPileNoire).setItemName("pilenoire").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileNoire);
    public static final Item ItemPileKaki = new Item(MC_0ID.iPileKaki).setItemName("pilekaki").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileKaki);
    public static final Item ItemPileMarron = new Item(MC_0ID.iPileMarron).setItemName("pilemarron").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileMarron);
    public static final Item ItemPileBleu = new Item(MC_0ID.iPileBleu).setItemName("pilebleu").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileBleu);
    public static final Item ItemPileViolette = new Item(MC_0ID.iPileViolette).setItemName("pileviolet").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileViolette);
    public static final Item ItemPileCyan = new Item(MC_0ID.iPileCyan).setItemName("pilecyan").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileCyan);
    public static final Item ItemPileGrisClair = new Item(MC_0ID.iPileGrisClair).setItemName("pilegrisclair").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileGrisClair);
    public static final Item ItemPileGris = new Item(MC_0ID.iPileGris).setItemName("pilegris").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileGris);
    public static final Item ItemPileRose = new Item(MC_0ID.iPileRose).setItemName("pilerose").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileRose);
    public static final Item ItemPileVerte = new Item(MC_0ID.iPileVerte).setItemName("pilevert").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileVerte);
    public static final Item ItemPileJaune = new Item(MC_0ID.iPileJaune).setItemName("pilejaune").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileJaune);
    public static final Item ItemPileBleuClair = new Item(MC_0ID.iPileBleuClair).setItemName("pilebleuclair").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileBleuClair);
    public static final Item ItemPileMagenta = new Item(MC_0ID.iPileMagenta).setItemName("pilemagenta").setMaxStackSize(1).setIconIndex(MC_0Textures.iPileMagenta);

//////////////////////////////////////////////////////////////////
//PROTOTYPE
//////////////////////////////////////////////////////////////////
    
//    public static final Item ItemPotion = new MC_2ItemPotion(MC_0ID.iPotion).setItemName("Potion").setMaxStackSize(64).setIconIndex(MC_0Textures.iTest);

    
    //Methode de rendu pour les items
    public static void AddRenderer(Map map)
    {

    }
	    
}
