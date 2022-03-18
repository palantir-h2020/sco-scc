package eu.palantir.catalogue.dto;

import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.dto.integrity.SCIntegrityDto;
import eu.palantir.catalogue.dto.privacy.SCPrivacyDto;
import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.dto.vnf.VnfDescriptorsDto;

public class SecurityCapabilityDetailsDto {

    @NotNull
    private final UUID id;

    private String xnfId;

    private String nsId;

    @NotNull
    private final SecurityCapabilityStatus status;

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

    public SecurityCapabilityDetailsDto(UUID id, String xnfId, String nsId, SecurityCapabilityStatus status,
            VnfDescriptorsDto vnf, SCSecurityDto security, SCBillingSLADto billingSLA, SCIntegrityDto integrity,
            SCPrivacyDto privacy) {
        this.id = id;
        this.xnfId = xnfId;
        this.nsId = nsId;
        this.status = status;
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.integrity = integrity;
        this.privacy = privacy;
    }

    public UUID getId() {
        return this.id;
    }

    public String getXnfId() {
        return this.xnfId;
    }

    public String getNsId() {
        return this.nsId;
    }

    public void setXnfId(String xnfId) {
        this.xnfId = xnfId;
    }

    public void setNsId(String nsId) {
        this.nsId = nsId;
    }

    public SecurityCapabilityStatus getStatus() {
        return this.status;
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
        return Objects.equals(id, securityCapabilityDetailsDto.id)
                && Objects.equals(xnfId, securityCapabilityDetailsDto.xnfId)
                && Objects.equals(nsId, securityCapabilityDetailsDto.nsId)
                && Objects.equals(status, securityCapabilityDetailsDto.status)
                && Objects.equals(vnf, securityCapabilityDetailsDto.vnf)
                && Objects.equals(security, securityCapabilityDetailsDto.security)
                && Objects.equals(billingSLA, securityCapabilityDetailsDto.billingSLA)
                && Objects.equals(integrity, securityCapabilityDetailsDto.integrity)
                && Objects.equals(privacy, securityCapabilityDetailsDto.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xnfId, nsId, status, vnf, security, billingSLA, integrity, privacy);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", xnfId='" + getXnfId() + "'" +
                ", nsId='" + getNsId() + "'" +
                ", status='" + getStatus() + "'" +
                ", vnf='" + getVnf() + "'" +
                ", security='" + getSecurity() + "'" +
                ", billingSLA='" + getBillingSLA() + "'" +
                ", integrity='" + getIntegrity() + "'" +
                ", privacy='" + getPrivacy() + "'" +
                "}";
    }

}
