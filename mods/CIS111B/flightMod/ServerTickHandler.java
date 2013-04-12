package mods.CIS111B.flightMod;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet type, Object[] tickData)
	  {
	    EntityPlayer player = (EntityPlayer)tickData[0];

	    boolean wasFlying = player.capabilities.isFlying;

	    if (player.inventory.armorInventory[2] != null)
	    {
	      int id = player.inventory.armorInventory[2].itemID;
	      if (id == 54)
	      {
	        player.capabilities.allowFlying = true;
	      }
	      else
	      {
	        player.capabilities.allowFlying = false;
	        player.capabilities.isFlying = false;
	      }
	    }
	    else
	    {
	      player.capabilities.allowFlying = false;
	      player.capabilities.isFlying = false;
	    }

	    if (player.capabilities.isCreativeMode)
	    {
	      player.capabilities.allowFlying = true;
	      player.capabilities.isFlying = wasFlying;
	    }
	  }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
