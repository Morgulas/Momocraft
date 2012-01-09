// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PacketGuiHandler, MFAPI, GuiMinefieldMain, KeyBinding, 
//            Packet100OpenWindow, Packet230ModLoader, GuiButton, GuiMinefieldCape, 
//            GuiScreen

public class MC_4GuiManager extends MC_7PacketGuiHandler
{

    public int modId;
    public static int guiId = 101;
    public MC_4GuiMain main_gui;
    public MC_4GuiCape cape_gui;
    public static MC_4GuiManager instance;

    public int getId()
    {
        return modId;
    }

    public MC_4GuiManager()
    {
        modId = 5;
//        ModLoaderMp.RegisterGUI(this, guiId);
//        ModLoader.RegisterKey(this, "minefield.divers");
        instance = this;
    }

    public GuiScreen handleGUI(int i)
    {
        if(i == guiId)
        {
            return new MC_4GuiMain(mod_Momocraft.mc.thePlayer);
        } else
        {
            return null;
        }
    }

    public void keyboardEvent(KeyBinding keybinding)
    {
		if(keybinding == mod_Momocraft.MenuMomocraft/* && mc.theWorld.multiplayerWorld*/)
		{
			//System.out.print("TestMimi");
            Packet100OpenWindow packet100openwindow = new Packet100OpenWindow();
            packet100openwindow.windowId = guiId;
            openMainGUI();
        }
    }

    public void handlePacket(Packet230ModLoader Packet230ModLoader)
    {
        if(main_gui == null)
        {
            return;
        }
        if(Packet230ModLoader.packetType == 1)
        {
            getAllData(Packet230ModLoader);
        }
        if(Packet230ModLoader.packetType == 9)
        {
            getAllCapeData(Packet230ModLoader);
        }
    }

    public void getAllData(Packet230ModLoader Packet230ModLoader)
    {
        try
        {
            main_gui.rang = Packet230ModLoader.dataString[0];
            main_gui.specialite = Packet230ModLoader.dataString[1];
            main_gui.money = Packet230ModLoader.dataString[2];
            main_gui.btn_monture.enabled = Packet230ModLoader.dataInt[0] == 1;
            main_gui.btn_cape.enabled = Packet230ModLoader.dataInt[1] == 1;
            main_gui.btn_home1.enabled = Packet230ModLoader.dataInt[2] == 1;
            main_gui.btn_sethome1.enabled = Packet230ModLoader.dataInt[3] == 1;
            main_gui.btn_home2.enabled = Packet230ModLoader.dataInt[4] == 1;
            main_gui.btn_sethome2.enabled = Packet230ModLoader.dataInt[5] == 1;
            main_gui.btn_spawn.enabled = Packet230ModLoader.dataInt[6] == 1;
            main_gui.btn_assistance.enabled = Packet230ModLoader.dataInt[7] == 1;
            main_gui.btn_bourse.enabled = Packet230ModLoader.dataInt[8] == 1;
            main_gui.btn_kill.enabled = Packet230ModLoader.dataInt[12] == 1;
            main_gui.home_timer = Packet230ModLoader.dataInt[9];
            main_gui.home2_timer = Packet230ModLoader.dataInt[10];
            main_gui.spawn_timer = Packet230ModLoader.dataInt[11];
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void getAllCapeData(Packet230ModLoader packet230modloader)
    {
        try
        {
            int i = packet230modloader.dataInt[0];
            if(cape_gui != null)
            {
                cape_gui.list_nom.clear();
                cape_gui.list_image.clear();
                cape_gui.list_description.clear();
                cape_gui.list_current.clear();
                cape_gui.list_active.clear();
                for(int j = 0; j < i; j++)
                {
                    cape_gui.list_nom.add(packet230modloader.dataString[j]);
                }

                for(int k = 0; k < i; k++)
                {
                    cape_gui.list_image.add(packet230modloader.dataString[k + i]);
                }

                for(int l = 0; l < i; l++)
                {
                    cape_gui.list_description.add(packet230modloader.dataString[l + i + i]);
                }

                for(int i1 = 0; i1 < i; i1++)
                {
                    cape_gui.list_current.add(Integer.valueOf(packet230modloader.dataInt[i1 + 1]));
                }

                for(int j1 = 0; j1 < i; j1++)
                {
                    cape_gui.list_active.add(Integer.valueOf(packet230modloader.dataInt[j1 + 1 + i]));
                }

            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void home1()
    {

    	Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 2;
        //mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

    public static void home2()
    {
    	Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 3;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
    }

    public static void sethome1()
    {
    	Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 4;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

    public static void sethome2()
    {
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 5;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

    public static void spawn()
    {
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 6;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

    public static void kill()
    {
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 7;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

    public void openMainGUI()
    {
        main_gui = new MC_4GuiMain(mod_Momocraft.mc.thePlayer);
        main_gui.mod = this;
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 0;
        mod_Momocraft.sendPacket(this, Packet230ModLoader);
        ModLoader.OpenGUI(mod_Momocraft.mc.thePlayer, main_gui);
        System.out.print("Packet Envoyé");
    }

    public void openCapeGUI()
    {
        cape_gui = new MC_4GuiCape(mod_Momocraft.mc.thePlayer);
        cape_gui.mod = this;
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 8;
        mod_Momocraft.sendPacket(this, Packet230ModLoader);
        ModLoader.OpenGUI(mod_Momocraft.mc.thePlayer, cape_gui);
        System.out.print("Packet Envoyé");
    }

    public void setCape(String s)
    {
        Packet230ModLoader Packet230ModLoader = new Packet230ModLoader();
        Packet230ModLoader.packetType = 10;
        String as[] = new String[1];
        as[0] = s;
        Packet230ModLoader.dataString = as;
        mod_Momocraft.sendPacket(instance, Packet230ModLoader);
        System.out.print("Packet Envoyé");
    }

}
