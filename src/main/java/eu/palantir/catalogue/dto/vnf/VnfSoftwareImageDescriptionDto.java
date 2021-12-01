package eu.palantir.catalogue.dto.vnf;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.palantir.catalogue.model.integrity.CheckSum;
import eu.palantir.catalogue.model.virtualization.ContainerFormat;
import eu.palantir.catalogue.model.virtualization.DiskFormat;
import eu.palantir.catalogue.validation.NotEmptyFields;

public class VnfSoftwareImageDescriptionDto {

    @NotBlank
    private final String id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String version;

    @NotNull
    @Valid
    private final CheckSum checksum;

    @NotNull
    private final URI image;

    @NotNull
    @JsonProperty("container-format")
    private final ContainerFormat containerFormat;

    @JsonProperty("disk-format")
    private final DiskFormat diskFormat;

    @NotNull
    @Min(0)
    @JsonProperty("min-disk")
    private final Integer minDisk;

    @NotNull
    @Min(0)
    @JsonProperty("min-ram")
    private final Float minRam;

    @NotNull
    @Min(0)
    private final Integer size;

    @NotBlank
    @JsonProperty("operating-system")
    private final String operatingSystem;

    @NotEmptyFields
    @JsonProperty("supported-virtualization-environment")
    private final List<String> virtualizationEnvironment;

    public VnfSoftwareImageDescriptionDto(String id, String name, String version, CheckSum checksum, URI image,
            ContainerFormat containerFormat, DiskFormat diskFormat, Integer minDisk, Float minRam, Integer size,
            String operatingSystem, List<String> virtualizationEnvironment) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.checksum = checksum;
        this.image = image;
        this.containerFormat = containerFormat;
        this.diskFormat = diskFormat;
        this.minDisk = minDisk;
        this.minRam = minRam;
        this.size = size;
        this.operatingSystem = operatingSystem;
        this.virtualizationEnvironment = virtualizationEnvironment;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public CheckSum getChecksum() {
        return this.checksum;
    }

    public URI getImage() {
        return this.image;
    }

    public ContainerFormat getContainerFormat() {
        return this.containerFormat;
    }

    public DiskFormat getDiskFormat() {
        return this.diskFormat;
    }

    public Integer getMinDisk() {
        return this.minDisk;
    }

    public Float getMinRam() {
        return this.minRam;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public List<String> getVirtualizationEnvironment() {
        return this.virtualizationEnvironment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfSoftwareImageDescriptionDto)) {
            return false;
        }
        VnfSoftwareImageDescriptionDto vnfSoftwareImageDescriptionDto = (VnfSoftwareImageDescriptionDto) o;
        return Objects.equals(id, vnfSoftwareImageDescriptionDto.id)
                && Objects.equals(name, vnfSoftwareImageDescriptionDto.name)
                && Objects.equals(version, vnfSoftwareImageDescriptionDto.version)
                && Objects.equals(checksum, vnfSoftwareImageDescriptionDto.checksum)
                && Objects.equals(image, vnfSoftwareImageDescriptionDto.image)
                && Objects.equals(containerFormat, vnfSoftwareImageDescriptionDto.containerFormat)
                && Objects.equals(diskFormat, vnfSoftwareImageDescriptionDto.diskFormat)
                && Objects.equals(minDisk, vnfSoftwareImageDescriptionDto.minDisk)
                && Objects.equals(minRam, vnfSoftwareImageDescriptionDto.minRam)
                && Objects.equals(size, vnfSoftwareImageDescriptionDto.size)
                && Objects.equals(operatingSystem, vnfSoftwareImageDescriptionDto.operatingSystem)
                && Objects.equals(virtualizationEnvironment, vnfSoftwareImageDescriptionDto.virtualizationEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, checksum, image, containerFormat, diskFormat, minDisk, minRam, size,
                operatingSystem, virtualizationEnvironment);
    }

}
