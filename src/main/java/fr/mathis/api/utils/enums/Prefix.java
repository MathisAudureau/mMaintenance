package fr.mathis.api.utils.enums;

import fr.mathis.api.message.Color;
import fr.mathis.api.message.Decoration;

public enum Prefix {

    DEFAULT(Color.GOLD + Decoration.BOLD + "KenaliaMC" + Color.GRAY + Decoration.BOLD + " > "),
    ERROR(Color.DARK_RED + Decoration.BOLD + "Erreur" + Color.GRAY + Decoration.BOLD + " > ");

    private final String value;

    public String getValue() {
        return this.value;
    }

    Prefix(String value) {
        this.value = value;
    }
}
