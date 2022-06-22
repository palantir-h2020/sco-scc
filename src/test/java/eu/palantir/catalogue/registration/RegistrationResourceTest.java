package eu.palantir.catalogue.registration;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import eu.palantir.catalogue.WireMockBaseUrl;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.fail;

@QuarkusTestResource(value = WiremockSecurityOrchestrator.class, restrictToAnnotatedClass = true)
@QuarkusTest
public class RegistrationResourceTest {

    static {
        // SCC URI
        RestAssured.baseURI = "http://0.0.0.0:8080/api/v1/register/";
    }

    @WireMockBaseUrl
    URL wireMockServerBaseUrl;

    ClassLoader classLoader;

    /* Inject and InjectMock if needed */

    @BeforeAll
    public void prepare() {
        this.classLoader = this.getClass().getClassLoader();
    }

    @Test
    public void testRegistrationAndOnboarding() {

        // Get sample files
        InputStream xNFPackage = classLoader.getResourceAsStream("packages/squid_vnfd.tar.gz");
        if (xNFPackage == null) {
            fail("xNFPackage file for test is not found");
        }

        InputStream nsPackage = classLoader.getResourceAsStream("packages/squid_cnf_nsd.tar.gz");
        if (nsPackage == null) {
            fail("NSPackage file for test is not found");
        }

        // Prepare test data
        final var mockedSC = Mockito.mock(SecurityCapabilityRegistrationRequestDto.class);

        // Prepare, send request form, get response
        Response httpResponse = RestAssured.given()
                .multiPart(
                        "xNFPackage", "squid_vnfd.tar.gz",
                        xNFPackage,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart(
                        "NSPackage", "squid_cnf_nsd.tar.gz",
                        nsPackage,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart("registrationData",
                        mockedSC, MediaType.APPLICATION_JSON)
                .accept(ContentType.JSON)
                .when()
                .post();

        // Assert response
        httpResponse.then().statusCode(202);
        String status = httpResponse.jsonPath().getString("."); // CHANGE

        // Await response from Security Orchestrator
        await().atMost(30, TimeUnit.SECONDS); // CHANGE

        // Check that the files are the same

    }

}
