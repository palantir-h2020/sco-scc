package eu.palantir.catalogue.dto;

import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import java.util.UUID;

public class SecurityCapabilityRegistrationInfoDto {
    private final UUID id;
    private final SecurityCapabilityStatus status;

    public SecurityCapabilityRegistrationInfoDto(UUID id, SecurityCapabilityStatus status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public SecurityCapabilityStatus getStatus() {
        return status;
    }
}
