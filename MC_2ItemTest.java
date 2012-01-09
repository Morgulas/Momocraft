/*
 * Momocraft - SteveVuillaume 
 * Pour serveur privée de Konjin sous Bukkit
 * stevevuillaume@gmail.com
 */

package net.minecraft.src;

//Class qui hérite de la classe mère Item
public class MC_2ItemTest extends Item {

	//Constructeur
	public MC_2ItemTest(int i) {
		super(i);		//Le "super" dit qu'il va prendre le constructeur de la class mère Item
	}
	
    
/*    Faire une action au clique droit :
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    return itemstack--;
    }

Liste des fonctions (Sera complété au fur et à mesure)

-Définir le max de la barre de vie d'un item : setMaxDamage(64);
-Enlever un peu de la barre de vie d'un item : itemstack.damageItem(1, entityplayer);
*/    
    
}
