package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class GenericItem extends Item {

	/*
	 * Registers the item in the minecraft directory.
	 */
	public GenericItem(int par1) {
		super(par1);
	}
	
	/*
	 * retrieves the item texture for this item.
	 */
	@Override 
	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}
}
