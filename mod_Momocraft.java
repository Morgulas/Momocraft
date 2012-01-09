/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import net.minecraft.client.Minecraft;
import java.util.*;
import org.lwjgl.input.Keyboard;

public class mod_Momocraft extends BaseModMp{
	
	//Déclaration de variable systèmes
	protected static Minecraft mc;
	private static GuiScreen lastGuiOpen;
	
    //Variables claviers
	static KeyBinding MenuMomocraft = new KeyBinding("Menu Momocraft", Keyboard.KEY_M);

///////////////////////////////////////////////////////////////////////////
//	CONSTRUCTEUR
/////////////////////////////////////////////////////////////////////////// 
	
	public mod_Momocraft() {
		
		//Désignation d'une variable pour l'instance Minecraft en cours
		mc = ModLoader.getMinecraftInstance();

		//RegisterKey
		ModLoader.RegisterKey(this, this.MenuMomocraft, false);
		
		//Rafraichissement du jeu
		ModLoader.SetInGUIHook(this, true, false);
		ModLoader.SetInGameHook(this, true, false);

		//RegisterGUI
		ModLoaderMp.RegisterGUI(this, MC_0ID.gMenuMomocraft);
        
		//Appel des fonctions
		new MC_0RegisterTileEntity();
		new MC_0RegisterBlock();
		new MC_0Block();
		new MC_0Item();
		new MC_0Recettes();		
		new MC_0Textures();
		new MC_0AddSmelting();
		new MC_0AddName();
		new MC_0Achievements();
	}

	
///////////////////////////////////////////////////////////////////////////
// GUIs
/////////////////////////////////////////////////////////////////////////// 
	
    public GuiScreen HandleGUI(int inventoryType) 
    {
//            if(inventoryType == MC_0ID.gFourNether)
//            	
//                    return new MC_4GuiFourNether(ModLoader.getMinecraftInstance().thePlayer.inventory, new MC_3TileEntityFourNether());
//            
//            else return null;		
    	return null;
    }
    
    
///////////////////////////////////////////////////////////////////////////
//	TICK
/////////////////////////////////////////////////////////////////////////// 	

	public boolean OnTickInGame(float f, Minecraft minecraft)
    {
//		world = minecraft.theWorld;
//		if(world != null && TEST == true){
//
//            minecraft.displayGuiScreen(new MC_4GuiMain(minecraft.thePlayer));
//			//new MC_4GuiMain(mod_Momocraft.instance.thePlayer);
//		}
//        if(minecraft.currentScreen instanceof GuiInventory)
//        {
//        	System.out.println("Gui ouvert");
//        	minecraft.displayGuiScreen(new MMC_GuiInventory(minecraft.thePlayer));
//        }
		
		//Pour les blocks en mode créative
		
        if(minecraft.currentScreen == null) 
        { 
            lastGuiOpen = null; 
        } 
//		if(openCapeGUI == true)
//		{
//			minecraft.displayGuiScreen(new MC_4GuiCape(minecraft.thePlayer));
//		}
		return true;
    }
	
	
	public boolean OnTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen) 
    { 
		//Pour les blocks en mode créative
        if((guiscreen instanceof GuiContainerCreative) && !(lastGuiOpen instanceof GuiContainerCreative) /*&& !minecraft.theWorld.multiplayerWorld*/) 
        { 
            lastGuiOpen = guiscreen;
            Container container = ((GuiContainer)guiscreen).inventorySlots; 
            List list = ((ContainerCreative)container).itemList;
            for(int i = 0; i <= 0; i++)
            { 
                list.add(new ItemStack(MC_0Block.BlockPaille, 1, i));
                list.add(new ItemStack(MC_0Block.BlockArdoise, 1, i));
                list.add(new ItemStack(MC_0Block.BlockGlowstonePure, 1, i));
                list.add(new ItemStack(MC_0Block.BlockLanterneGlowstone, 1, i));
                list.add(new ItemStack(MC_0Block.BlockLanterneGlowstonePure, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierPaille, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierArdoise, 1, i));                 
                list.add(new ItemStack(MC_0Block.BlockHerbeLumineuse, 1, i));
                
                list.add(new ItemStack(MC_0Block.BlockEscalierStone, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierStonePolie, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierLog, 1, i));
                
                list.add(new ItemStack(MC_0Block.BlockDalle, 1, 0)); 
                list.add(new ItemStack(MC_0Block.BlockDalle, 1, 1)); 
                list.add(new ItemStack(MC_0Block.BlockDalle, 1, 2)); 
                list.add(new ItemStack(MC_0Block.BlockDalle, 1, 3)); 

                list.add(new ItemStack(MC_0Block.BlockPlaqueDiamond, 1, i));  
                list.add(new ItemStack(MC_0Block.BlockPlaqueGlass, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueGlowStone, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueGlowStoneLight, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueGold, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueIce, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueLapis, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockPlaqueObsidian, 1, i));                 
                list.add(new ItemStack(MC_0Block.BlockPlaquePlanks, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueSandStone, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueSteel, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueStone, 1, i)); 
                
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth0, 1, i));                  
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth1, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth2, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth3, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth4, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth5, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth6, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth7, 1, i));                 
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth8, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth9, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth10, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth11, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth12, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth13, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth14, 1, i));
                list.add(new ItemStack(MC_0Block.BlockPlaqueCloth15, 1, i)); 
                
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth0, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth1, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth2, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth3, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth4, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth5, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth6, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth7, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth8, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth9, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth10, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth11, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth12, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth13, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth14, 1, i));
                list.add(new ItemStack(MC_0Block.BlockEscalierCloth15, 1, i));
                   
                //Arches
                list.add(new ItemStack(MC_0Block.BlockArcheStep, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheSandstone, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArchePlank, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheCobblestone, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheBrick, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheStonebrick, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheStone, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheLog, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArchePaille, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockArcheArdoise, 1, i)); 
                
                //Muret
                list.add(new ItemStack(MC_0Block.BlockMuretStep, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretSandstone, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretPlank, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretCobblestone, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretBrick, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretStoneBrick, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockMuretStone, 1, i)); 
                
                //Dalle de plafond
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 0)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 1)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 2)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 3)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 4)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 5)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 6)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 7)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 8)); 
                list.add(new ItemStack(MC_0Block.BlockDalleSup, 1, 9)); 
                
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 0)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 1)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 2)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 3)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 4)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 5)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 6)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 7)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 8)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 9)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 10)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 11)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 12)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 13)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 14)); 
                list.add(new ItemStack(MC_0Block.BlockStepCloth, 1, 15));
                

                list.add(new ItemStack(MC_0Block.BlockBarriereFer, 1, i)); 
                
                list.add(new ItemStack(MC_0Block.BlockTrampoline, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockNuage, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockChaine, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockHerse, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockTonneau, 1, i)); 
//                list.add(new ItemStack(MC_0Block.BlockChaudronBiere, 1, i));
                
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 0)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 1)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 2)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 3)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 4)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 5)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 6)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 7)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 8)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 9)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 10)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 11)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 12)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 13)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 14)); 
                list.add(new ItemStack(MC_0Block.BlockVerre, 1, 15)); 
                
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 0)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 1)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 2)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 3)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 4)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 5)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 6)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 7)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 8)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 9)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 10)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 11)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 12)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 13)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 14)); 
                list.add(new ItemStack(MC_0Block.BlockVitre, 1, 15)); 
                
                list.add(new ItemStack(MC_0Block.BlockCouverts, 1, i));
                list.add(new ItemStack(MC_0Block.BlockHoublon, 1, i)); 
                list.add(new ItemStack(MC_0Block.BlockBucheHory, 1, 0));
                list.add(new ItemStack(MC_0Block.BlockBucheHory, 1, 1));
                list.add(new ItemStack(MC_0Block.BlockBucheHory, 1, 2));
                
                list.add(new ItemStack(MC_0Block.BlockPortail, 1, i));
                list.add(new ItemStack(MC_0Block.BlockRedStone0, 1, i));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 0));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 1));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 2));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 3));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 4));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 5));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 6));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 7));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 8));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 9));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 10));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 11));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 12));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 13));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 14));
//                list.add(new ItemStack(MC_0Block.BlockLanceurdeFeu, 1, 15));
            } 
        }
        lastGuiOpen = guiscreen;
        return true; 
    } 

///////////////////////////////////////////////////////////////////////////
//	CAPTURE DES EVENEMENTS CLAVIER
///////////////////////////////////////////////////////////////////////////
	


	public void KeyboardEvent(KeyBinding keybinding) 
	{
		if(keybinding == this.MenuMomocraft/* && mc.theWorld.multiplayerWorld*/)
		{
            mc.displayGuiScreen(new MC_4GuiMain(mc.thePlayer));
		}
	}

	
    public static void sendPacket(MC_7PacketGuiHandler packetguihandler, Packet230ModLoader packet230minefield)
    {
//        if(!hasInit)
//        {
//            init();
//        }
        if(packetguihandler == null)
        {
            Exception exception = new Exception();
            exception.printStackTrace();
        } else
        {
            packet230minefield.modId = packetguihandler.getId();
            sendPacket(packetguihandler, packet230minefield);
        }
    }


///////////////////////////////////////////////////////////////////////////
//	METHODE DU MOD
/////////////////////////////////////////////////////////////////////////// 
	
	
	//Methode de rendu sur le mod (Important pour la gravitite par exemple, et les items à effet visuelle)
    public void AddRenderer(Map map)
    {
        MC_0Block.AddRenderer(map);
        MC_0Item.AddRenderer(map);
    }
    
    public static int IndexClothTexture(int i)
    {
        i = ~(i & 0xf);
        return 113 + ((i & 8) >> 3) + (i & 7) * 16;
    }

    public static int Inverse(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return 1;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 3;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 5;

        case 5: // '\005'
            return 4;
        }
        return -1;
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    //Attribution de la version
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.3.0";
	}

	//Méthode de chargement
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
