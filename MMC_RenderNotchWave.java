package net.minecraft.src;

import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

public class MMC_RenderNotchWave extends Render{
	
	 public MMC_RenderNotchWave()
	    {
	    }

	    public void func_4012_a(MMC_EntityNotchWave entitynotchwave, double d, double d1, double d2, 
	            float f, float f1)
	    {
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)d, (float)d1, (float)d2);
	        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
	        loadTexture("/momocraft/aether/other/NotchWave.png");
	        Tessellator tessellator = Tessellator.instance;
	        float f2 = 1.0F;
	        float f3 = 0.5F;
	        float f4 = 0.25F;
	        GL11.glRotatef(180F - renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GL11.glRotatef(-renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        tessellator.startDrawingQuads();
	        tessellator.setNormal(0.0F, 1.0F, 0.0F);
	        tessellator.addVertexWithUV(0.0F - f3, 0.0F - f4, 0.0D, 0.0D, 0.0D);
	        tessellator.addVertexWithUV(f2 - f3, 0.0F - f4, 0.0D, 0.0D, 1.0D);
	        tessellator.addVertexWithUV(f2 - f3, 1.0F - f4, 0.0D, 1.0D, 1.0D);
	        tessellator.addVertexWithUV(0.0F - f3, 1.0F - f4, 0.0D, 1.0D, 0.0D);
	        tessellator.draw();
	        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
	        GL11.glPopMatrix();
	    }

	    public void doRender(Entity entity, double d, double d1, double d2, 
	            float f, float f1)
	    {
	        func_4012_a((MMC_EntityNotchWave)entity, d, d1, d2, f, f1);
	    }
}
