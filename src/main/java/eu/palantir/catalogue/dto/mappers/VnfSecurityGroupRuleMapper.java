package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.vnf.VnfSecurityGroupRuleDto;
import eu.palantir.catalogue.model.vnf.VnfSecurityGroupRule;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VnfSecurityGroupRuleMapper {

    VnfSecurityGroupRule toVnfSecurityGroupRule(VnfSecurityGroupRuleDto vnfSecurityGroupRuleDto);

    VnfSecurityGroupRuleDto toVnfSecurityGroupRuleDto(VnfSecurityGroupRule vnfSecurityGroupRule);

}
