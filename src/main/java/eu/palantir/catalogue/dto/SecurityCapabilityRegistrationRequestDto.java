package eu.palantir.catalogue.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.dto.vnf.VnfRegistrationDto;

public class SecurityCapabilityRegistrationRequestDto {

    @NotNull
    private final VnfRegistrationDto vnf;

    @NotNull
    private final SCSecurityDto security;

    @NotNull
    private final SCBillingSLADto billingSLA;

    public SecurityCapabilityRegistrationRequestDto(VnfRegistrationDto vnf, SCSecurityDto security, SCBillingSLADto billingSLA) {
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilityRegistrationRequestDto)) {
            return false;
        }
        SecurityCapabilityRegistrationRequestDto securityCapabilityRegistrationRequestDto = (SecurityCapabilityRegistrationRequestDto) o;
        return Objects.equals(vnf, securityCapabilityRegistrationRequestDto.vnf)
                && Objects.equals(security, securityCapabilityRegistrationRequestDto.security)
                && Objects.equals(billingSLA, securityCapabilityRegistrationRequestDto.billingSLA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vnf, security, billingSLA);
    }

}
