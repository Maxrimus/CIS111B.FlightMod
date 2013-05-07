package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
/*
 * This class represents the armor that was specially created for this mod. It
 * also retrieves the armor texture files for us, as well as the item files.
 */
public class FlightArmor extends ItemArmor implements IArmorTextureProvider{

	/*
	 * registers this armor in the minecraft directory
	 */
	public FlightArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setMaxStackSize(1);
	}

	/*
	 * retrieves the item texture for this item.
	 */
	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}

	/*
	 * retrieves the on-player armor texture for this item.
	 */
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(this.armorType == 2)
		{
			return ("/mods/CIS111B/textures/armor/" + this.getArmorMaterial() + "_2.png");
		}
		else
		{
			return ("/mods/CIS111B/textures/armor/" + this.getArmorMaterial() + "_1.png");
		}
	}
}
