package net.minecraft.src;

import java.util.*;

import net.minecraft.src.*;

public class AetherWorldTreasure {

    int type;
    protected AetherWorldTreasureTable useless;
    protected AetherWorldTreasureTable common;
    protected AetherWorldTreasureTable uncommon;
    protected AetherWorldTreasureTable rare;
    protected AetherWorldTreasureTable ultrarare;
    public static AetherWorldTreasure hill1 = new AetherWorldTreasure(1);
    public static AetherWorldTreasure hill2 = new AetherWorldTreasure(2);
    public static AetherWorldTreasure hill3 = new AetherWorldTreasure(3);
    public static AetherWorldTreasure hedgemaze = new AetherWorldTreasure(4);
    public static AetherWorldTreasure underhill_room = new AetherWorldTreasure(5);
    public static AetherWorldTreasure underhill_deadend = new AetherWorldTreasure(6);
    public static AetherWorldTreasure tower_room = new AetherWorldTreasure(7);

    public AetherWorldTreasure(int i)
    {
        type = i;
        useless = new AetherWorldTreasureTable();
        common = new AetherWorldTreasureTable();
        uncommon = new AetherWorldTreasureTable();
        rare = new AetherWorldTreasureTable();
        ultrarare = new AetherWorldTreasureTable();
        fill(i);
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        boolean flag = true;
        world.setBlockWithNotify(i, j, k, Block.chest.blockID);
        for(int l = 0; l < 4; l++)
        {
            flag &= addItemToChest(world, random, i, j, k, getCommonItem(random));
        }

        for(int i1 = 0; i1 < 2; i1++)
        {
            flag &= addItemToChest(world, random, i, j, k, getUncommonItem(random));
        }

        for(int j1 = 0; j1 < 1; j1++)
        {
            flag &= addItemToChest(world, random, i, j, k, getRareItem(random));
        }

        return flag;
    }

    public ItemStack getCommonItem(Random random)
    {
        if(random.nextInt(4) == 0)
        {
            return useless.getRandomItem(random);
        } else
        {
            return common.getRandomItem(random);
        }
    }

    public ItemStack getUncommonItem(Random random)
    {
        return uncommon.getRandomItem(random);
    }

    public ItemStack getRareItem(Random random)
    {
        if(random.nextInt(4) == 0)
        {
            return ultrarare.getRandomItem(random);
        } else
        {
            return rare.getRandomItem(random);
        }
    }

    protected boolean addItemToChest(World world, Random random, int i, int j, int k, ItemStack itemstack)
    {
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
        if(tileentitychest != null)
        {
            int l = findRandomInventorySlot(tileentitychest, random);
            if(l != -1)
            {
                tileentitychest.setInventorySlotContents(l, itemstack);
                return true;
            }
        }
        return false;
    }

    protected int findRandomInventorySlot(TileEntityChest tileentitychest, Random random)
    {
        for(int i = 0; i < 100; i++)
        {
            int j = random.nextInt(tileentitychest.getSizeInventory());
            if(tileentitychest.getStackInSlot(j) == null)
            {
                return j;
            }
        }

        return -1;
    }

    protected void fill(int i)
    {
        useless.add(Block.plantRed, 4);
        useless.add(Block.plantYellow, 4);
        useless.add(Item.feather, 3);
        useless.add(Item.seeds, 2);
        useless.add(Item.flint, 2);
        useless.add(Block.cactus, 2);
        useless.add(Block.reed, 4);
        useless.add(Block.sand, 4);
        if(i == 1 || i == 2 || i == 3)
        {
            common.add(Item.ingotIron, 4);
            common.add(Item.wheat, 4);
            common.add(Item.silk, 4);
            common.add(Item.bucketEmpty, 1);
            uncommon.add(Item.bread, 1);
            uncommon.add(Item.gunpowder, 4);
            uncommon.add(Item.arrow, 12);
            uncommon.add(Block.torchWood, 12);
            rare.add(Item.ingotGold, 3);
            rare.add(Item.pickaxeSteel, 1);
            rare.add(Item.saddle, 1);
            ultrarare.add(Item.compass, 1);
            ultrarare.add(Item.recordCat, 1);
            ultrarare.add(Item.diamond, 1);
        }
        if(i == 4)
        {
            common.add(Block.planks, 4);
            common.add(Block.mushroomBrown, 4);
            common.add(Block.mushroomRed, 4);
            common.add(Item.wheat, 4);
            common.add(Item.silk, 4);
            common.add(Item.stick, 6);
            uncommon.add(Item.melon, 4);
            uncommon.add(Item.melonSeeds, 4);
            uncommon.add(Item.pumpkinSeeds, 4);
            uncommon.add(Item.arrow, 12);
            uncommon.add(MomocraftBlocks.TestBlock, 4);
            rare.add(Block.web, 3);
            rare.add(Item.shears, 1);
            rare.add(Item.saddle, 1);
            rare.add(Item.bow, 1);
            rare.add(Item.appleRed, 2);
            ultrarare.add(Item.hoeDiamond, 1);
            ultrarare.add(Item.diamond, 1);
            ultrarare.add(Item.bowlSoup, 1);
            ultrarare.add(Item.appleGold, 1);
        }
        if(i == 5)
        {
            common.add(Item.ingotIron, 4);
            common.add(Item.bread, 1);
            common.add(Item.wheat, 6);
            common.add(Item.gunpowder, 4);
            common.add(Item.legsLeather, 1);
            common.add(Item.helmetLeather, 1);
            common.add(Item.bootsLeather, 1);
            common.add(Item.plateLeather, 1);
            uncommon.add(Item.legsSteel, 1);
            uncommon.add(Item.helmetSteel, 1);
            uncommon.add(Item.bootsSteel, 1);
            uncommon.add(Item.plateSteel, 1);
            uncommon.add(Item.swordSteel, 1);
            uncommon.add(Item.axeSteel, 1);
            uncommon.add(Item.bow, 1);
            rare.add(Item.redstone, 6);
            rare.add(Item.lightStoneDust, 4);
            rare.add(Block.tnt, 3);
            rare.add(Item.beefCooked, 1);
            ultrarare.add(Item.saddle, 1);
            ultrarare.add(Item.book, 1);
            ultrarare.add(Item.painting, 1);
            ultrarare.add(Item.appleGold, 1);
            ultrarare.add(Item.recordCat, 1);
        }
        if(i == 6)
        {
            common.add(Item.stick, 12);
            common.add(Item.coal, 12);
            common.add(Item.arrow, 12);
            common.add(Item.wheat, 4);
            uncommon.add(Item.gunpowder, 4);
            uncommon.add(Block.planks, 6);
            uncommon.add(Item.leather, 4);
            uncommon.add(Item.silk, 4);
            uncommon.add(Item.paper, 3);
            uncommon.add(Item.bread, 1);
            rare.add(Item.ingotIron, 3);
            rare.add(Item.redstone, 6);
            rare.add(Item.lightStoneDust, 4);
            ultrarare.add(Item.book, 1);
            ultrarare.add(Item.ingotIron, 10);
            ultrarare.add(Item.cookie, 1);
        }
        if(i == 7)
        {
            common.add(Item.snowball, 6);
            common.add(Item.paper, 4);
            common.add(Item.arrow, 12);
            common.add(Item.feather, 11);
            uncommon.add(Item.swordGold, 1);
            uncommon.add(Item.pickaxeGold, 1);
            uncommon.add(Block.torchRedstoneActive, 4);
            uncommon.add(Item.silk, 4);
            uncommon.add(Item.book, 1);
            uncommon.add(Item.bread, 1);
            rare.add(Item.slimeBall, 3);
            rare.add(Item.redstone, 6);
            rare.add(Item.compass, 1);
            ultrarare.add(Item.enderPearl, 1);
            ultrarare.add(Block.obsidian, 4);
            ultrarare.add(Item.diamond, 1);
        }
    }

}
