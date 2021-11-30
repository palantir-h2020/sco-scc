package eu.palantir.catalogue;

import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "SCC API", description = "Security Capabilities Catalogue API", version = "0.1.0"))
public class SecurityCapabilitiesCatalogue extends Application {
}