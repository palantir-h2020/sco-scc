package eu.palantir.catalogue.service;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.SecurityCapabilityOnboardingDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;

public interface SecurityCapabilityRegistrationService {

    // Simply Registration
    SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto);

    // Registration after onboarding
    SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto,
            SecurityCapabilityOnboardingDto onboardingDto);

    // true if update is possible
    Boolean updateSC(SecurityCapabilityRegistrationRequestDto registrationDto);

}
