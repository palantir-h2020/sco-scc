package eu.palantir.catalogue.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import eu.palantir.catalogue.model.billing.SCBillingSLA;
import eu.palantir.catalogue.model.integrity.SCIntegrity;
import eu.palantir.catalogue.model.privacy.SCPrivacy;
import eu.palantir.catalogue.model.security.SCSecurity;
import eu.palantir.catalogue.model.vnf.VnfDescriptors;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Entity
public class SecurityCapability extends PanacheMongoEntityBase {

    @Id
    private UUID id;

    private VnfDescriptors vnf;

    private SCSecurity security;

    private SCBillingSLA billingSLA;

    // CHANGE: Enforce it when integrity descriptors are agreed.
    private SCIntegrity integrity;

    // CHANGE: Enforce it when privacy descriptors are agreed.
    private SCPrivacy privacy;

    public SecurityCapability() {
    }

    public SecurityCapability(UUID id, VnfDescriptors vnf, SCSecurity security, SCBillingSLA billingSLA,
            SCIntegrity integrity, SCPrivacy privacy) {
        this.id = id;
        this.vnf = vnf;
        this.security = security;
        this.billingSLA = billingSLA;
        this.integrity = integrity;
        this.privacy = privacy;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public SCIntegrity getIntegrity() {
        return this.integrity;
    }

    public void setIntegrity(SCIntegrity integrity) {
        this.integrity = integrity;
    }

    public SCPrivacy getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(SCPrivacy privacy) {
        this.privacy = privacy;
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

    public SecurityCapability integrity(SCIntegrity integrity) {
        setIntegrity(integrity);
        return this;
    }

    public SecurityCapability privacy(SCPrivacy privacy) {
        setPrivacy(privacy);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SecurityCapability)) {
            return false;
        }
        SecurityCapability securityCapability = (SecurityCapability) o;
        return Objects.equals(id, securityCapability.id) && Objects.equals(vnf, securityCapability.vnf)
                && Objects.equals(security, securityCapability.security)
                && Objects.equals(billingSLA, securityCapability.billingSLA)
                && Objects.equals(integrity, securityCapability.integrity)
                && Objects.equals(privacy, securityCapability.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vnf, security, billingSLA, integrity, privacy);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", vnf='" + getVnf() + "'" +
                ", security='" + getSecurity() + "'" +
                ", billingSLA='" + getBillingSLA() + "'" +
                ", integrity='" + getIntegrity() + "'" +
                ", privacy='" + getPrivacy() + "'" +
                "}";
    }

}
