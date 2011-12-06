package net.minecraft.src;

import net.minecraft.src.*;


public class MMC_Achievements {
	
	public MMC_Achievements()
	    {
	        enterAether = (new Achievement(800, "enterAether", 0, 0, Block.glowStone, null)).registerAchievement();
	        defeatBronze = (new Achievement(801, "defeatBronze", -2, 3, new ItemStack(MMC_Item.ItemAetherKey, 1, 0), enterAether)).registerAchievement();
	        defeatSilver = (new Achievement(802, "defeatSilver", 0, 4, new ItemStack(MMC_Item.ItemAetherKey, 1, 1), enterAether)).registerAchievement();
	        defeatGold = (new Achievement(803, "defeatGold", 2, 3, new ItemStack(MMC_Item.ItemAetherKey, 1, 2), enterAether)).registerAchievement();
//	        enchanter = (new Achievement(804, "enchanter", 2, 1, MomocraftBlocks.BlockAetherEnchanter, enterAether)).registerAchievement();
//	        incubator = (new Achievement(805, "incubator", 2, -1, MomocraftBlocks.BlockAetherIncubator, enterAether)).registerAchievement();
	        blueCloud = (new Achievement(806, "blueCloud", -2, -1, new ItemStack(MMC_Block.BlockAetherAercloud, 1, 1), enterAether)).registerAchievement();
	        flyingPig = (new Achievement(807, "flyingPig", -2, 1, Item.saddle, enterAether)).registerAchievement();
	        gravTools = (new Achievement(808, "gravTools", -1, -3, MMC_Item.ItemAetherPickGravitite, enterAether)).registerAchievement();
	        lore = (new Achievement(809, "lore", 1, -3, Item.book, enterAether)).registerAchievement();
	        loreception = (new Achievement(810, "loreception", 1, -5, Item.book, lore)).registerAchievement();
	        ModLoader.AddAchievementDesc(enterAether, "Hostile Paradise", "Ascend to the Aether");
	        ModLoader.AddAchievementDesc(defeatBronze, "Like a Bossaru!", "Defeat the bronze boss");
	        ModLoader.AddAchievementDesc(defeatSilver, "Dethroned", "Defeat the silver boss");
	        ModLoader.AddAchievementDesc(defeatGold, "Extinguished", "Defeat the gold boss");
	        ModLoader.AddAchievementDesc(enchanter, "Do you believe in magic?", "Craft an enchanter");
	        ModLoader.AddAchievementDesc(incubator, "Now you're family", "Incubate a moa");
	        ModLoader.AddAchievementDesc(blueCloud, "To infinity and beyond!", "Bounce on a blue cloud");
	        ModLoader.AddAchievementDesc(flyingPig, "When phygs fly!", "Fly on a phyg");
	        ModLoader.AddAchievementDesc(gravTools, "Pink is the new blue", "Craft a gravitite tool");
	        ModLoader.AddAchievementDesc(lore, "The more you know!", "Read a book of lore");
	        ModLoader.AddAchievementDesc(loreception, "Lore-ception", "It's a book in a book in a book in...");
/*A corriger	        AetherACPage aetheracpage = new AetherACPage();
	        aetheracpage.addAchievements(new Achievement[] {
	            enterAether, defeatBronze, defeatSilver, defeatGold, enchanter, incubator, gravTools, blueCloud, flyingPig, lore, 
	            loreception
	        });*/
	    }

	    public static final int acOff = 800;
	    public static Achievement enterAether;
	    public static Achievement defeatBronze;
	    public static Achievement defeatSilver;
	    public static Achievement defeatGold;
	    public static Achievement enchanter;
	    public static Achievement incubator;
	    public static Achievement gravTools;
	    public static Achievement blueCloud;
	    public static Achievement flyingPig;
	    public static Achievement lore;
	    public static Achievement loreception;
}
