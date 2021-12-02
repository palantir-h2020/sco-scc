package eu.palantir.catalogue.service.impl;

import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.service.SecurityCapabilityService;

@ApplicationScoped
public class SecurityCapabilityServiceImpl implements SecurityCapabilityService {

    @Override
    public Optional<SecurityCapabilityDetailsDto> getSCbyID(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean deleteSCbyID(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

}
