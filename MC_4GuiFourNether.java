//// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://www.kpdus.com/jad.html
//// Decompiler options: packimports(3) braces deadcode 
//
//package net.minecraft.src;
//
//import net.minecraft.client.Minecraft;
//import org.lwjgl.opengl.GL11;
//
//// Referenced classes of package net.minecraft.src:
////            GuiContainer, ContainerFurnace, FontRenderer, RenderEngine, 
////            TileEntityFurnace, InventoryPlayer
//
//public class MC_4GuiFourNether extends GuiContainer
//{
//
//    public MC_4GuiFourNether(InventoryPlayer inventoryplayer, MC_3TileEntityFourNether tileentitycooker)
//    {
//        super(new MC_5ContainerFourNether(inventoryplayer, tileentitycooker));
//        cookerInventory = tileentitycooker;
//    }
//
//    protected void drawGuiContainerForegroundLayer()
//    {
//        fontRenderer.drawString("Four du Nether", 60, 6, 0x404040);
//        fontRenderer.drawString("Inventaire", 8, (ySize - 96) + 2, 0x404040);
//    }
//
//    protected void drawGuiContainerBackgroundLayer(float f, int i2, int j2)
//    {
//        int i = mc.renderEngine.getTexture("/momocraft/gui/furnace.png");
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        mc.renderEngine.bindTexture(i);
//        int j = (width - xSize) / 2;
//        int k = (height - ySize) / 2;
//        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
//        if(cookerInventory.isFreezing())
//        {
//            int l = cookerInventory.getCookTimeRemainingScaled(12);
//            drawTexturedModalRect(j + 56, (k + 36 + 12) - l, 176, 12 - l, 14, l + 2);
//        }
//        int i1 = cookerInventory.getBurnProgressScaled(24);
//        drawTexturedModalRect(j + 79, k + 34, 176, 14, i1 + 1, 16);
//    }
//
//    private MC_3TileEntityFourNether cookerInventory;
//
//}