package eu.palantir.catalogue.service;

import java.util.List;

import eu.palantir.catalogue.auth.CatalogueClient;
import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.dto.SecurityCapabilitySearchDto;

public interface SecurityCapabilitySearchService {

    List<SecurityCapabilityDetailsDto> getAll();

    List<SecurityCapabilityDetailsDto> getAll(CatalogueClient client);

    List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto);

    List<SecurityCapabilityDetailsDto> search(SecurityCapabilitySearchDto searchDto,
            CatalogueClient client);

    Boolean exists(SecurityCapabilityRegistrationDto registrationDto);

}
