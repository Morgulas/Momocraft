/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

public class MC_0Textures {
	
/////////////////////////////////////////////////////////////////////////	
//Déclaration des variables textures
/////////////////////////////////////////////////////////////////////////
	
	/*
	 * Attention! Si la même texture est chargé, seule la derniere occurence est prise en compte.
	 * 
	 */
	
    //Racourcir la fonction
	public static int overrideb(String chemin, String image)
	{
	         return ModLoader.addOverride("/terrain.png", (chemin + image));
	}
	
	public static int overridei(String chemin, String image)
	{
	         return ModLoader.addOverride("/gui/items.png", (chemin + image));
	}
	
//-------------------------------------------
// Blocs et Items de test
//-------------------------------------------
	
	//Les Blocs
	static String dossierb = "/momocraft/blocks/";
	public static final int bTest = overrideb(dossierb, "testbloc.png");		

	//Les Items
	static String dossieri = "/momocraft/items/";
	public static final int iTest = overridei(dossieri, "testitem.png");
	
	
//-------------------------------------------
// Les Blocs
//-------------------------------------------
	
	public static final int bPaille = overrideb(dossierb, "paille.png");
	public static final int bArdoise = overrideb(dossierb, "ardoise.png");
	public static final int bGlowstonePure = overrideb(dossierb, "glowstonepure.png");
	public static final int bLanterneGlowstone = overrideb(dossierb, "lanterneglowstone.png");
	public static final int bLanterneGlowstonePure = overrideb(dossierb, "lanterneglowstonepure.png");
	
	public static final int bRedstone0 = overrideb(dossierb, "redstone0.png");
	public static final int bRedstone1 = overrideb(dossierb, "redstone1.png");
	
//	public static final int bRedstone0 = overrideb(dossierb, "BlockredBlock.png");
//	public static final int bRedstone1 = overrideb(dossierb, "BlockredlightBlock.png");
	
	public static final int bTrampolineTop = overrideb(dossierb, "JumpTop.png");
	public static final int bTrampolineSide = overrideb(dossierb, "JumpSide.png");
	public static final int bTrampolineBottom = overrideb(dossierb, "Jump.png");
	public static final int bNuage = overrideb(dossierb, "Aercloud.png");
	public static final int bChaine = overrideb(dossierb, "Chaine.png");
	
	public static final int bVerreOrange = overrideb(dossierb, "verreorange.png");
	public static final int bVerreBlanc = overrideb(dossierb, "verreblanc.png");
	public static final int bVerreRouge = overrideb(dossierb, "verrerouge.png");
	public static final int bVerreNoir = overrideb(dossierb, "verrenoir.png");
	public static final int bVerreVertfonce = overrideb(dossierb, "verrevertfonce.png");
	public static final int bVerreBrun = overrideb(dossierb, "verrebrun.png");
	public static final int bVerreBleufonce = overrideb(dossierb, "verrebleufonce.png");
	public static final int bVerreViolet = overrideb(dossierb, "verreviolet.png");
	public static final int bVerreBleuClair = overrideb(dossierb, "verrebleuclair.png");
	public static final int bVerreGrisClair = overrideb(dossierb, "verregrisclair.png");
	public static final int bVerreGrisFonce = overrideb(dossierb, "verregrisfonce.png");
	public static final int bVerreRose = overrideb(dossierb, "verrerose.png");
	public static final int bVerreVertClair = overrideb(dossierb, "verrevertclair.png");
	public static final int bVerreJaune = overrideb(dossierb, "verrejaune.png");
	public static final int bVerreTurquoise = overrideb(dossierb, "verreturquoise.png");
	public static final int bVerreMagenta = overrideb(dossierb, "verremagenta.png");
	
	public static final int bCouverts = overrideb(dossierb, "couverts.png");
	
	public static final int bHoublon = overrideb(dossierb, "houblon.png");
	public static final int bLogSide1 = overrideb(dossierb, "logside1.png");
	public static final int bLogSide2 = overrideb(dossierb, "logside2.png");
	public static final int bLogSide3 = overrideb(dossierb, "logside3.png");
	
	public static final int bHoublonLiquide = overrideb(dossierb, "houblonliquide.png");
	
	
//-------------------------------------------
// Les Items
//-------------------------------------------
	
	public static final int iLingotObsidienne = overridei(dossieri, "obsidienneingot.png");
	public static final int iObsiPioche = overridei(dossieri, "obsipioche.png");
	public static final int iObsiPelle = overridei(dossieri, "obsipelle.png");
	public static final int iObsiHache = overridei(dossieri, "obsihache.png");
	public static final int iObsiBeche = overridei(dossieri, "obsibeche.png");
	public static final int iObsiEpee = overridei(dossieri, "obsiepee.png");
	public static final int iObsiCasque = overridei(dossieri, "casqueobsi.png");
	public static final int iObsiPlastron = overridei(dossieri, "armureobsi.png");
	public static final int iObsiJambieres = overridei(dossieri, "jambeobsi.png");
	public static final int iObsiBottes = overridei(dossieri, "piedobsi.png");
	public static final int iBarreFer = overridei(dossieri, "barredefer.png");
	public static final int iCerclageFer = overridei(dossieri, "cerclagefer.png");
	public static final int iBarreOr = overridei(dossieri, "barreor.png");
	public static final int iCerclageOr = overridei(dossieri, "cerclageor.png");
	public static final int iBarreObsi = overridei(dossieri, "barreobsi.png");
	public static final int iCerclageObsi = overridei(dossieri, "cerclageobsi.png");
	public static final int iRail = overridei(dossieri, "rail.png");
	
	public static final int iBagWE = overridei(dossieri, "worldedit.png");
	public static final int iBagVoxel1 = overridei(dossieri, "voxel1.png");
	public static final int iBagVoxel2 = overridei(dossieri, "voxel2.png");
	public static final int iMapWG = overridei(dossieri, "mapwg.png");
	public static final int iMapLog1 = overridei(dossieri, "maplog1.png");
	public static final int iMapLog2 = overridei(dossieri, "maplog2.png");
	public static final int iHoublon = overridei(dossierb, "houblon.png");
	
	public static final int iCapeOrange = overridei(dossieri, "capeorange.png");
	public static final int iCapeBlanche = overridei(dossieri, "capeblanche.png");
	public static final int iCapeRouge = overridei(dossieri, "caperouge.png");
	public static final int iCapeNoire = overridei(dossieri, "capenoir.png");
	public static final int iCapeKaki = overridei(dossieri, "capekaki.png");
	public static final int iCapeMarron = overridei(dossieri, "capemarron.png");
	public static final int iCapeBleu = overridei(dossieri, "capebleu.png");
	public static final int iCapeViolette = overridei(dossieri, "capeviolette.png");
	public static final int iCapeCyan = overridei(dossieri, "capecyan.png");
	public static final int iCapeGrisClair = overridei(dossieri, "capegrisclair.png");
	public static final int iCapeGris = overridei(dossieri, "capegris.png");
	public static final int iCapeRose = overridei(dossieri, "caperose.png");
	public static final int iCapeVerte = overridei(dossieri, "capeverte.png");
	public static final int iCapeJaune = overridei(dossieri, "capejaune.png");
	public static final int iCapeBleuClair = overridei(dossieri, "capebleuclair.png");
	public static final int iCapeMagenta = overridei(dossieri, "capemagenta.png");
	
	public static final int iPileOrange = overridei(dossieri, "pileorange.png");
	public static final int iPileBlanche = overridei(dossieri, "pileblanc.png");
	public static final int iPileRouge = overridei(dossieri, "pilerouge.png");
	public static final int iPileNoire = overridei(dossieri, "pilenoir.png");
	public static final int iPileKaki = overridei(dossieri, "pilekaki.png");
	public static final int iPileMarron = overridei(dossieri, "pilemarron.png");
	public static final int iPileBleu = overridei(dossieri, "pilebleu.png");
	public static final int iPileViolette = overridei(dossieri, "pileviolet.png");
	public static final int iPileCyan = overridei(dossieri, "pilecyan.png");
	public static final int iPileGrisClair = overridei(dossieri, "pilegrisclair.png");
	public static final int iPileGris = overridei(dossieri, "pilegris.png");
	public static final int iPileRose = overridei(dossieri, "pilerose.png");
	public static final int iPileVerte = overridei(dossieri, "pilevert.png");
	public static final int iPileJaune = overridei(dossieri, "pilejaune.png");
	public static final int iPileBleuClair = overridei(dossieri, "pilebleuclair.png");
	public static final int iPileMagenta = overridei(dossieri, "pilemagenta.png");

}
