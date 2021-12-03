package eu.palantir.catalogue.model.network;

public enum EtherType {

    IP_V4 {
        // overriding toString() for SMALL
        public String toString() {
            return "ipv4";
        }
    },

    IP_V6 {
        public String toString() {
            return "ipv6";
        }
    },

}
