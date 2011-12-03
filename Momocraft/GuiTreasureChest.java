package net.minecraft.src.Momocraft;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class GuiTreasureChest extends GuiContainer {
	
	public GuiTreasureChest(IInventory iinventory, IInventory iinventory1, int i)
    {
        super(new ContainerChest(iinventory, iinventory1));
        inventoryRows = 0;
        upperChestInventory = iinventory;
        lowerChestInventory = iinventory1;
        //field_948_f = false;
        char c = '\336';
        int j = c - 108;
        inventoryRows = iinventory1.getSizeInventory() / 9;
        ySize = j + inventoryRows * 18;
        switch(i)
        {
        case 1: // '\001'
            name = "Bronze Treasure Chest";
            break;

        case 3: // '\003'
            name = "Silver Treasure Chest";
            break;

        case 5: // '\005'
            name = "Gold Treasure Chest";
            break;
        }
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(name, 8, 6, 0x404040);
        fontRenderer.drawString(upperChestInventory.getInvName(), 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, inventoryRows * 18 + 17);
        drawTexturedModalRect(j, k + inventoryRows * 18 + 17, 0, 126, xSize, 96);
    }

    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;
    private int inventoryRows;
    private String name;
    
    
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
