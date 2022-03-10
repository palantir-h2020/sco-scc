package eu.palantir.catalogue.model;

import eu.palantir.catalogue.model.billing.SCBillingSLA;
import eu.palantir.catalogue.model.security.SCSecurity;
import eu.palantir.catalogue.model.vnf.VnfDescriptors;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.UUID;

@MongoEntity
public class SecurityCapability {

    @BsonId
    private UUID id;

    private SecurityCapabilityStatus status;

    private VnfDescriptors vnf;

    private SCSecurity security;

    private SCBillingSLA billingSLA;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SecurityCapabilityStatus getStatus() {
        return status;
    }

    public void setStatus(SecurityCapabilityStatus status) {
        this.status = status;
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

    public SecurityCapability id(UUID id) {
        setId(id);
        return this;
    }

    public SecurityCapability vnf(VnfDescriptors vnf) {
        setVnf(vnf);
        return this;
    }

    public SecurityCapability security(SCSecurity security) {
        setSecurity(security);
        return this;
    }

    public SecurityCapability billingSLA(SCBillingSLA billingSLA) {
        setBillingSLA(billingSLA);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                " status='" + getStatus() + "'" +
                ", vnf='" + getVnf() + "'" +
                ", security='" + getSecurity() + "'" +
                ", billingSLA='" + getBillingSLA() + "'" +
                "}";
    }
}
