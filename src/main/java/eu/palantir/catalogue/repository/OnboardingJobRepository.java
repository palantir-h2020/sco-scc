package eu.palantir.catalogue.repository;

import eu.palantir.catalogue.model.job.OnboardingJob;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OnboardingJobRepository implements PanacheMongoRepositoryBase<OnboardingJob, String> {

}
