package me.Saciek.plugRole.commands;

import me.Saciek.plugRole.items.EndurancePotionManager;
import me.Saciek.plugRole.items.MinersPotionManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EndurancePotionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("EndurancePotion")) {
            Inventory inventory = player.getInventory();
            boolean hasFreeSlot = false;
            for (int i = 0; i < 36; i++) {
                if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                    hasFreeSlot = true;
                    break;
                }
            }

            if (!hasFreeSlot) {
                player.sendMessage(ChatColor.RED + "You need at least one free slot in your inventory.");
                return true;
            }

            ItemStack gold = new ItemStack(Material.GOLD_INGOT);
            if (!inventory.containsAtLeast(gold, 32)) {
                player.sendMessage(ChatColor.RED + "You don't have enough gold in your inventory. You need 32 gold.");
                return true;
            }

            gold.setAmount(32);
            inventory.removeItem(gold);
            inventory.addItem(EndurancePotionManager.EndurancePotion);
            player.sendMessage(ChatColor.GREEN + "The EndurancePotion has been added to your inventory!");
            return true;
        }

        return false;
    }
}
