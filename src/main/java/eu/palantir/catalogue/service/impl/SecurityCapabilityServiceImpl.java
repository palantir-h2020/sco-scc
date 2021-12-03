package eu.palantir.catalogue.service.impl;

import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.service.SecurityCapabilityService;
import eu.palantir.catalogue.store.StaticStore;

@ApplicationScoped
public class SecurityCapabilityServiceImpl implements SecurityCapabilityService {

    StaticStore scStore;

    @Inject
    public SecurityCapabilityServiceImpl(StaticStore scStore) {
        this.scStore = scStore;
    }

    @Override
    public Optional<SecurityCapabilityDetailsDto> getSCbyID(UUID id) {
        // CHANGE: Implement during DB integration
        if (id.toString().equals("fc83e9a0-2ed5-4c23-b6da-62513953233b")) {
            return Optional.of(scStore.getSample(1));
        }
        if (id.toString().equals("ee4efa39-28c6-4657-afbd-103ad588b255")) {
            return Optional.of(scStore.getSample(2));
        }
        return Optional.of(scStore.getSample(3));
    }

    @Override
    public Boolean deleteSCbyID(UUID id) {
        // CHANGE: Implement during DB integration
        return true;
    }

}
