package eu.palantir.catalogue.dto.integrity;

import java.util.Objects;

public class SCIntegrityDto {
    // ADD: The aggreed-upon integrity descriptors

    // Mock only
    private final String scHash;

    // Mock only
    public SCIntegrityDto(String scHash) {
        this.scHash = scHash;
    }

    public String getScHash() {
        return this.scHash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCIntegrityDto)) {
            return false;
        }
        SCIntegrityDto sCIntegrityDto = (SCIntegrityDto) o;
        return Objects.equals(scHash, sCIntegrityDto.scHash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(scHash);
    }

}
