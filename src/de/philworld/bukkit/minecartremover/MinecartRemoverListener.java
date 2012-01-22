package de.philworld.bukkit.minecartremover;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

public class MinecartRemoverListener implements Listener {
	public void onVehicleExit(VehicleExitEvent event) {
		event.getVehicle().remove();
		if(event.getExited() instanceof Player) {
			Player p = (Player) event.getExited();
			if(p.getGameMode() == GameMode.CREATIVE) { 
				p.sendMessage(ChatColor.GREEN + "[MinecartRemover] The minecart has been removed.");
			} else {
				p.getInventory().addItem(new ItemStack(Material.MINECART, 1));
				p.sendMessage(ChatColor.GREEN + "[MinecartRemover] The minecart has been added to your inventory.");
			}
		}
	}
}
