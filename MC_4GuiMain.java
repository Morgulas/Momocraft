// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.URL;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerPlayer, EntityPlayer, MFAPI, 
//            GuiButton, EntityPlayerSP, ModMinefieldMainGui, SoundManager, 
//            FontRenderer, RenderEngine, RenderHelper, RenderManager, 
//            TransparentPanel, ImageButton, Slot

public class MC_4GuiMain extends GuiContainer
{

    public MC_4GuiManager mod;
    public EntityPlayer player;
    public String specialite;
    public String rang;
    public String money;
    public boolean bouton_montures;
    public boolean bouton_capes;
    public boolean bouton_home1;
    public boolean bouton_sethome1;
    public boolean bouton_home2;
    public boolean bouton_sethome2;
    public boolean bouton_spawn;
    public boolean bouton_assistance;
    public boolean bouton_bourse;
    public boolean bouton_kill;
    public int home_timer;
    public int home2_timer;
    public int spawn_timer;
    private float xSize_lo;
    private float ySize_lo;
    private JScrollPane scrollPane;
    private static String url_site_tmp = "";
    public static JTextPane editorPane = new JTextPane();
    public GuiButton btn_monture;
    public GuiButton btn_cape;
    public GuiButton btn_bourse;
    public GuiButton btn_home1;
    public GuiButton btn_sethome1;
    public GuiButton btn_home2;
    public GuiButton btn_sethome2;
    public GuiButton btn_assistance;
    public GuiButton btn_spawn;
    public GuiButton btn_kill;

    public MC_4GuiMain(EntityPlayer entityplayer)
    {
        super(new ContainerPlayer(entityplayer.inventory));
        specialite = "...";
        rang = "...";
        money = "...";
        bouton_montures = false;
        bouton_capes = true;
        bouton_home1 = true;
        bouton_sethome1 = true;
        bouton_home2 = true;
        bouton_sethome2 = true;
        bouton_spawn = true;
        bouton_assistance = false;
        bouton_bourse = false;
        bouton_kill = true;
        home_timer = 100;
        home2_timer = 100;
        spawn_timer = 100;
        player = entityplayer;
        mc = ModLoader.getMinecraftInstance();
    }

    
    //Dessine et positionne les boutons
    public void initGui()
    {
        controlList.clear();
        xSize = 256;
        ySize = 202;
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        controlList.add(new GuiButton(0, i + 198, j + 170, 51, 20, "Fermer"));
        btn_monture = new GuiButton(1, i + 184, j + 38, 65, 20, "Montures");
        btn_monture.enabled = bouton_montures;
        controlList.add(btn_monture);
        btn_cape = new GuiButton(2, i + 184, j + 65, 65, 20, "Capes");
        btn_cape.enabled = bouton_capes;
        controlList.add(btn_cape);
        btn_bourse = new GuiButton(3, i + 184, j + 93, 65, 20, "XXXXXX");
        btn_bourse.enabled = bouton_bourse;
        controlList.add(btn_bourse);
        btn_home1 = new GuiButton(4, i + 8, j + 147, 61, 20, "Maison 1");
        btn_home1.enabled = bouton_home1;
        controlList.add(btn_home1);
        btn_sethome1 = new GuiButton(5, i + 78, j + 147, 51, 20, "d\351finir");
        btn_sethome1.enabled = bouton_sethome1;
        controlList.add(btn_sethome1);
        btn_home2 = new GuiButton(6, i + 8, j + 170, 61, 20, "Maison 2");
        btn_home2.enabled = bouton_home2;
        controlList.add(btn_home2);
        btn_sethome2 = new GuiButton(7, i + 78, j + 170, 51, 20, "d\351finir");
        btn_sethome2.enabled = bouton_sethome2;
        controlList.add(btn_sethome2);
        btn_assistance = new GuiButton(8, i + 184, j + 9, 65, 20, "XXXXXX");
        btn_assistance.enabled = bouton_assistance;
        controlList.add(btn_assistance);
        btn_spawn = new GuiButton(9, i + 133, j + 147, 61, 20, "Spawn");
        btn_spawn.enabled = bouton_spawn;
        controlList.add(btn_spawn);
        btn_kill = new GuiButton(10, i + 133, j + 170, 61, 20, "Kill");
        btn_kill.enabled = bouton_kill;
        controlList.add(btn_kill);
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        try
        {
            if(guibutton.id == 0)
            {
            	System.out.println("Fermer");
                mc.setIngameFocus();
            } else
//            if(guibutton.id == 3)
//            {
//                if(mod_Momocraft.mc.getApplet().getComponentCount() == 3)
//                {
//                    java.awt.Component component = mod_Momocraft.mc.getApplet().getComponent(1);
//                    component.setVisible(true);
//                    java.awt.Component component1 = mod_Momocraft.mc.getApplet().getComponent(2);
//                    component1.setVisible(true);
//                    editorPane.setPage(new URL((new StringBuilder()).append("http://www.google.fr").append(MFAPI.instance.thePlayer.username).toString()));
//                } else
//                {
//                    JPanel jpanel = buildMainPanel((new StringBuilder()).append("http://www.google.fr")/*.append(MFAPI.instance.thePlayer.username).toString()*/);
//                    java.awt.Component component2 = buildCloseButton();
////                    mod_Momocraft.mc.getApplet().add(jpanel, "Center");
////                    Minecraft.mcApplet.add(component2, "South");
//                }
////                mod_Momocraft.mc.getApplet().getComponent(0).setVisible(false);
////                ModLoader.getApplet().validate();
//            } else
            if(guibutton.id == 2)
            {
            	System.out.println("Cape");
                mc.displayGuiScreen(new MC_4GuiCape(mc.thePlayer));
            } else
            if(guibutton.id == 4)
            {
            	System.out.println("Home1");
                MC_4GuiManager.home1();
                //mc.setIngameFocus();
            } else
            if(guibutton.id == 6)
            {
            	System.out.println("Home2");
                //ModMinefieldMainGui.home2();
                //mc.setIngameFocus();
            } else
            if(guibutton.id == 5)
            {
            	System.out.println("SetHome1");
                //ModMinefieldMainGui.sethome1();
                //mc.setIngameFocus();
            } else
            if(guibutton.id == 7)
            {
            	System.out.println("SetHome2");
                //ModMinefieldMainGui.sethome2();
                //mc.setIngameFocus();
            } else
            if(guibutton.id == 9)
            {
            	System.out.println("Spawn");
                //ModMinefieldMainGui.spawn();
                //mc.setIngameFocus();
            } else
            if(guibutton.id == 10)
            {
            	System.out.println("Kill");
                //ModMinefieldMainGui.kill();
                //mc.setIngameFocus();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
//
//    protected void mouseClicked(int i, int j, int k)
//    {
//        if(k == 0)
//        {
//            for(int l = 0; l < controlList.size(); l++)
//            {
//                GuiButton guibutton = (GuiButton)controlList.get(l);
//                if(guibutton.mousePressed(mc, i, j))
//                {
//                    itemRenderer = guibutton;
//                    mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
//                    actionPerformed(guibutton);
//                }
//            }
//
//        }
//    }

    private void drawSlotInventory(Slot slot)
    {
    }

    
    //Dessine des elements sur le GUI
    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("\2470Fiche du personnage", 10, 16, 0x404040);
        fontRenderer.drawString("\2470T\351l\351portation", 10, 125, 0x404040);
        fontRenderer.drawString((new StringBuilder()).append("\2478").append(player.username).toString(), 90, 38, 0x404040);
        fontRenderer.drawString(rang, 90, 47, 0x404040);
        fontRenderer.drawString("\2478M\351tier principal", 90, 65, 0x404040);
        fontRenderer.drawString((new StringBuilder()).append("\2470").append(specialite).toString(), 90, 74, 0x404040);
        fontRenderer.drawString("\2478Pi\350ces d'argent", 90, 92, 0x404040);
        fontRenderer.drawString((new StringBuilder()).append("\2470").append(money).append(" Pa").toString(), 90, 101, 0x404040);
    }

    //Configuration de la GUI en entier
    public void drawScreen(int i, int j, float f)
    {
        xSize_lo = i;
        ySize_lo = j;
        drawDefaultBackground();
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        drawGuiContainerBackgroundLayer(f);
        for(int i1 = 0; i1 < controlList.size(); i1++)
        {
            GuiButton guibutton = (GuiButton)controlList.get(i1);
            guibutton.drawButton(mc, i, j);
        }

        drawPourcentBar();
        drawPlayer();
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(k, l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        drawGuiContainerForegroundLayer();
        GL11.glPopMatrix();
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
    }

    //Dessine les barres de pourcentages
    protected void drawPourcentBar()
    {
        int i = mc.renderEngine.getTexture("/momocraft/gui/main.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j + 8, k + 163, 0, 202, 60, 4);
        if(home_timer == 100)
        {
            drawTexturedModalRect(j + 8, k + 163, 0, 208, 60, 4);
        } else
        {
            int l = (int)((double)home_timer * 0.57999999999999996D);
            drawTexturedModalRect(j + 9, k + 164, 0, 206, l, 2);
        }
        drawTexturedModalRect(j + 8, k + 186, 0, 202, 60, 4);
        if(home2_timer == 100)
        {
            drawTexturedModalRect(j + 8, k + 186, 0, 208, 60, 4);
        } else
        {
            int i1 = (int)((double)home2_timer * 0.57999999999999996D);
            drawTexturedModalRect(j + 9, k + 187, 0, 206, i1, 2);
        }
        drawTexturedModalRect(j + 133, k + 163, 0, 202, 60, 4);
        if(spawn_timer == 100)
        {
            drawTexturedModalRect(j + 133, k + 163, 0, 208, 60, 4);
        } else
        {
            int j1 = (int)((double)spawn_timer * 0.57999999999999996D);
            drawTexturedModalRect(j + 134, k + 164, 0, 206, j1, 2);
        }
    }

    //Fond du GUI et positionnement (background)
    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/momocraft/gui/main.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }

    
    //Dessine le personnage
    private void drawPlayer()
    {
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glPushMatrix();
        GL11.glTranslatef(i + 37, j + 102, 50F);
        float f = 30F;
        GL11.glScalef(-f, f, f);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        float f1 = mc.thePlayer.renderYawOffset;
        float f2 = mc.thePlayer.rotationYaw;
        float f3 = mc.thePlayer.rotationPitch;
        float f4 = (float)(i + 51) - xSize_lo;
        float f5 = (float)((j + 75) - 50) - ySize_lo;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float)Math.atan(f5 / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        mc.thePlayer.renderYawOffset = (float)Math.atan(f4 / 40F) * 20F;
        mc.thePlayer.rotationYaw = (float)Math.atan(f4 / 40F) * 40F;
        mc.thePlayer.rotationPitch = -(float)Math.atan(f5 / 40F) * 20F;
        GL11.glTranslatef(0.0F, mc.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180F;
        RenderManager.instance.renderEntityWithPosYaw(mc.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        mc.thePlayer.renderYawOffset = f1;
        mc.thePlayer.rotationYaw = f2;
        mc.thePlayer.rotationPitch = f3;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
    }
//
//    private JPanel buildMainPanel(String s)
//    {
//        TransparentPanel transparentpanel = new TransparentPanel(new java.awt.BorderLayout());
//        transparentpanel.setSize(200, 350);
//        transparentpanel.add(getHtmlPage(s), "Center");
//        return transparentpanel;
//    }
//
//    private JScrollPane getHtmlPage(String s)
//    {
//        try
//        {
//            editorPane.setText("<html><body><font color=\"#808080\"><br><br><br><br><br><br><br><center>Chargement en cours..</center></font></body></html>");
//            url_site_tmp = s;
//            (new Thread() {
//
//                public void run()
//                {
//                    try
//                    {
//                        MC_4GuiMain.editorPane.setPage(new URL(MC_4GuiMain.url_site_tmp));
//                    }
//                    catch(Exception exception1)
//                    {
//                        exception1.printStackTrace();
//                        MC_4GuiMain.editorPane.setText((new StringBuilder()).append("<html><body><font color=\"#808080\"><br><br><br><br><br><br><br><center>Erreur de chargement<br>").append(exception1.toString()).append("</center></font></body></html>").toString());
//                    }
//                }
//
//            }
//).start();
//            editorPane.setBackground(java.awt.Color.DARK_GRAY);
//            editorPane.setEditable(false);
//            scrollPane = new JScrollPane(editorPane);
//            scrollPane.setBorder(null);
//            editorPane.setMargin(null);
//        }
//        catch(Exception exception)
//        {
//            exception.printStackTrace();
//        }
//        return scrollPane;
//    }
//
//    private java.awt.Component buildCloseButton()
//    {
//        TransparentPanel transparentpanel = new TransparentPanel(new java.awt.FlowLayout(1));
//        transparentpanel.setOpaque(false);
//        transparentpanel.setSize(200, 20);
//        ImageButton imagebutton = new ImageButton("minefield/gui/close.png", "Fermer");
//        imagebutton.setVisible(true);
//        imagebutton.setSize(200, 20);
//        imagebutton.addMouseListener(new java.awt.event.MouseListener() {
//
//            public void mouseReleased(java.awt.event.MouseEvent mouseevent)
//            {
//            }
//
//            public void mousePressed(java.awt.event.MouseEvent mouseevent)
//            {
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent mouseevent)
//            {
//            }
//
//            public void mouseEntered(java.awt.event.MouseEvent mouseevent)
//            {
//            }
//
//            public void mouseClicked(java.awt.event.MouseEvent mouseevent)
//            {
//                MFAPI.instance.getApplet().getComponent(0).setVisible(true);
//                MFAPI.instance.getApplet().getComponent(1).setVisible(false);
//                MFAPI.instance.getApplet().getComponent(2).setVisible(false);
//                MFAPI.instance.getApplet().validate();
//            }
//
//        }
//);
//        transparentpanel.add(imagebutton);
//        transparentpanel.setVisible(true);
//        return transparentpanel;
//    }
//
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
    }

}
