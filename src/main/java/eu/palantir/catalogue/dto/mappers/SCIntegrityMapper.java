package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.integrity.SCIntegrityDto;
import eu.palantir.catalogue.model.integrity.SCIntegrity;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SCIntegrityMapper {

    SCIntegrityDto toSCIntegrityDto(SCIntegrity scIntegrity);

}
