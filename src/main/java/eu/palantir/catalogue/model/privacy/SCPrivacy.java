package eu.palantir.catalogue.model.privacy;

import java.util.Objects;

import javax.persistence.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Entity
public class SCPrivacy extends PanacheMongoEntityBase {
    // ADD: The aggreed-upon privacy descriptors

    // All following are mock-only for now.
    private Boolean sharesData;

    private Boolean storesData;

    private Boolean processesData;

    public SCPrivacy() {
    }

    public SCPrivacy(Boolean sharesData, Boolean storesData, Boolean processesData) {
        this.sharesData = sharesData;
        this.storesData = storesData;
        this.processesData = processesData;
    }

    public Boolean isSharesData() {
        return this.sharesData;
    }

    public Boolean getSharesData() {
        return this.sharesData;
    }

    public void setSharesData(Boolean sharesData) {
        this.sharesData = sharesData;
    }

    public Boolean isStoresData() {
        return this.storesData;
    }

    public Boolean getStoresData() {
        return this.storesData;
    }

    public void setStoresData(Boolean storesData) {
        this.storesData = storesData;
    }

    public Boolean isProcessesData() {
        return this.processesData;
    }

    public Boolean getProcessesData() {
        return this.processesData;
    }

    public void setProcessesData(Boolean processesData) {
        this.processesData = processesData;
    }

    public SCPrivacy sharesData(Boolean sharesData) {
        setSharesData(sharesData);
        return this;
    }

    public SCPrivacy storesData(Boolean storesData) {
        setStoresData(storesData);
        return this;
    }

    public SCPrivacy processesData(Boolean processesData) {
        setProcessesData(processesData);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCPrivacy)) {
            return false;
        }
        SCPrivacy sCPrivacy = (SCPrivacy) o;
        return Objects.equals(sharesData, sCPrivacy.sharesData) && Objects.equals(storesData, sCPrivacy.storesData)
                && Objects.equals(processesData, sCPrivacy.processesData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharesData, storesData, processesData);
    }

    @Override
    public String toString() {
        return "{" +
                " sharesData='" + isSharesData() + "'" +
                ", storesData='" + isStoresData() + "'" +
                ", processesData='" + isProcessesData() + "'" +
                "}";
    }

}
