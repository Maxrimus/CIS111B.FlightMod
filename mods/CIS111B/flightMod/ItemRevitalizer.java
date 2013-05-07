package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/*
 * Class to deal with the Revitalizer item, as it is a different type of item,
 * having a damage value as opposed to the other items in this mod.
 */
public class ItemRevitalizer extends Item {

	public ItemRevitalizer(int par1) {
		super(par1);
		this.setMaxDamage(16);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Retrieves the item textures for this item. 
	 */
	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}
}
    
