package eu.palantir.catalogue.service;

import java.util.Optional;
import java.util.UUID;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;

public interface SecurityCapabilityService {

    Optional<SecurityCapabilityDetailsDto> getById(UUID id);

    boolean deleteById(UUID id);
}
