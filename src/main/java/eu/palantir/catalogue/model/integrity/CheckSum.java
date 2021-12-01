package eu.palantir.catalogue.model.integrity;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class CheckSum {

    @NotBlank
    private final String algorithm;

    @NotBlank
    private final String hash;

    public CheckSum(String algorithm, String hash) {
        this.algorithm = algorithm;
        this.hash = hash;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getHash() {
        return this.hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CheckSum)) {
            return false;
        }
        CheckSum checkSum = (CheckSum) o;
        return Objects.equals(algorithm, checkSum.algorithm) && Objects.equals(hash, checkSum.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, hash);
    }

}
