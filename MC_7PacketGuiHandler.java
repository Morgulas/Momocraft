// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Packet230Minefield, GuiScreen, KeyBinding

public abstract class MC_7PacketGuiHandler
{

    public MC_7PacketGuiHandler()
    {
    }

    public int getId()
    {
        return -1;
    }

    public void ModsLoaded()
    {
    }

    public void handlePacket(Packet230ModLoader packet230modloader)
    {
    }

    public void handleTileEntityPacket(int i, int j, int k, int l, int ai[], float af[], String as[])
    {
    }

    public GuiScreen handleGUI(int i)
    {
        return null;
    }

    public void keyboardEvent(KeyBinding keybinding)
    {
    }

    public void onTickInGUI(Minecraft minecraft, GuiScreen guiscreen)
    {
    }
}
