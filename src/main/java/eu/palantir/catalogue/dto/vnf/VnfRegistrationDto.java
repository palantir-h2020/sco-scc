package eu.palantir.catalogue.dto.vnf;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VnfRegistrationDto {

    @NotBlank
    private final String provider;

    @NotBlank
    private final String version;

    @NotBlank
    @JsonProperty("software-version")
    private final String softwareVersion;

    @NotBlank
    @JsonProperty("product-info-name")
    private final String productInfoName;

    @NotBlank
    @JsonProperty("product-info-description")
    private final String productInfoDescription;

    @NotBlank
    @Valid
    @JsonProperty("security-group-rule")
    private final VnfSecurityGroupRuleDto securityGroupRule;

    @NotBlank
    @Valid
    @JsonProperty("sw-image-desc")
    private final VnfSoftwareImageDescriptionDto softwareImageDescription;

    public VnfRegistrationDto(String provider, String version, String softwareVersion, String productInfoName,
            String productInfoDescription, VnfSecurityGroupRuleDto securityGroupRule,
            VnfSoftwareImageDescriptionDto softwareImageDescription) {
        this.provider = provider;
        this.version = version;
        this.softwareVersion = softwareVersion;
        this.productInfoName = productInfoName;
        this.productInfoDescription = productInfoDescription;
        this.securityGroupRule = securityGroupRule;
        this.softwareImageDescription = softwareImageDescription;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getVersion() {
        return this.version;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public String getProductInfoName() {
        return this.productInfoName;
    }

    public String getProductInfoDescription() {
        return this.productInfoDescription;
    }

    public VnfSecurityGroupRuleDto getSecurityGroupRule() {
        return this.securityGroupRule;
    }

    public VnfSoftwareImageDescriptionDto getSoftwareImageDescription() {
        return this.softwareImageDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfRegistrationDto)) {
            return false;
        }
        VnfRegistrationDto vnfRegistrationDto = (VnfRegistrationDto) o;
        return Objects.equals(provider, vnfRegistrationDto.provider)
                && Objects.equals(version, vnfRegistrationDto.version)
                && Objects.equals(softwareVersion, vnfRegistrationDto.softwareVersion)
                && Objects.equals(productInfoName, vnfRegistrationDto.productInfoName)
                && Objects.equals(productInfoDescription, vnfRegistrationDto.productInfoDescription)
                && Objects.equals(securityGroupRule, vnfRegistrationDto.securityGroupRule)
                && Objects.equals(softwareImageDescription, vnfRegistrationDto.softwareImageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provider, version, softwareVersion, productInfoName, productInfoDescription,
                securityGroupRule, softwareImageDescription);
    }

}
