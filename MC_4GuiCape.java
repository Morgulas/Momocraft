// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerPlayer, EntityPlayer, MFAPI, 
//            GuiButton, ModMinefieldMainGui, SoundManager, FontRenderer, 
//            RenderEngine, ImageBufferDownload, EntityPlayerSP, RenderHelper, 
//            RenderManager, RenderPlayer, ModelBiped, ModelRenderer, 
//            Slot

public class MC_4GuiCape extends GuiContainer
{

    public MC_4GuiManager mod;
    public EntityPlayer player;
    private float xSize_lo;
    private float ySize_lo;
    public ArrayList list_nom;
    public ArrayList list_image;
    public ArrayList list_description;
    public ArrayList list_current;
    public ArrayList list_active;
    public static int limit = 4;
    public static int offset = 0;
    public boolean click_down;
    public boolean click_first;
    public GuiButton btn_next;
    public GuiButton btn_prev;

    public MC_4GuiCape(EntityPlayer entityplayer)
    {
        super(new ContainerPlayer(entityplayer.inventory));
        list_nom = new ArrayList();
        list_image = new ArrayList();
        list_description = new ArrayList();
        list_current = new ArrayList();
        list_active = new ArrayList();
        click_down = false;
        click_first = true;
        player = entityplayer;
        mc = mod_Momocraft.mc;
    }

    public void initGui()
    {
        controlList.clear();
        xSize = 256;
        ySize = 202;
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        controlList.add(new GuiButton(0, i + 195, j + 171, 51, 20, "Fermer"));
        controlList.add(new GuiButton(1, i + 68, j + 171, 51, 20, "Retour"));
        btn_prev = new GuiButton(2, i + 136, j + 171, 20, 20, "<");
        controlList.add(btn_prev);
        btn_next = new GuiButton(3, i + 156, j + 171, 20, 20, ">");
        controlList.add(btn_next);
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        try
        {
            if(guibutton.id == 0)
            {
                mc.setIngameFocus();
                click_first = true;
                offset = 0;
            } else
            if(guibutton.id == 1)
            {
             //   mod.openMainGUI();
                mc.displayGuiScreen(new MC_4GuiMain(mc.thePlayer));
            	click_first = true;
                offset = 0;
            } else
            if(guibutton.id == 2)
            {
                if(offset > 0)
                {
                    offset -= limit;
                }
            } else
            if(guibutton.id == 3)
            {
                int i = list_image.size();
                if(offset <= i + limit)
                {
                    offset += limit;
                }
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void mouseClicked(int i, int j, int k)
    {
        if(k == 0)
        {
            for(int l = 0; l < controlList.size(); l++)
            {
                GuiButton guibutton = (GuiButton)controlList.get(l);
                if(guibutton.mousePressed(mc, i, j))
                {
                    //itemRenderer = guibutton;
                    mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    actionPerformed(guibutton);
                }
            }

        }
    }

    private void drawSlotInventory(Slot slot)
    {
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("\2470Choisissez votre cape", 10, 16, 0x404040);
    }

    public void drawScreen(int i, int j, float f)
    {
        xSize_lo = i;
        ySize_lo = j;
        if(offset == 0)
        {
            btn_prev.enabled = false;
        } else
        {
            btn_prev.enabled = true;
        }
        if(offset >= list_image.size() - 4)
        {
            btn_next.enabled = false;
        } else
        {
            btn_next.enabled = true;
        }
        if(Mouse.isButtonDown(0))
        {
            click_down = true;
        } else
        if(click_down && !click_first)
        {
            click_down = false;
            int k = (width - xSize) / 2;
            int i1 = (height - ySize) / 2;
            int k1 = i - k;
            int i2 = j - i1;
            byte byte0 = -1;
            if(k1 >= 68 && k1 <= 244)
            {
                if(i2 >= 35 && i2 <= 67)
                {
                    byte0 = 0;
                }
                if(i2 >= 69 && i2 <= 101)
                {
                    byte0 = 1;
                }
                if(i2 >= 103 && i2 <= 135)
                {
                    byte0 = 2;
                }
                if(i2 >= 137 && i2 <= 169)
                {
                    byte0 = 3;
                }
            }
            if(list_nom.size() > byte0 + offset && byte0 >= 0)
            {
                String s = (String)list_nom.get(byte0 + offset);
                mod.setCape(s);
            }
        } else
        {
            click_first = false;
            click_down = false;
        }
        drawDefaultBackground();
        int l = (width - xSize) / 2;
        int j1 = (height - ySize) / 2;
        drawGuiContainerBackgroundLayer(f);
        for(int l1 = 0; l1 < controlList.size(); l1++)
        {
            GuiButton guibutton = (GuiButton)controlList.get(l1);
            guibutton.drawButton(mc, i, j);
        }

        GL11.glTranslatef(l, j1, 0.0F);
        drawCapesImage();
        drawCapesNom();
        drawPlayer1();
        drawPlayer2();
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
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

    //Dessine l'encadrer de la cape
    protected void drawCapesImage()
    {
              String s = "Test1";
              //Fond rayé (seulement si pas de cape)
              int j = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(j);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (0 + 1) + 1, 0, 202, 177, 32);
              //Barre verte d'état
              int k = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(k);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(242, 34 * (0 + 1) + 1, 177, 202, 3, 32);
              //Rendu de la cape en rectangle
              mc.renderEngine.obtainImageData(s, new ImageBufferDownload());
              int l = mc.renderEngine.getTexture("/momocraft/blocks/Aerogel.png");
              //int l = mc.renderEngine.getTextureForDownloadableImage(s, null);
              mc.renderEngine.bindTexture(l);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (0 + 1) + 1, 0, 2, 24, 32);
              
              String s2 = "Test2";
              //Fond rayé (seulement si pas de cape)
              int j2 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(j2);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (1 + 1) + 1, 0, 202, 177, 32);
              //Barre verte d'état
              int k2 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(k2);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(242, 34 * (1 + 1) + 1, 177, 202, 3, 32);
              //Rendu de la cape en rectangle
              mc.renderEngine.obtainImageData(s2, new ImageBufferDownload());
              int l2 = mc.renderEngine.getTexture("/momocraft/blocks/Aerogel.png");
              //int l = mc.renderEngine.getTextureForDownloadableImage(s, null);
              mc.renderEngine.bindTexture(l2);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (1 + 1) + 1, 0, 2, 24, 32);
              
              String s3 = "Test3";
              //Fond rayé (seulement si pas de cape)
              int j3 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(j3);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (2 + 1) + 1, 0, 202, 177, 32);
              //Barre verte d'état
              int k3 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(k3);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(242, 34 * (2 + 1) + 1, 177, 202, 3, 32);
              //Rendu de la cape en rectangle
              mc.renderEngine.obtainImageData(s3, new ImageBufferDownload());
              int l3 = mc.renderEngine.getTexture("/momocraft/blocks/Aerogel.png");
              //int l = mc.renderEngine.getTextureForDownloadableImage(s, null);
              mc.renderEngine.bindTexture(l3);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (2 + 1) + 1, 0, 2, 24, 32);
              
              String s4 = "Test4";
              //Fond rayé (seulement si pas de cape)
              int j4 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(j4);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (3 + 1) + 1, 0, 202, 177, 32);
              //Barre verte d'état
              int k4 = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
              mc.renderEngine.bindTexture(k4);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(242, 34 * (3 + 1) + 1, 177, 202, 3, 32);
              //Rendu de la cape en rectangle
              mc.renderEngine.obtainImageData(s4, new ImageBufferDownload());
              int l4 = mc.renderEngine.getTexture("/momocraft/blocks/Aerogel.png");
              //int l = mc.renderEngine.getTextureForDownloadableImage(s, null);
              mc.renderEngine.bindTexture(l4);
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              drawTexturedModalRect(68, 34 * (3 + 1) + 1, 0, 2, 24, 32);

	}

//        for(int i = 0; i < limit && i + offset < list_image.size(); i++)
//        {
//            String s = (String)list_image.get(i + offset);
//            if(((Integer)list_active.get(i + offset)).intValue() != 1)
//            {
//                int j = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
//                if(j >= 0)
//                {
//                    mc.renderEngine.bindTexture(j);
//                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                    drawTexturedModalRect(68, 34 * (i + 1) + 1, 0, 202, 177, 32);
//                }
//            }
//            if(((Integer)list_current.get(i + offset)).intValue() == 1)
//            {
//                int k = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
//                if(k >= 0)
//                {
//                    mc.renderEngine.bindTexture(k);
//                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                    drawTexturedModalRect(242, 34 * (i + 1) + 1, 177, 202, 3, 32);
//                }
//            }
//            mc.renderEngine.obtainImageData(s, new ImageBufferDownload());
//            int l = mc.renderEngine.getTextureForDownloadableImage(s, null);
//            if(l >= 0)
//            {
//                mc.renderEngine.bindTexture(l);
//                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                drawTexturedModalRect(68, 34 * (i + 1) + 1, 0, 2, 24, 32);
//            }
//        }

    

    protected void drawCapesNom()
    {
      //Premiere ligne de description
      String s = "Cape de test 1";
      //Deuxieme ligne de description
      String s1 = "Ceci est la cape de test 1!";
      GL11.glPushMatrix();
      GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(2896 /*GL_LIGHTING*/);
      GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s).toString(), 96, 34 * (0 + 1) + 6, 0x404040);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s1).toString(), 96, 34 * (0 + 1) + 22, 0x404040);
      GL11.glPopMatrix();
      GL11.glEnable(2896 /*GL_LIGHTING*/);
      GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
      
      //Premiere ligne de description
      String s01 = "Cape de test 2";
      //Deuxieme ligne de description
      String s11 = "Ceci est la cape de test 2!";
      GL11.glPushMatrix();
      GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(2896 /*GL_LIGHTING*/);
      GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s01).toString(), 96, 34 * (1 + 1) + 6, 0x404040);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s11).toString(), 96, 34 * (1 + 1) + 22, 0x404040);
      GL11.glPopMatrix();
      GL11.glEnable(2896 /*GL_LIGHTING*/);
      GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
      
      //Premiere ligne de description
      String s111 = "Cape de test 3";
      //Deuxieme ligne de description
      String s1111 = "Ceci est la cape de test 3!";
      GL11.glPushMatrix();
      GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(2896 /*GL_LIGHTING*/);
      GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s111).toString(), 96, 34 * (2 + 1) + 6, 0x404040);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s1111).toString(), 96, 34 * (2 + 1) + 22, 0x404040);
      GL11.glPopMatrix();
      GL11.glEnable(2896 /*GL_LIGHTING*/);
      GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
      
      //Premiere ligne de description
      String s4 = "Cape de test 4";
      //Deuxieme ligne de description
      String s44 = "Ceci est la cape de test 4!";
      GL11.glPushMatrix();
      GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
      GL11.glDisable(2896 /*GL_LIGHTING*/);
      GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s4).toString(), 96, 34 * (3 + 1) + 6, 0x404040);
      fontRenderer.drawString((new StringBuilder()).append("\2478").append(s44).toString(), 96, 34 * (3 + 1) + 22, 0x404040);
      GL11.glPopMatrix();
      GL11.glEnable(2896 /*GL_LIGHTING*/);
      GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
//        for(int i = 0; i < limit && i + offset < list_nom.size(); i++)
//        {
//            String s = (String)list_nom.get(i + offset);
//            String s1 = (String)list_description.get(i + offset);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
//            GL11.glPopMatrix();
//            GL11.glPushMatrix();
//            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
//            GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
//            GL11.glDisable(2896 /*GL_LIGHTING*/);
//            GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
//            if(((Integer)list_active.get(i + offset)).intValue() != 1)
//            {
//                fontRenderer.drawString((new StringBuilder()).append("\2478").append(s).toString(), 96, 34 * (i + 1) + 6, 0x404040);
//                fontRenderer.drawString((new StringBuilder()).append("\2478").append(s1).toString(), 96, 34 * (i + 1) + 22, 0x404040);
//            } else
//            {
//                fontRenderer.drawString((new StringBuilder()).append("\2470").append(s).toString(), 96, 34 * (i + 1) + 6, 0x404040);
//                fontRenderer.drawString((new StringBuilder()).append("\2478").append(s1).toString(), 96, 34 * (i + 1) + 22, 0x404040);
//            }
//            GL11.glPopMatrix();
//            GL11.glEnable(2896 /*GL_LIGHTING*/);
//            GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
//        }

    }

    
    //Background
    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/momocraft/gui/cape.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }

    
    //Rendu numero 1
    private void drawPlayer1()
    {
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glTranslatef(37F, 102F, 50F);
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
        mc.thePlayer.rotationYaw = mc.thePlayer.rotationYaw * 5F;
        mc.thePlayer.renderYawOffset = mc.thePlayer.renderYawOffset * 5F;
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

    
    //Rendu numero 2
    private void drawPlayer2()
    {
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glTranslatef(37F, 102F, 50F);
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
        mc.thePlayer.rotationYaw = mc.thePlayer.rotationYaw * 5F;
        mc.thePlayer.renderYawOffset = mc.thePlayer.renderYawOffset * 5F;
        String s = "";
        ModelBase modelbase = null;
        Render render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
        if(render instanceof RenderPlayer)
        {
            if(((RenderPlayer)render).mainModel instanceof ModelBiped)
            {
                ModelBiped modelbiped = (ModelBiped)((RenderPlayer)render).mainModel;
                modelbiped.bipedBody.showModel = false;
                modelbiped.bipedHead.showModel = false;
                modelbiped.bipedHeadwear.showModel = false;
                modelbiped.bipedLeftArm.showModel = false;
                modelbiped.bipedLeftLeg.showModel = false;
                modelbiped.bipedRightArm.showModel = false;
                modelbiped.bipedRightLeg.showModel = false;
                modelbase = ((RenderPlayer)render).renderPassModel;
                ((RenderPlayer)render).renderPassModel = null;
                s = mc.thePlayer.cloakUrl;
                mc.thePlayer.cloakUrl = "http://www.minefield.fr/MinecraftCloaks/thorgrin.png";
            }
//            ((RenderPlayer)render).renderSpecial = false;
        }
        GL11.glTranslatef(0.0F, mc.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = -180F;
        RenderManager.instance.renderEntityWithPosYaw(mc.thePlayer, 0.0D, -2.7999999999999998D, 0.0D, 0.0F, 1.0F);
        mc.thePlayer.renderYawOffset = f1;
        mc.thePlayer.rotationYaw = f2;
        mc.thePlayer.rotationPitch = f3;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        if(render instanceof RenderPlayer)
        {
            if(((RenderPlayer)render).mainModel instanceof ModelBiped)
            {
                ModelBiped modelbiped1 = (ModelBiped)((RenderPlayer)render).mainModel;
                modelbiped1.bipedBody.showModel = true;
                modelbiped1.bipedHead.showModel = true;
                modelbiped1.bipedHeadwear.showModel = true;
                modelbiped1.bipedLeftArm.showModel = true;
                modelbiped1.bipedLeftLeg.showModel = true;
                modelbiped1.bipedRightArm.showModel = true;
                modelbiped1.bipedRightLeg.showModel = true;
                ((RenderPlayer)render).renderPassModel = modelbase;
                mc.thePlayer.cloakUrl = s;
            }
//            ((RenderPlayer)render).renderSpecial = true;
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
    }

}
