/*
 * Mod Momocraft - SteveVuillaume
 * 
 * stevevuillaume@gmail.com
 * Pt:1
 * 
 */


package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

import java.util.*;


public class MMC_Item {
	
	//Variable de textures neutre
	static int steel = Block.blockSteel.blockIndexInTexture;
	static int glass = Block.blockSteel.blockIndexInTexture;
	
//-------------------------------------------
// Momocraft
//-------------------------------------------	
	
		//TestItem
		public static final Item ItemMomocraftTestItem = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemMomocraftTest /*Id du block*/))
				.setItemName("TestItem")								//Redefinir le nom de l'item de la variable
				.setMaxStackSize(16)									//Stack maximum
				.setFull3D()											//Permet de creer l'objet en 3D comme une hache
				.setIconIndex(MMC_Textures.TexItemMomocraftTest);	//Texture de l'item
		
		
		public static final Item ItemMomocraftCharniere = new MMC_ItemCharniere(MMC_ID.idItemMomocraftCharniere).setItemName("Charniere").setIconIndex(MMC_Textures.TexItemMomocraftTest);
		public static final Item ItemMomocraftRail = new MMC_ItemRail(MMC_ID.idItemMomocraftRail).setItemName("Rail").setIconIndex(MMC_Textures.TexItemMomocraftTest);
		
//-------------------------------------------
// Minefield
//-------------------------------------------		
		
		public static final Item ItemMinefieldBierre = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldBierre").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);		
		public static final Item ItemMinefieldBarreDeFer = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldBarreDeFer").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);
		public static final Item ItemMinefieldObsiEpee = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsiEpee").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);	
		public static final Item ItemMinefieldObsiPioche = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsiPioche").setMaxStackSize(1).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);	
		public static final Item ItemMinefieldObsiPelle = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsiPelle").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);	
		public static final Item ItemMinefieldObsiHache = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsiHache").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);
		public static final Item ItemMinefieldObsiBeche = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsiBeche").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);
		public static final Item ItemMinefieldObsidienneIngot = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldObsidienneIngot").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);	
		public static final Item ItemMinefieldCerclageFer = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldCerclageFer").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);
		public static final Item ItemMinefieldCarte = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldCarte").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);
		
		//Les rideaux
		public static final Item ItemMinefieldRideauBlanc = (new MMC_ItemMomocraftTestItem (MMC_ID.idItemMomocraftTest)).setItemName("ItemMinefieldRideauBlanc").setMaxStackSize(16).setFull3D().setIconIndex(MMC_Textures.TexItemMomocraftTest);

		
//-------------------------------------------
// Aether Mod
//-------------------------------------------
		
/*Les mineraux*/
		
/*Les armures*/
		//Gants
		public static String accessoires = "/armor/Accessories.png";
		public static final Item ItemAetherLeatherGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherLeatherGlove, 0, accessoires, 10, MMC_Couleur.LeatherGlove)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherLeatherGlove");	
		public static final Item ItemAetherIronGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherIronGlove, 2, accessoires, 10, MMC_Couleur.IronGlove)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherIronGlove");	
		public static final Item ItemAetherGoldGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherGoldGlove, 1, accessoires, 10, MMC_Couleur.GoldGlove)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherGoldGlove");	
		public static final Item ItemAetherDiamondGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherDiamondGlove, 3, accessoires, 10, MMC_Couleur.DiamondGlove)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherDiamondGlove");
		public static final Item ItemAetherObsidianGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherObsidianGlove, 2, accessoires, 10, MMC_Couleur.ObsidianGlove)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherObsidianGlove");	
		public static final Item ItemAetherZaniteGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherZaniteGlove, 3, accessoires, 10, MMC_Couleur.Zanite)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherZaniteGlove");	
		public static final Item ItemAetherGravititeGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherGravititeGlove, 3, accessoires, 10, MMC_Couleur.Gravitite)).setIconIndex(MMC_Textures.TexItemAetherGlove).setItemName("ItemAetherGravititeGlove");	
		public static final Item ItemAetherPhoenixGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherPhoenixGlove, 4, accessoires, 10, MMC_Couleur.Phoenix)).setIconIndex(MMC_Textures.TexItemAetherGloveChain).setItemName("ItemAetherPhoenixGlove");	
		public static final Item ItemAetherNeptuneGlove = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherNeptuneGlove, 3, accessoires, 10, MMC_Couleur.Neptune)).setIconIndex(MMC_Textures.TexItemAetherGloveChain).setItemName("ItemAetherNeptuneGlove");	

		
		//Armure en zanite
		public static int zaniteArmour = ModLoader.AddArmor("Zanite");
		public static final Item ItemAetherZaniteHelmet = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherZaniteHelmet,EnumArmorMaterial.IRON,zaniteArmour,0, MMC_Couleur.Zanite)).setIconIndex(2).setItemName("ItemAetherZaniteHelmet");	
		public static final Item ItemAetherZaniteChestplate = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherZaniteChestplate,EnumArmorMaterial.IRON,zaniteArmour,1, MMC_Couleur.Zanite)).setIconIndex(18).setItemName("ItemAetherZaniteChestplate");	
		public static final Item ItemAetherZaniteLeggings = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherZaniteLeggings,EnumArmorMaterial.IRON,zaniteArmour,2, MMC_Couleur.Zanite)).setIconIndex(34).setItemName("ItemAetherZaniteLeggings");	
		public static final Item ItemAetherZaniteBoots = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherZaniteBoots,EnumArmorMaterial.IRON,zaniteArmour,3, MMC_Couleur.Zanite)).setIconIndex(50).setItemName("ItemAetherZaniteBoots");	
		
		//Armure en gravitite
		public static int gravititeArmour = ModLoader.AddArmor("Gravitite");
		public static final Item ItemAetherGravititeHelmet = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherGravititeHelmet,EnumArmorMaterial.DIAMOND,gravititeArmour,0, MMC_Couleur.Gravitite)).setIconIndex(2).setItemName("ItemAetherGravititeHelmet");	
		public static final Item ItemAetherGravititeBodyplate = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherGravititeBodyplate,EnumArmorMaterial.DIAMOND,gravititeArmour,1, MMC_Couleur.Gravitite)).setIconIndex(18).setItemName("ItemAetherGravititeBodyplate");	
		public static final Item ItemAetherGravititePlatelegs = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherGravititePlatelegs,EnumArmorMaterial.DIAMOND,gravititeArmour,2, MMC_Couleur.Gravitite)).setIconIndex(34).setItemName("ItemAetherGravititePlatelegs");	
		public static final Item ItemAetherGravititeBoots = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherGravititeBoots,EnumArmorMaterial.DIAMOND,gravititeArmour,3, MMC_Couleur.Gravitite)).setIconIndex(50).setItemName("ItemAetherGravititeBoots");	
		
		//Armure du Phoenix
		public static int phoenixArmour = ModLoader.AddArmor("Phoenix");
		public static final Item ItemAetherPhoenixHelm = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherPhoenixHelm,EnumArmorMaterial.DIAMOND,phoenixArmour,0, MMC_Couleur.Phoenix)).setIconIndex(1).setItemName("ItemAetherPhoenixHelm");	
		public static final Item ItemAetherPhoenixBody = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherPhoenixBody,EnumArmorMaterial.DIAMOND,phoenixArmour,1, MMC_Couleur.Phoenix)).setIconIndex(17).setItemName("ItemAetherPhoenixBody");	
		public static final Item ItemAetherPhoenixLegs = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherPhoenixLegs,EnumArmorMaterial.DIAMOND,phoenixArmour,2, MMC_Couleur.Phoenix)).setIconIndex(33).setItemName("ItemAetherPhoenixLegs");	
		public static final Item ItemAetherPhoenixBoots = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherPhoenixBoots,EnumArmorMaterial.DIAMOND,phoenixArmour,3, MMC_Couleur.Phoenix)).setIconIndex(49).setItemName("ItemAetherPhoenixBoots");
		
		//Armure d'obsidienne
/*	Désactivé car doublon avec Minefield qui est mieux	
		public static int obsiArmour = ModLoader.AddArmor("obsi");
		public static final Item ItemAetherObsidianHelm = (new ItemCasqueObsi(MomocraftID.idItemAetherObsidianHelm,EnumArmorMaterial.GOLD,obsiArmour,0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/casqueobsi.png")).setItemName("ItemAetherObsidianHelm");	
		public static final Item ItemAetherObsidianBody = (new ItemArmureObsi(MomocraftID.idItemAetherObsidianBody,EnumArmorMaterial.GOLD,obsiArmour,1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/armureobsi.png")).setItemName("ItemAetherObsidianBody");	
		public static final Item ItemAetherObsidianLegs = (new ItemJambeObsi(MomocraftID.idItemAetherObsidianLegs,EnumArmorMaterial.GOLD,obsiArmour,2)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/jambeobsi.png")).setItemName("ItemAetherObsidianLegs");	
		public static final Item ItemAetherObsidianBoots = (new ItemPiedObsi(MomocraftID.idItemAetherObsidianBoots,EnumArmorMaterial.GOLD,obsiArmour,3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/piedobsi.png")).setItemName("ItemAetherObsidianBoots");
*/		
		//Armure de Neptune
		public static int neptuneArmour = ModLoader.AddArmor("Neptune");
		public static final Item ItemAetherNeptuneHelmet = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherNeptuneHelmet,EnumArmorMaterial.DIAMOND,neptuneArmour,0, MMC_Couleur.Neptune)).setIconIndex(1).setItemName("ItemAetherNeptuneHelmet");	
		public static final Item ItemAetherNeptuneChestplate = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherNeptuneChestplate,EnumArmorMaterial.DIAMOND,neptuneArmour,1, MMC_Couleur.Neptune)).setIconIndex(17).setItemName("ItemAetherNeptuneChestplate");	
		public static final Item ItemAetherNeptuneLeggings = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherNeptuneLeggings,EnumArmorMaterial.DIAMOND,neptuneArmour,2, MMC_Couleur.Neptune)).setIconIndex(33).setItemName("ItemAetherNeptuneLeggings");	
		public static final Item ItemAetherNeptuneBoots = (new MMC_ItemColouredArmor(MMC_ID.idItemAetherNeptuneBoots,EnumArmorMaterial.DIAMOND,neptuneArmour,3, MMC_Couleur.Neptune)).setIconIndex(49).setItemName("ItemAetherNeptuneBoots");	
		
		

		
/*Les accessoires*/
		
/*Les outils et armes selon modele de materiaux défini*/
        static EnumToolMaterial enumtoolmaterial1 = EnumToolMaterial.WOOD;
		public static final Item ItemAetherSwordSkyroot = (new ItemSword(MMC_ID.idItemAetherSwordSkyroot, enumtoolmaterial1)).setIconIndex(MMC_Textures.TexItemAetherSwordSkyroot).setItemName("ItemAetherSwordSkyroot");
		public static final Item ItemAetherAxeSkyroot = (new MMC_ItemAetherAxeSkyroot(MMC_ID.idItemAetherAxeSkyroot, enumtoolmaterial1)).setIconIndex(MMC_Textures.TexItemAetherAxeSkyroot).setItemName("ItemAetherAxeSkyroot");	
		public static final Item ItemAetherPickSkyroot = (new MMC_ItemAetherPickSkyroot(MMC_ID.idItemAetherPickSkyroot, enumtoolmaterial1)).setIconIndex(MMC_Textures.TexItemAetherPickSkyroot).setItemName("ItemAetherPickSkyroot");	
		public static final Item ItemAetherShovelSkyroot = (new MMC_ItemAetherShovelSkyroot(MMC_ID.idItemAetherShovelSkyroot, enumtoolmaterial1)).setIconIndex(MMC_Textures.TexItemAetherShovelSkyroot).setItemName("ItemAetherShovelSkyroot");	
		
        static EnumToolMaterial enumtoolmaterial2 = EnumToolMaterial.STONE;
		public static final Item ItemAetherSwordHolystone = (new MMC_ItemAetherSwordHolystone(MMC_ID.idItemAetherSwordHolystone, enumtoolmaterial2)).setIconIndex(MMC_Textures.TexItemAetherSwordHolystone).setItemName("ItemAetherSwordHolystone");	
		public static final Item ItemAetherAxeHolystone = (new MMC_ItemAetherAxeHolystone(MMC_ID.idItemAetherAxeHolystone, enumtoolmaterial2)).setIconIndex(MMC_Textures.TexItemAetherAxeHolystone).setItemName("ItemAetherAxeHolystone");	
		public static final Item ItemAetherPickHolystone = (new MMC_ItemAetherPickHolystone(MMC_ID.idItemAetherPickHolystone, enumtoolmaterial2)).setIconIndex(MMC_Textures.TexItemAetherPickHolystone).setItemName("ItemAetherPickHolystone");	
		public static final Item ItemAetherShovelHolystone = (new MMC_ItemAetherShovelHolystone(MMC_ID.idItemAetherShovelHolystone, enumtoolmaterial2)).setIconIndex(MMC_Textures.TexItemAetherShovelHolystone).setItemName("ItemAetherShovelHolystone");	

        static EnumToolMaterial enumtoolmaterial3 = EnumToolMaterial.IRON;
		public static final Item ItemAetherSwordZanite = (new MMC_ItemAetherSwordZanite(MMC_ID.idItemAetherSwordZanite, enumtoolmaterial3)).setIconIndex(MMC_Textures.TexItemAetherSwordZanite).setItemName("ItemAetherSwordZanite");	
		public static final Item ItemAetherAxeZanite = (new MMC_ItemAetherAxeZanite(MMC_ID.idItemAetherAxeZanite, enumtoolmaterial3)).setIconIndex(MMC_Textures.TexItemAetherAxeZanite).setItemName("ItemAetherAxeZanite");	
		public static final Item ItemAetherPickZanite = (new MMC_ItemAetherPickZanite(MMC_ID.idItemAetherPickZanite, enumtoolmaterial3)).setIconIndex(MMC_Textures.TexItemAetherPickZanite).setItemName("ItemAetherPickZanite");	
		public static final Item ItemAetherShovelZanite = (new MMC_ItemAetherShovelZanite(MMC_ID.idItemAetherShovelZanite, enumtoolmaterial3)).setIconIndex(MMC_Textures.TexItemAetherShovelZanite).setItemName("ItemAetherShovelZanite");	

        static EnumToolMaterial enumtoolmaterial4 = EnumToolMaterial.EMERALD;
		public static final Item ItemAetherSwordGravitite = (new MMC_ItemAetherSwordGravitite(MMC_ID.idItemAetherSwordGravitite, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherSwordGravitite).setItemName("ItemAetherSwordGravitite");	
		public static final Item ItemAetherAxeGravitite = (new MMC_ItemAetherAxeGravitite(MMC_ID.idItemAetherAxeGravitite, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherAxeGravitite).setItemName("ItemAetherAxeGravitite");	
		public static final Item ItemAetherPickGravitite = (new MMC_ItemAetherPickGravitite(MMC_ID.idItemAetherPickGravitite, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherPickGravitite).setItemName("ItemAetherPickGravitite");	
		public static final Item ItemAetherShovelGravitite = (new MMC_ItemAetherShovelGravitite(MMC_ID.idItemAetherShovelGravitite, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherShovelGravitite).setItemName("ItemAetherShovelGravitite");
		public static final Item ItemAetherPickValkyrie = (new MMC_ItemAetherPickValkyrie(MMC_ID.idItemAetherPickValkyrie, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherValkyriePickaxe).setItemName("ItemAetherPickValkyrie");	
		public static final Item ItemAetherAxeValkyrie = (new MMC_ItemAetherAxeValkyrie(MMC_ID.idItemAetherAxeValkyrie, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherValkyrieAxe).setItemName("ItemAetherAxeValkyrie");	
		public static final Item ItemAetherShovelValkyrie = (new MMC_ItemAetherShovelValkyrie(MMC_ID.idItemAetherShovelValkyrie, enumtoolmaterial4)).setIconIndex(MMC_Textures.TexItemAetherValkyrieShovel).setItemName("ItemAetherShovelValkyrie");	
		
/*Les composants*/
		public static final Item ItemAetherAechorPetal = (new MMC_ItemAetherAechorPetal(MMC_ID.idItemAetherAechorPetal)).setIconIndex(MMC_Textures.TexItemAetherAechorPetal).setItemName("ItemAetherAechorPetal");	

/*Divers*/
		public static final Item ItemAetherVictoryMedal = (new MMC_ItemAetherVictoryMedal(MMC_ID.idItemAetherVictoryMedal)).setIconIndex(MMC_Textures.TexItemAetherVictoryMedal).setItemName("ItemAetherVictoryMedal");	
		public static final Item ItemAetherKey = (new MMC_ItemAetherKey(MMC_ID.idItemAetherKey)).setIconIndex(MMC_Textures.TexItemAetherKey).setItemName("ItemAetherKey");	
		public static final Item ItemAetherLoreBook = (new MMC_ItemAetherLoreBook(MMC_ID.idItemAetherLoreBook)).setIconIndex(59).setItemName("ItemAetherLoreBook");	
		public static final Item ItemAetherMoaEgg = (new MMC_ItemAetherMoaEgg(MMC_ID.idItemAetherMoaEgg)).setIconIndex(MMC_Textures.TexItemAetherMoaEgg).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherBlueMusicDisk = (new MMC_ItemAetherBlueMusicDisk(MMC_ID.idItemAetherBlueMusicDisk)).setIconIndex(MMC_Textures.TexItemAetherBlueMusicDisk).setItemName("ItemAetherBlueMusicDisk");	
		public static final Item ItemAetherGoldenAmber = (new MMC_ItemAetherGoldenAmber(MMC_ID.idItemAetherGoldenAmber)).setIconIndex(MMC_Textures.TexItemAetherGoldenAmber).setItemName("ItemAetherGoldenAmber");	
		public static final Item ItemAetherStick = (new MMC_ItemAetherStick(MMC_ID.idItemAetherStick)).setIconIndex(MMC_Textures.TexItemAetherStick).setItemName("ItemAetherStick");	
		public static final Item ItemAetherDart = (new MMC_ItemAetherDart(MMC_ID.idItemAetherDart)).setIconIndex(MMC_Textures.TexItemAetherDartGolden).setItemName("ItemAetherDart");	
		public static final Item ItemAetherDartShooter = (new MMC_ItemAetherDartShooter(MMC_ID.idItemAetherDartShooter)).setIconIndex(MMC_Textures.TexItemAetherDartShooter).setItemName("ItemAetherDartShooter");	
		public static final Item ItemAetherAmbrosiumShard = (new MMC_ItemAetherAmbrosiumShard(MMC_ID.idItemAetherAmbrosiumShard, 1)).setIconIndex(MMC_Textures.TexItemAetherAmbrosiumShard).setItemName("ItemAetherAmbrosiumShard");	
		public static final Item ItemAetherZanite = (new Item(MMC_ID.idItemAetherZanite)).setIconIndex(MMC_Textures.TexItemAetherZanite).setItemName("ItemAetherZanite");	
		public static final Item ItemAetherBucket = (new MMC_ItemAetherBucket(MMC_ID.idItemAetherBucket)).setIconIndex(MMC_Textures.TexItemAetherBucket).setItemName("ItemAetherBucket");	
	

		
		public static final Item ItemAetherIronBubble = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherIronBubble)).setIconIndex(MMC_Textures.TexItemAetherIronBubble).setItemName("ItemAetherIronBubble");	
		public static final Item ItemAetherPigSlayer = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherPigSlayer)).setIconIndex(MMC_Textures.TexItemAetherPigSlayer).setItemName("ItemAetherPigSlayer");	
		public static final Item ItemAetherVampireBlade = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherVampireBlade)).setIconIndex(MMC_Textures.TexItemAetherVampireBlade).setItemName("ItemAetherVampireBlade");	
		public static final Item ItemAetherNatureStaff = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherNatureStaff)).setIconIndex(MMC_Textures.TexItemAetherNatureStaff).setItemName("ItemAetherNatureStaff");	
		
		public static final Item ItemAetherSwordFire = (new MMC_ItemSwordElemental(MMC_ID.idItemAetherSwordFire, MMC_EnumElement.Fire, -20609)).setIconIndex(MMC_Textures.TexItemAetherElementalSword).setItemName("ItemAetherSwordFire");	
		public static final Item ItemAetherSwordHoly = (new MMC_ItemSwordElemental(MMC_ID.idItemAetherSwordHoly, MMC_EnumElement.Holy, -81)).setIconIndex(MMC_Textures.TexItemAetherElementalSword).setItemName("ItemAetherSwordHoly");	
		public static final Item ItemAetherSwordLightning = (new MMC_ItemSwordElemental(MMC_ID.idItemAetherSwordLightning, MMC_EnumElement.Lightning, -5242881)).setIconIndex(MMC_Textures.TexItemAetherElementalSword).setItemName("ItemAetherSwordLightning");	
		
		public static final Item ItemAetherLightningKnife = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherLightningKnife)).setIconIndex(MMC_Textures.TexItemAetherLightningKnife).setItemName("ItemAetherLightningKnife");	
		public static final Item ItemAetherGummieSwet = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherGummieSwet)).setIconIndex(MMC_Textures.TexItemAetherGummieSwet).setItemName("ItemAetherGummieSwet");	
		public static final Item ItemAetherHammerNotch = (new MMC_ItemAetherHammerNotch(MMC_ID.idItemAetherHammerNotch)).setIconIndex(MMC_Textures.TexItemAetherHammerNotch).setItemName("ItemAetherHammerNotch");	
		public static final Item ItemAetherPhoenixBow = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherPhoenixBow)).setIconIndex(MMC_Textures.TexItemAetherPhoenixBow).setItemName("ItemAetherPhoenixBow");	
		public static final Item ItemAetherCloudParachute = (new MMC_ItemAetherCloudParachute(MMC_ID.idItemAetherCloudParachute)).setIconIndex(MMC_Textures.TexItemAetherCloudParachute).setItemName("ItemAetherCloudParachute");	
		public static final Item ItemAetherCloudParachuteGold = (new MMC_ItemAetherCloudParachute(MMC_ID.idItemAetherCloudParachuteGold)).setIconIndex(MMC_Textures.TexItemAetherCloudParachute).setItemName("ItemAetherCloudParachuteGold");	
		public static final Item ItemAetherCloudStaff = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherCloudStaff)).setIconIndex(MMC_Textures.TexItemAetherCloudStaff).setItemName("ItemAetherCloudStaff");	
		public static final Item ItemAetherLifeShard = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherLifeShard)).setIconIndex(MMC_Textures.TexItemAetherLifeShard).setItemName("ItemAetherLifeShard");	
		public static final Item ItemAetherGoldenFeather = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherGoldenFeather)).setIconIndex(MMC_Textures.TexItemAetherGoldenFeather).setItemName("ItemAetherGoldenFeather");	
		public static final Item ItemAetherLance = (new MMC_ItemMomocraftTestItem(MMC_ID.idItemAetherLance)).setIconIndex(MMC_Textures.TexItemAetherLance).setItemName("ItemAetherLance");	
		
		//Anneaux
		public static final Item ItemAetherIronRing = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherIronRing, 0, accessoires, 8, 16777215)).setIconIndex(MMC_Textures.TexItemAetherRing).setItemName("ItemAetherIronRing");	
		public static final Item ItemAetherGoldRing = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherGoldRing, 0, accessoires, 8, 16776994)).setIconIndex(MMC_Textures.TexItemAetherRing).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherZaniteRing = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherZaniteRing, 0, accessoires, 8, 7412456)).setIconIndex(MMC_Textures.TexItemAetherRing).setItemName("ItemAetherZaniteRing");	
		public static final Item ItemAetherIceRing = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherIceRing, 0, accessoires, 8, 9823975)).setIconIndex(MMC_Textures.TexItemAetherRing).setItemName("ItemAetherIceRing");	
		
		//Pendentifs
		public static final Item ItemAetherIronPendant = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherIronPendant, 0, accessoires, 4, 16777215)).setIconIndex(MMC_Textures.TexItemAetherPendant).setItemName("ItemAetherIronPendant");	
		public static final Item ItemAetherGoldPendant = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherGoldPendant, 0, accessoires, 4, 16776994)).setIconIndex(MMC_Textures.TexItemAetherPendant).setItemName("ItemAetherGoldPendant");	
		public static final Item ItemAetherZanitePendant = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherZanitePendant, 0, accessoires, 4, 7412456)).setIconIndex(MMC_Textures.TexItemAetherPendant).setItemName("ItemAetherZanitePendant");	
		public static final Item ItemAetherIcePendant = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherIcePendant, 0, accessoires, 4, 9823975)).setIconIndex(MMC_Textures.TexItemAetherPendant).setItemName("ItemAetherIcePendant");	

		//Divers protection
		public static final Item ItemAetherRepShield = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherRepShield, 0, 0, 6, 16777215)).setIconIndex(MMC_Textures.TexItemAetherRepulsionShield).setItemName("ItemAetherRepShield");	
		public static final Item ItemAetherAetherCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherCape, 0, "/aether/other/AetherCape.png", 5)).setIconIndex(MMC_Textures.TexItemAetherCape).setItemName("ItemAetherAetherCape");	
		public static final Item ItemAetherInvisibilityCloak = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherInvisibilityCloak, 0, 0, 5)).setIconIndex(MMC_Textures.TexItemAetherInvisibilityCloak).setItemName("ItemAetherInvisibilityCloak");	
		public static final Item ItemAetherAgilityCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherAgilityCape, 0, "/aether/other/AgilityCape.png", 5)).setIconIndex(MMC_Textures.TexItemAetherAgilityCape).setItemName("ItemAetherAgilityCape");	
		
		//Capes
		public static final Item ItemAetherWhiteCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherWhiteCape, 0, "/momocraft/aether/other/WhiteCape.png", 5)).setIconIndex(MMC_Textures.TexItemAetherCape).setItemName("ItemAetherWhiteCape");	
		public static final Item ItemAetherRedCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherRedCape, 0, "/momocraft/aether/other/RedCape.png", 5, MMC_Couleur.RedCape)).setIconIndex(MMC_Textures.TexItemAetherCape).setItemName("ItemAetherRedCape");	
		public static final Item ItemAetherYellowCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherYellowCape, 0, "/momocraft/aether/other/YellowCape.png", 5, MMC_Couleur.YellowCape)).setIconIndex(MMC_Textures.TexItemAetherCape).setItemName("ItemAetherYellowCape");	
		public static final Item ItemAetherBlueCape = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherBlueCape, 0, "/momocraft/aether/other/BlueCape.png", 5, MMC_Couleur.BlueCape)).setIconIndex(MMC_Textures.TexItemAetherCape).setItemName("ItemAetherBlueCape");	
		
		//Bijou
		public static final Item ItemAetherRegenerationStone = (new MMC_ItemMoreArmor(MMC_ID.idItemAetherRegenerationStone, 0, 0, 7)).setIconIndex(MMC_Textures.TexItemAetherRegenerationStone).setItemName("ItemAetherRegenerationStone");	
		public static final Item ItemAetherHealingStone = (new MMC_ItemAetherAmbrosiumShard(MMC_ID.idItemAetherHealingStone, 4)).setIconIndex(MMC_Textures.TexItemAetherHealingStone).setItemName("ItemAetherHealingStone");	
	
		
/////////////////////////////////////////////////////////////////////////
//	Methodes
/////////////////////////////////////////////////////////////////////////

		//Methode de rendu pour les items
	    public static void AddRenderer(Map map)
	    {
	        map.put(MMC_EntityNotchWave.class, new MMC_RenderNotchWave());

	    }
}
