package eu.palantir.catalogue.model.virtualization;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ContainerFormat {

    @JsonProperty("aki")
    AKI {
        public String toString() {
            return "aki";
        }
    },

    @JsonProperty("ami")
    AMI {
        public String toString() {
            return "ami";
        }
    },

    @JsonProperty("ari")
    ARI {
        public String toString() {
            return "ari";
        }
    },

    @JsonProperty("bare")
    BARE {
        public String toString() {
            return "bare";
        }
    },

    @JsonProperty("docker")
    DOCKER {
        public String toString() {
            return "docker";
        }
    },

    @JsonProperty("ova")
    OVA {
        public String toString() {
            return "ova";
        }
    },

    @JsonProperty("ovf")
    OVF {
        public String toString() {
            return "ovf";
        }
    }
}
