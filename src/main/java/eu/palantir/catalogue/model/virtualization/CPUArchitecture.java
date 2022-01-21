package eu.palantir.catalogue.model.virtualization;

public enum CPUArchitecture {
    X86 {
        public String toString() {
            return "x86";
        }
    },
    X86_64 {
        public String toString() {
            return "x86-64";
        }
    },
    ARM {
        public String toString() {
            return "ARM";
        }
    },
    ARM_64 {
        // When 64-bit ARM variant is required e.g. ARMv8 (non -R) and higher.
        public String toString() {
            return "ARM-64";
        }
    },
}
