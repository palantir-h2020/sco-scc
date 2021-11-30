package eu.palantir.project;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import eu.palantir.catalogue.client.SecurityOrchestratorClient;

import javax.inject.Inject;
import java.util.Set;

@QuarkusTest
public class MyRemoteServiceTest {

    @Inject
    @RestClient
    SecurityOrchestratorClient myRemoteService;

    @Test
    public void testExtensionsRestClientEndpoint() {
        Set<SecurityOrchestratorClient.Extension> restClientExtensions = myRemoteService
                .getExtensionsById("io.quarkus:quarkus-rest-client");

        Assertions.assertEquals(1, restClientExtensions.size());
        for (SecurityOrchestratorClient.Extension extension : restClientExtensions) {
            Assertions.assertEquals("io.quarkus:quarkus-rest-client", extension.id);
            Assertions.assertEquals("REST Client", extension.name);
            Assertions.assertEquals("REST Client", extension.shortName);
            Assertions.assertTrue(extension.keywords.size() > 1);
            Assertions.assertTrue(extension.keywords.contains("rest-client"));
        }
    }
}
