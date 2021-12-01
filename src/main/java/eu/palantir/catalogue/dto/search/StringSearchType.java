package eu.palantir.catalogue.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StringSearchType {

    @JsonProperty("exact")
    EXACT {
        public String toString() {
            return "exact";
        }
    },

    @JsonProperty("contains")
    CONTAINS {
        public String toString() {
            return "contains";
        }
    },

    @JsonProperty("regex")
    REGEX {
        public String toString() {
            return "regex";
        }
    },

}
