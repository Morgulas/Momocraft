package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Momocraft.*;

import java.util.*;


public class MomocraftItems {
	
	
//-------------------------------------------
// Momocraft
//-------------------------------------------	
	
		//TestItem
		public static final Item TestItem = (new ItemTestItem(MomocraftID.idItemMomocraftTest /*Id du block*/))
				.setItemName("TestItem")								//Redefinir le nom de l'item de la variable
				.setMaxStackSize(16)									//Stack maximum
				.setFull3D()											//Permet de creer l'objet en 3D comme une hache
				.setIconIndex(MomocraftTextures.TexItemMomocraftTest);	//Texture de l'item
		
//-------------------------------------------
// Minefield
//-------------------------------------------		
		
		public static final Item ObsiSword = (new ItemObsiSword(MomocraftID.idItemMomocraftTest)).setItemName("ObsiSword").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);		
		public static final Item Chope = (new ItemChope(MomocraftID.idItemMomocraftTest)).setItemName("Chope").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);
		public static final Item IronBar = (new ItemIronBar(MomocraftID.idItemMomocraftTest)).setItemName("IronBar").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);	
		public static final Item CasqueObsi = (new ItemCasqueObsi (MomocraftID.idItemMomocraftTest, EnumArmorMaterial.DIAMOND, ModLoader.AddArmor("obsi"), 0)).setItemName("CasqueObsi").setMaxStackSize(1).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);	
		public static final Item ArmureObsi = (new ItemArmureObsi (MomocraftID.idItemMomocraftTest, EnumArmorMaterial.DIAMOND, ModLoader.AddArmor("obsi"), 1)).setItemName("ArmureObsi").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);	
		public static final Item JambeObsi = (new ItemJambeObsi (MomocraftID.idItemMomocraftTest, EnumArmorMaterial.DIAMOND, ModLoader.AddArmor("obsi"), 2)).setItemName("JambeObsi").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);
		public static final Item PiedObsi = (new ItemPiedObsi (MomocraftID.idItemMomocraftTest, EnumArmorMaterial.DIAMOND, ModLoader.AddArmor("obsi"), 3)).setItemName("PiedObsi").setMaxStackSize(16).setFull3D().setIconIndex(MomocraftTextures.TexItemMomocraftTest);
		
//-------------------------------------------
// Aether Mod
//-------------------------------------------
		
/*Les mineraux*/
		
/*Les armures*/
		//Gants
		public static String accessoires = "Zanite";
		public static final Item ItemAetherLeatherGlove = (new ItemMoreArmor(MomocraftID.idItemAetherLeatherGlove, 1, accessoires, 10, MomocraftCouleur.LeatherGlove)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherLeatherGlove");	
		public static final Item ItemAetherIronGlove = (new ItemMoreArmor(MomocraftID.idItemAetherIronGlove, 1, accessoires, 10, MomocraftCouleur.IronGlove)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherIronGlove");	
		public static final Item ItemAetherGoldGlove = (new ItemMoreArmor(MomocraftID.idItemAetherGoldGlove, 1, accessoires, 10, MomocraftCouleur.GoldGlove)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherGoldGlove");	
		public static final Item ItemAetherDiamondGlove = (new ItemMoreArmor(MomocraftID.idItemAetherDiamondGlove, 1, accessoires, 10, MomocraftCouleur.DiamondGlove)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherDiamondGlove");
		public static final Item ItemAetherObsidianGlove = (new ItemMoreArmor(MomocraftID.idItemAetherObsidianGlove, 1, accessoires, 10, MomocraftCouleur.ObsidianGlove)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherObsidianGlove");	
		public static final Item ItemAetherZaniteGlove = (new ItemMoreArmor(MomocraftID.idItemAetherZaniteGlove, 1, accessoires, 10, MomocraftCouleur.Zanite)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherZaniteGlove");	
		public static final Item ItemAetherGravititeGlove = (new ItemMoreArmor(MomocraftID.idItemAetherGravititeGlove, 1, accessoires, 10, MomocraftCouleur.Gravitite)).setIconIndex(MomocraftTextures.TexItemAetherGlove).setItemName("ItemAetherGravititeGlove");	
		public static final Item ItemAetherPhoenixGlove = (new ItemMoreArmor(MomocraftID.idItemAetherPhoenixGlove, 1, accessoires, 10, MomocraftCouleur.Phoenix)).setIconIndex(MomocraftTextures.TexItemAetherGloveChain).setItemName("ItemAetherPhoenixGlove");	
		public static final Item ItemAetherNeptuneGlove = (new ItemMoreArmor(MomocraftID.idItemAetherNeptuneGlove, 1, accessoires, 10, MomocraftCouleur.Neptune)).setIconIndex(MomocraftTextures.TexItemAetherGloveChain).setItemName("ItemAetherNeptuneGlove");	

		
		//Armure en zanite
		public static int zaniteArmour = ModLoader.AddArmor("Zanite");
		public static final Item ItemAetherZaniteHelmet = (new ItemColouredArmor(MomocraftID.idItemAetherZaniteHelmet,EnumArmorMaterial.IRON,zaniteArmour,0, MomocraftCouleur.Zanite)).setIconIndex(2).setItemName("ItemAetherZaniteHelmet");	
		public static final Item ItemAetherZaniteChestplate = (new ItemColouredArmor(MomocraftID.idItemAetherZaniteChestplate,EnumArmorMaterial.IRON,zaniteArmour,0, MomocraftCouleur.Zanite)).setIconIndex(18).setItemName("ItemAetherZaniteChestplate");	
		public static final Item ItemAetherZaniteLeggings = (new ItemColouredArmor(MomocraftID.idItemAetherZaniteLeggings,EnumArmorMaterial.IRON,zaniteArmour,0, MomocraftCouleur.Zanite)).setIconIndex(34).setItemName("ItemAetherZaniteLeggings");	
		public static final Item ItemAetherZaniteBoots = (new ItemColouredArmor(MomocraftID.idItemAetherZaniteBoots,EnumArmorMaterial.IRON,zaniteArmour,0, MomocraftCouleur.Zanite)).setIconIndex(50).setItemName("ItemAetherZaniteBoots");	
		
		//Armure en gravitite
		public static int gravititeArmour = ModLoader.AddArmor("Gravitite");
		public static final Item ItemAetherGravititeHelmet = (new ItemColouredArmor(MomocraftID.idItemAetherGravititeHelmet,EnumArmorMaterial.DIAMOND,gravititeArmour,0, MomocraftCouleur.Gravitite)).setIconIndex(2).setItemName("ItemAetherGravititeHelmet");	
		public static final Item ItemAetherGravititeBodyplate = (new ItemColouredArmor(MomocraftID.idItemAetherGravititeBodyplate,EnumArmorMaterial.DIAMOND,gravititeArmour,0, MomocraftCouleur.Gravitite)).setIconIndex(18).setItemName("ItemAetherGravititeBodyplate");	
		public static final Item ItemAetherGravititePlatelegs = (new ItemColouredArmor(MomocraftID.idItemAetherGravititePlatelegs,EnumArmorMaterial.DIAMOND,gravititeArmour,0, MomocraftCouleur.Gravitite)).setIconIndex(34).setItemName("ItemAetherGravititePlatelegs");	
		public static final Item ItemAetherGravititeBoots = (new ItemColouredArmor(MomocraftID.idItemAetherGravititeBoots,EnumArmorMaterial.DIAMOND,gravititeArmour,0, MomocraftCouleur.Gravitite)).setIconIndex(50).setItemName("ItemAetherGravititeBoots");	
		
		//Armure du Phoenix
		public static int phoenixArmour = ModLoader.AddArmor("Phoenix");
		public static final Item ItemAetherPhoenixHelm = (new ItemColouredArmor(MomocraftID.idItemAetherPhoenixHelm,EnumArmorMaterial.DIAMOND,phoenixArmour,0, MomocraftCouleur.Phoenix)).setIconIndex(1).setItemName("ItemAetherPhoenixHelm");	
		public static final Item ItemAetherPhoenixBody = (new ItemColouredArmor(MomocraftID.idItemAetherPhoenixBody,EnumArmorMaterial.DIAMOND,phoenixArmour,0, MomocraftCouleur.Phoenix)).setIconIndex(17).setItemName("ItemAetherPhoenixBody");	
		public static final Item ItemAetherPhoenixLegs = (new ItemColouredArmor(MomocraftID.idItemAetherPhoenixLegs,EnumArmorMaterial.DIAMOND,phoenixArmour,0, MomocraftCouleur.Phoenix)).setIconIndex(33).setItemName("ItemAetherPhoenixLegs");	
		public static final Item ItemAetherPhoenixBoots = (new ItemColouredArmor(MomocraftID.idItemAetherPhoenixBoots,EnumArmorMaterial.DIAMOND,phoenixArmour,0, MomocraftCouleur.Phoenix)).setIconIndex(49).setItemName("ItemAetherPhoenixBoots");
		
		//Armure d'obsidienne
		public static int obsiArmour = ModLoader.AddArmor("obsi");
		public static final Item ItemAetherObsidianHelm = (new ItemCasqueObsi(MomocraftID.idItemAetherObsidianHelm,EnumArmorMaterial.GOLD,obsiArmour,0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/casqueobsi.png")).setItemName("ItemAetherObsidianHelm");	
		public static final Item ItemAetherObsidianBody = (new ItemArmureObsi(MomocraftID.idItemAetherObsidianBody,EnumArmorMaterial.GOLD,obsiArmour,0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/armureobsi.png")).setItemName("ItemAetherObsidianBody");	
		public static final Item ItemAetherObsidianLegs = (new ItemJambeObsi(MomocraftID.idItemAetherObsidianLegs,EnumArmorMaterial.GOLD,obsiArmour,0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/jambeobsi.png")).setItemName("ItemAetherObsidianLegs");	
		public static final Item ItemAetherObsidianBoots = (new ItemPiedObsi(MomocraftID.idItemAetherObsidianBoots,EnumArmorMaterial.GOLD,obsiArmour,0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/momocraft/minefield/items/piedobsi.png")).setItemName("ItemAetherObsidianBoots");
		
		//Armure de Neptune
		public static int neptuneArmour = ModLoader.AddArmor("Neptune");
		public static final Item ItemAetherNeptuneHelmet = (new ItemColouredArmor(MomocraftID.idItemAetherNeptuneHelmet,EnumArmorMaterial.DIAMOND,neptuneArmour,0, MomocraftCouleur.Neptune)).setIconIndex(1).setItemName("ItemAetherNeptuneHelmet");	
		public static final Item ItemAetherNeptuneChestplate = (new ItemColouredArmor(MomocraftID.idItemAetherNeptuneChestplate,EnumArmorMaterial.DIAMOND,neptuneArmour,0, MomocraftCouleur.Neptune)).setIconIndex(17).setItemName("ItemAetherNeptuneChestplate");	
		public static final Item ItemAetherNeptuneLeggings = (new ItemColouredArmor(MomocraftID.idItemAetherNeptuneLeggings,EnumArmorMaterial.DIAMOND,neptuneArmour,0, MomocraftCouleur.Neptune)).setIconIndex(33).setItemName("ItemAetherNeptuneLeggings");	
		public static final Item ItemAetherNeptuneBoots = (new ItemColouredArmor(MomocraftID.idItemAetherNeptuneBoots,EnumArmorMaterial.DIAMOND,neptuneArmour,0, MomocraftCouleur.Neptune)).setIconIndex(49).setItemName("ItemAetherNeptuneBoots");	
		
		

		
/*Les accessoires*/
		
/*Les outils et armes selon modele de materiaux d�fini*/
        static EnumToolMaterial enumtoolmaterial1 = EnumToolMaterial.WOOD;
		public static final Item ItemAetherSwordSkyroot = (new ItemSword(MomocraftID.idItemAetherSwordSkyroot, enumtoolmaterial1)).setIconIndex(MomocraftTextures.TexItemAetherSwordSkyroot).setItemName("ItemAetherSwordSkyroot");
		public static final Item ItemAetherAxeSkyroot = (new ItemAetherAxeSkyroot(MomocraftID.idItemAetherAxeSkyroot, enumtoolmaterial1)).setIconIndex(MomocraftTextures.TexItemAetherAxeSkyroot).setItemName("ItemAetherAxeSkyroot");	
		public static final Item ItemAetherPickSkyroot = (new ItemAetherPickSkyroot(MomocraftID.idItemAetherPickSkyroot, enumtoolmaterial1)).setIconIndex(MomocraftTextures.TexItemAetherPickSkyroot).setItemName("ItemAetherPickSkyroot");	
		public static final Item ItemAetherShovelSkyroot = (new ItemAetherShovelSkyroot(MomocraftID.idItemAetherShovelSkyroot, enumtoolmaterial1)).setIconIndex(MomocraftTextures.TexItemAetherShovelSkyroot).setItemName("ItemAetherShovelSkyroot");	
		
        static EnumToolMaterial enumtoolmaterial2 = EnumToolMaterial.STONE;
		public static final Item ItemAetherSwordHolystone = (new ItemAetherSwordHolystone(MomocraftID.idItemAetherSwordHolystone, enumtoolmaterial2)).setIconIndex(MomocraftTextures.TexItemAetherSwordHolystone).setItemName("ItemAetherSwordHolystone");	
		public static final Item ItemAetherAxeHolystone = (new ItemAetherAxeHolystone(MomocraftID.idItemAetherAxeHolystone, enumtoolmaterial2)).setIconIndex(MomocraftTextures.TexItemAetherAxeHolystone).setItemName("ItemAetherAxeHolystone");	
		public static final Item ItemAetherPickHolystone = (new ItemAetherPickHolystone(MomocraftID.idItemAetherPickHolystone, enumtoolmaterial2)).setIconIndex(MomocraftTextures.TexItemAetherPickHolystone).setItemName("ItemAetherPickHolystone");	
		public static final Item ItemAetherShovelHolystone = (new ItemAetherShovelHolystone(MomocraftID.idItemAetherShovelHolystone, enumtoolmaterial2)).setIconIndex(MomocraftTextures.TexItemAetherShovelHolystone).setItemName("ItemAetherShovelHolystone");	

        static EnumToolMaterial enumtoolmaterial3 = EnumToolMaterial.IRON;
		public static final Item ItemAetherSwordZanite = (new ItemAetherSwordZanite(MomocraftID.idItemAetherSwordZanite, enumtoolmaterial3)).setIconIndex(MomocraftTextures.TexItemAetherSwordZanite).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherAxeZanite = (new ItemAetherAxeZanite(MomocraftID.idItemAetherAxeZanite, enumtoolmaterial3)).setIconIndex(MomocraftTextures.TexItemAetherAxeZanite).setItemName("ItemAetherAxeZanite");	
		public static final Item ItemAetherPickZanite = (new ItemAetherPickZanite(MomocraftID.idItemAetherPickZanite, enumtoolmaterial3)).setIconIndex(MomocraftTextures.TexItemAetherPickZanite).setItemName("ItemAetherPickZanite");	
		public static final Item ItemAetherShovelZanite = (new ItemAetherShovelZanite(MomocraftID.idItemAetherShovelZanite, enumtoolmaterial3)).setIconIndex(MomocraftTextures.TexItemAetherShovelZanite).setItemName("ItemAetherShovelZanite");	

        static EnumToolMaterial enumtoolmaterial4 = EnumToolMaterial.EMERALD;
		public static final Item ItemAetherSwordGravitite = (new ItemAetherSwordGravitite(MomocraftID.idItemAetherSwordGravitite, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherSwordGravitite).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherAxeGravitite = (new ItemAetherAxeGravitite(MomocraftID.idItemAetherAxeGravitite, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherAxeGravitite).setItemName("ItemAetherAxeGravitite");	
		public static final Item ItemAetherPickGravitite = (new ItemAetherPickGravitite(MomocraftID.idItemAetherPickGravitite, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherPickGravitite).setItemName("ItemAetherPickGravitite");	
		public static final Item ItemAetherShovelGravitite = (new ItemAetherShovelGravitite(MomocraftID.idItemAetherShovelGravitite, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherShovelGravitite).setItemName("ItemAetherShovelGravitite");
		public static final Item ItemAetherPickValkyrie = (new ItemAetherPickValkyrie(MomocraftID.idItemAetherPickValkyrie, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherValkyriePickaxe).setItemName("ItemAetherPickValkyrie");	
		public static final Item ItemAetherAxeValkyrie = (new ItemAetherAxeValkyrie(MomocraftID.idItemAetherAxeValkyrie, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherValkyrieAxe).setItemName("ItemAetherAxeValkyrie");	
		public static final Item ItemAetherShovelValkyrie = (new ItemAetherShovelValkyrie(MomocraftID.idItemAetherShovelValkyrie, enumtoolmaterial4)).setIconIndex(MomocraftTextures.TexItemAetherValkyrieShovel).setItemName("ItemAetherShovelValkyrie");	
		
/*Les composants*/
		public static final Item ItemAetherAechorPetal = (new ItemAetherAechorPetal(MomocraftID.idItemAetherAechorPetal)).setIconIndex(MomocraftTextures.TexItemAetherAechorPetal).setItemName("ItemAetherAechorPetal");	

/*Divers*/
		public static final Item ItemAetherVictoryMedal = (new ItemAetherVictoryMedal(MomocraftID.idItemAetherVictoryMedal)).setIconIndex(MomocraftTextures.TexItemAetherVictoryMedal).setItemName("ItemAetherVictoryMedal");	
		public static final Item ItemAetherKey = (new ItemAetherKey(MomocraftID.idItemAetherKey)).setIconIndex(MomocraftTextures.TexItemAetherKey).setItemName("ItemAetherKey");	
		public static final Item ItemAetherLoreBook = (new ItemAetherLoreBook(MomocraftID.idItemAetherLoreBook)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherLoreBook");	
		public static final Item ItemAetherMoaEgg = (new ItemAetherMoaEgg(MomocraftID.idItemAetherMoaEgg)).setIconIndex(MomocraftTextures.TexItemAetherMoaEgg).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherBlueMusicDisk = (new ItemAetherBlueMusicDisk(MomocraftID.idItemAetherBlueMusicDisk)).setIconIndex(MomocraftTextures.TexItemAetherBlueMusicDisk).setItemName("ItemAetherBlueMusicDisk");	
		public static final Item ItemAetherGoldenAmber = (new ItemAetherGoldenAmber(MomocraftID.idItemAetherGoldenAmber)).setIconIndex(MomocraftTextures.TexItemAetherGoldenAmber).setItemName("ItemAetherGoldenAmber");	
		public static final Item ItemAetherStick = (new ItemAetherStick(MomocraftID.idItemAetherStick)).setIconIndex(MomocraftTextures.TexItemAetherStick).setItemName("ItemAetherStick");	
		public static final Item ItemAetherDart = (new ItemAetherDart(MomocraftID.idItemAetherDart)).setIconIndex(MomocraftTextures.TexItemAetherDartGolden).setItemName("ItemAetherDart");	
		public static final Item ItemAetherDartShooter = (new ItemAetherDartShooter(MomocraftID.idItemAetherDartShooter)).setIconIndex(MomocraftTextures.TexItemAetherDartShooter).setItemName("ItemAetherDartShooter");	
		public static final Item ItemAetherAmbrosiumShard = (new ItemAetherAmbrosiumShard(MomocraftID.idItemAetherAmbrosiumShard)).setIconIndex(MomocraftTextures.TexItemAetherAmbrosiumShard).setItemName("ItemAetherAmbrosiumShard");	
		public static final Item ItemAetherZanite = (new Item(MomocraftID.idItemAetherZanite)).setIconIndex(MomocraftTextures.TexItemAetherZanite).setItemName("ItemAetherZanite");	
		public static final Item ItemAetherBucket = (new ItemAetherBucket(MomocraftID.idItemAetherBucket)).setIconIndex(MomocraftTextures.TexItemAetherBucket).setItemName("ItemAetherBucket");	
	

		
		public static final Item ItemAetherIronBubble = (new ItemIronBar(MomocraftID.idItemAetherIronBubble)).setIconIndex(MomocraftTextures.TexItemAetherIronBubble).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherPigSlayer = (new ItemIronBar(MomocraftID.idItemAetherPigSlayer)).setIconIndex(MomocraftTextures.TexItemAetherPigSlayer).setItemName("ItemAetherPigSlayer");	
		public static final Item ItemAetherVampireBlade = (new ItemIronBar(MomocraftID.idItemAetherVampireBlade)).setIconIndex(MomocraftTextures.TexItemAetherVampireBlade).setItemName("ItemAetherVampireBlade");	
		public static final Item ItemAetherNatureStaff = (new ItemIronBar(MomocraftID.idItemAetherNatureStaff)).setIconIndex(MomocraftTextures.TexItemAetherNatureStaff).setItemName("ItemAetherNatureStaff");	
		public static final Item ItemAetherSwordFire = (new ItemIronBar(MomocraftID.idItemAetherSwordFire)).setIconIndex(MomocraftTextures.TexItemAetherElementalSword).setItemName("ItemAetherSwordFire");	
		public static final Item ItemAetherSwordHoly = (new ItemIronBar(MomocraftID.idItemAetherSwordHoly)).setIconIndex(MomocraftTextures.TexItemAetherElementalSword).setItemName("ItemAetherSwordHoly");	
		public static final Item ItemAetherSwordLightning = (new ItemIronBar(MomocraftID.idItemAetherSwordLightning)).setIconIndex(MomocraftTextures.TexItemAetherElementalSword).setItemName("ItemAetherSwordLightning");	
		public static final Item ItemAetherLightningKnife = (new ItemIronBar(MomocraftID.idItemAetherLightningKnife)).setIconIndex(MomocraftTextures.TexItemAetherLightningKnife).setItemName("ItemAetherLightningKnife");	
		public static final Item ItemAetherGummieSwet = (new ItemIronBar(MomocraftID.idItemAetherGummieSwet)).setIconIndex(MomocraftTextures.TexItemAetherGummieSwet).setItemName("ItemAetherGummieSwet");	
		public static final Item ItemAetherHammerNotch = (new ItemIronBar(MomocraftID.idItemAetherHammerNotch)).setIconIndex(MomocraftTextures.TexItemAetherHammerNotch).setItemName("ItemAetherHammerNotch");	
		public static final Item ItemAetherPhoenixBow = (new ItemIronBar(MomocraftID.idItemAetherPhoenixBow)).setIconIndex(MomocraftTextures.TexItemAetherPhoenixBow).setItemName("ItemAetherPhoenixBow");	
		public static final Item ItemAetherCloudParachute = (new ItemIronBar(MomocraftID.idItemAetherCloudParachute)).setIconIndex(MomocraftTextures.TexItemAetherCloudParachute).setItemName("ItemAetherCloudParachute");	
		public static final Item ItemAetherCloudParachuteGold = (new ItemIronBar(MomocraftID.idItemAetherCloudParachuteGold)).setIconIndex(MomocraftTextures.TexItemAetherCloudParachute).setItemName("ItemAetherCloudParachuteGold");	
		public static final Item ItemAetherCloudStaff = (new ItemIronBar(MomocraftID.idItemAetherCloudStaff)).setIconIndex(MomocraftTextures.TexItemAetherCloudStaff).setItemName("ItemAetherCloudStaff");	
		public static final Item ItemAetherLifeShard = (new ItemIronBar(MomocraftID.idItemAetherLifeShard)).setIconIndex(MomocraftTextures.TexItemAetherLifeShard).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherGoldenFeather = (new ItemIronBar(MomocraftID.idItemAetherGoldenFeather)).setIconIndex(MomocraftTextures.TexItemAetherGoldenFeather).setItemName("ItemAetherGoldenFeather");	
		public static final Item ItemAetherLance = (new ItemIronBar(MomocraftID.idItemAetherLance)).setIconIndex(MomocraftTextures.TexItemAetherLance).setItemName("ItemAetherLance");	
		public static final Item ItemAetherIronRing = (new ItemIronBar(MomocraftID.idItemAetherIronRing)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherIronRing");	
		public static final Item ItemAetherGoldRing = (new ItemIronBar(MomocraftID.idItemAetherGoldRing)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherZaniteRing = (new ItemIronBar(MomocraftID.idItemAetherZaniteRing)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherZaniteRing");	
		public static final Item ItemAetherIronPendant = (new ItemIronBar(MomocraftID.idItemAetherIronPendant)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherIronPendant");	
		public static final Item ItemAetherGoldPendant = (new ItemIronBar(MomocraftID.idItemAetherGoldPendant)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherGoldPendant");	
		public static final Item ItemAetherZanitePendant = (new ItemIronBar(MomocraftID.idItemAetherZanitePendant)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherZanitePendant");	
		public static final Item ItemAetherRepShield = (new ItemIronBar(MomocraftID.idItemAetherRepShield)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherMoaEgg");	
		public static final Item ItemAetherAetherCape = (new ItemIronBar(MomocraftID.idItemAetherCape)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherAetherCape");	
	

		public static final Item ItemAetherRegenerationStone = (new ItemIronBar(MomocraftID.idItemAetherRegenerationStone)).setIconIndex(MomocraftTextures.TexItemAetherRegenerationStone).setItemName("ItemAetherRegenerationStone");	
		public static final Item ItemAetherInvisibilityCloak = (new ItemIronBar(MomocraftID.idItemAetherInvisibilityCloak)).setIconIndex(MomocraftTextures.TexItemAetherInvisibilityCloak).setItemName("ItemAetherInvisibilityCloak");	
		public static final Item ItemAetherAgilityCape = (new ItemIronBar(MomocraftID.idItemAetherAgilityCape)).setIconIndex(MomocraftTextures.TexItemAetherAgilityCape).setItemName("ItemAetherAgilityCape");	
		public static final Item ItemAetherWhiteCape = (new ItemIronBar(MomocraftID.idItemAetherWhiteCape)).setIconIndex(MomocraftTextures.TexItemAetherCape).setItemName("ItemAetherWhiteCape");	
		public static final Item ItemAetherRedCape = (new ItemIronBar(MomocraftID.idItemAetherRedCape)).setIconIndex(MomocraftTextures.TexItemAetherCape).setItemName("ItemAetherRedCape");	
		public static final Item ItemAetherYellowCape = (new ItemIronBar(MomocraftID.idItemAetherYellowCape)).setIconIndex(MomocraftTextures.TexItemAetherCape).setItemName("ItemAetherYellowCape");	
		public static final Item ItemAetherBlueCape = (new ItemIronBar(MomocraftID.idItemAetherBlueCape)).setIconIndex(MomocraftTextures.TexItemAetherCape).setItemName("ItemAetherBlueCape");	
		
		public static final Item ItemAetherHealingStone = (new ItemIronBar(MomocraftID.idItemAetherHealingStone)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherHealingStone");	
		public static final Item ItemAetherIceRing = (new ItemIronBar(MomocraftID.idItemAetherIceRing)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherIceRing");	
		public static final Item ItemAetherIcePendant = (new ItemIronBar(MomocraftID.idItemAetherIcePendant)).setIconIndex(MomocraftTextures.TexItemMomocraftTest).setItemName("ItemAetherIcePendant");	
/*		*/

		
/////////////////////////////////////////////////////////////////////////
//
//	FONCTION TICK
//	
/////////////////////////////////////////////////////////////////////////


}
