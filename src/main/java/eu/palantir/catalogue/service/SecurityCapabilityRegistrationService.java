package eu.palantir.catalogue.service;

import java.util.UUID;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;

public interface SecurityCapabilityRegistrationService {

    UUID registerSC(SecurityCapabilityRegistrationDto registrationDto);

    // true if update is possible
    Boolean updateSC(SecurityCapabilityRegistrationDto registrationDto);

}
