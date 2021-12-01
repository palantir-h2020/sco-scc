package eu.palantir.catalogue.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransportProtocol {

    @JsonProperty("tcp")
    TCP {
        // overriding toString() for SMALL
        public String toString() {
            return "tcp";
        }
    },

    @JsonProperty("udp")
    UDP {
        public String toString() {
            return "udp";
        }
    },

    @JsonProperty("icmp")
    ICMP {
        public String toString() {
            return "icmp";
        }
    }

}
