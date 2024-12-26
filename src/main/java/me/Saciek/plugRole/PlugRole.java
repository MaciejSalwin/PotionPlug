package me.Saciek.plugRole;
import me.Saciek.plugRole.commands.MinersPotionCommands;
import me.Saciek.plugRole.event.MinersPotionEvent;
import me.Saciek.plugRole.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugRole extends JavaPlugin {

    @Override
    public void onEnable() {
        MinersPotionCommands command = new MinersPotionCommands();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RolePlug] - is turned On ");
        CommandSender RolePlugCommands;
        ItemManager.innit();
        getServer().getPluginManager().registerEvents(new MinersPotionEvent(), this);
        getCommand("Potion").setExecutor(command);
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RolePlug] - is turned Off");
    }
}
