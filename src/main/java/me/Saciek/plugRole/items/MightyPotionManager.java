package me.Saciek.plugRole.items;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class MightyPotionManager {

    public static ItemStack MightyPotion;

    public static void innit() {
        CreateMightyPotion();
    }

    private static void CreateMightyPotion(){
        ItemStack item = new ItemStack(Material.LINGERING_POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Mighty Potion");
        List<String> lore = new ArrayList<>();
        lore.add("§8This potion will give you boost to your overall fighting skills such as DamageRes or FireRes etc");
        lore.add("§8after that you will have to wait 1 hour to use mighty potion again");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        MightyPotion = item;
    }
}
