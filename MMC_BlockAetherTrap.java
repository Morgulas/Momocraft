package net.minecraft.src;

import java.util.*;
import net.minecraft.src.*;


public class MMC_BlockAetherTrap extends BlockBreakable{
	
	public MMC_BlockAetherTrap(int i)
    {
        super(i, sprBronze, Material.rock, false);
        setTickOnLoad(true);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 2)
        {
            return sprGold;
        }
        if(j == 1)
        {
            return sprSilver;
        } else
        {
            return sprBronze;
        }
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

/*    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, "aether.sound.other.dungeontrap.activateTrap", 1.0F, 1.0F);
            int l = MathHelper.floor_double(i);
            int i1 = MathHelper.floor_double(j);
            int j1 = MathHelper.floor_double(k);
            switch(world.getBlockMetadata(i, j, k))
            {
            case 0: // '\0'
                EntitySentry entitysentry = new EntitySentry(world);
                entitysentry.setPosition((double)l + 0.5D, (double)i1 + 1.5D, (double)j1 + 0.5D);
                world.entityJoinedWorld(entitysentry);
                break;

            case 1: // '\001'
                EntityValkyrie entityvalkyrie = new EntityValkyrie(world);
                entityvalkyrie.setPosition((double)l + 0.5D, (double)i1 + 1.5D, (double)j1 + 0.5D);
                world.entityJoinedWorld(entityvalkyrie);
                break;
            }
            world.setBlockAndMetadataWithNotify(i, j, k, MomocraftBlocks.BlockAetherLockedDungeonStone.blockID, world.getBlockMetadata(i, j, k));
        }
    }
*/
    protected int damageDropped(int i)
    {
        return i;
    }

    public static int sprBronze = MMC_Textures.TexBlockAetherCarvedStone;
    public static int sprSilver = MMC_Textures.TexBlockAetherAngelicStone;
    public static int sprGold = MMC_Textures.TexBlockAetherHellfireStone;
}
