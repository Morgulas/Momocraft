package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_FireworksParticle extends EntityFX {
	double redDiff, greenDiff, blueDiff;
	private float field_672_a; // I think this is the size of the particle
	
	//constructor
	public MMC_FireworksParticle(World world, double x, double y, double z, double r, double g, double b, double rT, double gT, double bT, int maxAge, float particleSize) 
	{
		super(world, x, y, z, 0, 0, 0);
		super.particleGravity = -1F;
		field_672_a = particleSize + (float) ((Math.random() - 0.5) / 100);
		setSize(1f, 1f);
		noClip = true;
		
		particleMaxAge = maxAge;
				
		motionX = Math.random() / 100; // small random movement
		motionY = Math.random() / 100;
		motionZ = Math.random() / 100;
		
		particleRed = (float) r;
		particleGreen = (float) g;
		particleBlue = (float) b;
		
				
		// calculate diffence between current color and target color
		// difference per update
		redDiff = (rT - r)/ maxAge;
		greenDiff = (gT - g)/ maxAge;
		blueDiff = (bT - b)/ maxAge;
		
//		particleTextureIndex = (int) (4 + Math.random() * 4D);
	}
	
	public void renderParticle(Tessellator tessellator, float f, float f1,
			float f2, float f3, float f4, float f5) {
		float f6 = ((float) particleAge + f) / (float) particleMaxAge;
		particleScale = field_672_a * (1.0F - f6 * f6 * 0.5F);
		super.renderParticle(tessellator, f, f1, f2, f3, f4, f5);
	}
	
	public float getEntityBrightness(float f) {
		return 1.0F;
	}
	
	public void onUpdate() {
	
		if (particleAge >= particleMaxAge) { // nobody lives beyond its time
			setEntityDead();
		}
		
		// remember your old coordinates
		prevPosX = posX; 
		prevPosY = posY;
		prevPosZ = posZ;
		
		// and move your body
		moveEntity(motionX, motionY, motionZ);
		
		// become old
		particleAge++;
		
		// slowly change color
		particleRed += redDiff;
		particleGreen += greenDiff;
		particleBlue += blueDiff;
		
		// you can't swim
		if (inWater) {
			setEntityDead();
		}
	}
		
}
