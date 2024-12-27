package me.Saciek.plugRole.event;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.Saciek.plugRole.items.EndurancePotionManager.EndurancePotion;

public class EndurancePotionEvent implements Listener {

    @EventHandler
    public static void afterDrank(PlayerInteractEvent event){
        ItemStack potion = event.getItem();
        if (potion != null && potion.isSimilar(EndurancePotion)){
            event.getPlayer().getInventory().removeItem(EndurancePotion);
            event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "You Got - EndurancePotion");
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.REGENERATION, 36000 , 0)));
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 12000 , 0)));
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.JUMP, 72000 , 0)));
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 72000 , 0)));
        }
    }
}


