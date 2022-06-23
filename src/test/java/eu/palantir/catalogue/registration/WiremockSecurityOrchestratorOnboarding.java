package eu.palantir.catalogue.registration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.jboss.logging.Logger;
import org.mockito.Mockito;
import com.github.tomakehurst.wiremock.WireMockServer;
import eu.palantir.catalogue.AbstractWireMockResource;
import eu.palantir.catalogue.dto.orchestrator.IdDto;

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

        ClassLoader classLoader = this.getClass().getClassLoader();

        // Security Orchestrator mock response.
        final var mockXNFResponse = Mockito.mock(IdDto.class);
        final var mockNSResponse = Mockito.mock(IdDto.class);

        // EXPECTED FILES
        // xNF package file
        InputStream xNFPackageStream = classLoader.getResourceAsStream("packages/squid_vnfd.tar.gz");
        byte[] expectedXNFPackage;
        try {
            expectedXNFPackage = xNFPackageStream.readAllBytes();
            xNFPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Failed to read xNFPackage.");
            e.printStackTrace();
            return Collections.emptyMap();
        }
        // NS package file
        InputStream nsPackageStream = classLoader.getResourceAsStream("packages/squid_cnf_nsd.tar.gz");
        byte[] expectedNSPackage;
        try {
            expectedNSPackage = nsPackageStream.readAllBytes();
            nsPackageStream.close();
        } catch (IOException e) {
            LOGGER.errorf("Failed to read NSPackage.");
            e.printStackTrace();
            return Collections.emptyMap();
        }

        // Wiremock Server setup
        this.wireMockServer = new WireMockServer(options().port(50101).bindAddress("10.101.41.168"));
        wireMockServer.start();

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

}
