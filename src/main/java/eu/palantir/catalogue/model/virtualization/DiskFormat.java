package eu.palantir.catalogue.model.virtualization;

public enum DiskFormat {

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

    ISO {
        public String toString() {
            return "iso";
        }
    },

    QCOW2 {
        public String toString() {
            return "qcow2";
        }
    },

    RAW {
        public String toString() {
            return "raw";
        }
    },

    VDI {
        public String toString() {
            return "vdi";
        }
    },

    VHD {
        public String toString() {
            return "vhd";
        }
    },

    VHDX {
        public String toString() {
            return "vhdx";
        }
    },

    VMDK {
        public String toString() {
            return "vmdk";
        }
    }

}
