package me.Saciek.plugRole.event;
import me.Saciek.plugRole.items.MightyPotionManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MightyPotionEvent implements Listener {

    @EventHandler
    public static void afterDrank(PlayerInteractEvent event){
        ItemStack potion = event.getItem();
        if (potion != null && potion.isSimilar(MightyPotionManager.MightyPotion)){
            event.getPlayer().getInventory().removeItem(MightyPotionManager.MightyPotion);
            event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "You Got - MightyPotion");
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 72000 , 0)));
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 72000 , 0)));
            event.getPlayer().addPotionEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 36000 , 0)));
        }
    }
}


