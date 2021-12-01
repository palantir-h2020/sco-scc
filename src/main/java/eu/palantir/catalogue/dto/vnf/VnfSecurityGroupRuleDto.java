package eu.palantir.catalogue.dto.vnf;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.palantir.catalogue.model.network.EtherType;
import eu.palantir.catalogue.model.network.TrafficDirection;
import eu.palantir.catalogue.model.network.TransportProtocol;
import io.smallrye.common.constraint.NotNull;

public class VnfSecurityGroupRuleDto {

    @NotBlank
    private final String id;

    @NotBlank
    private final String description;

    @NotNull
    private final TrafficDirection direction;

    @NotNull
    @JsonProperty("ether-type")
    private final EtherType etherType;

    @NotNull
    private final TransportProtocol protocol;

    @NotNull
    @Min(1)
    @Max(65535)
    private final Integer minPort;

    @NotNull
    @Min(1)
    @Max(65535)
    private final Integer maxPort;

    public VnfSecurityGroupRuleDto(String id, String description, TrafficDirection direction, EtherType etherType,
            TransportProtocol protocol, Integer minPort, Integer maxPort) {
        this.id = id;
        this.description = description;
        this.direction = direction;
        this.etherType = etherType;
        this.protocol = protocol;
        this.minPort = minPort;
        this.maxPort = maxPort;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public TrafficDirection getDirection() {
        return this.direction;
    }

    public EtherType getEtherType() {
        return this.etherType;
    }

    public TransportProtocol getProtocol() {
        return this.protocol;
    }

    public Integer getMinPort() {
        return this.minPort;
    }

    public Integer getMaxPort() {
        return this.maxPort;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfSecurityGroupRuleDto)) {
            return false;
        }
        VnfSecurityGroupRuleDto vnfSecurityGroupRuleDto = (VnfSecurityGroupRuleDto) o;
        return Objects.equals(id, vnfSecurityGroupRuleDto.id)
                && Objects.equals(description, vnfSecurityGroupRuleDto.description)
                && Objects.equals(direction, vnfSecurityGroupRuleDto.direction)
                && Objects.equals(etherType, vnfSecurityGroupRuleDto.etherType)
                && Objects.equals(protocol, vnfSecurityGroupRuleDto.protocol)
                && Objects.equals(minPort, vnfSecurityGroupRuleDto.minPort)
                && Objects.equals(maxPort, vnfSecurityGroupRuleDto.maxPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, direction, etherType, protocol, minPort, maxPort);
    }

}
