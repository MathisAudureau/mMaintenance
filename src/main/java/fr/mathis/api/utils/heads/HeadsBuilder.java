package fr.mathis.api.utils.heads;

import java.util.List;

import fr.mathis.api.message.Color;
import fr.mathis.api.message.Decoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadsBuilder {
    public static ItemStack getPlayerHead(Player player, List<String> lore) {

        ItemStack playerSkull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta playerSkullM = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);

        playerSkullM.setDisplayName(Color.GOLD + Decoration.BOLD + player.getName());
        playerSkullM.setOwner(player.getName());
        playerSkullM.setLore(lore);
        playerSkull.setItemMeta((ItemMeta)playerSkullM);

        return playerSkull;
    }
}
