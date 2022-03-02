package eu.palantir.catalogue.model.vnf;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import eu.palantir.catalogue.model.integrity.CheckSum;
import eu.palantir.catalogue.model.virtualization.CPUArchitecture;
import eu.palantir.catalogue.model.virtualization.ContainerFormat;
import eu.palantir.catalogue.model.virtualization.DiskFormat;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Entity
public class VnfSoftwareImageDescription extends PanacheMongoEntityBase {

    @Id
    private String id;

    private String name;

    private String version;

    private CheckSum checksum;

    private URI image;

    private ContainerFormat containerFormat;

    private CPUArchitecture cpuArchitecture;

    private Integer minCpus;

    private DiskFormat diskFormat;

    private Integer minDisk;

    private Float minRam;

    private Integer size;

    private String operatingSystem;

    private List<String> virtualizationEnvironment;

    public VnfSoftwareImageDescription() {
    }

    public VnfSoftwareImageDescription(String id, String name, String version, CheckSum checksum, URI image,
            ContainerFormat containerFormat, CPUArchitecture cpuArchitecture, Integer minCpus, DiskFormat diskFormat,
            Integer minDisk, Float minRam, Integer size, String operatingSystem,
            List<String> virtualizationEnvironment) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.checksum = checksum;
        this.image = image;
        this.containerFormat = containerFormat;
        this.cpuArchitecture = cpuArchitecture;
        this.minCpus = minCpus;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CheckSum getChecksum() {
        return this.checksum;
    }

    public void setChecksum(CheckSum checksum) {
        this.checksum = checksum;
    }

    public URI getImage() {
        return this.image;
    }

    public void setImage(URI image) {
        this.image = image;
    }

    public ContainerFormat getContainerFormat() {
        return this.containerFormat;
    }

    public void setContainerFormat(ContainerFormat containerFormat) {
        this.containerFormat = containerFormat;
    }

    public CPUArchitecture getCpuArchitecture() {
        return this.cpuArchitecture;
    }

    public void setCpuArchitecture(CPUArchitecture cpuArchitecture) {
        this.cpuArchitecture = cpuArchitecture;
    }

    public Integer getMinCpus() {
        return this.minCpus;
    }

    public void setMinCpus(Integer minCpus) {
        this.minCpus = minCpus;
    }

    public DiskFormat getDiskFormat() {
        return this.diskFormat;
    }

    public void setDiskFormat(DiskFormat diskFormat) {
        this.diskFormat = diskFormat;
    }

    public Integer getMinDisk() {
        return this.minDisk;
    }

    public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    public Float getMinRam() {
        return this.minRam;
    }

    public void setMinRam(Float minRam) {
        this.minRam = minRam;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<String> getVirtualizationEnvironment() {
        return this.virtualizationEnvironment;
    }

    public void setVirtualizationEnvironment(List<String> virtualizationEnvironment) {
        this.virtualizationEnvironment = virtualizationEnvironment;
    }

    public VnfSoftwareImageDescription id(String id) {
        setId(id);
        return this;
    }

    public VnfSoftwareImageDescription name(String name) {
        setName(name);
        return this;
    }

    public VnfSoftwareImageDescription version(String version) {
        setVersion(version);
        return this;
    }

    public VnfSoftwareImageDescription checksum(CheckSum checksum) {
        setChecksum(checksum);
        return this;
    }

    public VnfSoftwareImageDescription image(URI image) {
        setImage(image);
        return this;
    }

    public VnfSoftwareImageDescription containerFormat(ContainerFormat containerFormat) {
        setContainerFormat(containerFormat);
        return this;
    }

    public VnfSoftwareImageDescription cpuArchitecture(CPUArchitecture cpuArchitecture) {
        setCpuArchitecture(cpuArchitecture);
        return this;
    }

    public VnfSoftwareImageDescription minCpus(Integer minCpus) {
        setMinCpus(minCpus);
        return this;
    }

    public VnfSoftwareImageDescription diskFormat(DiskFormat diskFormat) {
        setDiskFormat(diskFormat);
        return this;
    }

    public VnfSoftwareImageDescription minDisk(Integer minDisk) {
        setMinDisk(minDisk);
        return this;
    }

    public VnfSoftwareImageDescription minRam(Float minRam) {
        setMinRam(minRam);
        return this;
    }

    public VnfSoftwareImageDescription size(Integer size) {
        setSize(size);
        return this;
    }

    public VnfSoftwareImageDescription operatingSystem(String operatingSystem) {
        setOperatingSystem(operatingSystem);
        return this;
    }

    public VnfSoftwareImageDescription virtualizationEnvironment(List<String> virtualizationEnvironment) {
        setVirtualizationEnvironment(virtualizationEnvironment);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfSoftwareImageDescription)) {
            return false;
        }
        VnfSoftwareImageDescription vnfSoftwareImageDescription = (VnfSoftwareImageDescription) o;
        return Objects.equals(id, vnfSoftwareImageDescription.id)
                && Objects.equals(name, vnfSoftwareImageDescription.name)
                && Objects.equals(version, vnfSoftwareImageDescription.version)
                && Objects.equals(checksum, vnfSoftwareImageDescription.checksum)
                && Objects.equals(image, vnfSoftwareImageDescription.image)
                && Objects.equals(containerFormat, vnfSoftwareImageDescription.containerFormat)
                && Objects.equals(cpuArchitecture, vnfSoftwareImageDescription.cpuArchitecture)
                && Objects.equals(minCpus, vnfSoftwareImageDescription.minCpus)
                && Objects.equals(diskFormat, vnfSoftwareImageDescription.diskFormat)
                && Objects.equals(minDisk, vnfSoftwareImageDescription.minDisk)
                && Objects.equals(minRam, vnfSoftwareImageDescription.minRam)
                && Objects.equals(size, vnfSoftwareImageDescription.size)
                && Objects.equals(operatingSystem, vnfSoftwareImageDescription.operatingSystem)
                && Objects.equals(virtualizationEnvironment, vnfSoftwareImageDescription.virtualizationEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, checksum, image, containerFormat, cpuArchitecture, minCpus, diskFormat,
                minDisk, minRam, size, operatingSystem, virtualizationEnvironment);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", version='" + getVersion() + "'" +
                ", checksum='" + getChecksum() + "'" +
                ", image='" + getImage() + "'" +
                ", containerFormat='" + getContainerFormat() + "'" +
                ", cpuArchitecture='" + getCpuArchitecture() + "'" +
                ", minCpus='" + getMinCpus() + "'" +
                ", diskFormat='" + getDiskFormat() + "'" +
                ", minDisk='" + getMinDisk() + "'" +
                ", minRam='" + getMinRam() + "'" +
                ", size='" + getSize() + "'" +
                ", operatingSystem='" + getOperatingSystem() + "'" +
                ", virtualizationEnvironment='" + getVirtualizationEnvironment() + "'" +
                "}";
    }

}
