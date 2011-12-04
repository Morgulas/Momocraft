package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Momocraft.*;
import java.util.*;
import org.lwjgl.opengl.GL11;

//Class du mode qui hérite de BaseMod
public class mod_Momocraft extends BaseMod{
	
	//Déclaration de variable systèmes
	
    public static boolean SAPIexists;
    public static int idBlockFirefly = 130;
    public static int idBlockCicada = 131;
    public static int idBlockPortal = 132;
    public static int idBlockLog = 133;
    public static int idBlockLeaves = 134;
    public static int idBlockMazestone = 135;
    public static int idBlockHedge = 136;
    public static int idBlockBossSpawner = 137;
    public static int idItemNagaScale = 7701;
    public static int fireflyRenderID;
    public static int cicadaRenderID;
	    
	//Constructeur
	public mod_Momocraft() {
		
		//Appel des fonctions
		new MomocraftBlocks();
		new MomocraftItems();
		new MomocraftMobs();
		new MomocraftRecettes();		
		new MomocraftTextures();

		//TEST
		
		ModLoader.SetInGameHook(this, true, true);
        ModLoader.SetInGUIHook(this, true, true);


        fireflyRenderID = ModLoader.getUniqueBlockModelID(this, false);
        cicadaRenderID = ModLoader.getUniqueBlockModelID(this, false);


	    

		

//-------------------------------------------
// Momocraft
//-------------------------------------------
		
		/*Les Blocs*/		
		ModLoader.RegisterBlock(MomocraftBlocks.TestBlock);				//Registration d'un bloc
		ModLoader.AddName(MomocraftBlocks.TestBlock, "Bloc de test");	//Rajout d'un nom au bloc
		
//		ModLoader.RegisterBlock(MomocraftBlocks.BlockPortal);				//Registration d'un bloc
//		ModLoader.AddName(MomocraftBlocks.BlockPortal, "Bloc de portail");	//Rajout d'un nom au bloc
		
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
		ModLoader.AddName(MomocraftBlocks.BlockAetherTrap, "Piège");
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
		ModLoader.AddName(MomocraftItems.ItemAetherObsidianGlove,"Gants en obsidienne");	
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
	
	//Fonctions liées au portail
	
    public void AddRenderer(Map map)
    {
        
    }

    public void GenerateSurface(World world, Random random, int i, int j)
    {
    }

    protected void makeSupplyChest(World world, Random random, int i, int j)
    {
        int k = world.worldInfo.getSpawnX();
        int l = world.worldInfo.getSpawnZ();
        if(k != 0 && l != 0 && k >= i && k <= i + 16 && l >= j && l <= j + 16)
        {
            System.out.println((new StringBuilder()).append("Making supply chest at ").append(k).append(", ").append(l).toString());
            int i1 = (k + random.nextInt(8)) - random.nextInt(8);
            int j1 = (l + random.nextInt(8)) - random.nextInt(8);
            int k1 = world.getTopSolidOrLiquidBlock(i1, j1);
            world.setBlockWithNotify(i1, k1, j1, Block.chest.blockID);
            TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i1, k1, j1);
            if(tileentitychest != null && tileentitychest.getSizeInventory() > 0)
            {
                tileentitychest.setInventorySlotContents(0, new ItemStack(Item.appleGold));
                tileentitychest.setInventorySlotContents(1, new ItemStack(Item.pickaxeDiamond));
                tileentitychest.setInventorySlotContents(2, new ItemStack(Item.shovelDiamond));
                tileentitychest.setInventorySlotContents(3, new ItemStack(Item.axeDiamond));
                tileentitychest.setInventorySlotContents(4, new ItemStack(Item.swordSteel));
                tileentitychest.setInventorySlotContents(5, new ItemStack(Block.obsidian, 14));
                tileentitychest.setInventorySlotContents(6, new ItemStack(Item.flintAndSteel));
                tileentitychest.setInventorySlotContents(7, new ItemStack(Block.mushroomRed, 64));
                tileentitychest.setInventorySlotContents(8, new ItemStack(Block.plantRed, 64));
                tileentitychest.setInventorySlotContents(9, new ItemStack(Block.plantYellow, 64));
                tileentitychest.setInventorySlotContents(10, new ItemStack(Block.mushroomBrown, 64));
                tileentitychest.setInventorySlotContents(11, new ItemStack(Item.diamond, 64));
                tileentitychest.setInventorySlotContents(12, new ItemStack(Item.bucketWater, 1));
            }
        }
    }

    public boolean OnTickInGame(float f, Minecraft minecraft)
    {
        if(!minecraft.theWorld.multiplayerWorld && minecraft.thePlayer != null && (double)minecraft.thePlayer.timeInPortal > 0.80000000000000004D && minecraft.thePlayer.timeUntilPortal == 0)
        {
            interceptPortal(minecraft);
        }
        if(minecraft.thePlayer != null && minecraft.thePlayer.dimension == 7 && !(minecraft.theWorld instanceof AetherWorld))
        {
            sendToTwilightForest(minecraft);
        }
        if(minecraft.thePlayer != null && (minecraft.theWorld.worldProvider instanceof AetherWorldProvider) && minecraft.thePlayer.dimension != 7)
        {
            minecraft.thePlayer.dimension = 7;
            System.err.println("Found the player in the wrong dimension.");
        }
        for(int i = 0; i < minecraft.theWorld.loadedEntityList.size(); i++)
        {
            Entity entity = (Entity)minecraft.theWorld.loadedEntityList.get(i);
            if((entity instanceof EntityItem) && entity.inWater && ((EntityItem)entity).item.itemID == Item.diamond.shiftedIndex)
            {
                System.out.println("I found a diamond in the water!");
                //((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(minecraft.theWorld, (int)entity.posX, (int)entity.posY, (int)entity.posZ);
                sendToTwilightForest(minecraft);
            }
        }

        return true;
    }

    public boolean OnTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen)
    {
        if(minecraft.thePlayer != null && minecraft.thePlayer.dimension == 7 && !(minecraft.theWorld.worldProvider instanceof AetherWorldProvider))
        {
            sendToTwilightForest(minecraft);
        }
        return true;
    }

    public void interceptPortal(Minecraft minecraft)
    {
        boolean flag = isAABBInBlockID(minecraft.theWorld, minecraft.thePlayer.boundingBox, TFBlocks.portal.blockID);
        if(minecraft.thePlayer.dimension == 7)
        {
            usePortal(minecraft, 0);
        } else
        if(minecraft.thePlayer.dimension == 0 && flag)
        {
            usePortal(minecraft, 7);
        }
    }

    public boolean isAABBInBlockID(World world, AxisAlignedBB axisalignedbb, int i)
    {
        int j = MathHelper.floor_double(axisalignedbb.minX);
        int k = MathHelper.floor_double(axisalignedbb.maxX + 1.0D);
        int l = MathHelper.floor_double(axisalignedbb.minY);
        int i1 = MathHelper.floor_double(axisalignedbb.maxY + 1.0D);
        int j1 = MathHelper.floor_double(axisalignedbb.minZ);
        int k1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0D);
        for(int l1 = j; l1 < k; l1++)
        {
            for(int i2 = l; i2 < i1; i2++)
            {
                for(int j2 = j1; j2 < k1; j2++)
                {
                    if(world.getBlockId(l1, i2, j2) == i)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void usePortal(Minecraft minecraft, int i)
    {
        minecraft.thePlayer.timeUntilPortal = 10;
        minecraft.thePlayer.timeInPortal = 0.0F;
        if(i == 0)
        {
            sendToSurface(minecraft);
        } else
        if(i == 7)
        {
            sendToTwilightForest(minecraft);
        }
        if(minecraft.thePlayer.isEntityAlive())
        {
            minecraft.thePlayer.setLocationAndAngles(minecraft.thePlayer.posX, minecraft.thePlayer.posY, minecraft.thePlayer.posZ, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
            minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
            (new AetherWorldTeleporter()).placeInPortal(minecraft.theWorld, minecraft.thePlayer);
        }
    }

    public void sendToTwilightForest(Minecraft minecraft)
    {
        minecraft.theWorld.setEntityDead(minecraft.thePlayer);
        minecraft.thePlayer.isDead = false;
        double d = minecraft.thePlayer.posY;
        if(minecraft.thePlayer.dimension == 0)
        {
            d *= 0.5D;
        }
        minecraft.thePlayer.setLocationAndAngles(minecraft.thePlayer.posX, d, minecraft.thePlayer.posZ, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
        if(minecraft.thePlayer.isEntityAlive())
        {
            minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        }
        AetherWorld tfworld = null;
        tfworld = new AetherWorld(minecraft.theWorld, new AetherWorldProvider());
        minecraft.changeWorld(tfworld, "Vous entrez dans la MomoDimension", minecraft.thePlayer);
        minecraft.thePlayer.worldObj = minecraft.theWorld;
        minecraft.thePlayer.dimension = 7;
    }

    public void sendToSurface(Minecraft minecraft)
    {
        minecraft.theWorld.setEntityDead(minecraft.thePlayer);
        minecraft.thePlayer.isDead = false;
        double d = minecraft.thePlayer.posY;
        if(minecraft.thePlayer.dimension == 0)
        {
            d *= 2D;
        }
        minecraft.thePlayer.setLocationAndAngles(minecraft.thePlayer.posX, d, minecraft.thePlayer.posZ, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
        if(minecraft.thePlayer.isEntityAlive())
        {
            minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        }
        World world = null;
        world = new World(minecraft.theWorld, WorldProvider.getProviderForDimension(0));
        minecraft.changeWorld(world, "Vous quittez la MomoDimension", minecraft.thePlayer);
        minecraft.thePlayer.worldObj = minecraft.theWorld;
        minecraft.thePlayer.dimension = 0;
    }

    public void addTileEntityMapping(Class class1, String s)
    {
        Map map = null;
        Map map1 = null;
        try
        {
            map = (Map)ModLoader.getPrivateValue(net.minecraft.src.TileEntity.class, new TileEntity(), 0);
            map1 = (Map)ModLoader.getPrivateValue(net.minecraft.src.TileEntity.class, new TileEntity(), 1);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
        }
        if(map1.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id: ").append(s).toString());
        } else
        {
            map.put(s, class1);
            map1.put(class1, s);
            return;
        }
    }

    public void addTileEntityRendererMapping(Class class1, TileEntitySpecialRenderer tileentityspecialrenderer)
    {
        Map map = null;
        try
        {
            map = (Map)ModLoader.getPrivateValue(net.minecraft.src.TileEntityRenderer.class, TileEntityRenderer.instance, 0);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
        }
        map.put(class1, tileentityspecialrenderer);
        tileentityspecialrenderer.setTileEntityRenderer(TileEntityRenderer.instance);
    }

    public static void addToAxeEffectiveList(Block block)
    {
        Block ablock[] = null;
        int i = -1;
        try
        {
            int j = 0;
            do
            {
                if(j >= (net.minecraft.src.ItemTool.class).getDeclaredFields().length)
                {
                    break;
                }
                if(ModLoader.getPrivateValue(net.minecraft.src.ItemTool.class, Item.axeSteel, j) instanceof Block[])
                {
                    i = j;
                    break;
                }
                j++;
            } while(true);
            if(i > -1)
            {
                ablock = (Block[])ModLoader.getPrivateValue(net.minecraft.src.ItemTool.class, Item.axeSteel, i);
            } else
            {
                System.out.println("Could not locate the array of blocks the axe is effective against.  Thus, not changing it.");
                return;
            }
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
        }
        Block ablock1[] = new Block[ablock.length + 1];
        System.arraycopy(ablock, 0, ablock1, 0, ablock.length);
        ablock1[ablock.length] = block;
        try
        {
            for(int k = 0; k < Item.itemsList.length; k++)
            {
                if(Item.itemsList[k] instanceof ItemAxe)
                {
                    ModLoader.setPrivateValue(net.minecraft.src.ItemTool.class, Item.itemsList[k], i, ablock1);
                }
            }

        }
        catch(IllegalArgumentException illegalargumentexception1)
        {
            illegalargumentexception1.printStackTrace();
        }
        catch(SecurityException securityexception)
        {
            securityexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception1)
        {
            nosuchfieldexception1.printStackTrace();
        }
    }

    public static void addToFireBurnRate(int i, int j, int k)
    {
        int ai[] = null;
        int ai1[] = null;
        try
        {
            ai = (int[])ModLoader.getPrivateValue(net.minecraft.src.BlockFire.class, Block.fire, 0);
            ai1 = (int[])ModLoader.getPrivateValue(net.minecraft.src.BlockFire.class, Block.fire, 1);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
        }
        ai[i] = j;
        ai1[i] = k;
    }

    public static void addToFireBurnRate(int i, int j)
    {
        try
        {
            for(int k = 0; k < (net.minecraft.src.BlockFire.class).getDeclaredFields().length; k++)
            {
                Object obj = ModLoader.getPrivateValue(net.minecraft.src.BlockFire.class, Block.fire, k);
                if((obj instanceof int[]) && ((int[])obj).length == 256)
                {
                    int ai[] = (int[])obj;
                    ai[i] = ai[j];
                }
            }

        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
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
    
    
    public static void giveAchievement(Achievement blueCloud,
			EntityPlayer entity) {
		// TODO Auto-generated method stub
		
    	
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
