package eu.palantir.catalogue.dto;

import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityCapabilityRegistrationInfoDto {
    private final UUID id;
    private final SecurityCapabilityStatus status;
    private String xnfId;
    private String nsId;
    private String onboardingJobId;

    public SecurityCapabilityRegistrationInfoDto(UUID id, SecurityCapabilityStatus status) {
        this.id = id;
        this.status = status;
    }

    public SecurityCapabilityRegistrationInfoDto(UUID id, SecurityCapabilityStatus status, String xnfId, String nsId) {
        this.id = id;
        this.status = status;
        this.xnfId = xnfId;
        this.nsId = nsId;
    }

    public SecurityCapabilityRegistrationInfoDto(UUID id, SecurityCapabilityStatus status, String onboardingJobId) {
        this.id = id;
        this.status = status;
        this.onboardingJobId = onboardingJobId;
    }

    public UUID getId() {
        return id;
    }

    public SecurityCapabilityStatus getStatus() {
        return status;
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

    public String getOnboardingJobId() {
        return this.onboardingJobId;
    }

    public void setOnboardingJobId(String onboardingJobId) {
        this.onboardingJobId = onboardingJobId;
    }

}
