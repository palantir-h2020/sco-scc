package eu.palantir.catalogue.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.dto.integrity.SCIntegrityDto;
import eu.palantir.catalogue.dto.privacy.SCPrivacyDto;
import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.dto.vnf.VnfDescriptorsDto;

public class SecurityCapabilityDetailsDto {

    @NotNull
    private final VnfDescriptorsDto vnf;

    @NotNull
    private final SCSecurityDto security;

    @NotNull
    private final SCBillingSLADto billingSLA;

    // @NotNull // CHANGE: Enforce it when integrity descriptors are agreed.
    private final SCIntegrityDto integrity;

    // @NotNull // CHANGE: Enforce it when privacy descriptors are agreed.
    private final SCPrivacyDto privacy;

    public SecurityCapabilityDetailsDto(VnfDescriptorsDto vnf, SCSecurityDto security, SCBillingSLADto billingSLA,
            SCIntegrityDto integrity, SCPrivacyDto privacy) {
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.integrity = integrity;
        this.privacy = privacy;
    }

    public VnfDescriptorsDto getVnf() {
        return this.vnf;
    }

    public SCSecurityDto getSecurity() {
        return this.security;
    }

    public SCBillingSLADto getBillingSLA() {
        return this.billingSLA;
    }

    public SCIntegrityDto getIntegrity() {
        return this.integrity;
    }

    public SCPrivacyDto getPrivacy() {
        return this.privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilityDetailsDto)) {
            return false;
        }
        SecurityCapabilityDetailsDto securityCapabilityDetailsDto = (SecurityCapabilityDetailsDto) o;
        return Objects.equals(vnf, securityCapabilityDetailsDto.vnf)
                && Objects.equals(security, securityCapabilityDetailsDto.security)
                && Objects.equals(billingSLA, securityCapabilityDetailsDto.billingSLA)
                && Objects.equals(integrity, securityCapabilityDetailsDto.integrity)
                && Objects.equals(privacy, securityCapabilityDetailsDto.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vnf, security, billingSLA, integrity, privacy);
    }

}
