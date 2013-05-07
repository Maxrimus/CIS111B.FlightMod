package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
/*
 * this class represents the behavior of the Wings armor piece.
 */
public class Wings extends ItemArmor {
	/*
	 * registers the wings in the minecraft directory.
	 */
	public Wings(int par1, EnumArmorMaterial par2, int par3, int par4) {
		super(par1,par2,par3,par4);
	}

	/*
	 * retrieves the item texture for this item.
	 */
	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}
}
