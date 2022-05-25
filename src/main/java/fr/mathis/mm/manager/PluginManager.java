package fr.mathis.mm.manager;

import fr.mathis.mm.mMaintenance;

public class PluginManager {
    public static mMaintenance getInstance() {
        return mMaintenance.instance;
    }
}
