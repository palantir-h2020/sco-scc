package eu.palantir.catalogue.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import eu.palantir.catalogue.auth.CatalogueClient;
import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.dto.SecurityCapabilitySearchDto;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;

@ApplicationScoped
public class SecurityCapabilitySearchServiceImpl implements SecurityCapabilitySearchService {

    @Override
    public List<SecurityCapabilityDetailsDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SecurityCapabilityDetailsDto> getAll(CatalogueClient client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto, CatalogueClient client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean exists(SecurityCapabilityRegistrationDto registrationDto) {
        // TODO Auto-generated method stub
        return null;
    }

}
