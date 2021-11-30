package eu.palantir.catalogue.auth;

public enum ClientType {

    // The only allowed client types for the catalogue.

    PALANTIR_COMPONENT {
        // overriding toString() for SMALL
        public String toString() {
            return "palantir_component";
        }
    },

    SC_DEVELOPER {
        public String toString() {
            return "sc_developer";
        }
    }

}
