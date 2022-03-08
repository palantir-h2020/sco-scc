package eu.palantir.catalogue.repository;

import eu.palantir.catalogue.model.SecurityCapability;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecurityCapabilityRepository implements PanacheMongoRepository<SecurityCapability> {

}
