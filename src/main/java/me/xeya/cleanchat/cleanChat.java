package me.xeya.cleanchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class cleanChat extends JavaPlugin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // || command.getName().equalsIgnoreCase("clearchat")
        if (command.getName().equalsIgnoreCase("cleanchat")) {
            Player p = (Player) sender;
            if (p.hasPermission("cleanchat.use")) {
                //Clean chat
                for (int i = 0; i < 35; i++) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("");
                    }
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&3Chat was cleared by &3 ") + p.getDisplayName());
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNo permission!"));
            }
        }
       return true;
    }
}
