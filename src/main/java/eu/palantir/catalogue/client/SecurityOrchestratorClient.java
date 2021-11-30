package eu.palantir.catalogue.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Set;

// DRAFT ONLY
@RegisterRestClient(baseUri = "https://example.palantir.security.orchestrator/api")
public interface SecurityOrchestratorClient {

    // CHANGE: Implement during integration phase.
    @GET
    @Path("/extensions")
    Set<Extension> getExtensionsById(@QueryParam("id") String id);

    class Extension {
        public String id;
        public String name;
        public String shortName;
        public List<String> keywords;
    }
}
