package fr.mathis.mm.utils.enums;

import fr.mathis.api.message.Color;

public enum Lang {

    MAINTENANCE_ENABLED(Color.GREEN + "La maintenance est activé."),
    MAINTENANCE_DISABLED(Color.GREEN + "La maintenance est désactivé."),

    PLAYER_MAINTENANCE_KICK(Color.RED + "Le serveur rentre en maintenance. Retrouvez plus d'informations sur nos réseaux. Nous revenons au plus rapidement."),
    MAINTENANCE_COMMAND_INVALID(Color.RED + "Commande de maintenance incconu! (/maintenance help)."),
    USER_ADD(Color.GREEN + "Utilisateur ajouté à la withelist."),
    USER_REMOVE(Color.GREEN + "Utilisateur retiré de la withelist.");

    private final String lang;

    public String getLang() {
        return this.lang;
    }

    Lang(String txt) {
        this.lang = txt;
    }

}
