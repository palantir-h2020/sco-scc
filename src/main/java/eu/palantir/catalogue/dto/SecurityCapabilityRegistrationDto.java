package eu.palantir.catalogue.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.dto.privacy.SCPrivacyDto;
import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.dto.vnf.VnfRegistrationDto;

public class SecurityCapabilityRegistrationDto {

    @NotNull
    private final VnfRegistrationDto vnf;

    @NotNull
    private final SCSecurityDto security;

    @NotNull
    private final SCBillingSLADto billingSLA;

    // CHANGE: Aggree on what futher integrity descriptors may be passed.

    // @NotNull // CHANGE: Enforce it if needed, when privacy descriptors are
    // agreed.
    private final SCPrivacyDto privacy;

    public SecurityCapabilityRegistrationDto(VnfRegistrationDto vnf, SCSecurityDto security, SCBillingSLADto billingSLA,
            SCPrivacyDto privacy) {
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.privacy = privacy;
    }

    public VnfRegistrationDto getVnf() {
        return this.vnf;
    }

    public SCSecurityDto getSecurity() {
        return this.security;
    }

    public SCBillingSLADto getBillingSLA() {
        return this.billingSLA;
    }

    public SCPrivacyDto getPrivacy() {
        return this.privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilityRegistrationDto)) {
            return false;
        }
        SecurityCapabilityRegistrationDto securityCapabilityRegistrationDto = (SecurityCapabilityRegistrationDto) o;
        return Objects.equals(vnf, securityCapabilityRegistrationDto.vnf)
                && Objects.equals(security, securityCapabilityRegistrationDto.security)
                && Objects.equals(billingSLA, securityCapabilityRegistrationDto.billingSLA)
                && Objects.equals(privacy, securityCapabilityRegistrationDto.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vnf, security, billingSLA, privacy);
    }

}
