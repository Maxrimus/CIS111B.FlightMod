package mods.CIS111B.flightMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class FlightArmor extends ItemArmor implements IArmorTextureProvider{

	public FlightArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setMaxStackSize(1);
	}

	public void updateIcons(IconRegister icon) 
	{ 
		this.iconIndex = icon.registerIcon("CIS111B:" + this.getUnlocalizedName());
	}

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
