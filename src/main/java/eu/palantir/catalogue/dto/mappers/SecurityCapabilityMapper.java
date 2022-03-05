package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.model.SecurityCapability;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", uses = {
        VnfDescriptorsMapper.class,
        SCIntegrityMapper.class,
        SCSecurityMapper.class,
        SCBillingSLAMapper.class,
        SCPrivacyMapper.class,
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SecurityCapabilityMapper {

    SecurityCapabilityDetailsDto toSCDetailsDto(SecurityCapability securityCapability);

    SecurityCapability toSecurityCapability(SecurityCapabilityRegistrationDto securityCapabilityRegistrationDto);
}
