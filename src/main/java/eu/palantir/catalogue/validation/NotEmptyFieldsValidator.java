package eu.palantir.catalogue.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyFieldsValidator implements ConstraintValidator<NotEmptyFields, List<String>> {

    @Override
    public void initialize(NotEmptyFields notEmptyFields) {
    }

    @Override
    public boolean isValid(List<String> objects, ConstraintValidatorContext context) {
        if (objects == null || objects.isEmpty())
            return false;
        return objects.stream().allMatch(elem -> elem != null && !elem.trim().isEmpty());
    }

}
