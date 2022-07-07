package eu.palantir.catalogue;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(title = "SCC API", description = "Security Capabilities Catalogue API.", version = "0.1.0"))
public class SecurityCapabilitiesCatalogue extends Application {

    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilitiesCatalogue.class);

    // Add readiness checks for DB when integrated.
    @Transactional
    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
    }

    @Transactional
    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }
}
