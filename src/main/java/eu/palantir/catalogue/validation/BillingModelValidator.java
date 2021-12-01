package eu.palantir.catalogue.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.model.billing.BillingModelType;

public class BillingModelValidator implements ConstraintValidator<BillingModel, SCBillingSLADto> {

    @Override
    public boolean isValid(SCBillingSLADto value, ConstraintValidatorContext context) {
        final var validatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
        validatorContext.addExpressionVariable("billingModel", value.getBillingModel());
        validatorContext.addExpressionVariable("hourlyBilling", value.getHourlyBilling());
        validatorContext.addExpressionVariable("instanceBilling", value.getInstanceBilling());
        validatorContext.addExpressionVariable("subscriptionBilling", value.getSubscriptionBilling());

        for (BillingModelType billingType : value.getBillingModel()) {
            String billingTypeStr = billingType.toString();

            if (billingTypeStr.equals("hourly") && value.getHourlyBilling() == null) {
                return false;
            } else if (billingTypeStr.equals("instance") && value.getInstanceBilling() == null) {
                return false;
            } else if (billingTypeStr.equals("subscription") && value.getSubscriptionBilling() == null) {
                return false;
            }
        }

        return true;
    }

}
