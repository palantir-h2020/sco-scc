package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.vnf.VnfSoftwareImageDescriptionDto;
import eu.palantir.catalogue.model.vnf.VnfSoftwareImageDescription;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VnfSoftwareImageDescriptionMapper {

    VnfSoftwareImageDescription toVnfSoftwareImageDescription(
            VnfSoftwareImageDescriptionDto vnfSoftwareImageDescriptionDto);

    VnfSoftwareImageDescriptionDto toVnfSoftwareImageDescriptionDto(
            VnfSoftwareImageDescription vnfSoftwareImageDescription);
}
