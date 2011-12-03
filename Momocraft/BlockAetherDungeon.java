package net.minecraft.src.Momocraft;

import net.minecraft.src.*;

public class BlockAetherDungeon extends Block{
	
	public BlockAetherDungeon(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 2)
        {
            return isLit() ? sprGoldLit : sprGold;
        }
        if(j == 1)
        {
            return isLit() ? sprSilverLit : sprSilver;
        } else
        {
            return isLit() ? sprBronzeLit : sprBronze;
        }
    }

    private boolean isLit()
    {
        return blockID == MomocraftBlocks.BlockAetherLightDungeonStone.blockID || blockID == MomocraftBlocks.BlockAetherLockedLightDungeonStone.blockID;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int func_21034_c(int i)
    {
        return ~i & 0xf;
    }

    public static int func_21035_d(int i)
    {
        return ~i & 0xf;
    }

    public static int sprBronze;
    public static int sprSilver;
    public static int sprGold;
    public static int sprBronzeLit = MomocraftTextures.TexBlockAetherLightCarvedStone;
    public static int sprSilverLit = MomocraftTextures.TexBlockAetherLightAngelicStone;
    public static int sprGoldLit = MomocraftTextures.TexBlockAetherLightHellfireStone;

    static 
    {
        sprBronze = BlockAetherTrap.sprBronze;
        sprSilver = BlockAetherTrap.sprSilver;
        sprGold = BlockAetherTrap.sprGold;
    }
}
