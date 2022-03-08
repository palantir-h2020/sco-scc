package eu.palantir.catalogue.service.impl;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.mappers.SecurityCapabilityMapper;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class SecurityCapabilityRegistrationServiceImpl implements SecurityCapabilityRegistrationService {
    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityRegistrationServiceImpl.class);

    private final SecurityCapabilityMapper securityCapabilityMapper;
    private final SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    public SecurityCapabilityRegistrationServiceImpl(SecurityCapabilityMapper securityCapabilityMapper,
            SecurityCapabilityRepository securityCapabilityRepository) {
        this.securityCapabilityMapper = securityCapabilityMapper;
        this.securityCapabilityRepository = securityCapabilityRepository;
    }

    @Override
    public SecurityCapabilityRegistrationInfoDto register(SecurityCapabilityRegistrationRequestDto registrationDto) {
        final var securityCapability = securityCapabilityMapper.toSecurityCapability(registrationDto);

        final var uuid = UUID.randomUUID();
        securityCapability.setId(uuid);
        LOGGER.infof("Registering %s", securityCapability);

        securityCapabilityRepository.persist(securityCapability);
        LOGGER.infof("Persisted security capability with id: %s", securityCapability.getId());

        return new SecurityCapabilityRegistrationInfoDto(uuid);
    }

    @Override
    public Boolean updateSC(SecurityCapabilityRegistrationRequestDto registrationDto) {
        // CHANGE: Implement during DB integration
        return true;
    }

}
