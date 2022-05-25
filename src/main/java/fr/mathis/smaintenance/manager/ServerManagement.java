package fr.mathis.smaintenance.manager;

import fr.mathis.smaintenance.SMaintenance;
import fr.mathis.smaintenance.utils.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerManagement {
    public static void kickAllNotAllowed() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.isOp() || SMaintenance.getAuthorized().contains(player.getUniqueId())) {
                continue;
            } else {
                player.kickPlayer(Lang.PLAYER_MAINTENANCE_KICK.getLang());
            }
        }
    }
}
