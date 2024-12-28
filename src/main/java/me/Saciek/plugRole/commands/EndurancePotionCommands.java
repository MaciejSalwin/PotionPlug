
package me.Saciek.plugRole.commands;

import me.Saciek.plugRole.items.EndurancePotionManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.UUID;

public class EndurancePotionCommands implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public EndurancePotionCommands() {
        this.cooldown = new HashMap<>();
    }

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

                ItemStack gold_ingots = new ItemStack(Material.GOLD_INGOT);
                if (!inventory.containsAtLeast(gold_ingots, 32)) {
                    player.sendMessage(ChatColor.RED + "You don't have enough gold in your inventory. You need 32 gold ingots.");
                    return true;
                }
                if (!this.cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) > 3_600_000){

                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

                    gold_ingots.setAmount(32);
                inventory.removeItem(gold_ingots);
                inventory.addItem(EndurancePotionManager.EndurancePotion);
                player.sendMessage(ChatColor.GREEN + "The EndurancePotion has been added to your inventory!");
                return true;

            }else {
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                    long seconds = (3_600_000 - timeElapsed) /1000;
                    long minutes = (seconds)/ 60;
                    if(seconds > 60) {
                        player.sendMessage(ChatColor.RED + "You have to wait " + minutes + " minutes to buy EndurancePotion again");
                    }else{
                        player.sendMessage(ChatColor.RED + "You have to wait " + seconds + " secounds to buy EndurancePotion again");
                    }
                }
        }
        return true;
    }
}
