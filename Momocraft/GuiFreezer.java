package net.minecraft.src.Momocraft;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class GuiFreezer extends GuiContainer {
	
	public GuiFreezer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityfreezer)
    {
        super(new ContainerFreezer(inventoryplayer, tileentityfreezer));
        freezerInventory = tileentityfreezer;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Freezer", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/aether/gui/enchanter.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        if(freezerInventory.isBurning())
        {
            int l = freezerInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(j + 57, (k + 47) - l, 176, 12 - l, 14, l + 2);
        }
        int i1 = freezerInventory.getCookProgressScaled(24);
        drawTexturedModalRect(j + 79, k + 35, 176, 14, i1 + 1, 16);
    }

    private TileEntityFreezer freezerInventory;

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
