package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_FireworksRocket extends EntityFX {
	
	double red, green, blue; // this is the color of the (sub)rocket as well as the starting color of the particles
	double redT, greenT, blueT; // this is the target color for the particles
	int maxAgeParticles;
	int maxAgeSubrockets;
	int numberOfSubrockets;
	double explosionStrength;
	float particleSize;
	boolean emitParticles; // if this is false, the subrocket doesn't emit particles during flight, but instead explodes at the end of life
	double gravity; 
	double colorRange;
	private float field_672_a; // I think this is the size of the particle
	int type;
	
	public MMC_FireworksRocket(World world, double x, double y, double z, double xM, double yM, double zM, int typ, double r, double g, double b, double rT, double gT, double bT, double cRange, int noSubs, int age, int ageS, int ageP, float pSize, boolean emitP, double explosionS, double grav)
	{
		super(world, x, y, z, xM, yM, zM);
		renderDistanceWeight = 10D; // so that they can be viewed from afar
		field_672_a = 0.9F;
		setSize(1f, 1f);
		noClip = false;
		particleMaxAge = age;
		maxAgeParticles = ageP;
		maxAgeSubrockets = ageS;
		numberOfSubrockets = noSubs;
		gravity = grav;
		explosionStrength = explosionS;
		particleSize = pSize;
		emitParticles = emitP; // this boolean decides if the subrockets emit particles
		type = typ;
		
		red = r;
		green = g; 
		blue = b;
		
		redT = rT;
		greenT = gT;
		blueT = bT;
		
		colorRange = cRange;
		
				
		particleRed = (float) red;
		particleGreen = (float) green;
		particleBlue = (float) blue;
				
//		particleTextureIndex = (int) (4 + Math.random() * 4D);
		
		noClip = false;
		
		motionY = 0.5F;
		
		
	}
	
	public void renderParticle(Tessellator tessellator, float f, float f1,
			float f2, float f3, float f4, float f5) {
		float f6 = ((float) particleAge + f) / (float) particleMaxAge;
		particleScale = 1;
		super.renderParticle(tessellator, f, f1, f2, f3, f4, f5);
	}
	
	public float getEntityBrightness(float f) {
		return 1.0F;
	}
	
	public void onUpdate() {
		if (particleAge >= particleMaxAge) { // nobody lives beyond its time
			explode();
			setEntityDead();
		}
		
		// remember your old coordinates
		prevPosX = posX; 
		prevPosY = posY;
		prevPosZ = posZ;
		
		// and move your body
		moveEntity(motionX, motionY, motionZ);
		
		// maybe spawn particles
		if(emitParticles) {
			spawnSparksOnPath(); //send the speed along
		}
		
		// become old
		particleAge++;
		
		spawnSparksOnPath();

		// speed up, but not too up
		
		
		if(type == 0) 
		{
			motionX *= 1.05D;
			motionZ *= 1.05D;
		
			motionX += ((Math.random()-.5)/10); 
			motionZ += ((Math.random()-.5)/10);
			
			if (motionY < 2.2) //only speed up to about 3
			{ 
				motionY *= 1.20D; // rocketpower
			}
		} else
		if(type == 1) // helix
		{	
			if (motionY < 1.2) //only speed up to about 2
			{ 
				motionY *= 1.10D; // rocketpower
			}
			motionX = 0.5 * Math.sin(particleAge);
			motionZ = 0.5 * Math.cos(particleAge);
			
		} else
		if(type == -1) // inverse helix
		{
			if (motionY < 1.2) //only speed up to about 2
			{ 
				motionY *= 1.10D; // rocketpower
			}
			motionX = 0.5 * Math.cos(particleAge+180);
			motionZ = 0.5 * Math.sin(particleAge+180);
		} else
		{
			motionX *= 1.05D;
			motionZ *= 1.05D;
		
			motionX += ((Math.random()-.5)/10); 
			motionZ += ((Math.random()-.5)/10);
			
			if (motionY < 2.2) //only speed up to about 3
			{ 
				motionY *= 1.20D; // rocketpower
			}
		}
		
		
				
		// bounce a bit
		if (onGround) 
		{
			motionY *= -0.7D; 
			motionX *= 0.7D;
			motionZ *= 0.7D;
		}
		
		// you can't swim
		if (inWater) 
		{
			setEntityDead();
		}
	}
	
	
	private void explode() {
		
		//System.out.println("BOEM");
		
		float Volume = (float) (8 + Math.random()*3);
		float Pitch = (float) (0.5 + Math.random());
		boolean carrySound = false;
		
		worldObj.playSoundAtEntity(this, "bang", Volume, Pitch); // volume, pitch
		if(type < 2) {
			for(int i = 0; i < numberOfSubrockets; i++) 
			{	
				// generate a random direction (sphere-like)
				int rotationX = (int) (Math.random() * 360);
				int rotationY = (int) (Math.random() * 360);
				double subMotionX = explosionStrength * Math.sin(rotationX) * Math.sin(rotationY);
				double subMotionY = explosionStrength * Math.sin(rotationX) * Math.cos(rotationY); 
				double subMotionZ = explosionStrength * Math.cos(rotationX);
				
				double sRed = red + (colorRange * (Math.random()-0.5));
				double sGreen = green + (colorRange * (Math.random()-0.5));
				double sBlue = blue + (colorRange * (Math.random()-0.5));
				
				double sRedT = redT + (colorRange * (Math.random()-0.5));
				double sGreenT = greenT + (colorRange * (Math.random()-0.5));
				double sBlueT = blueT + (colorRange * (Math.random()-0.5));
				
				int sAge = (int) (maxAgeSubrockets + (maxAgeSubrockets/10) * (Math.random()-0.5));
				
				// shoot subrocket in that direction
				EntityFX fx = new MMC_FireworksSubrocket(worldObj, posX, posY, posZ, subMotionX, subMotionY, subMotionZ, sRed, sGreen, sBlue, sRedT, sGreenT, sBlueT, sAge, maxAgeParticles, particleSize, emitParticles, gravity, carrySound);
				fx.renderDistanceWeight = 10D;
				ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
			}	
		} else if(type == 2) // Splitter
		{	
			// Number of splits = how many times the splitter doubles itself. you get 2^numberOfSplits rockets, so ...
			int numberOfSplits = 3;//(int) Math.round(Math.log(numberOfSubrockets)/Math.log(2)); // to approach the number of subrockets
			
			//double subMotionX = (Math.random()-0.5)/4;
			//double subMotionY = (Math.random()-0.5)/4;
			//double subMotionZ = (Math.random()-0.5)/4;
				
			
			int splitAge = (int) (maxAgeSubrockets/1.5);
			for(int i = 0; i < numberOfSubrockets; i++) 
			{	
				// generate a random direction (sphere-like)
				int rotationX = (int) (Math.random() * 360);
				int rotationY = (int) (Math.random() * 360);
				double subMotionX = explosionStrength * Math.sin(rotationX) * Math.sin(rotationY);
				double subMotionY = explosionStrength * Math.sin(rotationX) * Math.cos(rotationY); 
				double subMotionZ = explosionStrength * Math.cos(rotationX);
				
				double sRed = red + (colorRange * (Math.random()-0.5));
				double sGreen = green + (colorRange * (Math.random()-0.5));
				double sBlue = blue + (colorRange * (Math.random()-0.5));
				
				double sRedT = redT + (colorRange * (Math.random()-0.5));
				double sGreenT = greenT + (colorRange * (Math.random()-0.5));
				double sBlueT = blueT + (colorRange * (Math.random()-0.5));
				
				int sAge = (int) (maxAgeSubrockets + (maxAgeSubrockets/10) * (Math.random()-0.5));
				
				// shoot splitrocket in that direction
				EntityFX fx1 = new MMC_FireworksSplitrocket(worldObj, posX, posY, posZ, subMotionX, subMotionY, subMotionZ, sRedT, sGreenT, sBlueT, sRed, sGreen, sBlue, splitAge, maxAgeParticles, particleSize, emitParticles, gravity, numberOfSplits);
				fx1.renderDistanceWeight = 10D;
				ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx1);
			
			}
			//EntityFX fx2 = new FireworksSplitrocket(worldObj, posX, posY, posZ, -subMotionX, -subMotionY, -subMotionZ, red, green, blue, redT, greenT, blueT, splitAge, maxAgeParticles, particleSize, emitParticles, gravity, numberOfSplits);
			//fx2.renderDistanceWeight = 10D;
			//ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx2);
		}
		else if(type == 3) // Cone up
		{	
			for(int i = 0; i < numberOfSubrockets; i++) 
			{	
			// generate a random direction (cone-like)
				int rotationX = (int) (Math.random() * 360);
				int rotationY = (int) (Math.random() * 360);
				double subMotionX = explosionStrength * Math.sin(rotationX) * Math.sin(rotationY);
				double subMotionY = 0.5 + Math.abs(explosionStrength * Math.sin(rotationX) * Math.cos(rotationY)); 
				double subMotionZ = explosionStrength * Math.cos(rotationX);
				
				double sRed = red + (colorRange * (Math.random()-0.5));
				double sGreen = green + (colorRange * (Math.random()-0.5));
				double sBlue = blue + (colorRange * (Math.random()-0.5));
				
				double sRedT = redT + (colorRange * (Math.random()-0.5));
				double sGreenT = greenT + (colorRange * (Math.random()-0.5));
				double sBlueT = blueT + (colorRange * (Math.random()-0.5));
				
				int sAge = (int) (maxAgeSubrockets + (maxAgeSubrockets/10) * (Math.random()-0.5));
				
				// shoot subrocket in that direction
				EntityFX fx = new MMC_FireworksSubrocket(worldObj, posX, posY, posZ, subMotionX, subMotionY, subMotionZ, sRed, sGreen, sBlue, sRedT, sGreenT, sBlueT, sAge, maxAgeParticles, particleSize, emitParticles, gravity, carrySound);
				fx.renderDistanceWeight = 10D;
				ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
			}
		} else if(type == 4) //cube
		{	
			for(int i = 0; i < numberOfSubrockets; i++) 
			{	
			// generate a random direction (cube-like)
				//int rotationX = (int) (Math.random() * 360);
				//int rotationY = (int) (Math.random() * 360);
				double subMotionX = explosionStrength * (Math.random()-0.5);
				double subMotionY = explosionStrength * (Math.random()-0.5); 
				double subMotionZ = explosionStrength * (Math.random()-0.5);
				
				double sRed = red + (colorRange * (Math.random()-0.5));
				double sGreen = green + (colorRange * (Math.random()-0.5));
				double sBlue = blue + (colorRange * (Math.random()-0.5));
				
				double sRedT = redT + (colorRange * (Math.random()-0.5));
				double sGreenT = greenT + (colorRange * (Math.random()-0.5));
				double sBlueT = blueT + (colorRange * (Math.random()-0.5));
				
				int sAge = (int) (maxAgeSubrockets + (maxAgeSubrockets/10) * (Math.random()-0.5));
				
				// shoot subrocket in that direction
				EntityFX fx = new MMC_FireworksSubrocket(worldObj, posX, posY, posZ, subMotionX, subMotionY, subMotionZ, sRed, sGreen, sBlue, sRedT, sGreenT, sBlueT, sAge, maxAgeParticles, particleSize, emitParticles, gravity, carrySound);
				fx.renderDistanceWeight = 10D;
				ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
			}
		} else if(type == 5) //circle horizontal
		{	
			for(int i = 0; i < numberOfSubrockets; i++) 
			{	
			// generate a random direction (circle-like)
				int rotationX = (int) (Math.random() * 360);
				int rotationY = (int) (Math.random() * 360);
				double subMotionX = explosionStrength * Math.sin(rotationX);// * Math.sin(rotationY);
				double subMotionY = (Math.random()-0.5)/100; //explosionStrength * Math.sin(rotationX) * Math.cos(rotationY); 
				double subMotionZ = explosionStrength * Math.cos(rotationX);
				
				double sRed = red + (colorRange * (Math.random()-0.5));
				double sGreen = green + (colorRange * (Math.random()-0.5));
				double sBlue = blue + (colorRange * (Math.random()-0.5));
				
				double sRedT = redT + (colorRange * (Math.random()-0.5));
				double sGreenT = greenT + (colorRange * (Math.random()-0.5));
				double sBlueT = blueT + (colorRange * (Math.random()-0.5));
				
				int sAge = (int) (maxAgeSubrockets + (maxAgeSubrockets/10) * (Math.random()-0.5));
				
				// shoot subrocket in that direction
				EntityFX fx = new MMC_FireworksSubrocket(worldObj, posX, posY, posZ, subMotionX, subMotionY, subMotionZ, sRed, sGreen, sBlue, sRedT, sGreenT, sBlueT, sAge, maxAgeParticles, particleSize, emitParticles, gravity, carrySound);
				fx.renderDistanceWeight = 10D;
				ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
			}
		}
		
		// send a sound subrocket
		if(emitParticles == false) {
			//System.out.println("aaaaand....");
			EntityFX soundz = new MMC_FireworksSubrocket(worldObj, posX, posY, posZ, 0, 0, 0, red, green, blue, redT, greenT, blueT, maxAgeSubrockets, maxAgeParticles, 0, emitParticles, gravity, true);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(soundz);
		}
		
	}
	
		private void spawnSparksOnPath()   
	{
		double speed = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ); // high speed means more particles
		int Number = (int) (speed*5); // number of particles to spawn
		double subPosX = prevPosX;
		double subPosY = prevPosY;
		double subPosZ = prevPosZ;
		double stepX = (posX - prevPosX) / (Number);
		double stepY = (posY - prevPosY) / (Number);
		double stepZ = (posZ - prevPosZ) / (Number);
		for (int teller = 0; teller < Number - 1; teller++) 
		{
			subPosX += stepX;
			subPosY += stepY;
			subPosZ += stepZ;
			spawnParticles(subPosX, subPosY, subPosZ);
		}
	}
	
	
	private void spawnParticles(double x, double y, double z) 
	{
		int pAge = (int) (maxAgeParticles/2 + (Math.random()-0.5) * (maxAgeParticles/10));  // the particles spawned from the rocket have a shorter lifespan, hence the /2
		float pSize = particleSize/2;
		EntityFX fx = new MMC_FireworksParticle(worldObj, x, y, z, red, green, blue, redT, greenT, blueT, pAge, pSize);
		fx.renderDistanceWeight = 10D;
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
	}
	
}
