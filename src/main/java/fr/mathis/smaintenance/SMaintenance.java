package fr.mathis.smaintenance;

import fr.mathis.api.utils.annotation.AuthorAnnotation;
import fr.mathis.api.utils.annotation.PluginAnnotation;
import fr.mathis.api.utils.enums.Info;
import fr.mathis.smaintenance.commands.MaintenanceCommand;
import fr.mathis.smaintenance.listeners.PlayerListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

@AuthorAnnotation(Name = "Mathis Audureau", Github = "https://github.com/mathisaudureau")
@PluginAnnotation(Name = "sMaintenance", Main = "fr.mathis.smaintenance.sMaintenance", Version = "1.0")
public class SMaintenance extends JavaPlugin {
    final Logger logger = this.getLogger();

    public static boolean Enable = false;
    private static Set<UUID> Authorized = new HashSet<>();

    @Override
    public void onEnable() {
        logger.info(Info.PLUGIN_IS_ENABLE.getValue().replace("%pl_name%", "sMaintenance"));
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerListener(), this);

        this.getCommand("maintenance").setExecutor(new MaintenanceCommand());
    }

    @Override
    public void onLoad() {
        logger.info(Info.PLUGIN_IS_LOAD.getValue().replace("%pl_name%", "sMaintenance"));
    }

    @Override
    public void onDisable() {
        logger.info(Info.PLUGIN_IS_DISABLE.getValue().replace("%pl_name%", "sMaintenance"));
    }

    public static Set<UUID> getAuthorized() {
        return Authorized;
    }
}
