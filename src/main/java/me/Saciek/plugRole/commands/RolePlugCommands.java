package me.Saciek.plugRole.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RolePlugCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labelif, String[] strings) {
        if(!(sender instanceof Player))
        {return true;}
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("Potion")){
            ItemStack emeralds = new ItemStack(Material.EMERALD);
            if(player.getInventory().containsAtLeast(emeralds, 64)){
                player.sendMessage(ChatColor.GREEN + "The UberPotion is in your inventory!");
            }else{
                player.sendMessage(ChatColor.RED + "You don't have enought emeralds in your inventory - You need 64 emeralds");
            }
        }
        return true;
    }
}
