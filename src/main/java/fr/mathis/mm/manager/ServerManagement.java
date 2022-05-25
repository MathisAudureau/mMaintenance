package fr.mathis.mm.manager;

import fr.mathis.mm.mMaintenance;
import fr.mathis.mm.utils.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerManagement {
    public static void kickAllNotAllowed() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.isOp() || mMaintenance.getAuthorized().contains(player.getUniqueId())) {
            } else {
                player.kickPlayer(Lang.PLAYER_MAINTENANCE_KICK.getLang());
            }
        }
    }
}
