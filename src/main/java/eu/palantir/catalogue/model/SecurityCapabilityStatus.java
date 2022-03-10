package eu.palantir.catalogue.model;

public enum SecurityCapabilityStatus {
    REGISTERED,
    ONBOARDED;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
