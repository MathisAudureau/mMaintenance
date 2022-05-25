package fr.mathis.api.utils.enums;

public enum Perm {

    NO_PERMISSION("Vous n'avez pas la permission nécéssaire."),
    LOW_POSITION("Impossible sur une personne ayant plus de permissions que vous."),
    CONSOLE_RETURN("Vous ne pouvez pas faire cette commande depuis la console.");

    private final String error;

    public String getError() {
        return this.error;
    }

    Perm(String error) {
        this.error = error;
    }
}
