package me.Saciek.plugRole.items;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class MinersPotionManager {

    public static ItemStack MinersPotion;

    public static void innit() {
        createEnchantPotion();
    }

    private static void createEnchantPotion(){
        ItemStack item = new ItemStack(Material.HONEY_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Miners Potion");
        List<String> lore = new ArrayList<>();
        lore.add("§8This potion will give you boost to your mining skills for 1 hour");
        lore.add("§8after that you will have to wait 1.5 hour to use miners potion again");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        MinersPotion = item;
    }
}
