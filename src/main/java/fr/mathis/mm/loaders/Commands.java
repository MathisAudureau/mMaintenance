package fr.mathis.mm.loaders;

import fr.mathis.mm.commands.MaintenanceCommand;
import fr.mathis.mm.mMaintenance;

public class Commands {
    public static void init(mMaintenance plugin) {
        new MaintenanceCommand(plugin);
    }
}
