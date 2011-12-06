package net.minecraft.src;

public class MMC_ItemMoreArmor extends Item {

    public MMC_ItemMoreArmor(int i, int j, int k, int l, int i1)
    {
        super(i);
        armorLevel = j;
        armorType = l;
        renderIndex = k;
        damageReduceAmount = damageReduceAmountArray[l];
        setMaxDamage(maxDamageArray[l] * 3 << j);
        maxStackSize = 1;
        colour = i1;
        colouriseRender = true;
        texture = "/armor/Accessories.png";
    }

    public MMC_ItemMoreArmor(int i, int j, int k, int l)
    {
        this(i, j, k, l, 0xffffff);
    }

    public MMC_ItemMoreArmor(int i, int j, String s, int k)
    {
        this(i, j, 0, k);
        texture = s;
    }

    public MMC_ItemMoreArmor(int i, int j, String s, int k, int l)
    {
        this(i, j, 0, k, l);
        texture = s;
    }

    public MMC_ItemMoreArmor(int i, int j, String s, int k, int l, boolean flag)
    {
        this(i, j, s, k, l);
        colouriseRender = flag;
    }

    public boolean isTypeValid(int i)
    {
        if(i == armorType)
        {
            return true;
        }
        if((i == 8 || i == 9) && (armorType == 8 || armorType == 9))
        {
            return true;
        }
        return (i == 7 || i == 11) && (armorType == 7 || armorType == 11);
    }

    public boolean damageType()
    {
        return damageType(armorType);
    }

    public boolean damageType(int i)
    {
        return i < 4 || i == 6 || i == 10;
    }

    public int getColorFromDamage(int i)
    {
        return colour;
    }

    private static final int damageReduceAmountArray[] = {
        3, 8, 6, 3, 0, 1, 0, 0, 0, 0, 
        2, 0
    };
    private static final int maxDamageArray[] = {
        11, 16, 15, 13, 10, 10, 8, 10, 10, 10, 
        10, 10
    };
    public final int armorLevel;
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    private final int colour;
    public String texture;
    public boolean colouriseRender;
}
