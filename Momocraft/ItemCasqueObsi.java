package net.minecraft.src.Momocraft;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;

public class ItemCasqueObsi extends ItemArmor {

	public ItemCasqueObsi(int i, EnumArmorMaterial enumarmormaterial, int j, int k) {
		super(i, enumarmormaterial, j, k);
	}
	//La variable J correspond a la texture
	//- i : c'est l'id
	//- Enum: Propriete de l'armure
	//- j: ModLoader.AddArmor("steelArmor") : on ajoute l'armure au jeu, "steelArmor" étant le nom de la texture (de l'armure complète).
	//- k: 0 -> casque, 1 -> torse, 2 -> jambes et 3 -> pieds.

}
