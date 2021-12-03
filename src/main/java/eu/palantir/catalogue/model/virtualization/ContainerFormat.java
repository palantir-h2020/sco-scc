package eu.palantir.catalogue.model.virtualization;

public enum ContainerFormat {

    AKI {
        public String toString() {
            return "aki";
        }
    },

    AMI {
        public String toString() {
            return "ami";
        }
    },

    ARI {
        public String toString() {
            return "ari";
        }
    },

    BARE {
        public String toString() {
            return "bare";
        }
    },

    DOCKER {
        public String toString() {
            return "docker";
        }
    },

    OVA {
        public String toString() {
            return "ova";
        }
    },

    OVF {
        public String toString() {
            return "ovf";
        }
    }
}
