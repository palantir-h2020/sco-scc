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
import org.jobrunr.scheduling.JobScheduler;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationFormDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;
import eu.palantir.catalogue.service.SecurityCapabilityOnboardingService;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;

@Path("/api/v1/register/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "register", description = "Registration of a Security Capability.")
public class RegisterSCResource {

    private static final Logger LOGGER = Logger.getLogger(RegisterSCResource.class);

    private final SecurityCapabilityRegistrationService registrationService;

    private final SecurityCapabilitySearchService searchService;

    private final SecurityCapabilityOnboardingService onboardingService;

    private final JobScheduler jobScheduler;

    @Inject
    public RegisterSCResource(SecurityCapabilityRegistrationService registrationService,
            SecurityCapabilitySearchService searchService,
            SecurityCapabilityOnboardingService onboardingService,
            JobScheduler jobScheduler) {
        this.registrationService = registrationService;
        this.searchService = searchService;
        this.onboardingService = onboardingService;
        this.jobScheduler = jobScheduler;
    }

    @POST
    @APIResponse(responseCode = "202", description = "SCC Registration request accepted", content = @Content(schema = @Schema(implementation = SecurityCapabilityRegistrationInfoDto.class)))
    @APIResponse(responseCode = "401", description = "Unauthorized for SC Registration")
    @APIResponse(responseCode = "406", description = "Invalid input data")
    @APIResponse(responseCode = "409", description = "Conflict, SC already exists")
    @Operation(summary = "REGISTER an SC, begin creation and on-boarding process, WITHOUT accompanying files.")
    public Response register(@Valid SecurityCapabilityRegistrationRequestDto securityCapabilityDto) {
        LOGGER.infof("Received registration (only) request for security capability %s", securityCapabilityDto);

        // CHANGE: Add user-based filtering

        if (searchService.exists(securityCapabilityDto)) {
            return Response.noContent().status(Status.CONFLICT).build();
        }

        final var registrationInfoDto = registrationService.register(securityCapabilityDto);

        return Response.accepted(registrationInfoDto).status(Status.ACCEPTED).build();
    }

    @POST
    @APIResponse(responseCode = "202", description = "SCC Registration request accepted", content = @Content(schema = @Schema(implementation = SecurityCapabilityRegistrationInfoDto.class)))
    @APIResponse(responseCode = "401", description = "Unauthorized for SC Registration")
    @APIResponse(responseCode = "406", description = "Invalid input data")
    @APIResponse(responseCode = "409", description = "Conflict, SC already exists")
    @Operation(summary = "REGISTER an SC, begin creation and on-boarding process")
    public Response register(@Valid SecurityCapabilityRegistrationFormDto registrationForm) {
        LOGGER.infof("Received registration and onboarding request for security capability %s", registrationForm);

        final var securityCapabilityDto = registrationForm.getRegistrationRequest();

        if (searchService.exists(securityCapabilityDto)) {
            return Response.noContent().status(Status.CONFLICT).build();
        }

        final var registrationInfoDto = registrationService.register(securityCapabilityDto);

        // ONBOARDING in background
        jobScheduler.enqueue(() -> onboardingService.onboardSC(registrationForm, registrationInfoDto.getId()));

        return Response.accepted(registrationInfoDto).status(Status.ACCEPTED).build();
    }

}
