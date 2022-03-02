package eu.palantir.catalogue.model.integrity;

import java.util.Objects;

import javax.persistence.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Entity
public class SCIntegrity extends PanacheMongoEntityBase {
    // ADD: The aggreed-upon integrity descriptors

    // Mock only
    private String scHash;

    public SCIntegrity() {
    }

    // Mock only
    public SCIntegrity(String scHash) {
        this.scHash = scHash;
    }

    public String getScHash() {
        return this.scHash;
    }

    public void setScHash(String scHash) {
        this.scHash = scHash;
    }

    public SCIntegrity scHash(String scHash) {
        setScHash(scHash);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCIntegrity)) {
            return false;
        }
        SCIntegrity sCIntegrity = (SCIntegrity) o;
        return Objects.equals(scHash, sCIntegrity.scHash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(scHash);
    }

    @Override
    public String toString() {
        return "{" +
                " scHash='" + getScHash() + "'" +
                "}";
    }

}
