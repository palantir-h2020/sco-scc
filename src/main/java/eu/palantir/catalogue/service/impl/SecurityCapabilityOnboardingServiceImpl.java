package eu.palantir.catalogue.service.impl;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import eu.palantir.catalogue.client.SecurityOrchestratorClient;
import eu.palantir.catalogue.dto.SecurityCapabilityOnboardingDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationFormDto;
import eu.palantir.catalogue.dto.orchestrator.IdDto;
import eu.palantir.catalogue.dto.orchestrator.PackageFormDto;
import eu.palantir.catalogue.model.SecurityCapability;
import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityOnboardingService;

@ApplicationScoped
// @RegisterForReflection // for when more info about job is required
public class SecurityCapabilityOnboardingServiceImpl implements SecurityCapabilityOnboardingService {

    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityOnboardingServiceImpl.class);

    private final SecurityOrchestratorClient securityOrchestratorClient;
    private final SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    public SecurityCapabilityOnboardingServiceImpl(@RestClient SecurityOrchestratorClient securityOrchestratorClient,
            SecurityCapabilityRepository securityCapabilityRepository) {
        this.securityOrchestratorClient = securityOrchestratorClient;
        this.securityCapabilityRepository = securityCapabilityRepository;
    }

    @Override
    public SecurityCapabilityOnboardingDto onboardSC(SecurityCapabilityRegistrationFormDto registrationForm,
            UUID scId) {
        LOGGER.infof("Retrieving security capability by id '%s'", scId);
        final var retrievedSC = securityCapabilityRepository.findByIdOptional(scId);

        if (retrievedSC.isEmpty()) {
            LOGGER.infof("Security capability with id '%s' was not found", scId);
            return new SecurityCapabilityOnboardingDto();
        }

        LOGGER.infof("Retrieved security capability %s, and WILL ONBOARD", retrievedSC.get());
        SecurityCapability securityCapability = retrievedSC.get();

        // CHANGE LATER: onboarding procedure according to model changes and packaging
        IdDto xnfIdDto = null;

        IdDto nsIdDto = null;

        SecurityCapabilityOnboardingDto onboardingDto = new SecurityCapabilityOnboardingDto();

        try {
            xnfIdDto = securityOrchestratorClient.onboardXnf(new PackageFormDto(registrationForm.getXNFPackage()));
            onboardingDto.setXnfId(xnfIdDto.getId().toString());

            nsIdDto = securityOrchestratorClient.onboardNs(new PackageFormDto(registrationForm.getNSPackage()));
            onboardingDto.setNsId(nsIdDto.getId().toString());
        } catch (Exception ex) {
            LOGGER.errorf("Could not onboard packages on Orchestrator, with error: %s", ex);
            return onboardingDto;
        }

        if (onboardingDto.isOnboarded()) {
            LOGGER.infof("Successfully onboarded SC with ID %s, xNF ID %s and NS ID %s on Security Orchestrator", scId,
                    onboardingDto.getXnfId(), onboardingDto.getNsId());

            // Update the corresponding SC
            securityCapability.setStatus(SecurityCapabilityStatus.ONBOARDED);
            securityCapability.setNsId(onboardingDto.getNsId());
            securityCapability.setXnfId(onboardingDto.getXnfId());
            securityCapabilityRepository.persist(securityCapability);
            LOGGER.infof("Successfully updated SC with ID %s after onboarding", scId);
        }

        return onboardingDto;
    }

}
