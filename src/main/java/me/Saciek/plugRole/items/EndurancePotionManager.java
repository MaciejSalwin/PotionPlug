package me.Saciek.plugRole.items;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class EndurancePotionManager {

    public static ItemStack EndurancePotion;

    public static void innit() {
        createEndurancePotion();
    }

    private static void createEndurancePotion(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Endurance Potion");
        List<String> lore = new ArrayList<>();
        lore.add("§8This potion will give you boost to your overall endurance skills such as speed etc");
        lore.add("§8after that you will have to wait 1.5 hour to use miners potion again");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        EndurancePotion = item;
    }
}
