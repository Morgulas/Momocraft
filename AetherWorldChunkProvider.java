package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldChunkProvider implements IChunkProvider {
	
	 public static final int ARENAHEIGHT = 31;
	    private AetherWorldGenMapTower towerGenerator;
	    private AetherWorldGenMapHollowTree hollowTreeGenerator;
	    private Random rand;
	    private NoiseGeneratorOctaves noiseGen1;
	    private NoiseGeneratorOctaves noiseGen2;
	    private NoiseGeneratorOctaves noiseGen3;
	    private NoiseGeneratorOctaves noiseGen4;
	    public NoiseGeneratorOctaves noiseGen5;
	    public NoiseGeneratorOctaves noiseGen6;
	    public NoiseGeneratorOctaves mobSpawnerNoise;
	    private World worldObj;
	    private final boolean mapFeaturesEnabled;
	    private double landMap[];
	    private double stoneNoise[];
	    private MapGenBase caveGenerator;
	    public AetherWorldGenMapStronghold strongholdGenerator;
	    public MapGenVillage villageGenerator;
	    public MapGenMineshaft mineshaftGenerator;
	    private MapGenBase ravineGenerator;
	    private BiomeGenBase biomesForGeneration[];
	    double noise3[];
	    double noise1[];
	    double noise2[];
	    double noise5[];
	    double noise6[];
	    float squareTable[];
	    int unusedIntArray32x32[][];

	    public AetherWorldChunkProvider(World world, long l, boolean flag)
	    {
	        stoneNoise = new double[256];
	        caveGenerator = new MapGenCaves();
	        strongholdGenerator = new AetherWorldGenMapStronghold();
	        towerGenerator = new AetherWorldGenMapTower();
	        hollowTreeGenerator = new AetherWorldGenMapHollowTree();
	        villageGenerator = new MapGenVillage();
	        mineshaftGenerator = new MapGenMineshaft();
	        ravineGenerator = new MapGenRavine();
	        unusedIntArray32x32 = new int[32][32];
	        worldObj = world;
	        mapFeaturesEnabled = flag;
	        rand = new Random(l);
	        noiseGen1 = new NoiseGeneratorOctaves(rand, 16);
	        noiseGen2 = new NoiseGeneratorOctaves(rand, 16);
	        noiseGen3 = new NoiseGeneratorOctaves(rand, 8);
	        noiseGen4 = new NoiseGeneratorOctaves(rand, 4);
	        noiseGen5 = new NoiseGeneratorOctaves(rand, 10);
	        noiseGen6 = new NoiseGeneratorOctaves(rand, 16);
	        mobSpawnerNoise = new NoiseGeneratorOctaves(rand, 8);
	    }

	    public void generateTerrain(int i, int j, byte abyte0[])
	    {
	        byte byte0 = 4;
	        worldObj.getClass();
	        byte byte1 = 7;
	        worldObj.getClass();
	        byte byte2 = 30;
	        int k = byte0 + 1;
	        worldObj.getClass();
	        byte byte3 = 8;
	        int l = byte0 + 1;
	        biomesForGeneration = worldObj.getWorldChunkManager().func_35557_b(biomesForGeneration, i * 4 - 2, j * 4 - 2, k + 5, l + 5);
	        landMap = makeLandPerBiome(landMap, i * byte0, 0, j * byte0, k, byte3, l);
	        for(int i1 = 0; i1 < byte0; i1++)
	        {
	            for(int j1 = 0; j1 < byte0; j1++)
	            {
	                for(int k1 = 0; k1 < byte1; k1++)
	                {
	                    double d = 0.125D;
	                    double d1 = landMap[((i1 + 0) * l + (j1 + 0)) * byte3 + (k1 + 0)];
	                    double d2 = landMap[((i1 + 0) * l + (j1 + 1)) * byte3 + (k1 + 0)];
	                    double d3 = landMap[((i1 + 1) * l + (j1 + 0)) * byte3 + (k1 + 0)];
	                    double d4 = landMap[((i1 + 1) * l + (j1 + 1)) * byte3 + (k1 + 0)];
	                    double d5 = (landMap[((i1 + 0) * l + (j1 + 0)) * byte3 + (k1 + 1)] - d1) * d;
	                    double d6 = (landMap[((i1 + 0) * l + (j1 + 1)) * byte3 + (k1 + 1)] - d2) * d;
	                    double d7 = (landMap[((i1 + 1) * l + (j1 + 0)) * byte3 + (k1 + 1)] - d3) * d;
	                    double d8 = (landMap[((i1 + 1) * l + (j1 + 1)) * byte3 + (k1 + 1)] - d4) * d;
	                    for(int l1 = 0; l1 < 8; l1++)
	                    {
	                        double d9 = 0.25D;
	                        double d10 = d1;
	                        double d11 = d2;
	                        double d12 = (d3 - d1) * d9;
	                        double d13 = (d4 - d2) * d9;
	                        for(int i2 = 0; i2 < 4; i2++)
	                        {
	                            worldObj.getClass();
	                            worldObj.getClass();
	                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
	                            worldObj.getClass();
	                            char c = '\200';
	                            double d14 = 0.25D;
	                            double d15 = d10;
	                            double d16 = (d11 - d10) * d14;
	                            for(int k2 = 0; k2 < 4; k2++)
	                            {
	                                int l2 = 0;
	                                if(k1 * 8 + l1 < byte2)
	                                {
	                                    l2 = Block.waterStill.blockID;
	                                }
	                                if(d15 > 0.0D)
	                                {
	                                    l2 = Block.stone.blockID;
	                                }
	                                abyte0[j2] = (byte)l2;
	                                j2 += c;
	                                d15 += d16;
	                            }

	                            d10 += d12;
	                            d11 += d13;
	                        }

	                        d1 += d5;
	                        d2 += d6;
	                        d3 += d7;
	                        d4 += d8;
	                    }

	                }

	            }

	        }

	    }

	    public void replaceBlocksForBiome(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
	    {
	        worldObj.getClass();
	        byte byte0 = 30;
	        double d = 0.03125D;
	        stoneNoise = noiseGen4.generateNoiseOctaves(stoneNoise, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
	        for(int k = 0; k < 16; k++)
	        {
	            for(int l = 0; l < 16; l++)
	            {
	                BiomeGenBase biomegenbase = abiomegenbase[l + k * 16];
	                int i1 = (int)(stoneNoise[k + l * 16] / 3D + 3D + rand.nextDouble() * 0.25D);
	                int j1 = -1;
	                byte byte1 = biomegenbase.topBlock;
	                byte byte2 = biomegenbase.fillerBlock;
	                worldObj.getClass();
	                for(int k1 = 127; k1 >= 0; k1--)
	                {
	                    worldObj.getClass();
	                    int l1 = (l * 16 + k) * 128 + k1;
	                    if(k1 <= 0 + rand.nextInt(5))
	                    {
	                        abyte0[l1] = (byte)Block.bedrock.blockID;
	                        continue;
	                    }
	                    byte byte3 = abyte0[l1];
	                    if(byte3 == 0)
	                    {
	                        j1 = -1;
	                        continue;
	                    }
	                    if(byte3 != Block.stone.blockID)
	                    {
	                        continue;
	                    }
	                    if(j1 == -1)
	                    {
	                        if(i1 <= 0)
	                        {
	                            byte1 = 0;
	                            byte2 = (byte)Block.stone.blockID;
	                        } else
	                        if(k1 >= byte0 - 4 && k1 <= byte0 + 1)
	                        {
	                            byte1 = biomegenbase.topBlock;
	                            byte2 = biomegenbase.fillerBlock;
	                        }
	                        if(k1 < byte0 && byte1 == 0)
	                        {
	                            byte1 = (byte)Block.waterStill.blockID;
	                        }
	                        j1 = i1;
	                        if(k1 >= byte0 - 1)
	                        {
	                            abyte0[l1] = byte1;
	                        } else
	                        {
	                            abyte0[l1] = byte2;
	                        }
	                        continue;
	                    }
	                    if(j1 <= 0)
	                    {
	                        continue;
	                    }
	                    j1--;
	                    abyte0[l1] = byte2;
	                    if(j1 == 0 && byte2 == Block.sand.blockID)
	                    {
	                        j1 = rand.nextInt(4);
	                        byte2 = (byte)Block.sandStone.blockID;
	                    }
	                    if(j1 == 0)
	                    {
	                        break;
	                    }
	                }

	            }

	        }

	    }

	    public Chunk loadChunk(int i, int j)
	    {
	        return provideChunk(i, j);
	    }

	    public Chunk provideChunk(int i, int j)
	    {
	        rand.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
	        worldObj.getClass();
	        byte abyte0[] = new byte[32768];
	        Chunk chunk = new Chunk(worldObj, abyte0, i, j);
	        generateTerrain(i, j, abyte0);
	        biomesForGeneration = worldObj.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, i * 16, j * 16, 16, 16);
	        float af[] = null;
	        af = worldObj.getWorldChunkManager().getTemperatures(af, i * 16, j * 16, 16, 16);
	        addGlaciers(i, j, abyte0, biomesForGeneration, af);
	        raiseHills(i, j, abyte0);
	        replaceBlocksForBiome(i, j, abyte0, biomesForGeneration);
	        if(mapFeaturesEnabled)
	        {
	            strongholdGenerator.generate(this, worldObj, i, j, abyte0);
	            villageGenerator.generate(this, worldObj, i, j, abyte0);
	            towerGenerator.generate(this, worldObj, i, j, abyte0);
	        }
	        ravineGenerator.generate(this, worldObj, i, j, abyte0);
	        chunk.generateSkylightMap();
	        return chunk;
	    }

	    public void terraform(int i, int j, byte abyte0[])
	    {
	        for(int k = 0; k < 16; k++)
	        {
	            for(int l = 0; l < 16; l++)
	            {
	                double d = 0.5D;
	                byte byte0 = -1;
	                int j1 = -1;
	                for(int k1 = 127; k1 >= 0; k1--)
	                {
	                    int l1 = (k * 16 + l) * 128 + k1;
	                    byte byte1 = abyte0[l1];
	                    if(byte1 == 0)
	                    {
	                        continue;
	                    }
	                    if(j1 == -1)
	                    {
	                        int i1 = k1;
	                        j1 = (int)((double)i1 * d);
	                    }
	                    if(k1 >= j1)
	                    {
	                        abyte0[l1] = 0;
	                    }
	                }

	            }

	        }

	    }

	    public void raiseHills(int i, int j, byte abyte0[])
	    {
	        if(!nearChunkFeature(i, j, worldObj))
	        {
	            return;
	        }
	        int ai[] = nearestFeatureCenter(i, j, worldObj);
	        int k = nearestFeatureSize(i, j, worldObj);
	        int l = nearestFeatureType(i, j, worldObj);
	        double d = (double)(k * 2 + 1) * 16D;
	        int i1 = ai[0];
	        int j1 = ai[1];
	        for(int k1 = 0; k1 < 16; k1++)
	        {
	            for(int l1 = 0; l1 < 16; l1++)
	            {
	                byte byte0 = -1;
	                int k2 = -1;
	                int i3 = k1 - i1;
	                int j3 = l1 - j1;
	                int k3 = (int)Math.sqrt(i3 * i3 + j3 * j3);
	                int l3 = (int)(Math.cos(((double)k3 / d) * 3.1415926535897931D) * (d / 3D));
	                if(l < 4 || l == 8)
	                {
	                    for(int i4 = 0; i4 <= 127; i4++)
	                    {
	                        int k4 = (k1 * 16 + l1) * 128 + i4;
	                        byte byte1 = abyte0[k4];
	                        if(byte1 != 0 && byte1 != Block.ice.blockID)
	                        {
	                            continue;
	                        }
	                        if(k2 == -1)
	                        {
	                            int i2 = i4;
	                            k2 = i2 + l3;
	                        }
	                        if(i4 <= k2)
	                        {
	                            abyte0[k4] = (byte)Block.stone.blockID;
	                        }
	                    }

	                    int j4 = l3 - 4 - k;
	                    if(j4 < 0)
	                    {
	                        j4 = 0;
	                    }
	                    if(l == 4)
	                    {
	                        j4 = 100;
	                    }
	                    for(int l4 = 0; l4 <= 127; l4++)
	                    {
	                        int j5 = (k1 * 16 + l1) * 128 + l4;
	                        if(l3 > 0 && l4 < 30 && abyte0[j5] != Block.stone.blockID)
	                        {
	                            abyte0[j5] = (byte)Block.stone.blockID;
	                        }
	                        if(l4 > 28 && l4 < 28 + j4)
	                        {
	                            abyte0[j5] = 0;
	                        }
	                    }

	                }
	                if(l != 4 && l != 5 && l != 9)
	                {
	                    continue;
	                }
	                float f = 0.0F;
	                int i5 = 31;
	                int k5 = (k * 2 + 1) * 8 - 8;
	                if(i3 <= -k5)
	                {
	                    f = (float)(-i3 - k5) / 8F;
	                }
	                if(i3 >= k5)
	                {
	                    f = (float)(i3 - k5) / 8F;
	                }
	                if(j3 <= -k5)
	                {
	                    f = Math.max(f, (float)(-j3 - k5) / 8F);
	                }
	                if(j3 >= k5)
	                {
	                    f = Math.max(f, (float)(j3 - k5) / 8F);
	                }
	                if(f > 0.0F)
	                {
	                    int l2 = -1;
	                    for(int l5 = 0; l5 <= 127; l5++)
	                    {
	                        int j6 = (k1 * 16 + l1) * 128 + l5;
	                        byte byte2 = abyte0[j6];
	                        if(byte2 != Block.stone.blockID && l2 == -1)
	                        {
	                            int j2 = l5;
	                            i5 = (int)((float)i5 + (float)(j2 - i5) * f);
	                            l2 = j2;
	                        }
	                    }

	                }
	                for(int i6 = 0; i6 <= 127; i6++)
	                {
	                    int k6 = (k1 * 16 + l1) * 128 + i6;
	                    if(i6 < i5 && (abyte0[k6] == 0 || abyte0[k6] == Block.waterStill.blockID))
	                    {
	                        abyte0[k6] = (byte)Block.stone.blockID;
	                    }
	                    if(i6 >= i5 && abyte0[k6] != Block.waterStill.blockID)
	                    {
	                        abyte0[k6] = 0;
	                    }
	                }

	            }

	        }

	    }

	    public static boolean nearChunkFeature(int i, int j, World world)
	    {
	        for(int k = 1; k <= 3; k++)
	        {
	            for(int l = -k; l <= k; l++)
	            {
	                for(int i1 = -k; i1 <= k; i1++)
	                {
	                    if(featureSize(l + i, i1 + j, world) == k)
	                    {
	                        return true;
	                    }
	                }

	            }

	        }

	        return false;
	    }

	    public static int[] nearestFeatureCenter(int i, int j, World world)
	    {
	        for(int k = 1; k <= 3; k++)
	        {
	            for(int l = -k; l <= k; l++)
	            {
	                for(int i1 = -k; i1 <= k; i1++)
	                {
	                    if(featureSize(l + i, i1 + j, world) == k)
	                    {
	                        int ai1[] = {
	                            l * 16 + 8, i1 * 16 + 8
	                        };
	                        return ai1;
	                    }
	                }

	            }

	        }

	        int ai[] = {
	            0, 0
	        };
	        return ai;
	    }

	    public static boolean isHollowHill(int i, int j, World world)
	    {
	        int k = featureType(i, j, world);
	        return k > 0 && k < 4;
	    }

	    public static int nearestFeatureSize(int i, int j, World world)
	    {
	        for(int k = 1; k <= 3; k++)
	        {
	            for(int l = -k; l <= k; l++)
	            {
	                for(int i1 = -k; i1 <= k; i1++)
	                {
	                    if(featureSize(l + i, i1 + j, world) == k)
	                    {
	                        return k;
	                    }
	                }

	            }

	        }

	        return -1;
	    }

	    public static int nearestFeatureType(int i, int j, World world)
	    {
	        for(int k = 1; k <= 3; k++)
	        {
	            for(int l = -k; l <= k; l++)
	            {
	                for(int i1 = -k; i1 <= k; i1++)
	                {
	                    if(featureSize(l + i, i1 + j, world) == k)
	                    {
	                        return featureType(l + i, i1 + j, world);
	                    }
	                }

	            }

	        }

	        return -1;
	    }

	    public static int featureSize(int i, int j, World world)
	    {
	        int k = featureType(i, j, world);
	        if(k == 4)
	        {
	            return 2;
	        }
	        if(k == 5)
	        {
	            return 3;
	        }
	        if(k == 6)
	        {
	            return 1;
	        }
	        if(k == 7)
	        {
	            return 1;
	        }
	        if(k == 8)
	        {
	            return 2;
	        }
	        if(k == 9)
	        {
	            return 3;
	        }
	        if(k == 1 || k == 2 || k == 3)
	        {
	            return k;
	        } else
	        {
	            return -1;
	        }
	    }

	    public static int featureType(int i, int j, World world)
	    {
	        BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(i * 16 + 8, j * 16 + 8);
	        if(biomegenbase == BiomeGenBase.ocean || biomegenbase == AetherWorldBiomeBase.tfOcean)
	        {
	            return -1;
	        }
	        if(i % 7 != 4 && i % 7 != -4 || j % 7 != 4 && j % 7 != -4)
	        {
	            return -1;
	        }
	        Random random = new Random(world.getWorldSeed() + (long)(i * 25117) + (long)(j * 0x24e51));
	        int k = random.nextInt(41);
	        if(biomegenbase == AetherWorldBiomeBase.glacier && k % 2 == 0)
	        {
	            return 7;
	        }
	        switch(k)
	        {
	        case 1: // '\001'
	        case 2: // '\002'
	        case 3: // '\003'
	        case 4: // '\004'
	        case 5: // '\005'
	        case 6: // '\006'
	            return 1;

	        case 7: // '\007'
	        case 8: // '\b'
	        case 9: // '\t'
	            return 2;

	        case 10: // '\n'
	            return 3;

	        case 11: // '\013'
	        case 12: // '\f'
	            return biomegenbase == AetherWorldBiomeBase.glacier ? -1 : 4;

	        case 13: // '\r'
	            return 5;

	        case 14: // '\016'
	        case 15: // '\017'
	            return 6;

	        case 16: // '\020'
	        case 17: // '\021'
	        case 18: // '\022'
	        case 19: // '\023'
	        default:
	            return -1;
	        }
	    }

	    private double[] makeLandPerBiome(double ad[], int i, int j, int k, int l, int i1, int j1)
	    {
	        if(ad == null)
	        {
	            ad = new double[l * i1 * j1];
	        }
	        if(squareTable == null)
	        {
	            squareTable = new float[25];
	            for(int k1 = -2; k1 <= 2; k1++)
	            {
	                for(int l1 = -2; l1 <= 2; l1++)
	                {
	                    float f = 10F / MathHelper.sqrt_float((float)(k1 * k1 + l1 * l1) + 0.2F);
	                    squareTable[k1 + 2 + (l1 + 2) * 5] = f;
	                }

	            }

	        }
	        double d = 684.41200000000003D;
	        double d1 = 684.41200000000003D;
	        noise5 = noiseGen5.func_4109_a(noise5, i, k, l, j1, 1.121D, 1.121D, 0.5D);
	        noise6 = noiseGen6.func_4109_a(noise6, i, k, l, j1, 200D, 200D, 0.5D);
	        noise3 = noiseGen3.generateNoiseOctaves(noise3, i, j, k, l, i1, j1, d / 80D, d1 / 160D, d / 80D);
	        noise1 = noiseGen1.generateNoiseOctaves(noise1, i, j, k, l, i1, j1, d, d1, d);
	        noise2 = noiseGen2.generateNoiseOctaves(noise2, i, j, k, l, i1, j1, d, d1, d);
	        i = k = 0;
	        int i2 = 0;
	        int j2 = 0;
	        for(int k2 = 0; k2 < l; k2++)
	        {
	            for(int l2 = 0; l2 < j1; l2++)
	            {
	                float f1 = 0.0F;
	                float f2 = 0.0F;
	                float f3 = 0.0F;
	                byte byte0 = 2;
	                BiomeGenBase biomegenbase = biomesForGeneration[k2 + 2 + (l2 + 2) * (l + 5)];
	                for(int i3 = -byte0; i3 <= byte0; i3++)
	                {
	                    for(int j3 = -byte0; j3 <= byte0; j3++)
	                    {
	                        BiomeGenBase biomegenbase1 = biomesForGeneration[k2 + i3 + 2 + (l2 + j3 + 2) * (l + 5)];
	                        float f4 = squareTable[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.minHeight + 2.0F);
	                        if(biomegenbase1.minHeight > biomegenbase.minHeight)
	                        {
	                            f4 /= 2.0F;
	                        }
	                        f1 += biomegenbase1.maxHeight * f4;
	                        f2 += biomegenbase1.minHeight * f4;
	                        f3 += f4;
	                    }

	                }

	                f1 /= f3;
	                f2 /= f3;
	                f1 = f1 * 0.9F + 0.1F;
	                f2 = (f2 * 4F - 1.0F) / 8F;
	                double d2 = noise6[j2] / 8000D;
	                if(d2 < 0.0D)
	                {
	                    d2 = -d2 * 0.29999999999999999D;
	                }
	                d2 = d2 * 3D - 2D;
	                if(d2 < 0.0D)
	                {
	                    d2 /= 2D;
	                    if(d2 < -1D)
	                    {
	                        d2 = -1D;
	                    }
	                    d2 /= 1.3999999999999999D;
	                    d2 /= 2D;
	                } else
	                {
	                    if(d2 > 1.0D)
	                    {
	                        d2 = 1.0D;
	                    }
	                    d2 /= 8D;
	                }
	                j2++;
	                for(int k3 = 0; k3 < i1; k3++)
	                {
	                    double d3 = f2;
	                    double d4 = f1;
	                    d3 += d2 * 0.20000000000000001D;
	                    d3 = (d3 * (double)i1) / 16D;
	                    double d5 = (double)i1 / 2D + d3 * 4D;
	                    double d6 = 0.0D;
	                    worldObj.getClass();
	                    double d7 = (((double)k3 - d5) * 12D * 128D) / 128D / d4;
	                    if(d7 < 0.0D)
	                    {
	                        d7 *= 4D;
	                    }
	                    double d8 = noise1[i2] / 512D;
	                    double d9 = noise2[i2] / 512D;
	                    double d10 = (noise3[i2] / 10D + 1.0D) / 2D;
	                    if(d10 < 0.0D)
	                    {
	                        d6 = d8;
	                    } else
	                    if(d10 > 1.0D)
	                    {
	                        d6 = d9;
	                    } else
	                    {
	                        d6 = d8 + (d9 - d8) * d10;
	                    }
	                    d6 -= d7;
	                    if(k3 > i1 - 4)
	                    {
	                        double d11 = (float)(k3 - (i1 - 4)) / 3F;
	                        d6 = d6 * (1.0D - d11) + -10D * d11;
	                    }
	                    ad[i2] = d6;
	                    i2++;
	                }

	            }

	        }

	        return ad;
	    }

	    public void addGlaciers(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[], float af[])
	    {
	        for(int k = 0; k < 16; k++)
	        {
	            for(int l = 0; l < 16; l++)
	            {
	                BiomeGenBase biomegenbase = abiomegenbase[l + k * 16];
	                if(biomegenbase != AetherWorldBiomeBase.glacier)
	                {
	                    continue;
	                }
	                int i1 = -1;
	                double d = 127;
	                do
	                {
	                    if(d < 0)
	                    {
	                        break;
	                    }
/*(int)rajout*/	                    int j1 = (int) ((l * 16 + k) * 128 + d);
	                    byte byte0 = abyte0[j1];
	                    if(byte0 == Block.stone.blockID)
	                    {
/*(int)rajout*/		                        i1 = (int) d;
	                        abyte0[j1] = (byte)Block.gravel.blockID;
	                        break;
	                    }
	                    d--;
	                } while(true);
	                d = Math.min(af[l + k * 16], 0.10000000000000001D);
	                int k1 = 16 + (int)((0.10000000000000001D - d) * 16D);
	                int l1 = i1 + k1 + 1;
	                for(int i2 = i1 + 1; i2 <= l1 && i2 < 128; i2++)
	                {
	                    int j2 = (l * 16 + k) * 128 + i2;
	                    abyte0[j2] = (byte)Block.ice.blockID;
	                }

	            }

	        }

	    }

	    public boolean chunkExists(int i, int j)
	    {
	        return true;
	    }

	    public void populate(IChunkProvider ichunkprovider, int i, int j)
	    {
	        BlockSand.fallInstantly = true;
	        int k = i * 16;
	        int l = j * 16;
	        BiomeGenBase biomegenbase = worldObj.getWorldChunkManager().getBiomeGenAt(k + 16, l + 16);
	        rand.setSeed(worldObj.getWorldSeed());
	        long l1 = (rand.nextLong() / 2L) * 2L + 1L;
	        long l2 = (rand.nextLong() / 2L) * 2L + 1L;
	        rand.setSeed((long)i * l1 + (long)j * l2 ^ worldObj.getWorldSeed());
	        boolean flag = false;
	        if(mapFeaturesEnabled)
	        {
	            strongholdGenerator.generateStructuresInChunk(worldObj, rand, i, j);
	            mineshaftGenerator.generateStructuresInChunk(worldObj, rand, i, j);
	            flag = villageGenerator.generateStructuresInChunk(worldObj, rand, i, j);
	            flag |= towerGenerator.generateStructuresInChunk(worldObj, rand, i, j);
	        }
	        flag |= nearestFeatureType(i, j, worldObj) > 3;
	        if(!flag && rand.nextInt(4) == 0)
	        {
	            int i1 = k + rand.nextInt(16) + 8;
	            worldObj.getClass();
	            int j2 = rand.nextInt(128);
	            int k3 = l + rand.nextInt(16) + 8;
	            (new WorldGenLakes(Block.waterStill.blockID)).generate(worldObj, rand, i1, j2, k3);
	        }
	        if(!flag && rand.nextInt(32) == 0)
	        {
	            int j1 = k + rand.nextInt(16) + 8;
	            worldObj.getClass();
	            int k2 = rand.nextInt(rand.nextInt(120) + 8);
	            int l3 = l + rand.nextInt(16) + 8;
	            worldObj.getClass();
	            if(k2 < 63 || rand.nextInt(10) == 0)
	            {
	                (new WorldGenLakes(Block.lavaStill.blockID)).generate(worldObj, rand, j1, k2, l3);
	            }
	        }
	        for(int k1 = 0; k1 < 8; k1++)
	        {
	            int i3 = k + rand.nextInt(16) + 8;
	            worldObj.getClass();
	            int i4 = rand.nextInt(128);
	            int k4 = l + rand.nextInt(16) + 8;
	            if((new WorldGenDungeons()).generate(worldObj, rand, i3, i4, k4));
	        }

	        biomegenbase.func_35477_a(worldObj, rand, k, l);
	        SpawnerAnimals.func_35957_a(worldObj, biomegenbase, k + 8, l + 8, 16, 16, rand);
	        SpawnerAnimals.func_35957_a(worldObj, biomegenbase, k + 8, l + 8, 16, 16, rand);
	        k += 8;
	        l += 8;
	        for(int i2 = 0; i2 < 16; i2++)
	        {
	            for(int j3 = 0; j3 < 16; j3++)
	            {
	                int j4 = worldObj.func_35461_e(k + i2, l + j3);
	                if(worldObj.func_40471_p(i2 + k, j4 - 1, j3 + l))
	                {
	                    worldObj.setBlockWithNotify(i2 + k, j4 - 1, j3 + l, Block.ice.blockID);
	                }
	                if(worldObj.func_40478_r(i2 + k, j4, j3 + l))
	                {
	                    worldObj.setBlockWithNotify(i2 + k, j4, j3 + l, Block.snow.blockID);
	                }
	            }

	        }

	        BlockSand.fallInstantly = false;
	    }

	    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate)
	    {
	        return true;
	    }

	    public boolean unload100OldestChunks()
	    {
	        return false;
	    }

	    public boolean canSave()
	    {
	        return true;
	    }

	    public String makeString()
	    {
	        return "RandomLevelSource";
	    }

	    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
	    {
	        WorldChunkManager worldchunkmanager = worldObj.getWorldChunkManager();
	        if(worldchunkmanager == null)
	        {
	            return null;
	        }
	        BiomeGenBase biomegenbase = worldchunkmanager.getBiomeGenAtChunkCoord(new ChunkCoordIntPair(i >> 4, k >> 4));
	        if(biomegenbase == null)
	        {
	            return null;
	        } else
	        {
	            return biomegenbase.getSpawnableList(enumcreaturetype);
	        }
	    }

	    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
	    {
	        if("Stronghold".equals(s) && strongholdGenerator != null)
	        {
	            return strongholdGenerator.func_40484_a(world, i, j, k);
	        } else
	        {
	            return null;
	        }
	    }


}
