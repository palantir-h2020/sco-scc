package eu.palantir.catalogue.model.vnf;

import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@MongoEntity
public class VnfDescriptors {

    @Id
    private UUID id;

    private String provider;

    private String version;

    private String softwareVersion;

    private String productInfoName;

    private String productInfoDescription;

    private VnfSecurityGroupRule securityGroupRule;

    private VnfSoftwareImageDescription softwareImageDescription;

    public VnfDescriptors() {
    }

    public VnfDescriptors(UUID id, String provider, String version, String softwareVersion, String productInfoName,
            String productInfoDescription, VnfSecurityGroupRule securityGroupRule,
            VnfSoftwareImageDescription softwareImageDescription) {
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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getProductInfoName() {
        return this.productInfoName;
    }

    public void setProductInfoName(String productInfoName) {
        this.productInfoName = productInfoName;
    }

    public String getProductInfoDescription() {
        return this.productInfoDescription;
    }

    public void setProductInfoDescription(String productInfoDescription) {
        this.productInfoDescription = productInfoDescription;
    }

    public VnfSecurityGroupRule getSecurityGroupRule() {
        return this.securityGroupRule;
    }

    public void setSecurityGroupRule(VnfSecurityGroupRule securityGroupRule) {
        this.securityGroupRule = securityGroupRule;
    }

    public VnfSoftwareImageDescription getSoftwareImageDescription() {
        return this.softwareImageDescription;
    }

    public void setSoftwareImageDescription(VnfSoftwareImageDescription softwareImageDescription) {
        this.softwareImageDescription = softwareImageDescription;
    }

    public VnfDescriptors id(UUID id) {
        setId(id);
        return this;
    }

    public VnfDescriptors provider(String provider) {
        setProvider(provider);
        return this;
    }

    public VnfDescriptors version(String version) {
        setVersion(version);
        return this;
    }

    public VnfDescriptors softwareVersion(String softwareVersion) {
        setSoftwareVersion(softwareVersion);
        return this;
    }

    public VnfDescriptors productInfoName(String productInfoName) {
        setProductInfoName(productInfoName);
        return this;
    }

    public VnfDescriptors productInfoDescription(String productInfoDescription) {
        setProductInfoDescription(productInfoDescription);
        return this;
    }

    public VnfDescriptors securityGroupRule(VnfSecurityGroupRule securityGroupRule) {
        setSecurityGroupRule(securityGroupRule);
        return this;
    }

    public VnfDescriptors softwareImageDescription(VnfSoftwareImageDescription softwareImageDescription) {
        setSoftwareImageDescription(softwareImageDescription);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfDescriptors)) {
            return false;
        }
        VnfDescriptors vnfDescriptors = (VnfDescriptors) o;
        return Objects.equals(id, vnfDescriptors.id) && Objects.equals(provider, vnfDescriptors.provider)
                && Objects.equals(version, vnfDescriptors.version)
                && Objects.equals(softwareVersion, vnfDescriptors.softwareVersion)
                && Objects.equals(productInfoName, vnfDescriptors.productInfoName)
                && Objects.equals(productInfoDescription, vnfDescriptors.productInfoDescription)
                && Objects.equals(securityGroupRule, vnfDescriptors.securityGroupRule)
                && Objects.equals(softwareImageDescription, vnfDescriptors.softwareImageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider, version, softwareVersion, productInfoName, productInfoDescription,
                securityGroupRule, softwareImageDescription);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", provider='" + getProvider() + "'" +
                ", version='" + getVersion() + "'" +
                ", softwareVersion='" + getSoftwareVersion() + "'" +
                ", productInfoName='" + getProductInfoName() + "'" +
                ", productInfoDescription='" + getProductInfoDescription() + "'" +
                ", securityGroupRule='" + getSecurityGroupRule() + "'" +
                ", softwareImageDescription='" + getSoftwareImageDescription() + "'" +
                "}";
    }

}
