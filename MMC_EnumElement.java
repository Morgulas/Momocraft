package net.minecraft.src;



public final class MMC_EnumElement{
	
	public static MMC_EnumElement[] values()
    {
        return (MMC_EnumElement[])$VALUES.clone();
    }

    public static MMC_EnumElement valueOf(String s)
    {
		return null;
        //return (EnumElement)Enum.valueOf(net.minecraft.src.EnumElement.class, s);
    }

    private MMC_EnumElement(String s, int i)
    {
        //super(s, i);
    }

    public static final MMC_EnumElement Fire;
    public static final MMC_EnumElement Lightning;
    public static final MMC_EnumElement Holy;
    private static final MMC_EnumElement $VALUES[]; /* synthetic field */

    static 
    {
        Fire = new MMC_EnumElement("Fire", 0);
        Lightning = new MMC_EnumElement("Lightning", 1);
        Holy = new MMC_EnumElement("Holy", 2);
        $VALUES = (new MMC_EnumElement[] {
            Fire, Lightning, Holy
        });
    }
}
