package me.Saciek.plugRole.event;

import me.Saciek.plugRole.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import static me.Saciek.plugRole.items.ItemManager.EnchantPotion;

public class EnchantPotionEvent implements Listener {

        @EventHandler
        public static void afterDrank(PlayerInteractEvent event){
            ItemStack potion = event.getItem();
            if (potion != null && potion.isSimilar(EnchantPotion)){
                event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "DZIAŁA PICIE POTKI");

            }
        }
    }


