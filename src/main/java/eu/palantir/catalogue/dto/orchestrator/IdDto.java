package eu.palantir.catalogue.dto.orchestrator;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class IdDto {
    @NotNull
    private UUID id;

    public IdDto() {
    }

    public IdDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof IdDto)) {
            return false;
        }
        IdDto idDto = (IdDto) o;
        return Objects.equals(id, idDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                "}";
    }

}
