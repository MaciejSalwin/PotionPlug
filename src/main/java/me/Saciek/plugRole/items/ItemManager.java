package me.Saciek.plugRole.items;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack EnchantPotion;

    public static void innit() {
        createEnchantPotion();
    }

    private static void createEnchantPotion(){
        ItemStack item = new ItemStack(Material.HONEY_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Potion of Endless Desire");
        List<String> lore = new ArrayList<>();
        lore.add("§8This Potion will give you 0.3 boost in all your enchantments for 1 hour.");
        lore.add("§8After this time you will have to wait 24 hours for next use");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        EnchantPotion = item;
    }
}
