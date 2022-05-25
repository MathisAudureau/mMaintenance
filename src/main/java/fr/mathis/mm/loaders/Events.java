package fr.mathis.mm.loaders;

import fr.mathis.mm.listeners.PlayerListener;
import fr.mathis.mm.mMaintenance;

public class Events {
    public static void init(mMaintenance plugin) {
        new PlayerListener(plugin);
    }
}
