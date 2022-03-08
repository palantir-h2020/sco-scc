package eu.palantir.catalogue.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.palantir.catalogue.auth.CatalogueClient;
import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.SecurityCapabilitySearchDto;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;
import eu.palantir.catalogue.store.StaticStore;

@ApplicationScoped
public class SecurityCapabilitySearchServiceImpl implements SecurityCapabilitySearchService {

    private final StaticStore scStore;
    private final SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    public SecurityCapabilitySearchServiceImpl(StaticStore scStore, SecurityCapabilityRepository securityCapabilityRepository) {
        this.scStore = scStore;
        this.securityCapabilityRepository = securityCapabilityRepository;
    }

    @Override
    public List<SecurityCapabilityDetailsDto> getAll() {
        // CHANGE: Implement during DB integration
        return scStore.getSamples(3);
    }

    @Override
    public List<SecurityCapabilityDetailsDto> getAll(CatalogueClient client) {
        // CHANGE: Implement during DB integration
        return scStore.getSamples(3);
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto) {
        // CHANGE: Implement during DB integration

        if (searchDto.getSecurity().getThreatProtections().get(0).getValue().equals("ddos")) {
            return scStore.getSamples(2);
        }

        return scStore.getSamples(3);
    }

    @Override
    public List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto, CatalogueClient client) {
        // CHANGE: Implement during DB integration
        if (searchDto.getSecurity().getThreatProtections().get(0).getValue().equals("ddos")) {
            return scStore.getSamples(2);
        }

        return scStore.getSamples(3);
    }

    @Override
    public boolean exists(SecurityCapabilityRegistrationRequestDto registrationDto) {
        // CHANGE: Implement during DB integration
        return false;
    }

}
