package me.Saciek.plugRole.event;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.Saciek.plugRole.items.MinersPotionManager.MinersPotion;

public class MinersPotionEvent implements Listener {

        @EventHandler
        public static void afterDrank(PlayerInteractEvent event){
            ItemStack potion = event.getItem();
            if (potion != null && potion.isSimilar(MinersPotion)){
                event.getPlayer().getInventory().removeItem(MinersPotion);
                event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "You Got - MinerPotion");
                event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.FAST_DIGGING, 72000 , 0)));
                event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.NIGHT_VISION, 72000 , 0)));
                event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.LUCK, 72000 , 0)));
            }
        }
    }


