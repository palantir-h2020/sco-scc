package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.model.security.SCSecurity;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SCSecurityMapper {

    SCSecurity toSCSecurity(SCSecurityDto scSecurityDto);

    SCSecurityDto toSCSecurityDto(SCSecurity scSecurity);

}
