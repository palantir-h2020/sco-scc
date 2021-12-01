package eu.palantir.catalogue.dto.search;

import java.time.Duration;
import java.util.Objects;

public class DurationRangeDto {

    private final Duration min;
    private final Duration max;

    public DurationRangeDto(Duration min, Duration max) {
        this.min = min;
        this.max = max;
    }

    public Duration getMin() {
        return this.min;
    }

    public Duration getMax() {
        return this.max;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DurationRangeDto)) {
            return false;
        }
        DurationRangeDto durationRange = (DurationRangeDto) o;
        return Objects.equals(min, durationRange.min) && Objects.equals(max, durationRange.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

}
