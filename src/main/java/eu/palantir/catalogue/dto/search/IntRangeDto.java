package eu.palantir.catalogue.dto.search;

import java.util.Objects;

public class IntRangeDto {

    private final Integer min;

    private final Integer max;

    public IntRangeDto(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return this.min;
    }

    public Integer getMax() {
        return this.max;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof IntRangeDto)) {
            return false;
        }
        IntRangeDto intRange = (IntRangeDto) o;
        return Objects.equals(min, intRange.min) && Objects.equals(max, intRange.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

}
