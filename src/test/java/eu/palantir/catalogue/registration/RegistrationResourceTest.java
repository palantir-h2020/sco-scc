package eu.palantir.catalogue.registration;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.awaitility.Durations;
import org.jboss.logging.Logger;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import eu.palantir.catalogue.WireMockBaseUrl;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.model.job.JobStatus;
import eu.palantir.catalogue.repository.OnboardingJobRepository;
import eu.palantir.catalogue.repository.SecurityCapabilityRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoTestResource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static java.nio.charset.Charset.forName;
import static org.awaitility.Awaitility.await;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTestResource(MongoTestResource.class)
@QuarkusTestResource(value = WiremockSecurityOrchestratorOnboarding.class, restrictToAnnotatedClass = true)
@QuarkusTest
public class RegistrationResourceTest {

    private static final Logger LOGGER = Logger.getLogger(RegistrationResourceTest.class);

    // Ranges for randoms
    private final Integer minInt = 5;
    private final Integer maxInt = 20;
    private final Float minFloat = (float) 1.0;
    private final Float maxFloat = (float) 100.0;

    @WireMockBaseUrl
    URL wireMockServerBaseUrl;

    @Inject
    SecurityCapabilityRepository securityCapabilityRepository;

    @Inject
    OnboardingJobRepository onboardingJobRepository;

    @BeforeEach
    void enableRestAssuredLoggingIfValidationFails() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testRegistrationAndOnboarding() throws FileNotFoundException {

        // Randomizer for Random SC input
        EasyRandomParameters parameters = new EasyRandomParameters()
                .randomizationDepth(10)
                .charset(forName("UTF-8"))
                .stringLengthRange(5, 20)
                .collectionSizeRange(1, 5)
                .randomize(Integer.class, () -> new Random().nextInt(maxInt) + minInt)
                .randomize(Float.class, () -> minFloat + new Random().nextFloat() * (maxFloat - minFloat))
                .scanClasspathForConcreteTypes(true)
                .randomize(FieldPredicates.named("xnfId")
                        .or(FieldPredicates.named("nsId")),
                        () -> null);

        EasyRandom generator = new EasyRandom(parameters);

        // Get sample files
        final File xNFfile = new File("src/test/java/eu/palantir/catalogue/resources/packages/squid_vnfd.tar.gz");
        final InputStream xNFPackageStream = new DataInputStream(new FileInputStream(xNFfile));

        final File nsFile = new File("src/test/java/eu/palantir/catalogue/resources/packages/squid_cnf_nsd.tar.gz");
        final InputStream nsPackageStream = new DataInputStream(new FileInputStream(nsFile));

        // Prepare test data
        final var randomSC = generator.nextObject(SecurityCapabilityRegistrationRequestDto.class);

        // Prepare, send request form, get response
        Response httpResponse = RestAssured.given()
                .contentType("multipart/form-data")
                .multiPart(
                        "xNFPackage", "squid_vnfd.tar.gz",
                        xNFPackageStream,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart(
                        "NSPackage", "squid_cnf_nsd.tar.gz",
                        nsPackageStream,
                        MediaType.APPLICATION_OCTET_STREAM)
                .multiPart("registrationData",
                        randomSC, MediaType.APPLICATION_JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/api/v1/register");

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
        String onboardingJobId = httpResponse.jsonPath().getString("onboardingJobId");
        LOGGER.infof("Will check onboarding job with id %s", onboardingJobId);
        // Retrieve mock Security Capability id
        UUID scId = UUID.fromString(httpResponse.jsonPath().getString("id"));

        // Await response from Security Orchestrator, via the onboarding job
        await().pollDelay(Durations.FIVE_SECONDS).until(() -> {
            var onboardingJob = onboardingJobRepository.findById(onboardingJobId);
            if (onboardingJob == null) {
                // Should exist. If it does not, there is an issue, so stop.
                LOGGER.errorf("Could not find onboarding job with id %s", onboardingJobId);
                return true;
            }
            // Stop waiting upon error or finish.
            JobStatus jobStatus = onboardingJob.getJobStatus();
            return jobStatus == JobStatus.FINISHED || jobStatus == JobStatus.ERROR;
        });

        var onboardingJob = onboardingJobRepository.findById(onboardingJobId);
        assertThat(onboardingJob).isNotNull();
        assertThat(onboardingJob.getJobStatus()).isEqualTo(JobStatus.FINISHED);

        // The WireMock server will respond appropriately ONLY if the files sent through
        // the ONBOARDING background job are sent correctly. Due to the response the SC
        // in the data store will appear with "ONBOARDED" status.
        final var testSecurityCapability = securityCapabilityRepository.findById(scId);
        assertThat(testSecurityCapability.getStatus().toString().toUpperCase()).isEqualTo("ONBOARDED");
    }

}
