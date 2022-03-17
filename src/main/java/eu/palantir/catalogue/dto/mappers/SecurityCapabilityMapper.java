package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.model.SecurityCapability;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", uses = {
        VnfDescriptorsMapper.class,
        SCIntegrityMapper.class,
        SCSecurityMapper.class,
        SCBillingSLAMapper.class,
        SCPrivacyMapper.class,
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SecurityCapabilityMapper {

    SecurityCapabilityDetailsDto toSecurityCapabilityDetailsDto(SecurityCapability securityCapability);

    List<SecurityCapabilityDetailsDto> toSecurityCapabilityDetailsDtoList(List<SecurityCapability> securityCapability);

    SecurityCapability toSecurityCapability(
            SecurityCapabilityRegistrationRequestDto securityCapabilityRegistrationRequestDto);
}
