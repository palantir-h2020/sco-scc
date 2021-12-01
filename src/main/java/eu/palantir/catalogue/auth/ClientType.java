package eu.palantir.catalogue.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClientType {

    // The only allowed client types for the catalogue.

    @JsonProperty("palantir_component")
    PALANTIR_COMPONENT {
        // overriding toString() for SMALL
        public String toString() {
            return "palantir_component";
        }
    },

    @JsonProperty("sc_developer")
    SC_DEVELOPER {
        public String toString() {
            return "sc_developer";
        }
    }

}
