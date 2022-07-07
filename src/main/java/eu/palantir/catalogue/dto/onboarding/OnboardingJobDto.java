package eu.palantir.catalogue.dto.onboarding;

import java.util.Objects;

import eu.palantir.catalogue.model.job.JobStatus;

public class OnboardingJobDto {

    private String id;

    private JobStatus jobStatus;

    public OnboardingJobDto() {
    }

    public OnboardingJobDto(String id, JobStatus jobStatus) {
        this.id = id;
        this.jobStatus = jobStatus;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobStatus getJobStatus() {
        return this.jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public OnboardingJobDto id(String id) {
        setId(id);
        return this;
    }

    public OnboardingJobDto jobStatus(JobStatus jobStatus) {
        setJobStatus(jobStatus);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OnboardingJobDto)) {
            return false;
        }
        OnboardingJobDto onboardingJobDto = (OnboardingJobDto) o;
        return Objects.equals(id, onboardingJobDto.id) && Objects.equals(jobStatus, onboardingJobDto.jobStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobStatus);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", jobStatus='" + getJobStatus() + "'" +
                "}";
    }

}
