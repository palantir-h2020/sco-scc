package eu.palantir.catalogue.service.impl;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.mappers.SecurityCapabilityMapper;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilityService;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SecurityCapabilityServiceImpl implements SecurityCapabilityService {
    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityServiceImpl.class);

    private final SecurityCapabilityMapper mapper;
    private final SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    public SecurityCapabilityServiceImpl(SecurityCapabilityMapper mapper, SecurityCapabilityRepository securityCapabilityRepository) {
        this.mapper = mapper;
        this.securityCapabilityRepository = securityCapabilityRepository;
    }

    @Override
    public Optional<SecurityCapabilityDetailsDto> getById(UUID id) {
        LOGGER.infof("Retrieving security capability by id '%s'", id);
        final var securityCapability = securityCapabilityRepository.findByIdOptional(id);

        if (securityCapability.isEmpty()) {
            LOGGER.infof("Security capability with id '%s' was not found", id);
            return Optional.empty();
        }

        LOGGER.infof("Retrieved security capability %s", securityCapability.get());
        final var securityCapabilityDetailsDto = mapper.toSecurityCapabilityDetailsDto(securityCapability.get());
        return Optional.of(securityCapabilityDetailsDto);
    }

    @Override
    public boolean deleteById(UUID id) {
        final var deleted = securityCapabilityRepository.deleteById(id);
        if (deleted) {
            LOGGER.infof("Deleted security capability with id '%s'", id);
        } else {
            LOGGER.infof("Security capability with id '%s' not found", id);
        }
        return deleted;
    }
}
