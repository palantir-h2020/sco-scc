package eu.palantir.catalogue.model.job;

import java.util.Objects;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity
public class OnboardingJob {

    @BsonId
    private String id;

    private JobStatus jobStatus;

    public OnboardingJob() {
    }

    public OnboardingJob(String id, JobStatus jobStatus) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OnboardingJob)) {
            return false;
        }
        OnboardingJob onboardingJob = (OnboardingJob) o;
        return Objects.equals(id, onboardingJob.id) && Objects.equals(jobStatus, onboardingJob.jobStatus);
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
