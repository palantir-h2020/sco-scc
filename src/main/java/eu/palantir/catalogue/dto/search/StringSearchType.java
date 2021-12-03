package eu.palantir.catalogue.dto.search;

public enum StringSearchType {

    EXACT {
        public String toString() {
            return "exact";
        }
    },

    CONTAINS {
        public String toString() {
            return "contains";
        }
    },

    REGEX {
        public String toString() {
            return "regex";
        }
    },

}
