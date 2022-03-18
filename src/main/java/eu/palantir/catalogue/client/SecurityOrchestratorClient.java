package eu.palantir.catalogue.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import eu.palantir.catalogue.dto.orchestrator.IdDto;
import eu.palantir.catalogue.dto.orchestrator.PackageFormDto;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// NOTE: The security orchestrator sco-so has to be configured as a host name!
@ApplicationScoped
@RegisterRestClient(baseUri = "http://sco-so:50101/pkg")
public interface SecurityOrchestratorClient {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/xnf")
    IdDto onboardXnf(@MultipartForm PackageFormDto packageFormDto);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ns")
    IdDto onboardNs(@MultipartForm PackageFormDto packageFormDto);

}
