package de.philworld.bukkit.vehicleremover;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class VehicleRemover extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft"); 

	@Override
	public void onDisable() {
		PluginDescriptionFile pff = this.getDescription();
		log.info(pff.getName() +  " " + pff.getVersion() + " is disabled.");
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new VehicleRemoverListener(), this);

		PluginDescriptionFile pff = this.getDescription();
		log.info(pff.getName() +  " " + pff.getVersion() + " is enabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

		// Determine if the sender is a player (and an op), or the console.
		boolean isPlayer  = (sender instanceof Player);

		// Cast the sender to Player if possible.
		Player p = (isPlayer) ? (Player) sender : null;

		// ---------------
		// Remove vehicles
		// ----------------
		if(cmd.getName().equalsIgnoreCase("removevehicles")) {
			int removedVehicles = 0;

			if (p.hasPermission("minecartremover.removevehicles")) {
				for (World world : getServer().getWorlds()) {
					for (Entity entity : world.getEntities()) {
						if ((entity instanceof Vehicle)) {
							if(((Vehicle) entity).isEmpty()) {
								entity.remove();
								++removedVehicles;
							}
						}
					}
				}

				sender.sendMessage(ChatColor.GREEN + "[VehicleRemover] " + removedVehicles + " empty Vehicles have been removed.");

				return true;
			}
			sender.sendMessage(ChatColor.RED + "You dont have permissions to do this!");
			return true;
		}

		return false;
	}

}