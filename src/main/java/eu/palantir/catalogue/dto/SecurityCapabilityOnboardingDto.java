package eu.palantir.catalogue.dto;

import java.util.Objects;

public class SecurityCapabilityOnboardingDto {

    private String xnfId;

    private String nsId;

    // true when onboarding is successfully done
    private boolean status;

    public SecurityCapabilityOnboardingDto() {
        this.xnfId = null;
        this.nsId = null;
        status = false;
    }

    public SecurityCapabilityOnboardingDto(String xnfId, String nsId) {
        this.xnfId = xnfId;
        this.nsId = nsId;
        status = this.isComplete();
    }

    public String getXnfId() {
        return this.xnfId;
    }

    public void setXnfId(String xnfId) {
        if (!xnfId.isEmpty()) {
            this.xnfId = xnfId;
            status = this.isComplete();
        } else {
            this.status = false;
        }
    }

    public String getNsId() {
        return this.nsId;
    }

    public void setNsId(String nsId) {
        if (!nsId.isEmpty()) {
            this.nsId = nsId;
            status = this.isComplete();
        } else {
            this.status = false;
        }
    }

    public boolean isOnboarded() {
        return this.status;
    }

    private boolean isComplete() {
        return !(this.xnfId == null || this.xnfId.isEmpty() || this.xnfId.isBlank())
                && !(this.nsId == null || this.nsId.isEmpty() || this.nsId.isBlank());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilityOnboardingDto)) {
            return false;
        }
        SecurityCapabilityOnboardingDto securityCapabilityOnboardingDto = (SecurityCapabilityOnboardingDto) o;
        return Objects.equals(xnfId, securityCapabilityOnboardingDto.xnfId)
                && Objects.equals(nsId, securityCapabilityOnboardingDto.nsId)
                && status == securityCapabilityOnboardingDto.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xnfId, nsId, status);
    }

}
