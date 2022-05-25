package fr.mathis.mm.utils.enums;

import fr.mathis.api.message.Color;

public enum Lang {

    MAINTENANCE_ENABLED(Color.RED + "La maintenance est activé."),
    MAINTENANCE_DISABLED(Color.RED + "La maintenance est désactivé."),

    PLAYER_MAINTENANCE_KICK(Color.RED + "Le serveur est en phase de maintenance."),
    MAINTENANCE_COMMAND_INVALID(Color.RED + "Commande de maintenance incconu! (/maintenance help).");

    private final String lang;

    public String getLang() {
        return this.lang;
    }

    Lang(String txt) {
        this.lang = txt;
    }

}
