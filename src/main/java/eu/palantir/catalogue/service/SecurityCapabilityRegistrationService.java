package eu.palantir.catalogue.service;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;

public interface SecurityCapabilityRegistrationService {

    SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto);

    // true if update is possible
    Boolean updateSC(SecurityCapabilityRegistrationRequestDto registrationDto);

}
