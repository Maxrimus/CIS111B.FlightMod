package mods.CIS111B.flightMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

/*
 * Class to help with handling crafting recipes.
 */
public class CraftingHandler implements ICraftingHandler {
@Override
public void onCrafting(EntityPlayer player, ItemStack item,
IInventory craftMatrix) {
	for(int i=0; i < craftMatrix.getSizeInventory(); i++) //Checks all the slots
	{		
	if(craftMatrix.getStackInSlot(i) != null) //If there is an item
	{
	ItemStack j = craftMatrix.getStackInSlot(i); //Gets the item
	if(j.getItem() != null && j.getItem() == FlightMod.revitalizer) 
	{
		 ItemStack k = new ItemStack(FlightMod.revitalizer, 2, (j.getItemDamage() + 1)); //Makes a new itemstack that's been damaged and has 2 items
		 if(k.getItemDamage() >= k.getMaxDamage()){ //If it is destroyed
		 k.stackSize--; //Removes the added item
		 }
		 craftMatrix.setInventorySlotContents(i, k); //Sets the slot to the new item
	}
	}
	}
}
@Override
public void onSmelting(EntityPlayer player, ItemStack item) {
}
}
