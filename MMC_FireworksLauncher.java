package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.*;

public class MMC_FireworksLauncher extends BlockContainer{
	
	int topTexture;
	int sideTexture;
	
	// setup the variables for the skyrocket
		double xMotion;
		double yMotion;
		double zMotion;
		
		double motionRandom;
		
		
		double red;
		double green;
		double blue;
		
		double redRandom;
		double greenRandom;
		double blueRandom;
		
		double redTarget;
		double greenTarget;
		double blueTarget;
		
		double redTRandom;
		double greenTRandom;
		double blueTRandom;
				
		double cRange;
		
		int numberOfSubrockets;
		
		
		int ageRocket;
		int ageSubrocket;
		int ageParticles;
		
		double ageRandom;
		
		float particleSize;
		boolean emitParticles;
		
		double explosionStrength;
		double strengthRandom;
		
		double gravity;
		int type;
		String[][] allSettings;
	
	
	public MMC_FireworksLauncher(int blockID, int tt, int st, MMC_FireworksSkyrocketManager props) 
	{
		super(blockID, st, Material.iron);
		
		topTexture = tt;
		sideTexture = st;
		
		allSettings = props.allSettings;
		//System.out.println(allSettings[0][1]);
		
	}
	
	public int getBlockTextureFromSide(int side) 
	{
		if(side == 1) {
			return topTexture;
		}
		return sideTexture;
	}
	
	public int tickRate() 
	{
		return 4;
	}
	
	public TileEntity getBlockEntity() // not yet used, but this is gonna be a container. put in dyes, out comes fireworks
	{
		return new TileEntityDispenser();
	}
	
	// if you rightclick
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer entityplayer)
	{
		if(world.multiplayerWorld)
		{
			return true;
		} else
		{
		   // TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.getBlockTileEntity(x, y, z);
			//entityplayer.displayGUIDispenser(tileentitydispenser);
			
			launchRocket(world, x, y, z);
			return true;
		}
	}
	
	// check if it receives redstone-power
	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		if (l > 0 && Block.blocksList[l].canProvidePower()) {
			boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k)
					|| world.isBlockIndirectlyGettingPowered(i, j + 1, k);
			if (flag) {
				world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
			}
		}
	}
	
	// not sure if this does anything...
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z)
				|| world.isBlockIndirectlyGettingPowered(x, y + 1, z)) {
			launchRocket(world, x, y, z);
		}
	}
	
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
        explode(world, i, j, k);
    }
	
	private void updateSettings(int skyrocket) {
		
		//allSettings[skyrocket][0-27]
		xMotion = Double.valueOf(allSettings[skyrocket][0]);
		yMotion = Double.valueOf(allSettings[skyrocket][1]);
		zMotion = Double.valueOf(allSettings[skyrocket][2]);
		
		red = Double.valueOf(allSettings[skyrocket][3]);
		green = Double.valueOf(allSettings[skyrocket][4]);
		blue = Double.valueOf(allSettings[skyrocket][5]);
		
		redTarget = Double.valueOf(allSettings[skyrocket][6]);
		greenTarget = Double.valueOf(allSettings[skyrocket][7]);
		blueTarget = Double.valueOf(allSettings[skyrocket][8]);
		
		cRange = Double.valueOf(allSettings[skyrocket][9]);
		
		numberOfSubrockets = Integer.valueOf(allSettings[skyrocket][10]);
		
		ageRocket = Integer.valueOf(allSettings[skyrocket][11]);
		ageSubrocket = Integer.valueOf(allSettings[skyrocket][12]);
		ageParticles = Integer.valueOf(allSettings[skyrocket][13]);
		
		particleSize = Float.valueOf(allSettings[skyrocket][14]);
		emitParticles = Boolean.valueOf(allSettings[skyrocket][15]);
		
		explosionStrength = Double.valueOf(allSettings[skyrocket][16]);
		
		gravity = Double.valueOf(allSettings[skyrocket][17]);
		type = Integer.valueOf(allSettings[skyrocket][18]);
		
		
		motionRandom = Double.valueOf(allSettings[skyrocket][19]);
		redRandom = Double.valueOf(allSettings[skyrocket][20]);
		greenRandom = Double.valueOf(allSettings[skyrocket][21]);
		blueRandom = Double.valueOf(allSettings[skyrocket][22]);
		redTRandom = Double.valueOf(allSettings[skyrocket][23]);
		greenTRandom = Double.valueOf(allSettings[skyrocket][24]);
		blueTRandom = Double.valueOf(allSettings[skyrocket][25]);
		ageRandom = Double.valueOf(allSettings[skyrocket][26]);
		strengthRandom = Double.valueOf(allSettings[skyrocket][27]);
		
	}
	
	
	private void launchRocket(World world, int x1, int y1, int z1) 
	{	
		if(Math.random() < 0.000001) { // small chance to just go boooooom
			explode(world, x1, y1, z1);
			return;
		}
		
		double x = x1 + 0.5;
		double y = y1 + 0.8;
		double z = z1 + 0.5;
		for(int i = 0; i < 5; i++) {
			
			double mX = (Math.random() -0.5)/10;
			double mY = Math.random() /20;
			double mZ = (Math.random() -0.5)/10;
			
			world.spawnParticle("smoke", x, y, z, mX, mY, mZ);
		
		}
		world.spawnParticle("lava", x, y, z, 0, 0, 0);
		
		// pick a random rocket
		int skyrocketType = (int) (Math.random()* allSettings.length);
		//System.out.println(skyrocketType);
		
		updateSettings(skyrocketType);
		
		double xMotionR = xMotion + (Math.random()*motionRandom); 
		double yMotionR = yMotion + (Math.random()*motionRandom*2); 
		double zMotionR = zMotion + (Math.random()*motionRandom); 
		
		double redR = red + (Math.random()*redRandom);
		double greenR = green + (Math.random()*greenRandom);
		double blueR = blue + (Math.random()*blueRandom);
		
		double redTargetR = redTarget + (Math.random()*redTRandom);
	    double greenTargetR = greenTarget + (Math.random()*greenTRandom);
		double blueTargetR = blueTarget + (Math.random()*blueTRandom);
		
		int ageRocketR = ageRocket + (int) (Math.random()*ageRandom);
		int ageSubrocketR = ageSubrocket + (int) (Math.random()*ageRandom);
		int ageParticlesR = ageParticles + (int) (Math.random()*ageRandom);
		
		double explosionStrengthR = explosionStrength + (Math.random()*strengthRandom);
		
		EntityFX rocket;
		
		if (type == 0) 
		{
			rocket = new MMC_FireworksRocket(world, x, y, z, xMotionR, yMotionR, zMotionR, type, redR, greenR, blueR, redTargetR, greenTargetR, blueTargetR, cRange, numberOfSubrockets, ageRocketR, ageSubrocketR, ageParticlesR, particleSize, emitParticles, explosionStrengthR, gravity);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(rocket);
			
		} else 
		if (type == 1)
		{	
			rocket = new MMC_FireworksRocket(world, x, y, z, xMotionR, yMotionR, zMotionR, type, redR, greenR, blueR, redTargetR, greenTargetR, blueTargetR, cRange, numberOfSubrockets, ageRocketR, ageSubrocketR, ageParticlesR, particleSize, emitParticles, explosionStrengthR, gravity);
			//rocket = new FireworksRocket(world, x, y, z, xMotion, yMotion, zMotion, 1, red, green, blue, redTarget, greenTarget, blueTarget, cRange, numberOfSubrockets, ageRocket, ageSubrocket, ageParticles, particleSize, true, explosionStrength, gravity);
			EntityFX rocket1 = new MMC_FireworksRocket(world, x, y, z, xMotionR, yMotionR, zMotionR, -1, redTargetR, greenTargetR, blueTargetR, redR, greenR, blueR, cRange, numberOfSubrockets*5, ageRocketR, ageSubrocketR, ageParticlesR, particleSize*2, false, explosionStrengthR, gravity);
			
			//EntityFX rocket1 = new FireworksRocket(world, x, y, z, xMotion, yMotion, zMotion, -1, redTarget, greenTarget, blueTarget, red, green, blue, cRange, numberOfSubrockets*2, ageRocket, ageSubrocket, ageParticles, particleSize*2, false, explosionStrength, gravity);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(rocket);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(rocket1);
			
		} else
		{
			rocket = new MMC_FireworksRocket(world, x, y, z, xMotionR, yMotionR, zMotionR, type, redR, greenR, blueR, redTargetR, greenTargetR, blueTargetR, cRange, numberOfSubrockets, ageRocketR, ageSubrocketR, ageParticlesR, particleSize, emitParticles, explosionStrengthR, gravity);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(rocket);
		}
		
		float Volume = (float) (0.5 + Math.random());
		float Pitch = (float) (0.6 + Math.random());
		world.playSoundAtEntity(rocket, "launch", Volume, Pitch); // volume, pitch
		
		
	}
	
	
	private void explode(World world, int x, int y, int z) 
	{
		
		for(int i = 0; i < 5; i++ ) {		
			double xMotionR = Math.random()-0.5; 
			double yMotionR = Math.random()-0.5; 
			double zMotionR = Math.random()/2; 
			
			double redR = Math.random();
			double greenR = Math.random();
			double blueR = Math.random();
			
			double redTargetR = Math.random();
			double greenTargetR = Math.random();
			double blueTargetR = Math.random();
			
			int ageRocketR = 0;
			int ageSubrocketR = 6 + (int) (Math.random()*10);
			int ageParticlesR = 20 + (int) (Math.random()*10);
			
			double explosionStrengthR = 2 + (Math.random()*2);
			
			EntityFX rocket1 = new MMC_FireworksRocket(world, x+0.5, y+0.5, z+0.5, xMotionR, yMotionR, zMotionR, 0, redTargetR, greenTargetR, blueTargetR, redR, greenR, blueR, cRange, 200, ageRocketR, ageSubrocketR, ageParticlesR, 1.7F, false, explosionStrengthR/4, 0.01);
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(rocket1);
		}
		
		world.createExplosion(null, x+0.5, y+0.5, z+0.5, 3F);	
    }

}
