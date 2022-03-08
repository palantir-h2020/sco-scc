package eu.palantir.catalogue.dto;

import java.util.UUID;

public class SecurityCapabilityRegistrationInfoDto {
    private final UUID id;

    public SecurityCapabilityRegistrationInfoDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
