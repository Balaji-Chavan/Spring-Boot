package com.demo.custom_validation.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidator.class)
public @interface AgeValidate {
    public String message() default "Age must be between 18 to 26";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
