package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_FireworksSubrocket extends EntityFX {
	double red, green, blue; // this is the color of the subrocket as well as the starting color of the particles
	double redT, greenT, blueT; // this is the target color for the particles
	int maxAgeParticles;
	boolean emitParticles; // if this is false, the subrocket doesn't emit particles during flight, but instead explodes at the end of life
	float particleSize;
	double gravity; 
	private float field_672_a; // I think this is the size of the particle
	boolean carrySound;
	
	public MMC_FireworksSubrocket(World world, double x, double y, double z, double xM, double yM, double zM, double r, double g, double b, double rT, double gT, double bT, int age, int ageP, float pSize, boolean emitP, double grav, boolean carrySnd)
	{
		super(world, x, y, z, xM, yM, zM);
		field_672_a = 0.9F;
		setSize(1f, 1f);
		noClip = false;
		particleMaxAge = age;
		maxAgeParticles = ageP;
		particleSize = pSize;
		gravity = grav;
		
		motionX = xM;
		motionY = yM;
		motionZ = zM;
		carrySound = carrySnd;
		red = r;
		green = g; 
		blue = b;
		
		redT = rT;
		greenT = gT;
		blueT = bT;
		
		emitParticles = emitP;
		
		particleRed = (float) red;
		particleGreen = (float) green;
		particleBlue = (float) blue;
				
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
			if(emitParticles == false) { // if you didn't emit particles during your life, do it when you die
				//spawnSparksOnPath();
				spawnParticles(posX, posY, posZ);
				if(carrySound) {
					float Volume = (float) (8 + Math.random()*3);
					float Pitch = (float) (0.5 + Math.random());
					worldObj.playSoundAtEntity(this, "cracks", Volume, Pitch); // volume, pitch
					//System.out.println("Cracks!");
				}
			}
			
			setEntityDead();
		}
		
		// remember your old coordinates
		prevPosX = posX; 
		prevPosY = posY;
		prevPosZ = posZ;
		
		// and move your body
		moveEntity(motionX, motionY, motionZ);
		
		if(emitParticles) {
			spawnSparksOnPath(); 
		}
		
		// become old
		particleAge++;
		
		// slow & fall down
		motionY -= gravity;
		motionX *= 0.985;
		motionZ *= 0.985;
		
		// bounce a bit
		if (onGround) {
			motionY *= -0.7D; 
			motionX *= 0.7D;
			motionZ *= 0.7D;
		}
		
		// you can't swim
		if (inWater) {
			setEntityDead();
		}
	}
	
	// since the update() method takes big steps, this method takes care of the sparks in between.
	private void spawnSparksOnPath()   
	{
		double speed = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ); // high speed means more particles
		int Number = (int) (1+ speed*5); // number of particles to spawn
		
		double subPosX = prevPosX;
		double subPosY = prevPosY;
		double subPosZ = prevPosZ;
		double stepX = (posX - prevPosX) / (Number);
		double stepY = (posY - prevPosY) / (Number);
		double stepZ = (posZ - prevPosZ) / (Number);
		for (int teller = 0; teller < Number; teller++) 
		{
			subPosX += stepX;
			subPosY += stepY;
			subPosZ += stepZ;
			spawnParticles(subPosX, subPosY, subPosZ);
		}
	}
	
	
	private void spawnParticles(double x, double y, double z) 
	{
		int pAge = (int) (maxAgeParticles + (Math.random()-0.5) * (maxAgeParticles/10));
		EntityFX fx = new MMC_FireworksParticle(worldObj, x, y, z, red, green, blue, redT, greenT, blueT, pAge, particleSize);
		fx.renderDistanceWeight = 10D;
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
	}
}
