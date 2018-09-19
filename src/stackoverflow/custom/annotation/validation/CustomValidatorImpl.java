package stackoverflow.custom.annotation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatorImpl implements ConstraintValidator<CustomValidator, Integer> {
    int max, min;

    public CustomValidatorImpl() {}

    @Override
    public void initialize(CustomValidator customValidator) {
        max = customValidator.max();
        min = customValidator.min();
    }
    @Override
    public boolean isValid(Integer no, ConstraintValidatorContext constraintValidatorContext) {
        return no > min && no < max;
    }
}