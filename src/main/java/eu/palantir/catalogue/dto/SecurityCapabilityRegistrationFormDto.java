package eu.palantir.catalogue.dto;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class SecurityCapabilityRegistrationFormDto {

    private static final Logger LOGGER = Logger.getLogger(SecurityCapabilityRegistrationFormDto.class);

    @NotNull
    @FormParam("registrationData")
    @PartType(MediaType.APPLICATION_JSON)
    @Valid
    private SecurityCapabilityRegistrationRequestDto registrationRequest;

    @NotNull
    @FormParam("xNFPackage")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream xNFPackage;

    @NotNull
    @FormParam("NSPackage")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream NSPackage;

    public SecurityCapabilityRegistrationFormDto() {
    }

    public SecurityCapabilityRegistrationFormDto(SecurityCapabilityRegistrationRequestDto registrationRequest,
            InputStream xNFPackage, InputStream NSPackage) {
        this.registrationRequest = registrationRequest;
        this.xNFPackage = xNFPackage;
        this.NSPackage = NSPackage;
    }

    public SecurityCapabilityRegistrationRequestDto getRegistrationRequest() {
        return this.registrationRequest;
    }

    public InputStream getXNFPackage() {
        return this.xNFPackage;
    }

    public InputStream getNSPackage() {
        return this.NSPackage;
    }

    public void setRegistrationRequest(SecurityCapabilityRegistrationRequestDto registrationRequest) {
        this.registrationRequest = registrationRequest;
    }

    public void setXNFPackage(InputStream xNFPackage) {
        this.xNFPackage = xNFPackage;
    }

    public void setNSPackage(InputStream NSPackage) {
        this.NSPackage = NSPackage;
    }

    public void closeStreams() {
        if (this.xNFPackage != null)
            try {
                this.xNFPackage.close();
            } catch (IOException e) {
                LOGGER.errorf("Failed to close xNFPackage file stream!");
                e.printStackTrace();
            }

        if (this.NSPackage != null)
            try {
                this.NSPackage.close();
            } catch (IOException e) {
                LOGGER.errorf("Failed to close NSPackage file stream!");
                e.printStackTrace();
            }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapabilityRegistrationFormDto)) {
            return false;
        }
        SecurityCapabilityRegistrationFormDto securityCapabilityRegistrationFormDto = (SecurityCapabilityRegistrationFormDto) o;
        return Objects.equals(registrationRequest, securityCapabilityRegistrationFormDto.registrationRequest)
                && Objects.equals(xNFPackage, securityCapabilityRegistrationFormDto.xNFPackage)
                && Objects.equals(NSPackage, securityCapabilityRegistrationFormDto.NSPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationRequest, xNFPackage, NSPackage);
    }

    @Override
    public String toString() {
        return "{" +
                " registrationRequest='" + getRegistrationRequest() + "'" +
                ", xNFPackage='" + System.identityHashCode(
                        getXNFPackage())
                + "'" +
                ", NSPackage='" + System.identityHashCode(getNSPackage()) + "'" +
                "}";
    }

}
