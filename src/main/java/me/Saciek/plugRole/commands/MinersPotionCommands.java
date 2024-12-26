package me.Saciek.plugRole.commands;

import me.Saciek.plugRole.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MinersPotionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("Potion")) {
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

            ItemStack emeralds = new ItemStack(Material.EMERALD);
            if (!inventory.containsAtLeast(emeralds, 12)) {
                player.sendMessage(ChatColor.RED + "You don't have enough emeralds in your inventory. You need 12 emeralds.");
                return true;
            }

            emeralds.setAmount(12);
            inventory.removeItem(emeralds);
            inventory.addItem(ItemManager.EnchantPotion);
            player.sendMessage(ChatColor.GREEN + "The UberPotion has been added to your inventory!");
            return true;
        }

        return false;
    }
}
