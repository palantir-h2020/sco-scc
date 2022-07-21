package eu.palantir.catalogue.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.palantir.catalogue.auth.CatalogueClient;
import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.SecurityCapabilitySearchDto;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;

@ApplicationScoped
public class SecurityCapabilitySearchServiceImpl implements SecurityCapabilitySearchService {

    private final SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    public SecurityCapabilitySearchServiceImpl(SecurityCapabilityRepository securityCapabilityRepository) {
        this.securityCapabilityRepository = securityCapabilityRepository;
    }

    @Override
    public List<SecurityCapabilityDetailsDto> getAll() {
        // CHANGE: Implement during DB integration
        // return securityCapabilityRepository.getSamples(3);
        return new ArrayList<SecurityCapabilityDetailsDto>();
    }

    @Override
    public List<SecurityCapabilityDetailsDto> getAll(CatalogueClient client) {
        // CHANGE: Implement during DB integration
        // return securityCapabilityRepository.getSamples(3);
        return new ArrayList<SecurityCapabilityDetailsDto>();
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto) {
        // CHANGE: Implement during DB integration

        // if
        // (searchDto.getSecurity().getThreatProtections().get(0).getValue().equals("ddos"))
        // {
        // return securityCapabilityRepository.getSamples(2);
        // }

        // return securityCapabilityRepository.getSamples(3);
        return new ArrayList<SecurityCapabilityDetailsDto>();
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto, CatalogueClient client) {
        // CHANGE: Implement during DB integration
        // if
        // (searchDto.getSecurity().getThreatProtections().get(0).getValue().equals("ddos"))
        // {
        // return securityCapabilityRepository.getSamples(2);
        // }

        // return securityCapabilityRepository.getSamples(3);
        return new ArrayList<SecurityCapabilityDetailsDto>();
    }

    @Override
    public boolean exists(SecurityCapabilityRegistrationRequestDto registrationDto) {
        // CHANGE: Implement during DB integration
        return false;
    }

}
