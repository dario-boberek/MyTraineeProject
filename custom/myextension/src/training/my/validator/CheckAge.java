package training.my.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CheckAgeValidator.class})
@Documented

public @interface CheckAge {
    String message() default "{training.my.validator.CheckAge.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
