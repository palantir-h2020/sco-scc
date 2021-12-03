package eu.palantir.catalogue.model.network;

public enum TransportProtocol {

    TCP {
        // overriding toString() for SMALL
        public String toString() {
            return "tcp";
        }
    },

    UDP {
        public String toString() {
            return "udp";
        }
    },

    ICMP {
        public String toString() {
            return "icmp";
        }
    }

}
