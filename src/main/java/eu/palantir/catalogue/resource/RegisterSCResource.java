package eu.palantir.catalogue.resource;

import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationRequestDto;
import eu.palantir.catalogue.dto.mappers.OnboardingJobMapper;
import eu.palantir.catalogue.dto.onboarding.OnboardingJobDto;
import eu.palantir.catalogue.repository.OnboardingJobRepository;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationFormDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationInfoDto;
import eu.palantir.catalogue.service.SecurityCapabilityOnboardingService;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;

@Path("/api/v1/register/")
@Tag(name = "register", description = "Registration of a Security Capability.")
@Produces(MediaType.APPLICATION_JSON)
public class RegisterSCResource {

    private static final Logger LOGGER = Logger.getLogger(RegisterSCResource.class);

    private final SecurityCapabilityRegistrationService registrationService;

    private final SecurityCapabilitySearchService searchService;

    private final SecurityCapabilityOnboardingService onboardingService;

    private final OnboardingJobRepository onboardingJobRepository;

    private final OnboardingJobMapper onboardingJobMapper;

    private final ManagedExecutor managedExecutor;

    @Inject
    public RegisterSCResource(SecurityCapabilityRegistrationService registrationService,
            SecurityCapabilitySearchService searchService,
            SecurityCapabilityOnboardingService onboardingService,
            OnboardingJobRepository onboardingJobRepository,
            OnboardingJobMapper onboardingJobMapper,
            ManagedExecutor managedExecutor) {
        this.registrationService = registrationService;
        this.searchService = searchService;
        this.onboardingService = onboardingService;
        this.onboardingJobRepository = onboardingJobRepository;
        this.onboardingJobMapper = onboardingJobMapper;
        this.managedExecutor = managedExecutor;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
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
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @APIResponse(responseCode = "202", description = "SCC Registration request accepted", content = @Content(schema = @Schema(implementation = SecurityCapabilityRegistrationFormDto.class)))
    @APIResponse(responseCode = "401", description = "Unauthorized for SC Registration")
    @APIResponse(responseCode = "406", description = "Invalid input data")
    @APIResponse(responseCode = "409", description = "Conflict, SC already exists")
    @Operation(summary = "REGISTER an SC, begin creation and on-boarding process")
    public Response register(@Valid @MultipartForm SecurityCapabilityRegistrationFormDto registrationForm) {
        LOGGER.infof("Received registration and onboarding request for security capability %s", registrationForm);

        final var securityCapabilityDto = registrationForm.getRegistrationRequest();

        if (searchService.exists(securityCapabilityDto)) {
            registrationForm.closeStreams();
            return Response.noContent().status(Status.CONFLICT).build();
        }

        final var registrationInfoDto = registrationService.register(securityCapabilityDto);
        final String onboardingTaskId = UUID.randomUUID().toString().replace("-", "");
        registrationInfoDto.setOnboardingJobId(onboardingTaskId);

        // ONBOARDING IN BACKGROUND! NOTE: Meant to be done last, closes the streams,
        // handles onboarding job status!
        managedExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.infof("Starting onboarding task %s for SC with ID %s ...", onboardingTaskId,
                        registrationInfoDto.getId());
                onboardingService.onboardSC(registrationForm, registrationInfoDto.getId(), onboardingTaskId);
                LOGGER.infof("Onboarding task %s for SC with ID %s completed!", onboardingTaskId,
                        registrationInfoDto.getId());
            }
        });

        return Response.accepted(registrationInfoDto).status(Status.ACCEPTED).build();
    }

    @GET
    @Path("{id}")
    @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = OnboardingJobDto.class)))
    @APIResponse(responseCode = "404", description = "Onboarding job not found")
    @Operation(summary = "Get status of an onboarding job, given its ID")
    public OnboardingJobDto getOnboardingStatus(@PathParam("id") String onboardingId) {

        final var onboardingJob = onboardingJobRepository.findByIdOptional(onboardingId)
                .orElseThrow(NotFoundException::new);

        return onboardingJobMapper.tOnboardingJobDto(onboardingJob);

    }

}
