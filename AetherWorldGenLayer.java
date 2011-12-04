package net.minecraft.src;

import net.minecraft.src.*;

public class AetherWorldGenLayer extends GenLayer
{
	  public AetherWorldGenLayer(long l)
	    {
	        super(l);
	    }

	    public static GenLayer[] makeTheWorld(long l)
	    {
	        Object obj = new AetherWorldLayerBase(1L);
	        obj = new GenLayerZoomFuzzy(2000L, ((GenLayer) (obj)));
	        obj = new GenLayerIsland(1L, ((GenLayer) (obj)));
	        obj = new GenLayerZoom(2001L, ((GenLayer) (obj)));
	        obj = new GenLayerIsland(2L, ((GenLayer) (obj)));
	        obj = new GenLayerZoom(2002L, ((GenLayer) (obj)));
	        obj = new GenLayerIsland(3L, ((GenLayer) (obj)));
	        obj = new GenLayerZoom(2003L, ((GenLayer) (obj)));
	        obj = new GenLayerIsland(3L, ((GenLayer) (obj)));
	        obj = new GenLayerZoom(2004L, ((GenLayer) (obj)));
	        obj = new GenLayerIsland(3L, ((GenLayer) (obj)));
	        byte byte0 = 4;
	        Object obj1 = obj;
	        obj1 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj1)), 0);
	        obj1 = new GenLayerRiverInit(100L, ((GenLayer) (obj1)));
	        obj1 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj1)), byte0 + 2);
	        obj1 = new AetherWorldGenLayerStream(1L, ((GenLayer) (obj1)));
	        obj1 = new GenLayerSmooth(1000L, ((GenLayer) (obj1)));
	        Object obj2 = obj;
	        obj2 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj2)), 0);
	        obj2 = new AetherWorldGenLayerBiomes(200L, ((GenLayer) (obj2)));
	        obj2 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj2)), 1);
	        obj2 = new AetherWorldGenLayerLakes(777L, ((GenLayer) (obj2)));
	        obj2 = new AetherWorldGenLayerGlaciers(200L, ((GenLayer) (obj2)));
	        obj2 = new AetherWorldGenLayerSnow(300L, ((GenLayer) (obj2)));
	        obj2 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj2)), 1);
	        Object obj3 = new GenLayerTemperature(((GenLayer) (obj2)));
	        Object obj4 = new GenLayerDownfall(((GenLayer) (obj2)));
	        for(int i = 0; i < byte0; i++)
	        {
	            obj2 = new GenLayerZoom(1000 + i, ((GenLayer) (obj2)));
	            if(i == 0)
	            {
	                obj2 = new GenLayerIsland(3L, ((GenLayer) (obj2)));
	            }
	            obj3 = new GenLayerSmoothZoom(1000 + i, ((GenLayer) (obj3)));
	            obj3 = new GenLayerTemperatureMix(((GenLayer) (obj3)), ((GenLayer) (obj2)), i);
	            obj4 = new GenLayerSmoothZoom(1000 + i, ((GenLayer) (obj4)));
	            obj4 = new GenLayerDownfallMix(((GenLayer) (obj4)), ((GenLayer) (obj2)), i);
	        }

	        obj2 = new GenLayerSmooth(1000L, ((GenLayer) (obj2)));
	        obj2 = new GenLayerRiverMix(100L, ((GenLayer) (obj2)), ((GenLayer) (obj1)));
	        obj2 = new AetherWorldGenLayerOceanReplacement(100L, ((GenLayer) (obj2)));
	        obj3 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj3)), 2);
	        obj4 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj4)), 2);
	        GenLayerZoomVoronoi genlayerzoomvoronoi = new GenLayerZoomVoronoi(10L, ((GenLayer) (obj2)));
	        ((GenLayer) (obj2)).func_35496_b(l);
	        ((GenLayer) (obj3)).func_35496_b(l);
	        ((GenLayer) (obj4)).func_35496_b(l);
	        genlayerzoomvoronoi.func_35496_b(l);
	        return (new GenLayer[] {
	            (GenLayer) obj2, genlayerzoomvoronoi, (GenLayer) obj3, (GenLayer) obj4
	        });
	    }

		@Override
		public int[] func_35500_a(int i, int j, int k, int l) {
			// TODO Auto-generated method stub
			return null;
		}

}
