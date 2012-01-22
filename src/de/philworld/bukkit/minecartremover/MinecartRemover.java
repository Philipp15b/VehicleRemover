package de.philworld.bukkit.minecartremover;

import java.util.logging.Logger;

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
		getServer().getPluginManager().registerEvents(new MinecartRemoverListener(), this);
		
		PluginDescriptionFile pff = this.getDescription();
        log.info(pff.getName() +  " " + pff.getVersion() + " is enabled.");
	}
	
}
