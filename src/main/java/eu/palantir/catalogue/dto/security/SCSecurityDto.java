package eu.palantir.catalogue.dto.security;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import eu.palantir.catalogue.model.security.PalantirDeploymentModel;
import eu.palantir.catalogue.validation.NotEmptyFields;

public class SCSecurityDto {

    @NotEmpty
    private final List<PalantirDeploymentModel> deploymentModels;

    @NotEmptyFields
    private final List<String> detectionMethods;

    @NotEmptyFields
    private final List<String> mitigationMethods;

    @NotEmptyFields
    private final List<String> controlDataTypes;

    @NotEmptyFields
    private final List<String> monitorDataTypes;

    private final List<String> threatProtections;

    public SCSecurityDto(List<PalantirDeploymentModel> deploymentModels, List<String> detectionMethods,
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

    public List<String> getDetectionMethods() {
        return this.detectionMethods;
    }

    public List<String> getMitigationMethods() {
        return this.mitigationMethods;
    }

    public List<String> getControlDataTypes() {
        return this.controlDataTypes;
    }

    public List<String> getMonitorDataTypes() {
        return this.monitorDataTypes;
    }

    public List<String> getThreatProtections() {
        return this.threatProtections;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCSecurityDto)) {
            return false;
        }
        SCSecurityDto sCSecurityDto = (SCSecurityDto) o;
        return Objects.equals(deploymentModels, sCSecurityDto.deploymentModels)
                && Objects.equals(detectionMethods, sCSecurityDto.detectionMethods)
                && Objects.equals(mitigationMethods, sCSecurityDto.mitigationMethods)
                && Objects.equals(controlDataTypes, sCSecurityDto.controlDataTypes)
                && Objects.equals(monitorDataTypes, sCSecurityDto.monitorDataTypes)
                && Objects.equals(threatProtections, sCSecurityDto.threatProtections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentModels, detectionMethods, mitigationMethods, controlDataTypes, monitorDataTypes,
                threatProtections);
    }

}
