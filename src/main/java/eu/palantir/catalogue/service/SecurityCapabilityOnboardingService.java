package eu.palantir.catalogue.service;

import java.util.UUID;

import eu.palantir.catalogue.dto.SecurityCapabilityOnboardingDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationFormDto;

public interface SecurityCapabilityOnboardingService {

    // Onboarding to SO through SCC is done only AFTER the SC is registered!
    // NOTE: Implementation HAS TO close the streams in registrationForm
    SecurityCapabilityOnboardingDto onboardSC(SecurityCapabilityRegistrationFormDto registrationForm, UUID scId);

}
