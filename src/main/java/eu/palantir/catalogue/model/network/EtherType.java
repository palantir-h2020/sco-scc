package eu.palantir.catalogue.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EtherType {

    @JsonProperty("ipv4")
    IP_V4 {
        // overriding toString() for SMALL
        public String toString() {
            return "ipv4";
        }
    },

    @JsonProperty("ipv6")
    IP_V6 {
        public String toString() {
            return "ipv6";
        }
    },

}
