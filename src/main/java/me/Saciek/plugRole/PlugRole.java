package me.Saciek.plugRole;
import me.Saciek.plugRole.commands.EndurancePotionCommands;
import me.Saciek.plugRole.commands.HelpInstructionCommands;
import me.Saciek.plugRole.commands.MinersPotionCommands;
import me.Saciek.plugRole.event.EndurancePotionEvent;
import me.Saciek.plugRole.event.MinersPotionEvent;
import me.Saciek.plugRole.items.EndurancePotionManager;
import me.Saciek.plugRole.items.MinersPotionManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugRole extends JavaPlugin {

    @Override
    public void onEnable() {
        MinersPotionCommands minersCommands = new MinersPotionCommands();
        EndurancePotionCommands enduranceCommands = new EndurancePotionCommands();
        HelpInstructionCommands helpCommands = new HelpInstructionCommands();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RolePlug] - is turned On ");
        CommandSender RolePlugCommands;
        MinersPotionManager.innit();
        EndurancePotionManager.innit();
        getServer().getPluginManager().registerEvents(new MinersPotionEvent(), this);
        getServer().getPluginManager().registerEvents(new EndurancePotionEvent(), this);
        getCommand("MinersPotion").setExecutor(minersCommands);
        getCommand("EndurancePotion").setExecutor(enduranceCommands);
        getCommand("help_potion").setExecutor(helpCommands);
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RolePlug] - is turned Off");
    }
}
