package eu.palantir.catalogue.service;

import java.util.Optional;
import java.util.UUID;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;

public interface SecurityCapabilityService {

    Optional<SecurityCapabilityDetailsDto> getSCbyID(UUID id);

    Boolean deleteSCbyID(UUID id);

}
