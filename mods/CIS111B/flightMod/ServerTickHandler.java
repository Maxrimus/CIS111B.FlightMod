package mods.CIS111B.flightMod;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	
	private void onPlayerTick(EntityPlayer player){
	    
	    if (player.getCurrentItemOrArmor(4) != null)
	    {
	    	Item helmet= player.getCurrentItemOrArmor(4).getItem();
	    	int id = helmet.itemID;
	        if (FlightMod.isHelmet(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.nightVision.getId(), 3600, 0)));
	        }
	    }
	    
	    if (player.getCurrentItemOrArmor(2) != null)
	    {
	    	Item pants = player.getCurrentItemOrArmor(2).getItem();
	    	int id = pants.itemID;
	        if (FlightMod.isPairOfPants(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 3600, 2)));
	        }
	    }    
	    
	    if (player.getCurrentItemOrArmor(1) != null)
	    {
	    	Item boots = player.getCurrentItemOrArmor(1).getItem();
	    	int id = boots.itemID;
	        if (FlightMod.isPairOfBoots(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.jump.getId(), 3600, 2)));
	        }
	    } 
	}
	@Override
	public void tickStart(EnumSet type, Object[] tickData)
	  {
		EntityPlayer player = (EntityPlayer)tickData[0];
	    boolean wasFlying = player.capabilities.isFlying;
	    if (player.inventory.armorInventory[2] != null)
	    {
	      int id = player.inventory.armorInventory[2].itemID;
	      if (FlightMod.isPairOfWings(id))
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
	    
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		  {
		    onPlayerTick((EntityPlayer)tickData[0]);
		  }
	  }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
