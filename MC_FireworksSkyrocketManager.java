// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.URL;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            ThreadDownloadResources, MFAPI, TexturePackBase

public class MC_FireworksSkyrocketManager
{
    private static Minecraft theMinecraft;
    public String modname;
    public File dir;
    public File config[];
    public String skyrockets[] = {
        "rocket0.skyrocket", "rocket1.skyrocket", "rocket2.skyrocket", "rocket3.skyrocket", "rocket4.skyrocket", "rocket5.skyrocket", "rocket6.skyrocket", "rocket7.skyrocket", "rocket8.skyrocket", "rocket9.skyrocket", 
        "rocket10.skyrocket", "rocket11.skyrocket", "rocket12.skyrocket", "rocket13.skyrocket", "rocket14.skyrocket", "rocket15.skyrocket"
    };
    String allSettings[][];
    public Map classToStringMapping;
    public Map weights;
    public Map types;

    public MC_FireworksSkyrocketManager()
    {
        modname = "Fireworks";
        weights = new HashMap();
        types = new HashMap();
        dir = Minecraft.getAppDir((new StringBuilder()).append("minecraft/minefield/mods/").append(modname).append("/Skyrockets/").toString());
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        if(dir.listFiles().length < 1)
        {
            System.out.println("Directory is empty, creating new skyrockets");
            forceInstall();
        }
        config = dir.listFiles();
        loadConfig();
//        try
//        {
//            if(ModLoader.getMinecraftInstance().downloadResourcesThread == null)
//            {
//            	ModLoader.getMinecraftInstance().downloadResourcesThread = new ThreadDownloadResources(Minecraft.getInstance().mcDataDir, MFAPI.instance);
//            }
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/bang1.wav", 0x129aaL, 0);
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/bang2.wav", 0x1505eL, 0);
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/crack1.wav", 41604L, 0);
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/cracks1.wav", 55756L, 0);
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/cracks3.wav", 0x1d2b4L, 0);
//            ModLoader.getMinecraftInstance().downloadResourcesThread.downloadAndInstallResource(new URL("http://www.minefield.fr/ressources/"), "newsound/fireworks/launch1.wav", 55376L, 0);
//            System.out.println("Fireworks sounds installed !");
//        }
//        catch(Exception exception)
//        {
//            exception.printStackTrace();
//        }
    }

    public void loadConfig()
    {
        File afile[] = dir.listFiles();
        Properties aproperties[] = new Properties[afile.length];
        for(int i = 0; i < afile.length; i++)
        {
            aproperties[i] = new Properties();
        }

        for(int j = 0; j < afile.length; j++)
        {
            if(!config[j].exists() || !config[j].canRead() || !config[j].isFile())
            {
                System.out.println((new StringBuilder()).append(modname).append(": couldn't load config").toString());
                return;
            }
            FileInputStream fileinputstream = null;
            try
            {
                fileinputstream = new FileInputStream(config[j]);
                aproperties[j].load(fileinputstream);
            }
            catch(IOException ioexception)
            {
                System.out.println((new StringBuilder()).append(modname).append(": couldn't load config").toString());
                return;
            }
            finally
            {
                if(fileinputstream != null)
                {
                    try
                    {
                        fileinputstream.close();
                    }
                    catch(IOException ioexception1) { }
                }
            }
        }

        loadConfig(aproperties);
    }

    public void loadConfig(Properties aproperties[])
    {
        File afile[] = dir.listFiles();
        allSettings = new String[afile.length][28];
        for(int i = 0; i < aproperties.length; i++)
        {
            allSettings[i][0] = aproperties[i].getProperty("xMotion");
            allSettings[i][1] = aproperties[i].getProperty("yMotion");
            allSettings[i][2] = aproperties[i].getProperty("zMotion");
            allSettings[i][3] = aproperties[i].getProperty("red");
            allSettings[i][4] = aproperties[i].getProperty("green");
            allSettings[i][5] = aproperties[i].getProperty("blue");
            allSettings[i][6] = aproperties[i].getProperty("redTarget");
            allSettings[i][7] = aproperties[i].getProperty("greenTarget");
            allSettings[i][8] = aproperties[i].getProperty("blueTarget");
            allSettings[i][9] = aproperties[i].getProperty("cRange");
            allSettings[i][10] = aproperties[i].getProperty("numberOfSubrockets");
            allSettings[i][11] = aproperties[i].getProperty("ageRocket");
            allSettings[i][12] = aproperties[i].getProperty("ageSubrocket");
            allSettings[i][13] = aproperties[i].getProperty("ageParticles");
            allSettings[i][14] = aproperties[i].getProperty("particleSize");
            allSettings[i][15] = aproperties[i].getProperty("emitParticles");
            allSettings[i][16] = aproperties[i].getProperty("explosionStrength");
            allSettings[i][17] = aproperties[i].getProperty("gravity");
            allSettings[i][18] = aproperties[i].getProperty("type");
            allSettings[i][19] = aproperties[i].getProperty("motionRandom");
            allSettings[i][20] = aproperties[i].getProperty("redRandom");
            allSettings[i][21] = aproperties[i].getProperty("greenRandom");
            allSettings[i][22] = aproperties[i].getProperty("blueRandom");
            allSettings[i][23] = aproperties[i].getProperty("redTRandom");
            allSettings[i][24] = aproperties[i].getProperty("greenTRandom");
            allSettings[i][25] = aproperties[i].getProperty("blueTRandom");
            allSettings[i][26] = aproperties[i].getProperty("ageRandom");
            allSettings[i][27] = aproperties[i].getProperty("strengthRandom");
        }

        String as[] = dir.list();
        for(int j = 0; j < as.length; j++)
        {
            System.out.println(as[j]);
        }

    }

    public boolean forceInstall()
    {
        return install(true);
    }

    public boolean install(boolean flag)
    {
        boolean flag1 = true;
        String as[] = skyrockets;
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s = as[j];
            flag1 = flag1 && install(s, flag);
        }

        return flag1;
    }

    public boolean install(String s, boolean flag)
    {
        File file = new File(dir, s);
        if(file.exists())
        {
            if(flag)
            {
                System.err.println((new StringBuilder()).append("Overwriting ").append(s).toString());
            } else
            {
                System.err.println((new StringBuilder()).append("Not creating ").append(s).append(", already exists.").toString());
                return false;
            }
        }
        System.err.println((new StringBuilder()).append("Creating ").append(file).toString());
        FileOutputStream fileoutputstream = null;
        InputStream inputstream = null;
        try
        {
            fileoutputstream = new FileOutputStream(file);
            inputstream = (net.minecraft.src.TexturePackBase.class).getResourceAsStream((new StringBuilder()).append("/minefield/Fireworks/Skyrockets/").append(s).toString());
            byte abyte0[] = new byte[4096];
            int i;
            while((i = inputstream.read(abyte0)) != -1) 
            {
                fileoutputstream.write(abyte0, 0, i);
            }
            fileoutputstream.flush();
        }
        catch(IOException ioexception)
        {
            System.err.println((new StringBuilder()).append("bsh: can't create ").append(file).toString());
            ioexception.printStackTrace();
            boolean flag1 = false;
            return flag1;
        }
        finally
        {
            try
            {
                if(fileoutputstream != null)
                {
                    fileoutputstream.close();
                }
                if(inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch(Throwable throwable) { }
        }
        return true;
    }
}
