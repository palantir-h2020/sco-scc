package eu.palantir.catalogue.registration;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.jboss.logging.Logger;
import com.github.tomakehurst.wiremock.WireMockServer;
import eu.palantir.catalogue.AbstractWireMockResource;
import eu.palantir.catalogue.dto.orchestrator.IdDto;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.jsonResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.aMultipart;
import static com.github.tomakehurst.wiremock.client.WireMock.binaryEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;

public class WiremockSecurityOrchestratorOnboarding extends AbstractWireMockResource {

    private static final Logger LOGGER = Logger.getLogger(WiremockSecurityOrchestratorOnboarding.class);

    @Override
    public Map<String, String> start() {

        // Security Orchestrator mock response.
        final var mockXNFResponse = new IdDto(UUID.randomUUID());
        final var mockNSResponse = new IdDto(UUID.randomUUID());

        // EXPECTED FILES
        // xNF package file
        byte[] expectedXNFPackage;
        try {
            final File xNFfile = new File("src/test/java/eu/palantir/catalogue/resources/packages/squid_vnfd.tar.gz");
            final InputStream xNFPackageStream = new DataInputStream(new FileInputStream(xNFfile));
            expectedXNFPackage = xNFPackageStream.readAllBytes();
            xNFPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Failed to read xNFPackage.");
            e.printStackTrace();
            return Collections.emptyMap();
        }
        // NS package file
        byte[] expectedNSPackage;
        try {
            final File nsFile = new File("src/test/java/eu/palantir/catalogue/resources/packages/squid_cnf_nsd.tar.gz");
            final InputStream nsPackageStream = new DataInputStream(new FileInputStream(nsFile));
            expectedNSPackage = nsPackageStream.readAllBytes();
            nsPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Failed to read NSPackage.");
            e.printStackTrace();
            return Collections.emptyMap();
        }

        // Wiremock Server setup
        wireMockServer = new WireMockServer(options().port(50101));
        wireMockServer.start();

        wireMockServer.addMockServiceRequestListener(WiremockSecurityOrchestratorOnboarding::requestReceived);

        // Wiremock will respond correctly ONLY IF the expected file is sent!
        wireMockServer.givenThat(post("/pkg/xnf").withMultipartRequestBody(aMultipart()
                .withName("package")
                .withHeader("Content-Type", containing("application/octet-stream"))
                .withBody(binaryEqualTo(expectedXNFPackage)))
                .willReturn(jsonResponse(mockXNFResponse, 202)));
        wireMockServer.givenThat(post("/pkg/ns").withMultipartRequestBody(aMultipart()
                .withName("package")
                .withHeader("Content-Type", containing("application/octet-stream"))
                .withBody(binaryEqualTo(expectedNSPackage)))
                .willReturn(jsonResponse(mockNSResponse, 202)));

        return Collections.emptyMap();
    }

    protected static void requestReceived(Request inRequest,
            Response inResponse) {
        LOGGER.infof("WireMock Orchestrator request at URL: %s", inRequest.getAbsoluteUrl());
        LOGGER.infof("WireMock Orchestrator request headers: \n%s", inRequest.getHeaders());
        LOGGER.infof("WireMock Orchestrator response body: \n%s", inResponse.getBodyAsString());
        LOGGER.infof("WireMock Orchestrator response headers: \n%s", inResponse.getHeaders());
    }

}
