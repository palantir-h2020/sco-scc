package eu.palantir.catalogue.dto.search;

import java.util.Objects;

public class FloatRangeDto {

    private final Float min;
    private final Float max;

    public FloatRangeDto(Float min, Float max) {
        this.min = min;
        this.max = max;
    }

    public Float getMin() {
        return this.min;
    }

    public Float getMax() {
        return this.max;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FloatRangeDto)) {
            return false;
        }
        FloatRangeDto floatRange = (FloatRangeDto) o;
        return Objects.equals(min, floatRange.min) && Objects.equals(max, floatRange.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

}
