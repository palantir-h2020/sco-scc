package eu.palantir.catalogue.model;

import eu.palantir.catalogue.model.billing.SCBillingSLA;
import eu.palantir.catalogue.model.security.SCSecurity;
import eu.palantir.catalogue.model.vnf.VnfDescriptors;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Objects;
import java.util.UUID;

@MongoEntity
public class SecurityCapability {

    @BsonId
    private UUID id;

    private SecurityCapabilityStatus status;

    private String xnfId;

    private String nsId;

    private VnfDescriptors vnf;

    private SCSecurity security;

    private SCBillingSLA billingSLA;

    public SecurityCapability() {
    }

    public SecurityCapability(UUID id, SecurityCapabilityStatus status, String xnfId, String nsId, VnfDescriptors vnf,
            SCSecurity security, SCBillingSLA billingSLA) {
        this.id = id;
        this.status = status;
        this.xnfId = xnfId;
        this.nsId = nsId;
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SecurityCapabilityStatus getStatus() {
        return this.status;
    }

    public void setStatus(SecurityCapabilityStatus status) {
        this.status = status;
    }

    public String getXnfId() {
        return this.xnfId;
    }

    public void setXnfId(String xnfId) {
        this.xnfId = xnfId;
    }

    public String getNsId() {
        return this.nsId;
    }

    public void setNsId(String nsId) {
        this.nsId = nsId;
    }

    public VnfDescriptors getVnf() {
        return this.vnf;
    }

    public void setVnf(VnfDescriptors vnf) {
        this.vnf = vnf;
    }

    public SCSecurity getSecurity() {
        return this.security;
    }

    public void setSecurity(SCSecurity security) {
        this.security = security;
    }

    public SCBillingSLA getBillingSLA() {
        return this.billingSLA;
    }

    public void setBillingSLA(SCBillingSLA billingSLA) {
        this.billingSLA = billingSLA;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapability)) {
            return false;
        }
        SecurityCapability securityCapability = (SecurityCapability) o;
        return Objects.equals(id, securityCapability.id) && Objects.equals(status, securityCapability.status)
                && Objects.equals(xnfId, securityCapability.xnfId) && Objects.equals(nsId, securityCapability.nsId)
                && Objects.equals(vnf, securityCapability.vnf) && Objects.equals(security, securityCapability.security)
                && Objects.equals(billingSLA, securityCapability.billingSLA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, xnfId, nsId, vnf, security, billingSLA);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", status='" + getStatus() + "'" +
                ", xnfId='" + getXnfId() + "'" +
                ", nsId='" + getNsId() + "'" +
                ", vnf='" + getVnf() + "'" +
                ", security='" + getSecurity() + "'" +
                ", billingSLA='" + getBillingSLA() + "'" +
                "}";
    }

}
