package eu.palantir.catalogue.model.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PalantirDeploymentModel {

    @JsonProperty("cloud")
    CLOUD {
        public String toString() {
            return "cloud";
        }
    },

    @JsonProperty("mec")
    MEC {
        public String toString() {
            return "mec";
        }
    },

    @JsonProperty("vcpe")
    VCPE {
        public String toString() {
            return "vcpe";
        }
    },

}
