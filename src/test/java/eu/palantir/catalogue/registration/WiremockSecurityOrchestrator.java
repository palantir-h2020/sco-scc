package eu.palantir.catalogue.registration;

import java.util.Collections;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;
import eu.palantir.catalogue.AbstractWireMockResource;

public class WiremockSecurityOrchestrator extends AbstractWireMockResource {

    @Override
    public Map<String, String> start() {
        this.wireMockServer = new WireMockServer(/* CONTINUE with options... */);
        // Will probably need to set it up as a proxy, based on the sco-so hostname!!!
        wireMockServer.start();

        /* set up server (givenThat and willReturn) */

        return Collections.emptyMap();
    }

}
