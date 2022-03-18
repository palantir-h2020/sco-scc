package eu.palantir.catalogue.service.impl;

import eu.palantir.catalogue.client.SecurityOrchestratorClient;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.mappers.SecurityCapabilityMapper;
import eu.palantir.catalogue.dto.orchestrator.IdDto;
import eu.palantir.catalogue.dto.orchestrator.PackageFormDto;
import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;
import liquibase.pro.packaged.ex;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class SecurityCapabilityRegistrationServiceImpl implements SecurityCapabilityRegistrationService {
    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityRegistrationServiceImpl.class);

    private final SecurityCapabilityMapper securityCapabilityMapper;
    private final SecurityCapabilityRepository securityCapabilityRepository;

    private final SecurityOrchestratorClient securityOrchestratorClient;

    @Inject
    public SecurityCapabilityRegistrationServiceImpl(SecurityCapabilityMapper securityCapabilityMapper,
            SecurityCapabilityRepository securityCapabilityRepository,
            @RestClient SecurityOrchestratorClient securityOrchestratorClient) {
        this.securityCapabilityMapper = securityCapabilityMapper;
        this.securityCapabilityRepository = securityCapabilityRepository;
        this.securityOrchestratorClient = securityOrchestratorClient;
    }

    @Override
    public SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto) {
        final var securityCapability = securityCapabilityMapper.toSecurityCapability(registrationDto);

        final var uuid = UUID.randomUUID();
        securityCapability.setId(uuid);
        var registeredStatus = SecurityCapabilityStatus.REGISTERED;
        securityCapability.setStatus(registeredStatus);
        LOGGER.infof("Registering %s", securityCapability);

        String xnfId = "";
        String nsId = "";

        // If already IDs are provided, do not contact the SO
        if ((securityCapability.getNsId() == null || securityCapability
                .getNsId().equals(""))
                || (securityCapability.getXnfId() == null || securityCapability.getXnfId().equals(""))) {

            try {
                IdDto xnfIdDto = securityOrchestratorClient.onboardXnf(new PackageFormDto(""));

                IdDto nsIdDto = securityOrchestratorClient.onboardNs(new PackageFormDto(""));

                if (xnfIdDto != null && nsIdDto != null) {
                    registeredStatus = SecurityCapabilityStatus.ONBOARDED;
                    securityCapability.setStatus(registeredStatus);
                    xnfId = xnfIdDto.getId().toString();
                    nsId = nsIdDto.getId().toString();
                }

                securityCapability.setXnfId(xnfId);
                securityCapability.getVnf().setId(UUID.fromString(xnfId));
                securityCapability.setNsId(nsId);
            } catch (Exception ex) {
                LOGGER.errorf("Could not onboard packages on Orchestrator, with error: %s", ex);
            }
        } else {
            xnfId = securityCapability.getXnfId();
            securityCapability.getVnf().setId(UUID.fromString(xnfId));
            nsId = securityCapability.getNsId();
            registeredStatus = SecurityCapabilityStatus.ONBOARDED;
            securityCapability.setStatus(registeredStatus);
        }

        LOGGER.infof("Prepared security capability %s for storage.", securityCapability);

        securityCapabilityRepository.persist(securityCapability);
        LOGGER.infof("Persisted security capability with id: %s", securityCapability.getId());

        SecurityCapabilityRegistrationInfoDto securityCapabilityRegistrationInfoDto = new SecurityCapabilityRegistrationInfoDto(
                uuid, registeredStatus, xnfId, nsId);

        return securityCapabilityRegistrationInfoDto;
    }

    @Override
    public Boolean updateSC(SecurityCapabilityRegistrationRequestDto registrationDto) {
        // CHANGE: Implement during DB integration
        return true;
    }

}
