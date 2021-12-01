package eu.palantir.catalogue.dto.vnf;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.palantir.catalogue.dto.search.FloatRangeDto;
import eu.palantir.catalogue.dto.search.IntRangeDto;
import eu.palantir.catalogue.dto.search.StringSearchDto;
import eu.palantir.catalogue.model.virtualization.ContainerFormat;
import eu.palantir.catalogue.model.virtualization.DiskFormat;

public class VnfSearchDto {

    private final StringSearchDto name;

    private final StringSearchDto provider;

    private final StringSearchDto version;

    @JsonProperty("product-info-name")
    private final StringSearchDto productInfoName;

    @JsonProperty("product-info-description")
    private final StringSearchDto productInfoDescription;

    @JsonProperty("container-format")
    private final List<ContainerFormat> containerFormat;

    @JsonProperty("disk-format")
    private final List<DiskFormat> diskFormat;

    @Min(0)
    @JsonProperty("min-disk")
    private final IntRangeDto minDisk;

    @Min(0)
    @JsonProperty("min-ram")
    private final FloatRangeDto minRam;

    @Min(0)
    private final IntRangeDto size;

    @JsonProperty("operating-system")
    private final List<StringSearchDto> operatingSystem;

    @JsonProperty("supported-virtualization-environment")
    private final List<StringSearchDto> virtualizationEnvironment;

    public VnfSearchDto(StringSearchDto name, StringSearchDto provider, StringSearchDto version,
            StringSearchDto productInfoName, StringSearchDto productInfoDescription,
            List<ContainerFormat> containerFormat, List<DiskFormat> diskFormat, IntRangeDto minDisk,
            FloatRangeDto minRam, IntRangeDto size, List<StringSearchDto> operatingSystem,
            List<StringSearchDto> virtualizationEnvironment) {
        this.name = name;
        this.provider = provider;
        this.version = version;
        this.productInfoName = productInfoName;
        this.productInfoDescription = productInfoDescription;
        this.containerFormat = containerFormat;
        this.diskFormat = diskFormat;
        this.minDisk = minDisk;
        this.minRam = minRam;
        this.size = size;
        this.operatingSystem = operatingSystem;
        this.virtualizationEnvironment = virtualizationEnvironment;
    }

    public StringSearchDto getName() {
        return this.name;
    }

    public StringSearchDto getProvider() {
        return this.provider;
    }

    public StringSearchDto getVersion() {
        return this.version;
    }

    public StringSearchDto getProductInfoName() {
        return this.productInfoName;
    }

    public StringSearchDto getProductInfoDescription() {
        return this.productInfoDescription;
    }

    public List<ContainerFormat> getContainerFormat() {
        return this.containerFormat;
    }

    public List<DiskFormat> getDiskFormat() {
        return this.diskFormat;
    }

    public IntRangeDto getMinDisk() {
        return this.minDisk;
    }

    public FloatRangeDto getMinRam() {
        return this.minRam;
    }

    public IntRangeDto getSize() {
        return this.size;
    }

    public List<StringSearchDto> getOperatingSystem() {
        return this.operatingSystem;
    }

    public List<StringSearchDto> getVirtualizationEnvironment() {
        return this.virtualizationEnvironment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfSearchDto)) {
            return false;
        }
        VnfSearchDto vnfSearchDto = (VnfSearchDto) o;
        return Objects.equals(name, vnfSearchDto.name) && Objects.equals(provider, vnfSearchDto.provider)
                && Objects.equals(version, vnfSearchDto.version)
                && Objects.equals(productInfoName, vnfSearchDto.productInfoName)
                && Objects.equals(productInfoDescription, vnfSearchDto.productInfoDescription)
                && Objects.equals(containerFormat, vnfSearchDto.containerFormat)
                && Objects.equals(diskFormat, vnfSearchDto.diskFormat) && Objects.equals(minDisk, vnfSearchDto.minDisk)
                && Objects.equals(minRam, vnfSearchDto.minRam) && Objects.equals(size, vnfSearchDto.size)
                && Objects.equals(operatingSystem, vnfSearchDto.operatingSystem)
                && Objects.equals(virtualizationEnvironment, vnfSearchDto.virtualizationEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, provider, version, productInfoName, productInfoDescription, containerFormat,
                diskFormat, minDisk, minRam, size, operatingSystem, virtualizationEnvironment);
    }

}
