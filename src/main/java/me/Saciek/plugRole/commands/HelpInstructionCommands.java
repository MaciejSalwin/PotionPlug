package me.Saciek.plugRole.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpInstructionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("help_potion")) {
            player.sendMessage(ChatColor.AQUA + "How to use PotionPlug:");
            player.sendMessage(ChatColor.AQUA + "--------------------------------");
            player.sendMessage(ChatColor.DARK_AQUA + "/MinersPotion - Gives you a potion that grants basic mining effects, such as Haste, Luck, and Night Vision (Level 1)");
            player.sendMessage(ChatColor.RED + "COST - 12 EMERALDS");
            player.sendMessage(ChatColor.DARK_AQUA + "/EndurancePotion - Gives you a potion that grants basic endurance effects, such as Speed, FireRes, Jump and DamageRes (Level 1)");
            player.sendMessage(ChatColor.RED + "COST - 32 GOLD");
            player.sendMessage(ChatColor.GREEN + "Each potion lasts for 1 hour and has a 1.5-hour cooldown");

            return true;
        }

        return false;
    }
}
