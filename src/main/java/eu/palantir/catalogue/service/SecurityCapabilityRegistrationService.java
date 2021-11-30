package eu.palantir.catalogue.service;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;

public interface SecurityCapabilityRegistrationService {

    void registerSC(SecurityCapabilityRegistrationDto registrationDto);

    // true if update is possible
    Boolean updateSC(SecurityCapabilityRegistrationDto registrationDto);

}
