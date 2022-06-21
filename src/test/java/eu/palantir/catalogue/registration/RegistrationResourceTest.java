package eu.palantir.catalogue.registration;

import java.net.URL;

import org.junit.jupiter.api.Test;

import eu.palantir.catalogue.WireMockBaseUrl;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTestResource(value = WiremockSecurityOrchestrator.class, restrictToAnnotatedClass = true)
@QuarkusTest
public class RegistrationResourceTest {

    static {
        // SCC URI
        RestAssured.baseURI = "http://0.0.0.0:8080/";
    }

    @WireMockBaseUrl
    URL wireMockServerBaseUrl;

    /* Inject and InjectMock */

    @Test
    public void testRegistrationAndOnboarding() {

    }

}
