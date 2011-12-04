package net.minecraft.src.Momocraft;

import java.util.Random;

import net.minecraft.src.*;

public class ItemAetherAxeGravitite extends ItemTool{

	public ItemAetherAxeGravitite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        float f = entityplayer.rotationPitch;
        float f1 = entityplayer.rotationYaw;
        double d = entityplayer.posX;
        double d1 = (entityplayer.posY + 1.6200000000000001D) - (double)entityplayer.yOffset;
        double d2 = entityplayer.posZ;
        Vec3D vec3d = Vec3D.createVector(d, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.01745329F - 3.141593F);
        float f3 = MathHelper.sin(-f1 * 0.01745329F - 3.141593F);
        float f4 = -MathHelper.cos(-f * 0.01745329F);
        float f5 = MathHelper.sin(-f * 0.01745329F);
        float f6 = f3 * f4;
        float f7 = f5;
        float f8 = f2 * f4;
        double d3 = 5D;
        Vec3D vec3d1 = vec3d.addVector((double)f6 * d3, (double)f7 * d3, (double)f8 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do(vec3d, vec3d1, false);
        if(movingobjectposition == null)
        {
            return itemstack;
        }
        if(movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            if(!world.multiplayerWorld)
            {
                int l = world.getBlockId(i, j, k);
                int i1 = world.getBlockMetadata(i, j, k);
                for(int j1 = 0; j1 < blocksEffectiveAgainst.length; j1++)
                {
                    if(l == blocksEffectiveAgainst[j1].blockID)
                    {
                        EntityFloatingBlock entityfloatingblock = new EntityFloatingBlock(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, l);
                        world.entityJoinedWorld(entityfloatingblock);
                    }
                }

            }
            itemstack.damageItem(4, entityplayer);
        }
        return itemstack;
    }

/*    public ToolBase getToolBase()
    {
        return ToolBase.Axe;
    }
*/
    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            MomocraftBlocks.BlockAetherPlank, MomocraftBlocks.BlockAetherLog
        });
    }
	
	
}