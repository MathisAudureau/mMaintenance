package fr.mathis.smaintenance.listeners;

import fr.mathis.smaintenance.SMaintenance;
import fr.mathis.smaintenance.utils.enums.Lang;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(SMaintenance.Enable) {
            if(event.getPlayer().isOp() || SMaintenance.getAuthorized().contains(event.getPlayer().getUniqueId())) {
                return;
            } else {
                event.getPlayer().kickPlayer(Lang.PLAYER_MAINTENANCE_KICK.getLang());
            }
        }
    }

}
