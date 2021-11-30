package eu.palantir.catalogue.resource;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.SecurityCapabilityRegistrationDto;
import eu.palantir.catalogue.dto.SecurityCapabilitySearchDto;
import eu.palantir.catalogue.service.SecurityCapabilityRegistrationService;
import eu.palantir.catalogue.service.SecurityCapabilitySearchService;
import eu.palantir.catalogue.service.SecurityCapabilityService;

@Path("/api/v1/services/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "services", description = "All operations on the registered SC services.")
public class ServicesResource {

    private static final Logger LOGGER = Logger.getLogger(ServicesResource.class);

    private final SecurityCapabilitySearchService searchService;

    private final SecurityCapabilityService capabilityService;

    private final SecurityCapabilityRegistrationService registrationService;

    @Inject
    public ServicesResource(SecurityCapabilitySearchService searchService, SecurityCapabilityService capabilityService,
            SecurityCapabilityRegistrationService registrationService) {
        this.searchService = searchService;
        this.capabilityService = capabilityService;
        this.registrationService = registrationService;
    }

    @GET
    @APIResponse(responseCode = "200")
    @Operation(summary = "Get all registered Security Capabilities, accessible to the current authenticated user.")
    public List<SecurityCapabilityDetailsDto> getAll() {
        LOGGER.infof("Received request for ALL registered security capabilities");

        // CHANGE: Add user-based filtering
        // CHANGE: Add pagination

        return searchService.getAll();
    }

    @GET
    @Path("{id}")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "Security Capability not found")
    @Operation(summary = "Find resource by ID")
    public SecurityCapabilityDetailsDto getSingle(@PathParam("id") UUID id) {
        LOGGER.infof("Received request for security capability with ID %s", id);

        // CHANGE: Add only authentication

        return capabilityService.getSCbyID(id).orElseThrow(NotFoundException::new);
    }

    @POST
    @APIResponse(responseCode = "200", description = "Search OK, matching SCs fetched", content = @Content(schema = @Schema(type = SchemaType.ARRAY, minItems = 1, uniqueItems = true, implementation = SecurityCapabilityDetailsDto.class)))
    @APIResponse(responseCode = "204", description = "Search OK, no matching SCs found")
    @APIResponse(responseCode = "406", description = "Invalid data")
    @Operation(summary = "Create new resource")
    public Response search(@Valid SecurityCapabilitySearchDto searchDto) {
        LOGGER.infof("Received SC search query %s", searchDto);

        // CHANGE: Add user-based filtering
        // CHANGE: Add pagination

        List<SecurityCapabilityDetailsDto> scList = searchService.search(searchDto);

        if (scList.isEmpty()) {
            return Response.noContent().status(Status.NO_CONTENT).build();
        }

        return Response.ok(scList).status(Status.OK).build();
    }

    @PATCH
    @Path("{id}")
    @APIResponse(responseCode = "202", description = "SC update process started", content = @Content(schema = @Schema(implementation = SecurityCapabilityRegistrationDto.class)))
    @APIResponse(responseCode = "204", description = "No changes found for SC to be updated")
    @APIResponse(responseCode = "404", description = "SC not found")
    @Operation(summary = "Edit resource by ID")
    public Response update(@PathParam("id") UUID id, @Valid SecurityCapabilityRegistrationDto updateDto) {
        LOGGER.infof("Received SC update %s for ID %s", updateDto, id);

        // CHANGE: Add user-based filtering

        SecurityCapabilityDetailsDto scDto = capabilityService.getSCbyID(id).orElseThrow(NotFoundException::new);

        if (updateDto.equals(scDto)) {
            return Response.noContent().status(Status.NO_CONTENT).build();
        }

        registrationService.updateSC(updateDto);

        return Response.ok(updateDto).status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("{id}")
    @APIResponse(responseCode = "204", description = "Security capability deleted")
    @APIResponse(responseCode = "404", description = "resource not found")
    @Operation(summary = "Delete resource by ID")
    public Response delete(@PathParam("id") UUID id) {

        // CHANGE: Add only authentication

        capabilityService.getSCbyID(id).orElseThrow(NotFoundException::new);

        // Delete, and throw 500 if it fails
        if (!capabilityService.deleteSCbyID(id)) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        // CHANGE: Add the call to the SO client to delete the SC.

        return Response.status(Status.NO_CONTENT).build();
    }
}
