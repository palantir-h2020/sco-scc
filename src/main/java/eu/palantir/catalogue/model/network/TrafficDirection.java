package eu.palantir.catalogue.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrafficDirection {

    @JsonProperty("ingress")
    INGRESS {
        // overriding toString() for SMALL
        public String toString() {
            return "ingress";
        }
    },

    @JsonProperty("egress")
    EGRESS {
        public String toString() {
            return "egress";
        }
    },

}
