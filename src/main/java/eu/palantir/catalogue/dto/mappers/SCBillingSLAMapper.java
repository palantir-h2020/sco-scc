package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.model.billing.SCBillingSLA;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SCBillingSLAMapper {

    SCBillingSLA toSCBillingSLA(SCBillingSLADto scBillingSLADto);

    SCBillingSLADto toSCBillingSLADto(SCBillingSLA scBillingSLA);

}
