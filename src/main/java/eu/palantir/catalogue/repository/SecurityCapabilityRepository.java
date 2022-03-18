package eu.palantir.catalogue.repository;

import eu.palantir.catalogue.model.SecurityCapability;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class SecurityCapabilityRepository implements PanacheMongoRepositoryBase<SecurityCapability, UUID> {

}
