package eu.palantir.catalogue.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;

public interface SecurityCapabilityService {

    Optional<SecurityCapabilityDetailsDto> getById(UUID id);

    List<SecurityCapabilityDetailsDto> getAll();

    boolean deleteById(UUID id);
}
