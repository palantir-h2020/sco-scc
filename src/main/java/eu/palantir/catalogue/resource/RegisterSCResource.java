package eu.palantir.catalogue.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;

@Path("/api/v1/register/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "register", description = "Registration of a Security Capablitiy")
public class RegisterSCResource {

    private static final Logger LOGGER = Logger.getLogger(RegisterSCResource.class);

    SecurityCapabilityRegistrationService registrationService;

    SecurityCapabilitySearchService searchService;

    @Inject
    public RegisterSCResource(SecurityCapabilityRegistrationService registrationService,
            SecurityCapabilitySearchService searchService) {
        this.registrationService = registrationService;
        this.searchService = searchService;
    }

    @POST
    @APIResponse(responseCode = "202", description = "SCC Registration request accepted", content = @Content(schema = @Schema(implementation = SecurityCapabilityRegistrationDto.class)))
    @APIResponse(responseCode = "401", description = "Unauthorized for SC Registration")
    @APIResponse(responseCode = "406", description = "Invalid input data")
    @APIResponse(responseCode = "409", description = "Conflict, SC already exists")
    @Operation(summary = "Register an SC, begin creation (or update) and onboarding process.")
    public Response create(@Valid SecurityCapabilityRegistrationDto securityCapabilityDto) {
        LOGGER.infof("Received registration request for security capability %s", securityCapabilityDto);

        // CHANGE: Add user-based filtering

        if (searchService.exists(securityCapabilityDto)) {
            return Response.noContent().status(Status.CONFLICT).build();
        }

        registrationService.registerSC(securityCapabilityDto);

        return Response.accepted(securityCapabilityDto).status(Status.ACCEPTED).build();
    }

}
