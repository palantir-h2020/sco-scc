package eu.palantir.catalogue.service.impl;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;

@ApplicationScoped
public class SecurityCapabilityRegistrationServiceImpl implements SecurityCapabilityRegistrationService {

    @Override
    public UUID registerSC(SecurityCapabilityRegistrationDto registrationDto) {
        // CHANGE: Implement during DB integration
        // UUID uuid = UUID.randomUUID();
        // Mock-only.
        return UUID.fromString("fc83e9a0-2ed5-4c23-b6da-62513953233b");
    }

    @Override
    public Boolean updateSC(SecurityCapabilityRegistrationDto registrationDto) {
        // CHANGE: Implement during DB integration
        return true;
    }

}
