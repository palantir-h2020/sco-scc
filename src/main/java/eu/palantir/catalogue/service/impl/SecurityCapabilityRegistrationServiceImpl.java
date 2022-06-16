package eu.palantir.catalogue.service.impl;

import eu.palantir.catalogue.dto.SecurityCapabilityOnboardingDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.mappers.SecurityCapabilityMapper;
import eu.palantir.catalogue.model.SecurityCapabilityStatus;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class SecurityCapabilityRegistrationServiceImpl implements SecurityCapabilityRegistrationService {
    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityRegistrationServiceImpl.class);

    private final SecurityCapabilityRepository securityCapabilityRepository;

    private final SecurityCapabilityMapper securityCapabilityMapper;

    @Inject
    public SecurityCapabilityRegistrationServiceImpl(SecurityCapabilityRepository securityCapabilityRepository,
            SecurityCapabilityMapper securityCapabilityMapper) {
        this.securityCapabilityRepository = securityCapabilityRepository;
        this.securityCapabilityMapper = securityCapabilityMapper;
    }

    @Override
    public SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto) {
        return this.register(registrationDto,
                new SecurityCapabilityOnboardingDto(registrationDto.getXnfId(),
                        registrationDto.getNsId()));
    }

    @Override
    public SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto,
            SecurityCapabilityOnboardingDto onboardingDto) {
        final var securityCapability = securityCapabilityMapper.toSecurityCapability(registrationDto);

        final var uuid = UUID.randomUUID();
        securityCapability.setId(uuid);
        var registeredStatus = SecurityCapabilityStatus.REGISTERED;

        String xnfId = null;
        String nsId = null;

        // If registration in SCC is done AFTER onboarding
        if (onboardingDto.isOnboarded()) {
            xnfId = onboardingDto.getXnfId();
            nsId = onboardingDto.getNsId();
            // CHANGE: still unclear if this data point will refer to the same xNF ID !
            securityCapability.getVnf().setId(UUID.fromString(onboardingDto.getXnfId()));
            registeredStatus = SecurityCapabilityStatus.ONBOARDED;
        }

        securityCapability.setStatus(registeredStatus);
        securityCapability.setNsId(nsId);
        securityCapability.setXnfId(xnfId);

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
