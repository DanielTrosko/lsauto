package it.danieltrosko.lsauto.model.entites;

public enum RepairStatus {
    ACCEPTED("PRZYJETY"),
    REPAIR("NAPRAWIANY"),
    TO_RECEIVE("DO ODBIORU");

    private final String name;

    RepairStatus(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }
}
