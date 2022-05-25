package fr.mathis.mm.listeners;

import fr.mathis.mm.mMaintenance;
import fr.mathis.mm.utils.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    public PlayerListener(mMaintenance plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(mMaintenance.Enable) {
            if(event.getPlayer().isOp() || mMaintenance.getAuthorized().contains(event.getPlayer().getUniqueId())) {
                return;
            } else {
                event.getPlayer().kickPlayer(Lang.PLAYER_MAINTENANCE_KICK.getLang());
            }
        }
    }

}
