package training.my.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAgeValidator implements ConstraintValidator<CheckAge, Integer> {

    @Override
    public void initialize(final CheckAge valid) {
    }

    @Override
    public boolean isValid(final Integer age, final ConstraintValidatorContext context) {
        return !(age < 21);
    }
}