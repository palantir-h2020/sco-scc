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

    // Manual registration of already-onboarded capability
    private String xnfId;

    private String nsId;

    public SecurityCapabilityRegistrationRequestDto(VnfRegistrationDto vnf, SCSecurityDto security,
            SCBillingSLADto billingSLA, String xnfId, String nsId) {
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.xnfId = xnfId;
        this.nsId = nsId;
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

    public String getXnfId() {
        return this.xnfId;
    }

    public void setXnfId(String xnfId) {
        this.xnfId = xnfId;
    }

    public String getNsId() {
        return this.nsId;
    }

    public void setNsId(String nsId) {
        this.nsId = nsId;
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
