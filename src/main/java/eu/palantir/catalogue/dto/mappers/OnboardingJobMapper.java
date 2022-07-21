package eu.palantir.catalogue.dto.mappers;

import org.mapstruct.Mapper;

import eu.palantir.catalogue.dto.onboarding.OnboardingJobDto;
import eu.palantir.catalogue.model.job.OnboardingJob;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OnboardingJobMapper {

    OnboardingJobDto tOnboardingJobDto(OnboardingJob onboardingJob);

}
