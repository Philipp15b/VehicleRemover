package de.philworld.bukkit.vehicleremover;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

public class VehicleRemoverListener implements Listener {
	
	@EventHandler
	public void onVehicleExit(VehicleExitEvent event) {
		event.getVehicle().remove();
		if(event.getExited() instanceof Player) {
			Player p = (Player) event.getExited();
			if(p.getGameMode() == GameMode.CREATIVE) { 
				p.sendMessage(ChatColor.GREEN + "[VehicleRemover] The vehicle has been removed.");
			} else {
				if(event.getVehicle() instanceof Minecart) {
					p.getInventory().addItem(new ItemStack(Material.MINECART, 1));
					p.sendMessage(ChatColor.GREEN + "[VehicleRemover] The minecart has been added to your inventory.");
				} else if(event.getVehicle() instanceof Boat) {
					p.getInventory().addItem(new ItemStack(Material.BOAT, 1));
					p.sendMessage(ChatColor.GREEN + "[VehicleRemover] The boat has been added to your inventory.");
				}
			}
		}
		
	}
}
