package net.minecraft.src;

import net.minecraft.src.*;

public class MMC_BlockAetherDungeon extends Block{
	
	public MMC_BlockAetherDungeon(int i)
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
        return blockID == MMC_Block.BlockAetherLightDungeonStone.blockID || blockID == MMC_Block.BlockAetherLockedLightDungeonStone.blockID;
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
    public static int sprBronzeLit = MMC_Textures.TexBlockAetherLightCarvedStone;
    public static int sprSilverLit = MMC_Textures.TexBlockAetherLightAngelicStone;
    public static int sprGoldLit = MMC_Textures.TexBlockAetherLightHellfireStone;

    static 
    {
        sprBronze = MMC_BlockAetherTrap.sprBronze;
        sprSilver = MMC_BlockAetherTrap.sprSilver;
        sprGold = MMC_BlockAetherTrap.sprGold;
    }
}
