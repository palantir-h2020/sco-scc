package eu.palantir.catalogue.dto.security;

import java.util.List;
import java.util.Objects;

import eu.palantir.catalogue.dto.search.StringSearchDto;
import eu.palantir.catalogue.model.security.PalantirDeploymentModel;

public class SCSecuritySearchDto {

    private final List<PalantirDeploymentModel> deploymentModels;

    private final List<StringSearchDto> detectionMethods;

    private final List<StringSearchDto> mitigationMethods;

    private final List<StringSearchDto> controlDataTypes;

    private final List<StringSearchDto> monitorDataTypes;

    private final List<StringSearchDto> threatProtections;

    public SCSecuritySearchDto(List<PalantirDeploymentModel> deploymentModels, List<StringSearchDto> detectionMethods,
            List<StringSearchDto> mitigationMethods, List<StringSearchDto> controlDataTypes,
            List<StringSearchDto> monitorDataTypes, List<StringSearchDto> threatProtections) {
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

    public List<StringSearchDto> getDetectionMethods() {
        return this.detectionMethods;
    }

    public List<StringSearchDto> getMitigationMethods() {
        return this.mitigationMethods;
    }

    public List<StringSearchDto> getControlDataTypes() {
        return this.controlDataTypes;
    }

    public List<StringSearchDto> getMonitorDataTypes() {
        return this.monitorDataTypes;
    }

    public List<StringSearchDto> getThreatProtections() {
        return this.threatProtections;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCSecuritySearchDto)) {
            return false;
        }
        SCSecuritySearchDto sCSecuritySearchDto = (SCSecuritySearchDto) o;
        return Objects.equals(deploymentModels, sCSecuritySearchDto.deploymentModels)
                && Objects.equals(detectionMethods, sCSecuritySearchDto.detectionMethods)
                && Objects.equals(mitigationMethods, sCSecuritySearchDto.mitigationMethods)
                && Objects.equals(controlDataTypes, sCSecuritySearchDto.controlDataTypes)
                && Objects.equals(monitorDataTypes, sCSecuritySearchDto.monitorDataTypes)
                && Objects.equals(threatProtections, sCSecuritySearchDto.threatProtections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentModels, detectionMethods, mitigationMethods, controlDataTypes, monitorDataTypes,
                threatProtections);
    }

}
