package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class MMC_RenderFloatingBlock extends Render{
	public MMC_RenderFloatingBlock()
    {
        renderBlocks = new RenderBlocks();
        shadowSize = 0.5F;
    }

    public void doRenderFallingSand(MMC_EntityFloatingBlock entityfloatingblock, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        loadTexture("/terrain.png");
        Block block = Block.blocksList[entityfloatingblock.blockID];
        World world = entityfloatingblock.getWorld();
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        renderBlockFallingSand(block, world, MathHelper.floor_double(entityfloatingblock.posX), MathHelper.floor_double(entityfloatingblock.posY), MathHelper.floor_double(entityfloatingblock.posZ), entityfloatingblock.metadata);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glPopMatrix();
    }

    public static void renderBlockFallingSand(Block block, World world, int i, int j, int k, int l)
    {
        int i1 = block.getRenderColor(l);
        float f = (float)(i1 >> 16 & 0xff) / 255F;
        float f1 = (float)(i1 >> 8 & 0xff) / 255F;
        float f2 = (float)(i1 & 0xff) / 255F;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f7 = block.getBlockBrightness(world, i, j, k);
        float f8 = block.getBlockBrightness(world, i, j - 1, k);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f3 * f8 * f, f3 * f8 * f1, f3 * f8 * f2);
        renderBlocks.renderBottomFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(0, l));
        f8 = block.getBlockBrightness(world, i, j + 1, k);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f4 * f8 * f, f4 * f8 * f1, f4 * f8 * f2);
        renderBlocks.renderTopFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(1, l));
        f8 = block.getBlockBrightness(world, i, j, k - 1);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f5 * f8 * f, f5 * f8 * f1, f5 * f8 * f2);
        renderBlocks.renderEastFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(2, l));
        f8 = block.getBlockBrightness(world, i, j, k + 1);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f5 * f8 * f, f5 * f8 * f1, f5 * f8 * f2);
        renderBlocks.renderWestFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(3, l));
        f8 = block.getBlockBrightness(world, i - 1, j, k);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f6 * f8 * f, f6 * f8 * f1, f6 * f8 * f2);
        renderBlocks.renderNorthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(4, l));
        f8 = block.getBlockBrightness(world, i + 1, j, k);
        if(f8 < f7)
        {
            f8 = f7;
        }
        tessellator.setColorOpaque_F(f6 * f8 * f, f6 * f8 * f1, f6 * f8 * f2);
        renderBlocks.renderSouthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(5, l));
        tessellator.draw();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        doRenderFallingSand((MMC_EntityFloatingBlock)entity, d, d1, d2, f, f1);
    }

    private static RenderBlocks renderBlocks;
}
