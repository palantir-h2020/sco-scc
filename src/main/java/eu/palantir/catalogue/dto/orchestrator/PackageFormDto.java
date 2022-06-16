package eu.palantir.catalogue.dto.orchestrator;

import java.io.InputStream;
import java.util.Objects;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class PackageFormDto {

    @FormParam("package")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream packageFile;
    // @PartType(MediaType.TEXT_PLAIN)
    // private String packageFile;

    public PackageFormDto() {
    }

    public PackageFormDto(InputStream packageFile) {
        this.packageFile = packageFile;
    }

    public InputStream getPackageFile() {
        return this.packageFile;
    }

    public void setPackageFile(InputStream packageFile) {
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
