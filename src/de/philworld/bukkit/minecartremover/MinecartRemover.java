package de.philworld.bukkit.minecartremover;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartRemover extends JavaPlugin {

    Logger log = Logger.getLogger("Minecraft"); 
	
	@Override
	public void onDisable() {
        PluginDescriptionFile pff = this.getDescription();
        log.info(pff.getName() +  " " + pff.getVersion() + " is disabled.");
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvent(Event.Type.VEHICLE_EXIT, new MinecartRemoverVehicleListener(), Priority.Normal, this);
		
		PluginDescriptionFile pff = this.getDescription();
        log.info(pff.getName() +  " " + pff.getVersion() + " is enabled.");
	}
	
}