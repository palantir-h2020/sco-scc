package eu.palantir.catalogue.model.virtualization;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DiskFormat {

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

    @JsonProperty("iso")
    ISO {
        public String toString() {
            return "iso";
        }
    },

    @JsonProperty("qcow2")
    QCOW2 {
        public String toString() {
            return "qcow2";
        }
    },

    @JsonProperty("raw")
    RAW {
        public String toString() {
            return "raw";
        }
    },

    @JsonProperty("vdi")
    VDI {
        public String toString() {
            return "vdi";
        }
    },

    @JsonProperty("vhd")
    VHD {
        public String toString() {
            return "vhd";
        }
    },

    @JsonProperty("vhdx")
    VHDX {
        public String toString() {
            return "vhdx";
        }
    },

    @JsonProperty("vmdk")
    VMDK {
        public String toString() {
            return "vmdk";
        }
    }

}
