package eu.palantir.catalogue.model.security;

import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;
import java.util.Objects;

@MongoEntity
public class SCSecurity {

    private List<PalantirDeploymentModel> deploymentModels;

    private List<String> detectionMethods;

    private List<String> mitigationMethods;

    private List<String> controlDataTypes;

    private List<String> monitorDataTypes;

    private List<String> threatProtections;

    public SCSecurity() {
    }

    public SCSecurity(List<PalantirDeploymentModel> deploymentModels, List<String> detectionMethods,
            List<String> mitigationMethods, List<String> controlDataTypes, List<String> monitorDataTypes,
            List<String> threatProtections) {
        this.deploymentModels = deploymentModels;
        this.detectionMethods = detectionMethods;
        this.mitigationMethods = mitigationMethods;
        this.controlDataTypes = controlDataTypes;
        this.monitorDataTypes = monitorDataTypes;
        this.threatProtections = threatProtections;
    }

    public List<PalantirDeploymentModel> getDeploymentModels() {
        return this.deploymentModels;
    }

    public void setDeploymentModels(List<PalantirDeploymentModel> deploymentModels) {
        this.deploymentModels = deploymentModels;
    }

    public List<String> getDetectionMethods() {
        return this.detectionMethods;
    }

    public void setDetectionMethods(List<String> detectionMethods) {
        this.detectionMethods = detectionMethods;
    }

    public List<String> getMitigationMethods() {
        return this.mitigationMethods;
    }

    public void setMitigationMethods(List<String> mitigationMethods) {
        this.mitigationMethods = mitigationMethods;
    }

    public List<String> getControlDataTypes() {
        return this.controlDataTypes;
    }

    public void setControlDataTypes(List<String> controlDataTypes) {
        this.controlDataTypes = controlDataTypes;
    }

    public List<String> getMonitorDataTypes() {
        return this.monitorDataTypes;
    }

    public void setMonitorDataTypes(List<String> monitorDataTypes) {
        this.monitorDataTypes = monitorDataTypes;
    }

    public List<String> getThreatProtections() {
        return this.threatProtections;
    }

    public void setThreatProtections(List<String> threatProtections) {
        this.threatProtections = threatProtections;
    }

    public SCSecurity deploymentModels(List<PalantirDeploymentModel> deploymentModels) {
        setDeploymentModels(deploymentModels);
        return this;
    }

    public SCSecurity detectionMethods(List<String> detectionMethods) {
        setDetectionMethods(detectionMethods);
        return this;
    }

    public SCSecurity mitigationMethods(List<String> mitigationMethods) {
        setMitigationMethods(mitigationMethods);
        return this;
    }

    public SCSecurity controlDataTypes(List<String> controlDataTypes) {
        setControlDataTypes(controlDataTypes);
        return this;
    }

    public SCSecurity monitorDataTypes(List<String> monitorDataTypes) {
        setMonitorDataTypes(monitorDataTypes);
        return this;
    }

    public SCSecurity threatProtections(List<String> threatProtections) {
        setThreatProtections(threatProtections);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCSecurity)) {
            return false;
        }
        SCSecurity sCSecurity = (SCSecurity) o;
        return Objects.equals(deploymentModels, sCSecurity.deploymentModels)
                && Objects.equals(detectionMethods, sCSecurity.detectionMethods)
                && Objects.equals(mitigationMethods, sCSecurity.mitigationMethods)
                && Objects.equals(controlDataTypes, sCSecurity.controlDataTypes)
                && Objects.equals(monitorDataTypes, sCSecurity.monitorDataTypes)
                && Objects.equals(threatProtections, sCSecurity.threatProtections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentModels, detectionMethods, mitigationMethods, controlDataTypes, monitorDataTypes,
                threatProtections);
    }

    @Override
    public String toString() {
        return "{" +
                " deploymentModels='" + getDeploymentModels() + "'" +
                ", detectionMethods='" + getDetectionMethods() + "'" +
                ", mitigationMethods='" + getMitigationMethods() + "'" +
                ", controlDataTypes='" + getControlDataTypes() + "'" +
                ", monitorDataTypes='" + getMonitorDataTypes() + "'" +
                ", threatProtections='" + getThreatProtections() + "'" +
                "}";
    }

}
