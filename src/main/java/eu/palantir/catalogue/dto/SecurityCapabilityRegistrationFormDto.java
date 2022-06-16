package eu.palantir.catalogue.dto;

import java.io.InputStream;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

public class SecurityCapabilityRegistrationFormDto {

    @NotNull
    @Valid
    @FormParam("registrationData")
    private final SecurityCapabilityRegistrationRequestDto registrationRequest;

    @NotNull
    @FormParam("xNFPackage")
    private final InputStream xNFPackage;

    @NotNull
    @FormParam("NSPackage")
    private final InputStream NSPackage;

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
                ", xNFPackage='" + getXNFPackage() + "'" +
                ", NSPackage='" + getNSPackage() + "'" +
                "}";
    }

}
