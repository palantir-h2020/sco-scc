package eu.palantir.catalogue.model.billing;

import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;
import java.util.Objects;

@MongoEntity
public class SCBillingSLA {

    protected List<BillingModelType> billingModel;

    protected Float subscriptionBilling;

    protected Float instanceBilling;

    protected Float hourlyBilling;

    protected Integer slaDowntime; // Measured in minutes

    protected Float slaViolationFee;

    public SCBillingSLA() {
    }

    public SCBillingSLA(List<BillingModelType> billingModel, Float subscriptionBilling, Float instanceBilling,
            Float hourlyBilling, Integer slaDowntime, Float slaViolationFee) {
        this.billingModel = billingModel;
        this.subscriptionBilling = subscriptionBilling;
        this.instanceBilling = instanceBilling;
        this.hourlyBilling = hourlyBilling;
        this.slaDowntime = slaDowntime;
        this.slaViolationFee = slaViolationFee;
    }

    public List<BillingModelType> getBillingModel() {
        return this.billingModel;
    }

    public void setBillingModel(List<BillingModelType> billingModel) {
        this.billingModel = billingModel;
    }

    public Float getSubscriptionBilling() {
        return this.subscriptionBilling;
    }

    public void setSubscriptionBilling(Float subscriptionBilling) {
        this.subscriptionBilling = subscriptionBilling;
    }

    public Float getInstanceBilling() {
        return this.instanceBilling;
    }

    public void setInstanceBilling(Float instanceBilling) {
        this.instanceBilling = instanceBilling;
    }

    public Float getHourlyBilling() {
        return this.hourlyBilling;
    }

    public void setHourlyBilling(Float hourlyBilling) {
        this.hourlyBilling = hourlyBilling;
    }

    public Integer getSlaDowntime() {
        return this.slaDowntime;
    }

    public void setSlaDowntime(Integer slaDowntime) {
        this.slaDowntime = slaDowntime;
    }

    public Float getSlaViolationFee() {
        return this.slaViolationFee;
    }

    public void setSlaViolationFee(Float slaViolationFee) {
        this.slaViolationFee = slaViolationFee;
    }

    public SCBillingSLA billingModel(List<BillingModelType> billingModel) {
        setBillingModel(billingModel);
        return this;
    }

    public SCBillingSLA subscriptionBilling(Float subscriptionBilling) {
        setSubscriptionBilling(subscriptionBilling);
        return this;
    }

    public SCBillingSLA instanceBilling(Float instanceBilling) {
        setInstanceBilling(instanceBilling);
        return this;
    }

    public SCBillingSLA hourlyBilling(Float hourlyBilling) {
        setHourlyBilling(hourlyBilling);
        return this;
    }

    public SCBillingSLA slaDowntime(Integer slaDowntime) {
        setSlaDowntime(slaDowntime);
        return this;
    }

    public SCBillingSLA slaViolationFee(Float slaViolationFee) {
        setSlaViolationFee(slaViolationFee);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCBillingSLA)) {
            return false;
        }
        SCBillingSLA sCBillingSLA = (SCBillingSLA) o;
        return Objects.equals(billingModel, sCBillingSLA.billingModel)
                && Objects.equals(subscriptionBilling, sCBillingSLA.subscriptionBilling)
                && Objects.equals(instanceBilling, sCBillingSLA.instanceBilling)
                && Objects.equals(hourlyBilling, sCBillingSLA.hourlyBilling)
                && Objects.equals(slaDowntime, sCBillingSLA.slaDowntime)
                && Objects.equals(slaViolationFee, sCBillingSLA.slaViolationFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingModel, subscriptionBilling, instanceBilling, hourlyBilling, slaDowntime,
                slaViolationFee);
    }

    @Override
    public String toString() {
        return "{" +
                " billingModel='" + getBillingModel() + "'" +
                ", subscriptionBilling='" + getSubscriptionBilling() + "'" +
                ", instanceBilling='" + getInstanceBilling() + "'" +
                ", hourlyBilling='" + getHourlyBilling() + "'" +
                ", slaDowntime='" + getSlaDowntime() + "'" +
                ", slaViolationFee='" + getSlaViolationFee() + "'" +
                "}";
    }

}
