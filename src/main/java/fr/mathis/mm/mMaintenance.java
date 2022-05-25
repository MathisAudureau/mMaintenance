package fr.mathis.mm;

import fr.mathis.api.utils.annotation.AuthorAnnotation;
import fr.mathis.api.utils.annotation.PluginAnnotation;
import fr.mathis.api.utils.enums.Info;
import fr.mathis.mm.commands.MaintenanceCommand;
import fr.mathis.mm.listeners.PlayerListener;
import fr.mathis.mm.loaders.Commands;
import fr.mathis.mm.loaders.Events;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.beans.EventHandler;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

@AuthorAnnotation(Name = "Mathis Audureau", Github = "https://github.com/mathisaudureau")
@PluginAnnotation(Name = "mMaintenance", Main = "fr.mathis.mm.mMaintenance", Version = "1.0")
public class mMaintenance extends JavaPlugin {
    final Logger logger = this.getLogger();

    public static mMaintenance instance;
    public static boolean Enable = false;
    private static final Set<UUID> Authorized = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;
        logger.info(Info.PLUGIN_IS_ENABLE.getValue().replace("%pl_name%", "mMaintenance"));

        Events.init(instance);
        Commands.init(instance);
    }

    @Override
    public void onLoad() {
        logger.info(Info.PLUGIN_IS_LOAD.getValue().replace("%pl_name%", "mMaintenance"));
    }

    @Override
    public void onDisable() {
        logger.info(Info.PLUGIN_IS_DISABLE.getValue().replace("%pl_name%", "mMaintenance"));
    }

    public static Set<UUID> getAuthorized() {
        return Authorized;
    }
}
