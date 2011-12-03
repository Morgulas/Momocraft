package net.minecraft.src;

import net.minecraft.src.Momocraft.BiomeGenAether;
import net.minecraft.src.Momocraft.BlockTestBlock;
import net.minecraft.src.Momocraft.DimensionAether;
import net.minecraft.src.Momocraft.ItemArmureObsi;
import net.minecraft.src.Momocraft.ItemCasqueObsi;
import net.minecraft.src.Momocraft.ItemChope;
import net.minecraft.src.Momocraft.ItemIronBar;
import net.minecraft.src.Momocraft.ItemJambeObsi;
import net.minecraft.src.Momocraft.ItemObsiSword;
import net.minecraft.src.Momocraft.ItemPiedObsi;
import net.minecraft.src.Momocraft.ItemTestItem;
import net.minecraft.src.Momocraft.MomocraftID;
import net.minecraft.src.MomocraftItems;
import net.minecraft.src.Momocraft.MomocraftMobs;
import net.minecraft.src.Momocraft.MomocraftRecettes;
import net.minecraft.src.Momocraft.MomocraftTextures;
import net.minecraft.src.MomocraftBlocks;
import java.util.*;

//Class du mode qui hérite de BaseMod
public class mod_Momocraft extends BaseMod{
	
	//Déclaration de variable systèmes
		private boolean cloudPara;
		private Random rand;
		private float zLevel;
		DimensionAether dim;
	    private KeyBinding key_loreGain;
	    
	//Constructeur
	public mod_Momocraft() {
		

		//Appel de generation de l'Aether
	        cloudPara = false;
	        rand = new Random();
	        zLevel = -90F;
	        key_loreGain = new KeyBinding("key.loreGain", 48);
	        dim = new DimensionAether();
	        dim.name = "Aether";
	        
	        BiomeGenAether biomegenaether = new BiomeGenAether();
	        try{
	            ModLoader.setPrivateValue(net.minecraft.src.BiomeGenBase.class, biomegenaether, "w", Boolean.valueOf(false));
	        }
	        catch(Exception exception){
	            System.out.println("Forgot to update reflection. Trying MCP name for disabling rain.");
	            try{
	                ModLoader.setPrivateValue(net.minecraft.src.BiomeGenBase.class, biomegenaether, "enableRain", Boolean.valueOf(false));
	            }
	            catch(Exception exception1) { }
	        }
        
        
        
        //Appel des fonctions
		new MomocraftBlocks();
		new MomocraftItems();
		new MomocraftMobs();
		new MomocraftRecettes();		
		new MomocraftTextures();
		

//-------------------------------------------
// Momocraft
//-------------------------------------------
		
		/*Les Blocs*/		
		ModLoader.RegisterBlock(MomocraftBlocks.TestBlock);				//Registration d'un bloc
		ModLoader.AddName(MomocraftBlocks.TestBlock, "Bloc de test");	//Rajout d'un nom au bloc
		
		/*Les Items*/
		ModLoader.AddName(MomocraftItems.TestItem,"Item de test");		//Rajout d'un nom a l'item
		

//-------------------------------------------
// Minefield
//-------------------------------------------
		
		/*Les Blocs*/
        ModLoader.RegisterBlock(MomocraftBlocks.BlockPaille);								
		ModLoader.AddName(MomocraftBlocks.BlockPaille, "Bloc de paille");
		
		/*Les Items*/
		ModLoader.AddName(MomocraftItems.ObsiSword,"Epee d'obsidienne");		/*ObsiSword*/
		ModLoader.AddName(MomocraftItems.Chope,"Chope");						/*Chope*/
		ModLoader.AddName(MomocraftItems.IronBar,"Barre de fer");				/*IronBar*/				
		ModLoader.AddName(MomocraftItems.CasqueObsi,"Casque d'obsidienne");		/*CasqueObsi*/	
		ModLoader.AddName(MomocraftItems.ArmureObsi,"Armure d'obsidienne");		/*ArmureObsi*/	
		ModLoader.AddName(MomocraftItems.JambeObsi,"Jambières d'obsidienne");	/*JambeObsi*/
		ModLoader.AddName(MomocraftItems.PiedObsi,"Pied d'obsidienne");			/*PiedObsi*/
		
		
//-------------------------------------------
// Aether Mod
//-------------------------------------------
		
		/*Les Blocs*/
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherPortal);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherPortal, "Bloc du portail vers l'Aether");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherDirt);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherDirt, "Terre de l'Aether");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherGrass);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherGrass, "Herbe de l'Aether");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherQuicksoil);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherQuicksoil, "QuickSoil");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherHolystone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherHolystone, "Holystone");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherIcestone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherIcestone, "Icestone");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherAercloud);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherAercloud, "Aercloud");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherAerogel);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherAerogel, "Aerogel");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherEnchanter);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherEnchanter, "Enchanteur");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherIncubator);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherIncubator, "Incubateur");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherLog);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherLog, "Bois");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherPlank);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherPlank, "Planche de bois");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherSkyrootLeaves);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherSkyrootLeaves, "Feuilles de Skyroot");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherGoldenOakLeaves);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherGoldenOakLeaves, "Feuilles d'arbre d'or");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherSkyrootSapling);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherSkyrootSapling, "Pousse de Skyroot");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherGoldenOakSapling);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherGoldenOakSapling, "Pousse d'arbre d'or");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherAmbrosiumOre);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherAmbrosiumOre, "Minerai d'Ambrosium");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherAmbrosiumTorch);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherAmbrosiumTorch, "Torche d'Ambrosium");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherZaniteOre);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherZaniteOre, "Minerai de Zanite");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherGravititeOre);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherGravititeOre, "Minerai de Gravitite");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherEnchantedGravitite);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherEnchantedGravitite, "Gravitite enchantée");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherTrap);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherTrap, "Trappe");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherChestMimic);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherChestMimic, "Coffre");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherTreasureChest);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherTreasureChest, "Coffre à trésor");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherDungeonStone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherDungeonStone, "Pierre de donjon");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherLightDungeonStone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherLightDungeonStone, "Pierre de donjon lumineuse");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherLockedDungeonStone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherLockedDungeonStone, "Pierre de donjon vérouillé?");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherLockedLightDungeonStone);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherLockedLightDungeonStone, "Pierre de donjon lumineuse vérouillé?");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherPillar);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherPillar, "Pillier");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherZanite);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherZanite, "Block de Zanite");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherQuicksoilGlass);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherQuicksoilGlass, "QuicksoilGlass");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherFreezer);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherFreezer, "Freezer");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherWhiteFlower);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherWhiteFlower, "Fleur blanche");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherPurpleFlower);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherPurpleFlower, "Fleur violette");
        ModLoader.RegisterBlock(MomocraftBlocks.BlockAetherBed);								
		ModLoader.AddName(MomocraftBlocks.BlockAetherBed, "Lit");
		
		
		/*Les Items*/
		ModLoader.AddName(MomocraftItems.ItemAetherVictoryMedal,"Médaille de victoire");	
		ModLoader.AddName(MomocraftItems.ItemAetherKey,"Clé");	
		ModLoader.AddName(MomocraftItems.ItemAetherLoreBook,"Livre d'histoire");	
		ModLoader.AddName(MomocraftItems.ItemAetherMoaEgg,"Oeuf de Moa");	
		ModLoader.AddName(MomocraftItems.ItemAetherBlueMusicDisk,"Disque Bleu");	
		ModLoader.AddName(MomocraftItems.ItemAetherGoldenAmber,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherAechorPetal,"Pétale d'Aechor");	
		ModLoader.AddName(MomocraftItems.ItemAetherStick,"Baton de l'Aether");	
		ModLoader.AddName(MomocraftItems.ItemAetherDart,"Dart");	
		ModLoader.AddName(MomocraftItems.ItemAetherDartShooter,"Dart Shooter");	
		ModLoader.AddName(MomocraftItems.ItemAetherAmbrosiumShard,"Ambrosium Shard");	
		ModLoader.AddName(MomocraftItems.ItemAetherZanite,"Zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherBucket,"Sot");	
		ModLoader.AddName(MomocraftItems.ItemAetherPickSkyroot,"Pioche en Skyroot");	
		ModLoader.AddName(MomocraftItems.ItemAetherPickHolystone,"Pioche en Holystone");	
		ModLoader.AddName(MomocraftItems.ItemAetherPickZanite,"Pioche en Zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherPickGravitite,"Pioche en Gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherShovelSkyroot,"Pelle en Skyroot");	
		ModLoader.AddName(MomocraftItems.ItemAetherShovelHolystone,"Pelle en Holystone");	
		ModLoader.AddName(MomocraftItems.ItemAetherShovelZanite,"Pelle en Zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherShovelGravitite,"Pelle en Gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherAxeSkyroot,"Hache en Skyroot");	
		ModLoader.AddName(MomocraftItems.ItemAetherAxeHolystone,"Hache en Holystone");	
		ModLoader.AddName(MomocraftItems.ItemAetherAxeZanite,"Hache en Zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherAxeGravitite,"Hache en Gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordSkyroot,"Epée en Skyroot");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordHolystone,"Epée en Holystone");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordZanite,"Epée en Zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordGravitite,"Epée en Gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherIronBubble,"Bulle de fer");	
		ModLoader.AddName(MomocraftItems.ItemAetherPigSlayer,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherVampireBlade,"Lame vampirique");	
		ModLoader.AddName(MomocraftItems.ItemAetherNatureStaff,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordFire,"Epée enflamée");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordHoly,"Sainte épée");	
		ModLoader.AddName(MomocraftItems.ItemAetherSwordLightning,"Epée lumineuse");	
		ModLoader.AddName(MomocraftItems.ItemAetherLightningKnife,"Couteau lumineux");	
		ModLoader.AddName(MomocraftItems.ItemAetherGummieSwet,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherHammerNotch,"Marteau de Notch");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixBow,"Arc du Phoenix");	
		ModLoader.AddName(MomocraftItems.ItemAetherCloudParachute,"Parachute Nuage");	
		ModLoader.AddName(MomocraftItems.ItemAetherCloudParachuteGold,"Parachute Nuage d'Or");	
		ModLoader.AddName(MomocraftItems.ItemAetherCloudStaff,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherLifeShard,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherGoldenFeather,"Plume d'or");	
		ModLoader.AddName(MomocraftItems.ItemAetherLance,"Lance");	
		ModLoader.AddName(MomocraftItems.ItemAetherIronRing,"Anneau de fer");	
		ModLoader.AddName(MomocraftItems.ItemAetherGoldRing,"Anneau d'or");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteRing,"Anneau de zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherIronPendant,"Pendentif de fer");	
		ModLoader.AddName(MomocraftItems.ItemAetherGoldPendant,"Pendentif d'or");	
		ModLoader.AddName(MomocraftItems.ItemAetherZanitePendant,"Pendentif de zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherRepShield,"TEST");	
		ModLoader.AddName(MomocraftItems.ItemAetherAetherCape,"Cape de l'Aether");	
		ModLoader.AddName(MomocraftItems.ItemAetherLeatherGlove,"Gants en cuir");	
		ModLoader.AddName(MomocraftItems.ItemAetherIronGlove,"Gants en fer");	
		ModLoader.AddName(MomocraftItems.ItemAetherGoldGlove,"Gants en or");	
		ModLoader.AddName(MomocraftItems.ItemAetherDiamondGlove,"Gants en diamand");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteGlove,"Gants en zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteHelmet,"Casque en zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteChestplate,"Armure en zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteLeggings,"Jambières en zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherZaniteBoots,"Bottes en zanite");	
		ModLoader.AddName(MomocraftItems.ItemAetherGravititeGlove,"Gants en gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherGravititeHelmet,"Casque en gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherGravititeBodyplate,"Armure en plaque de gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherGravititePlatelegs,"Jambières en plaque de gravitite ");	
		ModLoader.AddName(MomocraftItems.ItemAetherGravititeBoots,"Bottes en gravitite");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixGlove,"Gants du Phoenix");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixHelm,"Casque du Phoenix");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixBody,"Armure du Phoenix");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixLegs,"Jambières du Phoenix");	
		ModLoader.AddName(MomocraftItems.ItemAetherPhoenixBoots,"Bottes du Phoenix");	
		//ModLoader.AddName(MomocraftItems.ItemAetherObsidianGlove,"Gants en obsidienne");	
		ModLoader.AddName(MomocraftItems.ItemAetherObsidianBody,"Armure en obsidienne");	
		ModLoader.AddName(MomocraftItems.ItemAetherObsidianHelm,"Casque en obsidienne");	
		ModLoader.AddName(MomocraftItems.ItemAetherObsidianLegs,"Jambières en obsidienne");	
		ModLoader.AddName(MomocraftItems.ItemAetherObsidianBoots,"Bottes en obsidienne");	
		ModLoader.AddName(MomocraftItems.ItemAetherNeptuneGlove,"Gants de Neptune");	
		ModLoader.AddName(MomocraftItems.ItemAetherNeptuneHelmet,"Casque de Neptune");	
		ModLoader.AddName(MomocraftItems.ItemAetherNeptuneChestplate,"Armure de Neptune");	
		ModLoader.AddName(MomocraftItems.ItemAetherNeptuneLeggings,"Jambières de Neptune");	
		ModLoader.AddName(MomocraftItems.ItemAetherNeptuneBoots,"Bottes de Neptune");	
		ModLoader.AddName(MomocraftItems.ItemAetherRegenerationStone,"Pierre de regeneration");	
		ModLoader.AddName(MomocraftItems.ItemAetherInvisibilityCloak,"Manteau d'invisibilité");	
		ModLoader.AddName(MomocraftItems.ItemAetherAgilityCape,"Cape d'agilité");	
		ModLoader.AddName(MomocraftItems.ItemAetherWhiteCape,"Cape blanche");	
		ModLoader.AddName(MomocraftItems.ItemAetherRedCape,"Cape rouge");	
		ModLoader.AddName(MomocraftItems.ItemAetherYellowCape,"Cape jaune");	
		ModLoader.AddName(MomocraftItems.ItemAetherBlueCape,"Cape bleu");	
		ModLoader.AddName(MomocraftItems.ItemAetherPickValkyrie,"Pioche des Valkyries");	
		ModLoader.AddName(MomocraftItems.ItemAetherAxeValkyrie,"Hache des Valkyries");	
		ModLoader.AddName(MomocraftItems.ItemAetherShovelValkyrie,"Pelle des Valkyries");	
		ModLoader.AddName(MomocraftItems.ItemAetherHealingStone,"Pierre de soin");	
		ModLoader.AddName(MomocraftItems.ItemAetherIceRing,"Anneau de glace");	
		ModLoader.AddName(MomocraftItems.ItemAetherIcePendant,"Pendentif de glace");	
/**/	
	
		
		

		

//-----------------------------------------------------------------------	
	}		
	//Chargeur des Achievements
	
    public static void giveAchievement(Achievement achievement)
    {
        giveAchievement(achievement, ((EntityPlayer) (ModLoader.getMinecraftInstance().thePlayer)));
    }

    public static void giveAchievement(Achievement achievement, EntityPlayer entityplayer)
    {
        if(ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(achievement))
        {
            return;
        } else
        {
            ModLoader.getMinecraftInstance().sndManager.playSoundFX("aether.sound.other.achievement.achievementGen", 1.0F, 1.0F);
            entityplayer.triggerAchievement(achievement);
            return;
        }
    }
	
	//Fonctions exotiques
	
	public static boolean equippedSkyrootShovel(){
		ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
		return itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherShovelSkyroot.shiftedIndex;
		}
			
	public static boolean equippedSkyrootAxe(){
		ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
		return itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherAxeSkyroot.shiftedIndex;
		}	
	
    public static boolean equippedSkyrootPick(){
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == MomocraftItems.ItemAetherPickSkyroot.shiftedIndex;
    	}		
	
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0.0";
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
