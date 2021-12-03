package eu.palantir.catalogue.dto.billing;

import java.util.List;
import java.util.Objects;

import eu.palantir.catalogue.dto.search.IntRangeDto;
import eu.palantir.catalogue.dto.search.FloatRangeDto;
import eu.palantir.catalogue.model.billing.BillingModelType;
import eu.palantir.catalogue.validation.BillingSearchModel;

@BillingSearchModel
public class SCBillingSLASearchDto {

    protected final List<BillingModelType> billingModel;

    protected final FloatRangeDto subscriptionBilling;

    protected final FloatRangeDto instanceBilling;

    protected final FloatRangeDto hourlyBilling;

    protected final IntRangeDto slaDowntime;

    protected final FloatRangeDto slaViolationFee;

    public SCBillingSLASearchDto(List<BillingModelType> billingModel, FloatRangeDto subscriptionBilling,
            FloatRangeDto instanceBilling, FloatRangeDto hourlyBilling, IntRangeDto slaDowntime,
            FloatRangeDto slaViolationFee) {
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

    public FloatRangeDto getSubscriptionBilling() {
        return this.subscriptionBilling;
    }

    public FloatRangeDto getInstanceBilling() {
        return this.instanceBilling;
    }

    public FloatRangeDto getHourlyBilling() {
        return this.hourlyBilling;
    }

    public IntRangeDto getSlaDowntime() {
        return this.slaDowntime;
    }

    public FloatRangeDto getSlaViolationFee() {
        return this.slaViolationFee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SCBillingSLASearchDto)) {
            return false;
        }
        SCBillingSLASearchDto sCBillingSLASearch = (SCBillingSLASearchDto) o;
        return Objects.equals(billingModel, sCBillingSLASearch.billingModel)
                && Objects.equals(subscriptionBilling, sCBillingSLASearch.subscriptionBilling)
                && Objects.equals(instanceBilling, sCBillingSLASearch.instanceBilling)
                && Objects.equals(hourlyBilling, sCBillingSLASearch.hourlyBilling)
                && Objects.equals(slaDowntime, sCBillingSLASearch.slaDowntime)
                && Objects.equals(slaViolationFee, sCBillingSLASearch.slaViolationFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingModel, subscriptionBilling, instanceBilling, hourlyBilling, slaDowntime,
                slaViolationFee);
    }

}
