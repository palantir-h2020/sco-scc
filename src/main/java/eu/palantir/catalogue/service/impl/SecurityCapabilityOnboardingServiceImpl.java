package eu.palantir.catalogue.service.impl;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;
import org.jboss.logging.Logger;

import eu.palantir.catalogue.client.SecurityOrchestratorClient;
import eu.palantir.catalogue.dto.SecurityCapabilityOnboardingDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationFormDto;
import eu.palantir.catalogue.dto.orchestrator.IdDto;
import eu.palantir.catalogue.dto.orchestrator.PackageFormDto;
import eu.palantir.catalogue.model.SecurityCapability;
import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import eu.palantir.catalogue.model.job.JobStatus;
import eu.palantir.catalogue.model.job.OnboardingJob;
import eu.palantir.catalogue.repository.OnboardingJobRepository;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityOnboardingService;

// CHANGE: Add a scheduled job to remove onboarding jobs that are older than a week old, every end of day.

@ApplicationScoped
public class SecurityCapabilityOnboardingServiceImpl implements SecurityCapabilityOnboardingService {

    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityOnboardingServiceImpl.class);

    @RestClient
    @Inject
    private final SecurityOrchestratorClient securityOrchestratorClient;
    private final SecurityCapabilityRepository securityCapabilityRepository;
    private final OnboardingJobRepository onboardingJobRepository;

    @Inject
    public SecurityCapabilityOnboardingServiceImpl(@RestClient SecurityOrchestratorClient securityOrchestratorClient,
            SecurityCapabilityRepository securityCapabilityRepository,
            OnboardingJobRepository onboardingJobRepository) {
        this.securityOrchestratorClient = securityOrchestratorClient;
        this.securityCapabilityRepository = securityCapabilityRepository;
        this.onboardingJobRepository = onboardingJobRepository;
    }

    @Override
    public SecurityCapabilityOnboardingDto onboardSC(SecurityCapabilityRegistrationFormDto registrationForm,
            UUID scId, String onboardingTaskId) {

        LOGGER.infof("Submitting onboarding task %s", onboardingTaskId);
        OnboardingJob onboardingJob = new OnboardingJob(onboardingTaskId, JobStatus.ONGOING);
        onboardingJobRepository.persist(onboardingJob);

        LOGGER.infof("Retrieving security capability by id '%s'", scId);
        final var retrievedSC = securityCapabilityRepository.findByIdOptional(scId);

        if (retrievedSC.isEmpty()) {
            LOGGER.infof("Security capability with id '%s' was not found", scId);
            registrationForm.closeStreams();
            onboardingJob.setJobStatus(JobStatus.ERROR);
            onboardingJobRepository.update(onboardingJob);
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
            LOGGER.infof("Retrieved xNF data from orchestrator %s", xnfIdDto);
            onboardingDto.setXnfId(xnfIdDto.getId().toString());

            nsIdDto = securityOrchestratorClient.onboardNs(new PackageFormDto(registrationForm.getNSPackage()));
            LOGGER.infof("Retrieved NS data from orchestrator %s", nsIdDto);
            onboardingDto.setNsId(nsIdDto.getId().toString());
        } catch (ResteasyWebApplicationException ex) {
            LOGGER.errorf("Could not onboard packages on Orchestrator, with ERROR: %s", ex);
            ex.printStackTrace();
            registrationForm.closeStreams();
            onboardingJob.setJobStatus(JobStatus.ERROR);
            onboardingJobRepository.update(onboardingJob);
            return onboardingDto;
        }

        if (onboardingDto.isOnboarded()) {
            LOGGER.infof("Successfully onboarded SC with ID %s, xNF ID %s and NS ID %s on Security Orchestrator", scId,
                    onboardingDto.getXnfId(), onboardingDto.getNsId());

            // Update the corresponding SC
            securityCapability.setStatus(SecurityCapabilityStatus.ONBOARDED);
            securityCapability.setNsId(onboardingDto.getNsId());
            securityCapability.setXnfId(onboardingDto.getXnfId());
            securityCapabilityRepository.update(securityCapability);
            LOGGER.infof("Successfully updated SC with ID %s after onboarding", scId);
        }

        registrationForm.closeStreams();
        onboardingJob.setJobStatus(JobStatus.FINISHED);
        onboardingJobRepository.update(onboardingJob);
        return onboardingDto;
    }

}
