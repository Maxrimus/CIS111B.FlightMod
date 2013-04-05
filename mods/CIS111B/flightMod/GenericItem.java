package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class GenericItem extends Item {

	public GenericItem(int par1) {
		super(par1);
	}
	@Override 
	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon(this.getUnlocalizedName());
	}
}
