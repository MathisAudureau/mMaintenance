package fr.mathis.api.utils.enums;

public enum Info {

    PLUGIN_IS_ENABLE("%pl_name% est active."),
    PLUGIN_IS_LOAD("%pl_name% charge..."),
    PLUGIN_IS_DISABLE("%pl_name% est désactive.");

    private final String value;

    public String getValue() {
        return this.value;
    }

    Info(String value) {
        this.value = value;
    }
}
