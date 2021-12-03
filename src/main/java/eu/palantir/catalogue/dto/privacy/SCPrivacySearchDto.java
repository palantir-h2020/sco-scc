package eu.palantir.catalogue.dto.privacy;

import java.util.Objects;

public class SCPrivacySearchDto {
    // ADD: The aggreed-upon privacy descriptors

    // All following are mock-only for now.
    private final Boolean sharesData;

    private final Boolean storesData;

    private final Boolean processesData;

    public SCPrivacySearchDto(Boolean sharesData, Boolean storesData, Boolean processesData) {
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

    public Boolean isStoresData() {
        return this.storesData;
    }

    public Boolean getStoresData() {
        return this.storesData;
    }

    public Boolean isProcessesData() {
        return this.processesData;
    }

    public Boolean getProcessesData() {
        return this.processesData;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCPrivacySearchDto)) {
            return false;
        }
        SCPrivacySearchDto sCPrivacySearchDto = (SCPrivacySearchDto) o;
        return Objects.equals(sharesData, sCPrivacySearchDto.sharesData)
                && Objects.equals(storesData, sCPrivacySearchDto.storesData)
                && Objects.equals(processesData, sCPrivacySearchDto.processesData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharesData, storesData, processesData);
    }

}
