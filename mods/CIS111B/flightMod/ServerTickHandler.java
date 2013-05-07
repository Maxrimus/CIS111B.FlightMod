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
	
	/*
	 * Deals with detecting information about the player during a tick(1/20th of
	 * a second)
	 */
	private void onPlayerTick(EntityPlayer player){
	    
	    if (player.getCurrentItemOrArmor(4) != null)//detects if there is a helm
	    {
	    	Item helmet= player.getCurrentItemOrArmor(4).getItem();//checks if helm is mod helm
	    	int id = helmet.itemID;
	        if (FlightMod.isHelmet(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.nightVision.getId(), 3600, 0)));//applies potion effect to player
	        }
	    }
	    
	    if (player.getCurrentItemOrArmor(2) != null)//detects if there are pants
	    {
	    	Item pants = player.getCurrentItemOrArmor(2).getItem();//checks if pants are mod pants
	    	int id = pants.itemID;
	        if (FlightMod.isPairOfPants(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 3600, 2)));//applies potion effect to player
	        }
	    }    
	    
	    if (player.getCurrentItemOrArmor(1) != null)//detects if there are boots
	    {
	    	Item boots = player.getCurrentItemOrArmor(1).getItem();//checks if boots are mod boots
	    	int id = boots.itemID;
	        if (FlightMod.isPairOfBoots(id))
	        {
	        	player.addPotionEffect((new PotionEffect(Potion.jump.getId(), 3600, 2)));//applies potion effect to player
	        }
	    } 
	}
	
	/*
	 * Detects information about a player at the beginning of a tick 
	 */
	@Override
	public void tickStart(EnumSet type, Object[] tickData)
	  {
		EntityPlayer player = (EntityPlayer)tickData[0];//gathers information about player
	    boolean wasFlying = player.capabilities.isFlying;//determines if player is already flying
	    if (player.inventory.armorInventory[2] != null)//detects if chestpiece is worn
	    {
	      int id = player.inventory.armorInventory[2].itemID;
	      if (FlightMod.isPairOfWings(id))//checks if chest is mod chest
	      {
	        player.capabilities.allowFlying = true;//allows the player to fly
	      }
	      else
	      {
	        player.capabilities.allowFlying = false;//disables flight
	        player.capabilities.isFlying = false;//cancels any current flight
	      }
	    }
	    else
	    {
	      player.capabilities.allowFlying = false;//disables flight
	      player.capabilities.isFlying = false;//cancels any current flight
	    }

	    if (player.capabilities.isCreativeMode)//checks if player is in creative mode, meaning flying would already be allowed
	    {
	      player.capabilities.allowFlying = true;
	      player.capabilities.isFlying = wasFlying;
	    }
	    
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		  {
		    onPlayerTick((EntityPlayer)tickData[0]);//passes player data to onPlayerTick
		  }
	  }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);//returns data of player
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
