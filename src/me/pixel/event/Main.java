package me.pixel.event;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("oevent")) {
			if (!sender.hasPermission("oevent.broadcast")) {
				sender.sendMessage(ChatColor.RED + "You cannot run this command!");
				return true;
			}
			
			Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
			
			 for(Player p : Bukkit.getOnlinePlayers()){
				 
				 String title = this.getConfig().getString("title");
				 String sub_title = this.getConfig().getString("sub-title");
				 
				 int fade_in = this.getConfig().getInt("fade-in");
				 int duration = this.getConfig().getInt("duration");
				 int fade_out = this.getConfig().getInt("fade-out");
				 
				 p.sendTitle(title.replaceAll("&", "§"), sub_title.replaceAll("&", "§"), 20, 100, 20);
				 
			 }
			
			
		}
		
		return false;
		
	}
}
