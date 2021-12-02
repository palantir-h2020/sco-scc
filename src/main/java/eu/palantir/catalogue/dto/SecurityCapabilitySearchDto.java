package eu.palantir.catalogue.dto;

import java.util.Objects;

import eu.palantir.catalogue.dto.billing.SCBillingSLASearchDto;
import eu.palantir.catalogue.dto.privacy.SCPrivacySearchDto;
import eu.palantir.catalogue.dto.security.SCSecuritySearchDto;
import eu.palantir.catalogue.dto.vnf.VnfSearchDto;

public class SecurityCapabilitySearchDto {

    private final VnfSearchDto vnf;

    private final SCSecuritySearchDto security;

    private final SCBillingSLASearchDto billingSLA;

    private final SCPrivacySearchDto privacy;

    public SecurityCapabilitySearchDto(VnfSearchDto vnf, SCSecuritySearchDto security, SCBillingSLASearchDto billingSLA,
            SCPrivacySearchDto privacy) {
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.privacy = privacy;
    }

    public VnfSearchDto getVnf() {
        return this.vnf;
    }

    public SCSecuritySearchDto getSecurity() {
        return this.security;
    }

    public SCBillingSLASearchDto getBillingSLA() {
        return this.billingSLA;
    }

    public SCPrivacySearchDto getPrivacy() {
        return this.privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilitySearchDto)) {
            return false;
        }
        SecurityCapabilitySearchDto securityCapabilitySearchDto = (SecurityCapabilitySearchDto) o;
        return Objects.equals(vnf, securityCapabilitySearchDto.vnf)
                && Objects.equals(security, securityCapabilitySearchDto.security)
                && Objects.equals(billingSLA, securityCapabilitySearchDto.billingSLA)
                && Objects.equals(privacy, securityCapabilitySearchDto.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vnf, security, billingSLA, privacy);
    }

}
