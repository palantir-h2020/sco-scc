package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.vnf.VnfDescriptorsDto;
import eu.palantir.catalogue.dto.vnf.VnfRegistrationDto;
import eu.palantir.catalogue.model.vnf.VnfDescriptors;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", uses = {
        VnfSecurityGroupRuleMapper.class,
        VnfSoftwareImageDescriptionMapper.class,
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VnfDescriptorsMapper {

    VnfDescriptorsDto toVnfDescriptorsDto(VnfDescriptors vnfDescriptors);

    VnfDescriptors toVnfDescriptors(VnfRegistrationDto vnfRegistrationDto);

}
