package me.Saciek.plugRole;

import me.Saciek.plugRole.commands.RolePlugCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugRole extends JavaPlugin {

    @Override
    public void onEnable() {
        RolePlugCommands command = new RolePlugCommands();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RolePlug] - is turned On ");
        CommandSender RolePlugCommands;
        getCommand("Potion").setExecutor(command);

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RolePlug] - is turned Off");
    }
}
