package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class Wings extends Item {

	public Wings(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}
}
