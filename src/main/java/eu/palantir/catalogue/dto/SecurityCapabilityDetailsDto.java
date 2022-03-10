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

    public SecurityCapabilityDetailsDto(UUID id, SecurityCapabilityStatus status,
            VnfDescriptorsDto vnf, SCSecurityDto security,
            SCBillingSLADto billingSLA, SCIntegrityDto integrity, SCPrivacyDto privacy) {
        this.id = id;
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

    public SecurityCapabilityStatus getStatus() {
        return status;
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
}
