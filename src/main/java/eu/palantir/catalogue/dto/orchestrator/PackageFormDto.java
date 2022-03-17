package eu.palantir.catalogue.dto.orchestrator;

import java.util.Objects;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class PackageFormDto {

    // CHANGE LATER INTO
    // @PartType(MediaType.APPLICATION_OCTET_STREAM)
    // public InputStream file;
    @FormParam("package")
    @PartType(MediaType.TEXT_PLAIN)
    private String packageFile;

    public PackageFormDto() {
    }

    public PackageFormDto(String packageFile) {
        this.packageFile = packageFile;
    }

    public String getPackageFile() {
        return this.packageFile;
    }

    public void setPackageFile(String packageFile) {
        this.packageFile = packageFile;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PackageFormDto)) {
            return false;
        }
        PackageFormDto packageFormDto = (PackageFormDto) o;
        return Objects.equals(packageFile, packageFormDto.packageFile);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(packageFile);
    }

    @Override
    public String toString() {
        return "{" +
                " packageFile='" + getPackageFile() + "'" +
                "}";
    }

}
