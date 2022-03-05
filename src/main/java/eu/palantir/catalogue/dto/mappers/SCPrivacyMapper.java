package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.privacy.SCPrivacyDto;
import eu.palantir.catalogue.model.privacy.SCPrivacy;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SCPrivacyMapper {

    SCPrivacy toSCPrivacy(SCPrivacyDto scPrivacyDto);

    SCPrivacyDto toSCPrivacyDto(SCPrivacy scPrivacy);

}
