package eu.palantir.catalogue.dto.search;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

public class StringSearchDto {

    @NotEmpty
    private final StringSearchType searchType;

    private final String value;

    public StringSearchDto(StringSearchType searchType, String value) {
        this.searchType = searchType;
        this.value = value;
    }

    public StringSearchType getSearchType() {
        return this.searchType;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StringSearchDto)) {
            return false;
        }
        StringSearchDto stringSearch = (StringSearchDto) o;
        return Objects.equals(searchType, stringSearch.searchType) && Objects.equals(value, stringSearch.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchType, value);
    }

}
