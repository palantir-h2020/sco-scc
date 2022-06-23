package eu.palantir.catalogue.registration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.jobrunr.storage.StorageProvider;
import eu.palantir.catalogue.WireMockBaseUrl;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jobrunr.jobs.states.StateName.SUCCEEDED;

@QuarkusTestResource(value = WiremockSecurityOrchestratorOnboarding.class, restrictToAnnotatedClass = true)
@QuarkusTest
public class RegistrationResourceTest {

    static {
        // SCC URI
        RestAssured.baseURI = "http://0.0.0.0:8080/api/v1/register/";
    }

    private static final Logger LOGGER = Logger.getLogger(RegistrationResourceTest.class);

    @WireMockBaseUrl
    URL wireMockServerBaseUrl;

    @Inject
    StorageProvider storageProvider;

    @Inject
    SecurityCapabilityRepository securityCapabilityRepository;

    ClassLoader classLoader;

    /* Inject and InjectMock if needed */

    @BeforeAll
    public void prepare() {
        this.classLoader = this.getClass().getClassLoader();
    }

    @Test
    public void testRegistrationAndOnboarding() {

        // Get sample files
        InputStream xNFPackageStream = classLoader.getResourceAsStream("packages/squid_vnfd.tar.gz");
        if (xNFPackageStream == null)
            fail("xNFPackage file for test is not found");

        InputStream nsPackageStream = classLoader.getResourceAsStream("packages/squid_cnf_nsd.tar.gz");
        if (nsPackageStream == null)
            fail("NSPackage file for test is not found");

        // Prepare test data
        final var mockedSC = Mockito.mock(SecurityCapabilityRegistrationRequestDto.class);

        // Prepare, send request form, get response
        Response httpResponse = RestAssured.given()
                .multiPart(
                        "xNFPackage", "squid_vnfd.tar.gz",
                        xNFPackageStream,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart(
                        "NSPackage", "squid_cnf_nsd.tar.gz",
                        nsPackageStream,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart("registrationData",
                        mockedSC, MediaType.APPLICATION_JSON)
                .accept(ContentType.JSON)
                .when()
                .post();

        try {
            xNFPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Could not close xNFPackageStream");
            e.printStackTrace();
        }

        try {
            nsPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Could not close nsPackageStream");
            e.printStackTrace();
        }

        // Assert response from SCC endpoint
        httpResponse.then().statusCode(202);
        assertThat(httpResponse.jsonPath().getString("status").toUpperCase()).isEqualTo("REGISTERED");
        // Retrieve onboarding background job id
        UUID onboardingJobId = UUID.fromString(httpResponse.jsonPath().getString("onboardingJobId"));
        // Retrieve mock Security Capability id
        UUID scId = UUID.fromString(httpResponse.jsonPath().getString("id"));

        // Await response from Security Orchestrator, via the onboarding job
        await().atMost(10, TimeUnit.SECONDS)
                .until(() -> storageProvider.getJobById(onboardingJobId).hasState(SUCCEEDED));

        // The WireMock server will respond appropriately ONLY if the files sent through
        // the ONBOARDING background job are sent correctly. Due to the response the SC
        // in the data store will appear with "ONBOARDED" status.
        final var testSecurityCapability = securityCapabilityRepository.findById(scId);
        assertThat(testSecurityCapability.getStatus().toString().toUpperCase()).isEqualTo("ONBOARDED");
    }

}
