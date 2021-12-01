package eu.palantir.catalogue.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BillingModelType {

    // Allowed billing models

    @JsonProperty("subscription")
    SUBSCRIPTION {
        // overriding toString() for SMALL
        public String toString() {
            return "subscription";
        }
    },

    @JsonProperty("instance")
    INSTANCE {
        public String toString() {
            return "instance";
        }
    },

    @JsonProperty("hourly")
    HOURLY {
        public String toString() {
            return "hourly";
        }
    },

}
