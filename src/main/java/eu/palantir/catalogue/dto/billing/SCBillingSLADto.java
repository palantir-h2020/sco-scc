package eu.palantir.catalogue.dto.billing;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import eu.palantir.catalogue.model.billing.BillingModelType;
import eu.palantir.catalogue.validation.BillingModel;
import io.smallrye.common.constraint.NotNull;

@BillingModel
public class SCBillingSLADto {

    @NotEmpty
    protected final List<BillingModelType> billingModel;

    protected final Float subscriptionBilling;

    protected final Float instanceBilling;

    protected final Float hourlyBilling;

    @NotNull
    @NotBlank
    protected final Integer slaDowntime; // Measured in minutes

    @NotNull
    @NotBlank
    protected final Float slaViolationFee;

    public SCBillingSLADto(List<BillingModelType> billingModel, Float subscriptionBilling, Float instanceBilling,
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

    public Float getSubscriptionBilling() {
        return this.subscriptionBilling;
    }

    public Float getInstanceBilling() {
        return this.instanceBilling;
    }

    public Float getHourlyBilling() {
        return this.hourlyBilling;
    }

    public Integer getSlaDowntime() {
        return this.slaDowntime;
    }

    public Float getSlaViolationFee() {
        return this.slaViolationFee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCBillingSLADto)) {
            return false;
        }
        SCBillingSLADto sCBillingSLA = (SCBillingSLADto) o;
        return Objects.equals(billingModel, sCBillingSLA.billingModel)
                && subscriptionBilling == sCBillingSLA.subscriptionBilling
                && instanceBilling == sCBillingSLA.instanceBilling && hourlyBilling == sCBillingSLA.hourlyBilling
                && Objects.equals(slaDowntime, sCBillingSLA.slaDowntime)
                && slaViolationFee == sCBillingSLA.slaViolationFee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingModel, subscriptionBilling, instanceBilling, hourlyBilling, slaDowntime,
                slaViolationFee);
    }

}
