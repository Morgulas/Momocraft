package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldBiomeBase extends BiomeGenBase{
	
	protected WorldGenBigMushroom bigMushroomGen;
    public static final BiomeGenBase tfOcean = (new AetherWorldBiomeTwilightOcean(70)).setColor(255).setBiomeName("Twilight Ocean");
    public static final BiomeGenBase twilightForest = (new AetherWorldBiomeTwilightForest(71)).setColor(30464).setBiomeName("Twilight Forest");
    public static final BiomeGenBase highlands = (new AetherWorldBiomeHighlands(72)).setColor(0x666666).setBiomeName("Highlands");
    public static final BiomeGenBase mushrooms = (new AetherWorldBiomeMushrooms(73)).setColor(0x996633).setBiomeName("Mushrooms");
    public static final BiomeGenBase swamp = (new AetherWorldBiomeSwamp(74)).setColor(0x999933).setBiomeName("Twilight Swamp");
    public static final BiomeGenBase stream = (new AetherWorldBiomeStream(75)).setColor(255).setBiomeName("Twilight Stream");
    public static final BiomeGenBase snow = (new AetherWorldBiomeSnow(76)).setColor(0xccffff).setBiomeName("Snowfield");
    public static final BiomeGenBase glacier = (new AetherWorldBiomeGlacier(77)).setColor(0xeeeeee).setBiomeName("Glacier");

    public AetherWorldBiomeBase(int i)
    {
        super(i);
        bigMushroomGen = new WorldGenBigMushroom();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();
//        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityTFBighorn.class, 12, 4, 4));
//        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityTFBoar.class, 10, 4, 4));
//        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityChicken.class, 10, 4, 4));
//        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityTFDeer.class, 15, 4, 4));
//        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityWolf.class, 5, 4, 4));
//        biomeDecorator.treesPerChunk = 10;
//        biomeDecorator.grassPerChunk = 2;
    }

    protected BiomeDecorator createBiomeDecorator()
    {
        return new AetherWorldBiomeDecorator(this);
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if(random.nextInt(5) == 0)
        {
            return worldGenForest;
        }
        if(random.nextInt(10) == 0)
        {
            return worldGenBigTree;
        } else
        {
            return worldGenTrees;
        }
    }

}
