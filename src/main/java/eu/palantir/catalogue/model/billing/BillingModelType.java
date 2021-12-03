package eu.palantir.catalogue.model.billing;

public enum BillingModelType {

    // Allowed billing models

    SUBSCRIPTION {
        public String toString() {
            return "subscription";
        }
    },

    INSTANCE {
        public String toString() {
            return "instance";
        }
    },

    HOURLY {
        public String toString() {
            return "hourly";
        }
    },

}
