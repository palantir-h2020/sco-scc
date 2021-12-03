package eu.palantir.catalogue.model.network;

public enum TrafficDirection {

    INGRESS {
        // overriding toString() for SMALL
        public String toString() {
            return "ingress";
        }
    },

    EGRESS {
        public String toString() {
            return "egress";
        }
    },

}
