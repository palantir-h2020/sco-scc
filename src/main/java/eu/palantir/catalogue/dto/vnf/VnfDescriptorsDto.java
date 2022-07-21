package eu.palantir.catalogue.dto.vnf;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VnfDescriptorsDto {

    @NotNull
    private final UUID id;

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

    @NotNull
    @Valid
    @JsonProperty("security-group-rule")
    private final VnfSecurityGroupRuleDto securityGroupRule;

    @NotNull
    @Valid
    @JsonProperty("sw-image-desc")
    private final VnfSoftwareImageDescriptionDto softwareImageDescription;

    public VnfDescriptorsDto(UUID id, String provider, String version, String softwareVersion, String productInfoName,
            String productInfoDescription, VnfSecurityGroupRuleDto securityGroupRule,
            VnfSoftwareImageDescriptionDto softwareImageDescription) {
        this.id = id;
        this.provider = provider;
        this.version = version;
        this.softwareVersion = softwareVersion;
        this.productInfoName = productInfoName;
        this.productInfoDescription = productInfoDescription;
        this.securityGroupRule = securityGroupRule;
        this.softwareImageDescription = softwareImageDescription;
    }

    public UUID getId() {
        return this.id;
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
        if (!(o instanceof VnfDescriptorsDto)) {
            return false;
        }
        VnfDescriptorsDto vnfDescriptorsDto = (VnfDescriptorsDto) o;
        return Objects.equals(id, vnfDescriptorsDto.id) && Objects.equals(provider, vnfDescriptorsDto.provider)
                && Objects.equals(version, vnfDescriptorsDto.version)
                && Objects.equals(softwareVersion, vnfDescriptorsDto.softwareVersion)
                && Objects.equals(productInfoName, vnfDescriptorsDto.productInfoName)
                && Objects.equals(productInfoDescription, vnfDescriptorsDto.productInfoDescription)
                && Objects.equals(securityGroupRule, vnfDescriptorsDto.securityGroupRule)
                && Objects.equals(softwareImageDescription, vnfDescriptorsDto.softwareImageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider, version, softwareVersion, productInfoName, productInfoDescription,
                securityGroupRule, softwareImageDescription);
    }

}
