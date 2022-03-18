package eu.palantir.catalogue.model.vnf;

import eu.palantir.catalogue.model.network.EtherType;
import eu.palantir.catalogue.model.network.TrafficDirection;
import eu.palantir.catalogue.model.network.TransportProtocol;

import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@MongoEntity
public class VnfSecurityGroupRule {

    @Id
    private String id;

    private String description;

    private TrafficDirection direction;

    @Enumerated(EnumType.STRING)
    private EtherType etherType;

    @Enumerated(EnumType.STRING)
    private TransportProtocol protocol;

    private Integer minPort;

    private Integer maxPort;

    public VnfSecurityGroupRule() {
    }

    public VnfSecurityGroupRule(String id, String description, TrafficDirection direction, EtherType etherType,
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

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrafficDirection getDirection() {
        return this.direction;
    }

    public void setDirection(TrafficDirection direction) {
        this.direction = direction;
    }

    public EtherType getEtherType() {
        return this.etherType;
    }

    public void setEtherType(EtherType etherType) {
        this.etherType = etherType;
    }

    public TransportProtocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(TransportProtocol protocol) {
        this.protocol = protocol;
    }

    public Integer getMinPort() {
        return this.minPort;
    }

    public void setMinPort(Integer minPort) {
        this.minPort = minPort;
    }

    public Integer getMaxPort() {
        return this.maxPort;
    }

    public void setMaxPort(Integer maxPort) {
        this.maxPort = maxPort;
    }

    public VnfSecurityGroupRule id(String id) {
        setId(id);
        return this;
    }

    public VnfSecurityGroupRule description(String description) {
        setDescription(description);
        return this;
    }

    public VnfSecurityGroupRule direction(TrafficDirection direction) {
        setDirection(direction);
        return this;
    }

    public VnfSecurityGroupRule etherType(EtherType etherType) {
        setEtherType(etherType);
        return this;
    }

    public VnfSecurityGroupRule protocol(TransportProtocol protocol) {
        setProtocol(protocol);
        return this;
    }

    public VnfSecurityGroupRule minPort(Integer minPort) {
        setMinPort(minPort);
        return this;
    }

    public VnfSecurityGroupRule maxPort(Integer maxPort) {
        setMaxPort(maxPort);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VnfSecurityGroupRule)) {
            return false;
        }
        VnfSecurityGroupRule vnfSecurityGroupRule = (VnfSecurityGroupRule) o;
        return Objects.equals(id, vnfSecurityGroupRule.id)
                && Objects.equals(description, vnfSecurityGroupRule.description)
                && Objects.equals(direction, vnfSecurityGroupRule.direction)
                && Objects.equals(etherType, vnfSecurityGroupRule.etherType)
                && Objects.equals(protocol, vnfSecurityGroupRule.protocol)
                && Objects.equals(minPort, vnfSecurityGroupRule.minPort)
                && Objects.equals(maxPort, vnfSecurityGroupRule.maxPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, direction, etherType, protocol, minPort, maxPort);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", description='" + getDescription() + "'" +
                ", direction='" + getDirection() + "'" +
                ", etherType='" + getEtherType() + "'" +
                ", protocol='" + getProtocol() + "'" +
                ", minPort='" + getMinPort() + "'" +
                ", maxPort='" + getMaxPort() + "'" +
                "}";
    }

}
